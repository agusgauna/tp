package ar.com.ada.tp.services;

import ar.com.ada.tp.model.dto.RepresentativeDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("representativeServices")
public class RepresentativeServices implements Services<RepresentativeDto>{
    @Override
    public List<RepresentativeDto> findAll() {
        return null;
    }

    @Override
    public RepresentativeDto save(RepresentativeDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
