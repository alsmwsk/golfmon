package com.google.android.gms.tagmanager;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.android.gms.internal.a;
import com.google.android.gms.internal.d.a;
import java.util.Map;

class h
  extends aj
{
  private static final String ID = a.y.toString();
  private final Context mContext;
  
  public h(Context paramContext)
  {
    super(ID, new String[0]);
    this.mContext = paramContext;
  }
  
  public d.a B(Map<String, d.a> paramMap)
  {
    try
    {
      d.a locala = di.u(Integer.valueOf(this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0).versionCode));
      return locala;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      bh.T("Package name " + this.mContext.getPackageName() + " not found. " + localNameNotFoundException.getMessage());
    }
    return di.rb();
  }
  
  public boolean pe()
  {
    return true;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.h
 * JD-Core Version:    0.7.0.1
 */