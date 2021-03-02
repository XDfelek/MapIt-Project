package com.example.demo.model.dao;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Data
@Table(name = "comments")
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String content;

    @ManyToOne
    private PostEntity postId;

    @ManyToOne
    private UserEntity userId;

    private String imagePath;

    private Long votesUp;

    private Long votesDown;

    private LocalDate date;
}
