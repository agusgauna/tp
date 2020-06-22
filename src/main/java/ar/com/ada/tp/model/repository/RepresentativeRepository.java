package ar.com.ada.tp.model.repository;

import ar.com.ada.tp.model.entity.Representative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("representativeRepository")
public interface RepresentativeRepository extends JpaRepository<Representative, Long> {

    @Modifying
    @Query(value = "ALTER TABLE Representative AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoincrementValue();
}
