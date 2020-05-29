package ar.com.ada.tp.controller;

import ar.com.ada.tp.model.dto.CourseDto;
import ar.com.ada.tp.services.CourseServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired @Qualifier("courseServices")
    private CourseServices courseServices;

    @GetMapping({"","/"})
    public ResponseEntity getCoursesWithQuota(){
        List<CourseDto> all = courseServices.findCoursesWithQuota();
        return ResponseEntity.ok(all);
    }

}
