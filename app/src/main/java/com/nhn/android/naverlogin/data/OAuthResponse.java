package com.nhn.android.naverlogin.data;

import android.text.TextUtils;
import java.util.Map;

public class OAuthResponse
{
  private String mAccessToken;
  private OAuthErrorCode mErrorCode;
  private String mErrorDescription;
  private long mExpiresIn;
  private String mRefreshToken;
  private String mResultValue;
  private String mTokenType;
  
  public OAuthResponse(OAuthErrorCode paramOAuthErrorCode)
  {
    this.mErrorCode = paramOAuthErrorCode;
    this.mErrorDescription = paramOAuthErrorCode.getDesc();
  }
  
  public OAuthResponse(OAuthErrorCode paramOAuthErrorCode, String paramString)
  {
    this.mErrorCode = paramOAuthErrorCode;
    this.mErrorDescription = paramString;
  }
  
  public OAuthResponse(Map<String, String> paramMap)
  {
    this.mAccessToken = ((String)paramMap.get("access_token"));
    this.mRefreshToken = ((String)paramMap.get("refresh_token"));
    this.mTokenType = ((String)paramMap.get("token_type"));
    try
    {
      this.mExpiresIn = Long.parseLong((String)paramMap.get("expires_in"));
      this.mErrorCode = OAuthErrorCode.fromString((String)paramMap.get("error"));
      this.mErrorDescription = ((String)paramMap.get("error_description"));
      this.mResultValue = ((String)paramMap.get("result"));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.mExpiresIn = 3600L;
      }
    }
  }
  
  public String getAccessToken()
  {
    return this.mAccessToken;
  }
  
  public OAuthErrorCode getErrorCode()
  {
    return this.mErrorCode;
  }
  
  public String getErrorDesc()
  {
    return this.mErrorDescription;
  }
  
  public long getExpiresIn()
  {
    return this.mExpiresIn;
  }
  
  public String getRefreshToken()
  {
    return this.mRefreshToken;
  }
  
  public String getResultValue()
  {
    return this.mResultValue;
  }
  
  public String getTokenType()
  {
    return this.mTokenType;
  }
  
  public boolean isSuccess()
  {
    return (TextUtils.isEmpty(this.mErrorCode.getCode())) && (!TextUtils.isEmpty(this.mAccessToken));
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nhn.android.naverlogin.data.OAuthResponse
 * JD-Core Version:    0.7.0.1
 */