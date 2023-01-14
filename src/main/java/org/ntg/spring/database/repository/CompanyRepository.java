package org.ntg.spring.database.repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ntg.spring.bpp.TransactionN;
import org.ntg.spring.database.pool.ConnectionPool;
import org.ntg.spring.database.entity.Company;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Optional;

@TransactionN
@Repository
@RequiredArgsConstructor
@Slf4j
//@Transactional(propagation = Propagation.REQUIRED)
public class CompanyRepository implements CrudRepository<Integer, Company> {
    private CompanyRepository companyRepository;
    private ConnectionPool connectionPool;
    @Value("${db.poolSize}")
    private int dbPoolSize;
    private List<ConnectionPool> connectionPools;

    @Override
    public Optional<Company> findById(Integer id) {
        log.info("find by id method ...");
        return Optional.of(new Company(id.intValue(), "optional company"));
    }

    @Override
    public boolean deleteById(Integer id) {
        log.info("delete method ...");
        return false;
    }

    @PostConstruct
    private void init(){
        log.info("Init company repository");
    }

    @PreDestroy
    private void destroy(){
        log.info("destroy company repository");
    }
}
