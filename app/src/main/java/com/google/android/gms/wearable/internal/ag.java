package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class ag<T>
{
  private final HashMap<T, bb> agU = new HashMap();
  
  abstract bb a(T paramT, IntentFilter[] paramArrayOfIntentFilter);
  
  public void a(ba paramba, BaseImplementation.b<Status> paramb, T paramT)
    throws RemoteException
  {
    synchronized (this.agU)
    {
      bb localbb = (bb)this.agU.remove(paramT);
      if (localbb == null)
      {
        paramb.b(new Status(4002));
        return;
      }
      localbb.clear();
      ((af)paramba.hw()).a(new e(this.agU, paramT, paramb), new ar(localbb));
      return;
    }
  }
  
  public void a(ba paramba, BaseImplementation.b<Status> paramb, T paramT, IntentFilter[] paramArrayOfIntentFilter)
    throws RemoteException
  {
    bb localbb = a(paramT, paramArrayOfIntentFilter);
    synchronized (this.agU)
    {
      if (this.agU.get(paramT) != null)
      {
        paramb.b(new Status(4001));
        return;
      }
      this.agU.put(paramT, localbb);
    }
  }
  
  public void b(ba paramba)
  {
    synchronized (this.agU)
    {
      az.h localh = new az.h();
      Iterator localIterator = this.agU.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          bb localbb = (bb)localEntry.getValue();
          if (localbb == null) {
            continue;
          }
          localbb.clear();
          boolean bool = paramba.isConnected();
          if (!bool) {
            continue;
          }
          try
          {
            ((af)paramba.hw()).a(localh, new ar(localbb));
            if (Log.isLoggable("WearableClient", 2)) {
              Log.d("WearableClient", "disconnect: removed: " + localEntry.getKey() + "/" + localbb);
            }
          }
          catch (RemoteException localRemoteException)
          {
            Log.w("WearableClient", "disconnect: Didn't remove: " + localEntry.getKey() + "/" + localbb);
          }
        }
      }
    }
    this.agU.clear();
  }
  
  public void ca(IBinder paramIBinder)
  {
    synchronized (this.agU)
    {
      af localaf = af.a.bZ(paramIBinder);
      az.h localh = new az.h();
      Iterator localIterator = this.agU.entrySet().iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          bb localbb = (bb)localEntry.getValue();
          try
          {
            localaf.a(localh, new b(localbb));
            if (Log.isLoggable("WearableClient", 2)) {
              Log.d("WearableClient", "onPostInitHandler: added: " + localEntry.getKey() + "/" + localbb);
            }
          }
          catch (RemoteException localRemoteException)
          {
            Log.d("WearableClient", "onPostInitHandler: Didn't add: " + localEntry.getKey() + "/" + localbb);
          }
        }
      }
    }
  }
  
  private static class a<T>
    extends az.a<Status>
  {
    private WeakReference<Map<T, bb>> axP;
    private WeakReference<T> axQ;
    
    a(Map<T, bb> paramMap, T paramT, BaseImplementation.b<Status> paramb)
    {
      super();
      this.axP = new WeakReference(paramMap);
      this.axQ = new WeakReference(paramT);
    }
    
    public void a(Status paramStatus)
    {
      Map localMap = (Map)this.axP.get();
      Object localObject1 = this.axQ.get();
      if ((!paramStatus.getStatus().isSuccess()) && (localMap != null) && (localObject1 != null)) {}
      try
      {
        bb localbb = (bb)localMap.remove(localObject1);
        if (localbb != null) {
          localbb.clear();
        }
        A(paramStatus);
        return;
      }
      finally {}
    }
  }
  
  static final class b
    extends ag<DataApi.DataListener>
  {
    bb a(DataApi.DataListener paramDataListener, IntentFilter[] paramArrayOfIntentFilter)
    {
      return bb.b(paramDataListener, paramArrayOfIntentFilter);
    }
  }
  
  static final class c
    extends ag<MessageApi.MessageListener>
  {
    bb a(MessageApi.MessageListener paramMessageListener, IntentFilter[] paramArrayOfIntentFilter)
    {
      return bb.b(paramMessageListener, paramArrayOfIntentFilter);
    }
  }
  
  static final class d
    extends ag<NodeApi.NodeListener>
  {
    bb a(NodeApi.NodeListener paramNodeListener, IntentFilter[] paramArrayOfIntentFilter)
    {
      return bb.a(paramNodeListener);
    }
  }
  
  private static class e<T>
    extends az.a<Status>
  {
    private WeakReference<Map<T, bb>> axP;
    private WeakReference<T> axQ;
    
    e(Map<T, bb> paramMap, T paramT, BaseImplementation.b<Status> paramb)
    {
      super();
      this.axP = new WeakReference(paramMap);
      this.axQ = new WeakReference(paramT);
    }
    
    public void a(Status paramStatus)
    {
      Map localMap = (Map)this.axP.get();
      Object localObject1 = this.axQ.get();
      if ((paramStatus.getStatus().getStatusCode() == 4002) && (localMap != null) && (localObject1 != null)) {}
      try
      {
        bb localbb = (bb)localMap.remove(localObject1);
        if (localbb != null) {
          localbb.clear();
        }
        A(paramStatus);
        return;
      }
      finally {}
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.ag
 * JD-Core Version:    0.7.0.1
 */