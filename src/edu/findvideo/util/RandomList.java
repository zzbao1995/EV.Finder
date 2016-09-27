package edu.findvideo.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class RandomList
{
  public void randomList(List list)
  {
    Collections.sort(list, new Comparator() {
      HashMap map = new HashMap();

      public int compare(Object v1, Object v2) { init(v1);
        init(v2);

        double n1 = ((Double)this.map.get(v1)).doubleValue();
        double n2 = ((Double)this.map.get(v2)).doubleValue();
        if (n1 > n2)
          return 1;
        if (n1 < n2)
          return -1;
        return 0; }

      private void init(Object v) {
        if (this.map.get(v) == null)
          this.map.put(v, new Double(Math.random()));
      }

      protected void finalize() throws Throwable {
        this.map = null;
      }
    });
  }
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.util.RandomList
 * JD-Core Version:    0.6.1
 */