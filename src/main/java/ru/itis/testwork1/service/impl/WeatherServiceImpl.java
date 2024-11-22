package ru.itis.testwork1.service.impl;

import org.json.JSONObject;
import ru.itis.testwork1.dao.WeatherDao;
import ru.itis.testwork1.dao.impl.WeatherDaoImpl;
import ru.itis.testwork1.entity.Attempt;
import ru.itis.testwork1.entity.WeatherAttempt;
import ru.itis.testwork1.service.WeatherService;
import ru.itis.testwork1.util.HttpClient;
import ru.itis.testwork1.util.HttpClientImpl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WeatherServiceImpl implements WeatherService {
    private final WeatherDao weatherDao = new WeatherDaoImpl();
    private final HttpClient httpClient = new HttpClientImpl();
    private static final String url = "http://api.openweathermap.org/data/2.5//weather";

    public String getWeather(String userLogin, String cityName, String appid) {
        Map<String, String> params = new HashMap<>();
        params.put("q", cityName);
        params.put("units", "metric");
        params.put("lang", "en");
        params.put("appid", appid);

        String response = httpClient.get(url, Map.of(), params);

        save(userLogin, cityName);

        JSONObject jsonObject = new JSONObject(response);

        return String.valueOf(jsonObject.getJSONObject("main").getDouble("temp"));
    }

    @Override
    public List<WeatherAttempt> getAll() {
        return weatherDao.getAll();
    }

    @Override
    public void save(String userLogin, String city) {
        weatherDao.save(
                new WeatherAttempt(
                        userLogin,
                        city
                )
        );
    }
}
