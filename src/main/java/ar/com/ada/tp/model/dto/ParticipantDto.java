package ar.com.ada.tp.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@JsonPropertyOrder({ "id", "name", "last_name", "birthday", "address", "information", "course_participant", "participant_gender" })
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ParticipantDto implements Serializable {
    private Long id;

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "lastName is required")
    private String lastName;

    @NotNull(message = "birthday is required")
    @Past(message = "the birth must be past data")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @NotBlank(message = "address is required")
    private String address;

    @JsonIgnoreProperties(value = "participant")
    private InformationDto information;

    @JsonIgnoreProperties(value = "participant")
    private Set<CourseParticipantDto> courseParticipants;

    @JsonIgnoreProperties(value = "participants")
    private ParticipantGenderDto participantGender;

    public ParticipantDto setId(Long id) {
        this.id = id;
        return this;
    }

    public ParticipantDto setName(String name) {
        this.name = name;
        return this;
    }

    public ParticipantDto setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ParticipantDto setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public ParticipantDto setAddress(String address) {
        this.address = address;
        return this;
    }
}
