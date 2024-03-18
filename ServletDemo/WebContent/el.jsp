<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL表达式</title>
</head>
<body>
	EL表达式计算：<br>
	<!-- 加运算 -->
	&nbsp;&nbsp;&nbsp;1、${3+1} <br>
	<!-- 或运算 -->
	&nbsp;&nbsp;&nbsp;2、${true || false }<br>
	<!-- 三目运算 -->
	&nbsp;&nbsp;&nbsp;3、${1==1?"张三":"李四"}<br>
	EL表达式接收前端参数：<br>
	&nbsp;&nbsp;&nbsp;${param.uname }<br>
	EL表达式获取request作用域数据：<br>
	<!--${requestScope.msg }相当于< %=session.getAttribute("msg") %>-->
	&nbsp;&nbsp;&nbsp;${requestScope.msg }<br>
	EL表达式获取request作用域数据简单写法：<br>
	&nbsp;&nbsp;&nbsp;${msg }<br>
	
	EL表达式获取JavaBean对象的属性值：<br>
	&nbsp;&nbsp;&nbsp;${user.username }<br>
	
	EL表达式获取Map集合的值：<br>
	<!-- 获取map中的数据，通过键获取值，键不存在则不显示  -->
	&nbsp;&nbsp;&nbsp;我叫${map.name},今年${map.age }岁了 ${map.sex }<br>
	<!-- 获取list中的数据，通过下标获取，下标不存在则不显示，不会抛出异常-->
	EL表达式获取List集合的值：<br>
	${list[0] }、${list[1] }、${list[2]}<br>
</body>
</html>