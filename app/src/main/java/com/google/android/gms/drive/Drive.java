package com.google.android.gms.drive;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.ApiOptions.Optional;
import com.google.android.gms.common.api.Api.b;
import com.google.android.gms.common.api.Api.c;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.drive.internal.p;
import com.google.android.gms.drive.internal.r;
import com.google.android.gms.drive.internal.u;
import com.google.android.gms.drive.internal.x;
import com.google.android.gms.drive.internal.z;
import com.google.android.gms.internal.jg;
import java.util.List;

public final class Drive
{
  public static final Api<Api.ApiOptions.NoOptions> API;
  public static final Api.c<r> DQ = new Api.c();
  public static final DriveApi DriveApi;
  public static final DrivePreferencesApi DrivePreferencesApi = new x();
  public static final Scope Oo;
  public static final Scope Op;
  public static final Api<b> Oq;
  public static final b Or;
  public static final e Os;
  public static final Scope SCOPE_APPFOLDER;
  public static final Scope SCOPE_FILE = new Scope("https://www.googleapis.com/auth/drive.file");
  
  static
  {
    SCOPE_APPFOLDER = new Scope("https://www.googleapis.com/auth/drive.appdata");
    Oo = new Scope("https://www.googleapis.com/auth/drive");
    Op = new Scope("https://www.googleapis.com/auth/drive.apps");
    API = new Api(new a()
    {
      protected Bundle a(Api.ApiOptions.NoOptions paramAnonymousNoOptions)
      {
        return new Bundle();
      }
    }, DQ, new Scope[0]);
    Oq = new Api(new a()
    {
      protected Bundle a(Drive.b paramAnonymousb)
      {
        if (paramAnonymousb == null) {
          return new Bundle();
        }
        return paramAnonymousb.iq();
      }
    }, DQ, new Scope[0]);
    DriveApi = new p();
    Or = new u();
    Os = new z();
  }
  
  public static abstract class a<O extends Api.ApiOptions>
    implements Api.b<r, O>
  {
    protected abstract Bundle a(O paramO);
    
    public r a(Context paramContext, Looper paramLooper, jg paramjg, O paramO, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
    {
      List localList = paramjg.ho();
      return new r(paramContext, paramLooper, paramjg, paramConnectionCallbacks, paramOnConnectionFailedListener, (String[])localList.toArray(new String[localList.size()]), a(paramO));
    }
    
    public int getPriority()
    {
      return 2147483647;
    }
  }
  
  public static class b
    implements Api.ApiOptions.Optional
  {
    private final Bundle DJ;
    
    private b()
    {
      this(new Bundle());
    }
    
    private b(Bundle paramBundle)
    {
      this.DJ = paramBundle;
    }
    
    public Bundle iq()
    {
      return this.DJ;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.Drive
 * JD-Core Version:    0.7.0.1
 */