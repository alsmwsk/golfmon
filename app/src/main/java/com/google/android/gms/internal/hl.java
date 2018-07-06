package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class hl
{
  public static class a
    implements SafeParcelable
  {
    public static final hm CREATOR = new hm();
    final int CK;
    public final Account Dc;
    
    public a()
    {
      this(null);
    }
    
    a(int paramInt, Account paramAccount)
    {
      this.CK = paramInt;
      this.Dc = paramAccount;
    }
    
    public a(Account paramAccount)
    {
      this(1, paramAccount);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      hm.a(this, paramParcel, paramInt);
    }
  }
  
  public static class b
    implements Result, SafeParcelable
  {
    public static final hn CREATOR = new hn();
    final int CK;
    public Status Dd;
    public List<hr> De;
    
    public b()
    {
      this.CK = 1;
    }
    
    b(int paramInt, Status paramStatus, List<hr> paramList)
    {
      this.CK = paramInt;
      this.Dd = paramStatus;
      this.De = paramList;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public Status getStatus()
    {
      return this.Dd;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      hn.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hl
 * JD-Core Version:    0.7.0.1
 */