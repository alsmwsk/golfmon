package com.google.android.gms.cast;

import com.google.android.gms.internal.in;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaStatus
{
  public static final long COMMAND_PAUSE = 1L;
  public static final long COMMAND_SEEK = 2L;
  public static final long COMMAND_SET_VOLUME = 4L;
  public static final long COMMAND_SKIP_BACKWARD = 32L;
  public static final long COMMAND_SKIP_FORWARD = 16L;
  public static final long COMMAND_TOGGLE_MUTE = 8L;
  private static final long[] Gs = new long[0];
  public static final int IDLE_REASON_CANCELED = 2;
  public static final int IDLE_REASON_ERROR = 4;
  public static final int IDLE_REASON_FINISHED = 1;
  public static final int IDLE_REASON_INTERRUPTED = 3;
  public static final int IDLE_REASON_NONE = 0;
  public static final int PLAYER_STATE_BUFFERING = 4;
  public static final int PLAYER_STATE_IDLE = 1;
  public static final int PLAYER_STATE_PAUSED = 3;
  public static final int PLAYER_STATE_PLAYING = 2;
  public static final int PLAYER_STATE_UNKNOWN;
  private JSONObject Ga;
  private MediaInfo Gb;
  private long Gj;
  private double Gk;
  private int Gl;
  private int Gm;
  private long Gn;
  private long Go;
  private double Gp;
  private boolean Gq;
  private long[] Gr;
  
  public MediaStatus(JSONObject paramJSONObject)
    throws JSONException
  {
    a(paramJSONObject, 0);
  }
  
  public int a(JSONObject paramJSONObject, int paramInt)
    throws JSONException
  {
    int i = 2;
    int j = 1;
    long l1 = paramJSONObject.getLong("mediaSessionId");
    if (l1 != this.Gj) {
      this.Gj = l1;
    }
    for (int k = j;; k = 0)
    {
      String str1;
      int i3;
      if (paramJSONObject.has("playerState"))
      {
        str1 = paramJSONObject.getString("playerState");
        if (!str1.equals("IDLE")) {
          break label406;
        }
        i3 = j;
      }
      for (;;)
      {
        if (i3 != this.Gl)
        {
          this.Gl = i3;
          k |= 0x2;
        }
        String str2;
        if ((i3 == j) && (paramJSONObject.has("idleReason")))
        {
          str2 = paramJSONObject.getString("idleReason");
          if (!str2.equals("CANCELLED")) {
            break label454;
          }
        }
        for (;;)
        {
          label119:
          if (i != this.Gm)
          {
            this.Gm = i;
            k |= 0x2;
          }
          if (paramJSONObject.has("playbackRate"))
          {
            double d2 = paramJSONObject.getDouble("playbackRate");
            if (this.Gk != d2)
            {
              this.Gk = d2;
              k |= 0x2;
            }
          }
          if ((paramJSONObject.has("currentTime")) && ((paramInt & 0x2) == 0))
          {
            long l3 = in.b(paramJSONObject.getDouble("currentTime"));
            if (l3 != this.Gn)
            {
              this.Gn = l3;
              k |= 0x2;
            }
          }
          if (paramJSONObject.has("supportedMediaCommands"))
          {
            long l2 = paramJSONObject.getLong("supportedMediaCommands");
            if (l2 != this.Go)
            {
              this.Go = l2;
              k |= 0x2;
            }
          }
          if ((paramJSONObject.has("volume")) && ((paramInt & 0x1) == 0))
          {
            JSONObject localJSONObject2 = paramJSONObject.getJSONObject("volume");
            double d1 = localJSONObject2.getDouble("level");
            if (d1 != this.Gp)
            {
              this.Gp = d1;
              k |= 0x2;
            }
            boolean bool = localJSONObject2.getBoolean("muted");
            if (bool != this.Gq)
            {
              this.Gq = bool;
              k |= 0x2;
            }
          }
          int n;
          long[] arrayOfLong2;
          if (paramJSONObject.has("activeTrackIds"))
          {
            JSONArray localJSONArray = paramJSONObject.getJSONArray("activeTrackIds");
            n = localJSONArray.length();
            arrayOfLong2 = new long[n];
            int i1 = 0;
            for (;;)
            {
              if (i1 < n)
              {
                arrayOfLong2[i1] = localJSONArray.getLong(i1);
                i1++;
                continue;
                label406:
                if (str1.equals("PLAYING"))
                {
                  i3 = i;
                  break;
                }
                if (str1.equals("PAUSED"))
                {
                  i3 = 3;
                  break;
                }
                if (!str1.equals("BUFFERING")) {
                  break label702;
                }
                i3 = 4;
                break;
                label454:
                if (str2.equals("INTERRUPTED"))
                {
                  i = 3;
                  break label119;
                }
                if (str2.equals("FINISHED"))
                {
                  i = j;
                  break label119;
                }
                if (!str2.equals("ERROR")) {
                  break label697;
                }
                i = 4;
                break label119;
              }
            }
            if (this.Gr != null) {}
          }
          for (;;)
          {
            if (j != 0) {
              this.Gr = arrayOfLong2;
            }
            int m = j;
            long[] arrayOfLong1 = arrayOfLong2;
            for (;;)
            {
              if (m != 0)
              {
                this.Gr = arrayOfLong1;
                k |= 0x2;
              }
              if (paramJSONObject.has("customData"))
              {
                this.Ga = paramJSONObject.getJSONObject("customData");
                k |= 0x2;
              }
              if (paramJSONObject.has("media"))
              {
                JSONObject localJSONObject1 = paramJSONObject.getJSONObject("media");
                this.Gb = new MediaInfo(localJSONObject1);
                k |= 0x2;
                if (localJSONObject1.has("metadata")) {
                  k |= 0x4;
                }
              }
              return k;
              if (this.Gr.length != n) {
                break;
              }
              for (int i2 = 0;; i2++)
              {
                if (i2 >= n) {
                  break label691;
                }
                if (this.Gr[i2] != arrayOfLong2[i2]) {
                  break;
                }
              }
              if (this.Gr != null)
              {
                m = j;
                arrayOfLong1 = null;
              }
              else
              {
                arrayOfLong1 = null;
                m = 0;
              }
            }
            label691:
            j = 0;
          }
          label697:
          i = 0;
        }
        label702:
        i3 = 0;
      }
    }
  }
  
  public long fR()
  {
    return this.Gj;
  }
  
  public long[] getActiveTrackIds()
  {
    if (this.Gr != null) {
      return this.Gr;
    }
    return Gs;
  }
  
  public JSONObject getCustomData()
  {
    return this.Ga;
  }
  
  public int getIdleReason()
  {
    return this.Gm;
  }
  
  public MediaInfo getMediaInfo()
  {
    return this.Gb;
  }
  
  public double getPlaybackRate()
  {
    return this.Gk;
  }
  
  public int getPlayerState()
  {
    return this.Gl;
  }
  
  public long getStreamPosition()
  {
    return this.Gn;
  }
  
  public double getStreamVolume()
  {
    return this.Gp;
  }
  
  public boolean isMediaCommandSupported(long paramLong)
  {
    return (paramLong & this.Go) != 0L;
  }
  
  public boolean isMute()
  {
    return this.Gq;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.MediaStatus
 * JD-Core Version:    0.7.0.1
 */