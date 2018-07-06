package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.dynamic.g.a;

@ey
public final class et
  extends g<ep>
{
  private static final et td = new et();
  
  private et()
  {
    super("com.google.android.gms.ads.InAppPurchaseManagerCreatorImpl");
  }
  
  private static boolean c(Activity paramActivity)
    throws et.a
  {
    Intent localIntent = paramActivity.getIntent();
    if (!localIntent.hasExtra("com.google.android.gms.ads.internal.purchase.useClientJar")) {
      throw new a("InAppPurchaseManager requires the useClientJar flag in intent extras.");
    }
    return localIntent.getBooleanExtra("com.google.android.gms.ads.internal.purchase.useClientJar", false);
  }
  
  public static eo e(Activity paramActivity)
  {
    try
    {
      if (c(paramActivity))
      {
        gr.S("Using AdOverlay from the client jar.");
        return new ee(paramActivity);
      }
      eo localeo = td.f(paramActivity);
      return localeo;
    }
    catch (a locala)
    {
      gr.W(locala.getMessage());
    }
    return null;
  }
  
  private eo f(Activity paramActivity)
  {
    try
    {
      d locald = e.k(paramActivity);
      eo localeo = eo.a.w(((ep)L(paramActivity)).c(locald));
      return localeo;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not create remote InAppPurchaseManager.", localRemoteException);
      return null;
    }
    catch (g.a locala)
    {
      gr.d("Could not create remote InAppPurchaseManager.", locala);
    }
    return null;
  }
  
  protected ep A(IBinder paramIBinder)
  {
    return ep.a.x(paramIBinder);
  }
  
  private static final class a
    extends Exception
  {
    public a(String paramString)
    {
      super();
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.et
 * JD-Core Version:    0.7.0.1
 */