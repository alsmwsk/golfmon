package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.b.a;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class nj
{
  private final np<ni> Ee;
  private ContentProviderClient agS = null;
  private boolean agT = false;
  private HashMap<LocationListener, b> agU = new HashMap();
  private final Context mContext;
  
  public nj(Context paramContext, np<ni> paramnp)
  {
    this.mContext = paramContext;
    this.Ee = paramnp;
  }
  
  private b a(LocationListener paramLocationListener, Looper paramLooper)
  {
    if (paramLooper == null) {
      jx.b(Looper.myLooper(), "Can't create handler inside thread that has not called Looper.prepare()");
    }
    synchronized (this.agU)
    {
      b localb = (b)this.agU.get(paramLocationListener);
      if (localb == null) {
        localb = new b(paramLocationListener, paramLooper);
      }
      this.agU.put(paramLocationListener, localb);
      return localb;
    }
  }
  
  public void S(boolean paramBoolean)
    throws RemoteException
  {
    this.Ee.dS();
    ((ni)this.Ee.hw()).S(paramBoolean);
    this.agT = paramBoolean;
  }
  
  public void a(LocationListener paramLocationListener)
    throws RemoteException
  {
    this.Ee.dS();
    jx.b(paramLocationListener, "Invalid null listener");
    synchronized (this.agU)
    {
      b localb = (b)this.agU.remove(paramLocationListener);
      if ((this.agS != null) && (this.agU.isEmpty()))
      {
        this.agS.release();
        this.agS = null;
      }
      if (localb != null)
      {
        localb.release();
        ((ni)this.Ee.hw()).a(localb);
      }
      return;
    }
  }
  
  public void a(LocationRequest paramLocationRequest, LocationListener paramLocationListener, Looper paramLooper)
    throws RemoteException
  {
    this.Ee.dS();
    b localb = a(paramLocationListener, paramLooper);
    ((ni)this.Ee.hw()).a(paramLocationRequest, localb);
  }
  
  public void b(Location paramLocation)
    throws RemoteException
  {
    this.Ee.dS();
    ((ni)this.Ee.hw()).b(paramLocation);
  }
  
  public void b(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
    throws RemoteException
  {
    this.Ee.dS();
    ((ni)this.Ee.hw()).a(paramLocationRequest, paramPendingIntent);
  }
  
  public void c(PendingIntent paramPendingIntent)
    throws RemoteException
  {
    this.Ee.dS();
    ((ni)this.Ee.hw()).b(paramPendingIntent);
  }
  
  public Location nl()
  {
    this.Ee.dS();
    try
    {
      Location localLocation = ((ni)this.Ee.hw()).bZ(this.mContext.getPackageName());
      return localLocation;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void nm()
  {
    if (this.agT) {}
    try
    {
      S(false);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  public void removeAllListeners()
  {
    try
    {
      synchronized (this.agU)
      {
        Iterator localIterator = this.agU.values().iterator();
        while (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          if (localb != null) {
            ((ni)this.Ee.hw()).a(localb);
          }
        }
      }
      this.agU.clear();
    }
    catch (RemoteException localRemoteException)
    {
      throw new IllegalStateException(localRemoteException);
    }
  }
  
  private static class a
    extends Handler
  {
    private final LocationListener agV;
    
    public a(LocationListener paramLocationListener)
    {
      this.agV = paramLocationListener;
    }
    
    public a(LocationListener paramLocationListener, Looper paramLooper)
    {
      super();
      this.agV = paramLocationListener;
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        Log.e("LocationClientHelper", "unknown message in LocationHandler.handleMessage");
        return;
      }
      Location localLocation = new Location((Location)paramMessage.obj);
      this.agV.onLocationChanged(localLocation);
    }
  }
  
  private static class b
    extends b.a
  {
    private Handler agW;
    
    b(LocationListener paramLocationListener, Looper paramLooper)
    {
      if (paramLooper == null) {}
      for (nj.a locala = new nj.a(paramLocationListener);; locala = new nj.a(paramLocationListener, paramLooper))
      {
        this.agW = locala;
        return;
      }
    }
    
    public void onLocationChanged(Location paramLocation)
    {
      if (this.agW == null)
      {
        Log.e("LocationClientHelper", "Received a location in client after calling removeLocationUpdates.");
        return;
      }
      Message localMessage = Message.obtain();
      localMessage.what = 1;
      localMessage.obj = paramLocation;
      this.agW.sendMessage(localMessage);
    }
    
    public void release()
    {
      this.agW = null;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nj
 * JD-Core Version:    0.7.0.1
 */