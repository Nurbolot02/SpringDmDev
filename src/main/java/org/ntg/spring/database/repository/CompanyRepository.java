package org.ntg.spring.database.repository;

import org.ntg.spring.database.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
public interface CompanyRepository extends JpaRepository<Company, Integer> {
    Optional<Company> findCompanyByName(@Param("name2") String name);
    Optional<Company> findCompanyByNameIgnoreCase(String name);
    List<Company> findCompaniesByNameContainingIgnoreCase(String fragment);
}
