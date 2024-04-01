package com.rom.command;

import java.util.*;

import javax.naming.NamingException;

import java.sql.Connection;
import java.sql.SQLException;

import com.rom.dao.BoardDao;
import com.rom.dao.DBConnect;
import com.rom.dao.MkTblDao;
import com.rom.dto.BoardDto;
import com.rom.dto.MkTblDto;

public class DbCommand {

	
	Connection conn = null;
	DBConnect db = new DBConnect();
	
	public DbCommand() {
		try {
			this.conn = db.getConn();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<MkTblDto> allList(){
		MkTblDao dao = new MkTblDao(conn);
		ArrayList<MkTblDto> lists = dao.selectDB();
		return lists;
	}
	
	ArrayList<BoardDto> latest(String tnum, int limitnum, int maxnum){
		BoardDao dao = new BoardDao(conn);
		ArrayList<BoardDto> lists = dao.selectDB(tnum, limitnum, maxnum);
		return lists;
	}
}
