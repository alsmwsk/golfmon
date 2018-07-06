package org.apache.commons.httpclient;

public class URIException
  extends HttpException
{
  public static final int ESCAPING = 3;
  public static final int PARSING = 1;
  public static final int PUNYCODE = 4;
  public static final int UNKNOWN = 0;
  public static final int UNSUPPORTED_ENCODING = 2;
  protected String reason;
  protected int reasonCode;
  
  public URIException() {}
  
  public URIException(int paramInt)
  {
    this.reasonCode = paramInt;
  }
  
  public URIException(int paramInt, String paramString)
  {
    super(paramString);
    this.reason = paramString;
    this.reasonCode = paramInt;
  }
  
  public URIException(String paramString)
  {
    super(paramString);
    this.reason = paramString;
    this.reasonCode = 0;
  }
  
  public String getReason()
  {
    return this.reason;
  }
  
  public int getReasonCode()
  {
    return this.reasonCode;
  }
  
  public void setReason(String paramString)
  {
    this.reason = paramString;
  }
  
  public void setReasonCode(int paramInt)
  {
    this.reasonCode = paramInt;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.URIException
 * JD-Core Version:    0.7.0.1
 */