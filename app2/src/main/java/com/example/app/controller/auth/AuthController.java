package com.example.app.controller.auth;

import com.example.app.dto.request.SignInRq;
import com.example.app.dto.request.SignUpRq;
import com.example.app.dto.response.MessageRs;
import com.example.app.dto.response.SignInRs;
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
    public ResponseEntity<MessageRs> signUp(
            @RequestBody SignUpRq req
    ) {
        return ResponseEntity.ok(authService.signUp(req));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<SignInRs> signIn(
            @RequestBody SignInRq req
    ) {
        return ResponseEntity.ok(authService.signIn(req));
    }
}
