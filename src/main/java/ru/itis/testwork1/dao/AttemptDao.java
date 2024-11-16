package ru.itis.testwork1.dao;

import ru.itis.testwork1.entity.Attempt;

import java.util.List;

public interface AttemptDao {
    Attempt get(Integer id);
    Attempt getByLogin(String login);
    List<Attempt> getAll();
    void save(Attempt attempt);
}
