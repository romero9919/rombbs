<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*, com.rom.dao.MkTblDao" %>
<% request.setCharacterEncoding("utf-8"); %>    
<%--<%@ page errorPage="error.jsp" %>--%>
<jsp:useBean id="db" class="com.rom.dao.DBConnect" scope="page" />
<jsp:useBean id="mdto" class="com.rom.dto.MkTblDto" scope="page" />
<jsp:setProperty name="mdto" property="*" />
<% 
   Connection conn = db.conn;
   MkTblDao dao = new MkTblDao(conn);
   int rs = dao.insertDB(mdto);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <% 
  if(rs == 1) {
  %>
  <script>
    alert("등록했습니다.");
    location.href="./adminlist.jsp";
  </script>
  <%} else { %>
    <script>
    alert("문제가 발생했습니다.");
    location.href="./adminlist.jsp"
  </script>
  <% }  %>
</body>
</html>