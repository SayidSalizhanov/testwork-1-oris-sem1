package ru.itis.testwork1.service.impl;

import ru.itis.testwork1.dao.UserDao;
import ru.itis.testwork1.dto.UserDto;
import ru.itis.testwork1.dao.impl.UserDaoImpl;
import ru.itis.testwork1.dto.UserLoginDto;
import ru.itis.testwork1.entity.User;
import ru.itis.testwork1.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserDao userDao = new UserDaoImpl();

    @Override
    public UserLoginDto getLoginDto(String login) {
        User user = userDao.getByLogin(login);
        return new UserLoginDto(
                user.getLogin(),
                user.getPassword()
        );
    }

    @Override
    public UserDto get(Integer id) {
        User user = userDao.get(id);
        return new UserDto(
                user.getName(),
                user.getLogin()
        );
    }

    @Override
    public UserDto getByLogin(String login) {
        User user = userDao.getByLogin(login);
        return new UserDto(
                user.getName(),
                user.getLogin()
        );
    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userDao.getAll();
        return users.stream()
                .map(u -> new UserDto(u.getName(), u.getLogin()))
                .toList();
    }

    @Override
    public void register(String name, String login, String password) {
        userDao.save(
                new User(
                        null,
                        name,
                        login,
                        password
                )
        );
    }
}
