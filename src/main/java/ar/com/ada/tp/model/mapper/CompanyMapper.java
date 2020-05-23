package ar.com.ada.tp.model.mapper;

import ar.com.ada.tp.model.dto.CompanyDto;
import ar.com.ada.tp.model.entity.Company;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends CycleDataMapper<CompanyDto, Company> {

    CompanyMapper MAPPER = Mappers.getMapper(CompanyMapper.class);
}
