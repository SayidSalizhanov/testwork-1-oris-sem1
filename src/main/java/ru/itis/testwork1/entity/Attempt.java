package ru.itis.testwork1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Attempt {
    private Integer id;
    private String login;
    private LocalDateTime time;
    private Boolean status;
}
