package com.google.android.gms.ads.search;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.bg;
import com.google.android.gms.internal.bg.a;

public final class SearchAdRequest
{
  public static final int BORDER_TYPE_DASHED = 1;
  public static final int BORDER_TYPE_DOTTED = 2;
  public static final int BORDER_TYPE_NONE = 0;
  public static final int BORDER_TYPE_SOLID = 3;
  public static final int CALL_BUTTON_COLOR_DARK = 2;
  public static final int CALL_BUTTON_COLOR_LIGHT = 0;
  public static final int CALL_BUTTON_COLOR_MEDIUM = 1;
  public static final String DEVICE_ID_EMULATOR = bg.DEVICE_ID_EMULATOR;
  public static final int ERROR_CODE_INTERNAL_ERROR = 0;
  public static final int ERROR_CODE_INVALID_REQUEST = 1;
  public static final int ERROR_CODE_NETWORK_ERROR = 2;
  public static final int ERROR_CODE_NO_FILL = 3;
  private final bg lg;
  private final int xA;
  private final int xB;
  private final int xC;
  private final int xD;
  private final int xE;
  private final int xF;
  private final int xG;
  private final int xH;
  private final String xI;
  private final int xJ;
  private final String xK;
  private final int xL;
  private final int xM;
  private final String xN;
  
  private SearchAdRequest(Builder paramBuilder)
  {
    this.xA = Builder.a(paramBuilder);
    this.xB = Builder.b(paramBuilder);
    this.xC = Builder.c(paramBuilder);
    this.xD = Builder.d(paramBuilder);
    this.xE = Builder.e(paramBuilder);
    this.xF = Builder.f(paramBuilder);
    this.xG = Builder.g(paramBuilder);
    this.xH = Builder.h(paramBuilder);
    this.xI = Builder.i(paramBuilder);
    this.xJ = Builder.j(paramBuilder);
    this.xK = Builder.k(paramBuilder);
    this.xL = Builder.l(paramBuilder);
    this.xM = Builder.m(paramBuilder);
    this.xN = Builder.n(paramBuilder);
    this.lg = new bg(Builder.o(paramBuilder), this);
  }
  
  bg Y()
  {
    return this.lg;
  }
  
  public int getAnchorTextColor()
  {
    return this.xA;
  }
  
  public int getBackgroundColor()
  {
    return this.xB;
  }
  
  public int getBackgroundGradientBottom()
  {
    return this.xC;
  }
  
  public int getBackgroundGradientTop()
  {
    return this.xD;
  }
  
  public int getBorderColor()
  {
    return this.xE;
  }
  
  public int getBorderThickness()
  {
    return this.xF;
  }
  
  public int getBorderType()
  {
    return this.xG;
  }
  
  public int getCallButtonColor()
  {
    return this.xH;
  }
  
  public String getCustomChannels()
  {
    return this.xI;
  }
  
  public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> paramClass)
  {
    return this.lg.getCustomEventExtrasBundle(paramClass);
  }
  
  public int getDescriptionTextColor()
  {
    return this.xJ;
  }
  
  public String getFontFace()
  {
    return this.xK;
  }
  
  public int getHeaderTextColor()
  {
    return this.xL;
  }
  
  public int getHeaderTextSize()
  {
    return this.xM;
  }
  
  public Location getLocation()
  {
    return this.lg.getLocation();
  }
  
  @Deprecated
  public <T extends NetworkExtras> T getNetworkExtras(Class<T> paramClass)
  {
    return this.lg.getNetworkExtras(paramClass);
  }
  
  public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(Class<T> paramClass)
  {
    return this.lg.getNetworkExtrasBundle(paramClass);
  }
  
  public String getQuery()
  {
    return this.xN;
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return this.lg.isTestDevice(paramContext);
  }
  
  public static final class Builder
  {
    private final bg.a lh = new bg.a();
    private int xA;
    private int xB;
    private int xC;
    private int xD;
    private int xE;
    private int xF;
    private int xG = 0;
    private int xH;
    private String xI;
    private int xJ;
    private String xK;
    private int xL;
    private int xM;
    private String xN;
    
    public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> paramClass, Bundle paramBundle)
    {
      this.lh.b(paramClass, paramBundle);
      return this;
    }
    
    public Builder addNetworkExtras(NetworkExtras paramNetworkExtras)
    {
      this.lh.a(paramNetworkExtras);
      return this;
    }
    
    public Builder addNetworkExtrasBundle(Class<? extends MediationAdapter> paramClass, Bundle paramBundle)
    {
      this.lh.a(paramClass, paramBundle);
      return this;
    }
    
    public Builder addTestDevice(String paramString)
    {
      this.lh.s(paramString);
      return this;
    }
    
    public SearchAdRequest build()
    {
      return new SearchAdRequest(this, null);
    }
    
    public Builder setAnchorTextColor(int paramInt)
    {
      this.xA = paramInt;
      return this;
    }
    
    public Builder setBackgroundColor(int paramInt)
    {
      this.xB = paramInt;
      this.xC = Color.argb(0, 0, 0, 0);
      this.xD = Color.argb(0, 0, 0, 0);
      return this;
    }
    
    public Builder setBackgroundGradient(int paramInt1, int paramInt2)
    {
      this.xB = Color.argb(0, 0, 0, 0);
      this.xC = paramInt2;
      this.xD = paramInt1;
      return this;
    }
    
    public Builder setBorderColor(int paramInt)
    {
      this.xE = paramInt;
      return this;
    }
    
    public Builder setBorderThickness(int paramInt)
    {
      this.xF = paramInt;
      return this;
    }
    
    public Builder setBorderType(int paramInt)
    {
      this.xG = paramInt;
      return this;
    }
    
    public Builder setCallButtonColor(int paramInt)
    {
      this.xH = paramInt;
      return this;
    }
    
    public Builder setCustomChannels(String paramString)
    {
      this.xI = paramString;
      return this;
    }
    
    public Builder setDescriptionTextColor(int paramInt)
    {
      this.xJ = paramInt;
      return this;
    }
    
    public Builder setFontFace(String paramString)
    {
      this.xK = paramString;
      return this;
    }
    
    public Builder setHeaderTextColor(int paramInt)
    {
      this.xL = paramInt;
      return this;
    }
    
    public Builder setHeaderTextSize(int paramInt)
    {
      this.xM = paramInt;
      return this;
    }
    
    public Builder setLocation(Location paramLocation)
    {
      this.lh.a(paramLocation);
      return this;
    }
    
    public Builder setQuery(String paramString)
    {
      this.xN = paramString;
      return this;
    }
    
    public Builder tagForChildDirectedTreatment(boolean paramBoolean)
    {
      this.lh.j(paramBoolean);
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.search.SearchAdRequest
 * JD-Core Version:    0.7.0.1
 */