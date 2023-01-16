package org.ntg.spring.database.repository;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.ntg.spring.database.entity.Company;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestConstructor;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ActiveProfiles("test")
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class CompanyRepositoryTest {

    private final EntityManager entityManager;

    @Test
    void checkFindById(){
        Company company = entityManager.find(Company.class, 1);
        assertNotNull(company);
        System.out.println();
    }

}