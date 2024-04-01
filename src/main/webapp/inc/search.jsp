<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <div class="listbox">
                   <form name="searchform" id="searchform" class="searchform">
                       <div class="input-group my-3">
                           <div class="input-group-prepend">
                               <button type="button" 
                                    class="btn btn-outline-secondary dropdown-toggle" 
                                    data-toggle="dropdown"
                                    value="title">
                                제목검색
                               </button>
                               <div class="dropdown-menu">
                                  <a class="dropdown-item" href="username">이름검색</a>
                                  <a class="dropdown-item" href="title">제목검색</a>
                                  <a class="dropdown-item" href="contents">내용검색</a>
                               </div>
                           </div>
                           <input type="search" class="form-control" placeholder="검색">
                           <div class="input-group-append">
                               <button class="btn btn-primary"><i class="ri-search-line"></i></button>
                           </div>
                       </div>
                 </form>
            </div>