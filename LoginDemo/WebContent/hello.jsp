<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
	<div>计算两数之和</div>
	<!-- 计算的小脚本： -->
	<%
	int a = 10;
	int b = 20;
	int result = a + b;
	%>
	计算结果：打印result =
	<%=result%><br> 声明函数：<%!public int add(int a, int b) {
		return a + b;
	}%>
	调用函数计算a+b=<%
	out.println(add(20, 20));
	%>
	求素数之和：<%
	int sum = 0, j;
	for(int i = 1; i<=100; i++){
		for(j = 2; j<i; j++){
			if(i % j == 0)
				break;
		}
		if(i == j){
			sum += i;
		}
	}
	out.println(sum);
	%>
</body>
</html>