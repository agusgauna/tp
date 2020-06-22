package ar.com.ada.tp.model.repository;

import ar.com.ada.tp.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository("categoryRepository")
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Modifying
    @Query(value = "ALTER TABLE Category AUTO_INCREMENT = 1", nativeQuery = true)
    void resetAutoincrementValue();

}
