package ar.com.ada.tp.model.mapper;

import ar.com.ada.tp.model.dto.CompanyTypeDto;
import ar.com.ada.tp.model.entity.CompanyType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompanyTypeMapper extends CycleDataMapper<CompanyTypeDto, CompanyType>{

    CompanyTypeMapper MAPPER = Mappers.getMapper(CompanyTypeMapper.class);
}
