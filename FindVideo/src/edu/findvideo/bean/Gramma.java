package edu.findvideo.bean;

public class Gramma
{
  private int id;
  private String surface;
  private String property;
  private String pronunciation;
  private int wrongId;
  private String basic;

  public Gramma()
  {
  }

  public Gramma(int id, String surface, String property, String pronunciation, int wrongId, String basic)
  {
    this.id = id;
    this.surface = surface;
    this.property = property;
    this.pronunciation = pronunciation;
    this.wrongId = wrongId;
    this.basic = basic;
  }

  public String toString()
  {
    return "Gramma{id=" + this.id + "surface=" + this.surface + "property=" + this.property + "pronunciation=" + this.pronunciation + "wrongId=" + this.wrongId + "basic=" + this.basic + '}';
  }

  public int getId()
  {
    return this.id;
  }

  public void setId(int Id) {
    this.id = Id;
  }

  public String getBasic() {
    return this.basic;
  }

  public void setBasic(String basic) {
    this.basic = basic;
  }

  public String getPronunciation()
  {
    return this.pronunciation;
  }

  public void setPronunciation(String pronunciation) {
    this.pronunciation = pronunciation;
  }

  public String getProperty() {
    return this.property;
  }

  public void setProperty(String property) {
    this.property = property;
  }

  public String getSurface() {
    return this.surface;
  }

  public void setSurface(String surface) {
    this.surface = surface;
  }

  public int getWrongId() {
    return this.wrongId;
  }

  public void setWrongId(int wrongId) {
    this.wrongId = wrongId;
  }
}

