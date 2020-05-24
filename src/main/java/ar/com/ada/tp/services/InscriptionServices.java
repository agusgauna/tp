package ar.com.ada.tp.services;

import ar.com.ada.tp.component.BusinessLogicExceptionComponent;
import ar.com.ada.tp.model.dto.InscriptionDto;
import ar.com.ada.tp.model.entity.Inscription;
import ar.com.ada.tp.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.tp.model.mapper.InscriptionMapper;
import ar.com.ada.tp.model.repository.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("inscriptionServices")
public class InscriptionServices implements Services<InscriptionDto>{

    @Autowired
    @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired @Qualifier("inscriptionRepository")
    private InscriptionRepository inscriptionRepository;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    private InscriptionMapper inscriptionMapper = InscriptionMapper.MAPPER;

    @Override
    public List<InscriptionDto> findAll() {
        List<Inscription> all = inscriptionRepository.findAll();
        List<InscriptionDto> inscriptionDtoList = inscriptionMapper.toDto(all, context);

        return inscriptionDtoList;
    }

    @Override
    public InscriptionDto save(InscriptionDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
