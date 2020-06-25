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
@Table(name = "Information")
public class Information {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Boolean study;

    @Column(nullable = false)
    private Boolean work;

    @Column(nullable = false)
    private Boolean hasIncome;

    @Column(nullable = false, length = 10)
    private Integer howMuch;

    @Column(nullable = false)
    private Boolean inCharge;

    @Column(nullable = false, length = 10)
    private Integer howMany;

    @OneToOne(mappedBy = "information")
    private Participant participant;

    public Information setId(Long id) {
        this.id = id;
        return this;
    }

    public Information setStudy(Boolean study) {
        this.study = study;
        return this;
    }

    public Information setWork(Boolean work) {
        this.work = work;
        return this;
    }

    public Information setHasIncome(Boolean hasIncome) {
        this.hasIncome = hasIncome;
        return this;
    }

    public Information setHowMuch(Integer howMuch) {
        this.howMuch = howMuch;
        return this;
    }

    public Information setInCharge(Boolean inCharge) {
        this.inCharge = inCharge;
        return this;
    }

    public Information setHowMany(Integer howMany) {
        this.howMany = howMany;
        return this;
    }

    public Information setParticipant(Participant participant) {
        this.participant = participant;
        return this;
    }
}
