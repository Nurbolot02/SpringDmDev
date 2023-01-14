package org.ntg.spring.integration.service;

import org.junit.jupiter.api.Test;
import org.ntg.spring.config.DatabaseProperties;
import org.ntg.spring.dto.CompanyReadDto;
import org.ntg.spring.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
@ActiveProfiles("test")
public class companyServiceIT {
    private static final int COMPANY_ID = 1;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private DatabaseProperties databaseProperties;

    @Test
    void findById() {
        var actualResult = companyService.findById(COMPANY_ID);
        assertTrue(actualResult.isPresent());

        var expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));
    }
}