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
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String category;

    @OneToMany(mappedBy = "category")
    private Set<Company> companies;

    @OneToMany(mappedBy = "category")
    private Set<Course> courses;

    public Category setId(Long id) {
        this.id = id;
        return this;
    }

    public Category setCategory(String category) {
        this.category = category;
        return this;
    }

    public Category setCompanies(Set<Company> companies) {
        this.companies = companies;
        return this;
    }
}
