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

    @Column(name = "image_path")
    @NotEmpty
    private String imagePath;

    @Column(name = "image_latitude")
    private Double imageLatitude;

    @Column(name = "image_longitude")
    private Double imageLongitude;

    @Column(name = "image_coordinates_are_real")  //TODO domyślnie jest false, trzeba zmienic pozniej
    private boolean imageCoordinatesAreReal;

    @Column(name = "votes_up")
    private Long votesUp;

    @Column(name = "votes_down")
    private Long votesDown;

    @OneToMany
    private List<CommentEntity> comments;

    @Column(name = "user_id")
    @ManyToOne
    private UserEntity userId;

    private LocalDate date;

}
