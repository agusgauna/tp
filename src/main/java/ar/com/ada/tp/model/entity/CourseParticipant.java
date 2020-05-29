package ar.com.ada.tp.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "CourseParticipant")
public class CourseParticipant implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne @JoinColumn (name = "Course_id", nullable = true)
    private Course course;

    @ManyToOne @JoinColumn (name = "Participant_id", nullable = true)
    private Participant participant;

    @Column(nullable = false, length = 10)
    private String requestType;

    @Column
    private Boolean status;

    @Column(nullable = false, length = 2)
    private Integer percent;

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
}
