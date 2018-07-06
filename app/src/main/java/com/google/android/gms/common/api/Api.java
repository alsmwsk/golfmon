package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.internal.jg;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Api<O extends ApiOptions>
{
  private final b<?, O> Jm;
  private final c<?> Jn;
  private final ArrayList<Scope> Jo;
  
  public <C extends a> Api(b<C, O> paramb, c<C> paramc, Scope... paramVarArgs)
  {
    this.Jm = paramb;
    this.Jn = paramc;
    this.Jo = new ArrayList(Arrays.asList(paramVarArgs));
  }
  
  public b<?, O> gx()
  {
    return this.Jm;
  }
  
  public List<Scope> gy()
  {
    return this.Jo;
  }
  
  public c<?> gz()
  {
    return this.Jn;
  }
  
  public static abstract interface ApiOptions
  {
    public static abstract interface HasOptions
      extends Api.ApiOptions
    {}
    
    public static final class NoOptions
      implements Api.ApiOptions.NotRequiredOptions
    {}
    
    public static abstract interface NotRequiredOptions
      extends Api.ApiOptions
    {}
    
    public static abstract interface Optional
      extends Api.ApiOptions.HasOptions, Api.ApiOptions.NotRequiredOptions
    {}
  }
  
  public static abstract interface a
  {
    public abstract void connect();
    
    public abstract void disconnect();
    
    public abstract boolean isConnected();
  }
  
  public static abstract interface b<T extends Api.a, O>
  {
    public abstract T a(Context paramContext, Looper paramLooper, jg paramjg, O paramO, GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener);
    
    public abstract int getPriority();
  }
  
  public static final class c<C extends Api.a> {}
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.Api
 * JD-Core Version:    0.7.0.1
 */