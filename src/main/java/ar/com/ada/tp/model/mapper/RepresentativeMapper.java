package ar.com.ada.tp.model.mapper;

import ar.com.ada.tp.model.dto.RepresentativeDto;
import ar.com.ada.tp.model.entity.Representative;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface RepresentativeMapper extends CycleDataMapper<RepresentativeDto, Representative>{

    RepresentativeMapper MAPPER = Mappers.getMapper(RepresentativeMapper.class);
}
