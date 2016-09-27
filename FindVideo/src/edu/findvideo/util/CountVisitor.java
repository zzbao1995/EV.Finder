package edu.findvideo.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintStream;

public class CountVisitor
{
  private File countFile = new File("countVisit.txt");

  public long readCount()
  {
    try
    {
      if (!this.countFile.exists()) {
        this.countFile.createNewFile();
        System.out.println(this.countFile.getAbsolutePath());
      }
      FileReader fReader = new FileReader(this.countFile);
      BufferedReader bReader = new BufferedReader(fReader);
      long count = Integer.parseInt(bReader.readLine());
      System.out.println(count);
      System.out.println(this.countFile.getAbsolutePath());
      bReader.close();

      return count;
    }
    catch (Exception e) {
      e.printStackTrace();
    }
    return 0L;
  }
  public void writeCount(long count) {
    try {
      System.out.println(count);
      FileOutputStream fOutputStream = new FileOutputStream(this.countFile, false);
      fOutputStream.write(String.valueOf(count).getBytes());
      fOutputStream.flush();
      fOutputStream.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

/* Location:           I:\FindVideo\WEB-INF\classes\
 * Qualified Name:     edu.findvideo.util.CountVisitor
 * JD-Core Version:    0.6.1
 */