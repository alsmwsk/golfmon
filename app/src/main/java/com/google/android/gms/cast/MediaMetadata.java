package com.google.android.gms.cast;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.internal.ix;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MediaMetadata
{
  private static final String[] Gc = { null, "String", "int", "double", "ISO-8601 date String" };
  private static final a Gd = new a().a("com.google.android.gms.cast.metadata.CREATION_DATE", "creationDateTime", 4).a("com.google.android.gms.cast.metadata.RELEASE_DATE", "releaseDate", 4).a("com.google.android.gms.cast.metadata.BROADCAST_DATE", "originalAirdate", 4).a("com.google.android.gms.cast.metadata.TITLE", "title", 1).a("com.google.android.gms.cast.metadata.SUBTITLE", "subtitle", 1).a("com.google.android.gms.cast.metadata.ARTIST", "artist", 1).a("com.google.android.gms.cast.metadata.ALBUM_ARTIST", "albumArtist", 1).a("com.google.android.gms.cast.metadata.ALBUM_TITLE", "albumName", 1).a("com.google.android.gms.cast.metadata.COMPOSER", "composer", 1).a("com.google.android.gms.cast.metadata.DISC_NUMBER", "discNumber", 2).a("com.google.android.gms.cast.metadata.TRACK_NUMBER", "trackNumber", 2).a("com.google.android.gms.cast.metadata.SEASON_NUMBER", "season", 2).a("com.google.android.gms.cast.metadata.EPISODE_NUMBER", "episode", 2).a("com.google.android.gms.cast.metadata.SERIES_TITLE", "seriesTitle", 1).a("com.google.android.gms.cast.metadata.STUDIO", "studio", 1).a("com.google.android.gms.cast.metadata.WIDTH", "width", 2).a("com.google.android.gms.cast.metadata.HEIGHT", "height", 2).a("com.google.android.gms.cast.metadata.LOCATION_NAME", "location", 1).a("com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "latitude", 3).a("com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "longitude", 3);
  public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
  public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
  public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";
  public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
  public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";
  public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";
  public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";
  public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
  public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";
  public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
  public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
  public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";
  public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";
  public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
  public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";
  public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";
  public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";
  public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";
  public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
  public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
  public static final int MEDIA_TYPE_GENERIC = 0;
  public static final int MEDIA_TYPE_MOVIE = 1;
  public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
  public static final int MEDIA_TYPE_PHOTO = 4;
  public static final int MEDIA_TYPE_TV_SHOW = 2;
  public static final int MEDIA_TYPE_USER = 100;
  private final List<WebImage> Fp = new ArrayList();
  private final Bundle Ge = new Bundle();
  private int Gf;
  
  public MediaMetadata()
  {
    this(0);
  }
  
  public MediaMetadata(int paramInt)
  {
    this.Gf = paramInt;
  }
  
  private void a(JSONObject paramJSONObject, String... paramVarArgs)
  {
    try
    {
      int i = paramVarArgs.length;
      int j = 0;
      String str1;
      if (j < i)
      {
        str1 = paramVarArgs[j];
        if (!this.Ge.containsKey(str1)) {}
      }
      else
      {
        switch (Gd.aB(str1))
        {
        case 1: 
        case 4: 
          paramJSONObject.put(Gd.az(str1), this.Ge.getString(str1));
          break;
        case 2: 
          paramJSONObject.put(Gd.az(str1), this.Ge.getInt(str1));
          break;
        case 3: 
          paramJSONObject.put(Gd.az(str1), this.Ge.getDouble(str1));
          break;
          Iterator localIterator = this.Ge.keySet().iterator();
          while (localIterator.hasNext())
          {
            String str2 = (String)localIterator.next();
            if (!str2.startsWith("com.google."))
            {
              Object localObject = this.Ge.get(str2);
              if ((localObject instanceof String)) {
                paramJSONObject.put(str2, localObject);
              } else if ((localObject instanceof Integer)) {
                paramJSONObject.put(str2, localObject);
              } else if ((localObject instanceof Double)) {
                paramJSONObject.put(str2, localObject);
              }
            }
          }
        }
      }
      for (;;)
      {
        j++;
        break;
      }
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  private boolean a(Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle1.size() != paramBundle2.size()) {
      return false;
    }
    Iterator localIterator = paramBundle1.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject1 = paramBundle1.get(str);
      Object localObject2 = paramBundle2.get(str);
      if (((localObject1 instanceof Bundle)) && ((localObject2 instanceof Bundle)) && (!a((Bundle)localObject1, (Bundle)localObject2))) {
        return false;
      }
      if (localObject1 == null)
      {
        if ((localObject2 != null) || (!paramBundle2.containsKey(str))) {
          return false;
        }
      }
      else if (!localObject1.equals(localObject2)) {
        return false;
      }
    }
    return true;
  }
  
  private void b(JSONObject paramJSONObject, String... paramVarArgs)
  {
    HashSet localHashSet = new HashSet(Arrays.asList(paramVarArgs));
    try
    {
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        if (!"metadataType".equals(str1))
        {
          String str2 = Gd.aA(str1);
          if (str2 != null)
          {
            boolean bool = localHashSet.contains(str2);
            if (!bool) {}
          }
          else
          {
            try
            {
              Object localObject1 = paramJSONObject.get(str1);
              if (localObject1 != null) {
                switch (Gd.aB(str2))
                {
                case 1: 
                  if ((localObject1 instanceof String)) {
                    this.Ge.putString(str2, (String)localObject1);
                  }
                  break;
                case 4: 
                  if (((localObject1 instanceof String)) && (ix.aL((String)localObject1) != null)) {
                    this.Ge.putString(str2, (String)localObject1);
                  }
                  break;
                case 2: 
                  if ((localObject1 instanceof Integer)) {
                    this.Ge.putInt(str2, ((Integer)localObject1).intValue());
                  }
                  break;
                case 3: 
                  if ((localObject1 instanceof Double))
                  {
                    this.Ge.putDouble(str2, ((Double)localObject1).doubleValue());
                    continue;
                    Object localObject2 = paramJSONObject.get(str1);
                    if ((localObject2 instanceof String)) {
                      this.Ge.putString(str1, (String)localObject2);
                    } else if ((localObject2 instanceof Integer)) {
                      this.Ge.putInt(str1, ((Integer)localObject2).intValue());
                    } else if ((localObject2 instanceof Double)) {
                      this.Ge.putDouble(str1, ((Double)localObject2).doubleValue());
                    }
                  }
                  break;
                }
              }
            }
            catch (JSONException localJSONException2) {}
          }
        }
      }
      return;
    }
    catch (JSONException localJSONException1) {}
  }
  
  private void f(String paramString, int paramInt)
    throws IllegalArgumentException
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalArgumentException("null and empty keys are not allowed");
    }
    int i = Gd.aB(paramString);
    if ((i != paramInt) && (i != 0)) {
      throw new IllegalArgumentException("Value for " + paramString + " must be a " + Gc[paramInt]);
    }
  }
  
  public void addImage(WebImage paramWebImage)
  {
    this.Fp.add(paramWebImage);
  }
  
  public void c(JSONObject paramJSONObject)
  {
    clear();
    this.Gf = 0;
    try
    {
      this.Gf = paramJSONObject.getInt("metadataType");
      label20:
      ix.a(this.Fp, paramJSONObject);
      switch (this.Gf)
      {
      default: 
        b(paramJSONObject, new String[0]);
        return;
      case 0: 
        b(paramJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE" });
        return;
      case 1: 
        b(paramJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE" });
        return;
      case 2: 
        b(paramJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE" });
        return;
      case 3: 
        b(paramJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE" });
        return;
      }
      b(paramJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE" });
      return;
    }
    catch (JSONException localJSONException)
    {
      break label20;
    }
  }
  
  public void clear()
  {
    this.Ge.clear();
    this.Fp.clear();
  }
  
  public void clearImages()
  {
    this.Fp.clear();
  }
  
  public boolean containsKey(String paramString)
  {
    return this.Ge.containsKey(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    MediaMetadata localMediaMetadata;
    do
    {
      return true;
      if (!(paramObject instanceof MediaMetadata)) {
        return false;
      }
      localMediaMetadata = (MediaMetadata)paramObject;
    } while ((a(this.Ge, localMediaMetadata.Ge)) && (this.Fp.equals(localMediaMetadata.Fp)));
    return false;
  }
  
  public Calendar getDate(String paramString)
  {
    f(paramString, 4);
    String str = this.Ge.getString(paramString);
    if (str != null) {
      return ix.aL(str);
    }
    return null;
  }
  
  public String getDateAsString(String paramString)
  {
    f(paramString, 4);
    return this.Ge.getString(paramString);
  }
  
  public double getDouble(String paramString)
  {
    f(paramString, 3);
    return this.Ge.getDouble(paramString);
  }
  
  public List<WebImage> getImages()
  {
    return this.Fp;
  }
  
  public int getInt(String paramString)
  {
    f(paramString, 2);
    return this.Ge.getInt(paramString);
  }
  
  public int getMediaType()
  {
    return this.Gf;
  }
  
  public String getString(String paramString)
  {
    f(paramString, 1);
    return this.Ge.getString(paramString);
  }
  
  public boolean hasImages()
  {
    return (this.Fp != null) && (!this.Fp.isEmpty());
  }
  
  public int hashCode()
  {
    Iterator localIterator = this.Ge.keySet().iterator();
    String str;
    for (int i = 17; localIterator.hasNext(); i = i * 31 + this.Ge.get(str).hashCode()) {
      str = (String)localIterator.next();
    }
    return i * 31 + this.Fp.hashCode();
  }
  
  public Set<String> keySet()
  {
    return this.Ge.keySet();
  }
  
  public void putDate(String paramString, Calendar paramCalendar)
  {
    f(paramString, 4);
    this.Ge.putString(paramString, ix.a(paramCalendar));
  }
  
  public void putDouble(String paramString, double paramDouble)
  {
    f(paramString, 3);
    this.Ge.putDouble(paramString, paramDouble);
  }
  
  public void putInt(String paramString, int paramInt)
  {
    f(paramString, 2);
    this.Ge.putInt(paramString, paramInt);
  }
  
  public void putString(String paramString1, String paramString2)
  {
    f(paramString1, 1);
    this.Ge.putString(paramString1, paramString2);
  }
  
  public JSONObject toJson()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("metadataType", this.Gf);
      label20:
      ix.a(localJSONObject, this.Fp);
      switch (this.Gf)
      {
      default: 
        a(localJSONObject, new String[0]);
        return localJSONObject;
      case 0: 
        a(localJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE" });
        return localJSONObject;
      case 1: 
        a(localJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.STUDIO", "com.google.android.gms.cast.metadata.SUBTITLE", "com.google.android.gms.cast.metadata.RELEASE_DATE" });
        return localJSONObject;
      case 2: 
        a(localJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.SERIES_TITLE", "com.google.android.gms.cast.metadata.SEASON_NUMBER", "com.google.android.gms.cast.metadata.EPISODE_NUMBER", "com.google.android.gms.cast.metadata.BROADCAST_DATE" });
        return localJSONObject;
      case 3: 
        a(localJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.ALBUM_TITLE", "com.google.android.gms.cast.metadata.ALBUM_ARTIST", "com.google.android.gms.cast.metadata.COMPOSER", "com.google.android.gms.cast.metadata.TRACK_NUMBER", "com.google.android.gms.cast.metadata.DISC_NUMBER", "com.google.android.gms.cast.metadata.RELEASE_DATE" });
        return localJSONObject;
      }
      a(localJSONObject, new String[] { "com.google.android.gms.cast.metadata.TITLE", "com.google.android.gms.cast.metadata.ARTIST", "com.google.android.gms.cast.metadata.LOCATION_NAME", "com.google.android.gms.cast.metadata.LOCATION_LATITUDE", "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE", "com.google.android.gms.cast.metadata.WIDTH", "com.google.android.gms.cast.metadata.HEIGHT", "com.google.android.gms.cast.metadata.CREATION_DATE" });
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      break label20;
    }
  }
  
  private static class a
  {
    private final Map<String, String> Gg = new HashMap();
    private final Map<String, String> Gh = new HashMap();
    private final Map<String, Integer> Gi = new HashMap();
    
    public a a(String paramString1, String paramString2, int paramInt)
    {
      this.Gg.put(paramString1, paramString2);
      this.Gh.put(paramString2, paramString1);
      this.Gi.put(paramString1, Integer.valueOf(paramInt));
      return this;
    }
    
    public String aA(String paramString)
    {
      return (String)this.Gh.get(paramString);
    }
    
    public int aB(String paramString)
    {
      Integer localInteger = (Integer)this.Gi.get(paramString);
      if (localInteger != null) {
        return localInteger.intValue();
      }
      return 0;
    }
    
    public String az(String paramString)
    {
      return (String)this.Gg.get(paramString);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.cast.MediaMetadata
 * JD-Core Version:    0.7.0.1
 */