package com.google.android.gms.fitness;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.request.SessionInsertRequest;
import com.google.android.gms.fitness.request.SessionReadRequest;
import com.google.android.gms.fitness.result.SessionReadResult;
import com.google.android.gms.fitness.result.SessionStopResult;
import com.google.android.gms.internal.jx;

public abstract interface SessionsApi
{
  public abstract PendingResult<Status> insertSession(GoogleApiClient paramGoogleApiClient, SessionInsertRequest paramSessionInsertRequest);
  
  public abstract PendingResult<SessionReadResult> readSession(GoogleApiClient paramGoogleApiClient, SessionReadRequest paramSessionReadRequest);
  
  public abstract PendingResult<Status> registerForSessions(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent);
  
  public abstract PendingResult<Status> startSession(GoogleApiClient paramGoogleApiClient, Session paramSession);
  
  public abstract PendingResult<SessionStopResult> stopSession(GoogleApiClient paramGoogleApiClient, String paramString);
  
  public abstract PendingResult<Status> unregisterForSessions(GoogleApiClient paramGoogleApiClient, PendingIntent paramPendingIntent);
  
  public static class ViewIntentBuilder
  {
    private String TP;
    private Session TQ;
    private boolean TR = false;
    private final Context mContext;
    
    public ViewIntentBuilder(Context paramContext)
    {
      this.mContext = paramContext;
    }
    
    private Intent i(Intent paramIntent)
    {
      if (this.TP == null) {}
      Intent localIntent;
      ResolveInfo localResolveInfo;
      do
      {
        return paramIntent;
        localIntent = new Intent(paramIntent).setPackage(this.TP);
        localResolveInfo = this.mContext.getPackageManager().resolveActivity(localIntent, 0);
      } while (localResolveInfo == null);
      String str = localResolveInfo.activityInfo.name;
      localIntent.setComponent(new ComponentName(this.TP, str));
      return localIntent;
    }
    
    public Intent build()
    {
      if (this.TQ != null) {}
      for (boolean bool = true;; bool = false)
      {
        jx.a(bool, "Session must be set");
        Intent localIntent = new Intent("vnd.google.fitness.VIEW");
        localIntent.setType(Session.getMimeType(this.TQ.getActivity()));
        c.a(this.TQ, localIntent, "vnd.google.fitness.session");
        if (!this.TR) {
          this.TP = this.TQ.getAppPackageName();
        }
        return i(localIntent);
      }
    }
    
    public ViewIntentBuilder setPreferredApplication(String paramString)
    {
      this.TP = paramString;
      this.TR = true;
      return this;
    }
    
    public ViewIntentBuilder setSession(Session paramSession)
    {
      this.TQ = paramSession;
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.SessionsApi
 * JD-Core Version:    0.7.0.1
 */