package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

@ey
public class fz
{
  private final Object mH = new Object();
  private boolean uQ = false;
  private final ga vL;
  private final LinkedList<a> vM;
  private final String vN;
  private final String vO;
  private long vP = -1L;
  private long vQ = -1L;
  private long vR = -1L;
  private long vS = 0L;
  private long vT = -1L;
  private long vU = -1L;
  
  public fz(ga paramga, String paramString1, String paramString2)
  {
    this.vL = paramga;
    this.vN = paramString1;
    this.vO = paramString2;
    this.vM = new LinkedList();
  }
  
  public fz(String paramString1, String paramString2)
  {
    this(ga.dc(), paramString1, paramString2);
  }
  
  public void cW()
  {
    synchronized (this.mH)
    {
      if ((this.vU != -1L) && (this.vQ == -1L))
      {
        this.vQ = SystemClock.elapsedRealtime();
        this.vL.a(this);
      }
      ga.dh().cW();
      return;
    }
  }
  
  public void cX()
  {
    synchronized (this.mH)
    {
      if (this.vU != -1L)
      {
        a locala = new a();
        locala.db();
        this.vM.add(locala);
        this.vS = (1L + this.vS);
        ga.dh().cX();
        this.vL.a(this);
      }
      return;
    }
  }
  
  public void cY()
  {
    synchronized (this.mH)
    {
      if ((this.vU != -1L) && (!this.vM.isEmpty()))
      {
        a locala = (a)this.vM.getLast();
        if (locala.cZ() == -1L)
        {
          locala.da();
          this.vL.a(this);
        }
      }
      return;
    }
  }
  
  public void e(av paramav)
  {
    synchronized (this.mH)
    {
      this.vT = SystemClock.elapsedRealtime();
      ga.dh().b(paramav, this.vT);
      return;
    }
  }
  
  public void j(long paramLong)
  {
    synchronized (this.mH)
    {
      this.vU = paramLong;
      if (this.vU != -1L) {
        this.vL.a(this);
      }
      return;
    }
  }
  
  public void k(long paramLong)
  {
    synchronized (this.mH)
    {
      if (this.vU != -1L)
      {
        this.vP = paramLong;
        this.vL.a(this);
      }
      return;
    }
  }
  
  public Bundle toBundle()
  {
    Bundle localBundle;
    ArrayList localArrayList;
    synchronized (this.mH)
    {
      localBundle = new Bundle();
      localBundle.putString("seq_num", this.vN);
      localBundle.putString("slotid", this.vO);
      localBundle.putBoolean("ismediation", this.uQ);
      localBundle.putLong("treq", this.vT);
      localBundle.putLong("tresponse", this.vU);
      localBundle.putLong("timp", this.vQ);
      localBundle.putLong("tload", this.vR);
      localBundle.putLong("pcc", this.vS);
      localBundle.putLong("tfetch", this.vP);
      localArrayList = new ArrayList();
      Iterator localIterator = this.vM.iterator();
      if (localIterator.hasNext()) {
        localArrayList.add(((a)localIterator.next()).toBundle());
      }
    }
    localBundle.putParcelableArrayList("tclick", localArrayList);
    return localBundle;
  }
  
  public void v(boolean paramBoolean)
  {
    synchronized (this.mH)
    {
      if (this.vU != -1L)
      {
        this.vR = SystemClock.elapsedRealtime();
        if (!paramBoolean)
        {
          this.vQ = this.vR;
          this.vL.a(this);
        }
      }
      return;
    }
  }
  
  public void w(boolean paramBoolean)
  {
    synchronized (this.mH)
    {
      if (this.vU != -1L)
      {
        this.uQ = paramBoolean;
        this.vL.a(this);
      }
      return;
    }
  }
  
  @ey
  private static final class a
  {
    private long vV = -1L;
    private long vW = -1L;
    
    public long cZ()
    {
      return this.vW;
    }
    
    public void da()
    {
      this.vW = SystemClock.elapsedRealtime();
    }
    
    public void db()
    {
      this.vV = SystemClock.elapsedRealtime();
    }
    
    public Bundle toBundle()
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("topen", this.vV);
      localBundle.putLong("tclose", this.vW);
      return localBundle;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fz
 * JD-Core Version:    0.7.0.1
 */