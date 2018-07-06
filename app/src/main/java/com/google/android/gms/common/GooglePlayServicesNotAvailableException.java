package com.google.android.gms.common;

public final class GooglePlayServicesNotAvailableException
  extends Exception
{
  public final int errorCode;
  
  public GooglePlayServicesNotAvailableException(int paramInt)
  {
    this.errorCode = paramInt;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.GooglePlayServicesNotAvailableException
 * JD-Core Version:    0.7.0.1
 */