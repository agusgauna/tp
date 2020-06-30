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
@Table(name = "CompanyType")
public class CompanyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String type;

    @OneToMany(mappedBy = "companyType")
    private Set<Company> companies;

    public CompanyType setId(Long id) {
        this.id = id;
        return this;
    }

    public CompanyType setType(String type) {
        this.type = type;
        return this;
    }
}
