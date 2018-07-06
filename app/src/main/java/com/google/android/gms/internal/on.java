package com.google.android.gms.internal;

import android.content.Intent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.panorama.PanoramaApi.PanoramaResult;

class on
  implements PanoramaApi.PanoramaResult
{
  private final Status Eb;
  private final Intent amR;
  
  public on(Status paramStatus, Intent paramIntent)
  {
    this.Eb = ((Status)jx.i(paramStatus));
    this.amR = paramIntent;
  }
  
  public Status getStatus()
  {
    return this.Eb;
  }
  
  public Intent getViewerIntent()
  {
    return this.amR;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.on
 * JD-Core Version:    0.7.0.1
 */