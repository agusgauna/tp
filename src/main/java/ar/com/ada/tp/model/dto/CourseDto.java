package ar.com.ada.tp.model.dto;

import ar.com.ada.tp.model.entity.Company;
import ar.com.ada.tp.model.entity.Inscription;
import ar.com.ada.tp.model.entity.Scholarship;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CourseDto implements Serializable {
    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "description is required")
    private String description;

    @NotBlank(message = "modality is required")
    private String modality;

    @NotNull(message = "cost is required")
    private Integer cost;

    @NotBlank(message = "category is required")
    private String category;

    @JsonIgnoreProperties(value = "courses")
    private Company company;

    @JsonIgnoreProperties(value = "courses")
    private Set<Inscription> inscriptions;

    @JsonIgnoreProperties(value = "courses")
    private Set<Scholarship> scholarships;

    public CourseDto setId(Long id) {
        this.id = id;
        return this;
    }

    public CourseDto setName(String name) {
        this.name = name;
        return this;
    }

    public CourseDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public CourseDto setModality(String modality) {
        this.modality = modality;
        return this;
    }

    public CourseDto setCost(Integer cost) {
        this.cost = cost;
        return this;
    }

    public CourseDto setCategory(String category) {
        this.category = category;
        return this;
    }
}
