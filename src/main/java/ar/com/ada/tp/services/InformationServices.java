package ar.com.ada.tp.services;

import ar.com.ada.tp.component.BusinessLogicExceptionComponent;
import ar.com.ada.tp.model.dto.InformationDto;
import ar.com.ada.tp.model.entity.Information;
import ar.com.ada.tp.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.tp.model.mapper.InformationMapper;
import ar.com.ada.tp.model.repository.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("informationServices")
public class InformationServices implements Services<InformationDto> {

    @Autowired
    @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired @Qualifier("informationRepository")
    private InformationRepository informationRepository;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    private InformationMapper informationMapper = InformationMapper.MAPPER;

    @Override
    public List<InformationDto> findAll() {
        List<Information> all = informationRepository.findAll();
        List<InformationDto> informationDtoList = informationMapper.toDto(all, context);

        return informationDtoList;
    }

    @Override
    public InformationDto save(InformationDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
