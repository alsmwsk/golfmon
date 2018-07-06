package com.google.android.gms.fitness.request;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;

public class aa
  implements SafeParcelable
{
  public static final Parcelable.Creator<aa> CREATOR = new ab();
  private final int CK;
  private final PendingIntent mPendingIntent;
  
  aa(int paramInt, PendingIntent paramPendingIntent)
  {
    this.CK = paramInt;
    this.mPendingIntent = paramPendingIntent;
  }
  
  public aa(PendingIntent paramPendingIntent)
  {
    this.CK = 3;
    this.mPendingIntent = paramPendingIntent;
  }
  
  private boolean a(aa paramaa)
  {
    return jv.equal(this.mPendingIntent, paramaa.mPendingIntent);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof aa)) && (a((aa)paramObject)));
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.mPendingIntent;
    return jv.hashCode(arrayOfObject);
  }
  
  public PendingIntent kb()
  {
    return this.mPendingIntent;
  }
  
  public String toString()
  {
    return jv.h(this).a("pendingIntent", this.mPendingIntent).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ab.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.aa
 * JD-Core Version:    0.7.0.1
 */