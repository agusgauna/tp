package ar.com.ada.tp.model.repository;

import ar.com.ada.tp.model.entity.Company;
import ar.com.ada.tp.model.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("courseRepository")
public interface CourseRepository extends JpaRepository<Course, Long> {


//    List<Course> findAllCompany(Company company);
}
