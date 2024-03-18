<%@page import="java.util.*"%>
<%@page import="com.javaee.entity.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- taglib：引入标签库    uri：标签库地址   prefix：为标签库取别名，此名称可以在当前页面使用-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
 #myDiv{
	text-align: center;
 }
</style>
<title>JSTL常用标签</title>
</head>
<body>
<div id="myDiv">
<!-- 1、Set标签:设置指定范围内的变量值 -->
	<h3>1、Set标签:设置指定范围内的变量值</h3>
	<!-- 在page作用域添加名称为a，值为hello的数据 -->
	<c:set var="a" value="hello" scope="page"></c:set>
	${pageScope.a }
	<br>
	<!-- 在session作用域存储名称为b，值为hello的数据   var:指定存储的名称，value：指定存储的值
		scope：指定存储的作用域，不写则默认为page作用域
	 -->
	<c:set var="b" value="hello" scope="session"></c:set>
	${sessionScope.b }
	<br>
	<%
		//绑定数据到request对象
		User user = new User();
		request.setAttribute("user", user);
	%>
	<!-- 将value值设置到user对象的username属性中 -->
	<c:set target="${user}" property="username" value="defaultName" />
	
<!--2、Out标签：计算表达式并将结果输出显示 -->
	<h3>2、Out标签：计算表达式并将结果输出显示</h3>
	<c:out value="${user.username }" default="noUserName"></c:out>
	
	<!-- out标签的转义字符 -->
	<p>${"<a href='http://www.baidu.com'>百度</a>"}</p>
	<p>
		<c:out escapeXml="false" value="<a href='http://www.baidu.com'>百度</a>" />
	</p>
	<c:out value="<a href='http://www.baidu.com'>百度</a>" /><br>

<!-- 3、remove标签 -->
	<h3>3、remove标签</h3>
	<!-- 设置之前应该是空值 -->
	1、设置变量之前的值是：msg=<c:out value="${msg}" default="null"/><br>
	<!-- 给变量msg设值 -->
	<c:set var="msg" value="Hello woniu!" scope="page"></c:set>
	<!-- 此时msg的值应该是上面设置的"已经不是空值了" -->
	2、设置新值以后：msg=<c:out value="${msg}"></c:out><br>
	<!-- 把 msg变量从page范围内移除-->
	<c:remove var="msg" scope="page"/>
	<!-- 此时msg的值应该显示null -->
	3、移除变量msg以后：msg=<c:out value="${msg}" default="null">
	</c:out><br>

<!-- 4、if标签 -->
	<h3>4、if标签</h3>
	${name }是一个
	<!-- test:表示一个boolean值，var：指定一个变量存储test的计算结果
		 此变量可与通过EL表达式获取，如下代码就是通过这种方式构造一个if  else 结构
	 -->
	<c:if test="${age>25 }" var="is">
		青年人
	</c:if>
	<c:if test="${!is }">
	 	少年人
	</c:if>
	
<!-- 5、choose标签 -->
	<h3>5、choose标签</h3>
	<c:choose>
		<c:when test="${age>25 }">太老</c:when>
		<c:when test="${age==25 }">刚刚好</c:when>
		<c:otherwise>太小</c:otherwise>
	</c:choose>
<!-- 6、Foreach：用于替换jsp中所有的循环代码（最常用）-->
 	<h3>6、Foreach：用于替换jsp中所有的循环代码（最常用）</h3>
<%--  <c:forEach begin="开始位置" end="结束位置" items="目标items" step="步进" 
 var="遍历变量" varStatus="迭代信息" >循环体</c:forEach> --%>
	<br>
	<%
		List<User> users = new ArrayList<>();
		for(int i = 1; i<=5; i++){
			User e = new User("a"+i, ""+i);
			users.add(e);
		}
		request.setAttribute("users", users);
	%>
	<h4>（1）循环输出集合users对象里面的数据</h4>
	<c:forEach  items="${users }" var="user" >
    循环体${user.username }<br>
    </c:forEach>
    <br>
    <h4>（2）循环输出数据</h4>
	<c:forEach var="i" begin="1" end="5">
   	Item <c:out value="${i}"/><p>
	</c:forEach>
</div>
</body>
</html>