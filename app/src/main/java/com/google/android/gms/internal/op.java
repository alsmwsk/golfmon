package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;

public class op
{
  private final ox amU;
  private ov amV;
  
  public op(Context paramContext, int paramInt, String paramString1, String paramString2, a parama, boolean paramBoolean)
  {
    String str = paramContext.getPackageName();
    try
    {
      i = paramContext.getPackageManager().getPackageInfo(str, 0).versionCode;
      this.amV = new ov(str, i, paramInt, paramString1, paramString2, paramBoolean);
      this.amU = new ox(paramContext, new ou(parama));
      return;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Log.wtf("PlayLogger", "This can't happen.");
        int i = 0;
      }
    }
  }
  
  public void a(long paramLong, String paramString, byte[] paramArrayOfByte, String... paramVarArgs)
  {
    this.amU.b(this.amV, new or(paramLong, paramString, paramArrayOfByte, paramVarArgs));
  }
  
  public void b(String paramString, byte[] paramArrayOfByte, String... paramVarArgs)
  {
    a(System.currentTimeMillis(), paramString, paramArrayOfByte, paramVarArgs);
  }
  
  public void start()
  {
    this.amU.start();
  }
  
  public void stop()
  {
    this.amU.stop();
  }
  
  public static abstract interface a
  {
    public abstract void d(PendingIntent paramPendingIntent);
    
    public abstract void on();
    
    public abstract void oo();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.op
 * JD-Core Version:    0.7.0.1
 */