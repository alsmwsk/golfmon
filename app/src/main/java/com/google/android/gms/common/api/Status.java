package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender.SendIntentException;
import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;

public final class Status
  implements Result, SafeParcelable
{
  public static final StatusCreator CREATOR = new StatusCreator();
  public static final Status KA;
  public static final Status Kw = new Status(0);
  public static final Status Kx = new Status(14);
  public static final Status Ky = new Status(8);
  public static final Status Kz = new Status(15);
  private final int CK;
  private final int Iv;
  private final String KB;
  private final PendingIntent mPendingIntent;
  
  static
  {
    KA = new Status(16);
  }
  
  public Status(int paramInt)
  {
    this(paramInt, null);
  }
  
  Status(int paramInt1, int paramInt2, String paramString, PendingIntent paramPendingIntent)
  {
    this.CK = paramInt1;
    this.Iv = paramInt2;
    this.KB = paramString;
    this.mPendingIntent = paramPendingIntent;
  }
  
  public Status(int paramInt, String paramString)
  {
    this(1, paramInt, paramString, null);
  }
  
  public Status(int paramInt, String paramString, PendingIntent paramPendingIntent)
  {
    this(1, paramInt, paramString, paramPendingIntent);
  }
  
  private String gt()
  {
    if (this.KB != null) {
      return this.KB;
    }
    return CommonStatusCodes.getStatusCodeString(this.Iv);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Status)) {}
    Status localStatus;
    do
    {
      return false;
      localStatus = (Status)paramObject;
    } while ((this.CK != localStatus.CK) || (this.Iv != localStatus.Iv) || (!jv.equal(this.KB, localStatus.KB)) || (!jv.equal(this.mPendingIntent, localStatus.mPendingIntent)));
    return true;
  }
  
  PendingIntent gP()
  {
    return this.mPendingIntent;
  }
  
  @Deprecated
  public ConnectionResult gQ()
  {
    return new ConnectionResult(this.Iv, this.mPendingIntent);
  }
  
  public PendingIntent getResolution()
  {
    return this.mPendingIntent;
  }
  
  public Status getStatus()
  {
    return this;
  }
  
  public int getStatusCode()
  {
    return this.Iv;
  }
  
  public String getStatusMessage()
  {
    return this.KB;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public boolean hasResolution()
  {
    return this.mPendingIntent != null;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(this.CK);
    arrayOfObject[1] = Integer.valueOf(this.Iv);
    arrayOfObject[2] = this.KB;
    arrayOfObject[3] = this.mPendingIntent;
    return jv.hashCode(arrayOfObject);
  }
  
  public boolean isCanceled()
  {
    return this.Iv == 16;
  }
  
  public boolean isInterrupted()
  {
    return this.Iv == 14;
  }
  
  public boolean isSuccess()
  {
    return this.Iv <= 0;
  }
  
  public void startResolutionForResult(Activity paramActivity, int paramInt)
    throws IntentSender.SendIntentException
  {
    if (!hasResolution()) {
      return;
    }
    paramActivity.startIntentSenderForResult(this.mPendingIntent.getIntentSender(), paramInt, null, 0, 0, 0);
  }
  
  public String toString()
  {
    return jv.h(this).a("statusCode", gt()).a("resolution", this.mPendingIntent).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    StatusCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.Status
 * JD-Core Version:    0.7.0.1
 */