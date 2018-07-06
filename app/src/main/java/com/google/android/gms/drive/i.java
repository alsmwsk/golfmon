package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.jx;

public abstract class i
  implements Parcelable
{
  private volatile transient boolean OW = false;
  
  protected abstract void I(Parcel paramParcel, int paramInt);
  
  public final boolean iB()
  {
    return this.OW;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (!iB()) {}
    for (boolean bool = true;; bool = false)
    {
      jx.K(bool);
      this.OW = true;
      I(paramParcel, paramInt);
      return;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.i
 * JD-Core Version:    0.7.0.1
 */