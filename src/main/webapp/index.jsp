<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.ArrayList, com.rom.dto.BoardDto"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8" />
<%@ include file="inc/header.jsp" %>
<div class="row">
<%@ include file="inc/aside.jsp" %>

<section class="main">
	<div class="row">
		<c:forEach var="list" items="${lists }" varStatus="status">

<%
		ArrayList<BoardDto> tlists = db.latest("${list.id}", 0, 5);
%>
		
		<div class="col-md-6">
			<div class="box">
				<div class="box-title">
					<h1>${list.tablename }</h1>
					<a href="./list.jsp?tid=${list.id }">
						<i class="ri-arrow-right-double-line"></i>
					</a>
				</div>
			
			</div>
		</div>
		</c:forEach>
	</div>
	
</section>

</div>

<%@ include file="inc/footer.jsp"%>