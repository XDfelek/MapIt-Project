package com.example.demo.model.dao;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "posts")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;

    private String description;

    @NotEmpty
    private String imagePath;

    private Double imageLatitude;

    private Double imageLongitude;

    private Long votesUp;

    private Long votesDown;

    @OneToMany
    private List<CommentEntity> comments;

    @ManyToOne
    private UserEntity userId;

    private LocalDate date;

}
