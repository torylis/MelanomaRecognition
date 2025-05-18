<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>Проверка</title>
</head>
<body>
<h2>Проверка родинки</h2>

<img src="${viewModel.imagePath}" alt="Фото родинки" width="300"/>
<p>Дата проверки: ${viewModel.date}</p>
<p>Уровень риска: <fmt:formatNumber value="${viewModel.risk * 100}" maxFractionDigits="2" />%</p>
<p>Местоположение:
  <c:choose>
    <c:when test="${viewModel.location == 'torso'}">туловище</c:when>
    <c:when test="${viewModel.location == 'lower extremity'}">нога</c:when>
    <c:when test="${viewModel.location == 'upper extremity'}">рука</c:when>
    <c:when test="${viewModel.location == 'head/neck'}">голова / шея</c:when>
    <c:when test="${viewModel.location == 'palms/soles'}">ладонь / стопа</c:when>
    <c:otherwise>${viewModel.location}</c:otherwise>
  </c:choose>
</p>

<form action="delete-check" method="post">
  <input type="hidden" name="checkId" value="${viewModel.moleId}" />
  <button type="submit">Удалить проверку</button>
</form>

<p><a href="main">Вернуться на главную страницу</a></p>
</body>
</html>