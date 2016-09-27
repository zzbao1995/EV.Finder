package edu.findvideo.servlet;

import edu.findvideo.dao.MediaDao;
import edu.findvideo.factory.DaoFactory;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class logins extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    String name = request.getParameter("name");
    String first = request.getParameter("first");
    int f = Integer.parseInt(first);
    request.setAttribute("mediaList", DaoFactory.getInstance().getMediaDao().getDetail(name, f));
    request.getRequestDispatcher("WEB-INF/adminhelp.jsp").forward(request, response);
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    doPost(request, response);
  }
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.servlet.logins
 * JD-Core Version:    0.6.1
 */