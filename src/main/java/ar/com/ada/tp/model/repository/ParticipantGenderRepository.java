package ar.com.ada.tp.model.repository;

import ar.com.ada.tp.model.entity.ParticipantGender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("participantGenderRepository")
public interface ParticipantGenderRepository extends JpaRepository<ParticipantGender, Long> {
}
