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
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({"id", "modality", "course"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CourseModalityDto {

    private Long id;

    @NotBlank(message = "modality is required")
    private String modality;

    @JsonIgnoreProperties(value = "courseModality")
    private Set<CourseDto> courses;

    public CourseModalityDto setId(Long id) {
        this.id = id;
        return this;
    }

    public CourseModalityDto setModality(String modality) {
        this.modality = modality;
        return this;
    }
}
