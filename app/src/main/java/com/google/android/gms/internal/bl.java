package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import java.util.List;

@ey
public class bl
{
  private final Context mContext;
  
  public bl(Context paramContext)
  {
    jx.b(paramContext, "Context can not be null");
    this.mContext = paramContext;
  }
  
  public static boolean bs()
  {
    return "mounted".equals(Environment.getExternalStorageState());
  }
  
  public boolean a(Intent paramIntent)
  {
    jx.b(paramIntent, "Intent can not be null");
    boolean bool1 = this.mContext.getPackageManager().queryIntentActivities(paramIntent, 0).isEmpty();
    boolean bool2 = false;
    if (!bool1) {
      bool2 = true;
    }
    return bool2;
  }
  
  public boolean bo()
  {
    Intent localIntent = new Intent("android.intent.action.DIAL");
    localIntent.setData(Uri.parse("tel:"));
    return a(localIntent);
  }
  
  public boolean bp()
  {
    Intent localIntent = new Intent("android.intent.action.VIEW");
    localIntent.setData(Uri.parse("sms:"));
    return a(localIntent);
  }
  
  public boolean bq()
  {
    return (bs()) && (this.mContext.checkCallingOrSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") == 0);
  }
  
  public boolean br()
  {
    return false;
  }
  
  public boolean bt()
  {
    Intent localIntent = new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event");
    return (Build.VERSION.SDK_INT >= 14) && (a(localIntent));
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.bl
 * JD-Core Version:    0.7.0.1
 */