package edu.findvideo.servlet;

import edu.findvideo.dao.MediaDao;
import edu.findvideo.dao.TagDao;
import edu.findvideo.dao.UserDao;
import edu.findvideo.factory.DaoFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    doPost(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    String account = request.getParameter("account");
    String password = request.getParameter("password");
    if ((account.equals("")) || (password.equals("")))
    {
      request.setAttribute("info", "请您输入用户名和密码");
      request.getRequestDispatcher("login.jsp").forward(request, response);
    }
    int judge = DaoFactory.getInstance().getUserDao().validateUser(account, password);
    System.out.println("judge=" + judge);
    if ((1 == judge) || (2 == judge))
    {
      request.setAttribute("mediaList", DaoFactory.getInstance().getMediaDao().getList());
      request.getSession(true).setAttribute("username", account);
      request.getSession(true).setAttribute("judge", Integer.valueOf(judge));
      request.getSession().setMaxInactiveInterval(30000);
      request.getRequestDispatcher("WEB-INF/admin.jsp").forward(request, response);
    }
    else if (judge == 0)
    {
      request.getSession().setAttribute("username", account);
      request.getSession(true).setAttribute("judge", Integer.valueOf(judge));
      request.getSession().setMaxInactiveInterval(30000);
      TagDao tagDao = DaoFactory.getInstance().getTagDao();
      List categorylist1 = tagDao.listCategory1();
      List categorylist2 = tagDao.listCategory2();
      List categorylist3 = tagDao.listCategory3();
      List categorylist4 = tagDao.listCategory4();
      List complexset = new ArrayList();
      complexset.add("原型搜索");
      complexset.add("分词搜索");
      request.setAttribute("complexsets", complexset);
      request.setAttribute("categorylist1", categorylist1);
      request.setAttribute("categorylist2", categorylist2);
      request.setAttribute("categorylist3", categorylist3);
      request.setAttribute("categorylist4", categorylist4);
      request.getRequestDispatcher("findvideo.jsp").forward(request, response);
    }
    else {
      request.setAttribute("info", "您输入的用户名或密码错误");
      request.getRequestDispatcher("login.jsp").forward(request, response);
    }
  }
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.servlet.Login
 * JD-Core Version:    0.6.1
 */