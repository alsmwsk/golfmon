package com.google.android.gms.wearable.internal;

import android.net.Uri;
import android.util.Log;
import com.google.android.gms.wearable.DataItem;
import com.google.android.gms.wearable.DataItemAsset;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class l
  implements DataItem
{
  private byte[] aeA;
  private Map<String, DataItemAsset> axH;
  private Uri mUri;
  
  public l(DataItem paramDataItem)
  {
    this.mUri = paramDataItem.getUri();
    this.aeA = paramDataItem.getData();
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramDataItem.getAssets().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry.getKey() != null) {
        localHashMap.put(localEntry.getKey(), ((DataItemAsset)localEntry.getValue()).freeze());
      }
    }
    this.axH = Collections.unmodifiableMap(localHashMap);
  }
  
  public Map<String, DataItemAsset> getAssets()
  {
    return this.axH;
  }
  
  public byte[] getData()
  {
    return this.aeA;
  }
  
  public Uri getUri()
  {
    return this.mUri;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public DataItem rp()
  {
    return this;
  }
  
  public DataItem setData(byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException();
  }
  
  public String toString()
  {
    return toString(Log.isLoggable("DataItem", 3));
  }
  
  public String toString(boolean paramBoolean)
  {
    StringBuilder localStringBuilder1 = new StringBuilder("DataItemEntity[");
    localStringBuilder1.append("@");
    localStringBuilder1.append(Integer.toHexString(hashCode()));
    StringBuilder localStringBuilder2 = new StringBuilder().append(",dataSz=");
    if (this.aeA == null) {}
    for (Object localObject = "null";; localObject = Integer.valueOf(this.aeA.length))
    {
      localStringBuilder1.append(localObject);
      localStringBuilder1.append(", numAssets=" + this.axH.size());
      localStringBuilder1.append(", uri=" + this.mUri);
      if (paramBoolean) {
        break;
      }
      localStringBuilder1.append("]");
      return localStringBuilder1.toString();
    }
    localStringBuilder1.append("]\n  assets: ");
    Iterator localIterator = this.axH.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localStringBuilder1.append("\n    " + str + ": " + this.axH.get(str));
    }
    localStringBuilder1.append("\n  ]");
    return localStringBuilder1.toString();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.l
 * JD-Core Version:    0.7.0.1
 */