package edu.findvideo.servlet;

import edu.findvideo.dao.TagDao;
import edu.findvideo.factory.DaoFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Index2 extends HttpServlet
{
  private static final long serialVersionUID = 1L;
  private TagDao tagDao = DaoFactory.getInstance().getTagDao();

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    List categorylist1 = this.tagDao.listCategory1();
    List categorylist2 = this.tagDao.listCategory2();
    List complexset = new ArrayList();
    complexset.add("原型搜索");
    complexset.add("分词搜索");
    request.setAttribute("complexsets", complexset);
    request.setAttribute("categorylist1", categorylist1);
    request.setAttribute("categorylist2", categorylist2);
    request.getRequestDispatcher("FindVideo2.jsp").forward(request, response);
  }
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.servlet.Index2
 * JD-Core Version:    0.6.1
 */