/*     */ package edu.findvideo.daoImpl;
/*     */ 
/*     */ import edu.findvideo.bean.Tag;
/*     */ import edu.findvideo.dao.TagDao;
/*     */ import edu.findvideo.util.DB;
/*     */ import java.io.PrintStream;
/*     */ import java.sql.Connection;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ 
/*     */ public class TagDaoImpl
/*     */   implements TagDao
/*     */ {
/*     */   public void addTag(Tag tag)
/*     */   {
/*  24 */     Connection conn = null;
/*  25 */     PreparedStatement pstmt = null;
/*  26 */     ResultSet rs = null;
/*  27 */     String sql = "insert into tag(mediaid,mediaurl,medianame,starttime,endtime,category1,category2,category3,category4,description,username) values (?,?,?,?,?,?,?,?,?,?,?)";
/*     */     try
/*     */     {
/*  31 */       conn = DB.getConnection();
/*  32 */       pstmt = conn.prepareStatement(sql);
/*  33 */       pstmt.setInt(1, tag.getMediaid());
/*  34 */       pstmt.setString(2, tag.getMediaurl());
/*  35 */       pstmt.setString(3, tag.getMedianame());
/*  36 */       pstmt.setDouble(4, tag.getStarttime());
/*  37 */       pstmt.setDouble(5, tag.getEndtime());
/*  38 */       pstmt.setString(6, tag.getCategory1());
/*  39 */       pstmt.setString(7, tag.getCategory2());
/*  40 */       pstmt.setString(8, tag.getCategory3());
/*  41 */       pstmt.setString(9, tag.getCategory4());
/*  42 */       pstmt.setString(10, tag.getDescription());
/*     */ 
/*  44 */       pstmt.setString(11, tag.getusername());
/*  45 */       pstmt.execute();
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/*  49 */       e.printStackTrace();
/*     */     } finally {
/*  51 */       DB.closeRs(rs);
/*  52 */       DB.closeStmt(pstmt);
/*  53 */       DB.closeConn(conn);
/*     */     }
/*     */   }
/*     */ 
/*     */   public List listTag(Tag tag)
/*     */   {
/*  65 */     List result = new ArrayList();
/*  66 */     Connection conn = null;
/*  67 */     PreparedStatement pstmt = null;
/*  68 */     ResultSet rs = null;
/*  69 */     int preParams = 0;
/*  70 */     StringBuffer buffer = new StringBuffer();
/*  71 */     buffer.append("select * from tag where ");
/*  72 */     if (!tag.getCategory1().equals("未分类"))
/*     */     {
/*  74 */       if (preParams == 0)
/*     */       {
/*  76 */         buffer.append("category1='" + tag.getCategory1() + "'");
/*     */       }
/*     */       else {
/*  79 */         buffer.append(" and category1='" + tag.getCategory1() + "'");
/*     */       }
/*  81 */       preParams++;
/*     */     }
/*  83 */     if (!tag.getCategory2().equals("未分类"))
/*     */     {
/*  85 */       if (preParams == 0)
/*     */       {
/*  87 */         buffer.append("category2='" + tag.getCategory2() + "'");
/*     */       }
/*     */       else {
/*  90 */         buffer.append(" and category2='" + tag.getCategory2() + "'");
/*     */       }
/*  92 */       preParams++;
/*     */     }
/*  94 */     if (!tag.getCategory3().equals("未分类"))
/*     */     {
/*  96 */       if (preParams == 0)
/*     */       {
/*  98 */         buffer.append("category3='" + tag.getCategory3() + "'");
/*     */       }
/*     */       else {
/* 101 */         buffer.append(" and category3='" + tag.getCategory3() + "'");
/*     */       }
/* 103 */       preParams++;
/*     */     }
/* 105 */     if (!tag.getCategory4().equals("未分类"))
/*     */     {
/* 107 */       if (preParams == 0)
/*     */       {
/* 109 */         buffer.append("category4='" + tag.getCategory4() + "'");
/*     */       }
/*     */       else {
/* 112 */         buffer.append(" and category4='" + tag.getCategory4() + "'");
/*     */       }
/* 114 */       preParams++;
/*     */     }
/* 116 */     System.out.println(tag.getCategory1() + tag.getCategory2() + tag.getCategory3() + tag.getCategory4());
/*     */     try
/*     */     {
/* 119 */       conn = DB.getConnection();
/* 120 */       if (preParams != 0)
/*     */       {
/* 122 */         pstmt = conn.prepareStatement(buffer.toString());
/*     */       }
/*     */       else
/* 125 */         pstmt = conn.prepareStatement("select * from tag");
/*     */       Tag t;
/* 129 */       for (rs = pstmt.executeQuery(); rs.next(); result.add(t))
/*     */       {
/* 131 */         t = new Tag();
/* 132 */         t.setTagid(rs.getInt("tagid"));
/* 133 */         t.setMediaurl(rs.getString("mediaurl"));
/* 134 */         t.setMedianame(rs.getString("medianame"));
/*     */ 
/* 136 */         t.setusername(rs.getString("username"));
/* 137 */         String c1 = rs.getString("category1");
/* 138 */         String c2 = rs.getString("category2");
/* 139 */         String c3 = rs.getString("category3");
/* 140 */         String c4 = rs.getString("category4");
/*     */ 
/* 142 */         String info = rs.getString("description");
/* 143 */         if ((c1 == null) || (c1.equals("未分类")))
/*     */         {
/* 145 */           t.setCategory1("");
/*     */         }
/*     */         else {
/* 148 */           t.setCategory1(c1);
/*     */         }
/* 150 */         if ((c2 == null) || (c2.equals("未分类")))
/*     */         {
/* 152 */           t.setCategory2("");
/*     */         }
/*     */         else {
/* 155 */           t.setCategory2(c2);
/*     */         }
/* 157 */         if ((c3 == null) || (c3.equals("未分类")))
/*     */         {
/* 159 */           t.setCategory3("");
/*     */         }
/*     */         else {
/* 162 */           t.setCategory3(c3);
/*     */         }
/* 164 */         if ((c4 == null) || (c4.equals("未分类")))
/*     */         {
/* 166 */           t.setCategory4("");
/*     */         }
/*     */         else {
/* 169 */           t.setCategory4(c4);
/*     */         }
/* 171 */         if ((info == null) || (info.equals("null")))
/*     */         {
/* 173 */           t.setDescription("暂无描述");
/*     */         }
/*     */         else {
/* 176 */           t.setDescription(info);
/*     */         }
/* 178 */         t.setStarttime(Double.parseDouble(rs.getString("starttime")));
/* 179 */         t.setEndtime(Double.parseDouble(rs.getString("endtime")));
/*     */       }
/*     */     }
/*     */     catch (SQLException e)
/*     */     {
/* 184 */       e.printStackTrace();
/*     */     } finally {
/* 186 */       DB.closeRs(rs);
/* 187 */       DB.closeStmt(pstmt);
/* 188 */       DB.closeConn(conn);
/*     */     }
/* 190 */     return result;
/*     */   }
/*     */ 
/*     */   public List<String> listCategory1() {
/* 194 */     List result = new ArrayList();
/* 195 */     Connection conn = null;
/* 196 */     PreparedStatement pstmt = null;
/* 197 */     ResultSet rs = null;
/* 198 */     String sql = "select name from tag_category1";
/*     */     try {
/* 200 */       conn = DB.getConnection();
/* 201 */       if (conn == null) {
/* 202 */         conn = DB.getConnection();
/*     */       }
/* 204 */       pstmt = conn.prepareStatement(sql);
/* 205 */       rs = pstmt.executeQuery();
/* 206 */       while (rs.next())
/* 207 */         result.add(rs.getString("name"));
/*     */     }
/*     */     catch (SQLException e) {
/* 210 */       e.printStackTrace();
/*     */     }
/*     */     finally {
/* 213 */       DB.closeRs(rs);
/* 214 */       DB.closeStmt(pstmt);
/* 215 */       DB.closeConn(conn);
/*     */     }
/* 217 */     return result;
/*     */   }
/*     */   public List<String> listCategory2() {
/* 220 */     List result = new ArrayList();
/* 221 */     Connection conn = null;
/* 222 */     PreparedStatement pstmt = null;
/* 223 */     ResultSet rs = null;
/* 224 */     String sql = "select name from tag_category2";
/*     */     try {
/* 226 */       conn = DB.getConnection();
/* 227 */       if (conn == null) {
/* 228 */         conn = DB.getConnection();
/*     */       }
/* 230 */       pstmt = conn.prepareStatement(sql);
/* 231 */       rs = pstmt.executeQuery();
/* 232 */       while (rs.next())
/* 233 */         result.add(rs.getString("name"));
/*     */     }
/*     */     catch (SQLException e) {
/* 236 */       e.printStackTrace();
/*     */     }
/*     */     finally {
/* 239 */       DB.closeRs(rs);
/* 240 */       DB.closeStmt(pstmt);
/* 241 */       DB.closeConn(conn);
/*     */     }
/* 243 */     return result;
/*     */   }
/*     */   public List<String> listCategory3() {
/* 246 */     List result = new ArrayList();
/* 247 */     Connection conn = null;
/* 248 */     PreparedStatement pstmt = null;
/* 249 */     ResultSet rs = null;
/* 250 */     String sql = "select name from tag_category3";
/*     */     try {
/* 252 */       conn = DB.getConnection();
/* 253 */       if (conn == null) {
/* 254 */         conn = DB.getConnection();
/*     */       }
/* 256 */       pstmt = conn.prepareStatement(sql);
/* 257 */       rs = pstmt.executeQuery();
/* 258 */       while (rs.next())
/* 259 */         result.add(rs.getString("name"));
/*     */     }
/*     */     catch (SQLException e) {
/* 262 */       e.printStackTrace();
/*     */     }
/*     */     finally {
/* 265 */       DB.closeRs(rs);
/* 266 */       DB.closeStmt(pstmt);
/* 267 */       DB.closeConn(conn);
/*     */     }
/* 269 */     return result;
/*     */   }
/*     */   public List<String> listCategory4() {
/* 272 */     List result = new ArrayList();
/* 273 */     Connection conn = null;
/* 274 */     PreparedStatement pstmt = null;
/* 275 */     ResultSet rs = null;
/* 276 */     String sql = "select name from tag_category4";
/*     */     try {
/* 278 */       conn = DB.getConnection();
/* 279 */       if (conn == null) {
/* 280 */         conn = DB.getConnection();
/*     */       }
/* 282 */       pstmt = conn.prepareStatement(sql);
/* 283 */       rs = pstmt.executeQuery();
/* 284 */       while (rs.next())
/* 285 */         result.add(rs.getString("name"));
/*     */     }
/*     */     catch (SQLException e) {
/* 288 */       e.printStackTrace();
/*     */     }
/*     */     finally {
/* 291 */       DB.closeRs(rs);
/* 292 */       DB.closeStmt(pstmt);
/* 293 */       DB.closeConn(conn);
/*     */     }
/* 295 */     return result;
/*     */   }
/*     */ }

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.daoImpl.TagDaoImpl
 * JD-Core Version:    0.6.1
 */