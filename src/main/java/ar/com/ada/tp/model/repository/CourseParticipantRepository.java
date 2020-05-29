package ar.com.ada.tp.model.repository;

import ar.com.ada.tp.model.entity.CourseParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("courseParticipantRepository")
public interface CourseParticipantRepository extends JpaRepository<CourseParticipant, Long> {
}
