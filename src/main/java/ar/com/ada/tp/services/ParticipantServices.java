package ar.com.ada.tp.services;

import ar.com.ada.tp.component.BusinessLogicExceptionComponent;
import ar.com.ada.tp.model.dto.ParticipantDto;
import ar.com.ada.tp.model.entity.Participant;
import ar.com.ada.tp.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.tp.model.mapper.ParticipantMapper;
import ar.com.ada.tp.model.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("participantServices")
public class ParticipantServices implements Services<ParticipantDto> {

    @Autowired @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired @Qualifier("participantRepository")
    private ParticipantRepository participantRepository;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    private ParticipantMapper participantMapper = ParticipantMapper.MAPPER;

    @Override
    public List<ParticipantDto> findAll() {
        List<Participant> all = participantRepository.findAll();
        List<ParticipantDto> participantDtoList = participantMapper.toDto(all, context);

        return participantDtoList;
    }

    @Override
    public ParticipantDto save(ParticipantDto dto) {
        Participant participant = participantMapper.toEntity(dto,context);
        Participant participantToSave = participantRepository.save(participant);
        ParticipantDto dtoSaved = participantMapper.toDto(participantToSave, context);

        return dtoSaved;
    }

    @Override
    public void delete(Long id) {
        Optional<Participant> byIdOptional = participantRepository.findById(id);
        if (byIdOptional.isPresent()){
            Participant filmToDelete = byIdOptional.get();
            participantRepository.delete(filmToDelete);
        }  else {
            logicExceptionComponent.throwExceptionEntityNotFound("Participant", id);
        }

    }
}
