package com.rom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.rom.dto.BoardDto;

public class BoardDao {
 
	PreparedStatement pstmt = null;
	ResultSet res = null;
	Connection conn;
	
    public BoardDao(Connection conn) {
    	this.conn = conn;
    }
    //전체페이지 수
    public int selectDB(String tnum){
        int tblnum = Integer.parseInt(tnum); 	
        int rs = 0;
    	String sql = "select count(*) from board where grid = ?";
    	try {
    	  pstmt = conn.prepareStatement(sql);
    	  pstmt.setInt(1,  tblnum);

    	  System.out.println(pstmt);	  
    	  res = pstmt.executeQuery();
    	  if(res.next()) {
             rs = res.getInt(1);
    	  }
    	} catch(SQLException e) {
    		e.printStackTrace();
    	} finally {
    		try {
    		   if(res != null) res.close();
    		   if(pstmt != null) pstmt.close();
    		}catch(SQLException e) {e.printStackTrace();}   
    	}
    	System.out.println(rs);
    	return rs;
    }
    
    //select
    public ArrayList<BoardDto> selectDB(String tnum, int limitnum, int maxnum){
        int tblnum = Integer.parseInt(tnum); 	
    	ArrayList<BoardDto> dtos = new ArrayList<>();
   
    	String sql = "select * from board where grid = ? order by gid desc, gnum asc"
    			+ " limit ?, ?";
    	try {
    	  pstmt = conn.prepareStatement(sql);
    	  pstmt.setInt(1,  tblnum);
    	  pstmt.setInt(2, limitnum);
    	  pstmt.setInt(3, maxnum);
    	  System.out.println(pstmt);	  
    	  res = pstmt.executeQuery();
    	
    	  while(res.next()) {
 		 
    		 BoardDto bDto = new BoardDto();
    		 bDto.setId(res.getInt("id"));
       		 bDto.setGrid(res.getInt("grid"));
    		 bDto.setGid(res.getInt("gid"));
    		 bDto.setGnum(res.getInt("gnum"));
    		 bDto.setDepth(res.getInt("depth"));
    		 bDto.setCategory(res.getInt("category"));
    		 bDto.setImnum(res.getInt("imnum"));
    		 bDto.setComment(res.getInt("comment"));
    		 bDto.setUserid(res.getString("userid"));
    		 bDto.setUname(res.getString("uname"));
    		 bDto.setPassword(res.getString("password"));
    		 bDto.setEmail(res.getString("email"));
    		 bDto.setHomepage(res.getString("homepage"));
    		 bDto.setSubject(res.getString("subject"));
    		 bDto.setContents(res.getString("contents"));
    		 bDto.setThfile(res.getInt("thfile"));
    		 bDto.setCount(res.getInt("count"));
    		 bDto.setIp(res.getString("ip"));
    		 bDto.setEditip(res.getString("editip"));
    		 bDto.setWritetime(res.getTimestamp("writetime"));
    		 bDto.setEditwritetime(res.getTimestamp("editwritetime"));
    		 bDto.setSec(res.getInt("sec"));
    		 dtos.add(bDto);
    	  }
    	} catch(SQLException e) {
    		e.printStackTrace();
    	} finally {
    		try {
    		   if(res != null) res.close();
    		   if(pstmt != null) pstmt.close();
    		}catch(SQLException e) {e.printStackTrace();}   
    	}
    	
    	return dtos;
    }
    
    public int AllSelectDB() {
        int rs = 0;
        String sql = "select count(*) from board";     
        try {
        		pstmt = conn.prepareStatement(sql);
                res = pstmt.executeQuery();
                
                if(res.next()) {
                	rs = res.getInt(1);
                }
        }catch(SQLException e) {
           e.printStackTrace();
        } finally {
           try {
              if(res != null) res.close();
              if(pstmt != null) pstmt.close();
           }catch(SQLException e) {e.printStackTrace();}   
        }
        return rs;
     }

        
 //select overload
    /*
 public ArrayList<BoardDto> selectDB(String name, String value){
    	
    	ArrayList<BoardDto> dtos = new ArrayList<>();
   
    	String sql = "select * from jboard where "+name+" LIKE ? order by refid desc, renum asc"
    			+ " limit ?, ?";

    	try {
    	  pstmt = conn.prepareStatement(sql);
    	  pstmt.setString(1, "%"+value+"%");
    	  pstmt.setInt(2, 0);
    	  pstmt.setInt(3, 20);
    	  System.out.println(pstmt);	  
    	  res = pstmt.executeQuery();
    	
    	  while(res.next()) {
    		 int id = res.getInt("id");
    		 int refid = res.getInt("refid");
    		 int depth = res.getInt("depth");
    		 int renum = res.getInt("renum");
    		 String title = res.getString("title");
    		 String content = res.getString("content");
    		 String writer = res.getString("writer");
    		 String pass = res.getString("pass");
    		 String userid = res.getString("userid");
    		 int hit = res.getInt("hit");
    		 int chit = res.getInt("chit");
    		 Timestamp wdate = res.getTimestamp("wdate");
    		 
    		 BDto bDto = new BDto();
    		 bDto.setId(id);
    		 bDto.setRefid(refid);
    		 bDto.setDepth(depth);
    		 bDto.setRenum(renum);
    		 bDto.setTitle(title);
    		 bDto.setContent(content);
    		 bDto.setWriter(writer);
    		 bDto.setPass(pass);
    		 bDto.setUserid(userid);
    		 bDto.setHit(hit);
    		 bDto.setChit(chit);
    		 bDto.setWdate(wdate);
    		 dtos.add(bDto);
    	  }
    	} catch(SQLException e) {
    		e.printStackTrace();
    	} finally {
    		try {
    		   if(res != null) res.close();
    		   if(pstmt != null) pstmt.close();
    		}catch(SQLException e) {e.printStackTrace();}   
    	}
    	
    	return dtos;
    }
    */
    //비번검증
    /*
    public int findPass(String id, String pass) { 

    	int nid = Integer.parseInt(id);
    	int result = 0;
 
    	String sql = "select id from jboard where id=? and pass=?"; 
    	BoardDto bDto = new BoardDto();
    	try {
    		pstmt = conn.prepareStatement(sql);
    		pstmt.setInt(1, nid);
    		pstmt.setString(2, pass);
    		res = pstmt.executeQuery();
    		if(res.next()) {
    			result = 1;
    		}
    	}catch (SQLException e) {
			e.printStackTrace();
		} finally {
    		try {
     		   if(res != null) res.close();
     		   if(pstmt != null) pstmt.close();
     		}catch(SQLException e) {e.printStackTrace();}   
     	}
    	return result;
    }
 */
    //삭제
    /*
    public int deleteDB(String id, String pass) {
    	int nid = Integer.parseInt(id);
    	int result = 0;
    	String sql = "delete from jboard where id=? and pass=?";
    	try {
			pstmt = conn.prepareStatement(sql);
	    	pstmt.setInt(1, nid);
	    	pstmt.setString(2, pass);
	        result = pstmt.executeUpdate();
	        
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
    		try {
     		   if(res != null) res.close();
     		   if(pstmt != null) pstmt.close();
     		}catch(SQLException e) {e.printStackTrace();}   
     	}
    	
    	return result;
    }
   
    public BoardDto viewDB(String nums) {
    	int num = Integer.parseInt(nums);
    	String sql = "select * from jboard where id=?";
    	BoardDto bDto = new BoardDto();
    	try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			res = pstmt.executeQuery();
			while(res.next()) {    		
	    		int id = res.getInt("id");
	    		int refid = res.getInt("refid");
	    		int depth = res.getInt("depth");
	    		int renum = res.getInt("renum");
	    		String title = res.getString("title");
	    		String content = res.getString("content");
	    		String writer = res.getString("writer");
	    		String pass = res.getString("pass");
	    		String userid = res.getString("userid");
	    		int hit = res.getInt("hit");
	    		int chit = res.getInt("chit");
	    		Timestamp wdate = res.getTimestamp("wdate");
	    		
	    		bDto.setId(id);
	    		bDto.setRefid(refid);
	    		bDto.setDepth(depth);
	    		bDto.setRenum(renum);
	    		bDto.setTitle(title);
	    		bDto.setContent(content);
	    		bDto.setWriter(writer);
	    		bDto.setPass(pass);
	    		bDto.setUserid(userid);
	    		bDto.setHit(hit);
	    		bDto.setChit(chit);
	    		bDto.setWdate(wdate);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
    		try {
     		   if(res != null) res.close();
     		   if(pstmt != null) pstmt.close();
     		}catch(SQLException e) {e.printStackTrace();}   
     	}
    	return bDto;
    }
    */
    //쓰기
    /*
    public int insertDB(BoardDto dto) {
    	int num = 0;
    	String sql = "insert into jboard ( depth,  title, content, writer, pass, userid) values (  ?, ?, ?, ?, ?, ?)";
    	try {
    		pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    		pstmt.setInt(1, dto.getDepth());  	
    		pstmt.setString(2, dto.getTitle());
    		pstmt.setString(3, dto.getContent());
    		pstmt.setString(4, dto.getWriter());
            pstmt.setString(5, dto.getPass());
            if(dto.getUserid()!=null) {
            	pstmt.setString(6, dto.getUserid());
            }else {
            	pstmt.setString(6, "GUEST");
            }
            pstmt.executeUpdate();
            res = pstmt.getGeneratedKeys(); //입력 후 auto increment 값을 반환 받음 	
              if(res.next()) {
            	num = res.getInt(1);            
             }
              
            if(dto.getDepth() == 0){
               updateDB(num, num, "refid");
            }else{
               updateDB(dto.getRefid(), dto.getRenum());
               updateDB(num, dto.getRefid(), dto.getRenum()+1);
            }   

        
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}finally {
    		try {
      		   if(res != null) res.close();
      		   if(pstmt != null) pstmt.close();
      		}catch(SQLException e) {e.printStackTrace();}   
      	}
    	return num;
    }
    */
    //업데이트
    /*
    public int updateDB(int id, int num, String column) {
        int rs = 0;
        String sql = "update jboard set "+ column +"=? where id=?";
        
        try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, num);
            pstmt.setInt(2, id);
            //System.out.println(pstmt);
            rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
    		try {
      		   if(pstmt != null) pstmt.close();
      		}catch(SQLException e) {e.printStackTrace();}   
      	}
    
    	return rs;
    }
    
    public int updateDB(int id, int num, int renum) {
        int rs = 0;
        String sql = "update jboard set refid =? , renum = ? where id=?";
        
        try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, num);
			pstmt.setInt(2, renum);
            pstmt.setInt(3, id);
            //System.out.println(pstmt);
            rs = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
    		try {
      		   if(pstmt != null) pstmt.close();
      		}catch(SQLException e) {e.printStackTrace();}   
      	}
    
    	return rs;
    }
    
    */
    //업데이트db 오버로드
    /*
    public int updateDB(BoardDto dto) {
        int rs = 0;
        String sql = "update jboard set writer = ? , pass = ?, title =?, content=? where id=?";
        
        try {
			pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, dto.getWriter());
			pstmt.setString(2, dto.getPass());
            pstmt.setString(3, dto.getTitle());
            pstmt.setString(4, dto.getContent());
            pstmt.setInt(5, dto.getId());
            rs = pstmt.executeUpdate();
            
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
    		try {
      		   if(pstmt != null) pstmt.close();
      		}catch(SQLException e) {e.printStackTrace();}   
      	}
    
    	return rs;
    }
    */
    //글 번호증가 업데이트
    /*
    public int updateDB(int refid, int renum) {
    	String sql = "update jboard set renum = renum + 1 where refid=? and renum > ?";
    	int rs = 0;
    	try {
    	   pstmt = conn.prepareStatement(sql); 
		   pstmt.setInt(1, refid);
		   pstmt.setInt(2, renum);
           System.out.println(pstmt);
		   rs = pstmt.executeUpdate();
           
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
   		try {
     		   if(pstmt != null) pstmt.close();
     		}catch(SQLException e) {e.printStackTrace();}   
     	}
   	   return rs;   
    }
    */
}
