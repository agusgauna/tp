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
        Representative byIdOptional = representativeRepository.findById(id).orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("Representative", id));
        RepresentativeDto representativeDto = representativeMapper.toDto(byIdOptional, context);

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
