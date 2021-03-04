package com.example.demo.service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.dao.UserEntity;
import com.example.demo.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public UserEntity addUser(UserEntity addUser) {
        return userRepo.save(addUser);
    }

    public List<UserEntity> findAllUsers(){
        return userRepo.findAll();
    }

    public UserEntity updateEmployee(UserEntity user) {
        return userRepo.save(user);
    }

    public UserEntity findUserById(Long id) {
        return userRepo.findUserById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id " + id + " was not found"));
    }

    public void deleteUser(Long id) {
        userRepo.deleteUserById(id);
    }
}
