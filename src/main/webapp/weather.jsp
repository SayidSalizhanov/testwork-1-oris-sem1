<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Weather</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script>
        $(document).on("click", "#ajax-button", function() {
                $.get("/weather?town=" + $("#town").val(), function (response){
                    $("#ajax-response").text(response)
                })
            }
        )
    </script>
</head>
<body>

<form>
    <label for="town">Город: </label>
    <input type="text" id="town" name="town" required>

    <input type="button" id="ajax-button" value="Узнать погоду">
</form>

<div id="ajax-response">

</div>

<%--<form method="POST" action="/weather">--%>
<%--    <label for="town">Город: </label>--%>
<%--    <input type="text" id="town" name="town" required>--%>

<%--    <button type="submit">Узнать погоду</button>--%>
<%--</form>--%>

<%--<c:if test="${not empty temperature}">--%>
<%--    <h3>Температура: ${temperature}</h3>--%>
<%--</c:if>--%>

</body>
</html>
