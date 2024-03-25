<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册页面</title>
</head>
<body>
<form action="register" method="post">
    用户名：
    <input name="username"/><br>
    昵&nbsp;&nbsp;&nbsp;称：<input name="nickName"/>
    <br>
    密&nbsp;&nbsp;&nbsp;码：
    <input name="password"/><br>
    <input type="submit" value="注册"/><span style="color:red">${msg }</span>
</form>
</body>
</html>