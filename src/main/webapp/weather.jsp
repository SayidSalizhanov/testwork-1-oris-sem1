<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Weather</title>
</head>
<body>

<form method="POST" action="/weather">
    <label for="town">Город: </label>
    <input type="text" id="town" name="town" required>

    <button type="submit">Узнать погоду</button>
</form>

<c:if test="${not empty temperature}">
    <h3>Температура: ${temperature}</h3>
</c:if>

</body>
</html>
