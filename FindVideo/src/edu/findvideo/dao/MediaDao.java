package edu.findvideo.dao;

import edu.findvideo.bean.Media;
import java.util.List;

public abstract interface MediaDao
{
  public abstract List<String> gettitleByid(int paramInt);

  public abstract List<Media> getAll();

  public abstract List<Media> getList();

  public abstract List<Media> getDetail(String paramString, int paramInt);

  public abstract Media getMediaById(int paramInt);
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.dao.MediaDao
 * JD-Core Version:    0.6.1
 */