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

    @Column(name = "post_id")
    @ManyToOne
    private PostEntity postId;

    @Column(name = "user_id")
    @ManyToOne
    private UserEntity userId;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "votes_up")
    private Long votesUp;

    @Column(name = "votes_down")
    private Long votesDown;

    private LocalDate date;
}
