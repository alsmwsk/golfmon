package org.apache.commons.httpclient.auth;

import org.apache.commons.httpclient.Credentials;

public abstract interface CredentialsProvider
{
  public static final String PROVIDER = "http.authentication.credential-provider";
  
  public abstract Credentials getCredentials(AuthScheme paramAuthScheme, String paramString, int paramInt, boolean paramBoolean)
    throws CredentialsNotAvailableException;
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.auth.CredentialsProvider
 * JD-Core Version:    0.7.0.1
 */