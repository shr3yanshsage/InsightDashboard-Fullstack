package com.examplecom.shr3yansh.deinsights_backendmo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import com.examplecom.shr3yansh.deinsights_backendmo.config.JwtUtil;
import com.examplecom.shr3yansh.deinsights_backendmo.entity.User;
import com.examplecom.shr3yansh.deinsights_backendmo.service.AuthService;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    // 🔹 Register
    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return authService.register(user);
    }

    // 🔹 Login (temporary simple response)
    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {

        boolean isAuthenticated = authService.authenticate(user.getUsername(), user.getPassword());

        if (!isAuthenticated) {
            throw new RuntimeException("Invalid credentials");
        }

        String token = jwtUtil.generateToken(user.getUsername());
        return Map.of("token", token);

    }
}
