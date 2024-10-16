<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Scripting Tag</title>
</head>
<body>
	<h1>예제 실습</h1>
	<hr>
	<a href="2_1">예제 2_1</a>
	<a href="2_2">예제 2_2</a>
	<a href="2_3">예제 2_3</a>
	<a href="2_4">예제 2_4</a>
	<a href="2_5">예제 2_5</a>
	<a href="2_6">예제 2_6</a>
	<a href="2_7">예제 2_7</a>
	<a href="2_8">예제 2_8</a>
	<hr>
	<a href="3_1">예제 3_1</a>
	<a href="3_2">예제 3_2</a>
	<a href="3_3">예제 3_3</a>
	<a href="3_4">예제 3_4</a>
	<a href="3_6">예제 3_6</a>
	<a href="3_7">예제 3_7</a>
	<a href="3_9">예제 3_9</a>
	<a href="3_10">예제 3_10</a>
	<a href="3_11">예제 3_11</a>
	<hr>
	<a href="4_1">예제 4_1</a>
	<a href="4_2">예제 4_2</a>
	<a href="4_3">예제 4_3</a>
	<a href="4_4">예제 4_4</a>
	<a href="4_5">예제 4_5</a>
	<a href="4_6">예제 4_6</a>
	<a href="4_7">예제 4_7</a>
	<a href="4_9">예제 4_9</a>
	<a href="4_10">예제 4_10</a>
	<a href="4_11">예제 4_11</a>
	
	<br>
	<a href="BookMarket">북 마켓</a>
	<br><br>
	
	<form action="4_0" method="get">
		<input type="text" name="id" /><br>
		<input type="text" name="name"/><br>
		<input type="submit" value="전송"></input>
	</form>
	<% 
		String id = "AGH";
		String name ="HYEON";
	%>
	<p><a href="4_0?id=<%=id%>&name=<%=name%>">예제 4_0</a><p>
	<hr>
	<form action="5_1">
		<p> 아 이 디 : <input type="text" name="id" placeholder="아이디를 입력하세요.">
		<p> 비밀번호 : <input type="text" name="passwd" placeholder="비밀번호를 입력하세요.">
		<p> <input type="submit" value="전송">
	</form>
	<hr>
	<a href="5_2">예제 5_2</a>
	<a href="5_3">예제 5_3</a>
	<a href="5_4">예제 5_4</a>
	<a href="5_5">예제 5-5</a>
	<a href="5_7">예제 5-7</a>
	<a href="5_8">예제 5-8</a>
	 <hr>
	
	<a href="6_1">예제 6-1</a>
	<a href="6_2">예제 6-2</a>
	<a href="6_3">예제 6-3</a>
	<a href="6_6">예제 6_6</a>
	
	<hr>
	
	<a href="7_1">예제 7_1</a>
	<a href="7_1_연습">예제 7_1_연습</a>
	<a href="7_1_t">예제 7_1_t</a>
	<a href="7_2">예제 7_2</a>
	<a href="7_3">예제 7_3</a>
	<a href="7_4">예제 7_4</a>
	
	<hr>
	
	<a href="8_1">예제 8_1</a>
	<a href="8_2">예제 8_2</a>
	<a href="8_3">예제 8_3</a>
	
</body>
</html>