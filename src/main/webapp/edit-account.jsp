<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Редактирование аккаунта</title>
</head>
<body>
<h2>Редактировать данные аккаунта</h2>

<c:if test="${not empty viewModel}">
    <form action="edit-account" method="post">
        <label for="username">Имя пользователя:</label><br/>
        <input type="text" id="username" name="username" value="${viewModel.username}" required/><br/><br/>

        <label for="gender">Пол:</label><br/>
        <select id="gender" name="gender" required>
            <option value="male" <c:if test="${viewModel.gender == 'Мужской'}">selected</c:if>>Мужской</option>
            <option value="female" <c:if test="${viewModel.gender == 'Женский'}">selected</c:if>>Женский</option>
        </select><br/><br/>

        <label for="birthdate">Дата рождения:</label><br/>
        <input type="date" id="birthdate" name="birthdate" value="${viewModel.birthdate}" required/><br/><br/>

        <input type="submit" value="Сохранить изменения"/>
    </form>
</c:if>

<c:if test="${empty viewModel}">
    <p>Ошибка загрузки данных пользователя.</p>
</c:if>

<br/>
<a href="account">← Назад</a>
</body>
</html>
