package org.ntg.spring.integration.database.repository;

import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.ntg.spring.database.entity.Company;
import org.ntg.spring.database.repository.CompanyRepository;
import org.ntg.spring.integration.annotation.IntegrationTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@IntegrationTest
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
@RequiredArgsConstructor
@Transactional
class CompanyRepositoryTest {
    private final EntityManager entityManager;
    private final TransactionTemplate transactionTemplate;
    private final CompanyRepository companyRepository;

    @Test
    void checkFindByNameMethod(){
        String companyName = "NTG2";
        Optional<Company> company = companyRepository.findCompanyByName(companyName);
        assertTrue(company.isPresent());
        assertEquals(companyName, company.get().getName());
    }

    @Test
    void checkFindCompaniesByNameContainingIgnoreCaseMethod(){
        String companyNameFragment = "le";
        List<Company> companyList = companyRepository.findCompaniesByNameContainingIgnoreCase(companyNameFragment);
        assertNotNull(companyList);
        companyList.forEach(company -> assertTrue(company.getName().contains(companyNameFragment)));
    }

    @Test
    void delete(){
        int ntgId = 5;
        Optional<Company> company = companyRepository.findById(ntgId);
        assertNotNull(company);
        assertTrue(company.isPresent());
        company.ifPresent(companyRepository::delete);
        entityManager.flush();
        assertTrue(companyRepository.findById(ntgId).isEmpty());
        System.out.println();
    }

    @Test
    void findById() {
        transactionTemplate.executeWithoutResult(tn -> {
            Company company = entityManager.find(Company.class, 1);
            assertNotNull(company);
            Assertions.assertThat(company.getLocales()).hasSize(2);
        });
    }

    @Test
    void checkRollBackInTests(){
        Company company = Company.builder()
                .name("NTG2")
                .locales(
                        Map.of(
                                "l1", "v1",
                                "l2", "v2"
                        )
                )
                .build();

        entityManager.persist(company);
    }
}