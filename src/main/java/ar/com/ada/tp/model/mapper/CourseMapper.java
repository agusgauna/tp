package ar.com.ada.tp.model.mapper;

import ar.com.ada.tp.model.dto.CourseDto;
import ar.com.ada.tp.model.entity.Course;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CourseMapper extends CycleDataMapper<CourseDto, Course> {

    CourseMapper MAPPER = Mappers.getMapper(CourseMapper.class);
}
