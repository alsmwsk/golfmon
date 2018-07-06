package com.appg.golfmon.atv;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import com.appg.golfmon.GMApp;
import com.appg.golfmon.GMApp.LocationCallBack;
import com.appg.golfmon.net.http.GFailedHandler;
import com.appg.golfmon.net.http.GJSONDecoder;
import com.appg.golfmon.net.http.GPClient;
import com.appg.golfmon.net.http.GResultHandler;
import com.appg.golfmon.util.Alert;
import com.appg.golfmon.util.Alert.OnCloseListener;
import com.appg.golfmon.util.CommonUtil;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.util.LogUtil;
import com.appg.golfmon.util.SPUtil;
import java.io.PrintStream;
import org.apache.commons.httpclient.Cookie;
import org.json.JSONArray;
import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.GExecutor;
import ra.genius.net.http.handler.IHttpHandler;

public class AtvIntro
  extends Activity
{
  // 할수있다..
  private static final int CALL_COUNT_MAX = 3;
  protected static final int REQ_SETTING_NETWORK = 1123;
  private int CALL_COUNT_CURREN = 0;
  private GMApp mApp = null;
  private Handler mHandler = new Handler();
  private Runnable mWaitRunnable = new Runnable()
  {
    public void run()
    {
      AtvIntro.this.startApp("대기");
    }
  };
  
  private void checkAppVersion()
  {
    GPClient localGPClient = new GPClient(this);
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addParameter("cmd", "BaseApi.introProcess");
    localGPClient.addParameter("registrationKey", SPUtil.getInstance().getRegistPushKey(this));
    localGPClient.addParameter("userNumber", JSONUtil.getString(SPUtil.getInstance().getUserInfo(this), "no", ""));
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(AtvIntro.this.getContext(), (String)paramAnonymousGBean.get("errorMessage"));
        AtvIntro.this.finish();
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        String str1 = JSONUtil.getString(paramAnonymousJSONObject, "marketUrlAndroid", "");
        if (!FormatUtil.isNullorEmpty(str1)) {
          SPUtil.getInstance().setMarketUrl(AtvIntro.this.getContext(), str1);
        }
        String str2 = JSONUtil.getString(paramAnonymousJSONObject, "marketUrlIOS", "");
        if (!FormatUtil.isNullorEmpty(str2)) {
          SPUtil.getInstance().setMarketUrlIOS(AtvIntro.this.getContext(), str2);
        }
        String str3 = JSONUtil.getString(paramAnonymousJSONObject, "version", "");
        if (!FormatUtil.isNullorEmpty(str3)) {
          SPUtil.getInstance().setServerVersion(AtvIntro.this.getContext(), str3);
        }
        String str4 = JSONUtil.getString(paramAnonymousJSONObject, "installMessage", "");
        if (!FormatUtil.isNullorEmpty(str4)) {
          SPUtil.getInstance().writeString(AtvIntro.this.getContext(), "spu.sys", "INSTALL_MSG", str4);
        }
        String str5 = JSONUtil.getString(paramAnonymousJSONObject, "installUrl", "");
        if (!FormatUtil.isNullorEmpty(str5)) {
          SPUtil.getInstance().writeString(AtvIntro.this.getContext(), "spu.sys", "INSTALL_URL", str5);
        }
        JSONObject localJSONObject = JSONUtil.getJSONObject(paramAnonymousJSONObject, "loginInfo");
        if (localJSONObject != null)
        {
          SPUtil.getInstance().setUserInfo(AtvIntro.this.getContext(), localJSONObject);
          SPUtil.getInstance().setUserType(AtvIntro.this.getContext(), JSONUtil.getString(localJSONObject, "user_type", ""));
          SPUtil.getInstance().setCookie(AtvIntro.this.getContext(), (Cookie[])paramAnonymousGBean.get("cookies"));
          SPUtil.getInstance().setIsLogin(AtvIntro.this.getContext(), true);
          if (paramAnonymousInt <= 0) {
            break label294;
          }
          AtvIntro.this.goMain();
        }
        for (;;)
        {
          return null;
          SPUtil.getInstance().logOut(AtvIntro.this.getContext());
          break;
          label294:
          if (paramAnonymousInt == -10)
          {
            Alert localAlert1 = new Alert();
            localAlert1.setOnCloseListener(new Alert.OnCloseListener()
            {
              public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
              {
                if (1 == paramAnonymous2Int)
                {
                  AtvIntro.this.goUpdate();
                  return;
                }
                AtvIntro.this.goMain();
              }
            });
            localAlert1.showAlert(AtvIntro.this.getContext(), paramAnonymousString, false, new String[] { "확인", "취소" });
          }
          else if (paramAnonymousInt == -20)
          {
            Alert localAlert2 = new Alert();
            localAlert2.setOnCloseListener(new Alert.OnCloseListener()
            {
              public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
              {
                AtvIntro.this.goUpdate();
              }
            });
            localAlert2.showAlert(AtvIntro.this.getContext(), paramAnonymousString, false, new String[] { "확인" });
          }
          else if ((paramAnonymousInt == -9999) || (paramAnonymousInt == -999))
          {
            SPUtil.getInstance().logOut(AtvIntro.this.getContext());
            Alert localAlert3 = new Alert();
            localAlert3.setOnCloseListener(new Alert.OnCloseListener()
            {
              public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
              {
                AtvIntro.this.startApp("checkAppg 다른디바이스로그인");
              }
            });
            localAlert3.showAlert(AtvIntro.this.getContext(), paramAnonymousString, false, new String[] { "확인" });
          }
          else if (paramAnonymousInt == -777)
          {
            Alert localAlert4 = new Alert();
            localAlert4.setOnCloseListener(new Alert.OnCloseListener()
            {
              public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
              {
                AtvIntro.this.startApp("checkAppg 정상팝업후");
              }
            });
            localAlert4.showAlert(AtvIntro.this.getContext(), paramAnonymousString, false, new String[] { "확인" });
          }
          else
          {
            Alert localAlert5 = new Alert();
            localAlert5.setOnCloseListener(new Alert.OnCloseListener()
            {
              public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
              {
                AtvIntro.this.finish();
              }
            });
            localAlert5.showAlert(AtvIntro.this.getContext(), paramAnonymousString, false, new String[] { "확인" });
          }
        }
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void checkAppg()
  {
    checkLocatinAgree();
    GPClient localGPClient = new GPClient(this);
    localGPClient.setUri("http://www.richware.co.kr/api/golfmon_A.txt");
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        AtvIntro.this.checkAppVersion();
      }
    });
    localGPClient.addHandler(new IHttpHandler()
    {
      public GBean handle(GBean paramAnonymousGBean)
      {
        int i = ((Integer)paramAnonymousGBean.get("returnCode")).intValue();
        String str = (String)paramAnonymousGBean.get("returnMessage");
        if (i > 0) {
          AtvIntro.this.checkAppVersion();
        }
        for (;;)
        {
          return null;
          Alert localAlert = new Alert();
          localAlert.showAlert(AtvIntro.this.getContext(), str, false, new String[] { "확인" });
          localAlert.setOnCloseListener(new Alert.OnCloseListener()
          {
            public void onClose(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int, Object paramAnonymous2Object)
            {
              AtvIntro.this.finish();
            }
          });
        }
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private void checkGCM()
  {
    Intent localIntent = new Intent("com.google.android.c2dm.intent.REGISTER");
    localIntent.putExtra("app", PendingIntent.getBroadcast(this, 0, new Intent(), 0));
    localIntent.putExtra("sender", "727981641450");
    startService(localIntent);
  }
  
  private void checkLocatinAgree()
  {
    if (SPUtil.getInstance().getAgreeLocation(this))
    {
      checkLocatinProvider();
      return;
    }
    Alert localAlert = new Alert();
    localAlert.setOnCloseListener(new Alert.OnCloseListener()
    {
      public void onClose(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, Object paramAnonymousObject)
      {
        if (1 == paramAnonymousInt)
        {
          SPUtil.getInstance().setAgreeLocation(AtvIntro.this, true);
          AtvIntro.this.checkLocatinProvider();
          return;
        }
        AtvIntro.this.startApp("checkLocatinAgree");
      }
    });
    localAlert.showAlert(this, "위치 서비스 사용동의", "위치정보를 사용하는데 동의합니까?\n*동의하지 않으시면 서울시청으로 위치가 자동 지정됩니다.", false, new String[] { "동의합니다", "동의하지않습니다." });
  }
  
  private void checkLocatinProvider()
  {
    if (this.mApp.isProviderOn())
    {
      startLocation();
      return;
    }
    Alert localAlert = new Alert();
    localAlert.setOnCloseListener(new Alert.OnCloseListener()
    {
      public void onClose(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, Object paramAnonymousObject)
      {
        if (1 == paramAnonymousInt)
        {
          Intent localIntent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
          localIntent.addCategory("android.intent.category.DEFAULT");
          AtvIntro.this.startActivityForResult(localIntent, 1597);
          return;
        }
        AtvIntro.this.startLocation();
      }
    });
    localAlert.showAlert(this, "시스템 설정에서 위치정보서비스(Wi-Fi, 모바일네트워크)를 사용하도록 설정해주세요", false, new String[] { "설정", "취소" });
  }
  
  private void checkNetwork()
  {
    if (!isNetworkOn())
    {
      Alert localAlert = new Alert();
      localAlert.setOnCloseListener(new Alert.OnCloseListener()
      {
        public void onClose(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, Object paramAnonymousObject)
        {
          if (1 == paramAnonymousInt)
          {
            Intent localIntent = new Intent("android.settings.WIRELESS_SETTINGS");
            localIntent.addCategory("android.intent.category.DEFAULT");
            AtvIntro.this.startActivityForResult(localIntent, 1123);
            return;
          }
          AtvIntro.this.finish();
        }
      });
      localAlert.showAlert(this, getString(2131099689), false, new String[] { "설정", "취소" });
      return;
    }
    checkWifi();
  }
  
  private void checkWifi()
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)getSystemService("connectivity");
    localConnectivityManager.getNetworkInfo(0);
    boolean bool = localConnectivityManager.getNetworkInfo(1).isConnected();
    if ((!SPUtil.getInstance().readBoolean(getContext(), "spu.sys", "CHECK_WIFI", false)) && (!bool))
    {
      Alert localAlert = new Alert();
      localAlert.setOnCloseListener(new Alert.OnCloseListener()
      {
        public void onClose(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, Object paramAnonymousObject)
        {
          if (paramAnonymousInt == 2) {
            SPUtil.getInstance().writeBoolean(AtvIntro.this.getContext(), "spu.sys", "CHECK_WIFI", true);
          }
          AtvIntro.this.checkAppg();
        }
      });
      localAlert.showAlert(this, getResources().getString(2131099689), false, new String[] { "확인", "다시보지않기" });
      return;
    }
    checkAppg();
  }
  
  private Context getContext()
  {
    return this;
  }
  
  private void goMain()
  {
    try
    {
      Intent localIntent = new Intent(this, AtvMain.class);
      if ((getIntent() != null) && (getIntent().getExtras() != null))
      {
        localIntent.setAction(getIntent().getAction());
        localIntent.putExtras(getIntent().getExtras());
      }
      startActivity(localIntent);
      finish();
      return;
    }
    finally {}
  }
  
  private void goUpdate()
  {
    try
    {
      startActivity(new Intent("android.intent.action.VIEW", Uri.parse(SPUtil.getInstance().getMarketUrl(this))));
      label24:
      finish();
      return;
    }
    catch (Exception localException)
    {
      break label24;
    }
  }
  
  private void startApp(String paramString)
  {
    try
    {
      LogUtil.e("intro startApp", paramString);
      int i = 1 + this.CALL_COUNT_CURREN;
      this.CALL_COUNT_CURREN = i;
      if (i == 3) {
        goMain();
      }
      return;
    }
    finally {}
  }
  
  private void startLocation()
  {
    LogUtil.e("intro startLocation", "start");
    this.mApp.start();
    this.mApp.getLocation(new GMApp.LocationCallBack()
    {
      public void onResult(int paramAnonymousInt)
      {
        AtvIntro.this.mApp.getLocation(null);
        AtvIntro.this.mApp.stop();
        int[] arrayOfInt = AtvIntro.this.mApp.getGeoPoint(1);
        if ((arrayOfInt[0] == -1) && (arrayOfInt[1] == -1))
        {
          AtvIntro.this.startApp("startLocation fail");
          return;
        }
        AtvIntro.this.callApi_getInfoOfAddressOfGeocode(arrayOfInt[0], arrayOfInt[1]);
      }
    });
  }
  
  public void callApi_getInfoOfAddressOfGeocode(int paramInt1, int paramInt2)
  {
    GPClient localGPClient = new GPClient(this);
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("Api.getInfoOfAddressOfGeocode");
    localGPClient.addParameter("lat", Integer.valueOf(paramInt1));
    localGPClient.addParameter("lng", Integer.valueOf(paramInt2));
    localGPClient.setDecoder(new GJSONDecoder(2));
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        AtvIntro.this.startApp("startLocation api fail");
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousInt > 0)
        {
          JSONArray localJSONArray = (JSONArray)paramAnonymousObject;
          AtvIntro.this.mApp.saveAddress(localJSONArray, 1);
          AtvIntro.this.mApp.saveLocationType(1);
        }
        AtvIntro.this.startApp("startLocation api");
        return null;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  public boolean isNetworkOn()
  {
    ConnectivityManager localConnectivityManager = (ConnectivityManager)getSystemService("connectivity");
    NetworkInfo localNetworkInfo1 = localConnectivityManager.getNetworkInfo(0);
    NetworkInfo localNetworkInfo2 = localConnectivityManager.getNetworkInfo(1);
    return (localNetworkInfo1.isConnected()) || (localNetworkInfo2.isConnected());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt1 == 1597) {
      checkLocatinProvider();
    }
    while (paramInt1 != 1123) {
      return;
    }
    checkNetwork();
  }
  
  public void onBackPressed()
  {
    if ((this.mHandler != null) && (this.mWaitRunnable != null))
    {
      this.mHandler.removeCallbacks(this.mWaitRunnable);
      GExecutor.getInstance().cancelAll();
      this.CALL_COUNT_CURREN = -100;
    }
    super.onBackPressed();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.CALL_COUNT_CURREN = 0;
    GExecutor.getInstance().cancelAll();
    this.mHandler.removeCallbacks(this.mWaitRunnable);
    try
    {
      System.out.println("appg version " + CommonUtil.getCurrentVersion(this));
      label53:
      this.mApp = ((GMApp)getApplication());
      this.mHandler.postDelayed(this.mWaitRunnable, 1000L);
      checkGCM();
      checkAppVersion();
      return;
    }
    catch (Exception localException)
    {
      break label53;
    }
  }
}



/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar

 * Qualified Name:     com.appg.golfmon.atv.AtvIntro

 * JD-Core Version:    0.7.0.1

 */