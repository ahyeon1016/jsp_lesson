<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String id = (String) request.getAttribute("id");
		String pwd = (String) request.getAttribute("pwd");
		
		if(id.equals("admin") && pwd.equals("1234")){
			Cookie cookie_id = new Cookie("id", id);
			Cookie cookie_pwd = new Cookie("pwd", pwd);
			response.addCookie(cookie_id);
			response.addCookie(cookie_pwd);
			out.print("쿠키 생성이 성공했습니다<br>");
			out.print(id+"님 환영합니다.");
		} else{
			out.print("쿠키 생성에 실패했습니다.");
		}
	%>
</body>
</html>