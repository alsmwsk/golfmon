package com.google.android.gms.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.RemoteException;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.appindexing.AppIndexApi.ActionResult;
import com.google.android.gms.appindexing.AppIndexApi.AppIndexingLink;
import com.google.android.gms.common.api.BaseImplementation.a;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import java.util.Iterator;
import java.util.List;

public final class hz
  implements AppIndexApi, ht
{
  public static Intent a(String paramString, Uri paramUri)
  {
    b(paramString, paramUri);
    List localList = paramUri.getPathSegments();
    String str = (String)localList.get(0);
    Uri.Builder localBuilder = new Uri.Builder();
    localBuilder.scheme(str);
    if (localList.size() > 1)
    {
      localBuilder.authority((String)localList.get(1));
      for (int i = 2; i < localList.size(); i++) {
        localBuilder.appendPath((String)localList.get(i));
      }
    }
    localBuilder.encodedQuery(paramUri.getEncodedQuery());
    localBuilder.encodedFragment(paramUri.getEncodedFragment());
    return new Intent("android.intent.action.VIEW", localBuilder.build());
  }
  
  private static void b(String paramString, Uri paramUri)
  {
    if (!"android-app".equals(paramUri.getScheme())) {
      throw new IllegalArgumentException("AppIndex: The URI scheme must be 'android-app' and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + paramUri);
    }
    String str = paramUri.getHost();
    if ((paramString != null) && (!paramString.equals(str))) {
      throw new IllegalArgumentException("AppIndex: The URI host must match the package name and follow the format (android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + paramUri);
    }
    List localList = paramUri.getPathSegments();
    if ((localList.isEmpty()) || (((String)localList.get(0)).isEmpty())) {
      throw new IllegalArgumentException("AppIndex: The app URI scheme must exist and follow the format android-app://<package_name>/<scheme>/[host_path]). Provided URI: " + paramUri);
    }
  }
  
  public static void c(List<AppIndexApi.AppIndexingLink> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext()) {
        b(null, ((AppIndexApi.AppIndexingLink)localIterator.next()).appIndexingUrl);
      }
    }
  }
  
  public PendingResult<Status> a(GoogleApiClient paramGoogleApiClient, final hr... paramVarArgs)
  {
    paramGoogleApiClient.a(new c(paramGoogleApiClient)
    {
      protected void a(hu paramAnonymoushu)
        throws RemoteException
      {
        paramAnonymoushu.a(new hz.d(this), this.DB, paramVarArgs);
      }
    });
  }
  
  public AppIndexApi.ActionResult action(GoogleApiClient paramGoogleApiClient, Action paramAction)
  {
    String str1 = ((hx)paramGoogleApiClient.a(hc.CG)).getContext().getPackageName();
    long l = System.currentTimeMillis();
    String str2 = String.valueOf(l);
    hr[] arrayOfhr = new hr[1];
    arrayOfhr[0] = hy.a(paramAction, str2, l, str1, 0);
    return new a(this, a(paramGoogleApiClient, arrayOfhr), paramAction, str2);
  }
  
  public PendingResult<Status> view(GoogleApiClient paramGoogleApiClient, Activity paramActivity, Intent paramIntent, String paramString, Uri paramUri, List<AppIndexApi.AppIndexingLink> paramList)
  {
    String str = ((hx)paramGoogleApiClient.a(hc.CG)).getContext().getPackageName();
    c(paramList);
    hr[] arrayOfhr = new hr[1];
    arrayOfhr[0] = new hr(str, paramIntent, paramString, paramUri, null, paramList);
    return a(paramGoogleApiClient, arrayOfhr);
  }
  
  public PendingResult<Status> view(GoogleApiClient paramGoogleApiClient, Activity paramActivity, Uri paramUri1, String paramString, Uri paramUri2, List<AppIndexApi.AppIndexingLink> paramList)
  {
    String str = ((hx)paramGoogleApiClient.a(hc.CG)).getContext().getPackageName();
    b(str, paramUri1);
    return view(paramGoogleApiClient, paramActivity, a(str, paramUri1), paramString, paramUri2, paramList);
  }
  
  public PendingResult<Status> viewEnd(GoogleApiClient paramGoogleApiClient, Activity paramActivity, Intent paramIntent)
  {
    return a(paramGoogleApiClient, new hr[] { new hr(hr.a(((hx)paramGoogleApiClient.a(hc.CG)).getContext().getPackageName(), paramIntent), System.currentTimeMillis(), 3) });
  }
  
  public PendingResult<Status> viewEnd(GoogleApiClient paramGoogleApiClient, Activity paramActivity, Uri paramUri)
  {
    return viewEnd(paramGoogleApiClient, paramActivity, a(((hx)paramGoogleApiClient.a(hc.CG)).getContext().getPackageName(), paramUri));
  }
  
  private static final class a
    implements AppIndexApi.ActionResult
  {
    private hz DE;
    private PendingResult<Status> DF;
    private Action DG;
    private String DH;
    
    a(hz paramhz, PendingResult<Status> paramPendingResult, Action paramAction, String paramString)
    {
      this.DE = paramhz;
      this.DF = paramPendingResult;
      this.DG = paramAction;
      this.DH = paramString;
    }
    
    public PendingResult<Status> end(GoogleApiClient paramGoogleApiClient)
    {
      String str = ((hx)paramGoogleApiClient.a(hc.CG)).getContext().getPackageName();
      long l = System.currentTimeMillis();
      hr localhr = hy.a(this.DG, this.DH, l, str, 3);
      return this.DE.a(paramGoogleApiClient, new hr[] { localhr });
    }
    
    public PendingResult<Status> getPendingResult()
    {
      return this.DF;
    }
  }
  
  private static abstract class b<T extends Result>
    extends BaseImplementation.a<T, hx>
  {
    public b(GoogleApiClient paramGoogleApiClient)
    {
      super(paramGoogleApiClient);
    }
    
    protected abstract void a(hu paramhu)
      throws RemoteException;
    
    protected final void a(hx paramhx)
      throws RemoteException
    {
      a(paramhx.fH());
    }
  }
  
  private static abstract class c<T extends Result>
    extends hz.b<Status>
  {
    c(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    protected Status b(Status paramStatus)
    {
      return paramStatus;
    }
  }
  
  private static final class d
    extends hw<Status>
  {
    public d(BaseImplementation.b<Status> paramb)
    {
      super();
    }
    
    public void a(Status paramStatus)
    {
      this.DA.b(paramStatus);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hz
 * JD-Core Version:    0.7.0.1
 */