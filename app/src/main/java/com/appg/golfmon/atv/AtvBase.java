package com.appg.golfmon.atv;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.appg.golfmon.atv.more.AtvMyRegist;
import com.appg.golfmon.atv.user.AtvUserLogin;
import com.appg.golfmon.util.Alert;
import com.appg.golfmon.util.Alert.OnCloseListener;
import com.appg.golfmon.util.InflateUtil;
import com.appg.golfmon.util.LogUtil;
import com.appg.golfmon.util.SPUtil;

public abstract class AtvBase
  extends Activity
{
  public static final int WARNING_CNT = 1;
  private LinearLayout mBaseLinear = null;
  protected RelativeLayout mBaseTopTitle = null;
  protected Button mBtnTopRight = null;
  protected int[] mDeviceSize = null;
  protected ImageView mImgTopTitleLeft = null;
  protected TextView mTxtTopTitleCenter = null;
  protected TextView mTxtTopTitleGrade = null;
  protected TextView mTxtTopTitleLeft = null;
  protected TextView mTxtTopTitleLeft2_1 = null;
  protected TextView mTxtTopTitleLeft2_2 = null;
  protected TextView mTxtTopTitleLeftBack = null;
  protected TextView mTxtTopTitleRegistDT = null;
  
  protected boolean checkLogin(boolean paramBoolean)
  {
    if (!SPUtil.getInstance().getIsLogin(this))
    {
      if (paramBoolean)
      {
        Alert localAlert = new Alert();
        localAlert.setOnCloseListener(new Alert.OnCloseListener()
        {
          public void onClose(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt, Object paramAnonymousObject)
          {
            if (1 == paramAnonymousInt) {
              AtvBase.this.startActivityForResult(new Intent(AtvBase.this.getContext(), AtvUserLogin.class), 1111);
            }
          }
        });
        localAlert.showAlert(this, "로그인이 필요합니다.", true, new String[] { "로그인", "취소" });
      }
      return false;
    }
    return true;
  }
  
  protected abstract void configureListener();
  
  protected abstract void findView();
  
  protected boolean getBundle()
  {
    return true;
  }
  
  protected void getBundleFail()
  {
    Alert.toastShort(this, "다시 시도해 주세요.");
    finish();
  }
  
  public Activity getContext()
  {
    return this;
  }
  
  protected void getDisplaySize()
  {
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    ((WindowManager)getSystemService("window")).getDefaultDisplay().getMetrics(localDisplayMetrics);
    this.mDeviceSize = new int[2];
    this.mDeviceSize[0] = localDisplayMetrics.widthPixels;
    this.mDeviceSize[1] = localDisplayMetrics.heightPixels;
  }
  
  protected abstract void init();
  
  public void logout()
  {
    LogUtil.e("logout() 베이스");
    SPUtil.getInstance().logOut(this);
    Intent localIntent = new Intent(getContext(), AtvMain.class);
    localIntent.setAction("LOGOUT");
    localIntent.setFlags(603979776);
    startActivity(localIntent);
    finish();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903046);
    getDisplaySize();
    this.mBaseTopTitle = ((RelativeLayout)findViewById(2131361846));
    this.mImgTopTitleLeft = ((ImageView)findViewById(2131361847));
    this.mTxtTopTitleLeft = ((TextView)findViewById(2131361848));
    this.mTxtTopTitleLeft2_1 = ((TextView)findViewById(2131361849));
    this.mTxtTopTitleLeft2_2 = ((TextView)findViewById(2131361850));
    this.mTxtTopTitleLeftBack = ((TextView)findViewById(2131361851));
    this.mTxtTopTitleCenter = ((TextView)findViewById(2131361852));
    this.mTxtTopTitleGrade = ((TextView)findViewById(2131361853));
    this.mTxtTopTitleRegistDT = ((TextView)findViewById(2131361855));
    this.mBtnTopRight = ((Button)findViewById(2131361854));
    this.mBaseLinear = ((LinearLayout)findViewById(2131361856));
    setView();
    if (getBundle())
    {
      findView();
      init();
      configureListener();
      return;
    }
    getBundleFail();
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    paramMenu.add(0, 0, 0, "내가 등록한 양도/조인").setIcon(17301563);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      return super.onOptionsItemSelected(paramMenuItem);
      startActivity(new Intent(getContext(), AtvMyRegist.class));
    }
  }
  
  protected abstract void setView();
  
  protected void setView(int paramInt)
  {
    if (paramInt > 0) {
      setView(InflateUtil.inflate(this, paramInt, null));
    }
  }
  
  protected void setView(View paramView)
  {
    if (paramView != null)
    {
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
      this.mBaseLinear.addView(paramView, localLayoutParams);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.AtvBase
 * JD-Core Version:    0.7.0.1
 */