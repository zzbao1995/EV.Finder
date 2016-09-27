package edu.findvideo.servlet;

import edu.findvideo.util.SenUtil;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Analysis extends HttpServlet
{
  private static final long serialVersionUID = 1L;

  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    String sentence = request.getParameter("sentence");
    if ((sentence.length() == 0) || (sentence.equals("")))
      request.getRequestDispatcher("analysisInput.jsp").forward(request, response);
    request.setAttribute("grammas", SenUtil.getInstance().getGrammasBySentence(sentence, 0));
    request.getRequestDispatcher("analysisDetail.jsp").forward(request, response);
  }
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.servlet.Analysis
 * JD-Core Version:    0.6.1
 */