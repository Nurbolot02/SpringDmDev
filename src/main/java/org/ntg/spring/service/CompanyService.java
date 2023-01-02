package org.ntg.spring.service;

import org.ntg.spring.database.repository.CrudRepository;
import org.ntg.spring.dto.CompanyReadDto;
import org.ntg.spring.entity.Company;

import java.util.Optional;

public class CompanyService {
    private final UserService userService;
    private final CrudRepository<Integer, Company> companyCrudRepository;

    public CompanyService(UserService userService, CrudRepository<Integer, Company> companyCrudRepository) {
        this.userService = userService;
        this.companyCrudRepository = companyCrudRepository;
    }

    public Optional<CompanyReadDto> findById(Integer id){
        return companyCrudRepository.findById(id)
                .map(company -> new CompanyReadDto(company.id()));
    }
}
