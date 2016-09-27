package edu.findvideo.tag;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class DigestTag extends BodyTagSupport
{
  private static final long serialVersionUID = 1L;
  private String key;

  public int doEndTag()
    throws JspException
  {
    String content = getBodyContent().getString();

    if (content.length() > 120) {
      content = content.substring(0, 120);
      StringBuffer buffer = new StringBuffer(content);
      buffer.insert(80, "<br>");
      buffer.insert(40, "<br>");
      buffer.append("...");
      content = buffer.toString();
    }

    content = content.replaceAll(this.key,
      "<span>" + this.key + "</span>");
    JspWriter out = this.pageContext.getOut();
    try {
      out.print(content);
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    return 6;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getKey() {
    return this.key;
  }
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.tag.DigestTag
 * JD-Core Version:    0.6.1
 */