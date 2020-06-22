package ar.com.ada.tp.model.repository;

import ar.com.ada.tp.model.entity.CourseModality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("courseModalityRepository")
public interface CourseModalityRepository extends JpaRepository<CourseModality, Long> {

    @Modifying
    @Query(value = "ALTER TABLE CourseModality AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoincrementValue();
}
