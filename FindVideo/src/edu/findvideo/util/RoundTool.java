package edu.findvideo.util;

import java.math.BigDecimal;

public final class RoundTool
{
  public static double round(double value, int scale, int roundingMode)
  {
    BigDecimal bd = new BigDecimal(value);
    bd = bd.setScale(scale, roundingMode);
    double d = bd.doubleValue();
    bd = null;
    return d;
  }
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.util.RoundTool
 * JD-Core Version:    0.6.1
 */