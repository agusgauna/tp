package ar.com.ada.tp.services;

import ar.com.ada.tp.model.dto.ParticipantDto;
import ar.com.ada.tp.model.entity.Participant;
import ar.com.ada.tp.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.tp.model.mapper.ParticipantMapper;
import ar.com.ada.tp.model.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("participantServices")
public class ParticipantServices implements Services<ParticipantDto> {

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
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
