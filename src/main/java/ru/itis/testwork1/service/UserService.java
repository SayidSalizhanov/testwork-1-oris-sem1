package ru.itis.testwork1.service;

import ru.itis.testwork1.dto.UserDto;
import ru.itis.testwork1.dto.UserLoginDto;

import java.util.List;

public interface UserService {
    UserLoginDto getLoginDto(String login);
    UserDto get(Integer id);
    UserDto getByLogin(String login);
    List<UserDto> getAll();
    void register(String name, String login, String password);
}
