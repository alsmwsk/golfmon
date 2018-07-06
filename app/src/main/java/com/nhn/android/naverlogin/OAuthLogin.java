package com.nhn.android.naverlogin;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import com.nhn.android.naverlogin.connection.CommonConnection;
import com.nhn.android.naverlogin.connection.NetworkState;
import com.nhn.android.naverlogin.connection.NetworkState.RetryListener;
import com.nhn.android.naverlogin.connection.OAuthLoginConnection;
import com.nhn.android.naverlogin.connection.ResponseData;
import com.nhn.android.naverlogin.data.OAuthErrorCode;
import com.nhn.android.naverlogin.data.OAuthLoginPreferenceManager;
import com.nhn.android.naverlogin.data.OAuthLoginState;
import com.nhn.android.naverlogin.data.OAuthLoginString;
import com.nhn.android.naverlogin.data.OAuthResponse;
import com.nhn.android.naverlogin.ui.OAuthLoginActivity;
import com.nhn.android.naverlogin.ui.OAuthLoginDialogMng;
import com.nhn.android.naverlogin.util.DeviceAppInfo;

public class OAuthLogin
{
  private static final String TAG = "NaverLoginOAuth|OAuthLogin";
  public static OAuthLoginHandler mOAuthLoginHandler;
  private static OAuthLogin sInstance;
  
  public static OAuthLogin getInstance()
  {
    if (sInstance == null) {
      sInstance = new OAuthLogin();
    }
    return sInstance;
  }
  
  public static String getVersion()
  {
    return "4.1.3";
  }
  
  private void showAlertDialog(Activity paramActivity, int paramInt)
  {
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity);
    Object localObject = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      localBuilder.setMessage((CharSequence)localObject);
      localBuilder.show();
      return;
      localObject = OAuthLoginString.naveroauthlogin_string_install_naverapp.getString(paramActivity);
      localBuilder.setPositiveButton(OAuthLoginString.naveroauthlogin_string_msg_install.getString(paramActivity), new MarketLinkDialogClickListener(paramActivity));
      localBuilder.setNegativeButton(OAuthLoginString.naveroauthlogin_string_msg_cancel.getString(paramActivity), new StartLoginDialogClickListener(paramActivity));
      continue;
      localObject = OAuthLoginString.naveroauthlogin_string_update_naverapp.getString(paramActivity);
      localBuilder.setPositiveButton(OAuthLoginString.naveroauthlogin_string_msg_update.getString(paramActivity), new MarketLinkDialogClickListener(paramActivity));
      localBuilder.setNegativeButton(OAuthLoginString.naveroauthlogin_string_msg_cancel.getString(paramActivity), new StartLoginDialogClickListener(paramActivity));
    }
  }
  
  private boolean valid(Context paramContext)
  {
    if (paramContext == null)
    {
      Log.i("NaverLoginOAuth|OAuthLogin", "context is null");
      return false;
    }
    OAuthLoginPreferenceManager localOAuthLoginPreferenceManager = new OAuthLoginPreferenceManager(paramContext);
    if (TextUtils.isEmpty(localOAuthLoginPreferenceManager.getClientId()))
    {
      Log.i("NaverLoginOAuth|OAuthLogin", "CliendId is null");
      return false;
    }
    if (TextUtils.isEmpty(localOAuthLoginPreferenceManager.getClientSecret()))
    {
      Log.i("NaverLoginOAuth|OAuthLogin", "CliendSecret is null");
      return false;
    }
    return true;
  }
  
  public String getAccessToken(Context paramContext)
  {
    String str = new OAuthLoginPreferenceManager(paramContext).getAccessToken();
    if (TextUtils.isEmpty(str)) {
      str = null;
    }
    return str;
  }
  
  public long getExpiresAt(Context paramContext)
  {
    return new OAuthLoginPreferenceManager(paramContext).getExpiresAt();
  }
  
  public OAuthErrorCode getLastErrorCode(Context paramContext)
  {
    return new OAuthLoginPreferenceManager(paramContext).getLastErrorCode();
  }
  
  public String getLastErrorDesc(Context paramContext)
  {
    return new OAuthLoginPreferenceManager(paramContext).getLastErrorDesc();
  }
  
  public String getRefreshToken(Context paramContext)
  {
    String str = new OAuthLoginPreferenceManager(paramContext).getRefreshToken();
    if (TextUtils.isEmpty(str)) {
      str = null;
    }
    return str;
  }
  
  public OAuthLoginState getState(Context paramContext)
  {
    if (!valid(paramContext)) {
      return OAuthLoginState.NEED_INIT;
    }
    OAuthLoginPreferenceManager localOAuthLoginPreferenceManager = new OAuthLoginPreferenceManager(paramContext);
    String str1 = localOAuthLoginPreferenceManager.getAccessToken();
    String str2 = localOAuthLoginPreferenceManager.getRefreshToken();
    if (TextUtils.isEmpty(str1))
    {
      if (TextUtils.isEmpty(str2)) {
        return OAuthLoginState.NEED_LOGIN;
      }
      return OAuthLoginState.NEED_REFRESH_TOKEN;
    }
    return OAuthLoginState.OK;
  }
  
  public String getTokenType(Context paramContext)
  {
    String str = new OAuthLoginPreferenceManager(paramContext).getTokenType();
    if (TextUtils.isEmpty(str)) {
      str = null;
    }
    return str;
  }
  
  public void init(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    OAuthLoginPreferenceManager localOAuthLoginPreferenceManager = new OAuthLoginPreferenceManager(paramContext);
    localOAuthLoginPreferenceManager.setClientId(paramString1);
    localOAuthLoginPreferenceManager.setClientSecret(paramString2);
    localOAuthLoginPreferenceManager.setClientName(paramString3);
    localOAuthLoginPreferenceManager.setCallbackUrl(paramString4);
    localOAuthLoginPreferenceManager.setLastErrorCode(OAuthErrorCode.NONE);
    localOAuthLoginPreferenceManager.setLastErrorDesc("");
  }
  
  public void logout(Context paramContext)
  {
    OAuthLoginPreferenceManager localOAuthLoginPreferenceManager = new OAuthLoginPreferenceManager(paramContext);
    localOAuthLoginPreferenceManager.setAccessToken("");
    localOAuthLoginPreferenceManager.setRefreshToken("");
    localOAuthLoginPreferenceManager.setLastErrorCode(OAuthErrorCode.NONE);
    localOAuthLoginPreferenceManager.setLastErrorDesc("");
  }
  
  public boolean logoutAndDeleteToken(Context paramContext)
  {
    OAuthLoginPreferenceManager localOAuthLoginPreferenceManager = new OAuthLoginPreferenceManager(paramContext);
    String str1 = localOAuthLoginPreferenceManager.getClientId();
    String str2 = localOAuthLoginPreferenceManager.getClientSecret();
    String str3 = localOAuthLoginPreferenceManager.getAccessToken();
    logout(paramContext);
    try
    {
      OAuthResponse localOAuthResponse = OAuthLoginConnection.deleteToken(paramContext, str1, str2, str3);
      if ("success".equalsIgnoreCase(localOAuthResponse.getResultValue())) {
        return true;
      }
      localOAuthLoginPreferenceManager.setLastErrorCode(localOAuthResponse.getErrorCode());
      localOAuthLoginPreferenceManager.setLastErrorDesc(localOAuthResponse.getErrorDesc());
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localOAuthLoginPreferenceManager.setLastErrorCode(OAuthErrorCode.ERROR_NO_CATAGORIZED);
      localOAuthLoginPreferenceManager.setLastErrorDesc(localException.getMessage());
    }
    return false;
  }
  
  public String refreshAccessToken(Context paramContext)
  {
    OAuthLoginPreferenceManager localOAuthLoginPreferenceManager = new OAuthLoginPreferenceManager(paramContext);
    OAuthResponse localOAuthResponse = OAuthLoginConnection.requestRefreshToken(paramContext, localOAuthLoginPreferenceManager.getClientId(), localOAuthLoginPreferenceManager.getClientSecret(), localOAuthLoginPreferenceManager.getRefreshToken());
    String str = localOAuthResponse.getAccessToken();
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    localOAuthLoginPreferenceManager.setAccessToken(localOAuthResponse.getAccessToken());
    localOAuthLoginPreferenceManager.setExpiresAt(System.currentTimeMillis() / 1000L + localOAuthResponse.getExpiresIn());
    return str;
  }
  
  public String requestApi(Context paramContext, String paramString1, String paramString2)
  {
    String str = "bearer " + paramString1;
    if (OAuthLoginDefine.DEVELOPER_VERSION)
    {
      Log.d("NaverLoginOAuth|OAuthLogin", "at:" + paramString1 + ", url:" + paramString2);
      Log.d("NaverLoginOAuth|OAuthLogin", "header:" + str);
    }
    ResponseData localResponseData = CommonConnection.request(paramContext, paramString2, null, null, str);
    if (OAuthLoginDefine.DEVELOPER_VERSION)
    {
      Log.d("NaverLoginOAuth|OAuthLogin", "res.statuscode" + localResponseData.mStatusCode);
      Log.d("NaverLoginOAuth|OAuthLogin", "res.content" + localResponseData.mContent);
    }
    if (localResponseData == null) {
      return null;
    }
    return localResponseData.mContent;
  }
  
  public void setMarketLinkWorking(boolean paramBoolean)
  {
    OAuthLoginDefine.MARKET_LINK_WORKING = paramBoolean;
  }
  
  public void startOauthLoginActivity(final Activity paramActivity, final OAuthLoginHandler paramOAuthLoginHandler)
  {
    if (NetworkState.checkConnectivity(paramActivity, true, new NetworkState.RetryListener()
    {
      public void onResult(boolean paramAnonymousBoolean)
      {
        if (paramAnonymousBoolean) {
          OAuthLogin.this.startOauthLoginActivity(paramActivity, paramOAuthLoginHandler);
        }
      }
    }))
    {
      mOAuthLoginHandler = paramOAuthLoginHandler;
      if (!TextUtils.isEmpty(getRefreshToken(paramActivity))) {
        new OAuthLoginTask(paramActivity).execute(new Void[0]);
      }
    }
    else
    {
      return;
    }
    if ((OAuthLoginDefine.MARKET_LINK_WORKING) && (!DeviceAppInfo.isIntentFilterExist(paramActivity, "com.naver.android.action.OAUTH2_LOGIN")) && (!DeviceAppInfo.isIntentFilterExist(paramActivity, "com.nhn.android.search.action.OAUTH2_LOGIN")))
    {
      if (DeviceAppInfo.isAppExist(paramActivity, "com.nhn.android.search"))
      {
        showAlertDialog(paramActivity, 144);
        return;
      }
      showAlertDialog(paramActivity, 145);
      return;
    }
    paramActivity.startActivity(new Intent(paramActivity, OAuthLoginActivity.class));
  }
  
  private class MarketLinkDialogClickListener
    implements DialogInterface.OnClickListener
  {
    Activity mActivity;
    
    MarketLinkDialogClickListener(Activity paramActivity)
    {
      this.mActivity = paramActivity;
    }
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.nhn.android.search"));
      this.mActivity.startActivity(localIntent);
    }
  }
  
  private class OAuthLoginTask
    extends AsyncTask<Void, Void, String>
  {
    private Context _context;
    private OAuthLoginDialogMng mDialogMng = new OAuthLoginDialogMng();
    
    OAuthLoginTask(Context paramContext)
    {
      this._context = paramContext;
    }
    
    protected String doInBackground(Void... paramVarArgs)
    {
      return OAuthLogin.this.refreshAccessToken(this._context);
    }
    
    protected void onPostExecute(String paramString)
    {
      try
      {
        this.mDialogMng.hideProgressDlg();
        label8:
        if (TextUtils.isEmpty(paramString))
        {
          Intent localIntent = new Intent(this._context, OAuthLoginActivity.class);
          this._context.startActivity(localIntent);
          return;
        }
        OAuthLogin.mOAuthLoginHandler.run(true);
        return;
      }
      catch (Exception localException)
      {
        break label8;
      }
    }
    
    protected void onPreExecute()
    {
      this.mDialogMng.showProgressDlg(this._context, OAuthLoginString.naveroauthlogin_string_getting_token.getString(this._context), null);
    }
  }
  
  class OAuthNaverAppInstallMethod
  {
    static final int TYPE_INSTALL = 145;
    static final int TYPE_UPDATE = 144;
    
    OAuthNaverAppInstallMethod() {}
  }
  
  private class StartLoginDialogClickListener
    implements DialogInterface.OnClickListener
  {
    Activity mActivity;
    
    StartLoginDialogClickListener(Activity paramActivity)
    {
      this.mActivity = paramActivity;
    }
    
    public void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      Intent localIntent = new Intent(this.mActivity, OAuthLoginActivity.class);
      this.mActivity.startActivity(localIntent);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nhn.android.naverlogin.OAuthLogin
 * JD-Core Version:    0.7.0.1
 */