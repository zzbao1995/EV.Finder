package edu.findvideo.listener;

import edu.findvideo.util.CountVisitor;
import java.io.PrintStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class VisitorListener
  implements ServletContextListener
{
  private CountVisitor cVisitor = new CountVisitor();

  public void contextDestroyed(ServletContextEvent arg0)
  {
    System.out.println("我是listen");
  }

  public void contextInitialized(ServletContextEvent arg0)
  {
    System.out.println("我是listendes");
    arg0.getServletContext().setAttribute("visitorCount", Long.valueOf(this.cVisitor.readCount()));
  }
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.listener.VisitorListener
 * JD-Core Version:    0.6.1
 */