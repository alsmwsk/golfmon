package com.google.android.gms.ads;

import android.content.Context;
import android.content.res.Resources;
import com.google.android.gms.internal.ay;
import com.google.android.gms.internal.gq;

public final class AdSize
{
  public static final int AUTO_HEIGHT = -2;
  public static final AdSize BANNER = new AdSize(320, 50, "320x50_mb");
  public static final AdSize FULL_BANNER = new AdSize(468, 60, "468x60_as");
  public static final int FULL_WIDTH = -1;
  public static final AdSize LARGE_BANNER = new AdSize(320, 100, "320x100_as");
  public static final AdSize LEADERBOARD = new AdSize(728, 90, "728x90_as");
  public static final AdSize MEDIUM_RECTANGLE = new AdSize(300, 250, "300x250_as");
  public static final AdSize SMART_BANNER = new AdSize(-1, -2, "smart_banner");
  public static final AdSize WIDE_SKYSCRAPER = new AdSize(160, 600, "160x600_as");
  private final int li;
  private final int lj;
  private final String lk;
  
  public AdSize(int paramInt1, int paramInt2) {}
  
  AdSize(int paramInt1, int paramInt2, String paramString)
  {
    if ((paramInt1 < 0) && (paramInt1 != -1)) {
      throw new IllegalArgumentException("Invalid width for AdSize: " + paramInt1);
    }
    if ((paramInt2 < 0) && (paramInt2 != -2)) {
      throw new IllegalArgumentException("Invalid height for AdSize: " + paramInt2);
    }
    this.li = paramInt1;
    this.lj = paramInt2;
    this.lk = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    AdSize localAdSize;
    do
    {
      return true;
      if (!(paramObject instanceof AdSize)) {
        return false;
      }
      localAdSize = (AdSize)paramObject;
    } while ((this.li == localAdSize.li) && (this.lj == localAdSize.lj) && (this.lk.equals(localAdSize.lk)));
    return false;
  }
  
  public int getHeight()
  {
    return this.lj;
  }
  
  public int getHeightInPixels(Context paramContext)
  {
    if (this.lj == -2) {
      return ay.b(paramContext.getResources().getDisplayMetrics());
    }
    return gq.a(paramContext, this.lj);
  }
  
  public int getWidth()
  {
    return this.li;
  }
  
  public int getWidthInPixels(Context paramContext)
  {
    if (this.li == -1) {
      return ay.a(paramContext.getResources().getDisplayMetrics());
    }
    return gq.a(paramContext, this.li);
  }
  
  public int hashCode()
  {
    return this.lk.hashCode();
  }
  
  public boolean isAutoHeight()
  {
    return this.lj == -2;
  }
  
  public boolean isFullWidth()
  {
    return this.li == -1;
  }
  
  public String toString()
  {
    return this.lk;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.AdSize
 * JD-Core Version:    0.7.0.1
 */