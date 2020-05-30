package ar.com.ada.tp.services;

import ar.com.ada.tp.component.BusinessLogicExceptionComponent;
import ar.com.ada.tp.model.dto.ParticipantDto;
import ar.com.ada.tp.model.entity.Course;
import ar.com.ada.tp.model.entity.Information;
import ar.com.ada.tp.model.entity.Participant;
import ar.com.ada.tp.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.tp.model.mapper.ParticipantMapper;
import ar.com.ada.tp.model.repository.CourseRepository;
import ar.com.ada.tp.model.repository.InformationRepository;
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

    @Autowired @Qualifier("informationRepository")
    private InformationRepository informationRepository;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    private ParticipantMapper participantMapper = ParticipantMapper.MAPPER;

    @Override
    public List<ParticipantDto> findAll() {
        List<Participant> all = participantRepository.findAll();
        List<ParticipantDto> participantDtoList = participantMapper.toDto(all, context);

        return participantDtoList;
    }

    public ParticipantDto findParticipantById(Long id) {
        Optional<Participant> byIdOptional = participantRepository.findById(id);
        ParticipantDto participantDto= null;

        if(byIdOptional.isPresent()) {
            Participant participantById = byIdOptional.get();
            participantDto = participantMapper.toDto(participantById, context);
        } else {
            logicExceptionComponent.throwExceptionEntityNotFound("Participant", id);
        }
        return participantDto;
    }

    @Override
    public ParticipantDto save(ParticipantDto dto) {
        Participant participant = participantMapper.toEntity(dto,context);
        Participant participantToSave = participantRepository.save(participant);
        ParticipantDto dtoSaved = participantMapper.toDto(participantToSave, context);

        return dtoSaved;
    }

    public ParticipantDto updateParticipant (ParticipantDto participantDtoToUpdate, Long id){
        Optional<Participant> byIdOptional = participantRepository.findById(id);
        ParticipantDto participantDtoUpdated = null;

        if(byIdOptional.isPresent()) {
            Participant participantById = byIdOptional.get();
            participantDtoToUpdate.setId(participantById.getId());
            Participant participantToUpdate = participantMapper.toEntity(participantDtoToUpdate, context);
            Participant participantUpdated = participantRepository.save(participantToUpdate);
            participantDtoUpdated = participantMapper.toDto(participantUpdated, context);

        } else {
            logicExceptionComponent.throwExceptionEntityNotFound("Participant", id);
        }
        return participantDtoUpdated;
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

    public ParticipantDto addInformationToParticipant(Long informationId, Long participantId) {
        Optional<Participant> participantByIdOptional = participantRepository.findById(participantId);
        Optional<Information> informationByIdOptional = informationRepository.findById(informationId);
        ParticipantDto participantDtoWithInformation = null;

        if (!participantByIdOptional.isPresent())
            logicExceptionComponent.throwExceptionEntityNotFound("Participant",participantId);
        if (!informationByIdOptional.isPresent())
            logicExceptionComponent.throwExceptionEntityNotFound("Information",informationId);

        Participant participant = participantByIdOptional.get();
        Information information = informationByIdOptional.get();

        participant.setInformation(information);
        Participant participantWithInformation = participantRepository.save(participant);
        participantDtoWithInformation = participantMapper.toDto(participantWithInformation, context);

        return participantDtoWithInformation;
    }
}
