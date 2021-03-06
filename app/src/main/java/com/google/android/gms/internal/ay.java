package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@ey
public final class ay
  implements SafeParcelable
{
  public static final az CREATOR = new az();
  public final int height;
  public final int heightPixels;
  public final String op;
  public final boolean oq;
  public final ay[] or;
  public final int versionCode;
  public final int width;
  public final int widthPixels;
  
  public ay()
  {
    this(2, "interstitial_mb", 0, 0, true, 0, 0, null);
  }
  
  ay(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean, int paramInt4, int paramInt5, ay[] paramArrayOfay)
  {
    this.versionCode = paramInt1;
    this.op = paramString;
    this.height = paramInt2;
    this.heightPixels = paramInt3;
    this.oq = paramBoolean;
    this.width = paramInt4;
    this.widthPixels = paramInt5;
    this.or = paramArrayOfay;
  }
  
  public ay(Context paramContext, AdSize paramAdSize)
  {
    this(paramContext, new AdSize[] { paramAdSize });
  }
  
  public ay(Context paramContext, AdSize[] paramArrayOfAdSize)
  {
    AdSize localAdSize = paramArrayOfAdSize[0];
    this.versionCode = 2;
    this.oq = false;
    this.width = localAdSize.getWidth();
    this.height = localAdSize.getHeight();
    int j;
    int k;
    label62:
    DisplayMetrics localDisplayMetrics;
    int n;
    label99:
    int i1;
    if (this.width == -1)
    {
      j = 1;
      if (this.height != -2) {
        break label216;
      }
      k = 1;
      localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
      if (j == 0) {
        break label222;
      }
      this.widthPixels = a(localDisplayMetrics);
      n = (int)(this.widthPixels / localDisplayMetrics.density);
      if (k == 0) {
        break label248;
      }
      i1 = c(localDisplayMetrics);
      label111:
      this.heightPixels = gq.a(localDisplayMetrics, i1);
      if ((j == 0) && (k == 0)) {
        break label257;
      }
    }
    label257:
    for (this.op = (n + "x" + i1 + "_as");; this.op = localAdSize.toString())
    {
      if (paramArrayOfAdSize.length <= 1) {
        break label269;
      }
      this.or = new ay[paramArrayOfAdSize.length];
      while (i < paramArrayOfAdSize.length)
      {
        this.or[i] = new ay(paramContext, paramArrayOfAdSize[i]);
        i++;
      }
      j = 0;
      break;
      label216:
      k = 0;
      break label62;
      label222:
      int m = this.width;
      this.widthPixels = gq.a(localDisplayMetrics, this.width);
      n = m;
      break label99;
      label248:
      i1 = this.height;
      break label111;
    }
    label269:
    this.or = null;
  }
  
  public ay(ay paramay, ay[] paramArrayOfay)
  {
    this(2, paramay.op, paramay.height, paramay.heightPixels, paramay.oq, paramay.width, paramay.widthPixels, paramArrayOfay);
  }
  
  public static int a(DisplayMetrics paramDisplayMetrics)
  {
    return paramDisplayMetrics.widthPixels;
  }
  
  public static int b(DisplayMetrics paramDisplayMetrics)
  {
    return (int)(c(paramDisplayMetrics) * paramDisplayMetrics.density);
  }
  
  private static int c(DisplayMetrics paramDisplayMetrics)
  {
    int i = (int)(paramDisplayMetrics.heightPixels / paramDisplayMetrics.density);
    if (i <= 400) {
      return 32;
    }
    if (i <= 720) {
      return 50;
    }
    return 90;
  }
  
  public AdSize bh()
  {
    return a.a(this.width, this.height, this.op);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    az.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ay
 * JD-Core Version:    0.7.0.1
 */