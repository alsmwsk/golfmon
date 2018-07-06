package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class a
  implements SafeParcelable
{
  public static final b CREATOR = new b();
  private final int CK;
  private byte amJ;
  private Bundle amK;
  private Bitmap amL;
  
  a(int paramInt, byte paramByte, Bundle paramBundle, Bitmap paramBitmap)
  {
    this.CK = paramInt;
    this.amJ = paramByte;
    this.amK = paramBundle;
    this.amL = paramBitmap;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Bitmap getBitmap()
  {
    return this.amL;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public byte oh()
  {
    return this.amJ;
  }
  
  public Bundle oi()
  {
    return this.amK;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.internal.a
 * JD-Core Version:    0.7.0.1
 */