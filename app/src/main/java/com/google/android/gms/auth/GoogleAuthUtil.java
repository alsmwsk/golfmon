package com.google.android.gms.auth;

import android.accounts.AccountManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.internal.ii;
import com.google.android.gms.internal.jx;
import java.io.IOException;
import java.net.URISyntaxException;

public final class GoogleAuthUtil
{
  public static final int CHANGE_TYPE_ACCOUNT_ADDED = 1;
  public static final int CHANGE_TYPE_ACCOUNT_REMOVED = 2;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_FROM = 3;
  public static final int CHANGE_TYPE_ACCOUNT_RENAMED_TO = 4;
  private static final ComponentName Ek;
  private static final ComponentName El;
  private static final Intent Em;
  private static final Intent En;
  public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
  public static final String KEY_ANDROID_PACKAGE_NAME;
  public static final String KEY_CALLER_UID;
  public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";
  @Deprecated
  public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
  public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
  
  static
  {
    String str1;
    if (Build.VERSION.SDK_INT >= 11)
    {
      str1 = "callerUid";
      KEY_CALLER_UID = str1;
      if (Build.VERSION.SDK_INT < 14) {
        break label107;
      }
    }
    label107:
    for (String str2 = "androidPackageName";; str2 = "androidPackageName")
    {
      KEY_ANDROID_PACKAGE_NAME = str2;
      Ek = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
      El = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
      Em = new Intent().setPackage("com.google.android.gms").setComponent(Ek);
      En = new Intent().setPackage("com.google.android.gms").setComponent(El);
      return;
      str1 = "callerUid";
      break;
    }
  }
  
  private static void C(Context paramContext)
    throws GoogleAuthException
  {
    try
    {
      GooglePlayServicesUtil.C(paramContext);
      return;
    }
    catch (GooglePlayServicesRepairableException localGooglePlayServicesRepairableException)
    {
      throw new GooglePlayServicesAvailabilityException(localGooglePlayServicesRepairableException.getConnectionStatusCode(), localGooglePlayServicesRepairableException.getMessage(), localGooglePlayServicesRepairableException.getIntent());
    }
    catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException)
    {
      throw new GoogleAuthException(localGooglePlayServicesNotAvailableException.getMessage());
    }
  }
  
  private static String a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, GoogleAuthException
  {
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    try
    {
      String str = getToken(paramContext, paramString1, paramString2, paramBundle);
      return str;
    }
    catch (GooglePlayServicesAvailabilityException localGooglePlayServicesAvailabilityException)
    {
      GooglePlayServicesUtil.showErrorNotification(localGooglePlayServicesAvailabilityException.getConnectionStatusCode(), paramContext);
      throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
    }
    catch (UserRecoverableAuthException localUserRecoverableAuthException)
    {
      throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
    }
  }
  
  private static boolean ax(String paramString)
  {
    return ("NetworkError".equals(paramString)) || ("ServiceUnavailable".equals(paramString)) || ("Timeout".equals(paramString));
  }
  
  private static boolean ay(String paramString)
  {
    return ("BadAuthentication".equals(paramString)) || ("CaptchaRequired".equals(paramString)) || ("DeviceManagementRequiredOrSyncDisabled".equals(paramString)) || ("NeedPermission".equals(paramString)) || ("NeedsBrowser".equals(paramString)) || ("UserCancel".equals(paramString)) || ("AppDownloadRequired".equals(paramString)) || (ii.EI.fO().equals(paramString)) || (ii.EJ.fO().equals(paramString)) || (ii.EK.fO().equals(paramString)) || (ii.EL.fO().equals(paramString)) || (ii.EM.fO().equals(paramString)) || (ii.EN.fO().equals(paramString));
  }
  
  /* Error */
  public static void clearToken(Context paramContext, String paramString)
    throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 201	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   4: astore_2
    //   5: ldc 203
    //   7: invokestatic 208	com/google/android/gms/internal/jx:aV	(Ljava/lang/String;)V
    //   10: aload_2
    //   11: invokestatic 209	com/google/android/gms/auth/GoogleAuthUtil:C	(Landroid/content/Context;)V
    //   14: new 122	android/os/Bundle
    //   17: dup
    //   18: invokespecial 123	android/os/Bundle:<init>	()V
    //   21: astore_3
    //   22: aload_0
    //   23: invokevirtual 213	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   26: getfield 218	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   29: astore 4
    //   31: aload_3
    //   32: ldc 220
    //   34: aload 4
    //   36: invokevirtual 223	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   39: aload_3
    //   40: getstatic 48	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   43: invokevirtual 226	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   46: ifne +12 -> 58
    //   49: aload_3
    //   50: getstatic 48	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   53: aload 4
    //   55: invokevirtual 223	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: new 228	com/google/android/gms/common/a
    //   61: dup
    //   62: invokespecial 229	com/google/android/gms/common/a:<init>	()V
    //   65: astore 5
    //   67: aload_2
    //   68: getstatic 78	com/google/android/gms/auth/GoogleAuthUtil:Em	Landroid/content/Intent;
    //   71: aload 5
    //   73: iconst_1
    //   74: invokevirtual 233	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   77: ifeq +107 -> 184
    //   80: aload 5
    //   82: invokevirtual 237	com/google/android/gms/common/a:gs	()Landroid/os/IBinder;
    //   85: invokestatic 242	com/google/android/gms/internal/r$a:a	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/r;
    //   88: aload_1
    //   89: aload_3
    //   90: invokeinterface 247 3 0
    //   95: astore 10
    //   97: aload 10
    //   99: getstatic 250	com/google/android/gms/internal/ii:Fk	Ljava/lang/String;
    //   102: invokevirtual 254	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   105: astore 11
    //   107: aload 10
    //   109: ldc_w 256
    //   112: invokevirtual 259	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   115: ifne +49 -> 164
    //   118: new 85	com/google/android/gms/auth/GoogleAuthException
    //   121: dup
    //   122: aload 11
    //   124: invokespecial 114	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   127: athrow
    //   128: astore 8
    //   130: ldc_w 261
    //   133: ldc_w 263
    //   136: aload 8
    //   138: invokestatic 269	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   141: pop
    //   142: new 118	java/io/IOException
    //   145: dup
    //   146: ldc_w 271
    //   149: invokespecial 272	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   152: athrow
    //   153: astore 7
    //   155: aload_2
    //   156: aload 5
    //   158: invokevirtual 276	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   161: aload 7
    //   163: athrow
    //   164: aload_2
    //   165: aload 5
    //   167: invokevirtual 276	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   170: return
    //   171: astore 6
    //   173: new 85	com/google/android/gms/auth/GoogleAuthException
    //   176: dup
    //   177: ldc_w 278
    //   180: invokespecial 114	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   183: athrow
    //   184: new 118	java/io/IOException
    //   187: dup
    //   188: ldc_w 280
    //   191: invokespecial 272	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   194: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	195	0	paramContext	Context
    //   0	195	1	paramString	String
    //   4	161	2	localContext	Context
    //   21	69	3	localBundle1	Bundle
    //   29	25	4	str1	String
    //   65	101	5	locala	com.google.android.gms.common.a
    //   171	1	6	localInterruptedException	java.lang.InterruptedException
    //   153	9	7	localObject	Object
    //   128	9	8	localRemoteException	android.os.RemoteException
    //   95	13	10	localBundle2	Bundle
    //   105	18	11	str2	String
    // Exception table:
    //   from	to	target	type
    //   80	128	128	android/os/RemoteException
    //   80	128	153	finally
    //   130	153	153	finally
    //   173	184	153	finally
    //   80	128	171	java/lang/InterruptedException
  }
  
  /* Error */
  public static java.util.List<AccountChangeEvent> getAccountChangeEvents(Context paramContext, int paramInt, String paramString)
    throws GoogleAuthException, IOException
  {
    // Byte code:
    //   0: aload_2
    //   1: ldc_w 284
    //   4: invokestatic 288	com/google/android/gms/internal/jx:b	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   7: pop
    //   8: ldc 203
    //   10: invokestatic 208	com/google/android/gms/internal/jx:aV	(Ljava/lang/String;)V
    //   13: aload_0
    //   14: invokevirtual 201	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   17: astore 4
    //   19: aload 4
    //   21: invokestatic 209	com/google/android/gms/auth/GoogleAuthUtil:C	(Landroid/content/Context;)V
    //   24: new 228	com/google/android/gms/common/a
    //   27: dup
    //   28: invokespecial 229	com/google/android/gms/common/a:<init>	()V
    //   31: astore 5
    //   33: aload 4
    //   35: getstatic 78	com/google/android/gms/auth/GoogleAuthUtil:Em	Landroid/content/Intent;
    //   38: aload 5
    //   40: iconst_1
    //   41: invokevirtual 233	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   44: ifeq +96 -> 140
    //   47: aload 5
    //   49: invokevirtual 237	com/google/android/gms/common/a:gs	()Landroid/os/IBinder;
    //   52: invokestatic 242	com/google/android/gms/internal/r$a:a	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/r;
    //   55: new 290	com/google/android/gms/auth/AccountChangeEventsRequest
    //   58: dup
    //   59: invokespecial 291	com/google/android/gms/auth/AccountChangeEventsRequest:<init>	()V
    //   62: aload_2
    //   63: invokevirtual 295	com/google/android/gms/auth/AccountChangeEventsRequest:setAccountName	(Ljava/lang/String;)Lcom/google/android/gms/auth/AccountChangeEventsRequest;
    //   66: iload_1
    //   67: invokevirtual 299	com/google/android/gms/auth/AccountChangeEventsRequest:setEventIndex	(I)Lcom/google/android/gms/auth/AccountChangeEventsRequest;
    //   70: invokeinterface 302 2 0
    //   75: invokevirtual 308	com/google/android/gms/auth/AccountChangeEventsResponse:getEvents	()Ljava/util/List;
    //   78: astore 10
    //   80: aload 4
    //   82: aload 5
    //   84: invokevirtual 276	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   87: aload 10
    //   89: areturn
    //   90: astore 8
    //   92: ldc_w 261
    //   95: ldc_w 263
    //   98: aload 8
    //   100: invokestatic 269	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   103: pop
    //   104: new 118	java/io/IOException
    //   107: dup
    //   108: ldc_w 271
    //   111: invokespecial 272	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   114: athrow
    //   115: astore 7
    //   117: aload 4
    //   119: aload 5
    //   121: invokevirtual 276	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   124: aload 7
    //   126: athrow
    //   127: astore 6
    //   129: new 85	com/google/android/gms/auth/GoogleAuthException
    //   132: dup
    //   133: ldc_w 278
    //   136: invokespecial 114	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   139: athrow
    //   140: new 118	java/io/IOException
    //   143: dup
    //   144: ldc_w 280
    //   147: invokespecial 272	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   150: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	paramContext	Context
    //   0	151	1	paramInt	int
    //   0	151	2	paramString	String
    //   17	101	4	localContext	Context
    //   31	89	5	locala	com.google.android.gms.common.a
    //   127	1	6	localInterruptedException	java.lang.InterruptedException
    //   115	10	7	localObject	Object
    //   90	9	8	localRemoteException	android.os.RemoteException
    //   78	10	10	localList	java.util.List
    // Exception table:
    //   from	to	target	type
    //   47	80	90	android/os/RemoteException
    //   47	80	115	finally
    //   92	115	115	finally
    //   129	140	115	finally
    //   47	80	127	java/lang/InterruptedException
  }
  
  public static String getAccountId(Context paramContext, String paramString)
    throws GoogleAuthException, IOException
  {
    jx.b(paramString, "accountName must be provided");
    jx.aV("Calling this from your main thread can lead to deadlock");
    C(paramContext.getApplicationContext());
    return getToken(paramContext, paramString, "^^_account_id_^^", new Bundle());
  }
  
  public static String getAppCert(Context paramContext, String paramString)
  {
    return "spatula";
  }
  
  public static String getToken(Context paramContext, String paramString1, String paramString2)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    return getToken(paramContext, paramString1, paramString2, new Bundle());
  }
  
  /* Error */
  public static String getToken(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, UserRecoverableAuthException, GoogleAuthException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 201	android/content/Context:getApplicationContext	()Landroid/content/Context;
    //   4: astore 4
    //   6: ldc 203
    //   8: invokestatic 208	com/google/android/gms/internal/jx:aV	(Ljava/lang/String;)V
    //   11: aload 4
    //   13: invokestatic 209	com/google/android/gms/auth/GoogleAuthUtil:C	(Landroid/content/Context;)V
    //   16: aload_3
    //   17: ifnonnull +155 -> 172
    //   20: new 122	android/os/Bundle
    //   23: dup
    //   24: invokespecial 123	android/os/Bundle:<init>	()V
    //   27: astore 5
    //   29: aload_0
    //   30: invokevirtual 213	android/content/Context:getApplicationInfo	()Landroid/content/pm/ApplicationInfo;
    //   33: getfield 218	android/content/pm/ApplicationInfo:packageName	Ljava/lang/String;
    //   36: astore 6
    //   38: aload 5
    //   40: ldc 220
    //   42: aload 6
    //   44: invokevirtual 223	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   47: aload 5
    //   49: getstatic 48	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   52: invokevirtual 226	android/os/Bundle:containsKey	(Ljava/lang/String;)Z
    //   55: ifne +13 -> 68
    //   58: aload 5
    //   60: getstatic 48	com/google/android/gms/auth/GoogleAuthUtil:KEY_ANDROID_PACKAGE_NAME	Ljava/lang/String;
    //   63: aload 6
    //   65: invokevirtual 223	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   68: new 228	com/google/android/gms/common/a
    //   71: dup
    //   72: invokespecial 229	com/google/android/gms/common/a:<init>	()V
    //   75: astore 7
    //   77: aload 4
    //   79: getstatic 78	com/google/android/gms/auth/GoogleAuthUtil:Em	Landroid/content/Intent;
    //   82: aload 7
    //   84: iconst_1
    //   85: invokevirtual 233	android/content/Context:bindService	(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    //   88: ifeq +213 -> 301
    //   91: aload 7
    //   93: invokevirtual 237	com/google/android/gms/common/a:gs	()Landroid/os/IBinder;
    //   96: invokestatic 242	com/google/android/gms/internal/r$a:a	(Landroid/os/IBinder;)Lcom/google/android/gms/internal/r;
    //   99: aload_1
    //   100: aload_2
    //   101: aload 5
    //   103: invokeinterface 319 4 0
    //   108: astore 12
    //   110: aload 12
    //   112: ifnonnull +73 -> 185
    //   115: ldc_w 261
    //   118: ldc_w 321
    //   121: invokestatic 325	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   124: pop
    //   125: new 85	com/google/android/gms/auth/GoogleAuthException
    //   128: dup
    //   129: ldc 148
    //   131: invokespecial 114	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   134: athrow
    //   135: astore 10
    //   137: ldc_w 261
    //   140: ldc_w 263
    //   143: aload 10
    //   145: invokestatic 269	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   148: pop
    //   149: new 118	java/io/IOException
    //   152: dup
    //   153: ldc_w 271
    //   156: invokespecial 272	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   159: athrow
    //   160: astore 9
    //   162: aload 4
    //   164: aload 7
    //   166: invokevirtual 276	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   169: aload 9
    //   171: athrow
    //   172: new 122	android/os/Bundle
    //   175: dup
    //   176: aload_3
    //   177: invokespecial 328	android/os/Bundle:<init>	(Landroid/os/Bundle;)V
    //   180: astore 5
    //   182: goto -153 -> 29
    //   185: aload 12
    //   187: ldc_w 330
    //   190: invokevirtual 254	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   193: astore 14
    //   195: aload 14
    //   197: invokestatic 336	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   200: istore 15
    //   202: iload 15
    //   204: ifne +13 -> 217
    //   207: aload 4
    //   209: aload 7
    //   211: invokevirtual 276	android/content/Context:unbindService	(Landroid/content/ServiceConnection;)V
    //   214: aload 14
    //   216: areturn
    //   217: aload 12
    //   219: ldc_w 338
    //   222: invokevirtual 254	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   225: astore 16
    //   227: aload 12
    //   229: ldc_w 340
    //   232: invokevirtual 344	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   235: checkcast 66	android/content/Intent
    //   238: astore 17
    //   240: aload 16
    //   242: invokestatic 346	com/google/android/gms/auth/GoogleAuthUtil:ay	(Ljava/lang/String;)Z
    //   245: ifeq +28 -> 273
    //   248: new 120	com/google/android/gms/auth/UserRecoverableAuthException
    //   251: dup
    //   252: aload 16
    //   254: aload 17
    //   256: invokespecial 349	com/google/android/gms/auth/UserRecoverableAuthException:<init>	(Ljava/lang/String;Landroid/content/Intent;)V
    //   259: athrow
    //   260: astore 8
    //   262: new 85	com/google/android/gms/auth/GoogleAuthException
    //   265: dup
    //   266: ldc_w 278
    //   269: invokespecial 114	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   272: athrow
    //   273: aload 16
    //   275: invokestatic 351	com/google/android/gms/auth/GoogleAuthUtil:ax	(Ljava/lang/String;)Z
    //   278: ifeq +13 -> 291
    //   281: new 118	java/io/IOException
    //   284: dup
    //   285: aload 16
    //   287: invokespecial 272	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   290: athrow
    //   291: new 85	com/google/android/gms/auth/GoogleAuthException
    //   294: dup
    //   295: aload 16
    //   297: invokespecial 114	com/google/android/gms/auth/GoogleAuthException:<init>	(Ljava/lang/String;)V
    //   300: athrow
    //   301: new 118	java/io/IOException
    //   304: dup
    //   305: ldc_w 280
    //   308: invokespecial 272	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   311: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	312	0	paramContext	Context
    //   0	312	1	paramString1	String
    //   0	312	2	paramString2	String
    //   0	312	3	paramBundle	Bundle
    //   4	204	4	localContext	Context
    //   27	154	5	localBundle1	Bundle
    //   36	28	6	str1	String
    //   75	135	7	locala	com.google.android.gms.common.a
    //   260	1	8	localInterruptedException	java.lang.InterruptedException
    //   160	10	9	localObject	Object
    //   135	9	10	localRemoteException	android.os.RemoteException
    //   108	120	12	localBundle2	Bundle
    //   193	22	14	str2	String
    //   200	3	15	bool	boolean
    //   225	71	16	str3	String
    //   238	17	17	localIntent	Intent
    // Exception table:
    //   from	to	target	type
    //   91	110	135	android/os/RemoteException
    //   115	135	135	android/os/RemoteException
    //   185	202	135	android/os/RemoteException
    //   217	260	135	android/os/RemoteException
    //   273	291	135	android/os/RemoteException
    //   291	301	135	android/os/RemoteException
    //   91	110	160	finally
    //   115	135	160	finally
    //   137	160	160	finally
    //   185	202	160	finally
    //   217	260	160	finally
    //   262	273	160	finally
    //   273	291	160	finally
    //   291	301	160	finally
    //   91	110	260	java/lang/InterruptedException
    //   115	135	260	java/lang/InterruptedException
    //   185	202	260	java/lang/InterruptedException
    //   217	260	260	java/lang/InterruptedException
    //   273	291	260	java/lang/InterruptedException
    //   291	301	260	java/lang/InterruptedException
  }
  
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    paramBundle.putBoolean("handle_notification", true);
    return a(paramContext, paramString1, paramString2, paramBundle);
  }
  
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, Intent paramIntent)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    h(paramIntent);
    if (paramBundle == null) {
      paramBundle = new Bundle();
    }
    paramBundle.putParcelable("callback_intent", paramIntent);
    paramBundle.putBoolean("handle_notification", true);
    return a(paramContext, paramString1, paramString2, paramBundle);
  }
  
  public static String getTokenWithNotification(Context paramContext, String paramString1, String paramString2, Bundle paramBundle1, String paramString3, Bundle paramBundle2)
    throws IOException, UserRecoverableNotifiedException, GoogleAuthException
  {
    if (TextUtils.isEmpty(paramString3)) {
      throw new IllegalArgumentException("Authority cannot be empty or null.");
    }
    if (paramBundle1 == null) {
      paramBundle1 = new Bundle();
    }
    if (paramBundle2 == null) {
      paramBundle2 = new Bundle();
    }
    ContentResolver.validateSyncExtrasBundle(paramBundle2);
    paramBundle1.putString("authority", paramString3);
    paramBundle1.putBundle("sync_extras", paramBundle2);
    paramBundle1.putBoolean("handle_notification", true);
    return a(paramContext, paramString1, paramString2, paramBundle1);
  }
  
  private static void h(Intent paramIntent)
  {
    if (paramIntent == null) {
      throw new IllegalArgumentException("Callback cannot be null.");
    }
    String str = paramIntent.toUri(1);
    try
    {
      Intent.parseUri(str, 1);
      return;
    }
    catch (URISyntaxException localURISyntaxException)
    {
      throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
    }
  }
  
  @Deprecated
  public static void invalidateToken(Context paramContext, String paramString)
  {
    AccountManager.get(paramContext).invalidateAuthToken("com.google", paramString);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.GoogleAuthUtil
 * JD-Core Version:    0.7.0.1
 */