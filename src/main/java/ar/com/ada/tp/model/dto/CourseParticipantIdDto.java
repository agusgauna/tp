package ar.com.ada.tp.model.dto;

import ar.com.ada.tp.model.entity.CourseParticipantId;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({ "courseId", "participantId" })
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class CourseParticipantIdDto implements Serializable {

    @NotNull(message = "courseId is required")
    private Long courseId;

    @NotNull(message = "participantId is required")
    private Long participantId;

    public CourseParticipantIdDto setCourseId(Long courseId) {
        this.courseId = courseId;
        return this;
    }

    public CourseParticipantIdDto setParticipantId(Long participantId) {
        this.participantId = participantId;
        return this;
    }

}
