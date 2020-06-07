package ar.com.ada.tp.model.repository;

import ar.com.ada.tp.model.entity.CompanyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("companyTypeRepository")
public interface CompanyTypeRepository extends JpaRepository<CompanyType, Long> {
}
