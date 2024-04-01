package com.rom.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rom.dao.DBConnect;
import com.rom.dao.MemberDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html;chatset=utf-8");
		String userid = request.getParameter("userid");
		String userpass = request.getParameter("userpass");
		
		if(isValidateUser(userid, userpass)) {
			HttpSession session = request.getSession();
			session.setAttribute("user", userid);
		}
		response.sendRedirect("./");
	}

	
	public boolean isValidateUser(String uid, String upass) {
		boolean result = false;
		
		DBConnect db = new DBConnect();
		Connection conn = db.conn;
		MemberDao dao = new MemberDao(conn);
		result = dao.loginMember(uid, upass);
		
		return result;
	}
	
}
