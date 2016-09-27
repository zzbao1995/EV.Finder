package edu.findvideo.bean;

public class SimpleSub
{
  private int mediaid;
  private String mediaTitle;
  private String content;
  private double startTime;
  private double endTime;
  private String mediaUrl;
  private String contentMark;

  public String getMediaTitle()
  {
    return this.mediaTitle;
  }
  public void setMediaTitle(String mediaTitle) {
    this.mediaTitle = mediaTitle;
  }
  public String getContent() {
    return this.content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public double getStartTime() {
    return this.startTime;
  }
  public void setStartTime(double startTime) {
    this.startTime = startTime;
  }
  public double getEndTime() {
    return this.endTime;
  }
  public void setEndTime(double endTime) {
    this.endTime = endTime;
  }
  public void setMediaUrl(String mediaUrl) {
    this.mediaUrl = mediaUrl;
  }
  public String getMediaUrl() {
    return this.mediaUrl;
  }
  public void setContentMark(String contentMark) {
    this.contentMark = contentMark;
  }
  public String getContentMark() {
    return this.contentMark;
  }
  public void setMediaid(int mediaid) {
    this.mediaid = mediaid;
  }
  public int getMediaid() {
    return this.mediaid;
  }
}

