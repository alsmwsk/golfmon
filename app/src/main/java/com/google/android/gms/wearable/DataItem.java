package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.common.data.Freezable;
import java.util.Map;

public abstract interface DataItem
  extends Freezable<DataItem>
{
  public abstract Map<String, DataItemAsset> getAssets();
  
  public abstract byte[] getData();
  
  public abstract Uri getUri();
  
  public abstract DataItem setData(byte[] paramArrayOfByte);
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.DataItem
 * JD-Core Version:    0.7.0.1
 */