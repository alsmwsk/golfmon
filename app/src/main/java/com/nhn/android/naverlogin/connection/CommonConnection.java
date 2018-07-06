package com.nhn.android.naverlogin.connection;

import android.content.Context;
import android.util.Log;
import com.nhn.android.naverlogin.OAuthLoginDefine;
import com.nhn.android.naverlogin.util.DeviceAppInfo;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class CommonConnection
{
  private static final String TAG = "NaverLoginOAuth|CommonConnection";
  protected static boolean mCancel;
  protected static DefaultHttpClient mHttpClient = null;
  
  public static void cancel()
  {
    mCancel = true;
    if (mHttpClient != null)
    {
      Log.e("NaverLoginOAuth|CommonConnection", "httpclient operation canceled (shutdown)");
      mHttpClient.getConnectionManager().shutdown();
      mHttpClient = null;
    }
  }
  
  private static DefaultHttpClient getDefaultHttpClient()
  {
    DefaultHttpClient localDefaultHttpClient = new DefaultHttpClient();
    HttpParams localHttpParams = localDefaultHttpClient.getParams();
    HttpConnectionParams.setConnectionTimeout(localHttpParams, OAuthLoginDefine.TIMEOUT);
    HttpConnectionParams.setSoTimeout(localHttpParams, OAuthLoginDefine.TIMEOUT);
    ConnManagerParams.setTimeout(localHttpParams, OAuthLoginDefine.TIMEOUT);
    return localDefaultHttpClient;
  }
  
  public static DefaultHttpClient getDefaultHttpClient(Context paramContext)
  {
    return getDefaultHttpClient(DeviceAppInfo.getBaseInstance().getUserAgent(paramContext));
  }
  
  protected static DefaultHttpClient getDefaultHttpClient(String paramString)
  {
    DefaultHttpClient localDefaultHttpClient = getDefaultHttpClient();
    localDefaultHttpClient.getParams().setParameter("http.useragent", paramString);
    if (OAuthLoginDefine.DEVELOPER_VERSION) {
      Log.d("NaverLoginOAuth|CommonConnection", "user-agent:" + paramString);
    }
    return localDefaultHttpClient;
  }
  
  public static boolean isBusy()
  {
    return mHttpClient != null;
  }
  
  public static ResponseData request(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return request(paramContext, paramString1, paramString2, paramString3, false);
  }
  
  public static ResponseData request(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    return request(paramContext, paramString1, paramString2, paramString3, paramString4, false);
  }
  
  /* Error */
  public static ResponseData request(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean)
  {
    // Byte code:
    //   0: new 133	com/nhn/android/naverlogin/connection/ResponseData
    //   3: dup
    //   4: invokespecial 134	com/nhn/android/naverlogin/connection/ResponseData:<init>	()V
    //   7: astore 6
    //   9: ldc 2
    //   11: monitorenter
    //   12: iload 5
    //   14: ifne +25 -> 39
    //   17: getstatic 16	com/nhn/android/naverlogin/connection/CommonConnection:mHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   20: ifnull +19 -> 39
    //   23: aload 6
    //   25: getstatic 140	com/nhn/android/naverlogin/connection/ResponseData$ResponseDataStat:BUSY	Lcom/nhn/android/naverlogin/connection/ResponseData$ResponseDataStat;
    //   28: ldc 142
    //   30: invokevirtual 146	com/nhn/android/naverlogin/connection/ResponseData:setResultCode	(Lcom/nhn/android/naverlogin/connection/ResponseData$ResponseDataStat;Ljava/lang/String;)V
    //   33: ldc 2
    //   35: monitorexit
    //   36: aload 6
    //   38: areturn
    //   39: getstatic 96	com/nhn/android/naverlogin/OAuthLoginDefine:DEVELOPER_VERSION	Z
    //   42: ifeq +25 -> 67
    //   45: ldc 8
    //   47: new 98	java/lang/StringBuilder
    //   50: dup
    //   51: ldc 148
    //   53: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   56: aload_1
    //   57: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 114	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   66: pop
    //   67: aload_1
    //   68: ifnull +10 -> 78
    //   71: aload_1
    //   72: invokevirtual 154	java/lang/String:length	()I
    //   75: ifne +27 -> 102
    //   78: aload 6
    //   80: getstatic 157	com/nhn/android/naverlogin/connection/ResponseData$ResponseDataStat:URL_ERROR	Lcom/nhn/android/naverlogin/connection/ResponseData$ResponseDataStat;
    //   83: ldc 159
    //   85: invokevirtual 146	com/nhn/android/naverlogin/connection/ResponseData:setResultCode	(Lcom/nhn/android/naverlogin/connection/ResponseData$ResponseDataStat;Ljava/lang/String;)V
    //   88: ldc 2
    //   90: monitorexit
    //   91: aload 6
    //   93: areturn
    //   94: astore 7
    //   96: ldc 2
    //   98: monitorexit
    //   99: aload 7
    //   101: athrow
    //   102: iload 5
    //   104: ifeq +198 -> 302
    //   107: aload_3
    //   108: ifnull +185 -> 293
    //   111: aload_3
    //   112: invokevirtual 154	java/lang/String:length	()I
    //   115: ifle +178 -> 293
    //   118: aload_3
    //   119: invokestatic 83	com/nhn/android/naverlogin/connection/CommonConnection:getDefaultHttpClient	(Ljava/lang/String;)Lorg/apache/http/impl/client/DefaultHttpClient;
    //   122: astore 8
    //   124: iconst_0
    //   125: putstatic 22	com/nhn/android/naverlogin/connection/CommonConnection:mCancel	Z
    //   128: ldc 2
    //   130: monitorexit
    //   131: new 161	org/apache/http/client/methods/HttpGet
    //   134: dup
    //   135: aload_1
    //   136: invokespecial 162	org/apache/http/client/methods/HttpGet:<init>	(Ljava/lang/String;)V
    //   139: astore 9
    //   141: aload_2
    //   142: ifnull +18 -> 160
    //   145: aload_2
    //   146: invokevirtual 154	java/lang/String:length	()I
    //   149: ifle +11 -> 160
    //   152: aload 9
    //   154: ldc 164
    //   156: aload_2
    //   157: invokevirtual 168	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: aload 4
    //   162: ifnull +48 -> 210
    //   165: aload 9
    //   167: ldc 170
    //   169: invokevirtual 173	org/apache/http/client/methods/HttpGet:removeHeaders	(Ljava/lang/String;)V
    //   172: aload 9
    //   174: ldc 170
    //   176: aload 4
    //   178: invokevirtual 176	org/apache/http/client/methods/HttpGet:setHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   181: getstatic 96	com/nhn/android/naverlogin/OAuthLoginDefine:DEVELOPER_VERSION	Z
    //   184: ifeq +26 -> 210
    //   187: ldc 8
    //   189: new 98	java/lang/StringBuilder
    //   192: dup
    //   193: ldc 178
    //   195: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   198: aload 4
    //   200: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: invokestatic 114	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   209: pop
    //   210: iload 5
    //   212: ifeq +127 -> 339
    //   215: aload 8
    //   217: aload 9
    //   219: invokevirtual 182	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   222: astore 18
    //   224: aload 18
    //   226: astore 11
    //   228: aload 11
    //   230: ifnull +15 -> 245
    //   233: aload 6
    //   235: aload 11
    //   237: aload 11
    //   239: invokestatic 188	com/nhn/android/naverlogin/util/CookieUtil:getCookie	(Lorg/apache/http/HttpResponse;)Ljava/lang/String;
    //   242: invokevirtual 192	com/nhn/android/naverlogin/connection/ResponseData:setResponseData	(Lorg/apache/http/HttpResponse;Ljava/lang/String;)V
    //   245: iload 5
    //   247: ifeq +225 -> 472
    //   250: aload 8
    //   252: invokevirtual 36	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   255: invokeinterface 41 1 0
    //   260: iload 5
    //   262: ifeq +263 -> 525
    //   265: getstatic 22	com/nhn/android/naverlogin/connection/CommonConnection:mCancel	Z
    //   268: ifeq +279 -> 547
    //   271: new 133	com/nhn/android/naverlogin/connection/ResponseData
    //   274: dup
    //   275: invokespecial 134	com/nhn/android/naverlogin/connection/ResponseData:<init>	()V
    //   278: astore 14
    //   280: aload 14
    //   282: getstatic 195	com/nhn/android/naverlogin/connection/ResponseData$ResponseDataStat:CANCEL	Lcom/nhn/android/naverlogin/connection/ResponseData$ResponseDataStat;
    //   285: ldc 197
    //   287: invokevirtual 146	com/nhn/android/naverlogin/connection/ResponseData:setResultCode	(Lcom/nhn/android/naverlogin/connection/ResponseData$ResponseDataStat;Ljava/lang/String;)V
    //   290: aload 14
    //   292: areturn
    //   293: aload_0
    //   294: invokestatic 199	com/nhn/android/naverlogin/connection/CommonConnection:getDefaultHttpClient	(Landroid/content/Context;)Lorg/apache/http/impl/client/DefaultHttpClient;
    //   297: astore 8
    //   299: goto -175 -> 124
    //   302: aload_3
    //   303: ifnull +23 -> 326
    //   306: aload_3
    //   307: invokevirtual 154	java/lang/String:length	()I
    //   310: ifle +16 -> 326
    //   313: aload_3
    //   314: invokestatic 83	com/nhn/android/naverlogin/connection/CommonConnection:getDefaultHttpClient	(Ljava/lang/String;)Lorg/apache/http/impl/client/DefaultHttpClient;
    //   317: putstatic 16	com/nhn/android/naverlogin/connection/CommonConnection:mHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   320: aconst_null
    //   321: astore 8
    //   323: goto -199 -> 124
    //   326: aload_0
    //   327: invokestatic 199	com/nhn/android/naverlogin/connection/CommonConnection:getDefaultHttpClient	(Landroid/content/Context;)Lorg/apache/http/impl/client/DefaultHttpClient;
    //   330: putstatic 16	com/nhn/android/naverlogin/connection/CommonConnection:mHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   333: aconst_null
    //   334: astore 8
    //   336: goto -212 -> 124
    //   339: getstatic 16	com/nhn/android/naverlogin/connection/CommonConnection:mHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   342: aload 9
    //   344: invokevirtual 182	org/apache/http/impl/client/DefaultHttpClient:execute	(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    //   347: astore 19
    //   349: aload 19
    //   351: astore 11
    //   353: goto -125 -> 228
    //   356: astore 10
    //   358: aload 6
    //   360: getstatic 202	com/nhn/android/naverlogin/connection/ResponseData$ResponseDataStat:CONNECTION_TIMEOUT	Lcom/nhn/android/naverlogin/connection/ResponseData$ResponseDataStat;
    //   363: aload 10
    //   365: invokevirtual 205	org/apache/http/conn/ConnectTimeoutException:getMessage	()Ljava/lang/String;
    //   368: invokevirtual 146	com/nhn/android/naverlogin/connection/ResponseData:setResultCode	(Lcom/nhn/android/naverlogin/connection/ResponseData$ResponseDataStat;Ljava/lang/String;)V
    //   371: aload 10
    //   373: invokevirtual 208	org/apache/http/conn/ConnectTimeoutException:printStackTrace	()V
    //   376: aconst_null
    //   377: astore 11
    //   379: goto -151 -> 228
    //   382: astore 16
    //   384: aload 6
    //   386: getstatic 211	com/nhn/android/naverlogin/connection/ResponseData$ResponseDataStat:NO_PEER_CERTIFICATE	Lcom/nhn/android/naverlogin/connection/ResponseData$ResponseDataStat;
    //   389: aload 16
    //   391: invokevirtual 212	javax/net/ssl/SSLPeerUnverifiedException:getMessage	()Ljava/lang/String;
    //   394: invokevirtual 146	com/nhn/android/naverlogin/connection/ResponseData:setResultCode	(Lcom/nhn/android/naverlogin/connection/ResponseData$ResponseDataStat;Ljava/lang/String;)V
    //   397: aload 16
    //   399: invokevirtual 213	javax/net/ssl/SSLPeerUnverifiedException:printStackTrace	()V
    //   402: aconst_null
    //   403: astore 11
    //   405: goto -177 -> 228
    //   408: astore 17
    //   410: aload 6
    //   412: getstatic 216	com/nhn/android/naverlogin/connection/ResponseData$ResponseDataStat:CONNECTION_FAIL	Lcom/nhn/android/naverlogin/connection/ResponseData$ResponseDataStat;
    //   415: aload 17
    //   417: invokevirtual 217	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   420: invokevirtual 146	com/nhn/android/naverlogin/connection/ResponseData:setResultCode	(Lcom/nhn/android/naverlogin/connection/ResponseData$ResponseDataStat;Ljava/lang/String;)V
    //   423: aload 17
    //   425: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   428: aconst_null
    //   429: astore 11
    //   431: goto -203 -> 228
    //   434: astore 15
    //   436: aload 6
    //   438: getstatic 221	com/nhn/android/naverlogin/connection/ResponseData$ResponseDataStat:FAIL	Lcom/nhn/android/naverlogin/connection/ResponseData$ResponseDataStat;
    //   441: new 98	java/lang/StringBuilder
    //   444: dup
    //   445: ldc 223
    //   447: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   450: aload 15
    //   452: invokevirtual 217	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   455: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: invokevirtual 111	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokevirtual 146	com/nhn/android/naverlogin/connection/ResponseData:setResultCode	(Lcom/nhn/android/naverlogin/connection/ResponseData$ResponseDataStat;Ljava/lang/String;)V
    //   464: aload 15
    //   466: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   469: goto -224 -> 245
    //   472: getstatic 16	com/nhn/android/naverlogin/connection/CommonConnection:mHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   475: invokevirtual 36	org/apache/http/impl/client/DefaultHttpClient:getConnectionManager	()Lorg/apache/http/conn/ClientConnectionManager;
    //   478: invokeinterface 41 1 0
    //   483: goto -223 -> 260
    //   486: astore 13
    //   488: aload 13
    //   490: invokevirtual 218	java/lang/Exception:printStackTrace	()V
    //   493: iload 5
    //   495: ifeq +6 -> 501
    //   498: goto -233 -> 265
    //   501: aconst_null
    //   502: putstatic 16	com/nhn/android/naverlogin/connection/CommonConnection:mHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   505: goto -240 -> 265
    //   508: astore 12
    //   510: iload 5
    //   512: ifeq +6 -> 518
    //   515: aload 12
    //   517: athrow
    //   518: aconst_null
    //   519: putstatic 16	com/nhn/android/naverlogin/connection/CommonConnection:mHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   522: goto -7 -> 515
    //   525: aconst_null
    //   526: putstatic 16	com/nhn/android/naverlogin/connection/CommonConnection:mHttpClient	Lorg/apache/http/impl/client/DefaultHttpClient;
    //   529: goto -264 -> 265
    //   532: astore 17
    //   534: goto -124 -> 410
    //   537: astore 16
    //   539: goto -155 -> 384
    //   542: astore 10
    //   544: goto -186 -> 358
    //   547: aload 6
    //   549: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	550	0	paramContext	Context
    //   0	550	1	paramString1	String
    //   0	550	2	paramString2	String
    //   0	550	3	paramString3	String
    //   0	550	4	paramString4	String
    //   0	550	5	paramBoolean	boolean
    //   7	541	6	localResponseData1	ResponseData
    //   94	6	7	localObject1	Object
    //   122	213	8	localDefaultHttpClient	DefaultHttpClient
    //   139	204	9	localHttpGet	org.apache.http.client.methods.HttpGet
    //   356	16	10	localConnectTimeoutException1	org.apache.http.conn.ConnectTimeoutException
    //   542	1	10	localConnectTimeoutException2	org.apache.http.conn.ConnectTimeoutException
    //   226	204	11	localObject2	Object
    //   508	8	12	localObject3	Object
    //   486	3	13	localException1	java.lang.Exception
    //   278	13	14	localResponseData2	ResponseData
    //   434	31	15	localException2	java.lang.Exception
    //   382	16	16	localSSLPeerUnverifiedException1	javax.net.ssl.SSLPeerUnverifiedException
    //   537	1	16	localSSLPeerUnverifiedException2	javax.net.ssl.SSLPeerUnverifiedException
    //   408	16	17	localException3	java.lang.Exception
    //   532	1	17	localException4	java.lang.Exception
    //   222	3	18	localHttpResponse1	org.apache.http.HttpResponse
    //   347	3	19	localHttpResponse2	org.apache.http.HttpResponse
    // Exception table:
    //   from	to	target	type
    //   17	36	94	finally
    //   39	67	94	finally
    //   71	78	94	finally
    //   78	91	94	finally
    //   96	99	94	finally
    //   111	124	94	finally
    //   124	131	94	finally
    //   293	299	94	finally
    //   306	320	94	finally
    //   326	333	94	finally
    //   131	141	356	org/apache/http/conn/ConnectTimeoutException
    //   131	141	382	javax/net/ssl/SSLPeerUnverifiedException
    //   131	141	408	java/lang/Exception
    //   233	245	434	java/lang/Exception
    //   250	260	486	java/lang/Exception
    //   472	483	486	java/lang/Exception
    //   250	260	508	finally
    //   472	483	508	finally
    //   488	493	508	finally
    //   145	160	532	java/lang/Exception
    //   165	210	532	java/lang/Exception
    //   215	224	532	java/lang/Exception
    //   339	349	532	java/lang/Exception
    //   145	160	537	javax/net/ssl/SSLPeerUnverifiedException
    //   165	210	537	javax/net/ssl/SSLPeerUnverifiedException
    //   215	224	537	javax/net/ssl/SSLPeerUnverifiedException
    //   339	349	537	javax/net/ssl/SSLPeerUnverifiedException
    //   145	160	542	org/apache/http/conn/ConnectTimeoutException
    //   165	210	542	org/apache/http/conn/ConnectTimeoutException
    //   215	224	542	org/apache/http/conn/ConnectTimeoutException
    //   339	349	542	org/apache/http/conn/ConnectTimeoutException
  }
  
  public static ResponseData request(Context paramContext, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    return request(paramContext, paramString1, paramString2, paramString3, null, paramBoolean);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nhn.android.naverlogin.connection.CommonConnection
 * JD-Core Version:    0.7.0.1
 */