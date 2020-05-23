package ar.com.ada.tp.model.repository;

import ar.com.ada.tp.model.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("participantRepository")
public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    Optional<Participant> findByNameAndLastName(String name, String lastName);
}
