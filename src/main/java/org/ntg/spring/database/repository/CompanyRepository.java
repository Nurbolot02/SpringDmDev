package org.ntg.spring.database.repository;

import lombok.RequiredArgsConstructor;
import org.ntg.spring.bpp.TransactionN;
import org.ntg.spring.database.pool.ConnectionPool;
import org.ntg.spring.entity.Company;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Optional;
@TransactionN
@Repository
@RequiredArgsConstructor
public class CompanyRepository implements CrudRepository<Long, Company> {
    private ConnectionPool connectionPool;
    @Value("${db.poolSize}")
    private int dbPoolSize;
    private List<ConnectionPool> connectionPools;

    @Override
    public Optional<Company> findById(Long id) {
        System.out.println("find by id method ...");
        return Optional.of(new Company(id));
    }

    @Override
    public boolean deleteById(Long id) {
        System.out.println("delete method ...");
        return false;
    }

    @PostConstruct
    private void init(){
        System.out.println("Init company repository");
    }

    @PreDestroy
    private void destroy(){
        System.out.println("destroy company repository");
    }
}
