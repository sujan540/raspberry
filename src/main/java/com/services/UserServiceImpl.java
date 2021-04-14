package com.services;

import com.modal.User;
import com.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends BaseEntityService<User> implements UserService {

    private final UserRepository userRepository;

    @Override
    protected UserRepository getEntityRepository() {
        return userRepository;
    }
}
