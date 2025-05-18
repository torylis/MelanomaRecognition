<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Вход</title>
</head>
<body>
<h1>Вход в систему</h1>

<form action="login" method="post">
    Логин: <input type="text" name="login" required><br><br>
    Пароль: <input type="password" name="password" required><br><br>
    <input type="submit" value="Войти">
</form>

<c:if test="${not empty param.error}">
    <c:choose>
        <c:when test="${param.error == 'invalidLogin'}">
            <p style="color: red;">Неверный логин!</p>
        </c:when>
        <c:when test="${param.error == 'invalidPassword'}">
            <p style="color: red;">Неверный пароль!</p>
        </c:when>
        <c:otherwise>
            <p style="color: red;">Неизвестная ошибка.</p>
        </c:otherwise>
    </c:choose>
</c:if>

<p>Нет аккаунта? <a href="register">Зарегистрируйтесь</a></p>

</body>
</html>
