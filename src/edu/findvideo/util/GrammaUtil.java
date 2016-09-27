package edu.findvideo.util;

import edu.findvideo.bean.Gramma;

public class GrammaUtil extends Gramma
{
  private int sentenceId;
  private int pos;

  public GrammaUtil()
  {
  }

  public GrammaUtil(int id, String surface, String property, String pronunciation, int sentenceId, int wrongId, String basic, int pos)
  {
    super(id, surface, property, pronunciation, wrongId, basic);
    this.sentenceId = sentenceId;
    this.pos = pos;
  }

  public int getPos() {
    return this.pos;
  }

  public void setPos(int pos) {
    this.pos = pos;
  }

  public int getSentenceId() {
    return this.sentenceId;
  }

  public void setSentenceId(int sentenceId) {
    this.sentenceId = sentenceId;
  }

  public String toString()
  {
    return "GrammaUtil{sentenceId=" + this.sentenceId + "pos=" + this.pos + '}';
  }
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.util.GrammaUtil
 * JD-Core Version:    0.6.1
 */