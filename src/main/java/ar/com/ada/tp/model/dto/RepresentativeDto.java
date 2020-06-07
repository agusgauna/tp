package ar.com.ada.tp.model.dto;

import ar.com.ada.tp.model.entity.Company;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({ "id", "name", "last_name", "type_document", "document",
        "position", "email", "company" })
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class RepresentativeDto implements Serializable {
    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "lastName is required")
    private String lastName;

    @NotNull(message = "document is required")
    private Integer document;

    @NotBlank(message = "position is required")
    private String position;

    @JsonFormat(pattern = "email@email.com")
    @NotBlank(message = "email is required")
    private String email;

    @JsonIgnoreProperties(value = "representatives")
    private CompanyDto company;

    @JsonIgnoreProperties(value = "representatives")
    private DocumentTypeDto documentType;

    public RepresentativeDto setId(Long id) {
        this.id = id;
        return this;
    }

    public RepresentativeDto setName(String name) {
        this.name = name;
        return this;
    }

    public RepresentativeDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public RepresentativeDto setDocument(Integer document) {
        this.document = document;
        return this;
    }

    public RepresentativeDto setPosition(String position) {
        this.position = position;
        return this;
    }

    public RepresentativeDto setEmail(String email) {
        this.email = email;
        return this;
    }
}
