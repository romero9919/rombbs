<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, com.rom.dao.MkTblDao, com.rom.dto.MkTblDto, java.util.ArrayList" %>
<jsp:useBean id="db" class="com.rom.dao.DBConnect" scope="page" />
<%
	String id = request.getParameter("tbl");
    Connection conn = db.conn;
    MkTblDao dao = new MkTblDao(conn); 
    MkTblDto dto = null;
    dto = dao.selectDB(id);
    String skin = "skin/" + dto.getSkin() + "/list.jsp";
    request.setAttribute("dto", dto);
%>  

<jsp:include page="inc/header.jsp" flush="true"/>
<div class="row">
<%@ include file="inc/aside.jsp" %>
<section>
<div class="main-list bg-white p-5">

<jsp:include page="<%=skin %>" flush="true" />
	
</div>
</section>
</div>
<%@ include file="inc/footer.jsp" %>