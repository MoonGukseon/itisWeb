<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="java.util.*" %>
<%@ page import="member.db.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	MemberDAO memberdao = MemberDAO.getInstance();
	Vector<MemberBean> memberlist = memberdao.getMemberList();
%>
<html>
<head>
<title>ȸ������ �ý��� �����ڸ��(ȸ�� ��� ����)</title>
</head>
<body>
<center>
<table border=1 width=300>
	<tr align=center>
		<td colspan=2>ȸ�� ���</td>
	</tr>
	<%
	for(int i=0; i<memberlist.size(); i++){
		MemberBean member=(MemberBean)memberlist.get(i);
	%>
	<tr align=center>
		<td>
			<a href="MemberViewAction.me?id=<%=member.getMEMBER_ID()%>">
				<%=member.getMEMBER_ID() %>
			</a>
		</td>
		<td>
			<a href="MemberDeleteAction.me?id=<%=member.getMEMBER_ID()%>">����</a>
		</td>
	</tr>
	
	<%} %>
	<tr align=center>
		<td colspan=2>
			<input type="button" value="back" onClick="history.go(-1)">
		</td>
	</tr>
</table>
</center>
</body>
</html>