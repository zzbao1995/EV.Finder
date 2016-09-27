package edu.findvideo.dao;

import edu.findvideo.bean.SimpleSub;
import edu.findvideo.util.PageModel;
import java.sql.Connection;

public abstract interface SubtitleDao
{
  public abstract int getTotal(Connection paramConnection);

  public abstract SimpleSub getFBcontentBySubId(int paramInt1, int paramInt2, int paramInt3, int paramInt4);

  public abstract PageModel getContentByKeyword(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5);
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.dao.SubtitleDao
 * JD-Core Version:    0.6.1
 */