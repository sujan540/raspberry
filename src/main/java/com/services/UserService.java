package com.services;

import com.modal.User;

import java.util.List;
import java.util.Optional;

public interface UserService extends EntityService<User> {
    List<User> getAll();
    boolean delete(Long id);
    Optional<User> findByUsernameAndPassword(String username, String password);
}
