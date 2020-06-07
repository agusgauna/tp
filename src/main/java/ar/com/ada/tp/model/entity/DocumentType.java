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
@Table(name = "Document_type")
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String type;

    @OneToMany(mappedBy = "documentType")
    private Set<Representative> representatives;

    public DocumentType setId(Long id) {
        this.id = id;
        return this;
    }

    public DocumentType setType(String type) {
        this.type = type;
        return this;
    }
}
