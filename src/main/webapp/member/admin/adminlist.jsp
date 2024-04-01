<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*, com.rom.dao.MkTblDao, com.rom.dto.MkTblDto, java.util.ArrayList" %>
<jsp:useBean id="db" class="com.rom.dao.DBConnect" scope="page" />
<%
   Connection conn = db.conn;
   MkTblDao dao = new MkTblDao(conn); 
   ArrayList<MkTblDto> lists = null;
   lists = dao.selectDB();
%>  
<jsp:include page="../../inc/header.jsp" flush="true" />
<div class="row">
<%@ include file="../../inc/aside.jsp" %>
<section>
<div class="main-list bg-white p-5">
  <h2 class="text-center">관리자 모드</h2>
  <div class="my-3 text-center">
     <form name="mkform" id="mkform" action="makedb.jsp" method="post">
         <div class="row">
            <div class="col">
              <input type="text" name="tablename" placeholder="게시판이름" />
            </div>
            <div class="col">
               <select name="skin">
                 <option value="">게시판스킨</option>
                 <option value="bbs">일반게시판</option>
                 <option value="gallery">갤러리</option>
                 <option value="blog">블로그</option>
                 <option value="text">신문형식</option>
               </select>
            </div>
            <div class="col">
               <button type="submit" class="btn btn-primary">게시판생성</button>
            </div>
         </div>
     </form>
  </div> 
  <table class="table table-hover mktbl">
  <colgroup>
    <col width="20%">
    <col width="10%">
    <col width="10%">
    <col width="10%">
    <col width="10%">
    <col width="12%">
    <col width="13%">
    <col width="15%">  
  </colgroup>
    <thead>
      <tr>
        <th rowspan="2">게시판제목</th>
        <th rowspan="2">스킨</th>
        <th rowspan="2">카테고리</th>
        <th rowspan="2">목록수</th>
        <th rowspan="2">페이지수</th>
        
        <th>접근권한</th>
        <th>글쓰기권한</th> 
        <th rowspan="2">명령</th>
      </tr>
      <tr>  
        <th>코멘트</th>
        <th>파일첨부</th>
      </tr>  

    </thead>
    <tbody>
    <%
     ArrayList<String> sct = new ArrayList<>();
     for(int i = 0; i < lists.size(); i++){
       MkTblDto dto = lists.get(i);    
    %>
    <form name='form' name="ct" id="tbledt" action="tbledt_ok.php" method="post">
      <tr>
        <td rowspan="2"><input type="text" name="tablename" value="<%=dto.getTablename() %>" class="form-control"></td>
        <td rowspan="2">
            <select name="skin" class="skin">
              <option value="">게시판스킨</option>
              <option value="bbs">일반게시판</option>
              <option value="gallery">갤러리</option>
              <option value="blog">블로그</option>
              <option value="text">신문형식</option>
            </select></td>
        <td rowspan="2">            
           <select name="category" class="category">
              <option value="0">불가</option>
              <option value="1">허용</option>
            </select></td>
        <td rowspan="2"><input type="number" name="listcount" value="<%=dto.getListcount()%>" class="form-control"></td>
        <td rowspan="2"><input type="number" name="pagecount" value="<%=dto.getPagecount()%>" class="form-control"></td>
     
        <td>           
            <select name="lleb" class="lleb">
              <option value="0">모두</option>
              <option value="1">회원</option>
              <option value="2">운영자</option>
            </select></td>
        <td>
            <select name="rleb" class="rleb">
              <option value="0">모두</option>
              <option value="1">회원</option>
              <option value="2">운영자</option>
            </select>
        </td>
      
        <td rowspan="2">
           <button type="submit" class="btn btn-warning btn-sm mr-2">수정</button>
           <button type="button" class="btn btn-danger btn-sm">삭제</button>
        </td> 
     </tr>
     <tr>   
        <td>
            <select name="comopt" class="comopt">
              <option value="0">불가</option>
              <option value="1">모두</option>
              <option value="2">회원</option>
              <option value="3">운영자</option>
            </select>
        </td>
        <td>
            <select name="comleb" class="comleb">
              <option value="0">불가</option>
              <option value="1">모두</option>
              <option value="2">회원</option>
              <option value="3">운영자</option>
            </select>
        </td>
      </tr>
      </form>   
      <%
         sct.add("$('.skin').eq("+i+").val('"+dto.getSkin()+"').prop('selected', true)"); 
         sct.add("$('.category').eq("+i+").val('"+dto.getCategory()+"').prop('selected', true)"); 
         sct.add("$('.lleb').eq("+i+").val('"+dto.getLleb()+"').prop('selected', true)"); 
         sct.add("$('.rleb').eq("+i+").val('"+dto.getRleb()+"').prop('selected', true)"); 
         sct.add("$('.comopt').eq("+i+").val('"+dto.getComopt()+"').prop('selected', true)"); 
         sct.add("$('.comleb').eq("+i+").val('"+dto.getComleb()+"').prop('selected', true)"); 
     } 
      %>
    </tbody>
  </table>
</div>
</section>
</div>
<script>
$(function(){
   <%
     for(int i = 0; i < sct.size(); i++){
        String tags = sct.get(i);
        out.println(tags);
     }
   
   %>
});
</script>
<%@ include file="../../inc/footer.jsp" %>