/*    */ package edu.findvideo.bean;
/*    */ 
/*    */ public class Tag
/*    */ {
/*    */   private int tagid;
/*    */   private int mediaid;
/*    */   private String mediaurl;
/*    */   private String medianame;
/*    */   private double starttime;
/*    */   private double endtime;
/*    */   private String category1;
/*    */   private String category2;
/*    */   private String category3;
/*    */   private String category4;
/*    */   private String description;
/*    */   private String username;
/*    */ 
/*    */   public int getMediaid()
/*    */   {
/* 18 */     return this.mediaid;
/*    */   }
/*    */   public String getusername() {
/* 21 */     return this.username;
/*    */   }
/*    */   public void setMediaid(int mediaid) {
/* 24 */     this.mediaid = mediaid;
/*    */   }
/*    */   public void setusername(String username) {
/* 27 */     this.username = username;
/*    */   }
/*    */   public double getStarttime() {
/* 30 */     return this.starttime;
/*    */   }
/*    */   public void setStarttime(double starttime) {
/* 33 */     this.starttime = starttime;
/*    */   }
/*    */   public double getEndtime() {
/* 36 */     return this.endtime;
/*    */   }
/*    */   public void setEndtime(double endtime) {
/* 39 */     this.endtime = endtime;
/*    */   }
/*    */   public void setMediaurl(String mediaurl) {
/* 42 */     this.mediaurl = mediaurl;
/*    */   }
/*    */   public String getMediaurl() {
/* 45 */     return this.mediaurl;
/*    */   }
/*    */   public void setTagid(int tagid) {
/* 48 */     this.tagid = tagid;
/*    */   }
/*    */ 
/*    */   public int getTagid()
/*    */   {
/* 54 */     return this.tagid;
/*    */   }
/*    */   public void setDescription(String description) {
/* 57 */     this.description = description;
/*    */   }
/*    */   public String getDescription() {
/* 60 */     return this.description;
/*    */   }
/*    */   public void setMedianame(String medianame) {
/* 63 */     this.medianame = medianame;
/*    */   }
/*    */   public String getMedianame() {
/* 66 */     return this.medianame;
/*    */   }
/*    */   public void setCategory1(String category1) {
/* 69 */     this.category1 = category1;
/*    */   }
/*    */   public String getCategory1() {
/* 72 */     return this.category1;
/*    */   }
/*    */   public void setCategory2(String category2) {
/* 75 */     this.category2 = category2;
/*    */   }
/*    */   public String getCategory2() {
/* 78 */     return this.category2;
/*    */   }
/*    */   public void setCategory3(String category3) {
/* 81 */     this.category3 = category3;
/*    */   }
/*    */   public String getCategory3() {
/* 84 */     return this.category3;
/*    */   }
/*    */   public void setCategory4(String category4) {
/* 87 */     this.category4 = category4;
/*    */   }
/*    */   public String getCategory4() {
/* 90 */     return this.category4;
/*    */   }
/*    */ }

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.bean.Tag
 * JD-Core Version:    0.6.1
 */