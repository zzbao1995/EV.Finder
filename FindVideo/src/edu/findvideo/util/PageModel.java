package edu.findvideo.util;

import edu.findvideo.bean.Subtitle;
import java.util.ArrayList;

public class PageModel
{
  private ArrayList<ArrayList<Subtitle>> list = null;
  private int pageNum = 0;
  private int resultCount = 0;
  private int pageSize = 0;

  public ArrayList<ArrayList<Subtitle>> getList() { return this.list; }

  public void setList(ArrayList<ArrayList<Subtitle>> list)
  {
    this.list = list;
  }

  public int getPageNum() {
    return this.pageNum;
  }

  public void setPageNum(int pageNum) {
    this.pageNum = pageNum;
  }

  public int getResultCount() {
    return this.resultCount;
  }

  public void setResultCount(int resultCount) {
    this.resultCount = resultCount;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getPageSize() {
    return this.pageSize;
  }
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.util.PageModel
 * JD-Core Version:    0.6.1
 */