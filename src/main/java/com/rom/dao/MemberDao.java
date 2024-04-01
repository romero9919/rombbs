package com.rom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rom.dto.MemberDto;

public class MemberDao {
	
	private PreparedStatement pstmt = null;
	private ResultSet res = null;
	private Connection conn;
	
	public MemberDao(Connection conn) {
		this.conn = conn;
	}
	
	//회원가입
	public int insertDB(MemberDto dto) {
		
		int num = 0;
		
		String sql = "INSERT INTO member (userid, userpass, username, useremail, usertel, userlink, zipcode, address, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUserid());
			pstmt.setString(2, dto.getUserpass());
			pstmt.setString(3, dto.getUsername());
			pstmt.setString(4, dto.getUseremail());
			pstmt.setString(5, dto.getUsertel());
			pstmt.setInt(6, dto.getZipcode());
			pstmt.setString(7, dto.getAddress());
			pstmt.setString(8, dto.getUserlink());
			pstmt.setString(9, dto.getRole());
			
			num = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch(SQLException e) {
				
			}
		}
		
		return num;
	}
	
//	public ResultSet login(MemberDto dto) {
//		ResultSet rs = null;
//		
//		String sql = "SELECT userid FROM member WHERE userid = ? AND userpass = ?";
//		
//		try {
//			
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, dto.getUserid());
//			pstmt.setString(2, dto.getUserpass());
//			
//			rs = pstmt.executeQuery();
//			
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//			
//		} finally {
//			try {
//				if(pstmt != null) pstmt.close();
//			} catch(SQLException e) {
//				
//			}
//		}
//		
//		return rs;
//	}
	
	public boolean loginMember(String userid, String userpass) {
		Boolean rs = false;
		String sql = "SELECT * FROM member WHERE userid = ? AND userpass = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.setString(2, userpass);
			
			res = pstmt.executeQuery();
			if(res.next()) rs = true;
			
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
			} catch(SQLException e) {
				
			}
		}
		return rs;
	}
	
}
