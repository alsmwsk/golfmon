package com.google.android.gms.wearable.internal;

import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.HashMap;
import java.util.Map;

public final class o
  extends d
  implements DataItem
{
  private final int Ya;
  
  public o(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    super(paramDataHolder, paramInt1);
    this.Ya = paramInt2;
  }
  
  public Map<String, DataItemAsset> getAssets()
  {
    HashMap localHashMap = new HashMap(this.Ya);
    int i = 0;
    if (i < this.Ya)
    {
      k localk = new k(this.JG, i + this.KZ);
      if (localk.getDataItemKey() == null) {}
      for (;;)
      {
        i++;
        break;
        localHashMap.put(localk.getDataItemKey(), localk);
      }
    }
    return localHashMap;
  }
  
  public byte[] getData()
  {
    return getByteArray("data");
  }
  
  public Uri getUri()
  {
    return Uri.parse(getString("path"));
  }
  
  public DataItem rp()
  {
    return new l(this);
  }
  
  public DataItem setData(byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.o
 * JD-Core Version:    0.7.0.1
 */