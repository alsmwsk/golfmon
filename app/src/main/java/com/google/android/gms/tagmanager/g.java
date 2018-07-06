package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class g
  extends aj
{
  private static final String ID = a.x.toString();
  private final Context mContext;
  
  public g(Context paramContext)
  {
    super(ID, new String[0]);
    this.mContext = paramContext;
  }
  
  public d.a B(Map<String, d.a> paramMap)
  {
    try
    {
      PackageManager localPackageManager = this.mContext.getPackageManager();
      d.a locala = di.u(localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(this.mContext.getPackageName(), 0)).toString());
      return locala;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      bh.b("App name is not found.", localNameNotFoundException);
    }
    return di.rb();
  }
  
  public boolean pe()
  {
    return true;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.g
 * JD-Core Version:    0.7.0.1
 */