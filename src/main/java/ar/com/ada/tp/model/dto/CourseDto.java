package ar.com.ada.tp.model.dto;

import ar.com.ada.tp.model.entity.Category;
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
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({"id", "name", "description", "cost", "quota", "scholarship",
        "count_inscription", "count_quota", "difference", "company", "course_participant", "category", "course_modality"})
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CourseDto implements Serializable {
    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "description is required")
    private String description;

    @NotNull(message = "cost is required")
    private Integer cost;

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
    private CompanyDto company;

    @JsonIgnoreProperties({"course", "participant"})
    private Set<CourseParticipantDto> courseParticipants;

    @JsonIgnoreProperties(value = "courses")
    private Category category;

    @JsonIgnoreProperties(value = "courses")
    private CourseModalityDto courseModality;

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

    public CourseDto setCost(Integer cost) {
        this.cost = cost;
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
