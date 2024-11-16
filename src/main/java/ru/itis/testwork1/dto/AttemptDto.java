package ru.itis.testwork1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AttemptDto {
    private String login;
    private String time;
    private String status;
}
