package org.apache.commons.httpclient;

public class StatusLine
{
  private final String httpVersion;
  private final String reasonPhrase;
  private final int statusCode;
  private final String statusLine;
  
  public StatusLine(String paramString)
    throws HttpException
  {
    int i = paramString.length();
    int j = 0;
    for (k = 0;; k = m)
    {
      try
      {
        if (Character.isWhitespace(paramString.charAt(k))) {
          break label114;
        }
        n = k + 4;
        try
        {
          if ("HTTP".equals(paramString.substring(k, n))) {
            break;
          }
          throw new HttpException("Status-Line '" + paramString + "' does not start with HTTP");
        }
        catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException2) {}
      }
      catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException1)
      {
        int n;
        label82:
        label114:
        int m;
        int i1;
        int i2;
        int i3;
        break label82;
      }
      throw new HttpException("Status-Line '" + paramString + "' is not valid");
      m = k + 1;
      j++;
    }
    i1 = paramString.indexOf(" ", n);
    if (i1 <= 0) {
      throw new ProtocolException("Unable to parse HTTP-Version from the status line: '" + paramString + "'");
    }
    this.httpVersion = paramString.substring(j, i1).toUpperCase();
    if (paramString.charAt(i1) != ' ')
    {
      i2 = paramString.indexOf(" ", i1);
      i3 = i2;
      if (i3 < 0) {
        i3 = i;
      }
    }
    for (;;)
    {
      try
      {
        this.statusCode = Integer.parseInt(paramString.substring(i1, i3));
        int i4 = i3 + 1;
        if (i4 >= i) {
          break label310;
        }
        this.reasonPhrase = paramString.substring(i4).trim();
        this.statusLine = paramString;
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        throw new ProtocolException("Unable to parse status code from status line: '" + paramString + "'");
      }
      i1++;
      break;
      label310:
      this.reasonPhrase = "";
    }
  }
  
  public static boolean startsWithHTTP(String paramString)
  {
    int i = 0;
    try
    {
      for (;;)
      {
        if (!Character.isWhitespace(paramString.charAt(i)))
        {
          boolean bool = "HTTP".equals(paramString.substring(i, i + 4));
          return bool;
        }
        i++;
      }
      return false;
    }
    catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException) {}
  }
  
  public final String getHttpVersion()
  {
    return this.httpVersion;
  }
  
  public final String getReasonPhrase()
  {
    return this.reasonPhrase;
  }
  
  public final int getStatusCode()
  {
    return this.statusCode;
  }
  
  public final String toString()
  {
    return this.statusLine;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.StatusLine
 * JD-Core Version:    0.7.0.1
 */