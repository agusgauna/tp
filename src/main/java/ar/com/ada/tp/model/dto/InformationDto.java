package ar.com.ada.tp.model.dto;

import ar.com.ada.tp.model.entity.Participant;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class InformationDto implements Serializable {
    private Long id;

    @NotNull(message = "study is required")
    private Boolean study;

    @NotNull(message = "work is required")
    private Boolean work;

    @NotNull(message = "hasIncome is required")
    private Boolean hasIncome;

    @NotNull(message = "howMuch is required")
    private Integer howMuch;

    @NotNull(message = "inCharge is required")
    private Boolean inCharge;

    @NotNull(message = "howMany is required")
    private Integer howMany;

    @JsonIgnoreProperties(value = "information")
    private Set<Participant> participants;

    public InformationDto setId(Long id) {
        this.id = id;
        return this;
    }

    public InformationDto setStudy(Boolean study) {
        this.study = study;
        return this;
    }

    public InformationDto setWork(Boolean work) {
        this.work = work;
        return this;
    }

    public InformationDto setHasIncome(Boolean hasIncome) {
        this.hasIncome = hasIncome;
        return this;
    }

    public InformationDto setHowMuch(Integer howMuch) {
        this.howMuch = howMuch;
        return this;
    }

    public InformationDto setInCharge(Boolean inCharge) {
        this.inCharge = inCharge;
        return this;
    }

    public InformationDto setHowMany(Integer howMany) {
        this.howMany = howMany;
        return this;
    }
}
