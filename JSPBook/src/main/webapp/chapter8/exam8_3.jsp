<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="8_3" name="loginForm" method="post">
		<p>이름    : <input type="text" name="name" id="name">
		<p>아 이 디 : <input type="text" name="id" id="id" placeholder="4~12자 이내로 입력해주세요.">
		<p>비밀번호 : <input type="password" name="pwd" id="pwd" placeholder="4자 이상으로 입력해 주세요.">
		<p><input type="button" value="전송" id="btn">
	</form>
	
	<script type="text/javascript">
		var btn = document.querySelector("#btn");
		btn.addEventListener("click", checkLogin);
		
		function checkLogin() {
			console.log("함수 도착");
			var form = document.loginForm;
			
			var name = document.querySelector("#name").value;
			var id = document.querySelector("#id").value;
			var pwd = document.querySelector("#pwd").value;
			
			console.log("이름 : "+name+" /아이디 : "+id+" /비밀번호 : "+pwd);
			console.log("이름 : "+name.substr(0,1)+" /아이디 : "+id.length+" /비밀번호 : "+pwd.length);
			
			if(!isNaN(name.substr(0,1))){
				alert("이름은 숫자로 시작할 수 없습니다.");
				form.name.select();
				return;
			}
			
			if(id.length<4 || id.length>12){
				alert("아이디는 4~12자 이내로 입력 가능합니다.");
				form.id.select();
				return;
			}
			
			if(pwd.length<4){
				alert("비밀번호는 4자 이상으로 입력해야 합니다.");
				form.pwd.select();
				return;		
			}

			form.submit();
		}
	
	
	</script>
</body>
</html>