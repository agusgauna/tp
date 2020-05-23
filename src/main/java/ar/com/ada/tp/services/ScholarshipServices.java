package ar.com.ada.tp.services;

import ar.com.ada.tp.model.dto.ScholarshipDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("scholarshipServices")
public class ScholarshipServices implements Services<ScholarshipDto> {
    @Override
    public List<ScholarshipDto> findAll() {
        return null;
    }

    @Override
    public ScholarshipDto save(ScholarshipDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
