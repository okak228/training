package com.example.app.controller.user;

import com.example.app.dto.response.PageRs;
import com.example.app.dto.response.UserDetailRs;
import com.example.app.dto.response.UserRs;
import com.example.app.entity.User;
import com.example.app.service.AuthService;
import com.example.app.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final AuthService authService;
    private final UserService userService;

    @GetMapping("/current")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public ResponseEntity<UserRs> getUserData() {
        final User user = authService.getCurrentUser();
        final UserRs userData = new UserRs(user.getUsername(), user.getRole().name());
        return ResponseEntity.ok(userData);
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public PageRs<UserDetailRs> getPage(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size,
            @RequestParam(value = "sortBy", required = false) String sortBy,
            @RequestParam(value = "name", required = false) String name
    ) {
        if (null == page) page = 1;
        if (null == size) size = 5;
        if (StringUtils.isEmpty(sortBy)) sortBy = "name";
        return userService.getPage(PageRequest.of(page - 1, size, Sort.by(Sort.Order.desc(sortBy))), name);
    }

    @GetMapping("/all")
    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
    public List<UserDetailRs> getAll() {
        return userService.getAll();
    }
}
