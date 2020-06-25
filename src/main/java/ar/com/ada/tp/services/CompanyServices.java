package ar.com.ada.tp.services;

import ar.com.ada.tp.component.BusinessLogicExceptionComponent;
import ar.com.ada.tp.exception.ApiEntityError;
import ar.com.ada.tp.exception.BusinessLogicException;
import ar.com.ada.tp.model.dto.CompanyDto;
import ar.com.ada.tp.model.entity.*;
import ar.com.ada.tp.model.mapper.CompanyMapper;
import ar.com.ada.tp.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.tp.model.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service("companyServices")
public class CompanyServices implements Services<CompanyDto> {

    @Autowired @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired @Qualifier("companyRepository")
    private CompanyRepository companyRepository;

    @Autowired @Qualifier("companyTypeRepository")
    private CompanyTypeRepository companyTypeRepository;

    @Autowired @Qualifier("categoryRepository")
    private CategoryRepository categoryRepository;

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

    public CompanyDto findCompanyById(Long companyId) {
        Company companyByIdOptional = companyRepository.findById(companyId).orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("Company", companyId));
        CompanyDto companyDto = companyMapper.toDto(companyByIdOptional, context);

        return companyDto;
    }

    @Override
    public CompanyDto save(CompanyDto dto) {
        Long companyTypeId = dto.getCompanyType().getId();
        Long companyCategoryId = dto.getCategory().getId();
        CompanyType companyType;
        companyType = companyTypeRepository.findById(companyTypeId).orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("CompanyType", companyTypeId));
        Category category;
        category = categoryRepository.findById(companyCategoryId).orElseThrow(()-> logicExceptionComponent.throwExceptionEntityNotFound("Category", companyCategoryId));
        Company companyToSave = companyMapper.toEntity(dto, context);
        companyToSave.setCompanyType(companyType);
        companyToSave.setCategory(category);
        Company companySaved = companyRepository.save(companyToSave);
        CompanyDto companyDtoSaved = companyMapper.toDto(companySaved, context);

        return companyDtoSaved;
    }

    public CompanyDto updateCompany (CompanyDto companyDtoToUpdate, Long id){
        Company byIdOptional = companyRepository.findById(id).orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("Company", id));
        companyDtoToUpdate.setId(byIdOptional.getId());
        Company companyToUpdate = companyMapper.toEntity(companyDtoToUpdate, context);
        Company companyUpdated = companyRepository.save(companyToUpdate);
        CompanyDto companyDtoUpdated = companyMapper.toDto(companyUpdated, context);

        return companyDtoUpdated;
    }

    @Override
    public void delete(Long id) {
        Company company = companyRepository
                .findById(id)
                .orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("Company", id));

//
//        List<Course> allCompany = courseRepository.findAllCompany(company);
//
//        if (!allCompany.isEmpty()) {
//
//        }

        companyRepository.delete(company);
    }

    public CompanyDto addRepresentativeToCompany (Long representativeId, Long companyId) {
        Company companyToSet = companyRepository.findById(companyId).orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("Company", companyId));
        Representative representativeToSet = representativeRepository.findById(representativeId).orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("Representative", representativeId));
        CompanyDto companyDtoWithNewRepresentative = null;

        boolean hasRepresentativeInCompany = companyToSet.getRepresentatives()
                .stream()
                .anyMatch(representative -> representative.getName().equals(representativeToSet.getName()));

        if (!hasRepresentativeInCompany){
            companyToSet.addRepresentative(representativeToSet);
            Company companyWithNewRepresentative = companyRepository.save(companyToSet);
            companyDtoWithNewRepresentative = companyMapper.toDto(companyWithNewRepresentative, context);
        } else {
            throw logicExceptionComponent.throwExceptionEntityAlreadyExist("Representative", representativeId);
        }
           return companyDtoWithNewRepresentative;
    }

    public CompanyDto addCourseToCompany (Long courseId, Long companyId) {
        Company companyToSet = companyRepository.findById(companyId).orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("Company", companyId));
        Course courseToSet = courseRepository.findById(courseId).orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("Course", courseId));
        CompanyDto companyDtoWithNewCourse = null;

        boolean hasCourseInCompany = companyToSet.getCourses()
                .stream()
                .anyMatch(course -> course.getName().equals(courseToSet.getName()));

        if (!hasCourseInCompany){
            companyToSet.addCourse(courseToSet);
            Company companyWithNewCourse = companyRepository.save(companyToSet);
            companyDtoWithNewCourse = companyMapper.toDto(companyWithNewCourse, context);
        } else {
            throw logicExceptionComponent.throwExceptionEntityAlreadyExist("Course", courseId);
        }
        return companyDtoWithNewCourse;
    }
}
