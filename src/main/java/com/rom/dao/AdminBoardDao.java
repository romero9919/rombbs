package com.rom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rom.dto.AdminBoardDto;

public class AdminBoardDao {

	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private Connection conn;
	
	public AdminBoardDao(Connection conn) {
		this.conn = conn;
	}
	
	public List<AdminBoardDto> selectAll(){
		rs = null;
		List<AdminBoardDto> res = new ArrayList<AdminBoardDto>();
		
		String sql = "SELECT * FROM admin_board";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery(sql);
			
			while(rs.next()) {
				AdminBoardDto dto = new AdminBoardDto(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13), rs.getString(14), rs.getString(15), rs.getString(16));				
				res.add(dto);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return res;
	}
}
