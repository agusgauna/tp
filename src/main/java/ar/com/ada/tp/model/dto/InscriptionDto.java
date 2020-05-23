package ar.com.ada.tp.model.dto;

import ar.com.ada.tp.model.entity.Course;
import ar.com.ada.tp.model.entity.Participant;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class InscriptionDto implements Serializable {
    private Long id;

    @JsonIgnoreProperties(value = "inscriptions")
    private Set<Course> courses;

    @JsonIgnoreProperties(value = "inscriptions")
    private Set<Participant> participants;
}
