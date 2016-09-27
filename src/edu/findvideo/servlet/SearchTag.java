/*    */ package edu.findvideo.servlet;
/*    */ 
/*    */ import edu.findvideo.bean.Tag;
/*    */ import edu.findvideo.dao.TagDao;
/*    */ import edu.findvideo.factory.DaoFactory;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import javax.servlet.RequestDispatcher;
/*    */ import javax.servlet.ServletException;
/*    */ import javax.servlet.http.HttpServlet;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ 
/*    */ public class SearchTag extends HttpServlet
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/* 19 */   private TagDao tagDao = DaoFactory.getInstance().getTagDao();
/*    */ 
/*    */   public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
/*    */   {
/* 23 */     String category1 = request.getParameter("category1");
/* 24 */     String category2 = request.getParameter("category2");
/* 25 */     String category3 = request.getParameter("category3");
/* 26 */     String category4 = request.getParameter("category4");
/* 27 */     Tag tag = new Tag();
/* 28 */     tag.setCategory1(category1);
/* 29 */     tag.setCategory2(category2);
/* 30 */     tag.setCategory3(category3);
/* 31 */     tag.setCategory4(category4);
/* 32 */     List taglist = this.tagDao.listTag(tag);
/* 33 */     request.setAttribute("taglist", taglist);
/* 34 */     request.getRequestDispatcher("searchtag.jsp").forward(request, response);
/*    */   }
/*    */ }

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.servlet.SearchTag
 * JD-Core Version:    0.6.1
 */