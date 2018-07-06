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
public final class dw
  extends g<dy>
{
  private static final dw sy = new dw();
  
  private dw()
  {
    super("com.google.android.gms.ads.AdOverlayCreatorImpl");
  }
  
  public static dx b(Activity paramActivity)
  {
    try
    {
      if (c(paramActivity))
      {
        gr.S("Using AdOverlay from the client jar.");
        return new dp(paramActivity);
      }
      dx localdx = sy.d(paramActivity);
      return localdx;
    }
    catch (a locala)
    {
      gr.W(locala.getMessage());
    }
    return null;
  }
  
  private static boolean c(Activity paramActivity)
    throws dw.a
  {
    Intent localIntent = paramActivity.getIntent();
    if (!localIntent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
      throw new a("Ad overlay requires the useClientJar flag in intent extras.");
    }
    return localIntent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
  }
  
  private dx d(Activity paramActivity)
  {
    try
    {
      d locald = e.k(paramActivity);
      dx localdx = dx.a.r(((dy)L(paramActivity)).b(locald));
      return localdx;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not create remote AdOverlay.", localRemoteException);
      return null;
    }
    catch (g.a locala)
    {
      gr.d("Could not create remote AdOverlay.", locala);
    }
    return null;
  }
  
  protected dy q(IBinder paramIBinder)
  {
    return dy.a.s(paramIBinder);
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
 * Qualified Name:     com.google.android.gms.internal.dw
 * JD-Core Version:    0.7.0.1
 */