<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form name="login_form" action="#">
		아 이 디 : <input type="text" name="id" id="id" ><br><br>
		비밀번호 : <input type="password" name="pwd" id="pwd"><br><br>
		<input type="submit" value="전송" id="submit">
	</form>
	
	<script type="text/javascript">
	var submit = document.querySelector("#submit");
	submit.addEventListener("click", checkForm);
	function checkForm(){
		var id = document.querySelector("#id").value;
		var pwd = document.querySelector("#pwd").value;
		console.log("id : "+id+"\n"+"pwd : "+pwd);
		alert("입력한 값 : \n"+id+"\n"+pwd);
	}
	</script>
</body>
</html>