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
@JsonPropertyOrder({ "course", "participant", "request_type", "status", "percent", "finished" })
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CourseParticipantDto implements Serializable {

    private CourseDto course;

    private ParticipantDto participant;

    private String requestType;

    private Boolean status;

    private Integer percent;

    private Boolean finished;

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

    public CourseParticipantDto setFinished(Boolean finished) {
        this.finished = finished;
        return this;
    }
}
