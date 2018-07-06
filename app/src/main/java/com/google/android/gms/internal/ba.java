package com.google.android.gms.internal;

import com.google.android.gms.ads.doubleclick.AppEventListener;

@ey
public final class ba
  extends bf.a
{
  private final AppEventListener os;
  
  public ba(AppEventListener paramAppEventListener)
  {
    this.os = paramAppEventListener;
  }
  
  public void onAppEvent(String paramString1, String paramString2)
  {
    this.os.onAppEvent(paramString1, paramString2);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ba
 * JD-Core Version:    0.7.0.1
 */