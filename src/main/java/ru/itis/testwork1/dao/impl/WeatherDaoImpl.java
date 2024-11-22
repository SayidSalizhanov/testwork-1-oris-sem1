package ru.itis.testwork1.dao.impl;

import ru.itis.testwork1.dao.WeatherDao;
import ru.itis.testwork1.entity.WeatherAttempt;
import ru.itis.testwork1.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WeatherDaoImpl implements WeatherDao {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    public List<WeatherAttempt> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from weather_attempts";
            ResultSet resultSet = statement.executeQuery(sql);
            List<WeatherAttempt> weatherAttempts = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    weatherAttempts.add(
                            new WeatherAttempt(
                                    resultSet.getInt("id"),
                                    resultSet.getString("user_login"),
                                    resultSet.getString("city")
                            )
                    );
                }
            }
            return weatherAttempts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(WeatherAttempt weatherAttempt) {
        String sql = "insert into weather_attempts (user_login, city) values (?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, weatherAttempt.getUserLogin());
            statement.setString(2, weatherAttempt.getCity());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
