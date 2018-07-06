package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaStatus;
import com.google.android.gms.cast.TextTrackStyle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class it
  extends il
{
  private static final long HR = TimeUnit.HOURS.toMillis(24L);
  private static final long HS = TimeUnit.HOURS.toMillis(24L);
  private static final long HT = TimeUnit.HOURS.toMillis(24L);
  private static final long HU = TimeUnit.SECONDS.toMillis(1L);
  private static final String NAMESPACE = in.aG("com.google.cast.media");
  private long HV;
  private MediaStatus HW;
  private final iw HX = new iw(HS);
  private final iw HY;
  private final iw HZ;
  private final iw Ia;
  private final iw Ib;
  private final iw Ic;
  private final iw Id;
  private final iw Ie;
  private final iw If;
  private final iw Ig;
  private final List<iw> Ih = new ArrayList();
  private final Runnable Ii = new a(null);
  private boolean Ij;
  private final Handler mHandler = new Handler(Looper.getMainLooper());
  
  public it()
  {
    this(null);
  }
  
  public it(String paramString)
  {
    super(NAMESPACE, "MediaControlChannel", paramString);
    this.Ih.add(this.HX);
    this.HY = new iw(HR);
    this.Ih.add(this.HY);
    this.HZ = new iw(HR);
    this.Ih.add(this.HZ);
    this.Ia = new iw(HR);
    this.Ih.add(this.Ia);
    this.Ib = new iw(HT);
    this.Ih.add(this.Ib);
    this.Ic = new iw(HR);
    this.Ih.add(this.Ic);
    this.Id = new iw(HR);
    this.Ih.add(this.Id);
    this.Ie = new iw(HR);
    this.Ih.add(this.Ie);
    this.If = new iw(HR);
    this.Ih.add(this.If);
    this.Ig = new iw(HR);
    this.Ih.add(this.Ig);
    gp();
  }
  
  private void J(boolean paramBoolean)
  {
    if (this.Ij != paramBoolean)
    {
      this.Ij = paramBoolean;
      if (paramBoolean) {
        this.mHandler.postDelayed(this.Ii, HU);
      }
    }
    else
    {
      return;
    }
    this.mHandler.removeCallbacks(this.Ii);
  }
  
  private void a(long paramLong, JSONObject paramJSONObject)
    throws JSONException
  {
    int i = 1;
    boolean bool = this.HX.p(paramLong);
    int j;
    if ((this.Ib.gr()) && (!this.Ib.p(paramLong)))
    {
      j = i;
      if (((!this.Ic.gr()) || (this.Ic.p(paramLong))) && ((!this.Id.gr()) || (this.Id.p(paramLong)))) {
        break label227;
      }
      label80:
      if (j == 0) {
        break label249;
      }
    }
    label227:
    label249:
    for (int k = 2;; k = 0)
    {
      if (i != 0) {
        k |= 0x1;
      }
      if ((bool) || (this.HW == null))
      {
        this.HW = new MediaStatus(paramJSONObject);
        this.HV = SystemClock.elapsedRealtime();
      }
      for (int m = 7;; m = this.HW.a(paramJSONObject, k))
      {
        if ((m & 0x1) != 0)
        {
          this.HV = SystemClock.elapsedRealtime();
          onStatusUpdated();
        }
        if ((m & 0x2) != 0)
        {
          this.HV = SystemClock.elapsedRealtime();
          onStatusUpdated();
        }
        if ((m & 0x4) != 0) {
          onMetadataUpdated();
        }
        Iterator localIterator = this.Ih.iterator();
        while (localIterator.hasNext()) {
          ((iw)localIterator.next()).d(paramLong, 0);
        }
        j = 0;
        break;
        i = 0;
        break label80;
      }
      return;
    }
  }
  
  private void gp()
  {
    J(false);
    this.HV = 0L;
    this.HW = null;
    this.HX.clear();
    this.Ib.clear();
    this.Ic.clear();
  }
  
  public long a(iv paramiv)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = fU();
    this.Ie.a(l, paramiv);
    J(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "GET_STATUS");
      if (this.HW != null) {
        localJSONObject.put("mediaSessionId", this.HW.fR());
      }
      label65:
      a(localJSONObject.toString(), l, null);
      return l;
    }
    catch (JSONException localJSONException)
    {
      break label65;
    }
  }
  
  public long a(iv paramiv, double paramDouble, JSONObject paramJSONObject)
    throws IOException, IllegalStateException, IllegalArgumentException
  {
    if ((Double.isInfinite(paramDouble)) || (Double.isNaN(paramDouble))) {
      throw new IllegalArgumentException("Volume cannot be " + paramDouble);
    }
    JSONObject localJSONObject1 = new JSONObject();
    long l = fU();
    this.Ic.a(l, paramiv);
    J(true);
    try
    {
      localJSONObject1.put("requestId", l);
      localJSONObject1.put("type", "SET_VOLUME");
      localJSONObject1.put("mediaSessionId", fR());
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("level", paramDouble);
      localJSONObject1.put("volume", localJSONObject2);
      if (paramJSONObject != null) {
        localJSONObject1.put("customData", paramJSONObject);
      }
    }
    catch (JSONException localJSONException)
    {
      label151:
      break label151;
    }
    a(localJSONObject1.toString(), l, null);
    return l;
  }
  
  public long a(iv paramiv, long paramLong, int paramInt, JSONObject paramJSONObject)
    throws IOException, IllegalStateException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = fU();
    this.Ib.a(l, paramiv);
    J(true);
    for (;;)
    {
      try
      {
        localJSONObject.put("requestId", l);
        localJSONObject.put("type", "SEEK");
        localJSONObject.put("mediaSessionId", fR());
        localJSONObject.put("currentTime", in.o(paramLong));
        if (paramInt != 1) {
          continue;
        }
        localJSONObject.put("resumeState", "PLAYBACK_START");
        if (paramJSONObject != null) {
          localJSONObject.put("customData", paramJSONObject);
        }
      }
      catch (JSONException localJSONException)
      {
        continue;
      }
      a(localJSONObject.toString(), l, null);
      return l;
      if (paramInt == 2) {
        localJSONObject.put("resumeState", "PLAYBACK_PAUSE");
      }
    }
  }
  
  public long a(iv paramiv, MediaInfo paramMediaInfo, boolean paramBoolean, long paramLong, long[] paramArrayOfLong, JSONObject paramJSONObject)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = fU();
    this.HX.a(l, paramiv);
    J(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "LOAD");
      localJSONObject.put("media", paramMediaInfo.toJson());
      localJSONObject.put("autoplay", paramBoolean);
      localJSONObject.put("currentTime", in.o(paramLong));
      if ((paramArrayOfLong != null) && (paramArrayOfLong.length > 0))
      {
        JSONArray localJSONArray = new JSONArray();
        for (int i = 0; i < paramArrayOfLong.length; i++) {
          localJSONArray.put(i, paramArrayOfLong[i]);
        }
        localJSONObject.put("activeTrackIds", localJSONArray);
      }
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException localJSONException)
    {
      label165:
      break label165;
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long a(iv paramiv, TextTrackStyle paramTextTrackStyle)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = fU();
    this.Ig.a(l, paramiv);
    J(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "EDIT_TRACKS_INFO");
      if (paramTextTrackStyle != null) {
        localJSONObject.put("textTrackStyle", paramTextTrackStyle.toJson());
      }
      localJSONObject.put("mediaSessionId", fR());
    }
    catch (JSONException localJSONException)
    {
      label75:
      break label75;
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long a(iv paramiv, JSONObject paramJSONObject)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = fU();
    this.HY.a(l, paramiv);
    J(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "PAUSE");
      localJSONObject.put("mediaSessionId", fR());
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException localJSONException)
    {
      label72:
      break label72;
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long a(iv paramiv, boolean paramBoolean, JSONObject paramJSONObject)
    throws IOException, IllegalStateException
  {
    JSONObject localJSONObject1 = new JSONObject();
    long l = fU();
    this.Id.a(l, paramiv);
    J(true);
    try
    {
      localJSONObject1.put("requestId", l);
      localJSONObject1.put("type", "SET_VOLUME");
      localJSONObject1.put("mediaSessionId", fR());
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("muted", paramBoolean);
      localJSONObject1.put("volume", localJSONObject2);
      if (paramJSONObject != null) {
        localJSONObject1.put("customData", paramJSONObject);
      }
    }
    catch (JSONException localJSONException)
    {
      label107:
      break label107;
    }
    a(localJSONObject1.toString(), l, null);
    return l;
  }
  
  public long a(iv paramiv, long[] paramArrayOfLong)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = fU();
    this.If.a(l, paramiv);
    J(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "EDIT_TRACKS_INFO");
      localJSONObject.put("mediaSessionId", fR());
      JSONArray localJSONArray = new JSONArray();
      for (int i = 0; i < paramArrayOfLong.length; i++) {
        localJSONArray.put(i, paramArrayOfLong[i]);
      }
      localJSONObject.put("activeTrackIds", localJSONArray);
    }
    catch (JSONException localJSONException)
    {
      label106:
      break label106;
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public final void aD(String paramString)
  {
    this.He.b("message received: %s", new Object[] { paramString });
    JSONObject localJSONObject1;
    String str;
    long l;
    try
    {
      localJSONObject1 = new JSONObject(paramString);
      str = localJSONObject1.getString("type");
      l = localJSONObject1.optLong("requestId", -1L);
      if (str.equals("MEDIA_STATUS"))
      {
        JSONArray localJSONArray = localJSONObject1.getJSONArray("status");
        if (localJSONArray.length() > 0)
        {
          a(l, localJSONArray.getJSONObject(0));
          return;
        }
        this.HW = null;
        onStatusUpdated();
        onMetadataUpdated();
        this.Ie.d(l, 0);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      is localis = this.He;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = localJSONException.getMessage();
      arrayOfObject[1] = paramString;
      localis.d("Message is malformed (%s); ignoring: %s", arrayOfObject);
      return;
    }
    if (str.equals("INVALID_PLAYER_STATE"))
    {
      this.He.d("received unexpected error: Invalid Player State.", new Object[0]);
      JSONObject localJSONObject5 = localJSONObject1.optJSONObject("customData");
      Iterator localIterator2 = this.Ih.iterator();
      while (localIterator2.hasNext()) {
        ((iw)localIterator2.next()).b(l, 2100, localJSONObject5);
      }
    }
    if (str.equals("LOAD_FAILED"))
    {
      JSONObject localJSONObject4 = localJSONObject1.optJSONObject("customData");
      this.HX.b(l, 2100, localJSONObject4);
      return;
    }
    if (str.equals("LOAD_CANCELLED"))
    {
      JSONObject localJSONObject3 = localJSONObject1.optJSONObject("customData");
      this.HX.b(l, 2101, localJSONObject3);
      return;
    }
    if (str.equals("INVALID_REQUEST"))
    {
      this.He.d("received unexpected error: Invalid Request.", new Object[0]);
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject("customData");
      Iterator localIterator1 = this.Ih.iterator();
      while (localIterator1.hasNext()) {
        ((iw)localIterator1.next()).b(l, 2100, localJSONObject2);
      }
    }
  }
  
  public long b(iv paramiv, JSONObject paramJSONObject)
    throws IOException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = fU();
    this.Ia.a(l, paramiv);
    J(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "STOP");
      localJSONObject.put("mediaSessionId", fR());
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException localJSONException)
    {
      label72:
      break label72;
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public void b(long paramLong, int paramInt)
  {
    Iterator localIterator = this.Ih.iterator();
    while (localIterator.hasNext()) {
      ((iw)localIterator.next()).d(paramLong, paramInt);
    }
  }
  
  public long c(iv paramiv, JSONObject paramJSONObject)
    throws IOException, IllegalStateException
  {
    JSONObject localJSONObject = new JSONObject();
    long l = fU();
    this.HZ.a(l, paramiv);
    J(true);
    try
    {
      localJSONObject.put("requestId", l);
      localJSONObject.put("type", "PLAY");
      localJSONObject.put("mediaSessionId", fR());
      if (paramJSONObject != null) {
        localJSONObject.put("customData", paramJSONObject);
      }
    }
    catch (JSONException localJSONException)
    {
      label72:
      break label72;
    }
    a(localJSONObject.toString(), l, null);
    return l;
  }
  
  public long fR()
    throws IllegalStateException
  {
    if (this.HW == null) {
      throw new IllegalStateException("No current media session");
    }
    return this.HW.fR();
  }
  
  public void fV()
  {
    gp();
  }
  
  public long getApproximateStreamPosition()
  {
    MediaInfo localMediaInfo = getMediaInfo();
    if (localMediaInfo == null) {}
    while (this.HV == 0L) {
      return 0L;
    }
    double d = this.HW.getPlaybackRate();
    long l1 = this.HW.getStreamPosition();
    int i = this.HW.getPlayerState();
    if ((d == 0.0D) || (i != 2)) {
      return l1;
    }
    long l2 = SystemClock.elapsedRealtime() - this.HV;
    if (l2 < 0L) {}
    for (long l3 = 0L;; l3 = l2)
    {
      if (l3 == 0L) {
        return l1;
      }
      long l4 = localMediaInfo.getStreamDuration();
      long l5 = l1 + (d * l3);
      if ((l4 > 0L) && (l5 > l4)) {}
      for (;;)
      {
        return l4;
        if (l5 < 0L) {
          l4 = 0L;
        } else {
          l4 = l5;
        }
      }
    }
  }
  
  public MediaInfo getMediaInfo()
  {
    if (this.HW == null) {
      return null;
    }
    return this.HW.getMediaInfo();
  }
  
  public MediaStatus getMediaStatus()
  {
    return this.HW;
  }
  
  public long getStreamDuration()
  {
    MediaInfo localMediaInfo = getMediaInfo();
    if (localMediaInfo != null) {
      return localMediaInfo.getStreamDuration();
    }
    return 0L;
  }
  
  protected void onMetadataUpdated() {}
  
  protected void onStatusUpdated() {}
  
  private class a
    implements Runnable
  {
    private a() {}
    
    public void run()
    {
      boolean bool1 = false;
      it.a(it.this, false);
      long l = SystemClock.elapsedRealtime();
      Iterator localIterator1 = it.a(it.this).iterator();
      while (localIterator1.hasNext()) {
        ((iw)localIterator1.next()).e(l, 2102);
      }
      for (;;)
      {
        synchronized (iw.Ip)
        {
          Iterator localIterator2 = it.a(it.this).iterator();
          if (localIterator2.hasNext())
          {
            if (((iw)localIterator2.next()).gr())
            {
              bool2 = true;
              break label137;
            }
          }
          else
          {
            it.b(it.this, bool1);
            return;
          }
        }
        boolean bool2 = bool1;
        label137:
        bool1 = bool2;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.it
 * JD-Core Version:    0.7.0.1
 */