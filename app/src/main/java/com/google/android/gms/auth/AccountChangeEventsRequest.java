package com.google.android.gms.auth;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEventsRequest
  implements SafeParcelable
{
  public static final AccountChangeEventsRequestCreator CREATOR = new AccountChangeEventsRequestCreator();
  String DZ;
  final int Ef;
  int Ei;
  
  public AccountChangeEventsRequest()
  {
    this.Ef = 1;
  }
  
  AccountChangeEventsRequest(int paramInt1, int paramInt2, String paramString)
  {
    this.Ef = paramInt1;
    this.Ei = paramInt2;
    this.DZ = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String getAccountName()
  {
    return this.DZ;
  }
  
  public int getEventIndex()
  {
    return this.Ei;
  }
  
  public AccountChangeEventsRequest setAccountName(String paramString)
  {
    this.DZ = paramString;
    return this;
  }
  
  public AccountChangeEventsRequest setEventIndex(int paramInt)
  {
    this.Ei = paramInt;
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AccountChangeEventsRequestCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.AccountChangeEventsRequest
 * JD-Core Version:    0.7.0.1
 */