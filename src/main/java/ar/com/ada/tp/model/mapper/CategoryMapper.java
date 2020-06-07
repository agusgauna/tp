package ar.com.ada.tp.model.mapper;

import ar.com.ada.tp.model.dto.CategoryDto;
import ar.com.ada.tp.model.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends CycleDataMapper<CategoryDto, Category> {

    CategoryMapper MAPPER = Mappers.getMapper(CategoryMapper.class);
}
