package com.appg.golfmon.gcm;

import android.app.Activity;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.appg.golfmon.atv.AtvIntro;
import com.appg.golfmon.atv.event.AtvEvent;
import com.appg.golfmon.atv.more.AtvNotice;
import com.appg.golfmon.atv.schedule.AtvDetail;
import com.appg.golfmon.util.CommonUtil;
import com.appg.golfmon.util.LogUtil;
import com.appg.golfmon.util.SPUtil;

public class C2DMActivity
  extends Activity
{
  public static final String ACTION_NOTIFY = "ACTION_NOTIFY";
  private static final String TAG = "GCM C2DMActivity";
  
  private void goEventList(Intent paramIntent)
  {
    paramIntent.setAction("ACTION_NOTIFY");
    paramIntent.setFlags(67108864);
    paramIntent.setClass(this, AtvEvent.class);
    startActivity(paramIntent);
  }
  
  private void goIntro(Intent paramIntent)
  {
    paramIntent.setAction("ACTION_NOTIFY");
    paramIntent.setFlags(603979776);
    paramIntent.setClass(this, AtvIntro.class);
    startActivity(paramIntent);
  }
  
  private void goNoticetList(Intent paramIntent)
  {
    paramIntent.setAction("ACTION_NOTIFY");
    paramIntent.setFlags(67108864);
    paramIntent.setClass(this, AtvNotice.class);
    startActivity(paramIntent);
  }
  
  private void goTransferJoinDetail(Intent paramIntent)
  {
    paramIntent.setAction("ACTION_NOTIFY");
    paramIntent.setFlags(67108864);
    paramIntent.setClass(this, AtvDetail.class);
    startActivity(paramIntent);
  }
  
  private void startApp(Intent paramIntent)
  {
    ComponentName localComponentName = new ComponentName(this, C2DMActivity.class);
    if (localComponentName.equals(CommonUtil.getAtv("GCM C2DMActivity", this, localComponentName).baseActivity)) {
      goIntro(paramIntent);
    }
    String str;
    do
    {
      return;
      str = paramIntent.getStringExtra("pushTypeID");
      if ("1".equals(str))
      {
        goTransferJoinDetail(paramIntent);
        return;
      }
      if ("4".equals(str))
      {
        goEventList(paramIntent);
        return;
      }
    } while (!"5".equals(str));
    goNoticetList(paramIntent);
  }
  
  public void finish()
  {
    super.finish();
    overridePendingTransition(0, 0);
  }
  
  public void onBackPressed()
  {
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903040);
    LogUtil.e("GCM C2DMActivity", "onCreate");
    onNewIntent(getIntent());
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    LogUtil.intent("GCM C2DMActivity", paramIntent);
    if (paramIntent == null)
    {
      finish();
      return;
    }
    if (!SPUtil.getInstance().getIsLogin(this))
    {
      finish();
      return;
    }
    String str = paramIntent.getStringExtra("msg");
    if (str == null) {
      str = "";
    }
    showAlert(this, getString(2131099688), str, paramIntent, new String[] { "확인", "닫기" });
  }
  
  public void showAlert(Context paramContext, String paramString1, String paramString2, final Intent paramIntent, String... paramVarArgs)
  {
    TextView localTextView1 = (TextView)findViewById(2131361817);
    TextView localTextView2 = (TextView)findViewById(2131361819);
    Button localButton1 = (Button)findViewById(2131361822);
    Button localButton2 = (Button)findViewById(2131361824);
    View localView = findViewById(2131361823);
    if (paramString1 == null) {
      localTextView1.setVisibility(8);
    }
    for (;;)
    {
      if (paramString2 == null) {
        paramString2 = "";
      }
      localTextView2.setText(paramString2);
      localButton1.setVisibility(8);
      localButton2.setVisibility(8);
      localView.setVisibility(8);
      switch (paramVarArgs.length)
      {
      default: 
        return;
        localTextView1.setVisibility(0);
        localTextView1.setText(paramString1);
      }
    }
    localButton1.setVisibility(0);
    localButton1.setText(paramVarArgs[1]);
    localButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        C2DMActivity.this.finish();
      }
    });
    localView.setVisibility(0);
    localButton2.setVisibility(0);
    localButton2.setText(paramVarArgs[0]);
    localButton2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        C2DMActivity.this.startApp(paramIntent);
        C2DMActivity.this.finish();
      }
    });
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.gcm.C2DMActivity
 * JD-Core Version:    0.7.0.1
 */