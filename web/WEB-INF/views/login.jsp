<%--
  Created by IntelliJ IDEA.
  User: TarasovaYuliya
  Date: 29.02.2020
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Вход в систему</title>
</head>
<body>
<p>Today <%= new java.util.Date() %>
</p>
<p><font color="red">${errorMessage}</font></p>
<form action="LoginServlet" method="POST">
    <p>Вход в систему</p>
    <table border="0">
        <tr>
            <td>Пользователь:</td>
            <td><input type="text" name="name"/></td>
        </tr>
        <tr>
            <td>Пароль:</td>
            <td><input type="password" name="password"></td>
        </tr>
    </table>

    <p><input type="submit" value="Войти"/></p>
</form>
<div>
    <form action="RegisterServlet" method="GET">
        <input class="button-main-page" type="submit" value="Регистрация"/>
    </form>
</div>
</body>
</html>
