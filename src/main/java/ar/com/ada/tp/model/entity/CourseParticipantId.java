package ar.com.ada.tp.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CourseParticipantId implements Serializable {

    @Column(name = "Course_id")
    private Long courseId;

    @Column(name = "Participant_id")
    private Long participantId;

    public CourseParticipantId setCourseId(Long courseId) {
        this.courseId = courseId;
        return this;
    }

    public CourseParticipantId setParticipantId(Long participantId) {
        this.participantId = participantId;
        return this;
    }
}
