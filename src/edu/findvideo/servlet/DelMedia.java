package edu.findvideo.servlet;

import edu.findvideo.dao.DeleteVideoDao;
import edu.findvideo.dao.MediaDao;
import edu.findvideo.factory.DaoFactory;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DelMedia extends HttpServlet
{
  private DeleteVideoDao delvideo = DaoFactory.getDeleteVideoDao();

  public void destroy()
  {
    super.destroy();
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    String mediaId = request.getParameter("id");
    boolean subtitleFlag = this.delvideo.deleteSubtitle(Integer.parseInt(mediaId));
    boolean mediaFlag = false;
    if (subtitleFlag) {
      mediaFlag = this.delvideo.deleteMedia(Integer.parseInt(mediaId));
      request.setAttribute("mediaList", DaoFactory.getInstance().getMediaDao().getAll());

      request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
      return;
    }

    request.setAttribute("mediaList", DaoFactory.getInstance().getMediaDao().getAll());

    request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doGet(request, response);
  }

  public void init()
    throws ServletException
  {
  }
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.servlet.DelMedia
 * JD-Core Version:    0.6.1
 */