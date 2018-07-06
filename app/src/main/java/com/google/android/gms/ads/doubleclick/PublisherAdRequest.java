package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.bg;
import com.google.android.gms.internal.bg.a;
import com.google.android.gms.internal.jx;
import java.util.Date;
import java.util.Set;

public final class PublisherAdRequest
{
  public static final String DEVICE_ID_EMULATOR = bg.DEVICE_ID_EMULATOR;
  public static final int ERROR_CODE_INTERNAL_ERROR = 0;
  public static final int ERROR_CODE_INVALID_REQUEST = 1;
  public static final int ERROR_CODE_NETWORK_ERROR = 2;
  public static final int ERROR_CODE_NO_FILL = 3;
  public static final int GENDER_FEMALE = 2;
  public static final int GENDER_MALE = 1;
  public static final int GENDER_UNKNOWN;
  private final bg lg;
  
  private PublisherAdRequest(Builder paramBuilder)
  {
    this.lg = new bg(Builder.a(paramBuilder));
  }
  
  public bg Y()
  {
    return this.lg;
  }
  
  public Date getBirthday()
  {
    return this.lg.getBirthday();
  }
  
  public String getContentUrl()
  {
    return this.lg.getContentUrl();
  }
  
  public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(Class<T> paramClass)
  {
    return this.lg.getCustomEventExtrasBundle(paramClass);
  }
  
  public int getGender()
  {
    return this.lg.getGender();
  }
  
  public Set<String> getKeywords()
  {
    return this.lg.getKeywords();
  }
  
  public Location getLocation()
  {
    return this.lg.getLocation();
  }
  
  public boolean getManualImpressionsEnabled()
  {
    return this.lg.getManualImpressionsEnabled();
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
  
  public String getPublisherProvidedId()
  {
    return this.lg.getPublisherProvidedId();
  }
  
  public boolean isTestDevice(Context paramContext)
  {
    return this.lg.isTestDevice(paramContext);
  }
  
  public static final class Builder
  {
    private final bg.a lh = new bg.a();
    
    public Builder addCustomEventExtrasBundle(Class<? extends CustomEvent> paramClass, Bundle paramBundle)
    {
      this.lh.b(paramClass, paramBundle);
      return this;
    }
    
    public Builder addKeyword(String paramString)
    {
      this.lh.r(paramString);
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
    
    public PublisherAdRequest build()
    {
      return new PublisherAdRequest(this, null);
    }
    
    public Builder setBirthday(Date paramDate)
    {
      this.lh.a(paramDate);
      return this;
    }
    
    public Builder setContentUrl(String paramString)
    {
      jx.b(paramString, "Content URL must be non-null.");
      jx.b(paramString, "Content URL must be non-empty.");
      if (paramString.length() <= 512) {}
      for (boolean bool = true;; bool = false)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(512);
        arrayOfObject[1] = Integer.valueOf(paramString.length());
        jx.b(bool, "Content URL must not exceed %d in length.  Provided length was %d.", arrayOfObject);
        this.lh.t(paramString);
        return this;
      }
    }
    
    public Builder setGender(int paramInt)
    {
      this.lh.h(paramInt);
      return this;
    }
    
    public Builder setLocation(Location paramLocation)
    {
      this.lh.a(paramLocation);
      return this;
    }
    
    public Builder setManualImpressionsEnabled(boolean paramBoolean)
    {
      this.lh.i(paramBoolean);
      return this;
    }
    
    public Builder setPublisherProvidedId(String paramString)
    {
      this.lh.u(paramString);
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
 * Qualified Name:     com.google.android.gms.ads.doubleclick.PublisherAdRequest
 * JD-Core Version:    0.7.0.1
 */