package ar.com.ada.tp.model.repository;

import ar.com.ada.tp.model.entity.DocumentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("documentTypeRepository")
public interface DocumentTypeRepository extends JpaRepository<DocumentType, Long> {

    @Modifying
    @Query(value = "ALTER TABLE DocumentType AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoincrementValue();
}
