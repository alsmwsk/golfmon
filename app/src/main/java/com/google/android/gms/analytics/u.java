package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

class u
  extends BroadcastReceiver
{
  static final String yR = u.class.getName();
  private final aj yS;
  
  u(aj paramaj)
  {
    this.yS = paramaj;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getAction();
    if ("android.net.conn.CONNECTIVITY_CHANGE".equals(str))
    {
      bool1 = paramIntent.getBooleanExtra("noConnectivity", false);
      localaj = this.yS;
      bool2 = false;
      if (!bool1) {
        bool2 = true;
      }
      localaj.C(bool2);
    }
    while ((!"com.google.analytics.RADIO_POWERED".equals(str)) || (paramIntent.hasExtra(yR)))
    {
      boolean bool1;
      aj localaj;
      boolean bool2;
      return;
    }
    this.yS.ey();
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
 * Qualified Name:     com.google.android.gms.analytics.u
 * JD-Core Version:    0.7.0.1
 */