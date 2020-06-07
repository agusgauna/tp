package ar.com.ada.tp.model.mapper;

import ar.com.ada.tp.model.dto.ParticipantGenderDto;
import ar.com.ada.tp.model.entity.ParticipantGender;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ParticipantGenderMapper extends CycleDataMapper<ParticipantGenderDto, ParticipantGender> {

    ParticipantGenderMapper MAPPER = Mappers.getMapper(ParticipantGenderMapper.class);
}
