package com.google.android.gms.tagmanager;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.api.PendingResult;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TagManager
{
  private static TagManager atW;
  private final DataLayer aqn;
  private final r asD;
  private final a atT;
  private final cx atU;
  private final ConcurrentMap<n, Boolean> atV;
  private final Context mContext;
  
  TagManager(Context paramContext, a parama, DataLayer paramDataLayer, cx paramcx)
  {
    if (paramContext == null) {
      throw new NullPointerException("context cannot be null");
    }
    this.mContext = paramContext.getApplicationContext();
    this.atU = paramcx;
    this.atT = parama;
    this.atV = new ConcurrentHashMap();
    this.aqn = paramDataLayer;
    this.aqn.a(new DataLayer.b()
    {
      public void C(Map<String, Object> paramAnonymousMap)
      {
        Object localObject = paramAnonymousMap.get("event");
        if (localObject != null) {
          TagManager.a(TagManager.this, localObject.toString());
        }
      }
    });
    this.aqn.a(new d(this.mContext));
    this.asD = new r();
    qP();
  }
  
  private void cV(String paramString)
  {
    Iterator localIterator = this.atV.keySet().iterator();
    while (localIterator.hasNext()) {
      ((n)localIterator.next()).cr(paramString);
    }
  }
  
  public static TagManager getInstance(Context paramContext)
  {
    try
    {
      if (atW != null) {
        break label68;
      }
      if (paramContext == null)
      {
        bh.T("TagManager.getInstance requires non-null context.");
        throw new NullPointerException();
      }
    }
    finally {}
    atW = new TagManager(paramContext, new a()new DataLayernew v
    {
      public o a(Context paramAnonymousContext, TagManager paramAnonymousTagManager, Looper paramAnonymousLooper, String paramAnonymousString, int paramAnonymousInt, r paramAnonymousr)
      {
        return new o(paramAnonymousContext, paramAnonymousTagManager, paramAnonymousLooper, paramAnonymousString, paramAnonymousInt, paramAnonymousr);
      }
    }, new DataLayer(new v(paramContext)), cy.qN());
    label68:
    TagManager localTagManager = atW;
    return localTagManager;
  }
  
  private void qP()
  {
    if (Build.VERSION.SDK_INT >= 14) {
      this.mContext.registerComponentCallbacks(new ComponentCallbacks2()
      {
        public void onConfigurationChanged(Configuration paramAnonymousConfiguration) {}
        
        public void onLowMemory() {}
        
        public void onTrimMemory(int paramAnonymousInt)
        {
          if (paramAnonymousInt == 20) {
            TagManager.this.dispatch();
          }
        }
      });
    }
  }
  
  void a(n paramn)
  {
    this.atV.put(paramn, Boolean.valueOf(true));
  }
  
  boolean b(n paramn)
  {
    return this.atV.remove(paramn) != null;
  }
  
  public void dispatch()
  {
    this.atU.dispatch();
  }
  
  public DataLayer getDataLayer()
  {
    return this.aqn;
  }
  
  boolean i(Uri paramUri)
  {
    for (;;)
    {
      ce localce;
      String str;
      boolean bool;
      try
      {
        localce = ce.qa();
        if (!localce.i(paramUri)) {
          break label228;
        }
        str = localce.getContainerId();
        int i = 4.atY[localce.qb().ordinal()];
        switch (i)
        {
        default: 
          bool = true;
          return bool;
        }
      }
      finally {}
      Iterator localIterator2 = this.atV.keySet().iterator();
      if (localIterator2.hasNext())
      {
        n localn2 = (n)localIterator2.next();
        if (localn2.getContainerId().equals(str))
        {
          localn2.ct(null);
          localn2.refresh();
        }
      }
      else
      {
        continue;
        Iterator localIterator1 = this.atV.keySet().iterator();
        while (localIterator1.hasNext())
        {
          n localn1 = (n)localIterator1.next();
          if (localn1.getContainerId().equals(str))
          {
            localn1.ct(localce.qc());
            localn1.refresh();
          }
          else if (localn1.pl() != null)
          {
            localn1.ct(null);
            localn1.refresh();
          }
        }
        continue;
        label228:
        bool = false;
      }
    }
  }
  
  public PendingResult<ContainerHolder> loadContainerDefaultOnly(String paramString, int paramInt)
  {
    o localo = this.atT.a(this.mContext, this, null, paramString, paramInt, this.asD);
    localo.po();
    return localo;
  }
  
  public PendingResult<ContainerHolder> loadContainerDefaultOnly(String paramString, int paramInt, Handler paramHandler)
  {
    o localo = this.atT.a(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.asD);
    localo.po();
    return localo;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferFresh(String paramString, int paramInt)
  {
    o localo = this.atT.a(this.mContext, this, null, paramString, paramInt, this.asD);
    localo.pq();
    return localo;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferFresh(String paramString, int paramInt, Handler paramHandler)
  {
    o localo = this.atT.a(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.asD);
    localo.pq();
    return localo;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String paramString, int paramInt)
  {
    o localo = this.atT.a(this.mContext, this, null, paramString, paramInt, this.asD);
    localo.pp();
    return localo;
  }
  
  public PendingResult<ContainerHolder> loadContainerPreferNonDefault(String paramString, int paramInt, Handler paramHandler)
  {
    o localo = this.atT.a(this.mContext, this, paramHandler.getLooper(), paramString, paramInt, this.asD);
    localo.pp();
    return localo;
  }
  
  public void setVerboseLoggingEnabled(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 2;; i = 5)
    {
      bh.setLogLevel(i);
      return;
    }
  }
  
  static abstract interface a
  {
    public abstract o a(Context paramContext, TagManager paramTagManager, Looper paramLooper, String paramString, int paramInt, r paramr);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.TagManager
 * JD-Core Version:    0.7.0.1
 */