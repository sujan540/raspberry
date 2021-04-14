package com.controller;

import com.modal.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Component
public class UserMapper extends BaseMapper<User,UserRequest, UserResponse>{

    @Override
    Optional<UserResponse> mapToResponse(Optional<User> user) {
        return Optional.ofNullable(UserResponse.builder()
                .email(user.get().getEmail())
                .firstName(user.get().getFirstName())
                .lastName(user.get().getLastName())
                .username(user.get().getUsername())
                .password(user.get().getPassword())
                .email(user.get().getEmail())
                .build());
    }

    @Override
    Optional<User> mapToEntity(Optional<UserRequest> request) {
        return Optional.ofNullable(User.builder()
                .email(request.get().getEmail())
                .firstName(request.get().getFirstName())
                .lastName(request.get().getLastName())
                .username(request.get().getUsername())
                .password(request.get().getPassword())
                .email(request.get().getEmail())
                .build());
    }
}
