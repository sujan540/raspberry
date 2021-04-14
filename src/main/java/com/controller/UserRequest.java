package com.controller;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class UserRequest {

    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
}
