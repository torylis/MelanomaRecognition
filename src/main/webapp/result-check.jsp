<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
  <title>Результат проверки</title>
</head>
<body>
<h2>Проверка выполнена!</h2>

<p>Уровень риска:
  <strong>
    <fmt:formatNumber value="${viewModel.riskLevel * 100}" type="number" maxFractionDigits="2" />%
  </strong>
</p>

<a href="main">← На главную страницу</a>
</body>
</html>
