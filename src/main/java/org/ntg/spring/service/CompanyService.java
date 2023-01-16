package org.ntg.spring.service;

import lombok.RequiredArgsConstructor;
import org.ntg.spring.database.repository.CompanyRepository;
import org.ntg.spring.dto.CompanyReadDto;
import org.ntg.spring.database.entity.Company;
import org.ntg.spring.listeners.entity.AccessType;
import org.ntg.spring.listeners.entity.EntityEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class CompanyService {
    private final ApplicationEventPublisher applicationEventPublisher;
    private final UserService userService;
    private final CompanyRepository companyRepository;

    public Optional<CompanyReadDto> findById(Integer id){
        return companyRepository.findById(id)
                .map(company -> {
                    applicationEventPublisher.publishEvent(new EntityEvent(company, AccessType.READ));
                    return new CompanyReadDto(company.getId());
                });
    }

    public void deleteById(Integer id){
        companyRepository.deleteById(id);
    }
}
