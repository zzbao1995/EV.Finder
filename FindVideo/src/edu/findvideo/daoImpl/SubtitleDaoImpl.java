package edu.findvideo.daoImpl;

import edu.findvideo.bean.Media;
import edu.findvideo.bean.SimpleSub;
import edu.findvideo.bean.Subtitle;
import edu.findvideo.dao.SubtitleDao;
import edu.findvideo.util.DB;
import edu.findvideo.util.MarkContent;
import edu.findvideo.util.PageModel;
import java.io.PrintStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SubtitleDaoImpl
  implements SubtitleDao
{
  public PageModel getContentByKeyword(int pageNum, int pageSize, String keyword, String baseword, String complex, String order, String media_class)
  {
    PageModel pm = new PageModel();
    pm.setPageSize(pageSize);
    ArrayList al = new ArrayList();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql1 = "select * from media as m where exists (select content from subtitle as s where content like '%" +
      keyword + "%' and s.media_id = m.media_id) " +
      "order by media_id  limit ?,?";
    String sql2 = "select * from media as m where exists (select content from subtitle as s where content like '%" +
      keyword + "%' and s.media_id = m.media_id) " +
      "order by random DESC limit ?,?";
    String sql3 = "select * from media as m where exists (select content from subtitle as s where content like '%" +
      keyword + "%' and s.media_id = m.media_id) and m.media_class like '%" + media_class + "%' " +
      "order by media_id  limit ?,?";
    String sql4 = "select * from media as m where exists (select content from subtitle as s where content like '%" +
      keyword + "%' and s.media_id = m.media_id) and m.media_class like '%" + media_class + "%' " +
      "order by random  limit ?,?";
    int count = 0;
    try {
      conn = DB.getConnection();
      if (("乱序".equals(order)) && ("所有类".equals(media_class))) {
        pstmt = conn.prepareStatement(sql2);
        pstmt.setInt(1, (pageNum - 1) * pageSize);
        pstmt.setInt(2, pageSize);
        rs = pstmt.executeQuery();
        System.out.println(sql2);
      }
      else if (("乱序".equals(order)) && (!"所有类".equals(media_class)))
      {
        pstmt = conn.prepareStatement(sql4);

        pstmt.setInt(1, (pageNum - 1) * pageSize);
        pstmt.setInt(2, pageSize);
        rs = pstmt.executeQuery();
        System.out.println(sql4);
      }
      else if ((!"乱序".equals(order)) && ("所有类".equals(media_class))) {
        pstmt = conn.prepareStatement(sql1);
        pstmt.setInt(1, (pageNum - 1) * pageSize);
        pstmt.setInt(2, pageSize);
        rs = pstmt.executeQuery();
        System.out.println(sql1);
      }
      else {
        pstmt = conn.prepareStatement(sql3);

        pstmt.setInt(1, (pageNum - 1) * pageSize);
        pstmt.setInt(2, pageSize);
        rs = pstmt.executeQuery();
        System.out.println(sql3);
      }

      while (rs.next()) {
        Media media = new Media();
        media.setMediaId(rs.getInt(1));
        System.out.println(rs.getInt(1));
        media.setMediaTitle(rs.getString(2));
        media.setMediaType(rs.getString(3));
        media.setDuration(rs.getInt(4));
        media.setUrl(rs.getString(5));

        ArrayList subtitleList = getSubtitle(media, keyword);
        if ((!keyword.equals(baseword)) && (complex.equals("分词搜索"))) {
          ArrayList subtitleListBase = getSubtitle(media, baseword);
          if (subtitleListBase != null) {
            subtitleList.addAll(subtitleListBase);
          }

        }

        if (subtitleList != null)
          al.add(subtitleList);
      }
      count = getResultCount(conn, keyword, media_class);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DB.closeRs(rs);
      DB.closeStmt(pstmt);
      DB.closeConn(conn);
    }

    pm.setResultCount(count);
    pm.setList(al);

    return pm;
  }

  private ArrayList<Subtitle> getSubtitle(Media media, String keyword) {
    MarkContent mc = new MarkContent();
    ArrayList subtitleList = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select * from subtitle where content like '%" + keyword +
      "%' and media_id = " + media.getMediaId();
    try {
      conn = DB.getConnection();
      pstmt = conn.prepareStatement(sql);

      rs = pstmt.executeQuery();

      while (rs.next())
      {
        Subtitle sub = new Subtitle();
        sub.setSubtitleId(rs.getInt(1));
        sub.setMedia(media);
        sub.setStartTime(rs.getDouble(3));
        sub.setEndTime(rs.getDouble(4));
        String markContent = mc.setMarkInContent(rs.getString(5), keyword);
        sub.setContent(rs.getString(5));
        sub.setContentMark(markContent);
        if (subtitleList == null)
        {
          subtitleList = new ArrayList();
        }
        subtitleList.add(sub);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DB.closeConn(conn);
      DB.closeRs(rs);
      DB.closeStmt(pstmt);
    }

    return subtitleList;
  }

  public int getResultCount(Connection conn, String keyword, String media_class)
  {
    int count = 0;
    Statement stmt = null;
    ResultSet rs = null;
    String sql;

    if ("所有类".equals(media_class)) {
      sql = "select count(*) from media as m where exists (select content from subtitle as s where content like '%" +
        keyword + "%' and s.media_id = m.media_id) ";
    }
    else
      sql = "select count(*) from media as m where exists (select content from subtitle as s where content like '%" +
        keyword + "%' and s.media_id = m.media_id) and m.media_class like '%" + media_class + "%' ";
    try
    {
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);
      if (rs.next())
        count = rs.getInt(1);
    }
    catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DB.closeConn(conn);
      DB.closeRs(rs);
      DB.closeStmt(stmt);
    }

    return count;
  }
  public int getTotal(Connection conn) {
    int count = 0;
    Statement stmt = null;
    ResultSet rs = null;
    String sql = "select count(*) from media";
    try {
      stmt = conn.createStatement();
      rs = stmt.executeQuery(sql);
      if (rs.next())
        count = rs.getInt(1);
    }
    catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DB.closeConn(conn);
      DB.closeRs(rs);
      DB.closeStmt(stmt);
    }

    return count;
  }

  public SimpleSub getFBcontentBySubId(int subId, int mediaId, int contentF, int contentB)
  {
    ArrayList ssList = new ArrayList();
    String contentM = "";
    SimpleSub ss2 = new SimpleSub();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    String sql = "select * from subtitle where media_id = ? and subtitle_id between ? and ?";
    try
    {
      conn = DB.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, mediaId);
      pstmt.setInt(2, subId - contentF);
      pstmt.setInt(3, subId + contentB);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        SimpleSub ss = new SimpleSub();
        ss.setStartTime(rs.getDouble(3));
        ss.setEndTime(rs.getDouble(4));
        contentM = contentM + rs.getString(5) + "<br>";
        ssList.add(ss);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DB.closeConn(conn);
      DB.closeStmt(pstmt);
      DB.closeRs(rs);
    }

    Double startTM = Double.valueOf(((SimpleSub)ssList.get(0)).getStartTime());
    int size = ssList.size();
    Double endTM = Double.valueOf(((SimpleSub)ssList.get(size - 1)).getEndTime());

    ss2.setContent(contentM);
    ss2.setStartTime(startTM.doubleValue());
    ss2.setEndTime(endTM.doubleValue());

    return ss2;
  }
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.daoImpl.SubtitleDaoImpl
 * JD-Core Version:    0.6.1
 */