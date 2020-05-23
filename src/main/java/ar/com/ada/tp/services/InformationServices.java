package ar.com.ada.tp.services;

import ar.com.ada.tp.model.dto.InformationDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("informationServices")
public class InformationServices implements Services<InformationDto> {
    @Override
    public List<InformationDto> findAll() {
        return null;
    }

    @Override
    public InformationDto save(InformationDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
