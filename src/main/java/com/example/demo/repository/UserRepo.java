package com.example.demo.repository;

import com.example.demo.model.dao.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
    void deleteUserById(Long id);

    Optional<UserEntity> findUserById(Long id);
}