<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="8_4" name="loginForm" method="post">
		<p>아 이 디 : <input type="text" name="id" id="id" placeholder="영소문자만 입력해 주세요.">
		<p>비밀번호 : <input type="password" name="pwd" id="pwd" placeholder="숫자만 입력해 주세요.">
		<p><input type="button" value="전송" id="btn">
	</form>
	
	<script type="text/javascript">
		var btn = document.querySelector("#btn");
		btn.addEventListener("click", checkLogin);
		
		function checkLogin() {
			var form = document.loginForm;
			
			var id = document.querySelector("#id").value;
			var pwd = document.querySelector("#pwd").value;
			console.log("아이디 : "+id+" /비밀번호 : "+pwd);
			
			var ch;
			for(i=0; i<id.length; i++){
				ch = id.charAt(i);
				console.log(ch);
				if( (ch<'a' || ch>'z') && (ch>'A' || ch<'Z') && (ch>'0' || ch<'9') ){
					alert("아이디는 소문자만 입력 가능합니다");
					form.id.select();
					return;
				}
			}
			
			console.log("아이디 통과");
			
			if(isNaN(pwd)){
				alert("비밀 번호는 숫자만 입력 가능합니다.");
				form.pwd.select();
				return;
			}
			
			console.log("비밀번호 통과");
			alert("입력이 완료되었습니다.");
			form.submit();
			
		}
	</script>
</body>
</html>