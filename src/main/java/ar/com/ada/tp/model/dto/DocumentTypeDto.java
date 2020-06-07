package ar.com.ada.tp.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({"id", "type", "representative"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class DocumentTypeDto implements Serializable {

    private Long id;

    @NotBlank(message = "type is required")
    private String type;

    @JsonIgnoreProperties(value = "documentType")
    private Set<RepresentativeDto> representatives;

    public DocumentTypeDto setId(Long id) {
        this.id = id;
        return this;
    }

    public DocumentTypeDto setType(String type) {
        this.type = type;
        return this;
    }
}
