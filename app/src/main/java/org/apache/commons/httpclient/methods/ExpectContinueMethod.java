package org.apache.commons.httpclient.methods;

import java.io.IOException;
import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.HttpVersion;
import org.apache.commons.httpclient.params.DefaultHttpParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public abstract class ExpectContinueMethod
  extends HttpMethodBase
{
  private static final Log LOG;
  static Class class$org$apache$commons$httpclient$methods$ExpectContinueMethod;
  
  static
  {
    Class localClass;
    if (class$org$apache$commons$httpclient$methods$ExpectContinueMethod == null)
    {
      localClass = class$("org.apache.commons.httpclient.methods.ExpectContinueMethod");
      class$org$apache$commons$httpclient$methods$ExpectContinueMethod = localClass;
    }
    for (;;)
    {
      LOG = LogFactory.getLog(localClass);
      return;
      localClass = class$org$apache$commons$httpclient$methods$ExpectContinueMethod;
    }
  }
  
  public ExpectContinueMethod() {}
  
  public ExpectContinueMethod(String paramString)
  {
    super(paramString);
  }
  
  static Class class$(String paramString)
  {
    try
    {
      Class localClass = Class.forName(paramString);
      return localClass;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new NoClassDefFoundError(localClassNotFoundException.getMessage());
    }
  }
  
  protected void addRequestHeaders(HttpState paramHttpState, HttpConnection paramHttpConnection)
    throws IOException, HttpException
  {
    LOG.trace("enter ExpectContinueMethod.addRequestHeaders(HttpState, HttpConnection)");
    super.addRequestHeaders(paramHttpState, paramHttpConnection);
    int i;
    if (getRequestHeader("Expect") != null)
    {
      i = 1;
      if ((!getParams().isParameterTrue("http.protocol.expect-continue")) || (!getEffectiveVersion().greaterEquals(HttpVersion.HTTP_1_1)) || (!hasRequestContent())) {
        break label77;
      }
      if (i == 0) {
        setRequestHeader("Expect", "100-continue");
      }
    }
    label77:
    while (i == 0)
    {
      return;
      i = 0;
      break;
    }
    removeRequestHeader("Expect");
  }
  
  public boolean getUseExpectHeader()
  {
    return getParams().getBooleanParameter("http.protocol.expect-continue", false);
  }
  
  protected abstract boolean hasRequestContent();
  
  public void setUseExpectHeader(boolean paramBoolean)
  {
    getParams().setBooleanParameter("http.protocol.expect-continue", paramBoolean);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.methods.ExpectContinueMethod
 * JD-Core Version:    0.7.0.1
 */