package com.rom.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SessionFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession(false);
		
		response.setContentType("text/html;chatset=utf-8");
		
		if(session == null || session.getAttribute("user") == null) {
			PrintWriter out = response.getWriter();
			String script = "<script>alert('회원 전용입니다. 로그인이 필요합니다.'); location.href = './';</script>";
			out.println(script);
		} else {
			chain.doFilter(req, res);
		}
		
	}

}
