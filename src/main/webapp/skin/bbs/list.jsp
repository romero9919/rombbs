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
<table class="table table-hover">
                    <colgroup>
                       <col width="8%">
                       <col>
                       <col width="15%">
                       <col width="10%">
                       <col width="15%">
                    </colgroup>
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>글쓴이</th>
                            <th>조회수</th>
                            <th>날짜</th>
                        </tr>
                    </thead>
<%
   int num = jdto.size(); 
   for(int i = 0; i < jdto.size(); i++) {
	  BoardDto list = jdto.get(i); 
	  Timestamp dates = list.getWritetime();
      String wdate = sdf.format(dates);
%>
                      <tr>
                           <td class="text-center"><%=num %></td>
                           <td><a href="contents.jsp?id=<%=list.getId()%>">
                               <%=list.getSubject() %>
                            </a><span></span>
                            <!-- 
                               <i class="ri-file-image-fill"></i>
                               <i class="ri-file-hwp-fill"></i>
                               <i class="ri-file-music-fill"></i>
                            -->   
                            </td>
                            
                           <td class="text-center"><%=list.getUname() %></td>
                           <td class="text-center"><%=list.getCount() %></td>
                           <td class="text-center"><%=wdate %></td>
                       </tr>
<%
     num--;
   }
%>
</table>