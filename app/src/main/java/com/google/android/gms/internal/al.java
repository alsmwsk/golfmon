package com.google.android.gms.internal;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@ey
public class al
{
  private final Object mH = new Object();
  private List<ak> nA = new LinkedList();
  private int nz;
  
  public boolean a(ak paramak)
  {
    synchronized (this.mH)
    {
      return this.nA.contains(paramak);
    }
  }
  
  public ak aZ()
  {
    Object localObject4;
    for (Object localObject1 = null;; localObject1 = localObject4)
    {
      synchronized (this.mH)
      {
        if (this.nA.size() == 0)
        {
          gr.S("Queue empty");
          return null;
        }
        if (this.nA.size() >= 2)
        {
          i = -2147483648;
          Iterator localIterator = this.nA.iterator();
          if (localIterator.hasNext())
          {
            ak localak1 = (ak)localIterator.next();
            int j = localak1.getScore();
            if (j <= i) {
              break label150;
            }
            localObject4 = localak1;
            k = j;
            break label160;
          }
          this.nA.remove(localObject1);
          return localObject1;
        }
      }
      ak localak2 = (ak)this.nA.get(0);
      localak2.aU();
      return localak2;
      label150:
      int k = i;
      localObject4 = localObject1;
      label160:
      int i = k;
    }
  }
  
  public boolean b(ak paramak)
  {
    synchronized (this.mH)
    {
      Iterator localIterator = this.nA.iterator();
      while (localIterator.hasNext())
      {
        ak localak = (ak)localIterator.next();
        if ((paramak != localak) && (localak.aT().equals(paramak.aT())))
        {
          this.nA.remove(paramak);
          return true;
        }
      }
      return false;
    }
  }
  
  public void c(ak paramak)
  {
    synchronized (this.mH)
    {
      if (this.nA.size() >= 10)
      {
        gr.S("Queue is full, current size = " + this.nA.size());
        this.nA.remove(0);
      }
      int i = this.nz;
      this.nz = (i + 1);
      paramak.c(i);
      this.nA.add(paramak);
      return;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.al
 * JD-Core Version:    0.7.0.1
 */