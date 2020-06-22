package ar.com.ada.tp.model.repository;

import ar.com.ada.tp.model.entity.Information;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("informationRepository")
public interface InformationRepository extends JpaRepository<Information, Long> {

    @Modifying
    @Query(value = "ALTER TABLE Information AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoincrementValue();
}
