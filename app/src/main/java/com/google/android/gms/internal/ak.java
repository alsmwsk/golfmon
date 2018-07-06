package com.google.android.gms.internal;

import java.util.ArrayList;
import java.util.Iterator;

@ey
public class ak
{
  private final Object mH = new Object();
  private final int np;
  private final int nq;
  private final int nr;
  private final ap ns;
  private ArrayList<String> nt = new ArrayList();
  private int nu = 0;
  private int nv = 0;
  private int nw = 0;
  private int nx;
  private String ny = "";
  
  public ak(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.np = paramInt1;
    this.nq = paramInt2;
    this.nr = paramInt3;
    this.ns = new ap(paramInt4);
  }
  
  private String a(ArrayList<String> paramArrayList, int paramInt)
  {
    String str;
    if (paramArrayList.isEmpty()) {
      str = "";
    }
    do
    {
      return str;
      StringBuffer localStringBuffer = new StringBuffer();
      Iterator localIterator = paramArrayList.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localStringBuffer.append((String)localIterator.next());
        localStringBuffer.append(' ');
      } while (localStringBuffer.length() <= paramInt);
      localStringBuffer.deleteCharAt(-1 + localStringBuffer.length());
      str = localStringBuffer.toString();
    } while (str.length() < paramInt);
    return str.substring(0, paramInt);
  }
  
  private void j(String paramString)
  {
    if ((paramString == null) || (paramString.length() < this.nr)) {
      return;
    }
    synchronized (this.mH)
    {
      this.nt.add(paramString);
      this.nu += paramString.length();
      return;
    }
  }
  
  int a(int paramInt1, int paramInt2)
  {
    return paramInt1 * this.np + paramInt2 * this.nq;
  }
  
  public boolean aS()
  {
    for (;;)
    {
      synchronized (this.mH)
      {
        if (this.nw == 0)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }
  
  public String aT()
  {
    return this.ny;
  }
  
  public void aU()
  {
    synchronized (this.mH)
    {
      this.nx = (-100 + this.nx);
      return;
    }
  }
  
  public void aV()
  {
    synchronized (this.mH)
    {
      this.nw = (-1 + this.nw);
      return;
    }
  }
  
  public void aW()
  {
    synchronized (this.mH)
    {
      this.nw = (1 + this.nw);
      return;
    }
  }
  
  public void aX()
  {
    synchronized (this.mH)
    {
      int i = a(this.nu, this.nv);
      if (i > this.nx)
      {
        this.nx = i;
        this.ny = this.ns.a(this.nt);
      }
      return;
    }
  }
  
  int aY()
  {
    return this.nu;
  }
  
  public void c(int paramInt)
  {
    this.nv = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof ak)) {}
    ak localak;
    do
    {
      return false;
      if (paramObject == this) {
        return true;
      }
      localak = (ak)paramObject;
    } while ((localak.aT() == null) || (!localak.aT().equals(aT())));
    return true;
  }
  
  public int getScore()
  {
    return this.nx;
  }
  
  public void h(String paramString)
  {
    j(paramString);
    synchronized (this.mH)
    {
      if (this.nw < 0) {
        gr.S("ActivityContent: negative number of WebViews.");
      }
      aX();
      return;
    }
  }
  
  public int hashCode()
  {
    return aT().hashCode();
  }
  
  public void i(String paramString)
  {
    j(paramString);
  }
  
  public String toString()
  {
    return "ActivityContent fetchId: " + this.nv + " score:" + this.nx + " total_length:" + this.nu + "\n text: " + a(this.nt, 200) + "\n signture: " + this.ny;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ak
 * JD-Core Version:    0.7.0.1
 */