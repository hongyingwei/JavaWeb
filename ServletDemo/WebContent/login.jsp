<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<<<<<<< HEAD
<title>Insert title here</title>
</head>
<body>
	<!-- 创建一个简单的登录页面 -->
	<form action="/ServletDemo/login" method="post">
		<div>
			用户名：<input name="username" /><span style="color:red"><%=request.getAttribute("msg")%></span>
			<br> 密&nbsp;&nbsp;&nbsp;码：<input name="password" /><span style="color:red">${msg}</span>
			<br><input type="submit" value="登录">
		</div>
=======
<title>登录页面</title>
</head>
<body>
	<!-- 简单的登录页面 -->
	<form action="login" method="post">
		用户名：<input name="username"><span style="color:red">${msg }</span><br>
		密 &nbsp;&nbsp;&nbsp;码：<input name="password" type="password"><br>
		<input type="submit" value="登录">
>>>>>>> branch 'master' of git@github.com:hongyingwei/JavaWeb.git
	</form>

</body>
</html>