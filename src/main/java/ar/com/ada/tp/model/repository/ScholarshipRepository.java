package ar.com.ada.tp.model.repository;

import ar.com.ada.tp.model.entity.Scholarship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("scholarshipRepository")
public interface ScholarshipRepository extends JpaRepository<Scholarship, Long> {
}
