package com.example.demo.model.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@Table(name = "authorities")
public class AuthoritiesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public enum ROLE{
        ADMIN,
        MODERATOR,
        USER_LOGGED,
        USER_NOT_LOGGED,
    }

    @Column(name = "user_id")
    @ManyToOne
    private UserEntity userId;
}
