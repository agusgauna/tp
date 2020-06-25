package ar.com.ada.tp.services;

import ar.com.ada.tp.component.BusinessLogicExceptionComponent;
import ar.com.ada.tp.model.dto.ParticipantDto;
import ar.com.ada.tp.model.entity.Course;
import ar.com.ada.tp.model.entity.Information;
import ar.com.ada.tp.model.entity.Participant;
import ar.com.ada.tp.model.entity.ParticipantGender;
import ar.com.ada.tp.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.tp.model.mapper.ParticipantMapper;
import ar.com.ada.tp.model.repository.CourseRepository;
import ar.com.ada.tp.model.repository.InformationRepository;
import ar.com.ada.tp.model.repository.ParticipantGenderRepository;
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

    @Autowired @Qualifier("participantGenderRepository")
    private ParticipantGenderRepository participantGenderRepository;

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
        Participant byIdOptional = participantRepository.findById(id).orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("Participant", id));
        ParticipantDto participantDto = participantMapper.toDto(byIdOptional, context);

        return participantDto;
    }

    @Override
    public ParticipantDto save(ParticipantDto dto) {
        Long participantGenderId = dto.getParticipantGender().getId();
        Long informationId = dto.getInformation().getId();
        ParticipantGender participantGender;
        participantGender = participantGenderRepository.findById(participantGenderId).orElseThrow(()-> logicExceptionComponent.throwExceptionEntityNotFound("ParticipantGender", participantGenderId));
        Information information;
        information = informationRepository.findById(informationId).orElseThrow(()->logicExceptionComponent.throwExceptionEntityNotFound("Information", informationId));
        Participant participantToSave = participantMapper.toEntity(dto,context);
        participantToSave.setParticipantGender(participantGender);
        participantToSave.setInformation(information);
        Participant participantSaved = participantRepository.save(participantToSave);
        ParticipantDto dtoSaved = participantMapper.toDto(participantSaved, context);

        return dtoSaved;
    }

    public ParticipantDto updateParticipant (ParticipantDto participantDtoToUpdate, Long id){
        Participant byIdOptional = participantRepository.findById(id).orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("Participant", id));
        participantDtoToUpdate.setId(byIdOptional.getId());
        Participant participantToUpdate = participantMapper.toEntity(participantDtoToUpdate, context);
        Participant participantUpdated = participantRepository.save(participantToUpdate);
        ParticipantDto participantDtoUpdated = participantMapper.toDto(participantUpdated, context);

        return participantDtoUpdated;
    }

    @Override
    public void delete(Long id) {
        Participant byIdOptional = participantRepository.findById(id).orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("Participant", id));
        participantRepository.delete(byIdOptional);
    }

    public ParticipantDto addInformationToParticipant(Long informationId, Long participantId) {
        Participant participant = participantRepository.findById(participantId).orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("Participant", participantId));
        Information information = informationRepository.findById(informationId).orElseThrow(() -> logicExceptionComponent.throwExceptionEntityNotFound("Information", informationId));
        ParticipantDto participantDtoWithInformation = null;
        participant.setInformation(information);
        Participant participantWithInformation = participantRepository.save(participant);
        participantDtoWithInformation = participantMapper.toDto(participantWithInformation, context);

        return participantDtoWithInformation;
    }
}
