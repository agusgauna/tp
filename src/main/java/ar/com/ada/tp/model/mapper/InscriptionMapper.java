package ar.com.ada.tp.model.mapper;

import ar.com.ada.tp.model.dto.InscriptionDto;
import ar.com.ada.tp.model.entity.Inscription;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InscriptionMapper extends CycleDataMapper<InscriptionDto, Inscription>{

    InscriptionMapper MAPPER = Mappers.getMapper(InscriptionMapper.class);
}
