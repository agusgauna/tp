package ar.com.ada.tp.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 50)
    private Integer cuil;

    @Column(nullable = false, length = 50)
    private String type;

    @Column(nullable = false, length = 100)
    private String address;

    @Column(nullable = false, length = 50)
    private String category;

    @Column(nullable = false, columnDefinition = "DATETIME")
    private Date year;

    @Column(nullable = false, length = 50)
    private Integer telephone;

    @OneToMany(mappedBy = "company")
    private Set<Representative> representatives;

    @OneToMany(mappedBy = "company")
    private Set<Course> courses;

    public Company(Long id) {
        this.id = id;
    }

    public Company(String name, Integer cuil, String type, String address, String category, Date year, Integer telephone) {
        this.name = name;
        this.cuil = cuil;
        this.type = type;
        this.address = address;
        this.category = category;
        this.year = year;
        this.telephone = telephone;
    }

    public Company setId(Long id) {
        this.id = id;
        return this;
    }

    public Company setName(String name) {
        this.name = name;
        return this;
    }

    public Company setCuil(Integer cuil) {
        this.cuil = cuil;
        return this;
    }

    public Company setType(String type) {
        this.type = type;
        return this;
    }

    public Company setAddress(String address) {
        this.address = address;
        return this;
    }

    public Company setCategory(String category) {
        this.category = category;
        return this;
    }

    public Company setYear(Date year) {
        this.year = year;
        return this;
    }

    public Company setTelephone(Integer telephone) {
        this.telephone = telephone;
        return this;
    }

    public void addRepresentative(Representative representative){
        this.representatives.add(representative);
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }
}
