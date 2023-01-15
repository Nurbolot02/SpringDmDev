package org.ntg.spring.integration.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.ntg.spring.config.DatabaseProperties;
import org.ntg.spring.dto.CompanyReadDto;
import org.ntg.spring.integration.annotation.IntegrationTest;
import org.ntg.spring.service.CompanyService;
import org.springframework.test.context.TestConstructor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration(classes = SpringApplicationRunner.class,
// initializers = ConfigDataApplicationContextInitializer.class)

@IntegrationTest
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class CompanyServiceIT {
    private static final int COMPANY_ID = 1;
    private final CompanyService companyService;
    private final DatabaseProperties databaseProperties;

    @Test
    void findById() {
        var actualResult = companyService.findById(COMPANY_ID);
        assertTrue(actualResult.isPresent());

        var expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));
    }
}