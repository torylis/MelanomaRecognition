<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Аккаунт</title>
</head>
<body>
<h2>Данные аккаунта</h2>

<c:choose>
    <c:when test="${not empty viewModel}">
        <p><strong>Имя:</strong> ${viewModel.username}</p>
        <p><strong>Пол:</strong>
            <c:if test="${viewModel.gender == 'male'}">мужской</c:if>
            <c:if test="${viewModel.gender == 'female'}">женский</c:if>
        </p>
        <p><strong>Дата рождения:</strong> ${viewModel.birthdate}</p>

        <a href="edit-account">Изменить данные</a>
        <br>
        <br>
    </c:when>
    <c:otherwise>
        <p>Информация недоступна.</p>
    </c:otherwise>
</c:choose>

<a href="main">← Назад</a>
</body>
</html>
