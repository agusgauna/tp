package ar.com.ada.tp.controller;

import ar.com.ada.tp.model.dto.CourseDto;
import ar.com.ada.tp.model.dto.CourseParticipantDto;
import ar.com.ada.tp.model.dto.ParticipantDto;
import ar.com.ada.tp.services.CourseParticipantServices;
import ar.com.ada.tp.services.CourseServices;
import ar.com.ada.tp.services.ParticipantServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/courseParticipants")
public class CourseParticipantController {

    @Autowired @Qualifier("courseServices")
    private CourseServices courseServices;

    @Autowired @Qualifier("participantServices")
    private ParticipantServices participantServices;

    @Autowired @Qualifier("courseParticipantServices")
    private CourseParticipantServices courseParticipantServices;

    @GetMapping({"","/"})
    public ResponseEntity getAllCourseParticipant() {
        List<CourseParticipantDto> all = courseParticipantServices.findAll();
        return ResponseEntity.ok(all);
    }

   @PostMapping({ "/courses", "/courses/" })
    public ResponseEntity addNewCourse(@Valid @RequestBody CourseDto courseDto) throws URISyntaxException {
        CourseDto courseDtoSaved = courseServices.save(courseDto);
        return ResponseEntity
                .created(new URI("/courses/" + courseDtoSaved.getId()))
                .body(courseDtoSaved);
    }

    @PostMapping({ "/participants", "/participants/" })
    public ResponseEntity addNewParticipant(@Valid @RequestBody ParticipantDto participantDto) throws URISyntaxException {
        ParticipantDto participantDtoSaved = participantServices.save(participantDto);
        return ResponseEntity
                .created(new URI("/participants/" + participantDtoSaved.getId()))
                .body(participantDtoSaved);
    }

    @PutMapping({ "/course/{courseId}/participant/{participantId}", "/course/{courseId}/participant/{participantId}/" })
    public ResponseEntity addNewRequest(
            @Valid @RequestBody CourseParticipantDto courseParticipantDto,
            @PathVariable Long courseId,
            @PathVariable Long participantId
    ) {
        CourseParticipantDto courseParticipantDtoSaved = courseParticipantServices.saveCourseParticipant(courseParticipantDto, courseId, participantId);
        return ResponseEntity
                .ok(courseParticipantDtoSaved);
    }
}
