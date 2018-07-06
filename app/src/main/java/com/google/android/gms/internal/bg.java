package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@ey
public final class bg
{
  public static final String DEVICE_ID_EMULATOR = gq.R("emulator");
  private final Date d;
  private final Set<String> f;
  private final Location h;
  private final String oA;
  private final SearchAdRequest oB;
  private final int oC;
  private final Set<String> oD;
  private final String ov;
  private final int ow;
  private final boolean ox;
  private final Bundle oy;
  private final Map<Class<? extends NetworkExtras>, NetworkExtras> oz;
  
  public bg(a parama)
  {
    this(parama, null);
  }
  
  public bg(a parama, SearchAdRequest paramSearchAdRequest)
  {
    this.d = a.a(parama);
    this.ov = a.b(parama);
    this.ow = a.c(parama);
    this.f = Collections.unmodifiableSet(a.d(parama));
    this.h = a.e(parama);
    this.ox = a.f(parama);
    this.oy = a.g(parama);
    this.oz = Collections.unmodifiableMap(a.h(parama));
    this.oA = a.i(parama);
    this.oB = paramSearchAdRequest;
    this.oC = a.j(parama);
    this.oD = Collections.unmodifiableSet(a.k(parama));
  }
  
  public SearchAdRequest bi()
  {
    return this.oB;
  }
  
  public Map<Class<? extends NetworkExtras>, NetworkExtras> bj()
  {
    return this.oz;
  }
  
  public Bundle bk()
  {
    return this.oy;
  }
  
  public int bl()
  {
    return this.oC;
  }
  
  public Date getBirthday()
  {
    return this.d;
  }
  
  public String getContentUrl()
  {
    return this.ov;
  }
  
  public Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> paramClass)
  {
    Bundle localBundle = this.oy.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
    if (localBundle != null) {
      return localBundle.getBundle(paramClass.getClass().getName());
    }
    return null;
  }
  
  public int getGender()
  {
    return this.ow;
  }
  
  public Set<String> getKeywords()
  {
    return this.f;
  }
  
  public Location getLocation()
  {
    return this.h;
  }
  
  public boolean getManualImpressionsEnabled()
  {
    return this.ox;
  }
  
  @Deprecated
  public <T extends NetworkExtras> T getNetworkExtras(Class<T> paramClass)
  {
    return (NetworkExtras)this.oz.get(paramClass);
  }
  
  public Bundle getNetworkExtrasBundle(Class<? extends MediationAdapter> paramClass)
  {
    return this.oy.getBundle(paramClass.getName());
  }
  
  public String getPublisherProvidedId()
  {
    return this.oA;
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return this.oD.contains(gq.v(paramContext));
  }
  
  public static final class a
  {
    private Date d;
    private Location h;
    private String oA;
    private int oC = -1;
    private final HashSet<String> oE = new HashSet();
    private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> oF = new HashMap();
    private final HashSet<String> oG = new HashSet();
    private String ov;
    private int ow = -1;
    private boolean ox = false;
    private final Bundle oy = new Bundle();
    
    public void a(Location paramLocation)
    {
      this.h = paramLocation;
    }
    
    @Deprecated
    public void a(NetworkExtras paramNetworkExtras)
    {
      if ((paramNetworkExtras instanceof AdMobExtras))
      {
        a(AdMobAdapter.class, ((AdMobExtras)paramNetworkExtras).getExtras());
        return;
      }
      this.oF.put(paramNetworkExtras.getClass(), paramNetworkExtras);
    }
    
    public void a(Class<? extends MediationAdapter> paramClass, Bundle paramBundle)
    {
      this.oy.putBundle(paramClass.getName(), paramBundle);
    }
    
    public void a(Date paramDate)
    {
      this.d = paramDate;
    }
    
    public void b(Class<? extends CustomEvent> paramClass, Bundle paramBundle)
    {
      if (this.oy.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
        this.oy.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
      }
      this.oy.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(paramClass.getName(), paramBundle);
    }
    
    public void h(int paramInt)
    {
      this.ow = paramInt;
    }
    
    public void i(boolean paramBoolean)
    {
      this.ox = paramBoolean;
    }
    
    public void j(boolean paramBoolean)
    {
      if (paramBoolean) {}
      for (int i = 1;; i = 0)
      {
        this.oC = i;
        return;
      }
    }
    
    public void r(String paramString)
    {
      this.oE.add(paramString);
    }
    
    public void s(String paramString)
    {
      this.oG.add(paramString);
    }
    
    public void t(String paramString)
    {
      this.ov = paramString;
    }
    
    public void u(String paramString)
    {
      this.oA = paramString;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bg
 * JD-Core Version:    0.7.0.1
 */