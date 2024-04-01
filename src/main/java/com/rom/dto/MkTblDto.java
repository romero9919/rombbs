package com.rom.dto;

public class MkTblDto {
   
   private int id;
    private String tablename;
    private String skin;
    private byte category;
    private byte listcount;
    private byte pagecount;
    private byte lleb;
    private byte rleb;
    private byte comopt;
    private byte comleb;
    private byte file;
    private int filesize;
    private int allfilesize;
    private String imgsize;
    private String thimgsize;
    
    
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
   public byte getCategory() {
      return category;
   }
   public void setCategory(byte category) {
      this.category = category;
   }
   public byte getListcount() {
      return listcount;
   }
   public void setListcount(byte listcount) {
      this.listcount = listcount;
   }
   public byte getPagecount() {
      return pagecount;
   }
   public void setPagecount(byte pagecount) {
      this.pagecount = pagecount;
   }
   public byte getLleb() {
      return lleb;
   }
   public void setLleb(byte lleb) {
      this.lleb = lleb;
   }
   public byte getRleb() {
      return rleb;
   }
   public void setRleb(byte rleb) {
      this.rleb = rleb;
   }
   public byte getComopt() {
      return comopt;
   }
   public void setComopt(byte comopt) {
      this.comopt = comopt;
   }
   public byte getComleb() {
      return comleb;
   }
   public void setComleb(byte comleb) {
      this.comleb = comleb;
   }
   public byte getFile() {
      return file;
   }
   public void setFile(byte file) {
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
   
   @Override
   public String toString() {
      return "MkTblDto [id=" + id + ", tablename=" + tablename + ", skin=" + skin + ", category=" + category
            + ", listcount=" + listcount + ", pagecount=" + pagecount + ", lleb=" + lleb + ", rleb=" + rleb
            + ", comopt=" + comopt + ", comleb=" + comleb + ", file=" + file + ", filesize=" + filesize
            + ", allfilesize=" + allfilesize + ", imgsize=" + imgsize + ", thimgsize=" + thimgsize + "]";
   }
    
    
}
