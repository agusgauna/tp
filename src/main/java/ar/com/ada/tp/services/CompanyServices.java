package ar.com.ada.tp.services;

import ar.com.ada.tp.component.BusinessLogicExceptionComponent;
import ar.com.ada.tp.exception.ApiEntityError;
import ar.com.ada.tp.exception.BusinessLogicException;
import ar.com.ada.tp.model.dto.CompanyDto;
import ar.com.ada.tp.model.entity.Company;
import ar.com.ada.tp.model.entity.Course;
import ar.com.ada.tp.model.entity.Representative;
import ar.com.ada.tp.model.mapper.CompanyMapper;
import ar.com.ada.tp.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.tp.model.repository.CompanyRepository;
import ar.com.ada.tp.model.repository.CourseRepository;
import ar.com.ada.tp.model.repository.ParticipantRepository;
import ar.com.ada.tp.model.repository.RepresentativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("companyServices")
public class CompanyServices implements Services<CompanyDto> {

    @Autowired @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired @Qualifier("companyRepository")
    private CompanyRepository companyRepository;

    @Autowired @Qualifier("representativeRepository")
    private RepresentativeRepository representativeRepository;

    @Autowired @Qualifier("courseRepository")
    private CourseRepository courseRepository;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    private CompanyMapper companyMapper = CompanyMapper.MAPPER;

    @Override
    public List<CompanyDto> findAll() {
        List<Company> all = companyRepository.findAll();
        List<CompanyDto> companyDtoList = companyMapper.toDto(all, context);

        return companyDtoList;
    }

    public CompanyDto findCompanyById(Long id) {
        Optional<Company> byIdOptional = companyRepository.findById(id);
        CompanyDto companyDto= null;

        if(byIdOptional.isPresent()) {
            Company companyById = byIdOptional.get();
            companyDto = companyMapper.toDto(companyById, context);
        } else {
            logicExceptionComponent.throwExceptionEntityNotFound("Course", id);
        }
        return companyDto;
    }

    @Override
    public CompanyDto save(CompanyDto dto) {
        Company companyToSave = companyMapper.toEntity(dto, context);
        Company companySaved = companyRepository.save(companyToSave);
        CompanyDto companyDtoSaved = companyMapper.toDto(companySaved, context);

        return companyDtoSaved;
    }

    public CompanyDto updateCompany (CompanyDto companyDtoToUpdate, Long id){
        Optional<Company> byIdOptional = companyRepository.findById(id);
        CompanyDto companyDtoUpdated = null;

        if(byIdOptional.isPresent()) {
            Company companyById = byIdOptional.get();
            companyDtoToUpdate.setId(companyById.getId());
            Company companyToUpdate = companyMapper.toEntity(companyDtoToUpdate, context);
            Company companyUpdated = companyRepository.save(companyToUpdate);
            companyDtoUpdated = companyMapper.toDto(companyUpdated, context);

        } else {
            logicExceptionComponent.throwExceptionEntityNotFound("Company", id);
        }
        return companyDtoUpdated;
    }

    @Override
    public void delete(Long id) {
        Optional<Company> byIdOptional = companyRepository.findById(id);
        if (byIdOptional.isPresent()) {
            Company companyToDelete = byIdOptional.get();
            companyRepository.delete(companyToDelete);
        } else {
            logicExceptionComponent.throwExceptionEntityNotFound("Course", id);
        }
    }

    public CompanyDto addRepresentativeToCompany (Long representativeId, Long companyId) {
        Optional<Company> companyByIdOptional = companyRepository.findById(companyId);
        Optional<Representative> representativeByIdOptional = representativeRepository.findById(representativeId);
        CompanyDto companyDtoWithNewRepresentative = null;

        if (!companyByIdOptional.isPresent())
            logicExceptionComponent.throwExceptionEntityNotFound("Company",companyId);
        if (!representativeByIdOptional.isPresent())
            logicExceptionComponent.throwExceptionEntityNotFound("Representative",representativeId);

        Company company = companyByIdOptional.get();
        Representative representativeToSet = representativeByIdOptional.get();

        boolean hasRepresentativeInCompany = company.getRepresentatives()
                .stream()
                .anyMatch(representative -> representative.getName().equals(representativeToSet.getName()));

        if (!hasRepresentativeInCompany){
            company.addRepresentative(representativeToSet);
            Company companyWithNewRepresentative = companyRepository.save(company);
            companyDtoWithNewRepresentative = companyMapper.toDto(companyWithNewRepresentative, context);
        } else {
            ApiEntityError apiEntityError = new ApiEntityError(
                    "Representative",
                    "AlreadyExist",
                    "The representative with id " + representativeId + "already exist in the company"
            );
            throw new BusinessLogicException(
                    "Representative already exist in the company",
                    HttpStatus.BAD_REQUEST,
                    apiEntityError
            );
        }
        return companyDtoWithNewRepresentative;
    }

    public CompanyDto addCourseToCompany (Long courseId, Long companyId) {
        Optional<Company> companyByIdOptional = companyRepository.findById(companyId);
        Optional<Course> courseByIdOptional = courseRepository.findById(courseId);
        CompanyDto companyDtoWithNewCourse = null;

        if (!companyByIdOptional.isPresent())
            logicExceptionComponent.throwExceptionEntityNotFound("Company",companyId);
        if (!courseByIdOptional.isPresent())
            logicExceptionComponent.throwExceptionEntityNotFound("Course",courseId);

        Company company = companyByIdOptional.get();
        Course courseToSet = courseByIdOptional.get();

        boolean hasCourseInCompany = company.getCourses()
                .stream()
                .anyMatch(course -> course.getName().equals(courseToSet.getName()));

        if (!hasCourseInCompany){
            company.addCourse(courseToSet);
            Company companyWithNewCourse = companyRepository.save(company);
            companyDtoWithNewCourse = companyMapper.toDto(companyWithNewCourse, context);
        } else {
            ApiEntityError apiEntityError = new ApiEntityError(
                    "Course",
                    "AlreadyExist",
                    "The course with id " + courseId + "already exist in the company"
            );
            throw new BusinessLogicException(
                    "Company already exist in the company",
                    HttpStatus.BAD_REQUEST,
                    apiEntityError
            );
        }
        return companyDtoWithNewCourse;
    }
}
