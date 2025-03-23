package com.example.controller;

import com.example.dto.LoginRequest;
import com.example.dto.MessageResponse;
import com.example.dto.RegisterRequest;
import com.example.dto.UserInfoResponse;
import com.example.entity.User;
import com.example.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        log.info("Register request received for user: {}", registerRequest.getUsername());

        if (userService.registerUser(registerRequest)) {
            return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
        } else {
            return ResponseEntity.badRequest().body(new MessageResponse("Username or email is already taken!"));
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, HttpSession session) {
        log.info("Login attempt for user: {}", loginRequest.getUsername());

        User user = userService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword())
                .orElse(null);

        if (user == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new MessageResponse("Invalid username or password!"));

        userService.createUserSession(session, user);

        return ResponseEntity.ok(new UserInfoResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail()
        ));
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validateSession(HttpSession session) {
        log.debug("Session validation request received");

        if (userService.validateSession(session)) {
            Long userId = (Long) session.getAttribute("AUTHENTICATED_USER");
            String username = (String) session.getAttribute("USERNAME");

            log.info("Session is valid for user: {}", username);
            return ResponseEntity.ok(new MessageResponse("Session is valid"));
        }
        log.info("Invalid session");
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
        .body(new MessageResponse("Session is invalid or expired"));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logoutUser(HttpSession session) {
        log.info("Logout request received");

        session.invalidate();
        return ResponseEntity.ok(new MessageResponse("User logged out successfully!"));
    }
}
