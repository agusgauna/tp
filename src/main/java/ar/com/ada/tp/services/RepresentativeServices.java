package ar.com.ada.tp.services;

import ar.com.ada.tp.component.BusinessLogicExceptionComponent;
import ar.com.ada.tp.model.dto.RepresentativeDto;
import ar.com.ada.tp.model.entity.Representative;
import ar.com.ada.tp.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.tp.model.mapper.RepresentativeMapper;
import ar.com.ada.tp.model.repository.RepresentativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("representativeServices")
public class RepresentativeServices implements Services<RepresentativeDto>{

    @Autowired
    @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired @Qualifier("representativeRepository")
    private RepresentativeRepository representativeRepository;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    private RepresentativeMapper representativeMapper = RepresentativeMapper.MAPPER;

    @Override
    public List<RepresentativeDto> findAll() {
        List<Representative> all = representativeRepository.findAll();
        List<RepresentativeDto> representativeDtoList = representativeMapper.toDto(all, context);

        return representativeDtoList;
    }

    @Override
    public RepresentativeDto save(RepresentativeDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
