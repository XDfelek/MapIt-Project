package com.example.demo.model.dao;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
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

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    @NotEmpty
    private String email;

    private Long level;

    @ManyToMany
    private List<AuthoritiesEntity> role;

    @OneToMany
    private List<PostEntity> posts;

    @OneToMany
    private List<CommentEntity> comments;

    private boolean isBanned;

    private LocalDate endOfBan;

}
