package com.example.app.service;

import com.example.app.dto.request.SignInRq;
import com.example.app.dto.request.SignUpRq;
import com.example.app.dto.response.MessageRs;
import com.example.app.dto.response.SignInRs;
import com.example.app.exception.ConflictException;
import com.example.app.exception.EntityNotFoundException;
import com.example.app.entity.enums.Role;
import com.example.app.entity.User;
import com.example.app.util.JWTUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JWTUtils jwtUtils;

    public MessageRs signUp(SignUpRq req) {
        if (userService.find(req.getName()).isPresent()) {
            throw new ConflictException("A user with this e-mail address already exists");
        }
        userService.create(req.getName(), passwordEncoder.encode(req.getPassword()), Role.USER);
        return new MessageRs("Account created successfully. Please sign in");
    }

    public SignInRs signIn(SignInRq req) {
        final User user = userService.find(req.getName())
                .orElseThrow(() -> new EntityNotFoundException("Incorrect name or password"));
        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            throw new EntityNotFoundException("Incorrect name or password");
        }
        final String accessToken = jwtUtils.generateToken(user);
        return new SignInRs(user.getUsername(), user.getRole().name(), accessToken);
    }

    public User getCurrentUser() {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken)
                SecurityContextHolder.getContext().getAuthentication();
        final String name = auth.getName();
        return userService.find(name).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }
}
