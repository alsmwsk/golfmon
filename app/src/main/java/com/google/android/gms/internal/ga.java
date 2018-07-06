package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtil;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

@ey
public class ga
  implements ck.b
{
  private static final ga vX = new ga();
  public static final String vY = vX.vZ;
  private Context mContext;
  private final Object mH = new Object();
  private am nE = null;
  private al nF = null;
  private ex nG = null;
  private gs qJ;
  private boolean uV = true;
  private boolean uW = true;
  public final String vZ = gi.dx();
  private final gb wa = new gb(this.vZ);
  private ld wb;
  private BigInteger wc = BigInteger.ONE;
  private final HashSet<fz> wd = new HashSet();
  private final HashMap<String, gd> we = new HashMap();
  private boolean wf = false;
  private boolean wg = false;
  private an wh = null;
  private LinkedList<Thread> wi = new LinkedList();
  private boolean wj = false;
  private Bundle wk = bn.by();
  private String wl;
  
  public static Bundle a(Context paramContext, gc paramgc, String paramString)
  {
    return vX.b(paramContext, paramgc, paramString);
  }
  
  public static void a(Context paramContext, gs paramgs)
  {
    vX.b(paramContext, paramgs);
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    vX.b(paramContext, paramBoolean);
  }
  
  public static void b(HashSet<fz> paramHashSet)
  {
    vX.c(paramHashSet);
  }
  
  public static Bundle bN()
  {
    return vX.dp();
  }
  
  public static String c(int paramInt, String paramString)
  {
    return vX.d(paramInt, paramString);
  }
  
  public static ga dc()
  {
    return vX;
  }
  
  public static String df()
  {
    return vX.dg();
  }
  
  public static gb dh()
  {
    return vX.di();
  }
  
  public static boolean dj()
  {
    return vX.dk();
  }
  
  public static boolean dl()
  {
    return vX.dm();
  }
  
  public static String dn()
  {
    return vX.jdMethod_do();
  }
  
  public static void e(Throwable paramThrowable)
  {
    vX.f(paramThrowable);
  }
  
  public void a(Bundle paramBundle)
  {
    synchronized (this.mH)
    {
      this.wj = true;
      this.wk = paramBundle;
      if (!this.wi.isEmpty()) {
        ex.a(this.mContext, (Thread)this.wi.remove(0), this.qJ);
      }
    }
  }
  
  public void a(fz paramfz)
  {
    synchronized (this.mH)
    {
      this.wd.add(paramfz);
      return;
    }
  }
  
  public void a(String paramString, gd paramgd)
  {
    synchronized (this.mH)
    {
      this.we.put(paramString, paramgd);
      return;
    }
  }
  
  public void a(Thread paramThread)
  {
    synchronized (this.mH)
    {
      if (this.wj)
      {
        ex.a(this.mContext, paramThread, this.qJ);
        return;
      }
      this.wi.add(paramThread);
    }
  }
  
  public Bundle b(Context paramContext, gc paramgc, String paramString)
  {
    Bundle localBundle1;
    Bundle localBundle2;
    synchronized (this.mH)
    {
      localBundle1 = new Bundle();
      localBundle1.putBundle("app", this.wa.b(paramContext, paramString));
      localBundle2 = new Bundle();
      Iterator localIterator1 = this.we.keySet().iterator();
      if (localIterator1.hasNext())
      {
        String str = (String)localIterator1.next();
        localBundle2.putBundle(str, ((gd)this.we.get(str)).toBundle());
      }
    }
    localBundle1.putBundle("slots", localBundle2);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator2 = this.wd.iterator();
    while (localIterator2.hasNext()) {
      localArrayList.add(((fz)localIterator2.next()).toBundle());
    }
    localBundle1.putParcelableArrayList("ads", localArrayList);
    paramgc.a(this.wd);
    this.wd.clear();
    return localBundle1;
  }
  
  public void b(Context paramContext, gs paramgs)
  {
    synchronized (this.mH)
    {
      if (!this.wg)
      {
        this.mContext = paramContext.getApplicationContext();
        this.qJ = paramgs;
        this.uV = gg.o(paramContext);
        iy.H(paramContext);
        ck.a(paramContext, this);
        a(Thread.currentThread());
        this.wl = gi.c(paramContext, paramgs.wS);
        this.wb = new lf();
        this.wg = true;
      }
      return;
    }
  }
  
  public void b(Context paramContext, boolean paramBoolean)
  {
    synchronized (this.mH)
    {
      if (paramBoolean != this.uV)
      {
        this.uV = paramBoolean;
        gg.a(paramContext, paramBoolean);
      }
      return;
    }
  }
  
  public void c(HashSet<fz> paramHashSet)
  {
    synchronized (this.mH)
    {
      this.wd.addAll(paramHashSet);
      return;
    }
  }
  
  public String d(int paramInt, String paramString)
  {
    if (this.qJ.wV) {}
    for (Resources localResources = this.mContext.getResources(); localResources == null; localResources = GooglePlayServicesUtil.getRemoteResource(this.mContext)) {
      return paramString;
    }
    return localResources.getString(paramInt);
  }
  
  public ld dd()
  {
    synchronized (this.mH)
    {
      ld localld = this.wb;
      return localld;
    }
  }
  
  public boolean de()
  {
    synchronized (this.mH)
    {
      boolean bool = this.uW;
      return bool;
    }
  }
  
  public String dg()
  {
    synchronized (this.mH)
    {
      String str = this.wc.toString();
      this.wc = this.wc.add(BigInteger.ONE);
      return str;
    }
  }
  
  public gb di()
  {
    synchronized (this.mH)
    {
      gb localgb = this.wa;
      return localgb;
    }
  }
  
  public boolean dk()
  {
    synchronized (this.mH)
    {
      boolean bool = this.wf;
      this.wf = true;
      return bool;
    }
  }
  
  public boolean dm()
  {
    synchronized (this.mH)
    {
      boolean bool = this.uV;
      return bool;
    }
  }
  
  public String jdMethod_do()
  {
    synchronized (this.mH)
    {
      String str = this.wl;
      return str;
    }
  }
  
  public Bundle dp()
  {
    synchronized (this.mH)
    {
      Bundle localBundle = this.wk;
      return localBundle;
    }
  }
  
  public void f(Throwable paramThrowable)
  {
    if (this.wg) {
      new ex(this.mContext, this.qJ, null, null).b(paramThrowable);
    }
  }
  
  public an l(Context paramContext)
  {
    if ((!bN().getBoolean(bn.pp.getKey(), false)) || (!ll.ij()) || (de())) {
      return null;
    }
    synchronized (this.mH)
    {
      if (this.nE != null) {
        break label83;
      }
      if (!(paramContext instanceof Activity)) {
        return null;
      }
    }
    this.nE = new am((Application)paramContext.getApplicationContext(), (Activity)paramContext);
    label83:
    if (this.nF == null) {
      this.nF = new al();
    }
    if (this.wh == null) {
      this.wh = new an(this.nE, this.nF, this.wk, new ex(this.mContext, this.qJ, null, null));
    }
    this.wh.ba();
    an localan = this.wh;
    return localan;
  }
  
  public void x(boolean paramBoolean)
  {
    synchronized (this.mH)
    {
      this.uW = paramBoolean;
      return;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ga
 * JD-Core Version:    0.7.0.1
 */