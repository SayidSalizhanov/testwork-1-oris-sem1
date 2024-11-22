package ru.itis.testwork1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherAttempt {
    private int id;
    private String userLogin;
    private String city;

    public WeatherAttempt(String userLogin, String city) {
        this.userLogin = userLogin;
        this.city = city;
    }
}
