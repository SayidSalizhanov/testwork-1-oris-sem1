package ru.itis.testwork1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ru.itis.testwork1.dto.UserLoginDto;
import ru.itis.testwork1.entity.User;
import ru.itis.testwork1.service.AttemptService;
import ru.itis.testwork1.service.UserService;
import ru.itis.testwork1.service.impl.AttemptServiceImpl;
import ru.itis.testwork1.service.impl.UserServiceImpl;
import ru.itis.testwork1.util.PasswordUtil;

import java.io.IOException;

@WebServlet("/")
public class LoginServlet extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    private final AttemptService attemptService = new AttemptServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("index.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        UserLoginDto userLoginDto = userService.getLoginDto(login);

        if (userLoginDto.getPassword().equals(PasswordUtil.encrypt(password))) {

            HttpSession session = req.getSession();
            session.setAttribute("login", login);
            session.setMaxInactiveInterval(60 * 60);

            attemptService.save(login, true);

            resp.sendRedirect("/profile");

        } else {

            attemptService.save(login, false);

            resp.sendRedirect("/");
        }
    }
}
