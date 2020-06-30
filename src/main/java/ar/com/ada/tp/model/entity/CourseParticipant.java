package ar.com.ada.tp.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Course_has_Participant")
public class CourseParticipant {

    @EmbeddedId
    private CourseParticipantId id;

    @ManyToOne @MapsId("courseId")
    private Course course;

    @ManyToOne @MapsId("participantId")
    private Participant participant;

    @Column(nullable = false, length = 10)
    private String requestType;

    @Column
    private Boolean status;

    @Column
    private Integer percent;

    @Column
    private Boolean finished;

    public CourseParticipant setRequestType(String requestType) {
        this.requestType = requestType;
        return this;
    }

    public CourseParticipant setStatus(Boolean status) {
        this.status = status;
        return this;
    }

    public CourseParticipant setPercent(Integer percent) {
        this.percent = percent;
        return this;
    }

    public CourseParticipant setFinished(Boolean finished) {
        this.finished = finished;
        return this;
    }

    public CourseParticipant setId(CourseParticipantId id) {
        this.id = id;
        return this;
    }

    public CourseParticipant setCourse(Course course) {
        this.course = course;
        return this;
    }

    public CourseParticipant setParticipant(Participant participant) {
        this.participant = participant;
        return this;
    }
}
