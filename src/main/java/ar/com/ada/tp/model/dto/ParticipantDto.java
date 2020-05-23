package ar.com.ada.tp.model.dto;

import ar.com.ada.tp.model.entity.Course;
import ar.com.ada.tp.model.entity.Information;
import ar.com.ada.tp.model.entity.Inscription;
import ar.com.ada.tp.model.entity.Scholarship;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @NotBlank(message = "gender is required")
    private String gender;

    @NotBlank(message = "address is required")
    private String address;

    @JsonIgnoreProperties(value = "participants")
    private Information information;

    @JsonIgnoreProperties(value = "participants")
    private Set<Inscription> inscriptions;

    @JsonIgnoreProperties(value = "participants")
    private Set<Scholarship> scholarships;

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

    public ParticipantDto setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public ParticipantDto setAddress(String address) {
        this.address = address;
        return this;
    }
}