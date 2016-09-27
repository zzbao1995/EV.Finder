package edu.findvideo.util;

public class MarkContent
{
  public String setMarkInContent(String string, String keyword)
  {
    String[] str = string.split(keyword);
    String content = "";
    for (int i = 0; i < str.length; i++) {
      if ((i == str.length - 1) && (str.length != 1))
        content = content + str[i];
      else {
        content = content + str[i] + "<span class=\"keyword_mark\">" + keyword + "</span>";
      }
    }
    return content;
  }

  public String doubleToTime(double d) {
    int hour = (int)(d / 3600.0D);
    int minute = (int)((d - 3600 * hour) / 60.0D);
    double secondD = d - 3600 * hour - 60 * minute;
    double second = RoundTool.round(secondD, 2, 1);
    String time = hour + ":" + minute + ":" + second;
    return time;
  }
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.util.MarkContent
 * JD-Core Version:    0.6.1
 */