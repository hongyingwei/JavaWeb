<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>首页</title>
</head>
<body>

Welcome, ${sessionScope.username}！
<a href="logout">退出登录</a>
<a href="destroyUser">注销</a>
</body>
</html>
