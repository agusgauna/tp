package ar.com.ada.tp.model.dto;

import ar.com.ada.tp.model.entity.Company;
import ar.com.ada.tp.model.entity.CourseParticipant;
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

    @NotNull(message = "quota is required")
    private Integer quota;

    @NotNull(message = "scholarship is required")
    private Integer scholarship;

    @NotNull(message = "countInscription is required")
    private Integer countInscription;

    @NotNull(message = "countQuota is required")
    private Integer countQuota;

    @NotNull(message = "difference is required")
    private Integer difference;

    @JsonIgnoreProperties(value = "courses")
    private Company company;

    @JsonIgnoreProperties(value = "course")
    private Set<CourseParticipant> courseParticipants;

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

    public CourseDto setQuota(Integer quota) {
        this.quota = quota;
        return this;
    }

    public CourseDto setScholarship(Integer scholarship) {
        this.scholarship = scholarship;
        return this;
    }

    public CourseDto setCountInscription(Integer countInscription) {
        this.countInscription = countInscription;
        return this;
    }

    public CourseDto setCountQuota(Integer countQuota) {
        this.countQuota = countQuota;
        return this;
    }

    public CourseDto setDifference(Integer difference) {
        this.difference = difference;
        return this;
    }
}
