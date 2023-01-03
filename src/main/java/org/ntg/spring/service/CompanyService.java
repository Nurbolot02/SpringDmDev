package org.ntg.spring.service;

import lombok.RequiredArgsConstructor;
import org.ntg.spring.database.repository.CrudRepository;
import org.ntg.spring.dto.CompanyReadDto;
import org.ntg.spring.entity.Company;
import org.ntg.spring.listeners.entity.AccessType;
import org.ntg.spring.listeners.entity.EntityEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CompanyService {
    private final ApplicationEventPublisher applicationEventPublisher;
    private final UserService userService;
    private final CrudRepository<Long, Company> companyCrudRepository;

    public Optional<CompanyReadDto> findById(Long id){
        return companyCrudRepository.findById(id)
                .map(company -> {
                    applicationEventPublisher.publishEvent(new EntityEvent(company, AccessType.READ));
                    return new CompanyReadDto(company.id());
                });
    }

    public void deleteById(Long id){
        companyCrudRepository.deleteById(id);
    }
}
