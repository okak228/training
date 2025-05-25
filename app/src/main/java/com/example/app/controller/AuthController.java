package com.example.app.controller;

import com.example.app.dto.request.SignInRequest;
import com.example.app.dto.request.SignUpRequest;
import com.example.app.dto.response.MessageResponse;
import com.example.app.dto.response.SignInResponse;
import com.example.app.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/sign-up")
    public ResponseEntity<MessageResponse> signUp(
            @RequestBody SignUpRequest req
    ) {
        return ResponseEntity.ok(authService.signUp(req));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<SignInResponse> signIn(
            @RequestBody SignInRequest req
    ) {
        return ResponseEntity.ok(authService.signIn(req));
    }
}
