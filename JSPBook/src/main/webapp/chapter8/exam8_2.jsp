<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="8_2" name="loginForm" method="post">
		<p>아 이 디 : <input type="text" name="id" id="id">
		<p>비밀번호 : <input type="password" name="pwd" id="pwd">
		<p><input type="button" value="전송" id="btn">
	</form>
	
	<script type="text/javascript">
		var btn = document.querySelector("#btn");
		btn.addEventListener("click", checkLogin);
		
		function checkLogin() {
			console.log("함수 도착");
			var id = document.querySelector("#id").value;
			var pwd = document.querySelector("#pwd").value;
			console.log(id+" "+pwd);
			
			var form = document.loginForm;
			if(id==""){
				alert("아이디를 입력해 주세요.");
				form.id.focus();
				return false;
			} else if(pwd==""){
				alert("비밀번호를 입력해 주세요.");
				form.pwd.focus();
				return false;
			}
			console.log("if문 빠져나옴");
			form.submit();
		}
	</script>
</body>
</html>