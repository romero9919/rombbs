<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, com.rom.dao.*, com.rom.dto.*,java.util.ArrayList, java.text.SimpleDateFormat" %>
 <%
    MkTblDto mdto = (MkTblDto) request.getAttribute("mlist"); 
    ArrayList<BoardDto> jdto = (ArrayList<BoardDto>) request.getAttribute("jlist");
    String maxrow = request.getParameter("maxrow");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
 %>   
<h2 class="text-center"><%=mdto.getTablename() %></h2>
<p>전체 게시글: <%=maxrow %></p>
<div class="row">
<%
   int num = jdto.size(); 
   for(int i = 0; i < jdto.size(); i++) {
      BoardDto list = jdto.get(i); 
      Timestamp dates = list.getWritetime();
      String wdate = sdf.format(dates);
%>
        <div class="col-md-4 mb-4">
           <div class="card">
               <img src="" class="card-img-top" alt="">
               <div class="card-body">
                  <h5 class="card-title"><%=list.getSubject() %></h5>
                  <p><%=list.getContents() %></p>
                  <div class="t-box">
                     hit: <%=list.getCount() %> |
                     <%=list.getUname() %> |
                     <%=wdate %>
                  </div>
                  <div class="button-box text-right">
                      <a href="contents.jsp?id=<%=list.getId()%>" class="btn btn-primary">보기</a>
                  </div>
               </div>
           </div>
        </div>     
            
<%
     num--;
   }
%>
</div>