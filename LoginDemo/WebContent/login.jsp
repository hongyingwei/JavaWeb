<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>

<!-- 简单的登录页面 -->
<form action="login" method="post">
    用户名：
    <input name="username"/>
    <span style="color:red">${msg}</span>
    <br>
    密 &nbsp;&nbsp;&nbsp;码：
    <input name="password" type="password"/><br>
    <input type="submit" value="登录"/><a href="register.jsp">注册</a>
</form>

</body>
</html>
