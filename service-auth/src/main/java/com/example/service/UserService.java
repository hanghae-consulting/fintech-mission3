package com.example.service;

import com.example.dto.RegisterRequest;
import com.example.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.session.Session;
import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Service;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.Optional;
import com.example.entity.User;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean registerUser(RegisterRequest req) {
        String username = req.getUsername();
        String password = req.getPassword();
        String email = req.getEmail();

        // 사용자명 중복 확인
        if (userRepository.existsByUsername(username)) {
            log.info("Username already taken: {}", username);
            return false;
        }

        // 이메일 중복 확인
        if (userRepository.existsByEmail(email)) {
            log.info("Email already in use: {}", email);
            return false;
        }

        // 새로운 사용자 저장
        User user = new User(username, email, passwordEncoder.encode(password));
        userRepository.save(user);

        log.info("User registered successfully: {}", user.getUsername());
        return true;
    }

    public Optional<User> authenticateUser(String username, String password) {
        return userRepository.findByUsername(username)
                .filter(user -> passwordEncoder.matches(password, user.getPassword()));
    }

    public void createUserSession(HttpSession session, User user) {
        session.setAttribute("USERNAME", user.getUsername());
        log.info("Session created in Redis for user: {}", user.getUsername());
    }

    public boolean validateSession(HttpSession session) {
        return session.getAttribute("AUTHENTICATED_USER") != null;
    }
}
