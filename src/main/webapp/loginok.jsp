<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, com.rom.dao.MemberDao" %>
<% request.setCharacterEncoding("utf-8"); %>
<%@ page errorPage="error.jsp" %>
<jsp:useBean id="db" class="com.rom.dao.DBConnect" scope="page" />
<jsp:useBean id="mdto" class="com.rom.dto.MemberDto" scope="page" />
<jsp:setProperty name="mdto" property="*" />
<%
	Connection conn = db.getConn();
	MemberDao dao = new MemberDao(conn);
		
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginpage</title>
</head>
<body> 
</body>
</html>