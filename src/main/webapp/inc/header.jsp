<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8" />
    
<%@ page import="java.sql.*, com.rom.dao.*, com.rom.dto.*,java.util.ArrayList" %>
<jsp:useBean id="db" class="com.rom.command.DbCommand" scope="page" />
<c:set var="db" value="${db }" />
<c:set var="lists" value="${db.allList() }" />




    
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <!-- title -->
  <title>jsp 로 만든 커뮤니티</title>
  <link rel="stylesheet" href="/rombbs/css/style.css">
  <script src="/rombbs/js/jquery.min.js"></script>
  <script src="/rombbs/js/popper.min.js"></script>
  <script src="/rombbs/js/slick.min.js"></script>
  <script src="/rombbs/js/bootstrap.min.js"></script>
  <script src="/rombbs/js/script.js"></script>
</head>
<body>
   <div class="container">
        <!-- header -->
        
    <!-- 헤더 -->
      <header>
         <a href="#" class="brand">MY BBS</a>
         <nav>
         <c:forEach var="list" items="${lists } varStatus="status">
         	<a href="./list.stp?tbl=${list.id }">${list.tablename }</a>
         
         </c:forEach>
         </nav>
      </header>
      <!-- / 헤더 -->