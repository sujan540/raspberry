package com.controller;

import static com.controller.UserController.BASE_URL;

import com.modal.User;
import com.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(BASE_URL)
@AllArgsConstructor
public class UserController {

    public static final String BASE_URL = "/users";

    private final UserMapper userMapper;
    private final UserService userService;


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<Payload<UserResponse>> getAll() {
        final List<UserResponse> userResponses = userMapper.buildResponses(userService.getAll());
        final Payload<UserResponse> response = new Payload<>();
        response.setCount((long) userResponses.size());
        response.setEntities(userResponses);
        response.setLimit(0);
        response.setOffset(0);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserResponse> registerUser(@RequestBody UserRequest userRequest) {

        final Optional<UserResponse> userResponse = userMapper.mapToResponse(
                userService.saveOrUpdate(
                        userMapper.buildEntity(Optional.ofNullable(userRequest))
                ));

        return ResponseEntity.ok(userResponse.get());

    }

    @PostMapping(value = "/authenticate", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<UserResponse> authenticateUser(@RequestBody UserRequest userRequest) {

        final Optional<User> user = userService.findByUsernameAndPassword(userRequest.getUsername(), userRequest.getPassword());

        if (user.isPresent()) {
            final Optional<UserResponse> userResponse = userMapper.mapToResponse(user);
            return ResponseEntity.ok(userResponse.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> deleteUser(@PathVariable Long id) {

        boolean isRemoved = userService.delete(id);

        if (!isRemoved) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
