package org.apache.commons.httpclient;

import org.apache.commons.httpclient.util.LangUtils;

public class NTCredentials
  extends UsernamePasswordCredentials
{
  private String domain;
  private String host;
  
  public NTCredentials() {}
  
  public NTCredentials(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    super(paramString1, paramString2);
    if (paramString4 == null) {
      throw new IllegalArgumentException("Domain may not be null");
    }
    this.domain = paramString4;
    if (paramString3 == null) {
      throw new IllegalArgumentException("Host may not be null");
    }
    this.host = paramString3;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (paramObject == null) {}
    do
    {
      return false;
      if (this == paramObject) {
        return bool;
      }
    } while ((!super.equals(paramObject)) || (!(paramObject instanceof NTCredentials)));
    NTCredentials localNTCredentials = (NTCredentials)paramObject;
    if ((LangUtils.equals(this.domain, localNTCredentials.domain)) && (LangUtils.equals(this.host, localNTCredentials.host))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public String getDomain()
  {
    return this.domain;
  }
  
  public String getHost()
  {
    return this.host;
  }
  
  public int hashCode()
  {
    return LangUtils.hashCode(LangUtils.hashCode(super.hashCode(), this.host), this.domain);
  }
  
  public void setDomain(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Domain may not be null");
    }
    this.domain = paramString;
  }
  
  public void setHost(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Host may not be null");
    }
    this.host = paramString;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer(super.toString());
    localStringBuffer.append("@");
    localStringBuffer.append(this.host);
    localStringBuffer.append(".");
    localStringBuffer.append(this.domain);
    return localStringBuffer.toString();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.NTCredentials
 * JD-Core Version:    0.7.0.1
 */