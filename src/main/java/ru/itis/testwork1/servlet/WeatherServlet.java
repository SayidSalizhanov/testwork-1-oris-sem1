package ru.itis.testwork1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.itis.testwork1.service.WeatherService;
import ru.itis.testwork1.service.impl.WeatherServiceImpl;

import java.io.IOException;

@WebServlet("/weather")
public class WeatherServlet extends HttpServlet {
    private final WeatherService weatherService = new WeatherServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String city = req.getParameter("town");
        String apiKey = "ec6ae61f58c44f36d3bd7d4f99c9993a";

        if (city == null || city.isEmpty()) {
            req.getRequestDispatcher("weather.jsp").forward(req, resp);
        }
        else {
            String temperature = weatherService.getWeather((String) req.getSession().getAttribute("login"), city, apiKey);
            resp.setContentType("text/plain");
            resp.getWriter().write(String.format("Temperature: %s", temperature));
        }
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String city = req.getParameter("town");
//        String apiKey = "ec6ae61f58c44f36d3bd7d4f99c9993a";
//
//        String temperature = weatherService.getWeather((String) req.getSession().getAttribute("login"), city, apiKey);
//
//        req.setAttribute("temperature", temperature);
//        req.getRequestDispatcher("weather.jsp").forward(req, resp);
//    }
}
