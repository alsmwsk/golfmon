package com.google.android.gms.wearable;

import android.net.Uri;
import com.google.android.gms.internal.ql;
import com.google.android.gms.internal.ql.a;
import com.google.android.gms.internal.qm;
import com.google.android.gms.internal.qv;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataMapItem
{
  private final DataMap axh;
  private final Uri mUri;
  
  private DataMapItem(DataItem paramDataItem)
  {
    this.mUri = paramDataItem.getUri();
    this.axh = a((DataItem)paramDataItem.freeze());
  }
  
  private DataMap a(DataItem paramDataItem)
  {
    if ((paramDataItem.getData() == null) && (paramDataItem.getAssets().size() > 0)) {
      throw new IllegalArgumentException("Cannot create DataMapItem from a DataItem  that wasn't made with DataMapItem.");
    }
    if (paramDataItem.getData() == null) {
      return new DataMap();
    }
    ArrayList localArrayList;
    for (;;)
    {
      int j;
      DataItemAsset localDataItemAsset;
      try
      {
        localArrayList = new ArrayList();
        int i = paramDataItem.getAssets().size();
        j = 0;
        if (j >= i) {
          break;
        }
        localDataItemAsset = (DataItemAsset)paramDataItem.getAssets().get(Integer.toString(j));
        if (localDataItemAsset == null) {
          throw new IllegalStateException("Cannot find DataItemAsset referenced in data at " + j + " for " + paramDataItem);
        }
      }
      catch (qv localqv)
      {
        throw new IllegalStateException("Unable to parse. Not a DataItem.");
      }
      localArrayList.add(Asset.createFromRef(localDataItemAsset.getId()));
      j++;
    }
    DataMap localDataMap = ql.a(new ql.a(qm.n(paramDataItem.getData()), localArrayList));
    return localDataMap;
  }
  
  public static DataMapItem fromDataItem(DataItem paramDataItem)
  {
    if (paramDataItem == null) {
      throw new IllegalStateException("provided dataItem is null");
    }
    return new DataMapItem(paramDataItem);
  }
  
  public DataMap getDataMap()
  {
    return this.axh;
  }
  
  public Uri getUri()
  {
    return this.mUri;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.DataMapItem
 * JD-Core Version:    0.7.0.1
 */