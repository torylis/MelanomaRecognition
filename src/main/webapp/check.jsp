<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Новая проверка</title>
</head>
<body>
<h2>Проверить родинку</h2>

<form action="check" method="post" enctype="multipart/form-data">
    <label for="photo">Загрузите фото:</label><br>
    <input type="file" name="photo" id="photo" accept="image/*" required><br><br>

    <label for="location">Расположение родинки:</label><br>
    <select name="location" id="location" required>
        <option value="torso">Туловище</option>
        <option value="lower extremity">Нога</option>
        <option value="upper extremity">Рука</option>
        <option value="head/neck">Голова / шея</option>
        <option value="palms/soles">Ладонь / стопа</option>
    </select><br><br>

    <button type="submit">Выполнить проверку</button>
</form>

<br>

<a href="main">← Отмена</a>

</body>
</html>

