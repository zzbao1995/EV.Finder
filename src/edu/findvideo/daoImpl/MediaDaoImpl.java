package edu.findvideo.daoImpl;

import edu.findvideo.bean.Media;
import edu.findvideo.dao.MediaDao;
import edu.findvideo.util.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MediaDaoImpl
  implements MediaDao
{
  public List<String> gettitleByid(int id)
  {
    ArrayList titleList = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "select title from subtitle where media_id=" + String.valueOf(id);
    try {
      conn = DB.getConnection();
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        String a = rs.getString("content");
        if (titleList == null) {
          titleList = new ArrayList();
        }
        titleList.add(a);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DB.closeRs(rs);
      DB.closeStmt(pstmt);
      DB.closeConn(conn);
    }
    return titleList;
  }

  public List<Media> getAll() {
    ArrayList mediaList = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "select * from media";
    try {
      conn = DB.getConnection();
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        Media me = new Media();
        me.setMediaId(rs.getInt("media_id"));
        me.setMediaTitle(rs.getString("media_title"));
        me.setDuration(rs.getInt("duration"));
        if (mediaList == null) {
          mediaList = new ArrayList();
        }
        mediaList.add(me);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DB.closeRs(rs);
      DB.closeStmt(pstmt);
      DB.closeConn(conn);
    }
    return mediaList;
  }

  public List<Media> getDetail(String name, int f)
  {
    ArrayList mediaList = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    if (f == 1)
    {
      String sql = "select * from media where media_id < 20";
      try {
        conn = DB.getConnection();
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        while (rs.next()) {
          Media me = new Media();
          me.setMediaId(rs.getInt("media_id"));
          me.setMediaTitle(rs.getString("media_title"));
          me.setDuration(rs.getInt("duration"));
          if (mediaList == null) {
            mediaList = new ArrayList();
          }
          mediaList.add(me);
        }
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        DB.closeRs(rs);
        DB.closeStmt(pstmt);
        DB.closeConn(conn);
      }

    }
    else
    {
      String sql = "select * from media where media_id >=" + f + " and media_id < " + (f +30);
      try {
        name = name.substring(0, 2);

        conn = DB.getConnection();
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();
        int i = 1;
        while (rs.next()) {
          Media me = new Media();
          if (i < 7)
          {
            me.setMediaId(rs.getInt("media_id"));
            me.setMediaTitle(rs.getString("media_title"));
            me.setDuration(rs.getInt("duration"));
          }
          else
          {
            String str = rs.getString("media_title");

            if (!str.startsWith(name))
              continue;
            me.setMediaId(rs.getInt("media_id"));
            me.setMediaTitle(str);
            me.setDuration(rs.getInt("duration"));
          }

          if (mediaList == null) {
            mediaList = new ArrayList();
          }
          i++;
          mediaList.add(me);
        }
      } catch (SQLException e) {
        e.printStackTrace();
      } finally {
        DB.closeRs(rs);
        DB.closeStmt(pstmt);
        DB.closeConn(conn);
      }
    }
    return mediaList;
  }

  public List<Media> getList() {
    ArrayList mediaList = null;
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "select * from media where media_id>30";
    String name = null;

    String help = null;
    Media me = new Media();
    me.setMediaId(1);
    me.setMediaTitle("电影|映画");
    me.setDuration(1);
    if (mediaList == null) {
      mediaList = new ArrayList();
    }
    mediaList.add(me);
    try {
      conn = DB.getConnection();
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        if (name == null)
        {
          name = rs.getString("media_title");
          name = name.substring(0, 2);
        }
        else
        {
          help = rs.getString("media_title");
          if (help.startsWith(name))
          {
            continue;
          }

          name = help.substring(0, 2);
        }

        me = new Media();
        me.setMediaId(rs.getInt("media_id"));
        String str = rs.getString("media_title");
        System.out.println(str);
        str = str.replaceAll("\\d+", "");
        me.setMediaTitle(str);
        me.setDuration(rs.getInt("media_id"));
        mediaList.add(me);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DB.closeRs(rs);
      DB.closeStmt(pstmt);
      DB.closeConn(conn);
    }
    return mediaList;
  }
  public Media getMediaById(int id) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    String sql = "select media_title,duration,url from media where media_id=" + id;
    Media media = new Media();
    try {
      conn = DB.getConnection();
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while (rs.next())
      {
        media.setMediaTitle(rs.getString("media_title"));
        media.setDuration(rs.getInt("duration"));
        media.setUrl(rs.getString("url"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DB.closeStmt(pstmt);
      DB.closeRs(rs);
      DB.closeConn(conn);
    }
    return media;
  }
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.daoImpl.MediaDaoImpl
 * JD-Core Version:    0.6.1
 */