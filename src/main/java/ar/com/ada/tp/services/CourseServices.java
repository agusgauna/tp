package ar.com.ada.tp.services;

import ar.com.ada.tp.model.dto.CourseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("courseServices")
public class CourseServices implements Services<CourseDto> {
    @Override
    public List<CourseDto> findAll() {
        return null;
    }

    @Override
    public CourseDto save(CourseDto dto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
