package ar.com.ada.tp.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Inscription")
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "Course_has_Inscription",
            joinColumns = @JoinColumn(name = "Inscription_id"),
            inverseJoinColumns = @JoinColumn(name = "Course_id"))
    private Set<Course> courses;

    @ManyToMany
    @JoinTable(name = "Participant_has_Inscription",
            joinColumns = @JoinColumn(name = "Inscription_id"),
            inverseJoinColumns = @JoinColumn(name = "Participant_id"))
    private Set<Participant> participants;

    public Inscription setId(Long id) {
        this.id = id;
        return this;
    }
}
