<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		<div>
			用户名：<input name="username" type="text" /><span style="color:red"><%=session.getAttribute("msg")%></span>
			<br>密&nbsp;&nbsp;码：<input type="password" name="password" /><br><span style="color:red">${msg}</span>
			<input type="submit" value="登录" />
		</div>
	</form>
	
</body>
</html>