<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, com.rom.dao.MemberDao" %>
<% request.setCharacterEncoding("utf-8"); %>
<%@ page errorPage="error.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>logoutpage</title>
</head>
<body>
	<%
		session.invalidate();
	%>
	<script type="text/javascript">
		alert("logout ok.");
		location.href="./";
	</script>
</body>
</html>