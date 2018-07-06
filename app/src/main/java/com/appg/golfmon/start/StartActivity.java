package com.appg.golfmon.start;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.LogUtil;

public class StartActivity
  extends Activity
{
  private final String TAG = "START StartActivity";
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    LogUtil.intent("START StartActivity", getIntent());
    if (!FormatUtil.isNullorEmpty(getIntent().getDataString()))
    {
      Intent localIntent = new Intent(this, StartReceiver.class);
      localIntent.setAction("com.appg.golfmon.ACTION_START");
      localIntent.setData(getIntent().getData());
      sendBroadcast(localIntent);
    }
    finish();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.start.StartActivity
 * JD-Core Version:    0.7.0.1
 */