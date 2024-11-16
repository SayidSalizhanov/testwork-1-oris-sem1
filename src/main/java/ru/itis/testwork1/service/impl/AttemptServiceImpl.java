package ru.itis.testwork1.service.impl;

import ru.itis.testwork1.dao.AttemptDao;
import ru.itis.testwork1.dto.AttemptDto;
import ru.itis.testwork1.dao.impl.AttemptDaoImpl;
import ru.itis.testwork1.entity.Attempt;
import ru.itis.testwork1.service.AttemptService;

import java.time.LocalDateTime;
import java.util.List;

public class AttemptServiceImpl implements AttemptService {
    private final AttemptDao attemptDao = new AttemptDaoImpl();

    @Override
    public AttemptDto get(Integer id) {
        Attempt attempt = attemptDao.get(id);

        return new AttemptDto(
                attempt.getLogin(),
                attempt.getTime().toString(),
                attempt.getStatus().toString()
        );
    }

    @Override
    public AttemptDto getByLogin(String login) {
        Attempt attempt = attemptDao.getByLogin(login);

        return new AttemptDto(
                attempt.getLogin(),
                attempt.getTime().toString(),
                attempt.getStatus().toString()
        );
    }

    @Override
    public List<AttemptDto> getAll() {
        List<Attempt> attempts = attemptDao.getAll();

        return attempts.stream()
                .map(a -> new AttemptDto(a.getLogin(), a.getTime().toString(), a.getStatus().toString()))
                .toList();
    }

    @Override
    public void save(String login, Boolean status) {
        attemptDao.save(
                new Attempt(
                        null,
                        login,
                        LocalDateTime.now(),
                        status
                )
        );
    }
}
