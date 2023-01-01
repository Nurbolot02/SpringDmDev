package org.ntg;

import org.ntg.database.pool.ConnectionPool;
import org.ntg.database.repository.CompanyRepository;
import org.ntg.database.repository.CrudRepository;
import org.ntg.entity.Company;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

public class Main {
    public static void main(String[] args) {
        String val = "hello";

        System.out.println(val.getClass().isAssignableFrom(CharSequence.class));
        System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(val.getClass()));

        ConnectionPool bean;
        try (var context = new ClassPathXmlApplicationContext("application.xml")) {
            bean = context.getBean("pool1", ConnectionPool.class);
            System.out.println(bean);


            AtomicReference<String> driver = new AtomicReference<>(context.getBean("driver", String.class));
            System.out.println(driver.get());

            var companyRepository = context.getBean("companyRepository", CrudRepository.class);
            Optional<Company> companyRepositoryById = companyRepository.findById(1L);
            System.out.println(companyRepositoryById);
            System.out.println(companyRepository.deleteById(1L));


            System.out.println("${driver.get()}");

        }
    }
}