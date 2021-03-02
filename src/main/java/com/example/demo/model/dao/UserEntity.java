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
@Table(name = "users")              //uniqueConstraints={@UniqueConstraint(columnNames={"username"})})
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    @ManyToMany
    private List<AuthoritiesEntity> role;

    @OneToMany
    private List<PostEntity> posts;

    @OneToMany
    private List<CommentEntity> comments;

}
