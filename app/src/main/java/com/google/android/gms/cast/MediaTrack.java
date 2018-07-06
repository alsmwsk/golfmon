package com.google.android.gms.cast;

import android.text.TextUtils;
import com.google.android.gms.internal.in;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.li;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class MediaTrack
{
  public static final int SUBTYPE_CAPTIONS = 2;
  public static final int SUBTYPE_CHAPTERS = 4;
  public static final int SUBTYPE_DESCRIPTIONS = 3;
  public static final int SUBTYPE_METADATA = 5;
  public static final int SUBTYPE_NONE = 0;
  public static final int SUBTYPE_SUBTITLES = 1;
  public static final int SUBTYPE_UNKNOWN = -1;
  public static final int TYPE_AUDIO = 2;
  public static final int TYPE_TEXT = 1;
  public static final int TYPE_UNKNOWN = 0;
  public static final int TYPE_VIDEO = 3;
  private long Eg;
  private String FR;
  private String FT;
  private String FV;
  private JSONObject Ga;
  private int Gt;
  private int Gu;
  private String mName;
  
  MediaTrack(long paramLong, int paramInt)
    throws IllegalArgumentException
  {
    clear();
    this.Eg = paramLong;
    if ((paramInt <= 0) || (paramInt > 3)) {
      throw new IllegalArgumentException("invalid type " + paramInt);
    }
    this.Gt = paramInt;
  }
  
  MediaTrack(JSONObject paramJSONObject)
    throws JSONException
  {
    c(paramJSONObject);
  }
  
  private void c(JSONObject paramJSONObject)
    throws JSONException
  {
    clear();
    this.Eg = paramJSONObject.getLong("trackId");
    String str1 = paramJSONObject.getString("type");
    String str2;
    if ("TEXT".equals(str1))
    {
      this.Gt = 1;
      this.FT = paramJSONObject.optString("trackContentId", null);
      this.FV = paramJSONObject.optString("trackContentType", null);
      this.mName = paramJSONObject.optString("name", null);
      this.FR = paramJSONObject.optString("language", null);
      if (!paramJSONObject.has("subtype")) {
        break label276;
      }
      str2 = paramJSONObject.getString("subtype");
      if (!"SUBTITLES".equals(str2)) {
        break label181;
      }
      this.Gu = 1;
    }
    label276:
    for (;;)
    {
      this.Ga = paramJSONObject.optJSONObject("customData");
      return;
      if ("AUDIO".equals(str1))
      {
        this.Gt = 2;
        break;
      }
      if ("VIDEO".equals(str1))
      {
        this.Gt = 3;
        break;
      }
      throw new JSONException("invalid type: " + str1);
      label181:
      if ("CAPTIONS".equals(str2))
      {
        this.Gu = 2;
      }
      else if ("DESCRIPTIONS".equals(str2))
      {
        this.Gu = 3;
      }
      else if ("CHAPTERS".equals(str2))
      {
        this.Gu = 4;
      }
      else if ("METADATA".equals(str2))
      {
        this.Gu = 5;
      }
      else
      {
        throw new JSONException("invalid subtype: " + str2);
        this.Gu = 0;
      }
    }
  }
  
  private void clear()
  {
    this.Eg = 0L;
    this.Gt = 0;
    this.FT = null;
    this.mName = null;
    this.FR = null;
    this.Gu = -1;
    this.Ga = null;
  }
  
  void ab(int paramInt)
    throws IllegalArgumentException
  {
    if ((paramInt <= -1) || (paramInt > 5)) {
      throw new IllegalArgumentException("invalid subtype " + paramInt);
    }
    if ((paramInt != 0) && (this.Gt != 1)) {
      throw new IllegalArgumentException("subtypes are only valid for text tracks");
    }
    this.Gu = paramInt;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool3;
    if (this == paramObject) {
      bool3 = bool1;
    }
    MediaTrack localMediaTrack;
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
          bool2 = paramObject instanceof MediaTrack;
          bool3 = false;
        } while (!bool2);
        localMediaTrack = (MediaTrack)paramObject;
        if (this.Ga != null) {
          break;
        }
        bool4 = bool1;
        if (localMediaTrack.Ga != null) {
          break label204;
        }
        bool5 = bool1;
        bool3 = false;
      } while (bool4 != bool5);
      if ((this.Ga == null) || (localMediaTrack.Ga == null)) {
        break;
      }
      bool6 = li.d(this.Ga, localMediaTrack.Ga);
      bool3 = false;
    } while (!bool6);
    if ((this.Eg == localMediaTrack.Eg) && (this.Gt == localMediaTrack.Gt) && (in.a(this.FT, localMediaTrack.FT)) && (in.a(this.FV, localMediaTrack.FV)) && (in.a(this.mName, localMediaTrack.mName)) && (in.a(this.FR, localMediaTrack.FR)) && (this.Gu == localMediaTrack.Gu)) {}
    for (;;)
    {
      return bool1;
      bool4 = false;
      break;
      label204:
      bool5 = false;
      break label52;
      bool1 = false;
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
  
  public long getId()
  {
    return this.Eg;
  }
  
  public String getLanguage()
  {
    return this.FR;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public int getSubtype()
  {
    return this.Gu;
  }
  
  public int getType()
  {
    return this.Gt;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[8];
    arrayOfObject[0] = Long.valueOf(this.Eg);
    arrayOfObject[1] = Integer.valueOf(this.Gt);
    arrayOfObject[2] = this.FT;
    arrayOfObject[3] = this.FV;
    arrayOfObject[4] = this.mName;
    arrayOfObject[5] = this.FR;
    arrayOfObject[6] = Integer.valueOf(this.Gu);
    arrayOfObject[7] = this.Ga;
    return jv.hashCode(arrayOfObject);
  }
  
  public void setContentId(String paramString)
  {
    this.FT = paramString;
  }
  
  public void setContentType(String paramString)
  {
    this.FV = paramString;
  }
  
  void setCustomData(JSONObject paramJSONObject)
  {
    this.Ga = paramJSONObject;
  }
  
  void setLanguage(String paramString)
  {
    this.FR = paramString;
  }
  
  void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("trackId", this.Eg);
      switch (this.Gt)
      {
      default: 
        if (this.FT != null) {
          localJSONObject.put("trackContentId", this.FT);
        }
        if (this.FV != null) {
          localJSONObject.put("trackContentType", this.FV);
        }
        if (this.mName != null) {
          localJSONObject.put("name", this.mName);
        }
        if (!TextUtils.isEmpty(this.FR)) {
          localJSONObject.put("language", this.FR);
        }
        switch (this.Gu)
        {
        }
        break;
      }
      for (;;)
      {
        if (this.Ga == null) {
          break label276;
        }
        localJSONObject.put("customData", this.Ga);
        return localJSONObject;
        localJSONObject.put("type", "TEXT");
        break;
        localJSONObject.put("type", "AUDIO");
        break;
        localJSONObject.put("type", "VIDEO");
        break;
        localJSONObject.put("subtype", "SUBTITLES");
        continue;
        localJSONObject.put("subtype", "CAPTIONS");
        continue;
        localJSONObject.put("subtype", "DESCRIPTIONS");
        continue;
        localJSONObject.put("subtype", "CHAPTERS");
        continue;
        localJSONObject.put("subtype", "METADATA");
      }
      label276:
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public static class Builder
  {
    private final MediaTrack Gv;
    
    public Builder(long paramLong, int paramInt)
      throws IllegalArgumentException
    {
      this.Gv = new MediaTrack(paramLong, paramInt);
    }
    
    public MediaTrack build()
    {
      return this.Gv;
    }
    
    public Builder setContentId(String paramString)
    {
      this.Gv.setContentId(paramString);
      return this;
    }
    
    public Builder setContentType(String paramString)
    {
      this.Gv.setContentType(paramString);
      return this;
    }
    
    public Builder setCustomData(JSONObject paramJSONObject)
    {
      this.Gv.setCustomData(paramJSONObject);
      return this;
    }
    
    public Builder setLanguage(String paramString)
    {
      this.Gv.setLanguage(paramString);
      return this;
    }
    
    public Builder setLanguage(Locale paramLocale)
    {
      this.Gv.setLanguage(in.b(paramLocale));
      return this;
    }
    
    public Builder setName(String paramString)
    {
      this.Gv.setName(paramString);
      return this;
    }
    
    public Builder setSubtype(int paramInt)
      throws IllegalArgumentException
    {
      this.Gv.ab(paramInt);
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.MediaTrack
 * JD-Core Version:    0.7.0.1
 */