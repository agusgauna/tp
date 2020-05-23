package ar.com.ada.tp.model.repository;

import ar.com.ada.tp.model.entity.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("inscriptionRepository")
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
}
