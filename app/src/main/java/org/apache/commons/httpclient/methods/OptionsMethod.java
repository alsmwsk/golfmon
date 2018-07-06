package org.apache.commons.httpclient.methods;

import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpConnection;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.httpclient.HttpState;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class OptionsMethod
  extends HttpMethodBase
{
  private static final Log LOG;
  static Class class$org$apache$commons$httpclient$methods$OptionsMethod;
  private Vector methodsAllowed = new Vector();
  
  static
  {
    Class localClass;
    if (class$org$apache$commons$httpclient$methods$OptionsMethod == null)
    {
      localClass = class$("org.apache.commons.httpclient.methods.OptionsMethod");
      class$org$apache$commons$httpclient$methods$OptionsMethod = localClass;
    }
    for (;;)
    {
      LOG = LogFactory.getLog(localClass);
      return;
      localClass = class$org$apache$commons$httpclient$methods$OptionsMethod;
    }
  }
  
  public OptionsMethod() {}
  
  public OptionsMethod(String paramString)
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
  
  public Enumeration getAllowedMethods()
  {
    checkUsed();
    return this.methodsAllowed.elements();
  }
  
  public String getName()
  {
    return "OPTIONS";
  }
  
  public boolean isAllowed(String paramString)
  {
    checkUsed();
    return this.methodsAllowed.contains(paramString);
  }
  
  public boolean needContentLength()
  {
    return false;
  }
  
  protected void processResponseHeaders(HttpState paramHttpState, HttpConnection paramHttpConnection)
  {
    LOG.trace("enter OptionsMethod.processResponseHeaders(HttpState, HttpConnection)");
    Header localHeader = getResponseHeader("allow");
    StringTokenizer localStringTokenizer;
    if (localHeader != null) {
      localStringTokenizer = new StringTokenizer(localHeader.getValue(), ",");
    }
    for (;;)
    {
      if (!localStringTokenizer.hasMoreElements()) {
        return;
      }
      String str = localStringTokenizer.nextToken().trim().toUpperCase();
      this.methodsAllowed.addElement(str);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.methods.OptionsMethod
 * JD-Core Version:    0.7.0.1
 */