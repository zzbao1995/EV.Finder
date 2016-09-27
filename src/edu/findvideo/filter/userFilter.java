package edu.findvideo.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class userFilter extends HttpServlet
  implements Filter
{
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
    throws IOException, ServletException
  {
    RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/admin.jsp");

    HttpServletRequest req = (HttpServletRequest)request;
    HttpServletResponse res = (HttpServletResponse)response;
    HttpSession session = req.getSession(true);

    String username = (String)session.getAttribute("username");

    if ((username == null) || ("".equals(username)))
    {
      res.sendRedirect("login.jsp");
    }
    else
    {
      chain.doFilter(request, response);
    }
  }

  public void init(FilterConfig arg0)
    throws ServletException
  {
  }
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.filter.userFilter
 * JD-Core Version:    0.6.1
 */