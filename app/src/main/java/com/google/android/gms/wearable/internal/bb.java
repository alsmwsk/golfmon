package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;

public class bb
  extends ae.a
{
  private final IntentFilter[] axD;
  private DataApi.DataListener ayl;
  private MessageApi.MessageListener aym;
  private NodeApi.NodeListener ayn;
  
  private bb(DataApi.DataListener paramDataListener, MessageApi.MessageListener paramMessageListener, NodeApi.NodeListener paramNodeListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    this.ayl = paramDataListener;
    this.aym = paramMessageListener;
    this.ayn = paramNodeListener;
    this.axD = paramArrayOfIntentFilter;
  }
  
  public static bb a(NodeApi.NodeListener paramNodeListener)
  {
    return new bb(null, null, paramNodeListener, null);
  }
  
  public static bb b(DataApi.DataListener paramDataListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    return new bb(paramDataListener, null, null, paramArrayOfIntentFilter);
  }
  
  public static bb b(MessageApi.MessageListener paramMessageListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    return new bb(null, paramMessageListener, null, paramArrayOfIntentFilter);
  }
  
  public void a(ai paramai)
  {
    if (this.aym != null) {
      this.aym.onMessageReceived(paramai);
    }
  }
  
  public void a(al paramal)
  {
    if (this.ayn != null) {
      this.ayn.onPeerConnected(paramal);
    }
  }
  
  public void aa(DataHolder paramDataHolder)
  {
    if (this.ayl != null) {
      try
      {
        this.ayl.onDataChanged(new DataEventBuffer(paramDataHolder));
        return;
      }
      finally
      {
        paramDataHolder.close();
      }
    }
    paramDataHolder.close();
  }
  
  public void b(al paramal)
  {
    if (this.ayn != null) {
      this.ayn.onPeerDisconnected(paramal);
    }
  }
  
  public void clear()
  {
    this.ayl = null;
    this.aym = null;
    this.ayn = null;
  }
  
  public IntentFilter[] rs()
  {
    return this.axD;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.bb
 * JD-Core Version:    0.7.0.1
 */