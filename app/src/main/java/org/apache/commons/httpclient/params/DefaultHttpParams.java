package org.apache.commons.httpclient.params;

import java.io.Serializable;
import java.util.HashMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DefaultHttpParams
  implements HttpParams, Serializable, Cloneable
{
  private static final Log LOG;
  static Class class$org$apache$commons$httpclient$params$DefaultHttpParams;
  private static HttpParamsFactory httpParamsFactory;
  private HttpParams defaults = null;
  private HashMap parameters = null;
  
  static
  {
    Class localClass;
    if (class$org$apache$commons$httpclient$params$DefaultHttpParams == null)
    {
      localClass = class$("org.apache.commons.httpclient.params.DefaultHttpParams");
      class$org$apache$commons$httpclient$params$DefaultHttpParams = localClass;
    }
    for (;;)
    {
      LOG = LogFactory.getLog(localClass);
      httpParamsFactory = new DefaultHttpParamsFactory();
      return;
      localClass = class$org$apache$commons$httpclient$params$DefaultHttpParams;
    }
  }
  
  public DefaultHttpParams()
  {
    this(getDefaultParams());
  }
  
  public DefaultHttpParams(HttpParams paramHttpParams)
  {
    this.defaults = paramHttpParams;
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
  
  public static HttpParams getDefaultParams()
  {
    return httpParamsFactory.getDefaultParams();
  }
  
  public static void setHttpParamsFactory(HttpParamsFactory paramHttpParamsFactory)
  {
    if (paramHttpParamsFactory == null) {
      throw new IllegalArgumentException("httpParamsFactory may not be null");
    }
    httpParamsFactory = paramHttpParamsFactory;
  }
  
  public void clear()
  {
    this.parameters = null;
  }
  
  public Object clone()
    throws CloneNotSupportedException
  {
    DefaultHttpParams localDefaultHttpParams = (DefaultHttpParams)super.clone();
    if (this.parameters != null) {
      localDefaultHttpParams.parameters = ((HashMap)this.parameters.clone());
    }
    localDefaultHttpParams.setDefaults(this.defaults);
    return localDefaultHttpParams;
  }
  
  public boolean getBooleanParameter(String paramString, boolean paramBoolean)
  {
    Object localObject = getParameter(paramString);
    if (localObject == null) {
      return paramBoolean;
    }
    return ((Boolean)localObject).booleanValue();
  }
  
  public HttpParams getDefaults()
  {
    try
    {
      HttpParams localHttpParams = this.defaults;
      return localHttpParams;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public double getDoubleParameter(String paramString, double paramDouble)
  {
    Object localObject = getParameter(paramString);
    if (localObject == null) {
      return paramDouble;
    }
    return ((Double)localObject).doubleValue();
  }
  
  public int getIntParameter(String paramString, int paramInt)
  {
    Object localObject = getParameter(paramString);
    if (localObject == null) {
      return paramInt;
    }
    return ((Integer)localObject).intValue();
  }
  
  public long getLongParameter(String paramString, long paramLong)
  {
    Object localObject = getParameter(paramString);
    if (localObject == null) {
      return paramLong;
    }
    return ((Long)localObject).longValue();
  }
  
  /* Error */
  public Object getParameter(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 57	org/apache/commons/httpclient/params/DefaultHttpParams:parameters	Ljava/util/HashMap;
    //   6: astore_3
    //   7: aconst_null
    //   8: astore 4
    //   10: aload_3
    //   11: ifnull +17 -> 28
    //   14: aload_0
    //   15: getfield 57	org/apache/commons/httpclient/params/DefaultHttpParams:parameters	Ljava/util/HashMap;
    //   18: aload_1
    //   19: invokevirtual 139	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   22: astore 5
    //   24: aload 5
    //   26: astore 4
    //   28: aload 4
    //   30: ifnull +8 -> 38
    //   33: aload_0
    //   34: monitorexit
    //   35: aload 4
    //   37: areturn
    //   38: aload_0
    //   39: getfield 55	org/apache/commons/httpclient/params/DefaultHttpParams:defaults	Lorg/apache/commons/httpclient/params/HttpParams;
    //   42: ifnull +22 -> 64
    //   45: aload_0
    //   46: getfield 55	org/apache/commons/httpclient/params/DefaultHttpParams:defaults	Lorg/apache/commons/httpclient/params/HttpParams;
    //   49: aload_1
    //   50: invokeinterface 140 2 0
    //   55: astore 6
    //   57: aload 6
    //   59: astore 4
    //   61: goto -28 -> 33
    //   64: aconst_null
    //   65: astore 4
    //   67: goto -34 -> 33
    //   70: astore_2
    //   71: aload_0
    //   72: monitorexit
    //   73: aload_2
    //   74: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	75	0	this	DefaultHttpParams
    //   0	75	1	paramString	String
    //   70	4	2	localObject1	Object
    //   6	5	3	localHashMap	HashMap
    //   8	58	4	localObject2	Object
    //   22	3	5	localObject3	Object
    //   55	3	6	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	70	finally
    //   14	24	70	finally
    //   38	57	70	finally
  }
  
  public boolean isParameterFalse(String paramString)
  {
    boolean bool1 = getBooleanParameter(paramString, false);
    boolean bool2 = false;
    if (!bool1) {
      bool2 = true;
    }
    return bool2;
  }
  
  public boolean isParameterSet(String paramString)
  {
    return getParameter(paramString) != null;
  }
  
  public boolean isParameterSetLocally(String paramString)
  {
    return (this.parameters != null) && (this.parameters.get(paramString) != null);
  }
  
  public boolean isParameterTrue(String paramString)
  {
    return getBooleanParameter(paramString, false);
  }
  
  public void setBooleanParameter(String paramString, boolean paramBoolean)
  {
    setParameter(paramString, new Boolean(paramBoolean));
  }
  
  public void setDefaults(HttpParams paramHttpParams)
  {
    try
    {
      this.defaults = paramHttpParams;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void setDoubleParameter(String paramString, double paramDouble)
  {
    setParameter(paramString, new Double(paramDouble));
  }
  
  public void setIntParameter(String paramString, int paramInt)
  {
    setParameter(paramString, new Integer(paramInt));
  }
  
  public void setLongParameter(String paramString, long paramLong)
  {
    setParameter(paramString, new Long(paramLong));
  }
  
  public void setParameter(String paramString, Object paramObject)
  {
    try
    {
      if (this.parameters == null) {
        this.parameters = new HashMap();
      }
      this.parameters.put(paramString, paramObject);
      if (LOG.isDebugEnabled()) {
        LOG.debug("Set parameter " + paramString + " = " + paramObject);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public void setParameters(String[] paramArrayOfString, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore_3
    //   4: aload_1
    //   5: arraylength
    //   6: istore 5
    //   8: iload_3
    //   9: iload 5
    //   11: if_icmplt +6 -> 17
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: aload_1
    //   19: iload_3
    //   20: aaload
    //   21: aload_2
    //   22: invokevirtual 156	org/apache/commons/httpclient/params/DefaultHttpParams:setParameter	(Ljava/lang/String;Ljava/lang/Object;)V
    //   25: iinc 3 1
    //   28: goto -24 -> 4
    //   31: astore 4
    //   33: aload_0
    //   34: monitorexit
    //   35: aload 4
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	DefaultHttpParams
    //   0	38	1	paramArrayOfString	String[]
    //   0	38	2	paramObject	Object
    //   3	23	3	i	int
    //   31	5	4	localObject	Object
    //   6	6	5	j	int
    // Exception table:
    //   from	to	target	type
    //   4	8	31	finally
    //   17	25	31	finally
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.params.DefaultHttpParams
 * JD-Core Version:    0.7.0.1
 */