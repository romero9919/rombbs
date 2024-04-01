package com.rom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBConnect {
	
	public Connection conn = null;

	
	private InitialContext initContext;
	
	public Connection getConn() throws SQLException, NamingException {
		
		if(conn==null || conn.isClosed()) {
			initContext = new InitialContext();
			DataSource ds = (DataSource) initContext.lookup("java:/comp/env/RomCommu");
			conn = ds.getConnection();
			System.out.println("DB Connected.");
			
		}
		
		
		return conn;
	}
	
	public void closeConn() {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.close();
				System.out.println("DB Closed.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null;
		}
		
	}
	
}
