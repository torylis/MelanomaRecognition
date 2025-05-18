<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Регистрация</title>
</head>
<body>
<h2>Регистрация</h2>

<c:if test="${param.error == 'loginExists'}">
    <p style="color:red;">Логин уже существует!</p>
</c:if>

<form action="register" method="post">
    Логин: <input type="text" name="login" required><br><br>
    Пароль: <input type="password" name="password" required><br><br>
    Имя пользователя: <input type="text" name="username" required><br><br>
    Дата рождения: <input type="date" name="birthdate" required><br><br>
    Пол:
    <select name="gender" required>
        <option value="male">Мужской</option>
        <option value="female">Женский</option>
    </select><br><br>
    <input type="submit" value="Зарегистрироваться">
</form>
</body>
</html>
