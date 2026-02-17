package com.examplecom.shr3yansh.deinsights_backendmo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.examplecom.shr3yansh.deinsights_backendmo.entity.User;
import com.examplecom.shr3yansh.deinsights_backendmo.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    // 🔹 Register new user
    public User register(User user) {

        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser.isPresent()) {
            throw new RuntimeException("Username already exists");
        }

        // Encrypt password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Default role
        user.setRole("ROLE_USER");

        return userRepository.save(user);
    }

    // 🔹 Login validation
    public boolean authenticate(String username, String password) {

        Optional<User> userOptional = userRepository.findByUsername(username);

        if (userOptional.isEmpty()) {
            return false;
        }

        User user = userOptional.get();

        return passwordEncoder.matches(password, user.getPassword());
    }
}