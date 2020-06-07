package ar.com.ada.tp.model.repository;

import ar.com.ada.tp.model.entity.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("documentTypeRepository")
public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {
}
