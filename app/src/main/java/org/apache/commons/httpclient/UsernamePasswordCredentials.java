package org.apache.commons.httpclient;

import org.apache.commons.httpclient.util.LangUtils;

public class UsernamePasswordCredentials
  implements Credentials
{
  private String password;
  private String userName;
  
  public UsernamePasswordCredentials() {}
  
  public UsernamePasswordCredentials(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Username:password string may not be null");
    }
    int i = paramString.indexOf(':');
    if (i >= 0)
    {
      this.userName = paramString.substring(0, i);
      this.password = paramString.substring(i + 1);
      return;
    }
    this.userName = paramString;
  }
  
  public UsernamePasswordCredentials(String paramString1, String paramString2)
  {
    if (paramString1 == null) {
      throw new IllegalArgumentException("Username may not be null");
    }
    this.userName = paramString1;
    this.password = paramString2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    UsernamePasswordCredentials localUsernamePasswordCredentials;
    do
    {
      do
      {
        return false;
        if (this == paramObject) {
          return true;
        }
      } while (!getClass().equals(paramObject.getClass()));
      localUsernamePasswordCredentials = (UsernamePasswordCredentials)paramObject;
    } while ((!LangUtils.equals(this.userName, localUsernamePasswordCredentials.userName)) || (!LangUtils.equals(this.password, localUsernamePasswordCredentials.password)));
    return true;
  }
  
  public String getPassword()
  {
    return this.password;
  }
  
  public String getUserName()
  {
    return this.userName;
  }
  
  public int hashCode()
  {
    return LangUtils.hashCode(LangUtils.hashCode(17, this.userName), this.password);
  }
  
  public void setPassword(String paramString)
  {
    this.password = paramString;
  }
  
  public void setUserName(String paramString)
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Username may not be null");
    }
    this.userName = paramString;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(this.userName);
    localStringBuffer.append(":");
    if (this.password == null) {}
    for (String str = "null";; str = this.password)
    {
      localStringBuffer.append(str);
      return localStringBuffer.toString();
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.UsernamePasswordCredentials
 * JD-Core Version:    0.7.0.1
 */