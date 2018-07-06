package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.BaseImplementation.a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.im;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import java.io.IOException;

public final class Cast
{
  public static final Api<CastOptions> API = new Api(DR, DQ, new Scope[0]);
  public static final CastApi CastApi = new Cast.CastApi.a();
  static final Api.c<im> DQ = new Api.c();
  private static final Api.b<im, CastOptions> DR = new Api.b()
  {
    public im a(Context paramAnonymousContext, Looper paramAnonymousLooper, jg paramAnonymousjg, Cast.CastOptions paramAnonymousCastOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      jx.b(paramAnonymousCastOptions, "Setting the API options is required.");
      return new im(paramAnonymousContext, paramAnonymousLooper, paramAnonymousCastOptions.Fz, Cast.CastOptions.a(paramAnonymousCastOptions), paramAnonymousCastOptions.FA, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener);
    }
    
    public int getPriority()
    {
      return 2147483647;
    }
  };
  public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
  public static final int MAX_MESSAGE_LENGTH = 65536;
  public static final int MAX_NAMESPACE_LENGTH = 128;
  
  public static abstract interface ApplicationConnectionResult
    extends Result
  {
    public abstract ApplicationMetadata getApplicationMetadata();
    
    public abstract String getApplicationStatus();
    
    public abstract String getSessionId();
    
    public abstract boolean getWasLaunched();
  }
  
  public static abstract interface CastApi
  {
    public abstract ApplicationMetadata getApplicationMetadata(GoogleApiClient paramGoogleApiClient)
      throws IllegalStateException;
    
    public abstract String getApplicationStatus(GoogleApiClient paramGoogleApiClient)
      throws IllegalStateException;
    
    public abstract double getVolume(GoogleApiClient paramGoogleApiClient)
      throws IllegalStateException;
    
    public abstract boolean isMute(GoogleApiClient paramGoogleApiClient)
      throws IllegalStateException;
    
    public abstract PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient paramGoogleApiClient);
    
    public abstract PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient paramGoogleApiClient, String paramString);
    
    public abstract PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2);
    
    public abstract PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient paramGoogleApiClient, String paramString);
    
    public abstract PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient paramGoogleApiClient, String paramString, LaunchOptions paramLaunchOptions);
    
    @Deprecated
    public abstract PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient paramGoogleApiClient, String paramString, boolean paramBoolean);
    
    public abstract PendingResult<Status> leaveApplication(GoogleApiClient paramGoogleApiClient);
    
    public abstract void removeMessageReceivedCallbacks(GoogleApiClient paramGoogleApiClient, String paramString)
      throws IOException, IllegalArgumentException;
    
    public abstract void requestStatus(GoogleApiClient paramGoogleApiClient)
      throws IOException, IllegalStateException;
    
    public abstract PendingResult<Status> sendMessage(GoogleApiClient paramGoogleApiClient, String paramString1, String paramString2);
    
    public abstract void setMessageReceivedCallbacks(GoogleApiClient paramGoogleApiClient, String paramString, Cast.MessageReceivedCallback paramMessageReceivedCallback)
      throws IOException, IllegalStateException;
    
    public abstract void setMute(GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
      throws IOException, IllegalStateException;
    
    public abstract void setVolume(GoogleApiClient paramGoogleApiClient, double paramDouble)
      throws IOException, IllegalArgumentException, IllegalStateException;
    
    public abstract PendingResult<Status> stopApplication(GoogleApiClient paramGoogleApiClient);
    
    public abstract PendingResult<Status> stopApplication(GoogleApiClient paramGoogleApiClient, String paramString);
    
    public static final class a
      implements Cast.CastApi
    {
      public ApplicationMetadata getApplicationMetadata(GoogleApiClient paramGoogleApiClient)
        throws IllegalStateException
      {
        return ((im)paramGoogleApiClient.a(Cast.DQ)).getApplicationMetadata();
      }
      
      public String getApplicationStatus(GoogleApiClient paramGoogleApiClient)
        throws IllegalStateException
      {
        return ((im)paramGoogleApiClient.a(Cast.DQ)).getApplicationStatus();
      }
      
      public double getVolume(GoogleApiClient paramGoogleApiClient)
        throws IllegalStateException
      {
        return ((im)paramGoogleApiClient.a(Cast.DQ)).fZ();
      }
      
      public boolean isMute(GoogleApiClient paramGoogleApiClient)
        throws IllegalStateException
      {
        return ((im)paramGoogleApiClient.a(Cast.DQ)).isMute();
      }
      
      public PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient paramGoogleApiClient)
      {
        paramGoogleApiClient.b(new Cast.c(paramGoogleApiClient)
        {
          protected void a(im paramAnonymousim)
            throws RemoteException
          {
            try
            {
              paramAnonymousim.b(null, null, this);
              return;
            }
            catch (IllegalStateException localIllegalStateException)
            {
              W(2001);
            }
          }
        });
      }
      
      public PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient paramGoogleApiClient, final String paramString)
      {
        paramGoogleApiClient.b(new Cast.c(paramGoogleApiClient)
        {
          protected void a(im paramAnonymousim)
            throws RemoteException
          {
            try
            {
              paramAnonymousim.b(paramString, null, this);
              return;
            }
            catch (IllegalStateException localIllegalStateException)
            {
              W(2001);
            }
          }
        });
      }
      
      public PendingResult<Cast.ApplicationConnectionResult> joinApplication(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2)
      {
        paramGoogleApiClient.b(new Cast.c(paramGoogleApiClient)
        {
          protected void a(im paramAnonymousim)
            throws RemoteException
          {
            try
            {
              paramAnonymousim.b(paramString1, paramString2, this);
              return;
            }
            catch (IllegalStateException localIllegalStateException)
            {
              W(2001);
            }
          }
        });
      }
      
      public PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient paramGoogleApiClient, final String paramString)
      {
        paramGoogleApiClient.b(new Cast.c(paramGoogleApiClient)
        {
          protected void a(im paramAnonymousim)
            throws RemoteException
          {
            try
            {
              paramAnonymousim.a(paramString, false, this);
              return;
            }
            catch (IllegalStateException localIllegalStateException)
            {
              W(2001);
            }
          }
        });
      }
      
      public PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient paramGoogleApiClient, final String paramString, final LaunchOptions paramLaunchOptions)
      {
        paramGoogleApiClient.b(new Cast.c(paramGoogleApiClient)
        {
          protected void a(im paramAnonymousim)
            throws RemoteException
          {
            try
            {
              paramAnonymousim.a(paramString, paramLaunchOptions, this);
              return;
            }
            catch (IllegalStateException localIllegalStateException)
            {
              W(2001);
            }
          }
        });
      }
      
      @Deprecated
      public PendingResult<Cast.ApplicationConnectionResult> launchApplication(GoogleApiClient paramGoogleApiClient, String paramString, boolean paramBoolean)
      {
        return launchApplication(paramGoogleApiClient, paramString, new LaunchOptions.Builder().setRelaunchIfRunning(paramBoolean).build());
      }
      
      public PendingResult<Status> leaveApplication(GoogleApiClient paramGoogleApiClient)
      {
        paramGoogleApiClient.b(new Cast.b(paramGoogleApiClient)
        {
          protected void a(im paramAnonymousim)
            throws RemoteException
          {
            try
            {
              paramAnonymousim.d(this);
              return;
            }
            catch (IllegalStateException localIllegalStateException)
            {
              W(2001);
            }
          }
        });
      }
      
      public void removeMessageReceivedCallbacks(GoogleApiClient paramGoogleApiClient, String paramString)
        throws IOException, IllegalArgumentException
      {
        try
        {
          ((im)paramGoogleApiClient.a(Cast.DQ)).aE(paramString);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          throw new IOException("service error");
        }
      }
      
      public void requestStatus(GoogleApiClient paramGoogleApiClient)
        throws IOException, IllegalStateException
      {
        try
        {
          ((im)paramGoogleApiClient.a(Cast.DQ)).fY();
          return;
        }
        catch (RemoteException localRemoteException)
        {
          throw new IOException("service error");
        }
      }
      
      public PendingResult<Status> sendMessage(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2)
      {
        paramGoogleApiClient.b(new Cast.b(paramGoogleApiClient)
        {
          protected void a(im paramAnonymousim)
            throws RemoteException
          {
            try
            {
              paramAnonymousim.a(paramString1, paramString2, this);
              return;
            }
            catch (IllegalArgumentException localIllegalArgumentException)
            {
              W(2001);
              return;
            }
            catch (IllegalStateException localIllegalStateException)
            {
              W(2001);
            }
          }
        });
      }
      
      public void setMessageReceivedCallbacks(GoogleApiClient paramGoogleApiClient, String paramString, Cast.MessageReceivedCallback paramMessageReceivedCallback)
        throws IOException, IllegalStateException
      {
        try
        {
          ((im)paramGoogleApiClient.a(Cast.DQ)).a(paramString, paramMessageReceivedCallback);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          throw new IOException("service error");
        }
      }
      
      public void setMute(GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
        throws IOException, IllegalStateException
      {
        try
        {
          ((im)paramGoogleApiClient.a(Cast.DQ)).I(paramBoolean);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          throw new IOException("service error");
        }
      }
      
      public void setVolume(GoogleApiClient paramGoogleApiClient, double paramDouble)
        throws IOException, IllegalArgumentException, IllegalStateException
      {
        try
        {
          ((im)paramGoogleApiClient.a(Cast.DQ)).a(paramDouble);
          return;
        }
        catch (RemoteException localRemoteException)
        {
          throw new IOException("service error");
        }
      }
      
      public PendingResult<Status> stopApplication(GoogleApiClient paramGoogleApiClient)
      {
        paramGoogleApiClient.b(new Cast.b(paramGoogleApiClient)
        {
          protected void a(im paramAnonymousim)
            throws RemoteException
          {
            try
            {
              paramAnonymousim.a("", this);
              return;
            }
            catch (IllegalStateException localIllegalStateException)
            {
              W(2001);
            }
          }
        });
      }
      
      public PendingResult<Status> stopApplication(GoogleApiClient paramGoogleApiClient, final String paramString)
      {
        paramGoogleApiClient.b(new Cast.b(paramGoogleApiClient)
        {
          protected void a(im paramAnonymousim)
            throws RemoteException
          {
            if (TextUtils.isEmpty(paramString))
            {
              e(2001, "IllegalArgument: sessionId cannot be null or empty");
              return;
            }
            try
            {
              paramAnonymousim.a(paramString, this);
              return;
            }
            catch (IllegalStateException localIllegalStateException)
            {
              W(2001);
            }
          }
        });
      }
    }
  }
  
  public static final class CastOptions
    implements Api.ApiOptions.HasOptions
  {
    final Cast.Listener FA;
    private final int FB;
    final CastDevice Fz;
    
    private CastOptions(Builder paramBuilder)
    {
      this.Fz = paramBuilder.FC;
      this.FA = paramBuilder.FD;
      this.FB = Builder.a(paramBuilder);
    }
    
    public static Builder builder(CastDevice paramCastDevice, Cast.Listener paramListener)
    {
      return new Builder(paramCastDevice, paramListener, null);
    }
    
    public static final class Builder
    {
      CastDevice FC;
      Cast.Listener FD;
      private int FE;
      
      private Builder(CastDevice paramCastDevice, Cast.Listener paramListener)
      {
        jx.b(paramCastDevice, "CastDevice parameter cannot be null");
        jx.b(paramListener, "CastListener parameter cannot be null");
        this.FC = paramCastDevice;
        this.FD = paramListener;
        this.FE = 0;
      }
      
      public Cast.CastOptions build()
      {
        return new Cast.CastOptions(this, null);
      }
      
      public Builder setVerboseLoggingEnabled(boolean paramBoolean)
      {
        if (paramBoolean)
        {
          this.FE = (0x1 | this.FE);
          return this;
        }
        this.FE = (0xFFFFFFFE & this.FE);
        return this;
      }
    }
  }
  
  public static class Listener
  {
    public void X(int paramInt) {}
    
    public void Y(int paramInt) {}
    
    public void onApplicationDisconnected(int paramInt) {}
    
    public void onApplicationMetadataChanged(ApplicationMetadata paramApplicationMetadata) {}
    
    public void onApplicationStatusChanged() {}
    
    public void onVolumeChanged() {}
  }
  
  public static abstract interface MessageReceivedCallback
  {
    public abstract void onMessageReceived(CastDevice paramCastDevice, String paramString1, String paramString2);
  }
  
  protected static abstract class a<R extends Result>
    extends BaseImplementation.a<R, im>
  {
    public a(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    public void W(int paramInt)
    {
      b(c(new Status(paramInt)));
    }
    
    public void e(int paramInt, String paramString)
    {
      b(c(new Status(paramInt, paramString, null)));
    }
  }
  
  private static abstract class b
    extends Cast.a<Status>
  {
    b(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public Status b(Status paramStatus)
    {
      return paramStatus;
    }
  }
  
  private static abstract class c
    extends Cast.a<Cast.ApplicationConnectionResult>
  {
    public c(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public Cast.ApplicationConnectionResult i(final Status paramStatus)
    {
      new Cast.ApplicationConnectionResult()
      {
        public ApplicationMetadata getApplicationMetadata()
        {
          return null;
        }
        
        public String getApplicationStatus()
        {
          return null;
        }
        
        public String getSessionId()
        {
          return null;
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
        
        public boolean getWasLaunched()
        {
          return false;
        }
      };
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.Cast
 * JD-Core Version:    0.7.0.1
 */