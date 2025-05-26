package com.example.app.mapper;

import com.example.app.dto.response.PageRs;
import com.example.app.dto.response.UserDetailRs;
import com.example.app.dto.response.UserRs;
import com.example.app.entity.User;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UserMapper {

//    public UserResponse toResponse(User user) {
//        return new UserResponse()
//                .setName(user.getName())
//                .setRole(user.getRole().toString());
//    }

    public abstract UserRs toResponse(User user);

    public abstract UserDetailRs toDetailResponse(User user);

    public PageRs<UserDetailRs> toPageResponse(Page<User> users) {
        return new PageRs<>(users.map(this::toDetailResponse));
    }

    public abstract List<UserDetailRs> toPageResponse(List<User> users);
}
