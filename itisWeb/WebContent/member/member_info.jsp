<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="member.db.*" %>
<%
	MemberBean member=(MemberBean)request.getAttribute("member");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>회원관리 시스템 관리자모드(회원 정보 보기)</title>
</head>
<body>
<center>
<table border=1 width=300>
	<tr align=center>
		<td>아이디: </td>
		<td><%=member.getMEMBER_ID() %></td>
	</tr>
	<tr align=center>
		<td>이름: </td>
		<td><%=member.getMEMBER_NAME() %></td>
	</tr>
	<tr align=center>
		<td>나이: </td>
		<td><%=member.getMEMBER_AGE() %></td>
	</tr>
	<tr align=center>
		<td>성별: </td>
		<td><%=member.getMEMBER_SEX() %></td>
	</tr>
	<tr align=center>
		<td>전화번호: </td>
		<td><%=member.getMEMBER_PHONE() %></td>
	</tr>
	<tr align=center>
		<td>이메일: </td>
		<td><%=member.getMEMBER_EMAIL() %></td>
	</tr>
	<tr align=center>
		<td>주소: </td>
		<td><%=member.getMEMBER_ADDRESS() %></td>
	</tr>
	<tr align=center>
		<td colspan=2>
			<a href="MemberListAction.me">리스트로 돌아가기</a>
		</td>
	</tr>
</table>
</center>
</body>
</html>