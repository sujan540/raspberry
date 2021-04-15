package com.repository;

import com.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    void deleteById(Long id);
    Optional<User> findByUsernameAndPassword(String username, String password);
}
