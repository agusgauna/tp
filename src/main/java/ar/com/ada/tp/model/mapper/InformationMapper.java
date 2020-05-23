package ar.com.ada.tp.model.mapper;

import ar.com.ada.tp.model.dto.InformationDto;
import ar.com.ada.tp.model.entity.Information;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InformationMapper extends CycleDataMapper<InformationDto, Information>{

    InformationMapper MAPPER = Mappers.getMapper(InformationMapper.class);
}
