package tech.fivedhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.fivedhub.model.Company;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {

    Optional<Company> findByNameCompany(String nameCompany);
}
