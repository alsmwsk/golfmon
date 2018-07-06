package org.apache.commons.httpclient;

import java.io.Serializable;
import org.apache.commons.httpclient.util.LangUtils;

public class NameValuePair
  implements Serializable
{
  private String name = null;
  private String value = null;
  
  public NameValuePair()
  {
    this(null, null);
  }
  
  public NameValuePair(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.value = paramString2;
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
    } while (!(paramObject instanceof NameValuePair));
    NameValuePair localNameValuePair = (NameValuePair)paramObject;
    if ((LangUtils.equals(this.name, localNameValuePair.name)) && (LangUtils.equals(this.value, localNameValuePair.value))) {}
    for (;;)
    {
      return bool;
      bool = false;
    }
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    return LangUtils.hashCode(LangUtils.hashCode(17, this.name), this.value);
  }
  
  public void setName(String paramString)
  {
    this.name = paramString;
  }
  
  public void setValue(String paramString)
  {
    this.value = paramString;
  }
  
  public String toString()
  {
    return "name=" + this.name + ", " + "value=" + this.value;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.NameValuePair
 * JD-Core Version:    0.7.0.1
 */