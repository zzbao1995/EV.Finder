package edu.findvideo.dao;

import edu.findvideo.bean.Tag;
import java.util.List;

public abstract interface TagDao
{
  public abstract void addTag(Tag paramTag);

  public abstract List<Tag> listTag(Tag paramTag);

  public abstract List<String> listCategory1();

  public abstract List<String> listCategory2();

  public abstract List<String> listCategory3();

  public abstract List<String> listCategory4();
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.dao.TagDao
 * JD-Core Version:    0.6.1
 */