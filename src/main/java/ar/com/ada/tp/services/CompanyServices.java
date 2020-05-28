package ar.com.ada.tp.services;

import ar.com.ada.tp.component.BusinessLogicExceptionComponent;
import ar.com.ada.tp.model.dto.CompanyDto;
import ar.com.ada.tp.model.entity.Company;
import ar.com.ada.tp.model.mapper.CompanyMapper;
import ar.com.ada.tp.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.tp.model.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("companyServices")
public class CompanyServices implements Services<CompanyDto> {

    @Autowired @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired @Qualifier("companyRepository")
    private CompanyRepository companyRepository;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    private CompanyMapper companyMapper = CompanyMapper.MAPPER;

    @Override
    public List<CompanyDto> findAll() {
        List<Company> all = companyRepository.findAll();
        List<CompanyDto> companyDtoList = companyMapper.toDto(all, context);

        return companyDtoList;
    }

    @Override
    public CompanyDto save(CompanyDto dto) {
        Company companyToSave = companyMapper.toEntity(dto, context);
        Company companySaved = companyRepository.save(companyToSave);
        CompanyDto companyDtoSaved = companyMapper.toDto(companySaved, context);

        return companyDtoSaved;
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
}
