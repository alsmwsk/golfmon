package org.apache.commons.httpclient.protocol;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.commons.httpclient.ConnectTimeoutException;

public final class ReflectionSocketFactory
{
  private static Constructor INETSOCKETADDRESS_CONSTRUCTOR;
  private static boolean REFLECTION_FAILED = false;
  private static Method SOCKETBIND_METHOD = null;
  private static Method SOCKETCONNECT_METHOD;
  private static Class SOCKETTIMEOUTEXCEPTION_CLASS = null;
  static Class class$java$net$InetAddress;
  static Class class$java$net$Socket;
  
  static
  {
    INETSOCKETADDRESS_CONSTRUCTOR = null;
    SOCKETCONNECT_METHOD = null;
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
  
  public static Socket createSocket(String paramString1, String paramString2, int paramInt1, InetAddress paramInetAddress, int paramInt2, int paramInt3)
    throws IOException, UnknownHostException, ConnectTimeoutException
  {
    if (REFLECTION_FAILED) {
      return null;
    }
    try
    {
      Class localClass1 = Class.forName(paramString1);
      Object localObject1 = localClass1.getMethod("getDefault", new Class[0]).invoke(null, new Object[0]);
      Socket localSocket = (Socket)localClass1.getMethod("createSocket", new Class[0]).invoke(localObject1, new Object[0]);
      if (INETSOCKETADDRESS_CONSTRUCTOR == null)
      {
        Class localClass4 = Class.forName("java.net.InetSocketAddress");
        Class[] arrayOfClass3 = new Class[2];
        if (class$java$net$InetAddress == null)
        {
          localClass5 = class$("java.net.InetAddress");
          class$java$net$InetAddress = localClass5;
          arrayOfClass3[0] = localClass5;
          arrayOfClass3[1] = Integer.TYPE;
          INETSOCKETADDRESS_CONSTRUCTOR = localClass4.getConstructor(arrayOfClass3);
        }
      }
      else
      {
        Constructor localConstructor1 = INETSOCKETADDRESS_CONSTRUCTOR;
        Object[] arrayOfObject1 = new Object[2];
        arrayOfObject1[0] = InetAddress.getByName(paramString2);
        arrayOfObject1[1] = new Integer(paramInt1);
        Object localObject2 = localConstructor1.newInstance(arrayOfObject1);
        Constructor localConstructor2 = INETSOCKETADDRESS_CONSTRUCTOR;
        Object[] arrayOfObject2 = new Object[2];
        arrayOfObject2[0] = paramInetAddress;
        arrayOfObject2[1] = new Integer(paramInt2);
        Object localObject3 = localConstructor2.newInstance(arrayOfObject2);
        if (SOCKETCONNECT_METHOD == null)
        {
          if (class$java$net$Socket != null) {
            break label445;
          }
          localClass3 = class$("java.net.Socket");
          class$java$net$Socket = localClass3;
          Class[] arrayOfClass2 = new Class[2];
          arrayOfClass2[0] = Class.forName("java.net.SocketAddress");
          arrayOfClass2[1] = Integer.TYPE;
          SOCKETCONNECT_METHOD = localClass3.getMethod("connect", arrayOfClass2);
        }
        if (SOCKETBIND_METHOD == null)
        {
          if (class$java$net$Socket != null) {
            break label453;
          }
          localClass2 = class$("java.net.Socket");
          class$java$net$Socket = localClass2;
          Class[] arrayOfClass1 = new Class[1];
          arrayOfClass1[0] = Class.forName("java.net.SocketAddress");
          SOCKETBIND_METHOD = localClass2.getMethod("bind", arrayOfClass1);
        }
        SOCKETBIND_METHOD.invoke(localSocket, new Object[] { localObject3 });
        Method localMethod = SOCKETCONNECT_METHOD;
        Object[] arrayOfObject3 = new Object[2];
        arrayOfObject3[0] = localObject2;
        arrayOfObject3[1] = new Integer(paramInt3);
        localMethod.invoke(localSocket, arrayOfObject3);
        return localSocket;
      }
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Throwable localThrowable;
      for (;;)
      {
        localThrowable = localInvocationTargetException.getTargetException();
        if (SOCKETTIMEOUTEXCEPTION_CLASS == null) {}
        try
        {
          SOCKETTIMEOUTEXCEPTION_CLASS = Class.forName("java.net.SocketTimeoutException");
          if (!SOCKETTIMEOUTEXCEPTION_CLASS.isInstance(localThrowable)) {
            break;
          }
          throw new ConnectTimeoutException("The host did not accept the connection within timeout of " + paramInt3 + " ms", localThrowable);
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          REFLECTION_FAILED = true;
          return null;
        }
        Class localClass5 = class$java$net$InetAddress;
        continue;
        Class localClass3 = class$java$net$Socket;
        continue;
        Class localClass2 = class$java$net$Socket;
      }
      if ((localThrowable instanceof IOException)) {
        throw ((IOException)localThrowable);
      }
      return null;
    }
    catch (Exception localException)
    {
      label445:
      label453:
      REFLECTION_FAILED = true;
    }
    return null;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     org.apache.commons.httpclient.protocol.ReflectionSocketFactory
 * JD-Core Version:    0.7.0.1
 */