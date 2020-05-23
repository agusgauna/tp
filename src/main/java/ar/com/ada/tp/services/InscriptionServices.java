package ar.com.ada.tp.services;

import ar.com.ada.tp.model.dto.InscriptionDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("inscriptionServices")
public class InscriptionServices implements Services<InscriptionDto>{
    @Override
    public List<InscriptionDto> findAll() {
        return null;
    }

    @Override
    public InscriptionDto save(InscriptionDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
