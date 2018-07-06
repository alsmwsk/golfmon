package com.appg.golfmon.start;

import android.app.ActivityManager.RunningTaskInfo;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.appg.golfmon.atv.AtvIntro;
import com.appg.golfmon.atv.AtvMain;
import com.appg.golfmon.util.CommonUtil;
import com.appg.golfmon.util.LogUtil;

public class StartReceiver
  extends BroadcastReceiver
{
  public static final String ACTION_START = "com.appg.golfmon.ACTION_START";
  public static final String REQUEST_START = "action_start";
  private final String TAG = "START StartReceiver";
  
  private void go(Context paramContext)
  {
    ActivityManager.RunningTaskInfo localRunningTaskInfo = CommonUtil.getAtv(paramContext, new ComponentName(paramContext, AtvMain.class));
    if (localRunningTaskInfo == null)
    {
      goIntro(paramContext);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.setClassName(paramContext.getPackageName(), localRunningTaskInfo.topActivity.getClassName());
    localIntent.setFlags(603979776);
    start(paramContext, localIntent);
  }
  
  private void goIntro(Context paramContext)
  {
    start(paramContext, new Intent(paramContext, AtvIntro.class));
  }
  
  private void start(Context paramContext, Intent paramIntent)
  {
    LogUtil.e("스타트");
    LogUtil.intent(paramIntent);
    PendingIntent localPendingIntent = PendingIntent.getActivity(paramContext, 0, paramIntent, 134217728);
    try
    {
      LogUtil.e("고고");
      localPendingIntent.send(paramContext, 456, paramIntent);
      return;
    }
    catch (PendingIntent.CanceledException localCanceledException)
    {
      localCanceledException.printStackTrace();
    }
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    LogUtil.intent("START StartReceiver", paramIntent);
    LogUtil.d("data : " + paramIntent.getDataString());
    if (paramIntent != null)
    {
      Uri localUri = paramIntent.getData();
      if (localUri != null)
      {
        String str = localUri.getHost();
        LogUtil.d("host : " + str);
        go(paramContext);
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.start.StartReceiver
 * JD-Core Version:    0.7.0.1
 */