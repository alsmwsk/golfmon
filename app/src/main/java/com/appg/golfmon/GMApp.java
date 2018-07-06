package com.appg.golfmon;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.util.LogUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import org.json.JSONArray;

public class GMApp
  extends Application
  implements LocationListener
{
  public static final int COMPLETE = 100;
  public static final String DEF_ADDRESS = "서울시 중구 소공동";
  public static final int DEF_LATITUDE = 37565909;
  public static final int DEF_LONGTITUDE = 126978500;
  public static final int FAIL = 999;
  public static final int LOCATIONTYPE_GPS = 1;
  public static final int LOCATIONTYPE_MAP = 2;
  private static final int TIMEOUT = 5000;
  private static final long TWO_MINUTES = 120000L;
  private final String SP_FILE_NAME_LOCATION = "SP_FILE_NAME_LOCATION";
  private final String SP_KEY_ACCURCY = "SP_KEY_ACCURCY";
  private final String SP_KEY_ADDR_DONG = "SP_KEY_ADDR_DONG";
  private final String SP_KEY_ADDR_GUGOON = "SP_KEY_ADDR_GUGOON";
  private final String SP_KEY_ADDR_SIDO = "SP_KEY_ADDR_SIDO";
  private final String SP_KEY_LATITUDE = "SP_KEY_LATITUDE";
  private final String SP_KEY_LOCATION_TYPE = "SP_KEY_LOCATION_TYPE";
  private final String SP_KEY_LONGITUDE = "SP_KEY_LONGITUDE";
  private final String SP_KEY_PROVIDER = "SP_KEY_PROVIDER";
  private final String SP_KEY_TIME = "SP_KEY_TIME";
  private final String TAG = "GLocation";
  private SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
  private Handler mHandler = new Handler()
  {
    public void handleMessage(Message paramAnonymousMessage)
    {
      LogUtil.e("GLocation", "aaaaaaaaaaa  로케이션 " + paramAnonymousMessage.what);
      if (GMApp.this.mLocationCallBack != null) {
        GMApp.this.mLocationCallBack.onResult(paramAnonymousMessage.what);
      }
    }
  };
  private LocationCallBack mLocationCallBack = null;
  private LocationManager mManager = null;
  private SharedPreferences mPreferences = null;
  
  private boolean isSameProvider(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      return paramString2 == null;
    }
    return paramString1.equals(paramString2);
  }
  
  public void clear()
  {
    if (this.mManager != null) {
      this.mManager.removeUpdates(this);
    }
    if (this.mHandler != null) {
      this.mHandler.removeMessages(999);
    }
  }
  
  public String[] getAddress(int paramInt)
  {
    String[] arrayOfString = new String[3];
    arrayOfString[0] = this.mPreferences.getString("SP_KEY_ADDR_SIDO_" + paramInt, "");
    arrayOfString[1] = this.mPreferences.getString("SP_KEY_ADDR_GUGOON_" + paramInt, "");
    arrayOfString[2] = this.mPreferences.getString("SP_KEY_ADDR_DONG_" + paramInt, "");
    return arrayOfString;
  }
  
  public int[] getGeoPoint(int paramInt)
  {
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = this.mPreferences.getInt("SP_KEY_LATITUDE_" + paramInt, -1);
    arrayOfInt[1] = this.mPreferences.getInt("SP_KEY_LONGITUDE_" + paramInt, -1);
    return arrayOfInt;
  }
  
  public void getLocation(LocationCallBack paramLocationCallBack)
  {
    if (paramLocationCallBack == null)
    {
      this.mLocationCallBack = null;
      this.mHandler.removeMessages(999);
    }
    do
    {
      return;
      if (!isAvailableLocation()) {
        break;
      }
      this.mLocationCallBack = null;
      this.mHandler.removeMessages(999);
    } while (paramLocationCallBack == null);
    paramLocationCallBack.onResult(100);
    return;
    this.mLocationCallBack = paramLocationCallBack;
    this.mHandler.sendEmptyMessageDelayed(999, 5000L);
  }
  
  public int getLocationType()
  {
    return this.mPreferences.getInt("SP_KEY_LOCATION_TYPE", 0);
  }
  
  public boolean isAvailableLocation()
  {
    if (this.mPreferences.getString("SP_KEY_PROVIDER", null) == null) {}
    while (System.currentTimeMillis() - this.mPreferences.getLong("SP_KEY_TIME", 0L) >= 120000L) {
      return false;
    }
    return true;
  }
  
  protected boolean isBetterLocation(Location paramLocation)
  {
    if (paramLocation == null) {
      return false;
    }
    if (this.mPreferences.getString("SP_KEY_PROVIDER", null) == null) {
      return true;
    }
    long l = paramLocation.getTime() - this.mPreferences.getLong("SP_KEY_TIME", 0L);
    int i;
    int j;
    if (l > 120000L)
    {
      i = 1;
      if (l >= -120000L) {
        break label85;
      }
      j = 1;
      label63:
      if (l <= 0L) {
        break label91;
      }
    }
    label85:
    label91:
    for (int k = 1;; k = 0)
    {
      if (i == 0) {
        break label97;
      }
      return true;
      i = 0;
      break;
      j = 0;
      break label63;
    }
    label97:
    if (j != 0) {
      return false;
    }
    int m = (int)(paramLocation.getAccuracy() - this.mPreferences.getFloat("SP_KEY_ACCURCY", 0.0F));
    int n;
    int i1;
    if (m > 0)
    {
      n = 1;
      if (m >= 0) {
        break label186;
      }
      i1 = 1;
      label140:
      if (m <= 200) {
        break label192;
      }
    }
    boolean bool;
    label186:
    label192:
    for (int i2 = 1;; i2 = 0)
    {
      bool = isSameProvider(paramLocation.getProvider(), this.mPreferences.getString("SP_KEY_PROVIDER", null));
      if (i1 == 0) {
        break label198;
      }
      return true;
      n = 0;
      break;
      i1 = 0;
      break label140;
    }
    label198:
    if ((k != 0) && (n == 0)) {
      return true;
    }
    return (k != 0) && (i2 == 0) && (bool);
  }
  
  public boolean isProviderOn()
  {
    return (this.mManager.isProviderEnabled("network")) || (this.mManager.isProviderEnabled("gps"));
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.mPreferences = getSharedPreferences("SP_FILE_NAME_LOCATION", 0);
    this.mManager = ((LocationManager)getSystemService("location"));
  }
  
  public void onLocationChanged(Location paramLocation)
  {
    LogUtil.d("GLocation", "OLC : " + paramLocation.toString());
    LogUtil.d("GLocation", "OLC --------------------------------------------------------------------------------------------------------------------");
    String str1 = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf("")).append("\n OLC provider : ").append(paramLocation.getProvider()).toString())).append("\n OLC accuracy : ").append(paramLocation.getAccuracy()).toString() + "\n OLC time : " + this.mDateFormat.format(new Date(paramLocation.getTime()));
    Iterator localIterator = paramLocation.getExtras().keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        boolean bool = isBetterLocation(paramLocation);
        String str3 = str1 + "\n OLC save " + bool;
        if (bool) {
          saveLocation(paramLocation);
        }
        LogUtil.d("GLocation", str3);
        LogUtil.d("GLocation", "OLC --------------------------------------------------------------------------------------------------------------------");
        this.mHandler.removeMessages(999);
        this.mHandler.sendEmptyMessage(100);
        return;
      }
      String str2 = (String)localIterator.next();
      Object localObject = paramLocation.getExtras().get(str2);
      if ((localObject instanceof String)) {
        str1 = str1 + "\n OLC getExtras " + str2 + " : " + paramLocation.getExtras().getString(str2);
      } else if ((localObject instanceof Integer)) {
        str1 = str1 + "\n OLC getExtras " + str2 + " : " + paramLocation.getExtras().getInt(str2);
      } else if ((localObject instanceof Float)) {
        str1 = str1 + "\n OLC getExtras " + str2 + " : " + paramLocation.getExtras().getFloat(str2);
      } else if ((localObject instanceof Double)) {
        str1 = str1 + "\n OLC getExtras " + str2 + " : " + paramLocation.getExtras().getDouble(str2);
      }
    }
  }
  
  public void onLowMemory()
  {
    clear();
    super.onLowMemory();
  }
  
  public void onProviderDisabled(String paramString)
  {
    LogUtil.d("GLocation", "onProviderDisabled : " + paramString);
  }
  
  public void onProviderEnabled(String paramString)
  {
    LogUtil.d("GLocation", "onProviderEnabled : " + paramString);
  }
  
  public void onStatusChanged(String paramString, int paramInt, Bundle paramBundle)
  {
    LogUtil.d("GLocation", "onStatusChanged provider : " + paramString);
  }
  
  public void saveAddress(JSONArray paramJSONArray, int paramInt)
  {
    if (paramJSONArray == null) {
      return;
    }
    LogUtil.e("GLocation", "saveAddress : " + paramJSONArray.toString());
    SharedPreferences.Editor localEditor = this.mPreferences.edit();
    localEditor.putString("SP_KEY_ADDR_SIDO_" + paramInt, JSONUtil.getString(paramJSONArray, 0));
    localEditor.putString("SP_KEY_ADDR_GUGOON_" + paramInt, JSONUtil.getString(paramJSONArray, 1));
    localEditor.putString("SP_KEY_ADDR_DONG_" + paramInt, JSONUtil.getString(paramJSONArray, 2));
    localEditor.commit();
  }
  
  public void saveLocation(int paramInt1, int paramInt2, int paramInt3)
  {
    LogUtil.e("GLocation", "saveLocation : " + paramInt3);
    SharedPreferences.Editor localEditor = this.mPreferences.edit();
    localEditor.putInt("SP_KEY_LATITUDE_" + paramInt3, paramInt1);
    localEditor.putInt("SP_KEY_LONGITUDE_" + paramInt3, paramInt2);
    localEditor.commit();
  }
  
  public void saveLocation(Location paramLocation)
  {
    saveLocation(paramLocation, 1);
  }
  
  public void saveLocation(Location paramLocation, int paramInt)
  {
    LogUtil.e("GLocation", "saveLocation : " + paramInt);
    SharedPreferences.Editor localEditor = this.mPreferences.edit();
    localEditor.putInt("SP_KEY_LATITUDE_" + paramInt, (int)(1000000.0D * paramLocation.getLatitude()));
    localEditor.putInt("SP_KEY_LONGITUDE_" + paramInt, (int)(1000000.0D * paramLocation.getLongitude()));
    localEditor.putString("SP_KEY_PROVIDER_" + paramInt, paramLocation.getProvider());
    localEditor.putFloat("SP_KEY_ACCURCY_" + paramInt, paramLocation.getAccuracy());
    localEditor.putLong("SP_KEY_TIME_" + paramInt, paramLocation.getTime());
    localEditor.commit();
  }
  
  public void saveLocationType(int paramInt)
  {
    LogUtil.e("GLocation", "saveLocationType : " + paramInt);
    SharedPreferences.Editor localEditor = this.mPreferences.edit();
    localEditor.putInt("SP_KEY_LOCATION_TYPE", paramInt);
    localEditor.commit();
  }
  
  public void start()
  {
    stop();
    LogUtil.e("GLocation", "start");
    Location localLocation1 = this.mManager.getLastKnownLocation("gps");
    Location localLocation2 = this.mManager.getLastKnownLocation("network");
    Location localLocation3 = this.mManager.getLastKnownLocation("passive");
    if (isBetterLocation(localLocation1)) {
      saveLocation(localLocation1);
    }
    if (isBetterLocation(localLocation2)) {
      saveLocation(localLocation2);
    }
    if (isBetterLocation(localLocation3)) {
      saveLocation(localLocation3);
    }
    this.mManager.requestLocationUpdates("gps", 10000L, 0.0F, this);
    this.mManager.requestLocationUpdates("network", 10L, 0.0F, this);
  }
  
  public void stop()
  {
    LogUtil.e("GLocation", "stop");
    this.mManager.removeUpdates(this);
  }
  
  public static abstract interface LocationCallBack
  {
    public abstract void onResult(int paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.GMApp
 * JD-Core Version:    0.7.0.1
 */