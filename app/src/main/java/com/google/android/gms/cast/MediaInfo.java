package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.li;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaInfo
{
  public static final int STREAM_TYPE_BUFFERED = 1;
  public static final int STREAM_TYPE_INVALID = -1;
  public static final int STREAM_TYPE_LIVE = 2;
  public static final int STREAM_TYPE_NONE = 0;
  public static final long UNKNOWN_DURATION = -1L;
  private final String FT;
  private int FU;
  private String FV;
  private MediaMetadata FW;
  private long FX;
  private List<MediaTrack> FY;
  private TextTrackStyle FZ;
  private JSONObject Ga;
  
  MediaInfo(String paramString)
    throws IllegalArgumentException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("content ID cannot be null or empty");
    }
    this.FT = paramString;
    this.FU = -1;
  }
  
  MediaInfo(JSONObject paramJSONObject)
    throws JSONException
  {
    this.FT = paramJSONObject.getString("contentId");
    String str = paramJSONObject.getString("streamType");
    if ("NONE".equals(str)) {
      this.FU = 0;
    }
    for (;;)
    {
      this.FV = paramJSONObject.getString("contentType");
      if (paramJSONObject.has("metadata"))
      {
        JSONObject localJSONObject2 = paramJSONObject.getJSONObject("metadata");
        this.FW = new MediaMetadata(localJSONObject2.getInt("metadataType"));
        this.FW.c(localJSONObject2);
      }
      this.FX = -1L;
      if ((paramJSONObject.has("duration")) && (!paramJSONObject.isNull("duration")))
      {
        double d = paramJSONObject.optDouble("duration", 0.0D);
        if ((!Double.isNaN(d)) && (!Double.isInfinite(d))) {
          this.FX = in.b(d);
        }
      }
      if (!paramJSONObject.has("tracks")) {
        break;
      }
      this.FY = new ArrayList();
      JSONArray localJSONArray = paramJSONObject.getJSONArray("tracks");
      while (i < localJSONArray.length())
      {
        MediaTrack localMediaTrack = new MediaTrack(localJSONArray.getJSONObject(i));
        this.FY.add(localMediaTrack);
        i++;
      }
      if ("BUFFERED".equals(str)) {
        this.FU = 1;
      } else if ("LIVE".equals(str)) {
        this.FU = 2;
      } else {
        this.FU = -1;
      }
    }
    this.FY = null;
    TextTrackStyle localTextTrackStyle;
    if (paramJSONObject.has("textTrackStyle"))
    {
      JSONObject localJSONObject1 = paramJSONObject.getJSONObject("textTrackStyle");
      localTextTrackStyle = new TextTrackStyle();
      localTextTrackStyle.c(localJSONObject1);
    }
    for (this.FZ = localTextTrackStyle;; this.FZ = null)
    {
      this.Ga = paramJSONObject.optJSONObject("customData");
      return;
    }
  }
  
  void a(MediaMetadata paramMediaMetadata)
  {
    this.FW = paramMediaMetadata;
  }
  
  void d(List<MediaTrack> paramList)
  {
    this.FY = paramList;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool3;
    if (this == paramObject) {
      bool3 = bool1;
    }
    MediaInfo localMediaInfo;
    boolean bool4;
    boolean bool5;
    label52:
    boolean bool6;
    do
    {
      do
      {
        boolean bool2;
        do
        {
          return bool3;
          bool2 = paramObject instanceof MediaInfo;
          bool3 = false;
        } while (!bool2);
        localMediaInfo = (MediaInfo)paramObject;
        if (this.Ga != null) {
          break;
        }
        bool4 = bool1;
        if (localMediaInfo.Ga != null) {
          break label177;
        }
        bool5 = bool1;
        bool3 = false;
      } while (bool4 != bool5);
      if ((this.Ga == null) || (localMediaInfo.Ga == null)) {
        break;
      }
      bool6 = li.d(this.Ga, localMediaInfo.Ga);
      bool3 = false;
    } while (!bool6);
    if ((in.a(this.FT, localMediaInfo.FT)) && (this.FU == localMediaInfo.FU) && (in.a(this.FV, localMediaInfo.FV)) && (in.a(this.FW, localMediaInfo.FW)) && (this.FX == localMediaInfo.FX)) {}
    for (;;)
    {
      return bool1;
      bool4 = false;
      break;
      label177:
      bool5 = false;
      break label52;
      bool1 = false;
    }
  }
  
  void fQ()
    throws IllegalArgumentException
  {
    if (TextUtils.isEmpty(this.FT)) {
      throw new IllegalArgumentException("content ID cannot be null or empty");
    }
    if (TextUtils.isEmpty(this.FV)) {
      throw new IllegalArgumentException("content type cannot be null or empty");
    }
    if (this.FU == -1) {
      throw new IllegalArgumentException("a valid stream type must be specified");
    }
  }
  
  public String getContentId()
  {
    return this.FT;
  }
  
  public String getContentType()
  {
    return this.FV;
  }
  
  public JSONObject getCustomData()
  {
    return this.Ga;
  }
  
  public List<MediaTrack> getMediaTracks()
  {
    return this.FY;
  }
  
  public MediaMetadata getMetadata()
  {
    return this.FW;
  }
  
  public long getStreamDuration()
  {
    return this.FX;
  }
  
  public int getStreamType()
  {
    return this.FU;
  }
  
  public TextTrackStyle getTextTrackStyle()
  {
    return this.FZ;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = this.FT;
    arrayOfObject[1] = Integer.valueOf(this.FU);
    arrayOfObject[2] = this.FV;
    arrayOfObject[3] = this.FW;
    arrayOfObject[4] = Long.valueOf(this.FX);
    arrayOfObject[5] = String.valueOf(this.Ga);
    return jv.hashCode(arrayOfObject);
  }
  
  void m(long paramLong)
    throws IllegalArgumentException
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("Stream duration cannot be negative");
    }
    this.FX = paramLong;
  }
  
  void setContentType(String paramString)
    throws IllegalArgumentException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("content type cannot be null or empty");
    }
    this.FV = paramString;
  }
  
  void setCustomData(JSONObject paramJSONObject)
  {
    this.Ga = paramJSONObject;
  }
  
  void setStreamType(int paramInt)
    throws IllegalArgumentException
  {
    if ((paramInt < -1) || (paramInt > 2)) {
      throw new IllegalArgumentException("invalid stream type");
    }
    this.FU = paramInt;
  }
  
  public void setTextTrackStyle(TextTrackStyle paramTextTrackStyle)
  {
    this.FZ = paramTextTrackStyle;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("contentId", this.FT);
        switch (this.FU)
        {
        default: 
          localJSONObject.put("streamType", localObject);
          if (this.FV != null) {
            localJSONObject.put("contentType", this.FV);
          }
          if (this.FW != null) {
            localJSONObject.put("metadata", this.FW.toJson());
          }
          localJSONObject.put("duration", in.o(this.FX));
          if (this.FY != null)
          {
            JSONArray localJSONArray = new JSONArray();
            Iterator localIterator = this.FY.iterator();
            if (localIterator.hasNext())
            {
              localJSONArray.put(((MediaTrack)localIterator.next()).toJson());
              continue;
            }
            localJSONObject.put("tracks", localJSONArray);
          }
          if (this.FZ != null) {
            localJSONObject.put("textTrackStyle", this.FZ.toJson());
          }
          if (this.Ga == null) {
            break label223;
          }
          localJSONObject.put("customData", this.Ga);
          return localJSONObject;
        }
      }
      catch (JSONException localJSONException) {}
      Object localObject = "NONE";
      continue;
      label223:
      return localJSONObject;
      localObject = "BUFFERED";
      continue;
      localObject = "LIVE";
    }
  }
  
  public static class Builder
  {
    private final MediaInfo Gb;
    
    public Builder(String paramString)
      throws IllegalArgumentException
    {
      if (TextUtils.isEmpty(paramString)) {
        throw new IllegalArgumentException("Content ID cannot be empty");
      }
      this.Gb = new MediaInfo(paramString);
    }
    
    public MediaInfo build()
      throws IllegalArgumentException
    {
      this.Gb.fQ();
      return this.Gb;
    }
    
    public Builder setContentType(String paramString)
      throws IllegalArgumentException
    {
      this.Gb.setContentType(paramString);
      return this;
    }
    
    public Builder setCustomData(JSONObject paramJSONObject)
    {
      this.Gb.setCustomData(paramJSONObject);
      return this;
    }
    
    public Builder setMediaTracks(List<MediaTrack> paramList)
    {
      this.Gb.d(paramList);
      return this;
    }
    
    public Builder setMetadata(MediaMetadata paramMediaMetadata)
    {
      this.Gb.a(paramMediaMetadata);
      return this;
    }
    
    public Builder setStreamDuration(long paramLong)
      throws IllegalArgumentException
    {
      this.Gb.m(paramLong);
      return this;
    }
    
    public Builder setStreamType(int paramInt)
      throws IllegalArgumentException
    {
      this.Gb.setStreamType(paramInt);
      return this;
    }
    
    public Builder setTextTrackStyle(TextTrackStyle paramTextTrackStyle)
    {
      this.Gb.setTextTrackStyle(paramTextTrackStyle);
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.MediaInfo
 * JD-Core Version:    0.7.0.1
 */