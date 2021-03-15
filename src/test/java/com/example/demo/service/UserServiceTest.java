package com.example.demo.service;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.dao.UserEntity;
import com.example.demo.repository.UserRepo;
import org.apache.catalina.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.when;

public class UserServiceTest {

    public static final String EMAIL = "test@test.com";
    private static final Long USER_ID = 1L;

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void shouldReturnUser() {
        when(userRepo.findUserById(USER_ID)).thenReturn(getUser());

        UserEntity user = userService.findUserById(USER_ID);

        Assertions.assertEquals(USER_ID, user.getId());
    }

    @Test
    void shouldThrowExceptionWhenNoUser(){
        when(userRepo.findUserById(USER_ID)).thenReturn(Optional.empty());

        Assertions.assertThrows(UserNotFoundException.class, () -> {
            userService.findUserById(USER_ID);
        });

    }

    @Test
    void  shouldEditUser() {
        when(userRepo.save(getUserEntity())).thenReturn(getUserEntity());

        UserEntity user = userService.updateUser(getUserEntity());

        Assertions.assertEquals(EMAIL, user.getEmail());
    }

    @Test
    void shouldAddUser() {
        when(userRepo.save(getUserEntity())).thenReturn(getUserEntity());

        UserEntity user = userService.addUser(getUserEntity());

        Assertions.assertEquals(EMAIL, user.getEmail());

    }

    @Test
    void shouldFindAllUser() {
        when(userRepo.findAll()).thenReturn(List.of(getUserEntity()));

        List<UserEntity> userEntityList = userService.findAllUsers();

        Assertions.assertEquals(1, userEntityList.size());
    }

    private Optional<UserEntity> getUser() {
        UserEntity userEntity = getUserEntity();

        return Optional.of(userEntity);
    }

    private UserEntity getUserEntity() {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(USER_ID);
        userEntity.setUsername("Username");
        userEntity.setEmail(EMAIL);
        return userEntity;
    }
}