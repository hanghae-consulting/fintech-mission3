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
@RequestMapping("/api/auth")
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
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpSession session) {
        Optional<User> user = userService.authenticateUser(loginRequest.getUsername(), loginRequest.getPassword());

        if (user.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new MessageResponse("Invalid username or password"));
        }

        userService.createUserSession(session, user.get());

        return ResponseEntity.ok(new MessageResponse("User logged in successfully!"));
    }

    @GetMapping("/validate")
    public ResponseEntity<?> validateSession(HttpSession session) {
        if (userService.validateSession(session)) {
            return ResponseEntity.ok(new MessageResponse("Session is valid"));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new MessageResponse("Session is invalid or expired"));
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logout(HttpSession session) {
        session.invalidate();
        return ResponseEntity.ok(new MessageResponse("User logged out successfully!"));
    }
}
