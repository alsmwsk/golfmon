package com.nhn.android.naverlogin.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.nhn.android.naverlogin.OAuthLogin;
import com.nhn.android.naverlogin.OAuthLoginHandler;
import com.nhn.android.naverlogin.connection.OAuthLoginConnection;
import com.nhn.android.naverlogin.data.OAuthErrorCode;
import com.nhn.android.naverlogin.data.OAuthLoginData;
import com.nhn.android.naverlogin.data.OAuthLoginPreferenceManager;
import com.nhn.android.naverlogin.data.OAuthLoginString;
import com.nhn.android.naverlogin.data.OAuthResponse;
import com.nhn.android.naverlogin.util.DeviceAppInfo;

public class OAuthLoginActivity
  extends Activity
{
  private static int REQUESTCODE_LOGIN = 100;
  private String mClientName;
  private Context mContext;
  private OAuthLoginDialogMng mDialogMng = new OAuthLoginDialogMng();
  private boolean mIsLoginActivityStarted = false;
  private OAuthLoginData mOAuthLoginData;
  
  private void finishWithErrorResult(OAuthErrorCode paramOAuthErrorCode)
  {
    Intent localIntent = new Intent();
    OAuthLoginPreferenceManager localOAuthLoginPreferenceManager = new OAuthLoginPreferenceManager(this.mContext);
    localOAuthLoginPreferenceManager.setLastErrorCode(paramOAuthErrorCode);
    localOAuthLoginPreferenceManager.setLastErrorDesc(paramOAuthErrorCode.getDesc());
    localIntent.putExtra("oauth_error_code", paramOAuthErrorCode.getCode());
    localIntent.putExtra("oauth_error_desc", paramOAuthErrorCode.getDesc());
    setResult(0, localIntent);
    finish();
    propagationResult(false);
  }
  
  private boolean initData(Bundle paramBundle)
  {
    this.mContext = this;
    OAuthLoginPreferenceManager localOAuthLoginPreferenceManager = new OAuthLoginPreferenceManager(this.mContext);
    String str1 = localOAuthLoginPreferenceManager.getClientId();
    String str2 = localOAuthLoginPreferenceManager.getClientSecret();
    String str3 = localOAuthLoginPreferenceManager.getCallbackUrl();
    if (paramBundle == null) {}
    for (String str4 = null;; str4 = paramBundle.getString("OAuthLoginData_state"))
    {
      this.mClientName = localOAuthLoginPreferenceManager.getClientName();
      if (!TextUtils.isEmpty(str1)) {
        break;
      }
      finishWithErrorResult(OAuthErrorCode.CLIENT_ERROR_NO_CLIENTID);
      return false;
    }
    if (TextUtils.isEmpty(str2))
    {
      finishWithErrorResult(OAuthErrorCode.CLIENT_ERROR_NO_CLIENTSECRET);
      return false;
    }
    if (TextUtils.isEmpty(this.mClientName))
    {
      finishWithErrorResult(OAuthErrorCode.CLIENT_ERROR_NO_CLIENTNAME);
      return false;
    }
    if (TextUtils.isEmpty(str3))
    {
      finishWithErrorResult(OAuthErrorCode.CLIENT_ERROR_NO_CALLBACKURL);
      return false;
    }
    this.mOAuthLoginData = new OAuthLoginData(str1, str2, str3, str4);
    return true;
  }
  
  private void propagationResult(boolean paramBoolean)
  {
    Message localMessage;
    if (OAuthLogin.mOAuthLoginHandler != null)
    {
      localMessage = new Message();
      if (!paramBoolean) {
        break label34;
      }
    }
    label34:
    for (int i = 1;; i = 0)
    {
      localMessage.what = i;
      OAuthLogin.mOAuthLoginHandler.sendMessage(localMessage);
      return;
    }
  }
  
  private void runOnlyOnce()
  {
    if (this.mOAuthLoginData == null)
    {
      finishWithErrorResult(OAuthErrorCode.CLIENT_ERROR_NO_CLIENTID);
      return;
    }
    startLoginActivity();
  }
  
  private void startLoginActivity()
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("ClientId", this.mOAuthLoginData.getClientId());
      localIntent.putExtra("ClientCallbackUrl", this.mOAuthLoginData.getCallbackUrl());
      localIntent.putExtra("state", this.mOAuthLoginData.getInitState());
      localIntent.putExtra("app_name", this.mClientName);
      localIntent.putExtra("oauth_sdk_version", "4.1.3");
      if (DeviceAppInfo.isIntentFilterExist(this.mContext, "com.nhn.android.search.action.OAUTH2_LOGIN"))
      {
        localIntent.setPackage("com.nhn.android.search");
        localIntent.setAction("com.nhn.android.search.action.OAUTH2_LOGIN");
        startActivityForResult(localIntent, REQUESTCODE_LOGIN);
        return;
      }
      if (DeviceAppInfo.isIntentFilterExist(this.mContext, "com.naver.android.action.OAUTH2_LOGIN"))
      {
        localIntent.setAction("com.naver.android.action.OAUTH2_LOGIN");
        String str = DeviceAppInfo.getPrimaryNaverOAuth2ndAppPackageName(this.mContext);
        if (!TextUtils.isEmpty(str)) {
          localIntent.setPackage(str);
        }
        startActivityForResult(localIntent, REQUESTCODE_LOGIN);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      startLoginWebviewActivity((Activity)this.mContext, REQUESTCODE_LOGIN, this.mOAuthLoginData.getClientId(), this.mOAuthLoginData.getInitState(), this.mOAuthLoginData.getCallbackUrl());
    }
  }
  
  private void startLoginWebviewActivity(Activity paramActivity, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(paramActivity, OAuthLoginInAppBrowserActivity.class);
    localIntent.putExtra("ClientId", paramString1);
    localIntent.putExtra("ClientCallbackUrl", paramString3);
    localIntent.putExtra("state", paramString2);
    paramActivity.startActivityForResult(localIntent, paramInt);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramIntent == null)
    {
      finishWithErrorResult(OAuthErrorCode.CLIENT_USER_CANCEL);
      return;
    }
    String str1 = paramIntent.getStringExtra("oauth_state");
    String str2 = paramIntent.getStringExtra("oauth_code");
    String str3 = paramIntent.getStringExtra("oauth_error_code");
    String str4 = paramIntent.getStringExtra("oauth_error_desc");
    this.mOAuthLoginData.setMiddleResult(str2, str1, str3, str4);
    if (TextUtils.isEmpty(str2))
    {
      OAuthLoginPreferenceManager localOAuthLoginPreferenceManager = new OAuthLoginPreferenceManager(this.mContext);
      localOAuthLoginPreferenceManager.setLastErrorCode(OAuthErrorCode.fromString(str3));
      localOAuthLoginPreferenceManager.setLastErrorDesc(str4);
      setResult(0, paramIntent);
      finish();
      propagationResult(false);
      return;
    }
    new GetAccessTokenTask(null).execute(new Void[0]);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (!initData(paramBundle)) {}
    do
    {
      return;
      if (paramBundle != null) {
        this.mIsLoginActivityStarted = paramBundle.getBoolean("IsLoginActivityStarted");
      }
    } while (this.mIsLoginActivityStarted);
    this.mIsLoginActivityStarted = true;
    runOnlyOnce();
  }
  
  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    if (paramBundle != null) {
      this.mIsLoginActivityStarted = paramBundle.getBoolean("IsLoginActivityStarted");
    }
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("IsLoginActivityStarted", this.mIsLoginActivityStarted);
    paramBundle.putString("OAuthLoginData_state", this.mOAuthLoginData.getInitState());
  }
  
  private class GetAccessTokenTask
    extends AsyncTask<Void, Void, OAuthResponse>
  {
    private GetAccessTokenTask() {}
    
    protected OAuthResponse doInBackground(Void... paramVarArgs)
    {
      try
      {
        OAuthResponse localOAuthResponse = OAuthLoginConnection.requestAccessToken(OAuthLoginActivity.this.mContext, OAuthLoginActivity.this.mOAuthLoginData.getClientId(), OAuthLoginActivity.this.mOAuthLoginData.getClientSecret(), OAuthLoginActivity.this.mOAuthLoginData.getState(), OAuthLoginActivity.this.mOAuthLoginData.getCode());
        return localOAuthResponse;
      }
      catch (Exception localException) {}
      return new OAuthResponse(OAuthErrorCode.CLIENT_ERROR_CONNECTION_ERROR);
    }
    
    protected void onPostExecute(OAuthResponse paramOAuthResponse)
    {
      try
      {
        OAuthLoginActivity.this.mDialogMng.hideProgressDlg();
        try
        {
          label11:
          localIntent = new Intent();
          localOAuthLoginPreferenceManager = new OAuthLoginPreferenceManager(OAuthLoginActivity.this.mContext);
          if (paramOAuthResponse.isSuccess())
          {
            localOAuthLoginPreferenceManager.setAccessToken(paramOAuthResponse.getAccessToken());
            localOAuthLoginPreferenceManager.setRefreshToken(paramOAuthResponse.getRefreshToken());
            localOAuthLoginPreferenceManager.setExpiresAt(System.currentTimeMillis() / 1000L + paramOAuthResponse.getExpiresIn());
            localOAuthLoginPreferenceManager.setTokenType(paramOAuthResponse.getTokenType());
            localOAuthLoginPreferenceManager.setLastErrorCode(OAuthErrorCode.NONE);
            localOAuthLoginPreferenceManager.setLastErrorDesc(OAuthErrorCode.NONE.getDesc());
            localIntent.putExtra("oauth_access_token", paramOAuthResponse.getAccessToken());
            localIntent.putExtra("oauth_refresh_token", paramOAuthResponse.getRefreshToken());
            localIntent.putExtra("oauth_expires_in", paramOAuthResponse.getExpiresIn());
            localIntent.putExtra("oauth_token_type", paramOAuthResponse.getTokenType());
            OAuthLoginActivity.this.setResult(-1, localIntent);
            OAuthLoginActivity.this.finish();
          }
          try
          {
            OAuthLoginActivity.this.propagationResult(paramOAuthResponse.isSuccess());
            return;
          }
          catch (Exception localException3)
          {
            localException3.printStackTrace();
            return;
          }
          if (paramOAuthResponse.getErrorCode() == OAuthErrorCode.NONE)
          {
            OAuthLoginActivity.this.finishWithErrorResult(OAuthErrorCode.CLIENT_USER_CANCEL);
            return;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Intent localIntent;
            OAuthLoginPreferenceManager localOAuthLoginPreferenceManager;
            localException2.printStackTrace();
            continue;
            localOAuthLoginPreferenceManager.setLastErrorCode(paramOAuthResponse.getErrorCode());
            localOAuthLoginPreferenceManager.setLastErrorDesc(paramOAuthResponse.getErrorDesc());
            localIntent.putExtra("oauth_error_code", paramOAuthResponse.getErrorCode().getCode());
            localIntent.putExtra("oauth_error_desc", paramOAuthResponse.getErrorDesc());
            OAuthLoginActivity.this.setResult(0, localIntent);
          }
        }
      }
      catch (Exception localException1)
      {
        break label11;
      }
    }
    
    protected void onPreExecute()
    {
      try
      {
        OAuthLoginActivity.this.mDialogMng.showProgressDlg(OAuthLoginActivity.this.mContext, OAuthLoginString.naveroauthlogin_string_getting_token.getString(OAuthLoginActivity.this.mContext), null);
        return;
      }
      catch (Exception localException) {}
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nhn.android.naverlogin.ui.OAuthLoginActivity
 * JD-Core Version:    0.7.0.1
 */