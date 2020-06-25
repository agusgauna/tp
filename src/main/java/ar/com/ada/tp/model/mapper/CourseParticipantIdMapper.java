package ar.com.ada.tp.model.mapper;

import ar.com.ada.tp.model.dto.CourseParticipantIdDto;
import ar.com.ada.tp.model.entity.CourseParticipantId;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CourseParticipantIdMapper extends CycleDataMapper<CourseParticipantIdDto, CourseParticipantId> {

    CourseParticipantIdMapper MAPPER = Mappers.getMapper(CourseParticipantIdMapper.class);
}
