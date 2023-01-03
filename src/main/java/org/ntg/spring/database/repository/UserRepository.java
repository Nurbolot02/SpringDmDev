package org.ntg.spring.database.repository;

import lombok.RequiredArgsConstructor;
import org.ntg.spring.database.pool.ConnectionPool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserRepository {
    @Qualifier("pool2")
    private final ConnectionPool connectionPool;
}
