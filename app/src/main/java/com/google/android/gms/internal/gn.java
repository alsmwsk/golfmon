package com.google.android.gms.internal;

import java.io.InputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@ey
public class gn
{
  public static final a<Void> wN = new a()
  {
    public Void c(InputStream paramAnonymousInputStream)
    {
      return null;
    }
    
    public Void dz()
    {
      return null;
    }
  };
  
  public <T> Future<T> a(final String paramString, final a<T> parama)
  {
    gh.submit(new Callable()
    {
      /* Error */
      public T call()
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore_1
        //   2: new 37	java/net/URL
        //   5: dup
        //   6: aload_0
        //   7: getfield 24	com/google/android/gms/internal/gn$2:wO	Ljava/lang/String;
        //   10: invokespecial 40	java/net/URL:<init>	(Ljava/lang/String;)V
        //   13: invokevirtual 44	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   16: checkcast 46	java/net/HttpURLConnection
        //   19: astore 5
        //   21: aload 5
        //   23: invokevirtual 49	java/net/HttpURLConnection:connect	()V
        //   26: aload 5
        //   28: invokevirtual 53	java/net/HttpURLConnection:getResponseCode	()I
        //   31: istore 9
        //   33: iload 9
        //   35: sipush 200
        //   38: if_icmplt +40 -> 78
        //   41: iload 9
        //   43: sipush 299
        //   46: if_icmpgt +32 -> 78
        //   49: aload_0
        //   50: getfield 26	com/google/android/gms/internal/gn$2:wP	Lcom/google/android/gms/internal/gn$a;
        //   53: aload 5
        //   55: invokevirtual 57	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   58: invokeinterface 63 2 0
        //   63: astore 10
        //   65: aload 5
        //   67: ifnull +8 -> 75
        //   70: aload 5
        //   72: invokevirtual 66	java/net/HttpURLConnection:disconnect	()V
        //   75: aload 10
        //   77: areturn
        //   78: aload 5
        //   80: ifnull +8 -> 88
        //   83: aload 5
        //   85: invokevirtual 66	java/net/HttpURLConnection:disconnect	()V
        //   88: aload_0
        //   89: getfield 26	com/google/android/gms/internal/gn$2:wP	Lcom/google/android/gms/internal/gn$a;
        //   92: invokeinterface 69 1 0
        //   97: areturn
        //   98: astore 4
        //   100: ldc 71
        //   102: aload 4
        //   104: invokestatic 77	com/google/android/gms/internal/gr:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   107: aload_1
        //   108: ifnull -20 -> 88
        //   111: aload_1
        //   112: invokevirtual 66	java/net/HttpURLConnection:disconnect	()V
        //   115: goto -27 -> 88
        //   118: astore_3
        //   119: ldc 71
        //   121: aload_3
        //   122: invokestatic 77	com/google/android/gms/internal/gr:d	(Ljava/lang/String;Ljava/lang/Throwable;)V
        //   125: aload_1
        //   126: ifnull -38 -> 88
        //   129: aload_1
        //   130: invokevirtual 66	java/net/HttpURLConnection:disconnect	()V
        //   133: goto -45 -> 88
        //   136: astore_2
        //   137: aload_1
        //   138: ifnull +7 -> 145
        //   141: aload_1
        //   142: invokevirtual 66	java/net/HttpURLConnection:disconnect	()V
        //   145: aload_2
        //   146: athrow
        //   147: astore 8
        //   149: aload 5
        //   151: astore_1
        //   152: aload 8
        //   154: astore_2
        //   155: goto -18 -> 137
        //   158: astore 7
        //   160: aload 5
        //   162: astore_1
        //   163: aload 7
        //   165: astore_3
        //   166: goto -47 -> 119
        //   169: astore 6
        //   171: aload 5
        //   173: astore_1
        //   174: aload 6
        //   176: astore 4
        //   178: goto -78 -> 100
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	181	0	this	2
        //   1	173	1	localObject1	Object
        //   136	10	2	localObject2	Object
        //   154	1	2	localObject3	Object
        //   118	4	3	localIOException1	java.io.IOException
        //   165	1	3	localObject4	Object
        //   98	5	4	localMalformedURLException1	java.net.MalformedURLException
        //   176	1	4	localObject5	Object
        //   19	153	5	localHttpURLConnection	java.net.HttpURLConnection
        //   169	6	6	localMalformedURLException2	java.net.MalformedURLException
        //   158	6	7	localIOException2	java.io.IOException
        //   147	6	8	localObject6	Object
        //   31	16	9	i	int
        //   63	13	10	localObject7	Object
        // Exception table:
        //   from	to	target	type
        //   2	21	98	java/net/MalformedURLException
        //   2	21	118	java/io/IOException
        //   2	21	136	finally
        //   100	107	136	finally
        //   119	125	136	finally
        //   21	33	147	finally
        //   49	65	147	finally
        //   21	33	158	java/io/IOException
        //   49	65	158	java/io/IOException
        //   21	33	169	java/net/MalformedURLException
        //   49	65	169	java/net/MalformedURLException
      }
    });
  }
  
  public static abstract interface a<T>
  {
    public abstract T b(InputStream paramInputStream);
    
    public abstract T cQ();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gn
 * JD-Core Version:    0.7.0.1
 */