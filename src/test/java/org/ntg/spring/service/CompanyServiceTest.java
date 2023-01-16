package org.ntg.spring.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.ntg.spring.database.repository.CompanyRepository;
import org.ntg.spring.dto.CompanyReadDto;
import org.ntg.spring.database.entity.Company;
import org.ntg.spring.listeners.entity.EntityEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.repository.CrudRepository;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {
    private static final int COMPANY_ID = 1;
    @Mock
    private ApplicationEventPublisher applicationEventPublisher;
    @Mock
    private UserService userService;
    @Mock
    private CompanyRepository companyRepository;
    @InjectMocks
    private CompanyService companyService;

    @Test
    void findById() {
        doReturn(Optional.of(new Company((int) COMPANY_ID, "facebook", Collections.emptyMap()) ))
                .when(companyRepository).findById(COMPANY_ID);

        Optional<CompanyReadDto> actualResult = companyService.findById(COMPANY_ID);
        assertTrue(actualResult.isPresent());

        CompanyReadDto expectedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));

        verify(applicationEventPublisher).publishEvent(any(EntityEvent.class));
        verifyNoMoreInteractions(applicationEventPublisher, userService);
    }
}