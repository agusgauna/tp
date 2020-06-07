package ar.com.ada.tp.model.mapper;

import ar.com.ada.tp.model.dto.CourseModalityDto;
import ar.com.ada.tp.model.entity.CourseModality;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CourseModalityMapper extends CycleDataMapper<CourseModalityDto, CourseModality>{

    CourseModalityMapper MAPPER = Mappers.getMapper(CourseModalityMapper.class);
}
