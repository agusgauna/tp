package ar.com.ada.tp.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({ "id", "gender", "participant" })
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ParticipantGenderDto implements Serializable {

    private Long id;

    @NotBlank(message = "gender is required")
    private String gender;

    @JsonIgnoreProperties(value = "participantGender")
    private Set<ParticipantDto> participants;

    public ParticipantGenderDto setId(Long id) {
        this.id = id;
        return this;
    }

    public ParticipantGenderDto setGender(String gender) {
        this.gender = gender;
        return this;
    }
}
