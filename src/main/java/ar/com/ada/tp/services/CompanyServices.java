package ar.com.ada.tp.services;

import ar.com.ada.tp.model.dto.CompanyDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("companyServices")
public class CompanyServices implements Services<CompanyDto> {
    @Override
    public List<CompanyDto> findAll() {
        return null;
    }

    @Override
    public CompanyDto save(CompanyDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
