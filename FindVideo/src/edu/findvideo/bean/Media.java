package edu.findvideo.bean;

public class Media
{
  private int mediaId;
  private String mediaTitle;
  private String mediaType;
  private int duration;
  private String url;

  public int getMediaId()
  {
    return this.mediaId;
  }
  public void setMediaId(int mediaId) {
    this.mediaId = mediaId;
  }
  public String getMediaTitle() {
    return this.mediaTitle;
  }
  public void setMediaTitle(String mediaTitle) {
    this.mediaTitle = mediaTitle;
  }
  public String getMediaType() {
    return this.mediaType;
  }
  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }
  public void setDuration(int duration) {
    this.duration = duration;
  }
  public int getDuration() {
    return this.duration;
  }
  public void setUrl(String url) {
    this.url = url;
  }
  public String getUrl() {
    return this.url;
  }
}
