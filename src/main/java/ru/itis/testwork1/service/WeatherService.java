package ru.itis.testwork1.service;

import ru.itis.testwork1.entity.WeatherAttempt;

import java.util.List;

public interface WeatherService {
    String getWeather(String userLogin, String cityName, String appid);
    List<WeatherAttempt> getAll();
    void save(String userLogin, String city);
}
