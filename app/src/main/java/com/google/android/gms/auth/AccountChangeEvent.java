package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public class AccountChangeEvent
  implements SafeParcelable
{
  public static final AccountChangeEventCreator CREATOR = new AccountChangeEventCreator();
  final String DZ;
  final int Ef;
  final long Eg;
  final int Eh;
  final int Ei;
  final String Ej;
  
  AccountChangeEvent(int paramInt1, long paramLong, String paramString1, int paramInt2, int paramInt3, String paramString2)
  {
    this.Ef = paramInt1;
    this.Eg = paramLong;
    this.DZ = ((String)jx.i(paramString1));
    this.Eh = paramInt2;
    this.Ei = paramInt3;
    this.Ej = paramString2;
  }
  
  public AccountChangeEvent(long paramLong, String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    this.Ef = 1;
    this.Eg = paramLong;
    this.DZ = ((String)jx.i(paramString1));
    this.Eh = paramInt1;
    this.Ei = paramInt2;
    this.Ej = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    AccountChangeEvent localAccountChangeEvent;
    do
    {
      return true;
      if (!(paramObject instanceof AccountChangeEvent)) {
        break;
      }
      localAccountChangeEvent = (AccountChangeEvent)paramObject;
    } while ((this.Ef == localAccountChangeEvent.Ef) && (this.Eg == localAccountChangeEvent.Eg) && (jv.equal(this.DZ, localAccountChangeEvent.DZ)) && (this.Eh == localAccountChangeEvent.Eh) && (this.Ei == localAccountChangeEvent.Ei) && (jv.equal(this.Ej, localAccountChangeEvent.Ej)));
    return false;
    return false;
  }
  
  public String getAccountName()
  {
    return this.DZ;
  }
  
  public String getChangeData()
  {
    return this.Ej;
  }
  
  public int getChangeType()
  {
    return this.Eh;
  }
  
  public int getEventIndex()
  {
    return this.Ei;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = Integer.valueOf(this.Ef);
    arrayOfObject[1] = Long.valueOf(this.Eg);
    arrayOfObject[2] = this.DZ;
    arrayOfObject[3] = Integer.valueOf(this.Eh);
    arrayOfObject[4] = Integer.valueOf(this.Ei);
    arrayOfObject[5] = this.Ej;
    return jv.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    String str = "UNKNOWN";
    switch (this.Eh)
    {
    }
    for (;;)
    {
      return "AccountChangeEvent {accountName = " + this.DZ + ", changeType = " + str + ", changeData = " + this.Ej + ", eventIndex = " + this.Ei + "}";
      str = "ADDED";
      continue;
      str = "REMOVED";
      continue;
      str = "RENAMED_TO";
      continue;
      str = "RENAMED_FROM";
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AccountChangeEventCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.AccountChangeEvent
 * JD-Core Version:    0.7.0.1
 */