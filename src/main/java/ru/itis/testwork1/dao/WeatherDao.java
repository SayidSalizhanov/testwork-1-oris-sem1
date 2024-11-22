package ru.itis.testwork1.dao;

import ru.itis.testwork1.entity.WeatherAttempt;

import java.util.List;

public interface WeatherDao {
    List<WeatherAttempt> getAll();
    void save(WeatherAttempt weatherAttempt);
}
