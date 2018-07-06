package com.google.android.gms.internal;

import android.util.Base64OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

public class ap
{
  private final int nT;
  private final int nU;
  private final ao nV = new ar();
  private Base64OutputStream nW;
  private ByteArrayOutputStream nX;
  
  public ap(int paramInt)
  {
    this.nU = paramInt;
    this.nT = 6;
  }
  
  private String m(String paramString)
  {
    String[] arrayOfString = paramString.split("\n");
    if ((arrayOfString == null) || (arrayOfString.length == 0)) {
      return "";
    }
    this.nX = new ByteArrayOutputStream();
    this.nW = new Base64OutputStream(this.nX, 10);
    Arrays.sort(arrayOfString, new Comparator()
    {
      public int compare(String paramAnonymousString1, String paramAnonymousString2)
      {
        return paramAnonymousString2.length() - paramAnonymousString1.length();
      }
    });
    int i = 0;
    if ((i < arrayOfString.length) && (i < this.nU))
    {
      if (arrayOfString[i].trim().length() == 0) {}
      for (;;)
      {
        i++;
        break;
        try
        {
          this.nW.write(this.nV.l(arrayOfString[i]));
        }
        catch (IOException localIOException2)
        {
          gr.b("Error while writing hash to byteStream", localIOException2);
        }
      }
    }
    try
    {
      this.nW.flush();
      this.nW.close();
      String str = this.nX.toString();
      return str;
    }
    catch (IOException localIOException1)
    {
      gr.b("HashManager: Unable to convert to base 64", localIOException1);
    }
    return "";
  }
  
  public String a(ArrayList<String> paramArrayList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      localStringBuffer.append(((String)localIterator.next()).toLowerCase(Locale.US));
      localStringBuffer.append('\n');
    }
    switch (0)
    {
    default: 
      return "";
    case 0: 
      return n(localStringBuffer.toString());
    }
    return m(localStringBuffer.toString());
  }
  
  String n(String paramString)
  {
    String[] arrayOfString1 = paramString.split("\n");
    if ((arrayOfString1 == null) || (arrayOfString1.length == 0)) {
      return "";
    }
    this.nX = new ByteArrayOutputStream();
    this.nW = new Base64OutputStream(this.nX, 10);
    PriorityQueue localPriorityQueue = new PriorityQueue(this.nU, new Comparator()
    {
      public int a(as.a paramAnonymousa1, as.a paramAnonymousa2)
      {
        return (int)(paramAnonymousa1.value - paramAnonymousa2.value);
      }
    });
    int i = 0;
    if (i < arrayOfString1.length)
    {
      String[] arrayOfString2 = aq.p(arrayOfString1[i]);
      if (arrayOfString2.length < this.nT) {}
      for (;;)
      {
        i++;
        break;
        as.a(arrayOfString2, this.nU, this.nT, localPriorityQueue);
      }
    }
    Iterator localIterator = localPriorityQueue.iterator();
    while (localIterator.hasNext())
    {
      as.a locala = (as.a)localIterator.next();
      try
      {
        this.nW.write(this.nV.l(locala.oa));
      }
      catch (IOException localIOException2)
      {
        gr.b("Error while writing hash to byteStream", localIOException2);
      }
    }
    try
    {
      this.nW.flush();
      this.nW.close();
      String str = this.nX.toString();
      return str;
    }
    catch (IOException localIOException1)
    {
      gr.b("HashManager: unable to convert to base 64", localIOException1);
    }
    return "";
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ap
 * JD-Core Version:    0.7.0.1
 */