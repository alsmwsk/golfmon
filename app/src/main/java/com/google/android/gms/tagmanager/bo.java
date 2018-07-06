package com.google.android.gms.tagmanager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

class bo
  extends BroadcastReceiver
{
  static final String yR = bo.class.getName();
  private final cx asb;
  
  bo(cx paramcx)
  {
    this.asb = paramcx;
  }
  
  public static void aa(Context paramContext)
  {
    Intent localIntent = new Intent("com.google.analytics.RADIO_POWERED");
    localIntent.addCategory(paramContext.getPackageName());
    localIntent.putExtra(yR, true);
    paramContext.sendBroadcast(localIntent);
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(str))
    {
      localBundle = paramIntent.getExtras();
      localBoolean = Boolean.FALSE;
      if (localBundle != null) {
        localBoolean = Boolean.valueOf(paramIntent.getExtras().getBoolean("noConnectivity"));
      }
      localcx = this.asb;
      if (!localBoolean.booleanValue())
      {
        bool = true;
        localcx.C(bool);
      }
    }
    while ((!"com.google.analytics.RADIO_POWERED".equals(str)) || (paramIntent.hasExtra(yR))) {
      for (;;)
      {
        Bundle localBundle;
        Boolean localBoolean;
        cx localcx;
        return;
        boolean bool = false;
      }
    }
    this.asb.ey();
  }
  
  public void z(Context paramContext)
  {
    IntentFilter localIntentFilter1 = new IntentFilter();
    localIntentFilter1.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    paramContext.registerReceiver(this, localIntentFilter1);
    IntentFilter localIntentFilter2 = new IntentFilter();
    localIntentFilter2.addAction("com.google.analytics.RADIO_POWERED");
    localIntentFilter2.addCategory(paramContext.getPackageName());
    paramContext.registerReceiver(this, localIntentFilter2);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.bo
 * JD-Core Version:    0.7.0.1
 */