package com.google.android.gms.wearable.internal;

import android.content.Context;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseOutputStream;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.jl;
import com.google.android.gms.internal.jl.e;
import com.google.android.gms.internal.jt;
import com.google.android.gms.wearable.Asset;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DataListener;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemAsset;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import com.google.android.gms.wearable.NodeApi.NodeListener;
import com.google.android.gms.wearable.PutDataRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class ba
  extends jl<af>
{
  private final ExecutorService asJ = Executors.newCachedThreadPool();
  private final ag<DataApi.DataListener> ayg = new ag.b();
  private final ag<MessageApi.MessageListener> ayh = new ag.c();
  private final ag<NodeApi.NodeListener> ayi = new ag.d();
  
  public ba(Context paramContext, Looper paramLooper, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    super(paramContext, paramLooper, paramConnectionCallbacks, paramOnConnectionFailedListener, new String[0]);
  }
  
  private FutureTask<Boolean> a(final ParcelFileDescriptor paramParcelFileDescriptor, final byte[] paramArrayOfByte)
  {
    new FutureTask(new Callable()
    {
      public Boolean rr()
      {
        if (Log.isLoggable("WearableClient", 3)) {
          Log.d("WearableClient", "processAssets: writing data to FD : " + paramParcelFileDescriptor);
        }
        ParcelFileDescriptor.AutoCloseOutputStream localAutoCloseOutputStream = new ParcelFileDescriptor.AutoCloseOutputStream(paramParcelFileDescriptor);
        try
        {
          localAutoCloseOutputStream.write(paramArrayOfByte);
          localAutoCloseOutputStream.flush();
          if (Log.isLoggable("WearableClient", 3)) {
            Log.d("WearableClient", "processAssets: wrote data: " + paramParcelFileDescriptor);
          }
          Boolean localBoolean = Boolean.valueOf(true);
          label266:
          return localBoolean;
        }
        catch (IOException localIOException2)
        {
          localIOException2 = localIOException2;
          Log.w("WearableClient", "processAssets: writing data failed: " + paramParcelFileDescriptor);
          return Boolean.valueOf(false);
        }
        finally
        {
          try
          {
            if (Log.isLoggable("WearableClient", 3)) {
              Log.d("WearableClient", "processAssets: closing: " + paramParcelFileDescriptor);
            }
            localAutoCloseOutputStream.close();
          }
          catch (IOException localIOException1)
          {
            break label266;
          }
        }
      }
    });
  }
  
  protected void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    if (Log.isLoggable("WearableClient", 2)) {
      Log.d("WearableClient", "onPostInitHandler: statusCode " + paramInt);
    }
    if (paramInt == 0)
    {
      this.ayg.ca(paramIBinder);
      this.ayh.ca(paramIBinder);
      this.ayi.ca(paramIBinder);
    }
    super.a(paramInt, paramIBinder, paramBundle);
  }
  
  public void a(BaseImplementation.b<DataApi.DataItemResult> paramb, Uri paramUri)
    throws RemoteException
  {
    ((af)hw()).a(new az.d(paramb), paramUri);
  }
  
  public void a(BaseImplementation.b<DataApi.GetFdForAssetResult> paramb, Asset paramAsset)
    throws RemoteException
  {
    ((af)hw()).a(new az.f(paramb), paramAsset);
  }
  
  public void a(BaseImplementation.b<Status> paramb, DataApi.DataListener paramDataListener)
    throws RemoteException
  {
    this.ayg.a(this, paramb, paramDataListener);
  }
  
  public void a(BaseImplementation.b<Status> paramb, DataApi.DataListener paramDataListener, IntentFilter[] paramArrayOfIntentFilter)
    throws RemoteException
  {
    this.ayg.a(this, paramb, paramDataListener, paramArrayOfIntentFilter);
  }
  
  public void a(BaseImplementation.b<DataApi.GetFdForAssetResult> paramb, DataItemAsset paramDataItemAsset)
    throws RemoteException
  {
    a(paramb, Asset.createFromRef(paramDataItemAsset.getId()));
  }
  
  public void a(BaseImplementation.b<Status> paramb, MessageApi.MessageListener paramMessageListener)
    throws RemoteException
  {
    this.ayh.a(this, paramb, paramMessageListener);
  }
  
  public void a(BaseImplementation.b<Status> paramb, MessageApi.MessageListener paramMessageListener, IntentFilter[] paramArrayOfIntentFilter)
    throws RemoteException
  {
    this.ayh.a(this, paramb, paramMessageListener, paramArrayOfIntentFilter);
  }
  
  public void a(BaseImplementation.b<Status> paramb, NodeApi.NodeListener paramNodeListener)
    throws RemoteException, RemoteException
  {
    this.ayi.a(this, paramb, paramNodeListener, null);
  }
  
  public void a(BaseImplementation.b<DataApi.DataItemResult> paramb, PutDataRequest paramPutDataRequest)
    throws RemoteException
  {
    Iterator localIterator1 = paramPutDataRequest.getAssets().entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Asset localAsset2 = (Asset)((Map.Entry)localIterator1.next()).getValue();
      if ((localAsset2.getData() == null) && (localAsset2.getDigest() == null) && (localAsset2.getFd() == null) && (localAsset2.getUri() == null)) {
        throw new IllegalArgumentException("Put for " + paramPutDataRequest.getUri() + " contains invalid asset: " + localAsset2);
      }
    }
    PutDataRequest localPutDataRequest = PutDataRequest.k(paramPutDataRequest.getUri());
    localPutDataRequest.setData(paramPutDataRequest.getData());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator2 = paramPutDataRequest.getAssets().entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator2.next();
      Asset localAsset1 = (Asset)localEntry.getValue();
      if (localAsset1.getData() == null) {
        localPutDataRequest.putAsset((String)localEntry.getKey(), (Asset)localEntry.getValue());
      } else {
        try
        {
          ParcelFileDescriptor[] arrayOfParcelFileDescriptor = ParcelFileDescriptor.createPipe();
          if (Log.isLoggable("WearableClient", 3)) {
            Log.d("WearableClient", "processAssets: replacing data with FD in asset: " + localAsset1 + " read:" + arrayOfParcelFileDescriptor[0] + " write:" + arrayOfParcelFileDescriptor[1]);
          }
          localPutDataRequest.putAsset((String)localEntry.getKey(), Asset.createFromFd(arrayOfParcelFileDescriptor[0]));
          FutureTask localFutureTask = a(arrayOfParcelFileDescriptor[1], localAsset1.getData());
          localArrayList.add(localFutureTask);
          this.asJ.submit(localFutureTask);
        }
        catch (IOException localIOException)
        {
          throw new IllegalStateException("Unable to create ParcelFileDescriptor for asset in request: " + paramPutDataRequest, localIOException);
        }
      }
    }
    try
    {
      ((af)hw()).a(new az.i(paramb, localArrayList), localPutDataRequest);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      throw new IllegalStateException("Unable to putDataItem: " + paramPutDataRequest, localNullPointerException);
    }
  }
  
  public void a(BaseImplementation.b<MessageApi.SendMessageResult> paramb, String paramString1, String paramString2, byte[] paramArrayOfByte)
    throws RemoteException
  {
    ((af)hw()).a(new az.j(paramb), paramString1, paramString2, paramArrayOfByte);
  }
  
  protected void a(jt paramjt, jl.e parame)
    throws RemoteException
  {
    paramjt.e(parame, 6587000, getContext().getPackageName());
  }
  
  public void b(BaseImplementation.b<DataItemBuffer> paramb, Uri paramUri)
    throws RemoteException
  {
    ((af)hw()).b(new az.e(paramb), paramUri);
  }
  
  public void b(BaseImplementation.b<Status> paramb, NodeApi.NodeListener paramNodeListener)
    throws RemoteException
  {
    this.ayi.a(this, paramb, paramNodeListener);
  }
  
  protected String bK()
  {
    return "com.google.android.gms.wearable.BIND";
  }
  
  protected String bL()
  {
    return "com.google.android.gms.wearable.internal.IWearableService";
  }
  
  public void c(BaseImplementation.b<DataApi.DeleteDataItemsResult> paramb, Uri paramUri)
    throws RemoteException
  {
    ((af)hw()).c(new az.b(paramb), paramUri);
  }
  
  protected af cb(IBinder paramIBinder)
  {
    return af.a.bZ(paramIBinder);
  }
  
  public void disconnect()
  {
    this.ayg.b(this);
    this.ayh.b(this);
    this.ayi.b(this);
    super.disconnect();
  }
  
  public void n(BaseImplementation.b<DataItemBuffer> paramb)
    throws RemoteException
  {
    ((af)hw()).b(new az.e(paramb));
  }
  
  public void o(BaseImplementation.b<NodeApi.GetLocalNodeResult> paramb)
    throws RemoteException
  {
    ((af)hw()).c(new az.g(paramb));
  }
  
  public void p(BaseImplementation.b<NodeApi.GetConnectedNodesResult> paramb)
    throws RemoteException
  {
    ((af)hw()).d(new az.c(paramb));
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.ba
 * JD-Core Version:    0.7.0.1
 */