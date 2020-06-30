package ar.com.ada.tp.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ParticipantGender")
public class ParticipantGender {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String gender;

    @OneToMany(mappedBy = "participantGender")
    private Set<Participant> participants;

    public ParticipantGender setId(Long id) {
        this.id = id;
        return this;
    }

    public ParticipantGender setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public ParticipantGender setParticipants(Set<Participant> participants) {
        this.participants = participants;
        return this;
    }
}
