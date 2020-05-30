package ar.com.ada.tp.model.dto;

import ar.com.ada.tp.model.entity.Participant;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({ "id", "study", "work", "has_income", "how_much",
        "in_charge", "how_many", "participant" })
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
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
    private ParticipantDto participant;

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
