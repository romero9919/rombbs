<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String sessionId = (String) session.getAttribute("user");

	if(sessionId != null){
	
%>

    <aside class="mt-3 p-4 bg-white">
    	<span class="badge"><%= sessionId %>님 로그인 중</span>
    	<br>
    	<a href="/logout.jsp">로그아웃</a>
<%
	if(sessionId.equals("admin")){
%>
		<a href="member/admin/adminlist.jsp">관리자 모드</a>
<%
	}
%>
<%
	} else{
%>
    <aside class="mt-3 p-4 bg-white">
            <form name="loginForm" class="loginform" id="loginform" method="post" action="login">
               <input type="text" class="form-control userid mb-4" id="userid"
                      placeholder="아이디" name="userid" />
               <input type="password" class="form-control userpass mb-3" id="userpass"
                      placeholder="비밀번호" name="userpass" />      
               <div class="text-right mb-3">
                 <label> 아이디 기억 <input type="checkbox" name="rid" value="rid" id="rid"></label>
               </div>         
               <button type="submit" class="btn btn-primary btn-block">로그인</button>                     
               <a href="register.jsp">회원가입</a>
            </form>    
<%
	}
%>	
   	           <div class="bannerbox">
                  <a href="#"><img src="https://picsum.photos/id/310/252/90" alt="banner"></a>
                  <a href="#"><img src="https://picsum.photos/id/410/252/90" alt="banner"></a>
                  <a href="#"><img src="https://picsum.photos/id/510/252/90" alt="banner"></a>
                  <a href="#"><img src="https://picsum.photos/id/610/252/90" alt="banner"></a>
               </div>
    </aside>
