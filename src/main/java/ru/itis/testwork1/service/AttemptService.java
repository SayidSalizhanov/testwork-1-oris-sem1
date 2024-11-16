package ru.itis.testwork1.service;

import ru.itis.testwork1.dto.AttemptDto;

import java.time.LocalDateTime;
import java.util.List;

public interface AttemptService {
    AttemptDto get(Integer id);
    AttemptDto getByLogin(String login);
    List<AttemptDto> getAll();
    void save(String login, Boolean status);
}
