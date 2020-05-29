package ar.com.ada.tp.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String description;

    @Column(nullable = false, length = 100)
    private String modality;

    @Column(nullable = false, length = 50)
    private Integer cost;

    @Column(nullable = false, length = 100)
    private String category;

    @Column(nullable = false, length = 10)
    private Integer quota;

    @Column(nullable = false, length = 10)
    private Integer scholarship;

    @Column(nullable = false, length = 10)
    private Integer countInscription;

    @Column(nullable = false, length = 10)
    private Integer countQuota;

    @Column(nullable = false, length = 10)
    private Integer difference;

    @ManyToOne
    @JoinColumn(name = "Company_id", nullable = true)
    private Company company;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<CourseParticipant> courseParticipants;

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

    public Course setModality(String modality) {
        this.modality = modality;
        return this;
    }

    public Course setCost(Integer cost) {
        this.cost = cost;
        return this;
    }

    public Course setCategory(String category) {
        this.category = category;
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

    public Course setCountInscription(Integer countInscription) {
        this.countInscription = countInscription;
        return this;
    }

    public Course setCountQuota(Integer countQuota) {
        this.countQuota = countQuota;
        return this;
    }
}
