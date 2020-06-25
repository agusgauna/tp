package ar.com.ada.tp.services;

import ar.com.ada.tp.component.BusinessLogicExceptionComponent;
import ar.com.ada.tp.model.dto.CourseDto;
import ar.com.ada.tp.model.entity.Category;
import ar.com.ada.tp.model.entity.Company;
import ar.com.ada.tp.model.entity.Course;
import ar.com.ada.tp.model.entity.CourseModality;
import ar.com.ada.tp.model.mapper.CourseMapper;
import ar.com.ada.tp.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.tp.model.repository.CategoryRepository;
import ar.com.ada.tp.model.repository.CompanyRepository;
import ar.com.ada.tp.model.repository.CourseModalityRepository;
import ar.com.ada.tp.model.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("courseServices")
public class CourseServices implements Services<CourseDto> {

    @Autowired
    @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired @Qualifier("courseRepository")
    private CourseRepository courseRepository;

    @Autowired @Qualifier("categoryRepository")
    private CategoryRepository categoryRepository;

    @Autowired @Qualifier("companyRepository")
    private CompanyRepository companyRepository;

    @Autowired @Qualifier("courseModalityRepository")
    private CourseModalityRepository courseModalityRepository;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    private CourseMapper courseMapper = CourseMapper.MAPPER;

    @Override
    public List<CourseDto> findAll() {
        List<Course> all = courseRepository.findAll();
        List<CourseDto> courseDtoList = courseMapper.toDto(all, context);

        return courseDtoList;
    }

    public CourseDto findCourseById(Long id) {
        Course byIdOptional = courseRepository.findById(id).orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("Course", id));
        CourseDto courseDto = courseMapper.toDto(byIdOptional, context);

        return courseDto;
    }

    @Override
    public CourseDto save(CourseDto dto) {
        Long categoryId = dto.getCategory().getId();
        Long companyId = dto.getCompany().getId();
        Long courseModalityId = dto.getCourseModality().getId();
        Category category;
        category = categoryRepository.findById(categoryId).orElseThrow(()-> logicExceptionComponent.throwExceptionEntityNotFound("Category", categoryId));
        Company company;
        company = companyRepository.findById(companyId).orElseThrow(()-> logicExceptionComponent.throwExceptionEntityNotFound("Company", companyId));
        CourseModality courseModality;
        courseModality = courseModalityRepository.findById(courseModalityId).orElseThrow(()-> logicExceptionComponent.throwExceptionEntityNotFound("CourseModality", courseModalityId));
        Course courseToSave = courseMapper.toEntity(dto, context);
        courseToSave.setCategory(category);
        courseToSave.setCompany(company);
        courseToSave.setCourseModality(courseModality);
        Course courseSaved = courseRepository.save(courseToSave);
        CourseDto courseDtoSaved = courseMapper.toDto(courseSaved, context);

        return courseDtoSaved;
    }

    public CourseDto updateCourse (CourseDto courseDtoToUpdate, Long id){
        Course byIdOptional = courseRepository.findById(id).orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("Course", id));
        courseDtoToUpdate.setId(byIdOptional.getId());
        Course courseToUpdate = courseMapper.toEntity(courseDtoToUpdate, context);
        Course courseUpdated = courseRepository.save(courseToUpdate);
        CourseDto courseDtoUpdated = courseMapper.toDto(courseUpdated, context);

        return courseDtoUpdated;
    }

    @Override
    public void delete(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("Course", id));
        courseRepository.delete(course);
    }

    public List<CourseDto> findCoursesWithQuota() {
        List<Course> all = courseRepository.findAll();
        List<Course> coursesWithQuote = all.stream()
                .filter(course -> course.getQuota() > 0)
                .collect(Collectors.toList());
        List<CourseDto> courseDtosWithQuote = courseMapper.toDto(coursesWithQuote, context);
        return courseDtosWithQuote;
    }

    public List<CourseDto> findCourseForCategory() {
        List<Course> all = courseRepository.findAll();
        List<Course> courseForCategory = all.stream()
                .filter(course -> course.getCategory().equals(course))
                .collect(Collectors.toList());
        List<CourseDto> courseDtosForCategory = courseMapper.toDto(courseForCategory, context);
        return courseDtosForCategory;
    }

    public List<CourseDto> findCourseForCompany() {
        List<Course> all = courseRepository.findAll();
        List<Course> courseForCompany = all.stream()
                .filter(course -> course.getCompany().equals(course))
                .collect(Collectors.toList());
        List<CourseDto> courseDtosForCompany = courseMapper.toDto(courseForCompany, context);
        return courseDtosForCompany;
    }

    public List<CourseDto> findCourseForCompanyAndCategory(){
        List<Course> all = courseRepository.findAll();
        List<Course> coursesForCompanyAndCategory = new ArrayList<>();
        for (Course course: all) {
            if (course.getCompany().equals(course) && course.getCategory().equals(course))
                coursesForCompanyAndCategory.add(course);
        }
        List<CourseDto> courseDtosForCompanyAndCategory = courseMapper.toDto(coursesForCompanyAndCategory, context);
        return courseDtosForCompanyAndCategory;
    }
}
