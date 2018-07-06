package com.nhn.android.naverlogin.data;

import android.text.TextUtils;
import android.util.Log;
import com.nhn.android.naverlogin.OAuthLoginDefine;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLEncoder;
import java.security.SecureRandom;

public class OAuthLoginData
{
  private static final String TAG = "NaverLoginOAuth|OAuthLoginData";
  private String mInOAuthCallback;
  private String mInOAuthClientId;
  private String mInOAuthClientSecret;
  private String mInOAuthState;
  private String mOAuthCode;
  private OAuthErrorCode mOAuthErrorCode;
  private String mOAuthErrorDesc;
  private String mOAuthState;
  
  public OAuthLoginData(String paramString1, String paramString2, String paramString3)
  {
    init(paramString1, paramString2, paramString3, null);
  }
  
  public OAuthLoginData(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    init(paramString1, paramString2, paramString3, paramString4);
  }
  
  private String generateState()
  {
    String str1 = new BigInteger(130, new SecureRandom()).toString(32);
    try
    {
      String str2 = URLEncoder.encode(str1, "UTF-8");
      return str2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
    }
    return str1;
  }
  
  private void init(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mInOAuthClientId = paramString1;
    this.mInOAuthClientSecret = paramString2;
    this.mInOAuthCallback = paramString3;
    if (TextUtils.isEmpty(paramString4))
    {
      this.mInOAuthState = generateState();
      return;
    }
    this.mInOAuthState = paramString4;
  }
  
  private boolean isStateOk()
  {
    if (this.mInOAuthState.equalsIgnoreCase(this.mOAuthState)) {
      return true;
    }
    if (OAuthLoginDefine.DEVELOPER_VERSION) {
      Log.d("NaverLoginOAuth|OAuthLoginData", "state is not valid. init:" + this.mInOAuthState + ", check:" + this.mOAuthState);
    }
    return false;
  }
  
  public String getCallbackUrl()
  {
    return this.mInOAuthCallback;
  }
  
  public String getClientId()
  {
    return this.mInOAuthClientId;
  }
  
  public String getClientSecret()
  {
    return this.mInOAuthClientSecret;
  }
  
  public String getCode()
  {
    if (isStateOk()) {
      return this.mOAuthCode;
    }
    return null;
  }
  
  public OAuthErrorCode getErrorCode()
  {
    return this.mOAuthErrorCode;
  }
  
  public String getErrorDesc()
  {
    return this.mOAuthErrorDesc;
  }
  
  public String getInitState()
  {
    return this.mInOAuthState;
  }
  
  public String getState()
  {
    return this.mOAuthState;
  }
  
  public boolean isSuccess()
  {
    return (TextUtils.isEmpty(this.mOAuthErrorCode.getCode())) && (isStateOk()) && (!TextUtils.isEmpty(this.mOAuthCode));
  }
  
  public void setMiddleResult(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.mOAuthCode = paramString1;
    this.mOAuthState = paramString2;
    this.mOAuthErrorCode = OAuthErrorCode.fromString(paramString3);
    this.mOAuthErrorDesc = paramString4;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nhn.android.naverlogin.data.OAuthLoginData
 * JD-Core Version:    0.7.0.1
 */