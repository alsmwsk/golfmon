package org.apache.commons.httpclient;

public class Header
  extends NameValuePair
{
  private boolean isAutogenerated = false;
  
  public Header()
  {
    this(null, null);
  }
  
  public Header(String paramString1, String paramString2)
  {
    super(paramString1, paramString2);
  }
  
  public Header(String paramString1, String paramString2, boolean paramBoolean)
  {
    super(paramString1, paramString2);
    this.isAutogenerated = paramBoolean;
  }
  
  public HeaderElement[] getElements()
  {
    return HeaderElement.parseElements(getValue());
  }
  
  public HeaderElement[] getValues()
    throws HttpException
  {
    return HeaderElement.parse(getValue());
  }
  
  public boolean isAutogenerated()
  {
    return this.isAutogenerated;
  }
  
  public String toExternalForm()
  {
    StringBuffer localStringBuffer1 = new StringBuffer();
    String str1;
    StringBuffer localStringBuffer2;
    if (getName() == null)
    {
      str1 = "";
      localStringBuffer2 = localStringBuffer1.append(str1).append(": ");
      if (getValue() != null) {
        break label63;
      }
    }
    label63:
    for (String str2 = "";; str2 = getValue())
    {
      return str2 + "\r\n";
      str1 = getName();
      break;
    }
  }
  
  public String toString()
  {
    return toExternalForm();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.Header
 * JD-Core Version:    0.7.0.1
 */