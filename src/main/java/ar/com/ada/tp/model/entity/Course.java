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
@Table(name = "Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String description;

    @Column(nullable = false)
    private Integer cost;

    @Column(nullable = false)
    private Integer quota;

    @Column(nullable = false)
    private Integer scholarship;

    @Column
    private Integer countQuota;

    @ManyToOne
    @JoinColumn(name = "Company_id", nullable = true)
    private Company company;

    @OneToMany(mappedBy = "course")
    private Set<CourseParticipant> courseParticipants;

    @ManyToOne
    @JoinColumn(name = "Category_id", nullable = true)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "Course_modality_id", nullable = true)
    private CourseModality courseModality;

    public Course setId(Long id) {
        this.id = id;
        return this;
    }

    public Course setName(String name) {
        this.name = name;
        return this;
    }

    public Course setDescription(String description) {
        this.description = description;
        return this;
    }

    public Course setCost(Integer cost) {
        this.cost = cost;
        return this;
    }

    public Course setQuota(Integer quota) {
        this.quota = quota;
        return this;
    }

    public Course setScholarship(Integer scholarship) {
        this.scholarship = scholarship;
        return this;
    }

    public Course setCountQuota(Integer countQuota) {
        this.countQuota = countQuota;
        return this;
    }

    public Course setCompany(Company company) {
        this.company = company;
        return this;
    }

    public Course setCourseParticipants(Set<CourseParticipant> courseParticipants) {
        this.courseParticipants = courseParticipants;
        return this;
    }

    public Course setCategory(Category category) {
        this.category = category;
        return this;
    }

    public Course setCourseModality(CourseModality courseModality) {
        this.courseModality = courseModality;
        return this;
    }
}
