package edu.findvideo.factory;

import edu.findvideo.dao.DeleteVideoDao;
import edu.findvideo.dao.MediaDao;
import edu.findvideo.dao.SubtitleDao;
import edu.findvideo.dao.TagDao;
import edu.findvideo.dao.UserDao;
import edu.findvideo.daoImpl.DeleteVideoDaoImpl;
import edu.findvideo.daoImpl.MediaDaoImpl;
import edu.findvideo.daoImpl.SubtitleDaoImpl;
import edu.findvideo.daoImpl.TagDaoImpl;
import edu.findvideo.daoImpl.UserDaoImpl;

public class DaoFactory
{
  private static DaoFactory df = new DaoFactory();
  private static SubtitleDao sd = new SubtitleDaoImpl();
  private static UserDao ud = new UserDaoImpl();
  private static MediaDao md = new MediaDaoImpl();
  private static TagDao td = new TagDaoImpl();
  private static DeleteVideoDao dv = new DeleteVideoDaoImpl();

  public static DeleteVideoDao getDeleteVideoDao() { return dv; }

  public static DaoFactory getInstance()
  {
    return df;
  }

  public SubtitleDao getSubtitleDao() {
    return sd;
  }
  public UserDao getUserDao() {
    return ud;
  }
  public MediaDao getMediaDao() {
    return md;
  }
  public TagDao getTagDao() {
    return td;
  }
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.factory.DaoFactory
 * JD-Core Version:    0.6.1
 */