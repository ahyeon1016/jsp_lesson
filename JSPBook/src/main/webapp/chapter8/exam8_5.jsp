<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>회원가입</h3>
	<form action="8_5" method="post" name="memberForm">
		<p> 아이디 : <input type="text" name="id" id="id"> 
		<p> 비밀번호 : <input type="password" name="pwd" id="pwd">
		<p> 이름 : <input type="name" name="name" id="name">
		<p> 연락처 : <select name="phone1" id="p1">
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="016">016</option>
			<option value="017">017</option>
			</select>
			 - <input type="text" maxlength="4" size="4" name="phone2" id="p2"> 
			 - <input type="text" maxlength="4" size="4" name="phone3" id="p3">
		<p> 이메일 : <input type="text" name="email" id="email">
		<p> <input type="button" value="가입하기" id="btn">
	</form>
	
	<script type="text/javascript">
		var btn = document.querySelector("#btn");
		btn.addEventListener("click", checkMember);
		 
		function checkMember() {
			console.log("함수 도착");
		
			var regExpId= /^[a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
			var regExpName= /^[가-힣]*$/;
			var regExpPwd= /^[0-9]*$/;
			var regExpPhone= /^\d{3}-\d{3,4}-\d{4}$/;
			var regExpEmail= /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		
			var form = document.memberForm;
			
			var id = document.querySelector("#id").value;
			var pwd = document.querySelector("#pwd").value;
			var name = document.querySelector("#name").value;
			var p1 = document.querySelector("#p1").value;
			var p2 = document.querySelector("#p2").value;
			var p3 = document.querySelector("#p3").value;
			var phone = (p1+"-"+p2+"-"+p3);
			var email = document.querySelector("#email").value;
			
			console.log("p1,p2,p3 : "+p1+" "+p2+" "+p3);
			console.log("아이디 : "+id+"\n비밀번호 : "+pwd+"\n이름 : "+name+"\n전화번호 : "+phone+"\n이메일 :"+email);
			
			if(!regExpId.test(id)){
				alert("아이디는 문자로 시작해 주세요.");
				form.id.select();
				return;
			}
			console.log("아이디 통과");
			
			if(!regExpPwd.test(pwd)){
				alert("비밀번호는 숫자만 입력해 주세요.");
				form.pwd.select();
				return;
			}
			console.log("비밀번호 통과");
			
			if(!regExpName.test(name)){
				alert("이름은 한글만 입력해 주세요");
				form.name.select();
				return;
			}
			console.log("이름 통과");
			
			if(!regExpPhone.test(phone)){
				alert("연락처 입력을 확인해 주세요.");
				return;
			}
			console.log("전화번호 통과");
			
			if(!regExpEmail.test(email)){
				alert("이메일 입력을 확인해 주세요.");
				form.email.select();
				return;
			}
			console.log("이메일 통과");
			alert("입력 완료");
			form.submit();

		}
	
		
	</script>
</body>
</html>