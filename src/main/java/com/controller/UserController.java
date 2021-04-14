package com.controller;

import static com.controller.UserController.BASE_URL;

import com.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(BASE_URL)
@AllArgsConstructor
public class UserController {

    public static final String BASE_URL = "/users";

    private final UserMapper userMapper;
    private final UserService userService;

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest userRequest) {

        final Optional<UserResponse> userResponse = userMapper.mapToResponse(
                userService.saveOrUpdate(
                        userMapper.buildEntity(Optional.ofNullable(userRequest))
                ));

        return ResponseEntity.ok(userResponse.get());

    }


}
