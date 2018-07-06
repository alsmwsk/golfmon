package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.k;
import com.google.android.gms.fitness.data.k.a;

public class q
  implements SafeParcelable
{
  public static final Parcelable.Creator<q> CREATOR = new r();
  private final int CK;
  private final k VW;
  private final PendingIntent mPendingIntent;
  
  q(int paramInt, IBinder paramIBinder, PendingIntent paramPendingIntent)
  {
    this.CK = paramInt;
    if (paramIBinder == null) {}
    for (k localk = null;; localk = k.a.aq(paramIBinder))
    {
      this.VW = localk;
      this.mPendingIntent = paramPendingIntent;
      return;
    }
  }
  
  public q(k paramk, PendingIntent paramPendingIntent)
  {
    this.CK = 2;
    this.VW = paramk;
    this.mPendingIntent = paramPendingIntent;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public PendingIntent kb()
  {
    return this.mPendingIntent;
  }
  
  IBinder kg()
  {
    if (this.VW == null) {
      return null;
    }
    return this.VW.asBinder();
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.VW;
    return String.format("SensorUnregistrationRequest{%s}", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    r.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.q
 * JD-Core Version:    0.7.0.1
 */