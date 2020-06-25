package ar.com.ada.tp.model.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Representative")
public class Representative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, length = 100)
    private String lastName;

    @Column(nullable = false, length = 8)
    private Integer document;

    @Column(nullable = false, length = 50)
    private String position;

    @Column(nullable = false, length = 100)
    private String email;

    @ManyToOne
    @JoinColumn(name = "Company_id", nullable = true)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "Document_type_id", nullable = true)
    private DocumentType documentType;

    public Representative setId(Long id) {
        this.id = id;
        return this;
    }

    public Representative setName(String name) {
        this.name = name;
        return this;
    }

    public Representative setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public Representative setDocument(Integer document) {
        this.document = document;
        return this;
    }

    public Representative setPosition(String position) {
        this.position = position;
        return this;
    }

    public Representative setEmail(String email) {
        this.email = email;
        return this;
    }

    public Representative setCompany(Company company) {
        this.company = company;
        return this;
    }

    public Representative setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
        return this;
    }
}
