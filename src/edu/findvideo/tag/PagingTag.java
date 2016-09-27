package edu.findvideo.tag;

import edu.findvideo.util.PageSize;
import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.TagSupport;

public class PagingTag extends TagSupport
{
  private static final long serialVersionUID = -8592367701351317265L;
  private int pageSize = PageSize.PAGE_SIZE;
  private String gotoURI = null;

  private String id = null;
  public static final String PAGE_NO = "pageNo";

  public int getPageSize()
  {
    return this.pageSize;
  }

  public void setPageSize(int pageSize) {
    PageSize.PAGE_SIZE = pageSize;
    this.pageSize = pageSize;
  }

  public String getGotoURI() {
    return this.gotoURI;
  }

  public void setGotoURI(String gotoURI) {
    this.gotoURI = gotoURI;
  }

  public int doStartTag()
    throws JspException
  {
    int pageNo = 1;
    HttpServletRequest request = (HttpServletRequest)this.pageContext.getRequest();
    int resultCount = ((Integer)request.getAttribute("resultCount")).intValue();
    String ps = request.getParameter("CpageSize");
    if ((ps == null) || (ps.equals(""))) {
      if (request.getSession().getAttribute("pageSize") != null)
        this.pageSize = ((Integer)request.getSession().getAttribute("pageSize")).intValue();
      else
        this.pageSize = PageSize.PAGE_SIZE;
    }
    else {
      this.pageSize = Integer.parseInt(ps);
      HttpSession session = request.getSession();
      session.setAttribute("pageSize", Integer.valueOf(this.pageSize));
    }

    StringBuffer sb = new StringBuffer();
    Enumeration enumeration = request.getParameterNames();
    String name = null;
    String value = null;

    while (enumeration.hasMoreElements()) {
      name = (String)enumeration.nextElement();
      value = request.getParameter(name);

      if ((name.equals("pageNo")) &&
        (value != null) && (!value.equals(""))) {
        pageNo = Integer.parseInt(value);
      }

    }

    int totalPage = getTotalPage(resultCount, this.pageSize);

    sb.append("<p>共&nbsp;").append(totalPage).append("&nbsp;页\n</p>");
    sb.append("<ul class=pagination>");
    if (pageNo != 1) {
      sb.append("<li><a href=\"").append(this.gotoURI).append("?pageNo=1\"")
        .append("\" id=\"btnTopPage\">首页</a></li>");
      sb.append("<li><a href=\"").append(this.gotoURI).append("?pageNo=").append(
        pageNo - 1).append("\" id=\"btnPreviousPage\">&laquo;</a></li>");
      sb.append("<li><a href=##>..</a></li>");
    }
      int i=1;
    for ( i = pageNo; i <= totalPage&&i<=pageNo+5; i++) {
      if (i == pageNo)
        sb.append("<li><span>").append(i).append("</span></li>");
      else {
        sb.append("<li><a href=\"").append(this.gotoURI).append("?pageNo=").append(
          i).append("\" id=\"toPage\">").append(i).append("</a></li>");
      }
    }
      if(i>pageNo+5 && i<totalPage){
          sb.append("<li><a href=#>..</a><li>");
      }
    if (totalPage != pageNo) {
      sb.append("<li><a href=\"").append(this.gotoURI).append("?pageNo=").append(
        pageNo + 1).append("\" id=\"btnNextPage\">&raquo;</a></li>");
      sb.append("<li><a href=\"").append(this.gotoURI).append("?pageNo=").append(
        totalPage).append("\" id=\"btnBottomPage\">尾页</a></li>");
    }
    sb.append("</ul>");
    try {
      this.pageContext.getOut().println(sb.toString());
    } catch (IOException e) {
      e.printStackTrace();
    }
    return 0;
  }

  public int getTotalPage(int resultCount, int pageSize) {
    int totalPage = 1;
    if (resultCount == 0) {
      return totalPage;
    }
    return resultCount % pageSize == 0 ? resultCount / pageSize :
      resultCount / pageSize + 1;
  }
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.tag.PagingTag
 * JD-Core Version:    0.6.1
 */