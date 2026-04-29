package com.famcloud.service;

import com.famcloud.entity.User;
import com.famcloud.entity.UserRole;
import com.famcloud.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

    @Autowired
    private final UserRepository userRepository;

    public User processUser(String email) {

        return userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not authorized. Contact admin."));
    }

}
