<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>hello,你好啊</div>
	<!-- <div>你好啊</div>
	<div>hello,fnajkfha你好啊</div> -->
	<%
		int a = 10, j;
		int b = 10;
		int sum = 0;
		for(int i = 1; i<=100; i++){
			for(j = 2; j<i; j++){
				if(i % j == 0){
					break;
				}
			}
			if(i == j){
				sum += i;
			}
		}
		out.println(sum);
	%>
	所有素数之和：<%=sum%><br>
	<%!
	public int fun(){
		int j;
		int sum = 0;
		for(int i = 1; i<=100; i++){
			for(j = 2; j<i; j++){
				if(i % j == 0){
					break;
				}
			}
			if(i == j){
				sum += i;
			}
		}
		return sum;
	}
	%>
	用函数的方式把所有的素数相加：<%=fun()%><br>
	用out输出结果：<%out.println(fun());%>
</body>
</html>