package ar.com.ada.tp.model.dto;

import ar.com.ada.tp.model.entity.Company;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class RepresentativeDto implements Serializable {
    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "lastName is required")
    private String lastName;

    @NotBlank(message = "typeDocument is required")
    private String typeDocument;

    @NotNull(message = "document is required")
    private Integer document;

    @NotBlank(message = "position is required")
    private String position;

    @JsonFormat(pattern = "email@email.com")
    @NotBlank(message = "email is required")
    private String email;

    @JsonIgnoreProperties(value = "representatives")
    private Company company;
}
