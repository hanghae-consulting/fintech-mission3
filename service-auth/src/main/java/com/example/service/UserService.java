package com.example.service;

import com.example.dto.RegisterRequest;
import com.example.entity.User;
import com.example.repository.UserRepository;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public boolean registerUser(RegisterRequest registerRequest) {
        // Check if username or email already exists
        if (userRepository.existsByUsername(registerRequest.getUsername())) {
            log.info("Username already taken: {}", registerRequest.getUsername());
            return false;
        }

        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            log.info("Email already in use: {}", registerRequest.getEmail());
            return false;
        }

        // Create new user
        User user = new User(
            registerRequest.getUsername(),
            registerRequest.getEmail(),
            passwordEncoder.encode(registerRequest.getPassword())
        );
        
        userRepository.save(user);
        log.info("User registered successfully: {}", user.getUsername());
        return true;
    }

    public Optional<User> authenticateUser(String username, String password) {
        log.debug("Attempting to authenticate user: {}", username);
        return userRepository.findByUsername(username)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()));
    }

    public void createUserSession(HttpSession session, User user) {
        session.setAttribute("AUTHENTICATED_USER", user.getId());
        session.setAttribute("USERNAME", user.getUsername());
        log.info("Session created for user: {}", user.getUsername());
    }

    public boolean validateSession(HttpSession session) {
        boolean isValid = session.getAttribute("AUTHENTICATED_USER") != null;
        log.debug("Session validation result: {}", isValid);
        return isValid;
    }
}
