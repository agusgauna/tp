package ar.com.ada.tp.services;

import ar.com.ada.tp.model.dto.CourseParticipantDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courseParticipantServices")
public class CourseParticipantServices implements Services<CourseParticipantDto> {

    @Override
    public List<CourseParticipantDto> findAll() {
        return null;
    }

    @Override
    public CourseParticipantDto save(CourseParticipantDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
