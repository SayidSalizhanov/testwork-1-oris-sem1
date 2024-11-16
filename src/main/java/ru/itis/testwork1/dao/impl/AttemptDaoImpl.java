package ru.itis.testwork1.dao.impl;

import ru.itis.testwork1.dao.AttemptDao;
import ru.itis.testwork1.entity.Attempt;
import ru.itis.testwork1.util.DatabaseConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttemptDaoImpl implements AttemptDao {
    private final Connection connection = DatabaseConnectionUtil.getConnection();

    @Override
    public Attempt get(Integer id) {
        try {
            String sql = "select * from attempts where id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null) {
                resultSet.next();
                return new Attempt(
                        resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getTimestamp("time").toLocalDateTime(),
                        resultSet.getBoolean("status")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public Attempt getByLogin(String login) {
        try {
            String sql = "select * from attempts where login = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, login);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet != null) {
                resultSet.next();
                return new Attempt(
                        resultSet.getInt("id"),
                        resultSet.getString("login"),
                        resultSet.getTimestamp("time").toLocalDateTime(),
                        resultSet.getBoolean("status")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public List<Attempt> getAll() {
        try {
            Statement statement = connection.createStatement();
            String sql = "select * from attempts";
            ResultSet resultSet = statement.executeQuery(sql);
            List<Attempt> attempts = new ArrayList<>();
            if (resultSet != null) {
                while (resultSet.next()) {
                    attempts.add(
                            new Attempt(
                                    resultSet.getInt("id"),
                                    resultSet.getString("login"),
                                    resultSet.getTimestamp("time").toLocalDateTime(),
                                    resultSet.getBoolean("status")
                            )
                    );
                }
            }
            return attempts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Attempt attempt) {
        String sql = "insert into attempts (login,time,status) values (?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, attempt.getLogin());
            statement.setTimestamp(2, Timestamp.valueOf(attempt.getTime()));
            statement.setBoolean(3, attempt.getStatus());

            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
