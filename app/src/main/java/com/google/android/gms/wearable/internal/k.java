package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.wearable.DataItemAsset;

public class k
  extends d
  implements DataItemAsset
{
  public k(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public String getDataItemKey()
  {
    return getString("asset_key");
  }
  
  public String getId()
  {
    return getString("asset_id");
  }
  
  public DataItemAsset ro()
  {
    return new i(this);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.k
 * JD-Core Version:    0.7.0.1
 */