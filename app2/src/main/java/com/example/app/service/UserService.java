package com.example.app.service;

import com.example.app.dto.response.PageRs;
import com.example.app.dto.response.UserDetailRs;
import com.example.app.entity.NewEntity;
import com.example.app.exception.EntityNotFoundException;
import com.example.app.mapper.UserMapper;
import com.example.app.entity.enums.Role;
import com.example.app.entity.User;
import com.example.app.repository.UserRepository;
import com.example.app.util.UserSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Transactional(readOnly = true)
    public User findById(UUID id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(id.toString()));
    }

    public Optional<User> find(String name) {
        return userRepository.findByName(name);
    }

    public User create(String name, String password, Role role) {
        final User user = new User(name, password, role);
        return userRepository.save(user);
    }

    public PageRs<UserDetailRs> getPage(Pageable pageRequest, String name) {
        return userMapper.toPageResponse(userRepository.findAll(UserSpecification.userSpecification(name), pageRequest));
    }

    public List<UserDetailRs> getAll() {
        return userMapper.toPageResponse(userRepository.findAll());
    }
}
