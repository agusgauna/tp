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

import java.util.List;

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

    @Override
    public CourseDto save(CourseDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
