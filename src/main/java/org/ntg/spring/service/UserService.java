package org.ntg.spring.service;

import lombok.RequiredArgsConstructor;
import org.ntg.spring.database.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
}
