package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import com.google.android.gms.wearable.internal.h;

public class DataEventBuffer
  extends g<DataEvent>
  implements Result
{
  private final Status Eb;
  
  public DataEventBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    this.Eb = new Status(paramDataHolder.getStatusCode());
  }
  
  public Status getStatus()
  {
    return this.Eb;
  }
  
  protected String ha()
  {
    return "path";
  }
  
  protected DataEvent q(int paramInt1, int paramInt2)
  {
    return new h(this.JG, paramInt1, paramInt2);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.DataEventBuffer
 * JD-Core Version:    0.7.0.1
 */