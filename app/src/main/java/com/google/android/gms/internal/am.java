package com.google.android.gms.internal;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;

@ey
public class am
  implements Application.ActivityLifecycleCallbacks
{
  private Context mContext;
  private final Object mH = new Object();
  private Activity nB;
  
  public am(Application paramApplication, Activity paramActivity)
  {
    paramApplication.registerActivityLifecycleCallbacks(this);
    setActivity(paramActivity);
    this.mContext = paramApplication.getApplicationContext();
  }
  
  private void setActivity(Activity paramActivity)
  {
    synchronized (this.mH)
    {
      if (!paramActivity.getClass().getName().startsWith("com.google.android.gms.ads")) {
        this.nB = paramActivity;
      }
      return;
    }
  }
  
  public Activity getActivity()
  {
    return this.nB;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    synchronized (this.mH)
    {
      if (this.nB == null) {
        return;
      }
      if (this.nB.equals(paramActivity)) {
        this.nB = null;
      }
      return;
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    setActivity(paramActivity);
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    setActivity(paramActivity);
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    setActivity(paramActivity);
  }
  
  public void onActivityStopped(Activity paramActivity) {}
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.am
 * JD-Core Version:    0.7.0.1
 */