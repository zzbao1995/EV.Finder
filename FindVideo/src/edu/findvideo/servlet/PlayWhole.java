package edu.findvideo.servlet;

import edu.findvideo.bean.Media;
import edu.findvideo.bean.SimpleSub;
import edu.findvideo.dao.MediaDao;
import edu.findvideo.dao.TagDao;
import edu.findvideo.factory.DaoFactory;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PlayWhole extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  private MediaDao mediaDao = DaoFactory.getInstance().getMediaDao();
  private TagDao tagDao = DaoFactory.getInstance().getTagDao();

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
  {
    String mediaid = request.getParameter("id");
    Media m = this.mediaDao.getMediaById(Integer.parseInt(mediaid));
    SimpleSub ss = new SimpleSub();
    ss.setMediaid(Integer.parseInt(mediaid));
    ss.setMediaTitle(m.getMediaTitle());
    ss.setMediaUrl(m.getUrl());
    ss.setStartTime(0.0D);
    ss.setEndTime(m.getDuration());
    List categorylist1 = this.tagDao.listCategory1();
    List categorylist2 = this.tagDao.listCategory2();
    List categorylist3 = this.tagDao.listCategory3();
    List categorylist4 = this.tagDao.listCategory4();
    request.setAttribute("SimpleSub", ss);
    request.setAttribute("categorylist1", categorylist1);
    request.setAttribute("categorylist2", categorylist2);
    request.setAttribute("categorylist3", categorylist3);
    request.setAttribute("categorylist4", categorylist4);
    request.getRequestDispatcher("/WEB-INF/addTag.jsp").forward(request, response);
  }
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.servlet.PlayWhole
 * JD-Core Version:    0.6.1
 */