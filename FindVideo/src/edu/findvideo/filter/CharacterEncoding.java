package edu.findvideo.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CharacterEncoding
  implements Filter
{
  String characterEncoding;
  boolean enabled;

  public void destroy()
  {
    this.characterEncoding = null;
  }

  public void init(FilterConfig config) throws ServletException {
    this.characterEncoding = config.getInitParameter("characterEncoding");
    if ("true".equalsIgnoreCase(config.getInitParameter("enabled")))
      this.enabled = true;
  }

  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException
  {
    if (this.enabled)
    {
      ((HttpServletRequest)request).setCharacterEncoding(this.characterEncoding);
      ((HttpServletResponse)response).setCharacterEncoding(this.characterEncoding);
    }
    chain.doFilter(request, response);
  }
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.filter.CharacterEncoding
 * JD-Core Version:    0.6.1
 */