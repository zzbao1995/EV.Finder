package edu.findvideo.servlet;

import edu.findvideo.bean.Media;
import edu.findvideo.bean.SimpleSub;
import edu.findvideo.bean.Tag;
import edu.findvideo.dao.MediaDao;
import edu.findvideo.dao.TagDao;
import edu.findvideo.factory.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

 public class TagManager extends HttpServlet
 {
   private static final long serialVersionUID = 1L;
   private TagDao tagDao = DaoFactory.getInstance().getTagDao();

   private MediaDao mediaDao = DaoFactory.getInstance().getMediaDao();

   public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
   {
       request.setCharacterEncoding("utf-8");
     String method = request.getParameter("method");
     if (method.equals("add")) {
       String mediaid = request.getParameter("mediaid");
       String mediaurl = request.getParameter("mediaurl");
       String medianame = request.getParameter("medianame");
       String starttime = request.getParameter("starttime");
       String endtime = request.getParameter("endtime");
       String category1 = request.getParameter("category1");
       String category2 = request.getParameter("category2");
       String category3 = request.getParameter("category3");
       String category4 = request.getParameter("category4");
       String description = request.getParameter("description");
       HttpSession hs = request.getSession(true);
       String username = (String)hs.getAttribute("username");

       Tag tag = new Tag();
       tag.setMediaid(Integer.parseInt(mediaid));
       tag.setMediaurl(mediaurl);
       tag.setMedianame(medianame);
       tag.setStarttime(Double.parseDouble(starttime));
       tag.setEndtime(Double.parseDouble(endtime));
       tag.setCategory1(category1);
       tag.setCategory2(category2);
       tag.setCategory3(category3);
       tag.setCategory4(category4);
       tag.setDescription(description);

       tag.setusername(username);
       this.tagDao.addTag(tag);
       Media m = this.mediaDao.getMediaById(Integer.parseInt(mediaid));
       SimpleSub ss = new SimpleSub();
       ss.setMediaid(Integer.parseInt(mediaid));
       ss.setMediaTitle(m.getMediaTitle());
       ss.setMediaUrl(m.getUrl());
       ss.setStartTime(0.0D);
       ss.setEndTime(m.getDuration());
       request.setAttribute("SimpleSub", ss);
       List categorylist1 = this.tagDao.listCategory1();
       List categorylist2 = this.tagDao.listCategory2();
       List categorylist3 = this.tagDao.listCategory3();
       List categorylist4 = this.tagDao.listCategory4();
       request.setAttribute("categorylist1", categorylist1);
       request.setAttribute("categorylist2", categorylist2);
       request.setAttribute("categorylist3", categorylist3);
       request.setAttribute("categorylist4", categorylist4);
       request.setAttribute("info", "标签添加成功");

        response.setContentType("text/json;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String msg="ok";
        StringBuffer s = new StringBuffer("{\"resWord\":\""+msg+"\"}");

        out.print(s.toString());

     }
     else if (method.equals("play")) {
       String mediaur = request.getParameter("mediaurl");
       String mediaurl = mediaur.substring(0,mediaur.length()-1);
       String starttm = request.getParameter("starttime");
       String starttime = starttm.substring(0,starttm.length()-1);
       String endtm = request.getParameter("endtime");
       String endtime = endtm.substring(0,endtm.length()-1);
       String url = mediaurl + "?start=" + starttime + "&end=" + endtime;
       request.setAttribute("url", url);
       request.getRequestDispatcher("playtag.jsp").forward(request, response);
     }
   }
 }

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.servlet.TagManager
 * JD-Core Version:    0.6.1
 */