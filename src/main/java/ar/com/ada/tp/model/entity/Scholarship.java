package ar.com.ada.tp.model.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Scholarship")
public class Scholarship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "Course_has_Scholarship",
            joinColumns = @JoinColumn(name = "Scholarship_id"),
            inverseJoinColumns = @JoinColumn(name = "Course_id"))
    private Set<Course> courses;

    @ManyToMany
    @JoinTable(name = "Participant_has_Scholarship",
            joinColumns = @JoinColumn(name = "Scholarship_id"),
            inverseJoinColumns = @JoinColumn(name = "Participant_id"))
    private Set<Participant> participants;

    public Scholarship setId(Long id) {
        this.id = id;
        return this;
    }
}
