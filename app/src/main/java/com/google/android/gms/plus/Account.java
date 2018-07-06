package com.google.android.gms.plus;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public abstract interface Account
{
  @Deprecated
  public abstract void clearDefaultAccount(GoogleApiClient paramGoogleApiClient);
  
  public abstract String getAccountName(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<Status> revokeAccessAndDisconnect(GoogleApiClient paramGoogleApiClient);
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.Account
 * JD-Core Version:    0.7.0.1
 */