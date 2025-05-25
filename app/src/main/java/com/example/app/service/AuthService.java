package com.example.app.service;

import com.example.app.dto.request.SignInRequest;
import com.example.app.dto.request.SignUpRequest;
import com.example.app.dto.response.MessageResponse;
import com.example.app.dto.response.SignInResponse;
import com.example.app.exception.ConflictException;
import com.example.app.exception.EntityNotFoundException;
import com.example.app.model.Role;
import com.example.app.model.User;
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

    public MessageResponse signUp(SignUpRequest req) {
        if (userService.find(req.getName()).isPresent()) {
            throw new ConflictException("A user with this e-mail address already exists");
        }
        userService.create(req.getName(), passwordEncoder.encode(req.getPassword()), Role.USER);
        return new MessageResponse("Account created successfully. Please sign in");
    }

    public SignInResponse signIn(SignInRequest req) {
        final User user = userService.find(req.getName())
                .orElseThrow(() -> new EntityNotFoundException("Incorrect name or password"));
        if (!passwordEncoder.matches(req.getPassword(), user.getPassword())) {
            throw new EntityNotFoundException("Incorrect name or password");
        }
        final String accessToken = jwtUtils.generateToken(user);
        return new SignInResponse(user.getUsername(), user.getRole().name(), accessToken);
    }

    public User getCurrentUser() {
        UsernamePasswordAuthenticationToken auth = (UsernamePasswordAuthenticationToken)
                SecurityContextHolder.getContext().getAuthentication();
        final String name = auth.getName();
        return userService.find(name).orElseThrow(() -> new EntityNotFoundException("User not found"));
    }
}
