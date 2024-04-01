package com.rom.dto;

public class AdminBoardDto {
	
	private int id;
	private String tablename;
	private String skin;
	private int category;
	private int listcount;
	private int pagecount;
	private int lleb;
	private int rleb;
	private int comopt;
	private int comleb;
	private int file;
	private int filesize;
	private int allfilesize;
	private String imgsize;
	private String thimgsize;
	private String bbstitle;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public String getSkin() {
		return skin;
	}
	public void setSkin(String skin) {
		this.skin = skin;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getListcount() {
		return listcount;
	}
	public void setListcount(int listcount) {
		this.listcount = listcount;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public int getLleb() {
		return lleb;
	}
	public void setLleb(int lleb) {
		this.lleb = lleb;
	}
	public int getRleb() {
		return rleb;
	}
	public void setRleb(int rleb) {
		this.rleb = rleb;
	}
	public int getComopt() {
		return comopt;
	}
	public void setComopt(int comopt) {
		this.comopt = comopt;
	}
	public int getComleb() {
		return comleb;
	}
	public void setComleb(int comleb) {
		this.comleb = comleb;
	}
	public int getFile() {
		return file;
	}
	public void setFile(int file) {
		this.file = file;
	}
	public int getFilesize() {
		return filesize;
	}
	public void setFilesize(int filesize) {
		this.filesize = filesize;
	}
	public int getAllfilesize() {
		return allfilesize;
	}
	public void setAllfilesize(int allfilesize) {
		this.allfilesize = allfilesize;
	}
	public String getImgsize() {
		return imgsize;
	}
	public void setImgsize(String imgsize) {
		this.imgsize = imgsize;
	}
	public String getThimgsize() {
		return thimgsize;
	}
	public void setThimgsize(String thimgsize) {
		this.thimgsize = thimgsize;
	}
	public String getBbstitle() {
		return bbstitle;
	}
	public void setBbstitle(String bbstitle) {
		this.bbstitle = bbstitle;
	}
	
	public AdminBoardDto(int id, String tablename, String skin, int category, int listcount, int pagecount, int lleb,
			int rleb, int comopt, int comleb, int file, int filesize, int allfilesize, String imgsize, String thimgsize,
			String bbstitle) {
		super();
		this.id = id;
		this.tablename = tablename;
		this.skin = skin;
		this.category = category;
		this.listcount = listcount;
		this.pagecount = pagecount;
		this.lleb = lleb;
		this.rleb = rleb;
		this.comopt = comopt;
		this.comleb = comleb;
		this.file = file;
		this.filesize = filesize;
		this.allfilesize = allfilesize;
		this.imgsize = imgsize;
		this.thimgsize = thimgsize;
		this.bbstitle = bbstitle;
	}
	
	
}
