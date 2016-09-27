package edu.findvideo.servlet;

import edu.findvideo.bean.SimpleSub;
import edu.findvideo.dao.SubtitleDao;
import edu.findvideo.factory.DaoFactory;
import edu.findvideo.util.MarkContent;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Play extends HttpServlet
{
  private static final long serialVersionUID = 4898152718138658297L;
  SubtitleDao subtitleDao = DaoFactory.getInstance().getSubtitleDao();

  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
  {
    MarkContent mc = new MarkContent();
    String keyword = (String)request.getSession().getAttribute("keyword");

    request.setCharacterEncoding("UTF-8");
    SimpleSub ss = new SimpleSub();
    String mediaTitle = request.getParameter("mediaTitle");
    String content = request.getParameter("content");
    double startTime = Double.parseDouble(request.getParameter("startTime"));
    double endTime = Double.parseDouble(request.getParameter("endTime"));
    String mediaUrl = request.getParameter("mediaUrl");
    String change = request.getParameter("change");
    int duration = Integer.parseInt(request.getParameter("duration"));
    int mediaId = Integer.parseInt(request.getParameter("mediaId"));

    if (change.equals("time")) {
      int changeST = Integer.parseInt(request.getParameter("changeST"));
      int changeET = Integer.parseInt(request.getParameter("changeET"));
      double st = startTime - changeST;
      double et = endTime + changeET;
      if (st < 0.0D)
        ss.setStartTime(0.0D);
      else {
        ss.setStartTime(st);
      }
      if (et > duration)
        ss.setEndTime(duration);
      else
        ss.setEndTime(et);
    }
    else if (change.equals("content")) {
      int contentF = Integer.parseInt(request.getParameter("contentForward"));
      int contentB = Integer.parseInt(request.getParameter("contentBackward"));

      int subId = Integer.parseInt(request.getParameter("subtitleId"));
      SimpleSub ss2 = this.subtitleDao.getFBcontentBySubId(subId, mediaId, contentF, contentB);
      ss.setStartTime(ss2.getStartTime());
      ss.setEndTime(ss2.getEndTime() + 2.0D);
      content = ss2.getContent();
    }
    ss.setMediaTitle(mediaTitle);
    ss.setContent(content);
    ss.setMediaUrl(mediaUrl);
    ss.setContentMark(mc.setMarkInContent(content, keyword));
    request.setAttribute("SimpleSub", ss);
    request.getRequestDispatcher("/JWPlayer/play.jsp").forward(request, response);
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    doPost(request, response);
  }
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.servlet.Play
 * JD-Core Version:    0.6.1
 */