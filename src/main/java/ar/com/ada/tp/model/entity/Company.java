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
@Entity(name = "Company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 11)
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
}
