package ar.com.ada.tp.services;

import ar.com.ada.tp.component.BusinessLogicExceptionComponent;
import ar.com.ada.tp.model.dto.ParticipantDto;
import ar.com.ada.tp.model.dto.ScholarshipDto;
import ar.com.ada.tp.model.entity.Participant;
import ar.com.ada.tp.model.entity.Scholarship;
import ar.com.ada.tp.model.mapper.CycleAvoidingMappingContext;
import ar.com.ada.tp.model.mapper.ScholarshipMapper;
import ar.com.ada.tp.model.repository.ScholarshipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("scholarshipServices")
public class ScholarshipServices implements Services<ScholarshipDto> {

    @Autowired
    @Qualifier("businessLogicExceptionComponent")
    private BusinessLogicExceptionComponent logicExceptionComponent;

    @Autowired @Qualifier("representativeRepository")
    private ScholarshipRepository scholarshipRepository;

    @Autowired @Qualifier("cycleAvoidingMappingContext")
    private CycleAvoidingMappingContext context;

    private ScholarshipMapper scholarshipMapper = ScholarshipMapper.MAPPER;

    @Override
    public List<ScholarshipDto> findAll() {
        List<Scholarship> all = scholarshipRepository.findAll();
        List<ScholarshipDto> scholarshipDtoList = scholarshipMapper.toDto(all, context);

        return scholarshipDtoList;
    }

    @Override
    public ScholarshipDto save(ScholarshipDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
