package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.ads.mediation.MediationServerParameters;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import java.util.Map;

@ey
public final class cx
  extends cy.a
{
  private Map<Class<? extends com.google.android.gms.ads.mediation.NetworkExtras>, com.google.android.gms.ads.mediation.NetworkExtras> qT;
  
  private <NETWORK_EXTRAS extends com.google.ads.mediation.NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> cz z(String paramString)
    throws RemoteException
  {
    try
    {
      Class localClass = Class.forName(paramString, false, cx.class.getClassLoader());
      if (com.google.ads.mediation.MediationAdapter.class.isAssignableFrom(localClass))
      {
        com.google.ads.mediation.MediationAdapter localMediationAdapter = (com.google.ads.mediation.MediationAdapter)localClass.newInstance();
        return new de(localMediationAdapter, (com.google.ads.mediation.NetworkExtras)this.qT.get(localMediationAdapter.getAdditionalParametersType()));
      }
      if (com.google.android.gms.ads.mediation.MediationAdapter.class.isAssignableFrom(localClass)) {
        return new dc((com.google.android.gms.ads.mediation.MediationAdapter)localClass.newInstance());
      }
      gr.W("Could not instantiate mediation adapter: " + paramString + " (not a valid adapter).");
      throw new RemoteException();
    }
    catch (Throwable localThrowable)
    {
      gr.W("Could not instantiate mediation adapter: " + paramString + ". " + localThrowable.getMessage());
      throw new RemoteException();
    }
  }
  
  public void d(Map<Class<? extends com.google.android.gms.ads.mediation.NetworkExtras>, com.google.android.gms.ads.mediation.NetworkExtras> paramMap)
  {
    this.qT = paramMap;
  }
  
  public cz x(String paramString)
    throws RemoteException
  {
    return z(paramString);
  }
  
  public boolean y(String paramString)
    throws RemoteException
  {
    try
    {
      boolean bool = CustomEvent.class.isAssignableFrom(Class.forName(paramString, false, cx.class.getClassLoader()));
      return bool;
    }
    catch (Throwable localThrowable)
    {
      gr.W("Could not load custom event implementation class: " + paramString + ", assuming old implementation.");
    }
    return false;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cx
 * JD-Core Version:    0.7.0.1
 */