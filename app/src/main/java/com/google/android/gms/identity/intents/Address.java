package com.google.android.gms.identity.intents;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.BaseImplementation.a;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.jg;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.mw;

public final class Address
{
  public static final Api<AddressOptions> API = new Api(DR, DQ, new Scope[0]);
  static final Api.c<mw> DQ = new Api.c();
  private static final Api.b<mw, AddressOptions> DR = new Api.b()
  {
    public mw a(Context paramAnonymousContext, Looper paramAnonymousLooper, jg paramAnonymousjg, Address.AddressOptions paramAnonymousAddressOptions, GoogleApiClient.ConnectionCallbacks paramAnonymousConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramAnonymousOnConnectionFailedListener)
    {
      jx.b(paramAnonymousContext instanceof Activity, "An Activity must be used for Address APIs");
      if (paramAnonymousAddressOptions == null) {
        paramAnonymousAddressOptions = new Address.AddressOptions();
      }
      return new mw((Activity)paramAnonymousContext, paramAnonymousLooper, paramAnonymousConnectionCallbacks, paramAnonymousOnConnectionFailedListener, paramAnonymousjg.getAccountName(), paramAnonymousAddressOptions.theme);
    }
    
    public int getPriority()
    {
      return 2147483647;
    }
  };
  
  public static void requestUserAddress(GoogleApiClient paramGoogleApiClient, final UserAddressRequest paramUserAddressRequest, final int paramInt)
  {
    paramGoogleApiClient.a(new a(paramGoogleApiClient)
    {
      protected void a(mw paramAnonymousmw)
        throws RemoteException
      {
        paramAnonymousmw.a(paramUserAddressRequest, paramInt);
        b(Status.Kw);
      }
    });
  }
  
  public static final class AddressOptions
    implements Api.ApiOptions.HasOptions
  {
    public final int theme;
    
    public AddressOptions()
    {
      this.theme = 0;
    }
    
    public AddressOptions(int paramInt)
    {
      this.theme = paramInt;
    }
  }
  
  private static abstract class a
    extends BaseImplementation.a<Status, mw>
  {
    public a(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    public Status b(Status paramStatus)
    {
      return paramStatus;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.identity.intents.Address
 * JD-Core Version:    0.7.0.1
 */