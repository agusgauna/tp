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
@Table(name = "Course_modality")
public class CourseModality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String modality;

    @OneToMany(mappedBy = "courseModality")
    private Set<Course> courses;

    public CourseModality setId(Long id) {
        this.id = id;
        return this;
    }

    public CourseModality setModality(String modality) {
        this.modality = modality;
        return this;
    }
}