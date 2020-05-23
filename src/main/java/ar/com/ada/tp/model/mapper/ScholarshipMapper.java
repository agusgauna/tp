package ar.com.ada.tp.model.mapper;

import ar.com.ada.tp.model.dto.ScholarshipDto;
import ar.com.ada.tp.model.entity.Scholarship;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ScholarshipMapper extends CycleDataMapper<ScholarshipDto, Scholarship> {

    ScholarshipMapper MAPPER = Mappers.getMapper(ScholarshipMapper.class);
}
