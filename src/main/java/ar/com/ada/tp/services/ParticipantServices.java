package ar.com.ada.tp.services;

import ar.com.ada.tp.model.dto.ParticipantDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("participantServices")
public class ParticipantServices implements Services<ParticipantDto> {
    @Override
    public List<ParticipantDto> findAll() {
        return null;
    }

    @Override
    public ParticipantDto save(ParticipantDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
