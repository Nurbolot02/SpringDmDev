package org.ntg.spring.service;

import org.ntg.spring.database.repository.CrudRepository;
import org.ntg.spring.dto.CompanyReadDto;
import org.ntg.spring.entity.Company;
import org.ntg.spring.listeners.entity.AccessType;
import org.ntg.spring.listeners.entity.EntityEvent;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Optional;

public class CompanyService {
    private final ApplicationEventPublisher applicationEventPublisher;
    private final UserService userService;
    private final CrudRepository<Integer, Company> companyCrudRepository;

    public CompanyService(ApplicationEventPublisher applicationEventPublisher, UserService userService, CrudRepository<Integer, Company> companyCrudRepository) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.userService = userService;
        this.companyCrudRepository = companyCrudRepository;
    }

    public Optional<CompanyReadDto> findById(Integer id){
        return companyCrudRepository.findById(id)
                .map(company -> {
                    applicationEventPublisher.publishEvent(new EntityEvent(company, AccessType.READ));
                    return new CompanyReadDto(company.id());
                });
    }
}
