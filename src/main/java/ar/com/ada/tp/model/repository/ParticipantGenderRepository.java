package ar.com.ada.tp.model.repository;

import ar.com.ada.tp.model.entity.ParticipantGender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("participantGenderRepository")
public interface ParticipantGenderRepository extends JpaRepository<ParticipantGender, Long> {

    @Modifying
    @Query(value = "ALTER TABLE ParticipantGender AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoincrementValue();
}
