package com.rom.dto;

import java.sql.Timestamp;

public class BoardDto {
 
	private int id;
	private int grid;
	private int gid;
	private int gnum;
	private int depth;	
	private int category;
	private int imnum;
	private int comment;
	private String userid;
	private String uname;
	private String password;
	private String email;
	private String homepage;
	private String subject;
	private String contents;
	private int thfile;
	private int count;
	private String ip;
	private String editip;
	private Timestamp writetime;
	private Timestamp editwritetime;
	private int sec;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getGrid() {
		return grid;
	}
	public void setGrid(int grid) {
		this.grid = grid;
	}
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public int getGnum() {
		return gnum;
	}
	public void setGnum(int gnum) {
		this.gnum = gnum;
	}
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getImnum() {
		return imnum;
	}
	public void setImnum(int imnum) {
		this.imnum = imnum;
	}
	public int getComment() {
		return comment;
	}
	public void setComment(int comment) {
		this.comment = comment;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHomepage() {
		return homepage;
	}
	public void setHomepage(String homepage) {
		this.homepage = homepage;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getThfile() {
		return thfile;
	}
	public void setThfile(int thfile) {
		this.thfile = thfile;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getEditip() {
		return editip;
	}
	public void setEditip(String editip) {
		this.editip = editip;
	}
	public Timestamp getWritetime() {
		return writetime;
	}
	public void setWritetime(Timestamp writetime) {
		this.writetime = writetime;
	}
	public Timestamp getEditwritetime() {
		return editwritetime;
	}
	public void setEditwritetime(Timestamp editwritetime) {
		this.editwritetime = editwritetime;
	}
	public int getSec() {
		return sec;
	}
	public void setSec(int sec) {
		this.sec = sec;
	}
	
	@Override
	public String toString() {
		return "BoardDto [id=" + id + ", gid=" + gid + ", gnum=" + gnum + ", depth=" + depth 
				+ ", category=" + category + ", imnum=" + imnum + ", comment=" + comment + ", userid=" + userid
				+ ", uname=" + uname + ", password=" + password + ", email=" + email + ", homepage=" + homepage
				+ ", subject=" + subject + ", contents=" + contents + ", thfile=" + thfile + ", count=" + count
				+ ", ip=" + ip + ", editip=" + editip + ", writetime=" + writetime + ", editwritetime=" + editwritetime
				+ ", sec=" + sec + "]";
	}

}
