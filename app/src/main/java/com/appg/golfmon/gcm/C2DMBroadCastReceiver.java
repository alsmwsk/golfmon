package com.appg.golfmon.gcm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.WakefulBroadcastReceiver;
import com.appg.golfmon.util.LogUtil;

public class C2DMBroadCastReceiver
  extends WakefulBroadcastReceiver
{
  private static final String TAG = "GCM C2DMBroadCastReceiver";
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    LogUtil.intent("GCM C2DMBroadCastReceiver", paramIntent);
    startWakefulService(paramContext, paramIntent.setComponent(new ComponentName(paramContext.getPackageName(), C2DMIntentService.class.getName())));
    setResultCode(-1);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.gcm.C2DMBroadCastReceiver
 * JD-Core Version:    0.7.0.1
 */