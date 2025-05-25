package com.example.app.service;

import com.example.app.model.Role;
import com.example.app.model.User;
import com.example.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Optional<User> find(String name) {
        return userRepository.findByName(name);
    }

    public User create(String name, String password, Role role) {
        final User user = new User(name, password, role);
        return userRepository.save(user);
    }
}
