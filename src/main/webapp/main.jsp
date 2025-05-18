<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<!DOCTYPE html>
<html>
<head>
    <title>Главная</title>
</head>
<body>
<h2>Добро пожаловать, <a href="account">${viewModel.username}</a>!</h2>

<form action="check" method="get">
    <button type="submit">Выполнить проверку</button>
</form>

<h3>Список проверок:</h3>

<c:choose>
    <c:when test="${not empty viewModel.moleCheck}">
        <ul style="list-style-type:none; padding-left:0; margin-left:0;">
            <c:forEach var="check" items="${viewModel.moleCheck}">
                <hr>
                <div style="margin-bottom: 20px;">
                    <img src="${check.imagePath}" alt="Фото" width="200" /><br>
                    <p>Уровень риска: <fmt:formatNumber value="${check.risk * 100}" maxFractionDigits="2" />%</p>

                    <form action="check-info" method="post">
                        <input type="hidden" name="checkId" value="${check.moleId}" />
                        <button type="submit">Показать дополнительную информацию</button>
                    </form>
                </div>
            </c:forEach>

        </ul>
    </c:when>
    <c:otherwise>
        <p>Проверки отсутствуют.</p>
    </c:otherwise>
</c:choose>
</body>
</html>
