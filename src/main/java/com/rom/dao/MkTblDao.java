package com.rom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.rom.dto.MkTblDto;

public class MkTblDao {

     private PreparedStatement pstmt = null;
     private Statement stmt = null;
     private ResultSet res = null;
     private Connection conn;
     
     public MkTblDao(Connection conn) {
         this.conn = conn;
     }

     //회원가입
     public int insertDB(MkTblDto dto) {
      
        int num = 0;
        String sql = "insert into admin_board (tablename, skin) values (?,?)"; 
        try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1,  dto.getTablename());
         pstmt.setString(2,  dto.getSkin());
   
         num = pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      } finally {
          try {
              if(pstmt != null) pstmt.close();
          }catch(SQLException e) {}
      }
        
        return num;
     }
     
    //select
     public ArrayList<MkTblDto> selectDB(){
       
        ArrayList<MkTblDto> dtos = new ArrayList<>();
       
        String sql ="select * from admin_board order by id desc";
        try {
          stmt = conn.createStatement();
          res = stmt.executeQuery(sql);
          while(res.next()) {
            MkTblDto dto = new MkTblDto(); 
            dto.setId(res.getInt("id"));
            dto.setTablename(res.getString("tablename"));
            dto.setSkin(res.getString("skin"));
            dto.setCategory(res.getByte("category"));
            dto.setListcount(res.getByte("listcount"));
            dto.setPagecount(res.getByte("pagecount"));
            dto.setLleb(res.getByte("lleb"));
            dto.setRleb(res.getByte("rleb"));
            dto.setComopt(res.getByte("comopt"));
            dto.setComleb(res.getByte("comleb"));
            dto.setFile(res.getByte("file"));
            dto.setFilesize(res.getInt("filesize"));
            dto.setAllfilesize(res.getInt("allfilesize"));
            dto.setImgsize(res.getString("imgsize"));
            dto.setThimgsize(res.getString("thimgsize"));
            dtos.add(dto);
             }
          }catch (SQLException e) {
               e.printStackTrace();
         } finally {
             try {
                    if(pstmt != null) pstmt.close();
                    if(res != null) res.close();
                }catch(SQLException e) {}
         }
        
           return dtos;
        }
     
     //select-view
     public MkTblDto selectDB(String ids){
         int id = Integer.parseInt(ids);       
        MkTblDto dto = new MkTblDto();
        String sql ="select * from admin_board where id= ? order by id desc";
        try {
          pstmt = conn.prepareStatement(sql);
          pstmt.setInt(1, id);
          res = pstmt.executeQuery();
          if(res.next()) { 
            dto.setId(res.getInt("id"));
            dto.setTablename(res.getString("tablename"));
            dto.setSkin(res.getString("skin"));
            dto.setCategory(res.getByte("category"));
            dto.setListcount(res.getByte("listcount"));
            dto.setPagecount(res.getByte("pagecount"));
            dto.setLleb(res.getByte("lleb"));
            dto.setRleb(res.getByte("rleb"));
            dto.setComopt(res.getByte("comopt"));
            dto.setComleb(res.getByte("comleb"));
            dto.setFile(res.getByte("file"));
            dto.setFilesize(res.getInt("filesize"));
            dto.setAllfilesize(res.getInt("allfilesize"));
            dto.setImgsize(res.getString("imgsize"));
            dto.setThimgsize(res.getString("thimgsize"));
             }
          }catch (SQLException e) {
               e.printStackTrace();
         } finally {
             try {
                    if(pstmt != null) pstmt.close();
                    if(res != null) res.close();
                }catch(SQLException e) {}
         }
           return dto;
        }
     
}