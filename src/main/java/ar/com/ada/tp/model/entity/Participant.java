package ar.com.ada.tp.model.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Participant")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false, columnDefinition = "DATETIME")
    private LocalDate birthday;

    @Column(nullable = false, length = 100)
    private String address;

    @OneToOne
    @JoinColumn(name = "Information_id", nullable = true)
    private Information information;

    @OneToMany(mappedBy = "participant")
    private Set<CourseParticipant> courseParticipants;

    @ManyToOne
    @JoinColumn(name = "Participant_gender_id", nullable = true)
    private ParticipantGender participantGender;

    public Participant setId(Long id) {
        this.id = id;
        return this;
    }

    public Participant setName(String name) {
        this.name = name;
        return this;
    }

    public Participant setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Participant setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public Participant setAddress(String address) {
        this.address = address;
        return this;
    }

    public Participant setInformation(Information information) {
        this.information = information;
        return this;
    }

    public Participant setCourseParticipants(Set<CourseParticipant> courseParticipants) {
        this.courseParticipants = courseParticipants;
        return this;
    }

    public Participant setParticipantGender(ParticipantGender participantGender) {
        this.participantGender = participantGender;
        return this;
    }
}
