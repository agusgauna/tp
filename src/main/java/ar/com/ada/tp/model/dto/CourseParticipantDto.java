package ar.com.ada.tp.model.dto;

import ar.com.ada.tp.model.entity.Course;
import ar.com.ada.tp.model.entity.Participant;
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
@JsonPropertyOrder({ "course", "participant", "requestType", "status", "percent" })
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CourseParticipantDto implements Serializable {

    private CourseDto course;

    private ParticipantDto participant;

    @NotBlank(message = "requestType is required")
    private String requestType;

    @NotNull(message = "status is required")
    private Boolean status;

    @NotNull(message = "percent is required")
    private Integer percent;

    public CourseParticipantDto setRequestType(String requestType) {
        this.requestType = requestType;
        return this;
    }

    public CourseParticipantDto setStatus(Boolean status) {
        this.status = status;
        return this;
    }

    public CourseParticipantDto setPercent(Integer percent) {
        this.percent = percent;
        return this;
    }
}