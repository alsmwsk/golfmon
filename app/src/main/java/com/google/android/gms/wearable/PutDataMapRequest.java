package com.google.android.gms.wearable;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.ql;
import com.google.android.gms.internal.ql.a;
import com.google.android.gms.internal.qw;
import java.util.List;

public class PutDataMapRequest
{
  private final DataMap axh;
  private final PutDataRequest axi;
  
  private PutDataMapRequest(PutDataRequest paramPutDataRequest, DataMap paramDataMap)
  {
    this.axi = paramPutDataRequest;
    this.axh = new DataMap();
    if (paramDataMap != null) {
      this.axh.putAll(paramDataMap);
    }
  }
  
  public static PutDataMapRequest create(String paramString)
  {
    return new PutDataMapRequest(PutDataRequest.create(paramString), null);
  }
  
  public static PutDataMapRequest createFromDataMapItem(DataMapItem paramDataMapItem)
  {
    return new PutDataMapRequest(PutDataRequest.k(paramDataMapItem.getUri()), paramDataMapItem.getDataMap());
  }
  
  public static PutDataMapRequest createWithAutoAppendedId(String paramString)
  {
    return new PutDataMapRequest(PutDataRequest.createWithAutoAppendedId(paramString), null);
  }
  
  public PutDataRequest asPutDataRequest()
  {
    ql.a locala = ql.a(this.axh);
    this.axi.setData(qw.f(locala.ayo));
    int i = locala.ayp.size();
    for (int j = 0; j < i; j++)
    {
      String str = Integer.toString(j);
      Asset localAsset = (Asset)locala.ayp.get(j);
      if (str == null) {
        throw new IllegalStateException("asset key cannot be null: " + localAsset);
      }
      if (localAsset == null) {
        throw new IllegalStateException("asset cannot be null: key=" + str);
      }
      if (Log.isLoggable("DataMap", 3)) {
        Log.d("DataMap", "asPutDataRequest: adding asset: " + str + " " + localAsset);
      }
      this.axi.putAsset(str, localAsset);
    }
    return this.axi;
  }
  
  public DataMap getDataMap()
  {
    return this.axh;
  }
  
  public Uri getUri()
  {
    return this.axi.getUri();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.PutDataMapRequest
 * JD-Core Version:    0.7.0.1
 */