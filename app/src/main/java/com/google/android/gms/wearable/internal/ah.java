package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wearable.MessageApi;
import com.google.android.gms.wearable.MessageApi.MessageListener;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;

public final class ah
  implements MessageApi
{
  private PendingResult<Status> a(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener, IntentFilter[] paramArrayOfIntentFilter)
  {
    return paramGoogleApiClient.a(new a(paramGoogleApiClient, paramMessageListener, paramArrayOfIntentFilter, null));
  }
  
  public PendingResult<Status> addListener(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener)
  {
    return a(paramGoogleApiClient, paramMessageListener, null);
  }
  
  public PendingResult<Status> removeListener(GoogleApiClient paramGoogleApiClient, final MessageApi.MessageListener paramMessageListener)
  {
    paramGoogleApiClient.a(new d(paramGoogleApiClient)
    {
      protected void a(ba paramAnonymousba)
        throws RemoteException
      {
        paramAnonymousba.a(this, paramMessageListener);
      }
      
      public Status b(Status paramAnonymousStatus)
      {
        return paramAnonymousStatus;
      }
    });
  }
  
  public PendingResult<MessageApi.SendMessageResult> sendMessage(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2, final byte[] paramArrayOfByte)
  {
    paramGoogleApiClient.a(new d(paramGoogleApiClient)
    {
      protected void a(ba paramAnonymousba)
        throws RemoteException
      {
        paramAnonymousba.a(this, paramString1, paramString2, paramArrayOfByte);
      }
      
      protected MessageApi.SendMessageResult aI(Status paramAnonymousStatus)
      {
        return new ah.b(paramAnonymousStatus, -1);
      }
    });
  }
  
  private static final class a
    extends d<Status>
  {
    private IntentFilter[] axD;
    private MessageApi.MessageListener axV;
    
    private a(GoogleApiClient paramGoogleApiClient, MessageApi.MessageListener paramMessageListener, IntentFilter[] paramArrayOfIntentFilter)
    {
      super();
      this.axV = paramMessageListener;
      this.axD = paramArrayOfIntentFilter;
    }
    
    protected void a(ba paramba)
      throws RemoteException
    {
      paramba.a(this, this.axV, this.axD);
      this.axV = null;
      this.axD = null;
    }
    
    public Status b(Status paramStatus)
    {
      this.axV = null;
      this.axD = null;
      return paramStatus;
    }
  }
  
  public static class b
    implements MessageApi.SendMessageResult
  {
    private final Status Eb;
    private final int ve;
    
    public b(Status paramStatus, int paramInt)
    {
      this.Eb = paramStatus;
      this.ve = paramInt;
    }
    
    public int getRequestId()
    {
      return this.ve;
    }
    
    public Status getStatus()
    {
      return this.Eb;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.ah
 * JD-Core Version:    0.7.0.1
 */