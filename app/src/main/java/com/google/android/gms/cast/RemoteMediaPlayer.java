package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.im;
import com.google.android.gms.internal.it;
import com.google.android.gms.internal.iu;
import com.google.android.gms.internal.iv;
import java.io.IOException;
import org.json.JSONObject;

public class RemoteMediaPlayer
  implements Cast.MessageReceivedCallback
{
  public static final int RESUME_STATE_PAUSE = 2;
  public static final int RESUME_STATE_PLAY = 1;
  public static final int RESUME_STATE_UNCHANGED = 0;
  public static final int STATUS_CANCELED = 2101;
  public static final int STATUS_FAILED = 2100;
  public static final int STATUS_REPLACED = 2103;
  public static final int STATUS_SUCCEEDED = 0;
  public static final int STATUS_TIMED_OUT = 2102;
  private final it Gw = new it()
  {
    protected void onMetadataUpdated()
    {
      RemoteMediaPlayer.b(RemoteMediaPlayer.this);
    }
    
    protected void onStatusUpdated()
    {
      RemoteMediaPlayer.a(RemoteMediaPlayer.this);
    }
  };
  private final a Gx = new a();
  private OnMetadataUpdatedListener Gy;
  private OnStatusUpdatedListener Gz;
  private final Object mH = new Object();
  
  public RemoteMediaPlayer()
  {
    this.Gw.a(this.Gx);
  }
  
  private void onMetadataUpdated()
  {
    if (this.Gy != null) {
      this.Gy.onMetadataUpdated();
    }
  }
  
  private void onStatusUpdated()
  {
    if (this.Gz != null) {
      this.Gz.onStatusUpdated();
    }
  }
  
  public long getApproximateStreamPosition()
  {
    synchronized (this.mH)
    {
      long l = this.Gw.getApproximateStreamPosition();
      return l;
    }
  }
  
  public MediaInfo getMediaInfo()
  {
    synchronized (this.mH)
    {
      MediaInfo localMediaInfo = this.Gw.getMediaInfo();
      return localMediaInfo;
    }
  }
  
  public MediaStatus getMediaStatus()
  {
    synchronized (this.mH)
    {
      MediaStatus localMediaStatus = this.Gw.getMediaStatus();
      return localMediaStatus;
    }
  }
  
  public String getNamespace()
  {
    return this.Gw.getNamespace();
  }
  
  public long getStreamDuration()
  {
    synchronized (this.mH)
    {
      long l = this.Gw.getStreamDuration();
      return l;
    }
  }
  
  public PendingResult<MediaChannelResult> load(GoogleApiClient paramGoogleApiClient, MediaInfo paramMediaInfo)
  {
    return load(paramGoogleApiClient, paramMediaInfo, true, 0L, null, null);
  }
  
  public PendingResult<MediaChannelResult> load(GoogleApiClient paramGoogleApiClient, MediaInfo paramMediaInfo, boolean paramBoolean)
  {
    return load(paramGoogleApiClient, paramMediaInfo, paramBoolean, 0L, null, null);
  }
  
  public PendingResult<MediaChannelResult> load(GoogleApiClient paramGoogleApiClient, MediaInfo paramMediaInfo, boolean paramBoolean, long paramLong)
  {
    return load(paramGoogleApiClient, paramMediaInfo, paramBoolean, paramLong, null, null);
  }
  
  public PendingResult<MediaChannelResult> load(GoogleApiClient paramGoogleApiClient, MediaInfo paramMediaInfo, boolean paramBoolean, long paramLong, JSONObject paramJSONObject)
  {
    return load(paramGoogleApiClient, paramMediaInfo, paramBoolean, paramLong, null, paramJSONObject);
  }
  
  public PendingResult<MediaChannelResult> load(final GoogleApiClient paramGoogleApiClient, final MediaInfo paramMediaInfo, final boolean paramBoolean, final long paramLong, long[] paramArrayOfLong, final JSONObject paramJSONObject)
  {
    paramGoogleApiClient.b(new b(paramGoogleApiClient)
    {
      protected void a(im paramAnonymousim)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.GR, paramMediaInfo, paramBoolean, paramLong, paramJSONObject, this.GI);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(k(new Status(2100)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject2 = finally;
            throw localObject2;
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
          }
          return;
        }
      }
    });
  }
  
  public void onMessageReceived(CastDevice paramCastDevice, String paramString1, String paramString2)
  {
    this.Gw.aD(paramString2);
  }
  
  public PendingResult<MediaChannelResult> pause(GoogleApiClient paramGoogleApiClient)
  {
    return pause(paramGoogleApiClient, null);
  }
  
  public PendingResult<MediaChannelResult> pause(final GoogleApiClient paramGoogleApiClient, final JSONObject paramJSONObject)
  {
    paramGoogleApiClient.b(new b(paramGoogleApiClient)
    {
      protected void a(im paramAnonymousim)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.GR, paramJSONObject);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(k(new Status(2100)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject2 = finally;
            throw localObject2;
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
          }
          return;
        }
      }
    });
  }
  
  public PendingResult<MediaChannelResult> play(GoogleApiClient paramGoogleApiClient)
  {
    return play(paramGoogleApiClient, null);
  }
  
  public PendingResult<MediaChannelResult> play(final GoogleApiClient paramGoogleApiClient, final JSONObject paramJSONObject)
  {
    paramGoogleApiClient.b(new b(paramGoogleApiClient)
    {
      protected void a(im paramAnonymousim)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).c(this.GR, paramJSONObject);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(k(new Status(2100)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject2 = finally;
            throw localObject2;
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
          }
          return;
        }
      }
    });
  }
  
  public PendingResult<MediaChannelResult> requestStatus(final GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.b(new b(paramGoogleApiClient)
    {
      protected void a(im paramAnonymousim)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.GR);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(k(new Status(2100)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject2 = finally;
            throw localObject2;
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
          }
          return;
        }
      }
    });
  }
  
  public PendingResult<MediaChannelResult> seek(GoogleApiClient paramGoogleApiClient, long paramLong)
  {
    return seek(paramGoogleApiClient, paramLong, 0, null);
  }
  
  public PendingResult<MediaChannelResult> seek(GoogleApiClient paramGoogleApiClient, long paramLong, int paramInt)
  {
    return seek(paramGoogleApiClient, paramLong, paramInt, null);
  }
  
  public PendingResult<MediaChannelResult> seek(final GoogleApiClient paramGoogleApiClient, final long paramLong, int paramInt, final JSONObject paramJSONObject)
  {
    paramGoogleApiClient.b(new b(paramGoogleApiClient)
    {
      protected void a(im paramAnonymousim)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.GR, paramLong, paramJSONObject, this.GI);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(k(new Status(2100)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject2 = finally;
            throw localObject2;
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
          }
          return;
        }
      }
    });
  }
  
  public PendingResult<MediaChannelResult> setActiveMediaTracks(final GoogleApiClient paramGoogleApiClient, final long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length == 0)) {
      throw new IllegalArgumentException("trackIds cannot be null or empty");
    }
    paramGoogleApiClient.b(new b(paramGoogleApiClient)
    {
      protected void a(im paramAnonymousim)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.GR, paramArrayOfLong);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(k(new Status(2100)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject2 = finally;
            throw localObject2;
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
          }
          return;
        }
      }
    });
  }
  
  public void setOnMetadataUpdatedListener(OnMetadataUpdatedListener paramOnMetadataUpdatedListener)
  {
    this.Gy = paramOnMetadataUpdatedListener;
  }
  
  public void setOnStatusUpdatedListener(OnStatusUpdatedListener paramOnStatusUpdatedListener)
  {
    this.Gz = paramOnStatusUpdatedListener;
  }
  
  public PendingResult<MediaChannelResult> setStreamMute(GoogleApiClient paramGoogleApiClient, boolean paramBoolean)
  {
    return setStreamMute(paramGoogleApiClient, paramBoolean, null);
  }
  
  public PendingResult<MediaChannelResult> setStreamMute(final GoogleApiClient paramGoogleApiClient, final boolean paramBoolean, final JSONObject paramJSONObject)
  {
    paramGoogleApiClient.b(new b(paramGoogleApiClient)
    {
      protected void a(im paramAnonymousim)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.GR, paramBoolean, paramJSONObject);
          }
          catch (IllegalStateException localIllegalStateException)
          {
            for (;;)
            {
              b(k(new Status(2100)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject2 = finally;
            throw localObject2;
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(k(new Status(2100)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
          }
          return;
        }
      }
    });
  }
  
  public PendingResult<MediaChannelResult> setStreamVolume(GoogleApiClient paramGoogleApiClient, double paramDouble)
    throws IllegalArgumentException
  {
    return setStreamVolume(paramGoogleApiClient, paramDouble, null);
  }
  
  public PendingResult<MediaChannelResult> setStreamVolume(final GoogleApiClient paramGoogleApiClient, final double paramDouble, JSONObject paramJSONObject)
    throws IllegalArgumentException
  {
    if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble))) {
      throw new IllegalArgumentException("Volume cannot be " + paramDouble);
    }
    paramGoogleApiClient.b(new b(paramGoogleApiClient)
    {
      protected void a(im paramAnonymousim)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.GR, paramDouble, this.GI);
          }
          catch (IllegalStateException localIllegalStateException)
          {
            for (;;)
            {
              b(k(new Status(2100)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject2 = finally;
            throw localObject2;
          }
          catch (IllegalArgumentException localIllegalArgumentException)
          {
            for (;;)
            {
              b(k(new Status(2100)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(k(new Status(2100)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
          }
          return;
        }
      }
    });
  }
  
  public PendingResult<MediaChannelResult> setTextTrackStyle(final GoogleApiClient paramGoogleApiClient, final TextTrackStyle paramTextTrackStyle)
  {
    if (paramTextTrackStyle == null) {
      throw new IllegalArgumentException("trackStyle cannot be null");
    }
    paramGoogleApiClient.b(new b(paramGoogleApiClient)
    {
      protected void a(im paramAnonymousim)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).a(this.GR, paramTextTrackStyle);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(k(new Status(2100)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject2 = finally;
            throw localObject2;
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
          }
          return;
        }
      }
    });
  }
  
  public PendingResult<MediaChannelResult> stop(GoogleApiClient paramGoogleApiClient)
  {
    return stop(paramGoogleApiClient, null);
  }
  
  public PendingResult<MediaChannelResult> stop(final GoogleApiClient paramGoogleApiClient, final JSONObject paramJSONObject)
  {
    paramGoogleApiClient.b(new b(paramGoogleApiClient)
    {
      protected void a(im paramAnonymousim)
      {
        synchronized (RemoteMediaPlayer.c(RemoteMediaPlayer.this))
        {
          RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(paramGoogleApiClient);
          try
          {
            RemoteMediaPlayer.e(RemoteMediaPlayer.this).b(this.GR, paramJSONObject);
          }
          catch (IOException localIOException)
          {
            for (;;)
            {
              b(k(new Status(2100)));
              RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
            }
            localObject2 = finally;
            throw localObject2;
          }
          finally
          {
            RemoteMediaPlayer.d(RemoteMediaPlayer.this).b(null);
          }
          return;
        }
      }
    });
  }
  
  public static abstract interface MediaChannelResult
    extends Result
  {
    public abstract JSONObject getCustomData();
  }
  
  public static abstract interface OnMetadataUpdatedListener
  {
    public abstract void onMetadataUpdated();
  }
  
  public static abstract interface OnStatusUpdatedListener
  {
    public abstract void onStatusUpdated();
  }
  
  private class a
    implements iu
  {
    private GoogleApiClient GN;
    private long GO = 0L;
    
    public a() {}
    
    public void a(String paramString1, String paramString2, long paramLong, String paramString3)
      throws IOException
    {
      if (this.GN == null) {
        throw new IOException("No GoogleApiClient available");
      }
      Cast.CastApi.sendMessage(this.GN, paramString1, paramString2).setResultCallback(new a(paramLong));
    }
    
    public void b(GoogleApiClient paramGoogleApiClient)
    {
      this.GN = paramGoogleApiClient;
    }
    
    public long fS()
    {
      long l = 1L + this.GO;
      this.GO = l;
      return l;
    }
    
    private final class a
      implements ResultCallback<Status>
    {
      private final long GP;
      
      a(long paramLong)
      {
        this.GP = paramLong;
      }
      
      public void j(Status paramStatus)
      {
        if (!paramStatus.isSuccess()) {
          RemoteMediaPlayer.e(RemoteMediaPlayer.this).b(this.GP, paramStatus.getStatusCode());
        }
      }
    }
  }
  
  private static abstract class b
    extends Cast.a<RemoteMediaPlayer.MediaChannelResult>
  {
    iv GR = new iv()
    {
      public void a(long paramAnonymousLong, int paramAnonymousInt, JSONObject paramAnonymousJSONObject)
      {
        RemoteMediaPlayer.b.this.b(new RemoteMediaPlayer.c(new Status(paramAnonymousInt), paramAnonymousJSONObject));
      }
      
      public void n(long paramAnonymousLong)
      {
        RemoteMediaPlayer.b.this.b(RemoteMediaPlayer.b.this.k(new Status(2103)));
      }
    };
    
    b(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public RemoteMediaPlayer.MediaChannelResult k(final Status paramStatus)
    {
      new RemoteMediaPlayer.MediaChannelResult()
      {
        public JSONObject getCustomData()
        {
          return null;
        }
        
        public Status getStatus()
        {
          return paramStatus;
        }
      };
    }
  }
  
  private static final class c
    implements RemoteMediaPlayer.MediaChannelResult
  {
    private final Status Eb;
    private final JSONObject Ga;
    
    c(Status paramStatus, JSONObject paramJSONObject)
    {
      this.Eb = paramStatus;
      this.Ga = paramJSONObject;
    }
    
    public JSONObject getCustomData()
    {
      return this.Ga;
    }
    
    public Status getStatus()
    {
      return this.Eb;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.RemoteMediaPlayer
 * JD-Core Version:    0.7.0.1
 */