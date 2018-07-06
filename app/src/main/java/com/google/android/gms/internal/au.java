package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.d;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.g;
import com.google.android.gms.dynamic.g.a;

@ey
public final class au
  extends g<be>
{
  private static final au oc = new au();
  
  private au()
  {
    super("com.google.android.gms.ads.AdManagerCreatorImpl");
  }
  
  public static bd a(Context paramContext, ay paramay, String paramString, cx paramcx)
  {
    Object localObject;
    if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(paramContext) == 0)
    {
      localObject = oc.b(paramContext, paramay, paramString, paramcx);
      if (localObject != null) {}
    }
    else
    {
      gr.S("Using AdManager from the client jar.");
      localObject = new u(paramContext, paramay, paramString, paramcx, new gs(6587000, 6587000, true));
    }
    return localObject;
  }
  
  private bd b(Context paramContext, ay paramay, String paramString, cx paramcx)
  {
    try
    {
      d locald = e.k(paramContext);
      bd localbd = bd.a.f(((be)L(paramContext)).a(locald, paramay, paramString, paramcx, 6587000));
      return localbd;
    }
    catch (RemoteException localRemoteException)
    {
      gr.d("Could not create remote AdManager.", localRemoteException);
      return null;
    }
    catch (g.a locala)
    {
      gr.d("Could not create remote AdManager.", locala);
    }
    return null;
  }
  
  protected be c(IBinder paramIBinder)
  {
    return be.a.g(paramIBinder);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.au
 * JD-Core Version:    0.7.0.1
 */