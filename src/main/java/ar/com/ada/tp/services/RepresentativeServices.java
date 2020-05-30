package ar.com.ada.tp.services;

import ar.com.ada.tp.component.BusinessLogicExceptionComponent;
import ar.com.ada.tp.model.dto.RepresentativeDto;
import ar.com.ada.tp.model.entity.Representative;
import ar.com.ada.tp.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.tp.model.mapper.RepresentativeMapper;
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
        Optional<Representative> byIdOptional = representativeRepository.findById(id);
        RepresentativeDto representativeDto = null;

        if(byIdOptional.isPresent()) {
            Representative representativeById = byIdOptional.get();
            representativeDto = representativeMapper.toDto(representativeById, context);
        } else {
            logicExceptionComponent.throwExceptionEntityNotFound("Representative", id);
        }
        return representativeDto;
    }

    @Override
    public RepresentativeDto save(RepresentativeDto dto) {
        Representative representativeToSave = representativeMapper.toEntity(dto, context);
        Representative representativeSaved = representativeRepository.save(representativeToSave);
        RepresentativeDto representativeDtoSaved = representativeMapper.toDto(representativeSaved, context);

        return representativeDtoSaved;
    }

    public RepresentativeDto updateRepresentative (RepresentativeDto representativeDtoToUpdate, Long id){
        Optional<Representative> byIdOptional = representativeRepository.findById(id);
        RepresentativeDto representativeDtoUpdated = null;

        if(byIdOptional.isPresent()) {
            Representative representativeById = byIdOptional.get();
            representativeDtoToUpdate.setId(representativeById.getId());
            Representative representativeToUpdate = representativeMapper.toEntity(representativeDtoToUpdate, context);
            Representative representativeUpdated = representativeRepository.save(representativeToUpdate);
            representativeDtoUpdated = representativeMapper.toDto(representativeUpdated, context);

        } else {
            logicExceptionComponent.throwExceptionEntityNotFound("Representative", id);
        }
        return representativeDtoUpdated;
    }

    @Override
    public void delete(Long id) {
        Optional<Representative> byIdOptional = representativeRepository.findById(id);
        if (byIdOptional.isPresent()) {
            Representative representativeToDelete = byIdOptional.get();
            representativeRepository.delete(representativeToDelete);
        } else {
            logicExceptionComponent.throwExceptionEntityNotFound("Representative", id);
        }

    }
}
