package ar.com.ada.tp.services;

import ar.com.ada.tp.component.BusinessLogicExceptionComponent;
import ar.com.ada.tp.model.dto.RepresentativeDto;
import ar.com.ada.tp.model.entity.Company;
import ar.com.ada.tp.model.entity.DocumentType;
import ar.com.ada.tp.model.entity.Representative;
import ar.com.ada.tp.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.tp.model.mapper.RepresentativeMapper;
import ar.com.ada.tp.model.repository.CompanyRepository;
import ar.com.ada.tp.model.repository.DocumentTypeRepository;
import ar.com.ada.tp.model.repository.RepresentativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("representativeServices")
public class RepresentativeServices implements Services<RepresentativeDto>{

    @Autowired
    @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired @Qualifier ("documentTypeRepository")
    private DocumentTypeRepository documentTypeRepository;

    @Autowired @Qualifier("companyRepository")
    private CompanyRepository companyRepository;

    @Autowired @Qualifier("representativeRepository")
    private RepresentativeRepository representativeRepository;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    private RepresentativeMapper representativeMapper = RepresentativeMapper.MAPPER;

    @Override
    public List<RepresentativeDto> findAll() {
        List<Representative> all = representativeRepository.findAll();
        List<RepresentativeDto> representativeDtoList = representativeMapper.toDto(all, context);

        return representativeDtoList;
    }

    public RepresentativeDto findRepresentativeById(Long id) {
        Representative byIdOptional = representativeRepository.findById(id).orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("Representative", id));
        RepresentativeDto representativeDto = representativeMapper.toDto(byIdOptional, context);

        return representativeDto;
    }

    @Override
    public RepresentativeDto save(RepresentativeDto dto) {
        Long documentTypeId = dto.getDocumentType().getId();
        Long companyId = dto.getCompany().getId();
        DocumentType documentType;
        documentType = documentTypeRepository.findById(documentTypeId).orElseThrow(()->logicExceptionComponent.throwExceptionEntityNotFound("DocumentType", documentTypeId));
        Company company;
        company = companyRepository.findById(companyId).orElseThrow(()-> logicExceptionComponent.throwExceptionEntityNotFound("Company", companyId));
        Representative representativeToSave = representativeMapper.toEntity(dto, context);
        representativeToSave.setDocumentType(documentType);
        representativeToSave.setCompany(company);
        Representative representativeSaved = representativeRepository.save(representativeToSave);
        RepresentativeDto representativeDtoSaved = representativeMapper.toDto(representativeSaved, context);

        return representativeDtoSaved;
    }

    public RepresentativeDto updateRepresentative (RepresentativeDto representativeDtoToUpdate, Long id){
        Representative byIdOptional = representativeRepository.findById(id).orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("Representative", id));
        representativeDtoToUpdate.setId(byIdOptional.getId());
        Representative representativeToUpdate = representativeMapper.toEntity(representativeDtoToUpdate, context);
        Representative representativeUpdated = representativeRepository.save(representativeToUpdate);
        RepresentativeDto representativeDtoUpdated = representativeMapper.toDto(representativeUpdated, context);

        return representativeDtoUpdated;
    }

    @Override
    public void delete(Long id) {
        Representative byIdOptional = representativeRepository.findById(id).orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("Representative", id));
        representativeRepository.delete(byIdOptional);
    }
}
