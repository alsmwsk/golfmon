package com.google.android.gms.drive.query.internal;

import android.os.Parcel;

public class MatchAllFilter
  extends AbstractFilter
{
  public static final j CREATOR = new j();
  final int CK;
  
  public MatchAllFilter()
  {
    this(1);
  }
  
  MatchAllFilter(int paramInt)
  {
    this.CK = paramInt;
  }
  
  public <F> F a(f<F> paramf)
  {
    return paramf.jd();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.MatchAllFilter
 * JD-Core Version:    0.7.0.1
 */