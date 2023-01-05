package org.ntg.spring.integration.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.ntg.spring.TestApplicationRunner;
import org.ntg.spring.database.pool.ConnectionPool;
import org.ntg.spring.service.UserService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = TestApplicationRunner.class)
@ActiveProfiles("test")
@RequiredArgsConstructor
public class UserServiceIT {
    private final UserService userService;
    private final ConnectionPool pool5;

    @Test
    void test() {
        System.out.println();
    }
}