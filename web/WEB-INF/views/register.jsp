<%--
  Created by IntelliJ IDEA.
  User: TarasovaYuliya
  Date: 14.03.2020
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация нового пользователя</title>
</head>
<body>
<p><font color="red">${errorRegister}</font></p>
<form action="RegisterServlet" method="POST">
    <p> Регистрация нового пользователя </p>
    <table border="0">
        <tr>
            <td>Введите имя:</td>
            <td><input name="newLoginName" type="text"/></td>
        </tr>
        <tr>
            <td>Введите пароль:</td>
            <td><input name="newPassword" type="password"/></td>
        </tr>
    </table>
    <p><input class="button-main-page" type="submit" value="Зарегистрировать"/></p>
</form>
</body>
</html>
