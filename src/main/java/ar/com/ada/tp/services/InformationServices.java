package ar.com.ada.tp.services;

import ar.com.ada.tp.component.BusinessLogicExceptionComponent;
import ar.com.ada.tp.model.dto.InformationDto;
import ar.com.ada.tp.model.entity.Information;
import ar.com.ada.tp.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.tp.model.mapper.InformationMapper;
import ar.com.ada.tp.model.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("informationServices")
public class InformationServices implements Services<InformationDto> {

    @Autowired
    @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired @Qualifier("informationRepository")
    private InformationRepository informationRepository;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    private InformationMapper informationMapper = InformationMapper.MAPPER;

    @Override
    public List<InformationDto> findAll() {
        List<Information> all = informationRepository.findAll();
        List<InformationDto> informationDtoList = informationMapper.toDto(all, context);

        return informationDtoList;
    }

    public InformationDto findInformationById(Long id) {
        Optional<Information> byIdOptional = informationRepository.findById(id);
        InformationDto informationDto = null;

        if(byIdOptional.isPresent()) {
            Information informationById = byIdOptional.get();
            informationDto = informationMapper.toDto(informationById, context);
        } else {
            logicExceptionComponent.throwExceptionEntityNotFound("Information", id);
        }
        return informationDto;
    }

    @Override
    public InformationDto save(InformationDto dto) {
        Information informationToSave = informationMapper.toEntity(dto, context);
        Information informationSaved = informationRepository.save(informationToSave);
        InformationDto informationDtoSaved = informationMapper.toDto(informationSaved, context);

        return informationDtoSaved;
    }

    public InformationDto updateInformation (InformationDto informationDtoToUpdate, Long id){
        Optional<Information> byIdOptional = informationRepository.findById(id);
        InformationDto informationDtoUpdated = null;

        if(byIdOptional.isPresent()) {
            Information informationById = byIdOptional.get();
            informationDtoToUpdate.setId(informationById.getId());
            Information informationToUpdate = informationMapper.toEntity(informationDtoToUpdate, context);
            Information informationUpdated = informationRepository.save(informationToUpdate);
            informationDtoUpdated = informationMapper.toDto(informationUpdated, context);

        } else {
            logicExceptionComponent.throwExceptionEntityNotFound("Information", id);
        }
        return informationDtoUpdated;
    }

    @Override
    public void delete(Long id) {
        Optional<Information> byIdOptional = informationRepository.findById(id);
        if (byIdOptional.isPresent()){
            Information informationToDelete = byIdOptional.get();
            informationRepository.delete(informationToDelete);
        } else {
            logicExceptionComponent.throwExceptionEntityNotFound("Information", id);
        }
    }
}
