package ar.com.ada.tp.model.repository;

import ar.com.ada.tp.model.entity.CourseParticipant;
import ar.com.ada.tp.model.entity.CourseParticipantId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("courseParticipantRepository")
public interface CourseParticipantRepository extends JpaRepository<CourseParticipant, CourseParticipantId> {

    @Modifying
    @Query(value = "ALTER TABLE CourseParticipant AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoincrementValue();
}
