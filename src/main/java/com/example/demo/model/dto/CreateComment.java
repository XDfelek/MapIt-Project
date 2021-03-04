package com.example.demo.model.dto;

import com.example.demo.model.dao.PostEntity;
import com.example.demo.model.dao.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateComment {

    private String content;

    private LocalDate date;
}
