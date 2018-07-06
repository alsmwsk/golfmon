package org.apache.commons.httpclient.methods;

import java.io.IOException;
import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.ProtocolException;
import org.apache.commons.httpclient.params.DefaultHttpParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HeadMethod
  extends HttpMethodBase
{
  private static final Log LOG;
  static Class class$org$apache$commons$httpclient$methods$HeadMethod;
  
  static
  {
    Class localClass;
    if (class$org$apache$commons$httpclient$methods$HeadMethod == null)
    {
      localClass = class$("org.apache.commons.httpclient.methods.HeadMethod");
      class$org$apache$commons$httpclient$methods$HeadMethod = localClass;
    }
    for (;;)
    {
      LOG = LogFactory.getLog(localClass);
      return;
      localClass = class$org$apache$commons$httpclient$methods$HeadMethod;
    }
  }
  
  public HeadMethod()
  {
    setFollowRedirects(true);
  }
  
  public HeadMethod(String paramString)
  {
    super(paramString);
    setFollowRedirects(true);
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
  
  public int getBodyCheckTimeout()
  {
    return getParams().getIntParameter("http.protocol.head-body-timeout", -1);
  }
  
  public String getName()
  {
    return "HEAD";
  }
  
  protected void readResponseBody(HttpState paramHttpState, HttpConnection paramHttpConnection)
    throws HttpException, IOException
  {
    LOG.trace("enter HeadMethod.readResponseBody(HttpState, HttpConnection)");
    int i = getParams().getIntParameter("http.protocol.head-body-timeout", -1);
    if (i < 0) {
      responseBodyConsumed();
    }
    do
    {
      return;
      if (LOG.isDebugEnabled()) {
        LOG.debug("Check for non-compliant response body. Timeout in " + i + " ms");
      }
      try
      {
        boolean bool2 = paramHttpConnection.isResponseAvailable(i);
        bool1 = bool2;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          LOG.debug("An IOException occurred while testing if a response was available, we will assume one is not.", localIOException);
          boolean bool1 = false;
        }
        LOG.warn("Body content returned in response to HTTP HEAD");
        super.readResponseBody(paramHttpState, paramHttpConnection);
      }
    } while (!bool1);
    if (getParams().isParameterTrue("http.protocol.reject-head-body")) {
      throw new ProtocolException("Body content may not be sent in response to HTTP HEAD request");
    }
  }
  
  public void recycle()
  {
    super.recycle();
    setFollowRedirects(true);
  }
  
  public void setBodyCheckTimeout(int paramInt)
  {
    getParams().setIntParameter("http.protocol.head-body-timeout", paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.methods.HeadMethod
 * JD-Core Version:    0.7.0.1
 */