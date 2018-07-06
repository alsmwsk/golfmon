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
import com.google.android.gms.maps.internal.IGoogleMapDelegate;
import com.google.android.gms.maps.internal.IMapViewDelegate;
import com.google.android.gms.maps.internal.MapLifecycleDelegate;
import com.google.android.gms.maps.internal.c;
import com.google.android.gms.maps.internal.m.a;
import com.google.android.gms.maps.internal.x;
import com.google.android.gms.maps.model.RuntimeRemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MapView
  extends FrameLayout
{
  private GoogleMap akS;
  private final b akY;
  
  public MapView(Context paramContext)
  {
    super(paramContext);
    this.akY = new b(this, paramContext, null);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.akY = new b(this, paramContext, GoogleMapOptions.createFromAttributes(paramContext, paramAttributeSet));
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.akY = new b(this, paramContext, GoogleMapOptions.createFromAttributes(paramContext, paramAttributeSet));
  }
  
  public MapView(Context paramContext, GoogleMapOptions paramGoogleMapOptions)
  {
    super(paramContext);
    this.akY = new b(this, paramContext, paramGoogleMapOptions);
  }
  
  @Deprecated
  public final GoogleMap getMap()
  {
    if (this.akS != null) {
      return this.akS;
    }
    this.akY.nO();
    if (this.akY.je() == null) {
      return null;
    }
    try
    {
      this.akS = new GoogleMap(((a)this.akY.je()).nP().getMap());
      return this.akS;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeRemoteException(localRemoteException);
    }
  }
  
  public void getMapAsync(OnMapReadyCallback paramOnMapReadyCallback)
  {
    jx.aU("getMapAsync() must be called on the main thread");
    this.akY.getMapAsync(paramOnMapReadyCallback);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    this.akY.onCreate(paramBundle);
    if (this.akY.je() == null) {
      a.b(this);
    }
  }
  
  public final void onDestroy()
  {
    this.akY.onDestroy();
  }
  
  public final void onLowMemory()
  {
    this.akY.onLowMemory();
  }
  
  public final void onPause()
  {
    this.akY.onPause();
  }
  
  public final void onResume()
  {
    this.akY.onResume();
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    this.akY.onSaveInstanceState(paramBundle);
  }
  
  static class a
    implements MapLifecycleDelegate
  {
    private final ViewGroup akZ;
    private final IMapViewDelegate ala;
    private View alb;
    
    public a(ViewGroup paramViewGroup, IMapViewDelegate paramIMapViewDelegate)
    {
      this.ala = ((IMapViewDelegate)jx.i(paramIMapViewDelegate));
      this.akZ = ((ViewGroup)jx.i(paramViewGroup));
    }
    
    public void getMapAsync(final OnMapReadyCallback paramOnMapReadyCallback)
    {
      try
      {
        this.ala.getMapAsync(new m.a()
        {
          public void a(IGoogleMapDelegate paramAnonymousIGoogleMapDelegate)
            throws RemoteException
          {
            paramOnMapReadyCallback.onMapReady(new GoogleMap(paramAnonymousIGoogleMapDelegate));
          }
        });
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public IMapViewDelegate nP()
    {
      return this.ala;
    }
    
    public void onCreate(Bundle paramBundle)
    {
      try
      {
        this.ala.onCreate(paramBundle);
        this.alb = ((View)e.f(this.ala.getView()));
        this.akZ.removeAllViews();
        this.akZ.addView(this.alb);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      throw new UnsupportedOperationException("onCreateView not allowed on MapViewDelegate");
    }
    
    public void onDestroy()
    {
      try
      {
        this.ala.onDestroy();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
      }
    }
    
    public void onDestroyView()
    {
      throw new UnsupportedOperationException("onDestroyView not allowed on MapViewDelegate");
    }
    
    public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      throw new UnsupportedOperationException("onInflate not allowed on MapViewDelegate");
    }
    
    public void onLowMemory()
    {
      try
      {
        this.ala.onLowMemory();
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
        this.ala.onPause();
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
        this.ala.onResume();
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
        this.ala.onSaveInstanceState(paramBundle);
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
    extends a<MapView.a>
  {
    protected f<MapView.a> akW;
    private final List<OnMapReadyCallback> akX = new ArrayList();
    private final ViewGroup ald;
    private final GoogleMapOptions ale;
    private final Context mContext;
    
    b(ViewGroup paramViewGroup, Context paramContext, GoogleMapOptions paramGoogleMapOptions)
    {
      this.ald = paramViewGroup;
      this.mContext = paramContext;
      this.ale = paramGoogleMapOptions;
    }
    
    protected void a(f<MapView.a> paramf)
    {
      this.akW = paramf;
      nO();
    }
    
    public void getMapAsync(OnMapReadyCallback paramOnMapReadyCallback)
    {
      if (je() != null)
      {
        ((MapView.a)je()).getMapAsync(paramOnMapReadyCallback);
        return;
      }
      this.akX.add(paramOnMapReadyCallback);
    }
    
    public void nO()
    {
      if ((this.akW != null) && (je() == null)) {}
      try
      {
        IMapViewDelegate localIMapViewDelegate = x.S(this.mContext).a(e.k(this.mContext), this.ale);
        this.akW.a(new MapView.a(this.ald, localIMapViewDelegate));
        Iterator localIterator = this.akX.iterator();
        while (localIterator.hasNext())
        {
          OnMapReadyCallback localOnMapReadyCallback = (OnMapReadyCallback)localIterator.next();
          ((MapView.a)je()).getMapAsync(localOnMapReadyCallback);
        }
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeRemoteException(localRemoteException);
        this.akX.clear();
        return;
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException) {}
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.MapView
 * JD-Core Version:    0.7.0.1
 */