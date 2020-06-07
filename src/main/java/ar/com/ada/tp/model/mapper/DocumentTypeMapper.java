package ar.com.ada.tp.model.mapper;

import ar.com.ada.tp.model.dto.DocumentTypeDto;
import ar.com.ada.tp.model.entity.DocumentType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface DocumentTypeMapper extends CycleDataMapper<DocumentTypeDto, DocumentType> {

    DocumentTypeMapper MAPPER = Mappers.getMapper(DocumentTypeMapper.class);
}
