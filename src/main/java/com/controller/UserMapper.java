package com.controller;

import com.modal.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserMapper extends BaseMapper<User, UserRequest, UserResponse> {

    @Override
    public List<String> doValidate(Optional<UserRequest> userRequest) {
        final List<String> issues = new ArrayList<>();
        if (StringUtils.isEmpty(userRequest.get().getEmail())) {
            issues.add("Email cannot be empty");
        }
        if (StringUtils.isEmpty(userRequest.get().getUsername())) {
            issues.add("Username cannot be empty");
        }
        if (StringUtils.isEmpty(userRequest.get().getPassword())) {
            issues.add("Password cannot be empty");
        }
        if (StringUtils.isEmpty(userRequest.get().getFirstName())) {
            issues.add("First Name cannot be empty");
        }
        if (StringUtils.isEmpty(userRequest.get().getLastName())) {
            issues.add("Last name cannot be empty");
        }
        return issues;
    }


    @Override
    public Optional<UserResponse> mapToResponse(Optional<User> user) {
        return Optional.ofNullable(UserResponse.builder()
                .email(user.get().getEmail())
                .firstName(user.get().getFirstName())
                .lastName(user.get().getLastName())
                .username(user.get().getUsername())
                .password(user.get().getPassword())
                .email(user.get().getEmail())
                .id(user.get().getId())
                .build());
    }

    @Override
    public Optional<User> mapToEntity(Optional<UserRequest> request) {
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
