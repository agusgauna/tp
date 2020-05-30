package ar.com.ada.tp.services;

import ar.com.ada.tp.component.BusinessLogicExceptionComponent;
import ar.com.ada.tp.model.dto.CourseDto;
import ar.com.ada.tp.model.entity.Course;
import ar.com.ada.tp.model.mapper.CourseMapper;
import ar.com.ada.tp.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.tp.model.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service("courseServices")
public class CourseServices implements Services<CourseDto> {

    @Autowired
    @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired @Qualifier("courseRepository")
    private CourseRepository courseRepository;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    private CourseMapper courseMapper = CourseMapper.MAPPER;

    @Override
    public List<CourseDto> findAll() {
        List<Course> all = courseRepository.findAll();
        List<CourseDto> courseDtoList = courseMapper.toDto(all, context);

        return courseDtoList;
    }



    public List<CourseDto> findCoursesWithQuota() {

        List<Course> all = courseRepository.findAll();
        List<Course> coursesWothQuote = all.stream()
                .filter(course -> course.getQuota() > 0)
                .collect(Collectors.toList());

        List<Course> coursesWothQuoteTwo = new ArrayList<>();
        for (Course course: all) {
            if (course.getQuota() > 0)
                coursesWothQuoteTwo.add(course);
        }
        List<CourseDto> courseDtosWithQuote = courseMapper.toDto(coursesWothQuote, context);
        return courseDtosWithQuote;
    }

    @Override
    public CourseDto save(CourseDto dto) {
        Course courseToSave = courseMapper.toEntity(dto, context);
        Course courseSaved = courseRepository.save(courseToSave);
        CourseDto courseDtoSaved = courseMapper.toDto(courseSaved, context);

        return courseDtoSaved;
    }

    @Override
    public void delete(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
        courseRepository.delete(course);
    }
}
