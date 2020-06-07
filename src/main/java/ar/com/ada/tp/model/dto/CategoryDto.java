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
@JsonPropertyOrder({"id", "category", "company", "course"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CategoryDto implements Serializable {

    private Long id;

    @NotBlank(message = "category is required")
    private String category;

    @JsonIgnoreProperties(value = "category")
    private Set<CompanyDto> companies;

    @JsonIgnoreProperties(value = "category")
    private Set<CourseDto> courses;

    public CategoryDto setId(Long id) {
        this.id = id;
        return this;
    }

    public CategoryDto setCategory(String category) {
        this.category = category;
        return this;
    }
}
