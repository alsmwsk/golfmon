package org.apache.commons.httpclient;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HttpState
{
  private static final Log LOG;
  public static final String PREEMPTIVE_DEFAULT = "false";
  public static final String PREEMPTIVE_PROPERTY = "httpclient.authentication.preemptive";
  static Class class$org$apache$commons$httpclient$HttpState;
  private int cookiePolicy = -1;
  private ArrayList cookies = new ArrayList();
  private HashMap credMap = new HashMap();
  private boolean preemptive = false;
  private HashMap proxyCred = new HashMap();
  
  static
  {
    Class localClass;
    if (class$org$apache$commons$httpclient$HttpState == null)
    {
      localClass = class$("org.apache.commons.httpclient.HttpState");
      class$org$apache$commons$httpclient$HttpState = localClass;
    }
    for (;;)
    {
      LOG = LogFactory.getLog(localClass);
      return;
      localClass = class$org$apache$commons$httpclient$HttpState;
    }
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
  
  private static String getCookiesStringRepresentation(List paramList)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = paramList.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localStringBuffer.toString();
      }
      Cookie localCookie = (Cookie)localIterator.next();
      if (localStringBuffer.length() > 0) {
        localStringBuffer.append("#");
      }
      localStringBuffer.append(localCookie.toExternalForm());
    }
  }
  
  private static String getCredentialsStringRepresentation(Map paramMap)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = paramMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        return localStringBuffer.toString();
      }
      Object localObject = localIterator.next();
      Credentials localCredentials = (Credentials)paramMap.get(localObject);
      if (localStringBuffer.length() > 0) {
        localStringBuffer.append(", ");
      }
      localStringBuffer.append(localObject);
      localStringBuffer.append("#");
      localStringBuffer.append(localCredentials.toString());
    }
  }
  
  private static Credentials matchCredentials(HashMap paramHashMap, AuthScope paramAuthScope)
  {
    Credentials localCredentials = (Credentials)paramHashMap.get(paramAuthScope);
    int i;
    Object localObject;
    Iterator localIterator;
    if (localCredentials == null)
    {
      i = -1;
      localObject = null;
      localIterator = paramHashMap.keySet().iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        if (localObject != null) {
          localCredentials = (Credentials)paramHashMap.get(localObject);
        }
        return localCredentials;
      }
      AuthScope localAuthScope = (AuthScope)localIterator.next();
      int j = paramAuthScope.match(localAuthScope);
      if (j > i)
      {
        i = j;
        localObject = localAuthScope;
      }
    }
  }
  
  /* Error */
  public void addCookie(Cookie paramCookie)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 42	org/apache/commons/httpclient/HttpState:LOG	Lorg/apache/commons/logging/Log;
    //   5: ldc 155
    //   7: invokeinterface 161 2 0
    //   12: aload_1
    //   13: ifnull +36 -> 49
    //   16: aload_0
    //   17: getfield 57	org/apache/commons/httpclient/HttpState:cookies	Ljava/util/ArrayList;
    //   20: invokevirtual 164	java/util/AbstractList:iterator	()Ljava/util/Iterator;
    //   23: astore_3
    //   24: aload_3
    //   25: invokeinterface 96 1 0
    //   30: ifne +22 -> 52
    //   33: aload_1
    //   34: invokevirtual 167	org/apache/commons/httpclient/Cookie:isExpired	()Z
    //   37: ifne +12 -> 49
    //   40: aload_0
    //   41: getfield 57	org/apache/commons/httpclient/HttpState:cookies	Ljava/util/ArrayList;
    //   44: aload_1
    //   45: invokevirtual 171	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   48: pop
    //   49: aload_0
    //   50: monitorexit
    //   51: return
    //   52: aload_1
    //   53: aload_3
    //   54: invokeinterface 103 1 0
    //   59: checkcast 105	org/apache/commons/httpclient/Cookie
    //   62: invokevirtual 174	org/apache/commons/httpclient/Cookie:equals	(Ljava/lang/Object;)Z
    //   65: ifeq -41 -> 24
    //   68: aload_3
    //   69: invokeinterface 177 1 0
    //   74: goto -41 -> 33
    //   77: astore_2
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_2
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	HttpState
    //   0	82	1	paramCookie	Cookie
    //   77	4	2	localObject	Object
    //   23	46	3	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	12	77	finally
    //   16	24	77	finally
    //   24	33	77	finally
    //   33	49	77	finally
    //   52	74	77	finally
  }
  
  /* Error */
  public void addCookies(Cookie[] paramArrayOfCookie)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 42	org/apache/commons/httpclient/HttpState:LOG	Lorg/apache/commons/logging/Log;
    //   5: ldc 181
    //   7: invokeinterface 161 2 0
    //   12: aload_1
    //   13: ifnull +15 -> 28
    //   16: iconst_0
    //   17: istore_3
    //   18: aload_1
    //   19: arraylength
    //   20: istore 4
    //   22: iload_3
    //   23: iload 4
    //   25: if_icmplt +6 -> 31
    //   28: aload_0
    //   29: monitorexit
    //   30: return
    //   31: aload_0
    //   32: aload_1
    //   33: iload_3
    //   34: aaload
    //   35: invokevirtual 183	org/apache/commons/httpclient/HttpState:addCookie	(Lorg/apache/commons/httpclient/Cookie;)V
    //   38: iinc 3 1
    //   41: goto -23 -> 18
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	HttpState
    //   0	49	1	paramArrayOfCookie	Cookie[]
    //   44	4	2	localObject	Object
    //   17	22	3	i	int
    //   20	6	4	j	int
    // Exception table:
    //   from	to	target	type
    //   2	12	44	finally
    //   18	22	44	finally
    //   31	38	44	finally
  }
  
  public void clear()
  {
    clearCookies();
    clearCredentials();
    clearProxyCredentials();
  }
  
  public void clearCookies()
  {
    try
    {
      this.cookies.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void clearCredentials()
  {
    this.credMap.clear();
  }
  
  public void clearProxyCredentials()
  {
    this.proxyCred.clear();
  }
  
  public int getCookiePolicy()
  {
    return this.cookiePolicy;
  }
  
  public Cookie[] getCookies()
  {
    try
    {
      LOG.trace("enter HttpState.getCookies()");
      Cookie[] arrayOfCookie = (Cookie[])this.cookies.toArray(new Cookie[this.cookies.size()]);
      return arrayOfCookie;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public Cookie[] getCookies(String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 42	org/apache/commons/httpclient/HttpState:LOG	Lorg/apache/commons/logging/Log;
    //   5: ldc 213
    //   7: invokeinterface 161 2 0
    //   12: invokestatic 219	org/apache/commons/httpclient/cookie/CookiePolicy:getDefaultSpec	()Lorg/apache/commons/httpclient/cookie/CookieSpec;
    //   15: astore 6
    //   17: new 54	java/util/ArrayList
    //   20: dup
    //   21: aload_0
    //   22: getfield 57	org/apache/commons/httpclient/HttpState:cookies	Ljava/util/ArrayList;
    //   25: invokevirtual 204	java/util/ArrayList:size	()I
    //   28: invokespecial 222	java/util/ArrayList:<init>	(I)V
    //   31: astore 7
    //   33: iconst_0
    //   34: istore 8
    //   36: aload_0
    //   37: getfield 57	org/apache/commons/httpclient/HttpState:cookies	Ljava/util/ArrayList;
    //   40: invokevirtual 204	java/util/ArrayList:size	()I
    //   43: istore 9
    //   45: iload 8
    //   47: iload 9
    //   49: if_icmplt +26 -> 75
    //   52: aload 7
    //   54: aload 7
    //   56: invokevirtual 204	java/util/ArrayList:size	()I
    //   59: anewarray 105	org/apache/commons/httpclient/Cookie
    //   62: invokevirtual 208	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   65: checkcast 210	[Lorg/apache/commons/httpclient/Cookie;
    //   68: astore 10
    //   70: aload_0
    //   71: monitorexit
    //   72: aload 10
    //   74: areturn
    //   75: aload_0
    //   76: getfield 57	org/apache/commons/httpclient/HttpState:cookies	Ljava/util/ArrayList;
    //   79: iload 8
    //   81: invokevirtual 225	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   84: checkcast 105	org/apache/commons/httpclient/Cookie
    //   87: astore 11
    //   89: aload 6
    //   91: aload_1
    //   92: iload_2
    //   93: aload_3
    //   94: iload 4
    //   96: aload 11
    //   98: invokeinterface 230 6 0
    //   103: ifeq +11 -> 114
    //   106: aload 7
    //   108: aload 11
    //   110: invokevirtual 171	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   113: pop
    //   114: iinc 8 1
    //   117: goto -72 -> 45
    //   120: astore 5
    //   122: aload_0
    //   123: monitorexit
    //   124: aload 5
    //   126: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	127	0	this	HttpState
    //   0	127	1	paramString1	String
    //   0	127	2	paramInt	int
    //   0	127	3	paramString2	String
    //   0	127	4	paramBoolean	boolean
    //   120	5	5	localObject	Object
    //   15	75	6	localCookieSpec	org.apache.commons.httpclient.cookie.CookieSpec
    //   31	76	7	localArrayList	ArrayList
    //   34	81	8	i	int
    //   43	7	9	j	int
    //   68	5	10	arrayOfCookie	Cookie[]
    //   87	22	11	localCookie	Cookie
    // Exception table:
    //   from	to	target	type
    //   2	33	120	finally
    //   36	45	120	finally
    //   52	70	120	finally
    //   75	114	120	finally
  }
  
  public Credentials getCredentials(String paramString1, String paramString2)
  {
    try
    {
      LOG.trace("enter HttpState.getCredentials(String, String");
      Credentials localCredentials = matchCredentials(this.credMap, new AuthScope(paramString2, -1, paramString1, AuthScope.ANY_SCHEME));
      return localCredentials;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Credentials getCredentials(AuthScope paramAuthScope)
  {
    if (paramAuthScope == null) {
      try
      {
        throw new IllegalArgumentException("Authentication scope may not be null");
      }
      finally {}
    }
    LOG.trace("enter HttpState.getCredentials(AuthScope)");
    Credentials localCredentials = matchCredentials(this.credMap, paramAuthScope);
    return localCredentials;
  }
  
  public Credentials getProxyCredentials(String paramString1, String paramString2)
  {
    try
    {
      LOG.trace("enter HttpState.getCredentials(String, String");
      Credentials localCredentials = matchCredentials(this.proxyCred, new AuthScope(paramString2, -1, paramString1, AuthScope.ANY_SCHEME));
      return localCredentials;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Credentials getProxyCredentials(AuthScope paramAuthScope)
  {
    if (paramAuthScope == null) {
      try
      {
        throw new IllegalArgumentException("Authentication scope may not be null");
      }
      finally {}
    }
    LOG.trace("enter HttpState.getProxyCredentials(AuthScope)");
    Credentials localCredentials = matchCredentials(this.proxyCred, paramAuthScope);
    return localCredentials;
  }
  
  public boolean isAuthenticationPreemptive()
  {
    return this.preemptive;
  }
  
  public boolean purgeExpiredCookies()
  {
    try
    {
      LOG.trace("enter HttpState.purgeExpiredCookies()");
      boolean bool = purgeExpiredCookies(new Date());
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public boolean purgeExpiredCookies(Date paramDate)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 42	org/apache/commons/httpclient/HttpState:LOG	Lorg/apache/commons/logging/Log;
    //   5: ldc_w 265
    //   8: invokeinterface 161 2 0
    //   13: iconst_0
    //   14: istore_3
    //   15: aload_0
    //   16: getfield 57	org/apache/commons/httpclient/HttpState:cookies	Ljava/util/ArrayList;
    //   19: invokevirtual 164	java/util/AbstractList:iterator	()Ljava/util/Iterator;
    //   22: astore 4
    //   24: aload 4
    //   26: invokeinterface 96 1 0
    //   31: istore 5
    //   33: iload 5
    //   35: ifne +7 -> 42
    //   38: aload_0
    //   39: monitorexit
    //   40: iload_3
    //   41: ireturn
    //   42: aload 4
    //   44: invokeinterface 103 1 0
    //   49: checkcast 105	org/apache/commons/httpclient/Cookie
    //   52: aload_1
    //   53: invokevirtual 267	org/apache/commons/httpclient/Cookie:isExpired	(Ljava/util/Date;)Z
    //   56: ifeq -32 -> 24
    //   59: aload 4
    //   61: invokeinterface 177 1 0
    //   66: iconst_1
    //   67: istore_3
    //   68: goto -44 -> 24
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	HttpState
    //   0	76	1	paramDate	Date
    //   71	4	2	localObject	Object
    //   14	54	3	bool1	boolean
    //   22	38	4	localIterator	Iterator
    //   31	3	5	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   2	13	71	finally
    //   15	24	71	finally
    //   24	33	71	finally
    //   42	66	71	finally
  }
  
  public void setAuthenticationPreemptive(boolean paramBoolean)
  {
    this.preemptive = paramBoolean;
  }
  
  public void setCookiePolicy(int paramInt)
  {
    this.cookiePolicy = paramInt;
  }
  
  public void setCredentials(String paramString1, String paramString2, Credentials paramCredentials)
  {
    try
    {
      LOG.trace("enter HttpState.setCredentials(String, String, Credentials)");
      this.credMap.put(new AuthScope(paramString2, -1, paramString1, AuthScope.ANY_SCHEME), paramCredentials);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setCredentials(AuthScope paramAuthScope, Credentials paramCredentials)
  {
    if (paramAuthScope == null) {
      try
      {
        throw new IllegalArgumentException("Authentication scope may not be null");
      }
      finally {}
    }
    LOG.trace("enter HttpState.setCredentials(AuthScope, Credentials)");
    this.credMap.put(paramAuthScope, paramCredentials);
  }
  
  public void setProxyCredentials(String paramString1, String paramString2, Credentials paramCredentials)
  {
    try
    {
      LOG.trace("enter HttpState.setProxyCredentials(String, String, Credentials");
      this.proxyCred.put(new AuthScope(paramString2, -1, paramString1, AuthScope.ANY_SCHEME), paramCredentials);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setProxyCredentials(AuthScope paramAuthScope, Credentials paramCredentials)
  {
    if (paramAuthScope == null) {
      try
      {
        throw new IllegalArgumentException("Authentication scope may not be null");
      }
      finally {}
    }
    LOG.trace("enter HttpState.setProxyCredentials(AuthScope, Credentials)");
    this.proxyCred.put(paramAuthScope, paramCredentials);
  }
  
  public String toString()
  {
    try
    {
      StringBuffer localStringBuffer = new StringBuffer();
      localStringBuffer.append("[");
      localStringBuffer.append(getCredentialsStringRepresentation(this.proxyCred));
      localStringBuffer.append(" | ");
      localStringBuffer.append(getCredentialsStringRepresentation(this.credMap));
      localStringBuffer.append(" | ");
      localStringBuffer.append(getCookiesStringRepresentation(this.cookies));
      localStringBuffer.append("]");
      String str = localStringBuffer.toString();
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.HttpState
 * JD-Core Version:    0.7.0.1
 */