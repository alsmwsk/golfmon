package com.google.android.gms.common.data;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

public final class DataBufferUtils
{
  public static <T, E extends Freezable<T>> ArrayList<T> freezeAndClose(DataBuffer<E> paramDataBuffer)
  {
    ArrayList localArrayList = new ArrayList(paramDataBuffer.getCount());
    try
    {
      Iterator localIterator = paramDataBuffer.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(((Freezable)localIterator.next()).freeze());
      }
    }
    finally
    {
      paramDataBuffer.close();
    }
    return localArrayList;
  }
  
  public static boolean hasData(DataBuffer<?> paramDataBuffer)
  {
    return (paramDataBuffer != null) && (paramDataBuffer.getCount() > 0);
  }
  
  public static boolean hasNextPage(DataBuffer<?> paramDataBuffer)
  {
    Bundle localBundle = paramDataBuffer.gV();
    return (localBundle != null) && (localBundle.getString("next_page_token") != null);
  }
  
  public static boolean hasPrevPage(DataBuffer<?> paramDataBuffer)
  {
    Bundle localBundle = paramDataBuffer.gV();
    return (localBundle != null) && (localBundle.getString("prev_page_token") != null);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.DataBufferUtils
 * JD-Core Version:    0.7.0.1
 */