package edu.findvideo.servlet;

import edu.findvideo.bean.SimpleSub;
import java.io.IOException;
import java.io.PrintStream;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PlayAll extends HttpServlet
{
  public void destroy()
  {
    super.destroy();
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    SimpleSub simpleSub = (SimpleSub)request.getSession().getAttribute("SimSub");
    request.setAttribute("SimpleSub", simpleSub);
    System.out.println(simpleSub.getMediaUrl());
    request.getRequestDispatcher("/JWPlayer/playWhole.jsp").forward(request, response);
  }

  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    SimpleSub simpleSub = (SimpleSub)request.getAttribute("SimpleSub");
    request.setAttribute("SimpleSub", simpleSub);
    request.getRequestDispatcher("JWPlayer/playWhole.jsp").forward(request, response);
  }

  public void init()
    throws ServletException
  {
  }
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.servlet.PlayAll
 * JD-Core Version:    0.6.1
 */