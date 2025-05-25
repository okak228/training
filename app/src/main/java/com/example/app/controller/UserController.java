package com.example.app.controller;

import com.example.app.dto.response.UserResponse;
import com.example.app.model.User;
import com.example.app.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final AuthService authService;

    @GetMapping("/current")
    public ResponseEntity<UserResponse> getUserData() {
        final User user = authService.getCurrentUser();
        final UserResponse userData = new UserResponse(user.getUsername(), user.getRole().name());
        return ResponseEntity.ok(userData);
    }
}
