package ar.com.ada.tp.model.repository;

import ar.com.ada.tp.model.entity.Representative;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("representativeRepository")
public interface RepresentativeRepository extends JpaRepository<Representative, Long> {
}
