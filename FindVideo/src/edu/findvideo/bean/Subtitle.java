package edu.findvideo.bean;

public class Subtitle
{
  private int subtitleId;
  private Media media;
  private int mediaId;
  private double startTime;
  private double endTime;
  private String content;
  private String contentMark;

  public int getSubtitleId()
  {
    return this.subtitleId;
  }
  public void setSubtitleId(int subtitleId) {
    this.subtitleId = subtitleId;
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
  public String getContent() {
    return this.content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public void setMedia(Media media) {
    this.media = media;
  }
  public Media getMedia() {
    return this.media;
  }
  public void setMediaId(int mediaId) {
    this.mediaId = mediaId;
  }
  public int getMediaId() {
    return this.mediaId;
  }
  public void setContentMark(String contentMark) {
    this.contentMark = contentMark;
  }
  public String getContentMark() {
    return this.contentMark;
  }
}
