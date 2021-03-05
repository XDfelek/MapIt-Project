package com.example.demo.model.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class VoteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private VOTE_TYPE vote;

    public enum VOTE_TYPE {
        VOTE_UP("+"),
        VOTE_DOWN("-");

        private final String text;

        VOTE_TYPE(String vote) {
            this.text = vote;
        }
    }

    @ManyToOne
    private PostEntity postId;

}
