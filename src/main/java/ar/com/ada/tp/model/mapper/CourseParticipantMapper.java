package ar.com.ada.tp.model.mapper;

import ar.com.ada.tp.model.dto.CourseParticipantDto;
import ar.com.ada.tp.model.entity.CourseParticipant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CourseParticipantMapper extends CycleDataMapper<CourseParticipantDto, CourseParticipant> {

    CourseParticipantMapper MAPPER = Mappers.getMapper(CourseParticipantMapper.class);
}
