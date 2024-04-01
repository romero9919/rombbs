<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, com.rom.dao.MemberDao" %>
<% request.setCharacterEncoding("utf-8"); %>
<%@ page errorPage="error.jsp" %>
<jsp:useBean id="db" class="com.rom.dao.DBConnect" scope="page" />
<jsp:useBean id="mdto" class="com.rom.dto.MemberDto" scope="page" />
<jsp:setProperty name="mdto" property="*" />
<%
	Connection conn = db.conn;
	MemberDao dao = new MemberDao(conn);
	int rs = dao.insertDB(mdto);
		
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% if(rs == 1){  
		session.setAttribute("userid", mdto.getUserid());
	%>
	<script type="text/javascript">
		alert("register ok.");
		location.href="./";
	</script>
	<%} else { %>
	<script type="text/javascript">
		alert("register error.");	
		location.href="./";
	</script>
	<%} %>
</body>
</html>