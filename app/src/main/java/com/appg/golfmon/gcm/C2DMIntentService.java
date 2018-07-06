package com.appg.golfmon.gcm;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.support.v4.app.NotificationCompat.Builder;
import com.appg.golfmon.util.JSONUtil;
import com.appg.golfmon.util.LogUtil;
import com.appg.golfmon.util.SPUtil;
import org.json.JSONObject;

public class C2DMIntentService
  extends IntentService
{
  private static final String TAG = "GCM C2DMIntentService";
  public static int mSeq = 0;
  
  public C2DMIntentService()
  {
    super("GCM C2DMIntentService");
  }
  
  public static void doNotification(Context paramContext, Intent paramIntent)
  {
    LogUtil.intent("GCM C2DMIntentService doNotification", paramIntent);
    String str = paramIntent.getStringExtra("msg");
    if (str == null) {
      str = "";
    }
    mSeq = 1 + mSeq;
    paramIntent.setAction("ACTION_NOTIFY");
    paramIntent.setClass(paramContext, C2DMActivity.class);
    paramIntent.setFlags(67108864);
    PendingIntent localPendingIntent = PendingIntent.getActivity(paramContext, mSeq, paramIntent, 134217728);
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(paramContext);
    localBuilder.setContentTitle(paramContext.getString(2131099688));
    localBuilder.setContentText(str);
    localBuilder.setSmallIcon(2130837655);
    localBuilder.setLargeIcon(BitmapFactory.decodeResource(paramContext.getResources(), 2130837624));
    localBuilder.setContentIntent(localPendingIntent);
    localBuilder.setAutoCancel(true);
    localBuilder.setDefaults(7);
    localBuilder.setTicker(paramContext.getString(2131099688) + "\n" + str);
    Notification localNotification = localBuilder.build();
    ((NotificationManager)paramContext.getSystemService("notification")).notify(mSeq, localNotification);
  }
  
  private void handleMessage(Intent paramIntent)
  {
    JSONObject localJSONObject = JSONUtil.createObject(paramIntent, "message");
    paramIntent.putExtra("pushTypeID", JSONUtil.getString(localJSONObject, "pushTypeID", ""));
    paramIntent.putExtra("msg", JSONUtil.getString(localJSONObject, "msg", ""));
    paramIntent.putExtra("transferJoinID", JSONUtil.getString(localJSONObject, "transferJoinID", "0"));
    if (!SPUtil.getInstance().getIsLogin(this)) {}
    while (!SPUtil.getInstance().getIsOnPush(this)) {
      return;
    }
    doNotification(this, paramIntent);
  }
  
  private void handleRegistration(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("registration_id");
    if (str != null) {
      SPUtil.getInstance().setRegistPushKey(this, str);
    }
  }
  
  /* Error */
  public final void onHandleIntent(Intent paramIntent)
  {
    // Byte code:
    //   0: ldc 8
    //   2: ldc 198
    //   4: invokestatic 202	com/appg/golfmon/util/LogUtil:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   7: ldc 8
    //   9: aload_1
    //   10: invokestatic 28	com/appg/golfmon/util/LogUtil:intent	(Ljava/lang/String;Landroid/content/Intent;)V
    //   13: aload_1
    //   14: invokevirtual 205	android/content/Intent:getAction	()Ljava/lang/String;
    //   17: astore 4
    //   19: aload 4
    //   21: ldc 207
    //   23: invokevirtual 211	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifeq +14 -> 40
    //   29: aload_0
    //   30: aload_1
    //   31: invokespecial 213	com/appg/golfmon/gcm/C2DMIntentService:handleRegistration	(Landroid/content/Intent;)V
    //   34: aload_1
    //   35: invokestatic 219	com/appg/golfmon/gcm/C2DMBroadCastReceiver:completeWakefulIntent	(Landroid/content/Intent;)Z
    //   38: pop
    //   39: return
    //   40: aload 4
    //   42: ldc 221
    //   44: invokevirtual 211	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   47: ifeq -13 -> 34
    //   50: aload_0
    //   51: aload_1
    //   52: invokespecial 223	com/appg/golfmon/gcm/C2DMIntentService:handleMessage	(Landroid/content/Intent;)V
    //   55: goto -21 -> 34
    //   58: astore_2
    //   59: aload_1
    //   60: invokestatic 219	com/appg/golfmon/gcm/C2DMBroadCastReceiver:completeWakefulIntent	(Landroid/content/Intent;)Z
    //   63: pop
    //   64: aload_2
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	C2DMIntentService
    //   0	66	1	paramIntent	Intent
    //   58	7	2	localObject	java.lang.Object
    //   17	24	4	str	String
    // Exception table:
    //   from	to	target	type
    //   13	34	58	finally
    //   40	55	58	finally
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.gcm.C2DMIntentService
 * JD-Core Version:    0.7.0.1
 */