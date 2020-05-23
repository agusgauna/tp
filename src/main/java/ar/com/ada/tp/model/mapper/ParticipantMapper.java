package ar.com.ada.tp.model.mapper;

import ar.com.ada.tp.model.dto.ParticipantDto;
import ar.com.ada.tp.model.entity.Participant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ParticipantMapper extends CycleDataMapper<ParticipantDto, Participant> {

    ParticipantMapper MAPPER = Mappers.getMapper(ParticipantMapper.class);
}
