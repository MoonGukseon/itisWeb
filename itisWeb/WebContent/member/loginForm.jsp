<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ITIS 로그인 페이지</title>
<script type="text/javascript">
	function inputCheck(){
		if(document.loginform.MEMBER_ID.value==""){
			alert("input the ID");
			document.loginform.id.focus();
			return;
		}
		if(document.loginform.MEMBER_PW.value==""){
			alert("Enter your password");
			document.loginform.pass.focus();
			return;
		}
		
		document.loginform.submit();
	}
	
</script>
</head>
<body>
	<form name="loginform" action="../MemberLoginAction.me" method="post">
		<center>
			<table border=1>
				<tr>
					<td colspan="2" align=center>
						<b><font size=5>로그인 페이지</font></b></td>
				</tr>
					<tr><td>아이디:</td><td><input type="text" name="MEMBER_ID"/></td></tr>
					<tr><td>비밀번호:</td><td><input type="password" name="MEMBER_PW"/></td></tr>
				<tr>
					<td colspan="2" align=center>
						<input type="button" value="log in" onClick="inputCheck()">&nbsp;&nbsp;
						<a href="../MemberJoin.me">회원가입</a>
					</td>
				</tr>
			</table>
		</center>
	</form>
</body>
</html>