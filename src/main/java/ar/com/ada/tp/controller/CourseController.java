package ar.com.ada.tp.controller;

import ar.com.ada.tp.model.dto.CourseDto;
import ar.com.ada.tp.model.dto.CourseParticipantDto;
import ar.com.ada.tp.services.CourseParticipantServices;
import ar.com.ada.tp.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired @Qualifier("courseServices")
    private CourseServices courseServices;

    @Autowired @Qualifier("courseParticipantServices")
    private CourseParticipantServices courseParticipantServices;

    @GetMapping({"/quota","/quota/"})
    public ResponseEntity getCoursesWithQuota(){
        List<CourseDto> all = courseServices.findCoursesWithQuota();
        return ResponseEntity.ok(all);
    }

    @GetMapping({"/category","/category/"})
    public ResponseEntity getCoursesForCategory(){
        List<CourseDto> all = courseServices.findCourseForCategory();
        return ResponseEntity.ok(all);
    }

    @GetMapping({"/company","/company/"})
    public ResponseEntity getCoursesForCompany(){
        List<CourseDto> all = courseServices.findCourseForCompany();
        return ResponseEntity.ok(all);
    }

    @GetMapping({"/course/participant/active","/course/participant/active/"})
    public ResponseEntity getCoursesForParticipantActive(){
        List<CourseParticipantDto> all = courseParticipantServices.findCourseForParticipantActive();
        return ResponseEntity.ok(all);
    }

    @GetMapping({"/course/participant/finished","/course/participant/finished/"})
    public ResponseEntity getCoursesForParticipantFinished(){
        List<CourseParticipantDto> all = courseParticipantServices.findCourseForParticipantFinished();
        return ResponseEntity.ok(all);
    }

    @GetMapping({"/company/category","/company/category/"})
    public ResponseEntity getCoursesForCompanyAndCategory(){
        List<CourseDto> all = courseServices.findCourseForCompanyAndCategory();
        return ResponseEntity.ok(all);
    }

    @GetMapping({"","/"})
    public ResponseEntity getAllCourses() {
        List<CourseDto> all = courseServices.findAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping({"/{id}","/{id}/"})
    public ResponseEntity getCourseById(@PathVariable Long id){
        CourseDto courseById = courseServices.findCourseById(id);
        return ResponseEntity.ok(courseById);
    }

    @PostMapping({"","/"})
    public ResponseEntity addNewCourse (@Valid @RequestBody CourseDto courseDto) {
        CourseDto courseSaved = courseServices.save(courseDto);
        return ResponseEntity.ok(courseSaved);
    }

    @PutMapping({"/{id}","/{id}/"})
    public ResponseEntity updateCourseById(@Valid @RequestBody CourseDto courseDto, @PathVariable Long id){
        CourseDto courseUpdated = courseServices.updateCourse(courseDto, id);
        return ResponseEntity.ok(courseUpdated);
    }

    @DeleteMapping({"/{id}","/{id}/"})
    public ResponseEntity deleteCourse (@PathVariable Long id){
        courseServices.delete(id);
        return ResponseEntity.noContent().build();
    }
}
