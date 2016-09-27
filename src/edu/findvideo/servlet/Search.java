package edu.findvideo.servlet;

import edu.findvideo.dao.SubtitleDao;
import edu.findvideo.factory.DaoFactory;
import edu.findvideo.util.PageModel;
import edu.findvideo.util.PageSize;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.java.sen.StringTagger;
import net.java.sen.Token;

public class Search extends HttpServlet
{
  private static final long serialVersionUID = 4953200673649992225L;
  private SubtitleDao subtitleDao = DaoFactory.getInstance().getSubtitleDao();

  public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException
  {
    int key = 0;
    request.setCharacterEncoding("UTF-8");
    String keyword = request.getParameter("keywords");

    List complexset = new ArrayList();
    complexset.add("原型搜索");
    complexset.add("分词搜索");
    request.setAttribute("complexsets", complexset);

    String complex = request.getParameter("complex");
    if (complex == null) {
      complex = (String)request.getSession().getAttribute("complex");
    }
    String baseword = null;
    System.out.println(keyword + "-++-" + baseword + "--" + complex);
    if ((keyword == null) || (keyword.equals(""))) {
      keyword = (String)request.getSession().getAttribute("keyword");
      if ((keyword == null) || (keyword.equals(""))) {
        key = 1;
      }
    }
    if (key != 1) {
      baseword = useSen(keyword);
    }

    System.out.println("key"+key);
    if (key == 0)
    {
      System.out.println(keyword + "---" + baseword + "--" + complex);

      findResult(request, keyword, baseword, complex);
      HttpSession session = request.getSession();
      session.setAttribute("keyword", keyword);
      session.setAttribute("complex", complex);
      request.getRequestDispatcher("search.jsp").forward(request, response);
    } else {
    // request.getRequestDispatcher("index.jsp").forward(request, response);
    response.sendRedirect("index.jsp");
    }
  }

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    doPost(request, response);
}


/**
 * 分词功能,将关键词分词..中文分词失败..
 * 就是将空格分隔的关键词分拣出来以供查询..
 * @param keyword
 * @return
 * @throws IOException
 */
private String useSen(String keyword) throws IOException {
  File path = new File(Thread.currentThread().getContextClassLoader().getResource("").toString());
  String abPath = path.getParentFile().getPath();
  abPath = abPath.substring(5, abPath.length());
  String confPath = abPath + "/senDic/conf/sen.xml";
    System.out.println(confPath);
  confPath = confPath.replaceAll("%20", " ");
   System.out.println(path + "  " + abPath + "  " + confPath + "  ");

  StringTagger tagger = StringTagger.getInstance(confPath);
  Token[] token = tagger.analyze(keyword);
  String re = token[0].getBasicString();
  if (re == null) {
    return keyword;
  }
  return re;
}

/**
 * 通过关键词找到结果..
 * @param request
 * @param keyword  搜索关键词..
 * @param baseword
 * @param complex  原型搜索,或者分词搜索
 *                 在这里设置了每个页面结果的个数,并把分词类型,顺序放入session中..
 *                 将生成的页面模型放入了session中
 */
private void findResult(HttpServletRequest request, String keyword, String baseword, String complex) {
    int pageNum = 1;
    int pageSize = 0;
    String order = request.getParameter("order");//顺序
    String media_class = request.getParameter("media_class");//分类类型
    System.out.println(media_class);
    if (media_class == null) {
      media_class = request.getSession().getAttribute("media_class").toString();
    }
    if (order == null) {
      order = request.getSession().getAttribute("order").toString();
    }
    request.getSession().setAttribute("order", order);
    request.getSession().setAttribute("media_class", media_class);
    String ps = request.getParameter("CpageSize");
    if ((ps == null) || (ps.equals(""))) {
      if (request.getSession().getAttribute("pageSize") != null)
        pageSize = ((Integer)request.getSession().getAttribute("pageSize")).intValue();
      else
      //默认页大小为10
      pageSize = PageSize.PAGE_SIZE;
    }
    else {
      pageSize = Integer.parseInt(ps);
      HttpSession session = request.getSession();
      session.setAttribute("pageSize", Integer.valueOf(pageSize));
    }
    if (request.getParameter("pageNo") != null) {
      pageNum = Integer.parseInt(request.getParameter("pageNo"));
    }
    PageModel pm = this.subtitleDao.getContentByKeyword(pageNum, pageSize, keyword, baseword, complex, order, media_class);

    request.setAttribute("resultCount", Integer.valueOf(pm.getResultCount()));
    request.setAttribute("pm", pm);
  }
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.servlet.Search
 * JD-Core Version:    0.6.1
 */