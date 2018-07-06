package com.google.android.gms.maps;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.jx;
import com.google.android.gms.maps.internal.IStreetViewPanoramaDelegate;
import com.google.android.gms.maps.internal.IStreetViewPanoramaViewDelegate;
import com.google.android.gms.maps.internal.StreetViewLifecycleDelegate;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.internal.u.a;
import com.google.android.gms.maps.internal.x;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StreetViewPanoramaView
  extends FrameLayout
{
  private StreetViewPanorama alm;
  private final b aly;
  
  public StreetViewPanoramaView(Context paramContext)
  {
    super(paramContext);
    this.aly = new b(this, paramContext, null);
  }
  
  public StreetViewPanoramaView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.aly = new b(this, paramContext, null);
  }
  
  public StreetViewPanoramaView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.aly = new b(this, paramContext, null);
  }
  
  public StreetViewPanoramaView(Context paramContext, StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
  {
    super(paramContext);
    this.aly = new b(this, paramContext, paramStreetViewPanoramaOptions);
  }
  
  @Deprecated
  public final StreetViewPanorama getStreetViewPanorama()
  {
    if (this.alm != null) {
      return this.alm;
    }
    this.aly.nO();
    if (this.aly.je() == null) {
      return null;
    }
    try
    {
      this.alm = new StreetViewPanorama(((a)this.aly.je()).nV().getStreetViewPanorama());
      return this.alm;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback paramOnStreetViewPanoramaReadyCallback)
  {
    jx.aU("getStreetViewPanoramaAsync() must be called on the main thread");
    this.aly.getStreetViewPanoramaAsync(paramOnStreetViewPanoramaReadyCallback);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    this.aly.onCreate(paramBundle);
    if (this.aly.je() == null) {
      a.b(this);
    }
  }
  
  public final void onDestroy()
  {
    this.aly.onDestroy();
  }
  
  public final void onLowMemory()
  {
    this.aly.onLowMemory();
  }
  
  public final void onPause()
  {
    this.aly.onPause();
  }
  
  public final void onResume()
  {
    this.aly.onResume();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    this.aly.onSaveInstanceState(paramBundle);
  }
  
  static class a
    implements StreetViewLifecycleDelegate
  {
    private final ViewGroup akZ;
    private View alA;
    private final IStreetViewPanoramaViewDelegate alz;
    
    public a(ViewGroup paramViewGroup, IStreetViewPanoramaViewDelegate paramIStreetViewPanoramaViewDelegate)
    {
      this.alz = ((IStreetViewPanoramaViewDelegate)jx.i(paramIStreetViewPanoramaViewDelegate));
      this.akZ = ((ViewGroup)jx.i(paramViewGroup));
    }
    
    public void getStreetViewPanoramaAsync(final OnStreetViewPanoramaReadyCallback paramOnStreetViewPanoramaReadyCallback)
    {
      try
      {
        this.alz.getStreetViewPanoramaAsync(new u.a()
        {
          public void a(IStreetViewPanoramaDelegate paramAnonymousIStreetViewPanoramaDelegate)
            throws RemoteException
          {
            paramOnStreetViewPanoramaReadyCallback.onStreetViewPanoramaReady(new StreetViewPanorama(paramAnonymousIStreetViewPanoramaDelegate));
          }
        });
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public IStreetViewPanoramaViewDelegate nV()
    {
      return this.alz;
    }
    
    public void onCreate(Bundle paramBundle)
    {
      try
      {
        this.alz.onCreate(paramBundle);
        this.alA = ((View)e.f(this.alz.getView()));
        this.akZ.removeAllViews();
        this.akZ.addView(this.alA);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      throw new UnsupportedOperationException("onCreateView not allowed on StreetViewPanoramaViewDelegate");
    }
    
    public void onDestroy()
    {
      try
      {
        this.alz.onDestroy();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onDestroyView()
    {
      throw new UnsupportedOperationException("onDestroyView not allowed on StreetViewPanoramaViewDelegate");
    }
    
    public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      throw new UnsupportedOperationException("onInflate not allowed on StreetViewPanoramaViewDelegate");
    }
    
    public void onLowMemory()
    {
      try
      {
        this.alz.onLowMemory();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onPause()
    {
      try
      {
        this.alz.onPause();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onResume()
    {
      try
      {
        this.alz.onResume();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onSaveInstanceState(Bundle paramBundle)
    {
      try
      {
        this.alz.onSaveInstanceState(paramBundle);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onStart() {}
    
    public void onStop() {}
  }
  
  static class b
    extends a<StreetViewPanoramaView.a>
  {
    protected f<StreetViewPanoramaView.a> akW;
    private final StreetViewPanoramaOptions alC;
    private final ViewGroup ald;
    private final List<OnStreetViewPanoramaReadyCallback> alq = new ArrayList();
    private final Context mContext;
    
    b(ViewGroup paramViewGroup, Context paramContext, StreetViewPanoramaOptions paramStreetViewPanoramaOptions)
    {
      this.ald = paramViewGroup;
      this.mContext = paramContext;
      this.alC = paramStreetViewPanoramaOptions;
    }
    
    protected void a(f<StreetViewPanoramaView.a> paramf)
    {
      this.akW = paramf;
      nO();
    }
    
    public void getStreetViewPanoramaAsync(OnStreetViewPanoramaReadyCallback paramOnStreetViewPanoramaReadyCallback)
    {
      if (je() != null)
      {
        ((StreetViewPanoramaView.a)je()).getStreetViewPanoramaAsync(paramOnStreetViewPanoramaReadyCallback);
        return;
      }
      this.alq.add(paramOnStreetViewPanoramaReadyCallback);
    }
    
    public void nO()
    {
      if ((this.akW != null) && (je() == null)) {}
      try
      {
        IStreetViewPanoramaViewDelegate localIStreetViewPanoramaViewDelegate = x.S(this.mContext).a(e.k(this.mContext), this.alC);
        this.akW.a(new StreetViewPanoramaView.a(this.ald, localIStreetViewPanoramaViewDelegate));
        Iterator localIterator = this.alq.iterator();
        while (localIterator.hasNext())
        {
          OnStreetViewPanoramaReadyCallback localOnStreetViewPanoramaReadyCallback = (OnStreetViewPanoramaReadyCallback)localIterator.next();
          ((StreetViewPanoramaView.a)je()).getStreetViewPanoramaAsync(localOnStreetViewPanoramaReadyCallback);
        }
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
        this.alq.clear();
        return;
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException) {}
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.StreetViewPanoramaView
 * JD-Core Version:    0.7.0.1
 */