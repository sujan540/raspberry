package com.controller;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserResponse {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
}
