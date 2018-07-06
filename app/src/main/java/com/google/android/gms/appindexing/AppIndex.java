package com.google.android.gms.appindexing;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.internal.hc;
import com.google.android.gms.internal.hz;

public final class AppIndex
{
  public static final Api<Api.ApiOptions.NoOptions> API = hc.CI;
  public static final Api<Api.ApiOptions.NoOptions> APP_INDEX_API = hc.CI;
  public static final AppIndexApi AppIndexApi = new hz();
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.appindexing.AppIndex
 * JD-Core Version:    0.7.0.1
 */