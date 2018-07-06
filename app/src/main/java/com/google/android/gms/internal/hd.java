package com.google.android.gms.internal;

import android.accounts.Account;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class hd
  implements SafeParcelable
{
  public static final he CREATOR = new he();
  final int CK;
  final hh[] CL;
  public final String CM;
  public final boolean CN;
  public final Account account;
  
  hd(int paramInt, hh[] paramArrayOfhh, String paramString, boolean paramBoolean, Account paramAccount)
  {
    this.CK = paramInt;
    this.CL = paramArrayOfhh;
    this.CM = paramString;
    this.CN = paramBoolean;
    this.account = paramAccount;
  }
  
  hd(String paramString, boolean paramBoolean, Account paramAccount, hh... paramVarArgs)
  {
    this(1, paramVarArgs, paramString, paramBoolean, paramAccount);
    BitSet localBitSet = new BitSet(ho.fF());
    for (int i = 0; i < paramVarArgs.length; i++)
    {
      int j = paramVarArgs[i].CZ;
      if (j != -1)
      {
        if (localBitSet.get(j)) {
          throw new IllegalArgumentException("Duplicate global search section type " + ho.P(j));
        }
        localBitSet.set(j);
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    he.a(this, paramParcel, paramInt);
  }
  
  public static class a
  {
    private List<hh> CO;
    private String CP;
    private boolean CQ;
    private Account CR;
    
    public a F(boolean paramBoolean)
    {
      this.CQ = paramBoolean;
      return this;
    }
    
    public a a(hh paramhh)
    {
      if (this.CO == null) {
        this.CO = new ArrayList();
      }
      this.CO.add(paramhh);
      return this;
    }
    
    public a ar(String paramString)
    {
      this.CP = paramString;
      return this;
    }
    
    public hd fD()
    {
      String str = this.CP;
      boolean bool = this.CQ;
      Account localAccount = this.CR;
      if (this.CO != null) {}
      for (hh[] arrayOfhh = (hh[])this.CO.toArray(new hh[this.CO.size()]);; arrayOfhh = null) {
        return new hd(str, bool, localAccount, arrayOfhh);
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hd
 * JD-Core Version:    0.7.0.1
 */