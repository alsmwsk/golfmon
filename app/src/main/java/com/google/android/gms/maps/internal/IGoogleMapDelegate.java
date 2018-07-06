package com.google.android.gms.maps.internal;

import android.location.Location;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;
import com.google.android.gms.maps.model.internal.i;
import com.google.android.gms.maps.model.internal.i.a;
import com.google.android.gms.maps.model.w;

public abstract interface IGoogleMapDelegate
  extends IInterface
{
  public abstract com.google.android.gms.maps.model.internal.h addCircle(CircleOptions paramCircleOptions)
    throws RemoteException;
  
  public abstract i addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions)
    throws RemoteException;
  
  public abstract i addGroundOverlay2(GroundOverlayOptions paramGroundOverlayOptions, com.google.android.gms.maps.model.internal.e parame)
    throws RemoteException;
  
  public abstract com.google.android.gms.maps.model.internal.l addMarker(MarkerOptions paramMarkerOptions)
    throws RemoteException;
  
  public abstract com.google.android.gms.maps.model.internal.l addMarker2(MarkerOptions paramMarkerOptions, com.google.android.gms.maps.model.internal.p paramp)
    throws RemoteException;
  
  public abstract com.google.android.gms.maps.model.internal.m addPolygon(PolygonOptions paramPolygonOptions)
    throws RemoteException;
  
  public abstract IPolylineDelegate addPolyline(PolylineOptions paramPolylineOptions)
    throws RemoteException;
  
  public abstract com.google.android.gms.maps.model.internal.n addTileOverlay(TileOverlayOptions paramTileOverlayOptions)
    throws RemoteException;
  
  public abstract void animateCamera(com.google.android.gms.dynamic.d paramd)
    throws RemoteException;
  
  public abstract void animateCamera2(com.google.android.gms.maps.model.internal.c paramc)
    throws RemoteException;
  
  public abstract void animateCameraWithCallback(com.google.android.gms.dynamic.d paramd, b paramb)
    throws RemoteException;
  
  public abstract void animateCameraWithCallback2(com.google.android.gms.maps.model.internal.c paramc, b paramb)
    throws RemoteException;
  
  public abstract void animateCameraWithDurationAndCallback(com.google.android.gms.dynamic.d paramd, int paramInt, b paramb)
    throws RemoteException;
  
  public abstract void animateCameraWithDurationAndCallback2(com.google.android.gms.maps.model.internal.c paramc, int paramInt, b paramb)
    throws RemoteException;
  
  public abstract void clear()
    throws RemoteException;
  
  public abstract CameraPosition getCameraPosition()
    throws RemoteException;
  
  public abstract com.google.android.gms.maps.model.internal.j getFocusedBuilding()
    throws RemoteException;
  
  public abstract void getMapAsync(m paramm)
    throws RemoteException;
  
  public abstract int getMapType()
    throws RemoteException;
  
  public abstract float getMaxZoomLevel()
    throws RemoteException;
  
  public abstract float getMinZoomLevel()
    throws RemoteException;
  
  public abstract Location getMyLocation()
    throws RemoteException;
  
  public abstract IProjectionDelegate getProjection()
    throws RemoteException;
  
  public abstract IUiSettingsDelegate getUiSettings()
    throws RemoteException;
  
  public abstract boolean isBuildingsEnabled()
    throws RemoteException;
  
  public abstract boolean isIndoorEnabled()
    throws RemoteException;
  
  public abstract boolean isMyLocationEnabled()
    throws RemoteException;
  
  public abstract boolean isTrafficEnabled()
    throws RemoteException;
  
  public abstract void moveCamera(com.google.android.gms.dynamic.d paramd)
    throws RemoteException;
  
  public abstract void moveCamera2(com.google.android.gms.maps.model.internal.c paramc)
    throws RemoteException;
  
  public abstract void onCreate(Bundle paramBundle)
    throws RemoteException;
  
  public abstract void onDestroy()
    throws RemoteException;
  
  public abstract void onLowMemory()
    throws RemoteException;
  
  public abstract void onPause()
    throws RemoteException;
  
  public abstract void onResume()
    throws RemoteException;
  
  public abstract void onSaveInstanceState(Bundle paramBundle)
    throws RemoteException;
  
  public abstract void setBuildingsEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setContentDescription(String paramString)
    throws RemoteException;
  
  public abstract boolean setIndoorEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setInfoWindowAdapter(d paramd)
    throws RemoteException;
  
  public abstract void setInfoWindowRenderer(e parame)
    throws RemoteException;
  
  public abstract void setLocationSource(ILocationSourceDelegate paramILocationSourceDelegate)
    throws RemoteException;
  
  public abstract void setMapType(int paramInt)
    throws RemoteException;
  
  public abstract void setMyLocationEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void setOnCameraChangeListener(f paramf)
    throws RemoteException;
  
  public abstract void setOnIndoorStateChangeListener(g paramg)
    throws RemoteException;
  
  public abstract void setOnInfoWindowClickListener(h paramh)
    throws RemoteException;
  
  public abstract void setOnMapClickListener(j paramj)
    throws RemoteException;
  
  public abstract void setOnMapLoadedCallback(k paramk)
    throws RemoteException;
  
  public abstract void setOnMapLongClickListener(l paraml)
    throws RemoteException;
  
  public abstract void setOnMarkerClickListener(n paramn)
    throws RemoteException;
  
  public abstract void setOnMarkerDragListener(o paramo)
    throws RemoteException;
  
  public abstract void setOnMyLocationButtonClickListener(p paramp)
    throws RemoteException;
  
  public abstract void setOnMyLocationChangeListener(q paramq)
    throws RemoteException;
  
  public abstract void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws RemoteException;
  
  public abstract void setTrafficEnabled(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void snapshot(v paramv, com.google.android.gms.dynamic.d paramd)
    throws RemoteException;
  
  public abstract void stopAnimation()
    throws RemoteException;
  
  public abstract boolean useViewLifecycleWhenInFragment()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements IGoogleMapDelegate
  {
    public static IGoogleMapDelegate aT(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      if ((localIInterface != null) && ((localIInterface instanceof IGoogleMapDelegate))) {
        return (IGoogleMapDelegate)localIInterface;
      }
      return new a(paramIBinder);
    }
    
    public boolean onTransact(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
      throws RemoteException
    {
      switch (paramInt1)
      {
      default: 
        return super.onTransact(paramInt1, paramParcel1, paramParcel2, paramInt2);
      case 1598968902: 
        paramParcel2.writeString("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        CameraPosition localCameraPosition = getCameraPosition();
        paramParcel2.writeNoException();
        if (localCameraPosition != null)
        {
          paramParcel2.writeInt(1);
          localCameraPosition.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        float f2 = getMaxZoomLevel();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f2);
        return true;
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        float f1 = getMinZoomLevel();
        paramParcel2.writeNoException();
        paramParcel2.writeFloat(f1);
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        moveCamera(com.google.android.gms.dynamic.d.a.ap(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        animateCamera(com.google.android.gms.dynamic.d.a.ap(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        animateCameraWithCallback(com.google.android.gms.dynamic.d.a.ap(paramParcel1.readStrongBinder()), b.a.aR(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        animateCameraWithDurationAndCallback(com.google.android.gms.dynamic.d.a.ap(paramParcel1.readStrongBinder()), paramParcel1.readInt(), b.a.aR(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        stopAnimation();
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0) {}
        for (PolylineOptions localPolylineOptions = PolylineOptions.CREATOR.dh(paramParcel1);; localPolylineOptions = null)
        {
          IPolylineDelegate localIPolylineDelegate = addPolyline(localPolylineOptions);
          paramParcel2.writeNoException();
          IBinder localIBinder11 = null;
          if (localIPolylineDelegate != null) {
            localIBinder11 = localIPolylineDelegate.asBinder();
          }
          paramParcel2.writeStrongBinder(localIBinder11);
          return true;
        }
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0) {}
        for (PolygonOptions localPolygonOptions = PolygonOptions.CREATOR.dg(paramParcel1);; localPolygonOptions = null)
        {
          com.google.android.gms.maps.model.internal.m localm = addPolygon(localPolygonOptions);
          paramParcel2.writeNoException();
          IBinder localIBinder10 = null;
          if (localm != null) {
            localIBinder10 = localm.asBinder();
          }
          paramParcel2.writeStrongBinder(localIBinder10);
          return true;
        }
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0) {}
        for (MarkerOptions localMarkerOptions2 = MarkerOptions.CREATOR.df(paramParcel1);; localMarkerOptions2 = null)
        {
          com.google.android.gms.maps.model.internal.l locall2 = addMarker(localMarkerOptions2);
          paramParcel2.writeNoException();
          IBinder localIBinder9 = null;
          if (locall2 != null) {
            localIBinder9 = locall2.asBinder();
          }
          paramParcel2.writeStrongBinder(localIBinder9);
          return true;
        }
      case 12: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0) {}
        for (GroundOverlayOptions localGroundOverlayOptions2 = GroundOverlayOptions.CREATOR.dc(paramParcel1);; localGroundOverlayOptions2 = null)
        {
          i locali2 = addGroundOverlay(localGroundOverlayOptions2);
          paramParcel2.writeNoException();
          IBinder localIBinder8 = null;
          if (locali2 != null) {
            localIBinder8 = locali2.asBinder();
          }
          paramParcel2.writeStrongBinder(localIBinder8);
          return true;
        }
      case 13: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0) {}
        for (TileOverlayOptions localTileOverlayOptions = TileOverlayOptions.CREATOR.dn(paramParcel1);; localTileOverlayOptions = null)
        {
          com.google.android.gms.maps.model.internal.n localn = addTileOverlay(localTileOverlayOptions);
          paramParcel2.writeNoException();
          IBinder localIBinder7 = null;
          if (localn != null) {
            localIBinder7 = localn.asBinder();
          }
          paramParcel2.writeStrongBinder(localIBinder7);
          return true;
        }
      case 14: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        clear();
        paramParcel2.writeNoException();
        return true;
      case 15: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        int i9 = getMapType();
        paramParcel2.writeNoException();
        paramParcel2.writeInt(i9);
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setMapType(paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 17: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        boolean bool10 = isTrafficEnabled();
        paramParcel2.writeNoException();
        if (bool10) {}
        for (int i8 = 1;; i8 = 0)
        {
          paramParcel2.writeInt(i8);
          return true;
        }
      case 18: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        int i7 = paramParcel1.readInt();
        boolean bool9 = false;
        if (i7 != 0) {
          bool9 = true;
        }
        setTrafficEnabled(bool9);
        paramParcel2.writeNoException();
        return true;
      case 19: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        boolean bool8 = isIndoorEnabled();
        paramParcel2.writeNoException();
        int i6 = 0;
        if (bool8) {
          i6 = 1;
        }
        paramParcel2.writeInt(i6);
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0) {}
        for (boolean bool6 = true;; bool6 = false)
        {
          boolean bool7 = setIndoorEnabled(bool6);
          paramParcel2.writeNoException();
          int i5 = 0;
          if (bool7) {
            i5 = 1;
          }
          paramParcel2.writeInt(i5);
          return true;
        }
      case 21: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        boolean bool5 = isMyLocationEnabled();
        paramParcel2.writeNoException();
        int i4 = 0;
        if (bool5) {
          i4 = 1;
        }
        paramParcel2.writeInt(i4);
        return true;
      case 22: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        int i3 = paramParcel1.readInt();
        boolean bool4 = false;
        if (i3 != 0) {
          bool4 = true;
        }
        setMyLocationEnabled(bool4);
        paramParcel2.writeNoException();
        return true;
      case 23: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        Location localLocation = getMyLocation();
        paramParcel2.writeNoException();
        if (localLocation != null)
        {
          paramParcel2.writeInt(1);
          localLocation.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 24: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setLocationSource(ILocationSourceDelegate.a.aW(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 25: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        IUiSettingsDelegate localIUiSettingsDelegate = getUiSettings();
        paramParcel2.writeNoException();
        IBinder localIBinder6 = null;
        if (localIUiSettingsDelegate != null) {
          localIBinder6 = localIUiSettingsDelegate.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder6);
        return true;
      case 26: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        IProjectionDelegate localIProjectionDelegate = getProjection();
        paramParcel2.writeNoException();
        IBinder localIBinder5 = null;
        if (localIProjectionDelegate != null) {
          localIBinder5 = localIProjectionDelegate.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder5);
        return true;
      case 27: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnCameraChangeListener(f.a.aZ(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 28: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMapClickListener(j.a.bd(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 29: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMapLongClickListener(l.a.bf(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 30: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMarkerClickListener(n.a.bh(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 31: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMarkerDragListener(o.a.bi(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 32: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnInfoWindowClickListener(h.a.bb(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 33: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setInfoWindowAdapter(d.a.aU(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 35: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0) {}
        for (CircleOptions localCircleOptions = CircleOptions.CREATOR.db(paramParcel1);; localCircleOptions = null)
        {
          com.google.android.gms.maps.model.internal.h localh = addCircle(localCircleOptions);
          paramParcel2.writeNoException();
          IBinder localIBinder4 = null;
          if (localh != null) {
            localIBinder4 = localh.asBinder();
          }
          paramParcel2.writeStrongBinder(localIBinder4);
          return true;
        }
      case 36: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMyLocationChangeListener(q.a.bk(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 37: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMyLocationButtonClickListener(p.a.bj(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 38: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        snapshot(v.a.bq(paramParcel1.readStrongBinder()), com.google.android.gms.dynamic.d.a.ap(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 39: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setPadding(paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt(), paramParcel1.readInt());
        paramParcel2.writeNoException();
        return true;
      case 40: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        boolean bool3 = isBuildingsEnabled();
        paramParcel2.writeNoException();
        int i2 = 0;
        if (bool3) {
          i2 = 1;
        }
        paramParcel2.writeInt(i2);
        return true;
      case 41: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        int i1 = paramParcel1.readInt();
        boolean bool2 = false;
        if (i1 != 0) {
          bool2 = true;
        }
        setBuildingsEnabled(bool2);
        paramParcel2.writeNoException();
        return true;
      case 42: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnMapLoadedCallback(k.a.be(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 44: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        com.google.android.gms.maps.model.internal.j localj = getFocusedBuilding();
        paramParcel2.writeNoException();
        IBinder localIBinder3 = null;
        if (localj != null) {
          localIBinder3 = localj.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder3);
        return true;
      case 45: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setOnIndoorStateChangeListener(g.a.ba(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 53: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        getMapAsync(m.a.bg(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 54: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0) {}
        for (Bundle localBundle2 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localBundle2 = null)
        {
          onCreate(localBundle2);
          paramParcel2.writeNoException();
          return true;
        }
      case 55: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        onResume();
        paramParcel2.writeNoException();
        return true;
      case 56: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        onPause();
        paramParcel2.writeNoException();
        return true;
      case 57: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        onDestroy();
        paramParcel2.writeNoException();
        return true;
      case 58: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        onLowMemory();
        paramParcel2.writeNoException();
        return true;
      case 59: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        boolean bool1 = useViewLifecycleWhenInFragment();
        paramParcel2.writeNoException();
        int n = 0;
        if (bool1) {
          n = 1;
        }
        paramParcel2.writeInt(n);
        return true;
      case 60: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        if (paramParcel1.readInt() != 0) {}
        for (Bundle localBundle1 = (Bundle)Bundle.CREATOR.createFromParcel(paramParcel1);; localBundle1 = null)
        {
          onSaveInstanceState(localBundle1);
          paramParcel2.writeNoException();
          if (localBundle1 == null) {
            break;
          }
          paramParcel2.writeInt(1);
          localBundle1.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 61: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setContentDescription(paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 64: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        int m = paramParcel1.readInt();
        com.google.android.gms.maps.model.internal.c localc4 = null;
        if (m != 0) {
          localc4 = com.google.android.gms.maps.model.internal.c.CREATOR.dq(paramParcel1);
        }
        moveCamera2(localc4);
        paramParcel2.writeNoException();
        return true;
      case 65: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        int k = paramParcel1.readInt();
        com.google.android.gms.maps.model.internal.c localc3 = null;
        if (k != 0) {
          localc3 = com.google.android.gms.maps.model.internal.c.CREATOR.dq(paramParcel1);
        }
        animateCamera2(localc3);
        paramParcel2.writeNoException();
        return true;
      case 66: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        int j = paramParcel1.readInt();
        com.google.android.gms.maps.model.internal.c localc2 = null;
        if (j != 0) {
          localc2 = com.google.android.gms.maps.model.internal.c.CREATOR.dq(paramParcel1);
        }
        animateCameraWithCallback2(localc2, b.a.aR(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 67: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        int i = paramParcel1.readInt();
        com.google.android.gms.maps.model.internal.c localc1 = null;
        if (i != 0) {
          localc1 = com.google.android.gms.maps.model.internal.c.CREATOR.dq(paramParcel1);
        }
        animateCameraWithDurationAndCallback2(localc1, paramParcel1.readInt(), b.a.aR(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 68: 
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        MarkerOptions localMarkerOptions1;
        if (paramParcel1.readInt() != 0)
        {
          localMarkerOptions1 = MarkerOptions.CREATOR.df(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label2501;
          }
        }
        for (com.google.android.gms.maps.model.internal.p localp = com.google.android.gms.maps.model.internal.p.CREATOR.ds(paramParcel1);; localp = null)
        {
          com.google.android.gms.maps.model.internal.l locall1 = addMarker2(localMarkerOptions1, localp);
          paramParcel2.writeNoException();
          IBinder localIBinder2 = null;
          if (locall1 != null) {
            localIBinder2 = locall1.asBinder();
          }
          paramParcel2.writeStrongBinder(localIBinder2);
          return true;
          localMarkerOptions1 = null;
          break;
        }
      case 69: 
        label2501:
        paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
        setInfoWindowRenderer(e.a.aV(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.maps.internal.IGoogleMapDelegate");
      GroundOverlayOptions localGroundOverlayOptions1;
      if (paramParcel1.readInt() != 0)
      {
        localGroundOverlayOptions1 = GroundOverlayOptions.CREATOR.dc(paramParcel1);
        if (paramParcel1.readInt() == 0) {
          break label2613;
        }
      }
      label2613:
      for (com.google.android.gms.maps.model.internal.e locale = com.google.android.gms.maps.model.internal.e.CREATOR.dr(paramParcel1);; locale = null)
      {
        i locali1 = addGroundOverlay2(localGroundOverlayOptions1, locale);
        paramParcel2.writeNoException();
        IBinder localIBinder1 = null;
        if (locali1 != null) {
          localIBinder1 = locali1.asBinder();
        }
        paramParcel2.writeStrongBinder(localIBinder1);
        return true;
        localGroundOverlayOptions1 = null;
        break;
      }
    }
    
    private static class a
      implements IGoogleMapDelegate
    {
      private IBinder le;
      
      a(IBinder paramIBinder)
      {
        this.le = paramIBinder;
      }
      
      /* Error */
      public com.google.android.gms.maps.model.internal.h addCircle(CircleOptions paramCircleOptions)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +53 -> 68
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 41	com/google/android/gms/maps/model/CircleOptions:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   33: bipush 35
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 47 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 50	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 54	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   52: invokestatic 60	com/google/android/gms/maps/model/internal/h$a:bw	(Landroid/os/IBinder;)Lcom/google/android/gms/maps/model/internal/h;
        //   55: astore 6
        //   57: aload_3
        //   58: invokevirtual 63	android/os/Parcel:recycle	()V
        //   61: aload_2
        //   62: invokevirtual 63	android/os/Parcel:recycle	()V
        //   65: aload 6
        //   67: areturn
        //   68: aload_2
        //   69: iconst_0
        //   70: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   73: goto -44 -> 29
        //   76: astore 4
        //   78: aload_3
        //   79: invokevirtual 63	android/os/Parcel:recycle	()V
        //   82: aload_2
        //   83: invokevirtual 63	android/os/Parcel:recycle	()V
        //   86: aload 4
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	a
        //   0	89	1	paramCircleOptions	CircleOptions
        //   3	80	2	localParcel1	Parcel
        //   7	72	3	localParcel2	Parcel
        //   76	11	4	localObject	Object
        //   55	11	6	localh	com.google.android.gms.maps.model.internal.h
        // Exception table:
        //   from	to	target	type
        //   8	14	76	finally
        //   18	29	76	finally
        //   29	57	76	finally
        //   68	73	76	finally
      }
      
      /* Error */
      public i addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +53 -> 68
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 68	com/google/android/gms/maps/model/GroundOverlayOptions:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   33: bipush 12
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 47 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 50	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 54	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   52: invokestatic 74	com/google/android/gms/maps/model/internal/i$a:bx	(Landroid/os/IBinder;)Lcom/google/android/gms/maps/model/internal/i;
        //   55: astore 6
        //   57: aload_3
        //   58: invokevirtual 63	android/os/Parcel:recycle	()V
        //   61: aload_2
        //   62: invokevirtual 63	android/os/Parcel:recycle	()V
        //   65: aload 6
        //   67: areturn
        //   68: aload_2
        //   69: iconst_0
        //   70: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   73: goto -44 -> 29
        //   76: astore 4
        //   78: aload_3
        //   79: invokevirtual 63	android/os/Parcel:recycle	()V
        //   82: aload_2
        //   83: invokevirtual 63	android/os/Parcel:recycle	()V
        //   86: aload 4
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	a
        //   0	89	1	paramGroundOverlayOptions	GroundOverlayOptions
        //   3	80	2	localParcel1	Parcel
        //   7	72	3	localParcel2	Parcel
        //   76	11	4	localObject	Object
        //   55	11	6	locali	i
        // Exception table:
        //   from	to	target	type
        //   8	14	76	finally
        //   18	29	76	finally
        //   29	57	76	finally
        //   68	73	76	finally
      }
      
      public i addGroundOverlay2(GroundOverlayOptions paramGroundOverlayOptions, com.google.android.gms.maps.model.internal.e parame)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if (paramGroundOverlayOptions != null)
            {
              localParcel1.writeInt(1);
              paramGroundOverlayOptions.writeToParcel(localParcel1, 0);
              if (parame != null)
              {
                localParcel1.writeInt(1);
                parame.writeToParcel(localParcel1, 0);
                this.le.transact(70, localParcel1, localParcel2, 0);
                localParcel2.readException();
                i locali = i.a.bx(localParcel2.readStrongBinder());
                return locali;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public com.google.android.gms.maps.model.internal.l addMarker(MarkerOptions paramMarkerOptions)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +53 -> 68
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 84	com/google/android/gms/maps/model/MarkerOptions:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   33: bipush 11
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 47 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 50	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 54	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   52: invokestatic 90	com/google/android/gms/maps/model/internal/l$a:bA	(Landroid/os/IBinder;)Lcom/google/android/gms/maps/model/internal/l;
        //   55: astore 6
        //   57: aload_3
        //   58: invokevirtual 63	android/os/Parcel:recycle	()V
        //   61: aload_2
        //   62: invokevirtual 63	android/os/Parcel:recycle	()V
        //   65: aload 6
        //   67: areturn
        //   68: aload_2
        //   69: iconst_0
        //   70: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   73: goto -44 -> 29
        //   76: astore 4
        //   78: aload_3
        //   79: invokevirtual 63	android/os/Parcel:recycle	()V
        //   82: aload_2
        //   83: invokevirtual 63	android/os/Parcel:recycle	()V
        //   86: aload 4
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	a
        //   0	89	1	paramMarkerOptions	MarkerOptions
        //   3	80	2	localParcel1	Parcel
        //   7	72	3	localParcel2	Parcel
        //   76	11	4	localObject	Object
        //   55	11	6	locall	com.google.android.gms.maps.model.internal.l
        // Exception table:
        //   from	to	target	type
        //   8	14	76	finally
        //   18	29	76	finally
        //   29	57	76	finally
        //   68	73	76	finally
      }
      
      public com.google.android.gms.maps.model.internal.l addMarker2(MarkerOptions paramMarkerOptions, com.google.android.gms.maps.model.internal.p paramp)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if (paramMarkerOptions != null)
            {
              localParcel1.writeInt(1);
              paramMarkerOptions.writeToParcel(localParcel1, 0);
              if (paramp != null)
              {
                localParcel1.writeInt(1);
                paramp.writeToParcel(localParcel1, 0);
                this.le.transact(68, localParcel1, localParcel2, 0);
                localParcel2.readException();
                com.google.android.gms.maps.model.internal.l locall = com.google.android.gms.maps.model.internal.l.a.bA(localParcel2.readStrongBinder());
                return locall;
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            localParcel1.writeInt(0);
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public com.google.android.gms.maps.model.internal.m addPolygon(PolygonOptions paramPolygonOptions)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +53 -> 68
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 100	com/google/android/gms/maps/model/PolygonOptions:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   33: bipush 10
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 47 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 50	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 54	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   52: invokestatic 106	com/google/android/gms/maps/model/internal/m$a:bB	(Landroid/os/IBinder;)Lcom/google/android/gms/maps/model/internal/m;
        //   55: astore 6
        //   57: aload_3
        //   58: invokevirtual 63	android/os/Parcel:recycle	()V
        //   61: aload_2
        //   62: invokevirtual 63	android/os/Parcel:recycle	()V
        //   65: aload 6
        //   67: areturn
        //   68: aload_2
        //   69: iconst_0
        //   70: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   73: goto -44 -> 29
        //   76: astore 4
        //   78: aload_3
        //   79: invokevirtual 63	android/os/Parcel:recycle	()V
        //   82: aload_2
        //   83: invokevirtual 63	android/os/Parcel:recycle	()V
        //   86: aload 4
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	a
        //   0	89	1	paramPolygonOptions	PolygonOptions
        //   3	80	2	localParcel1	Parcel
        //   7	72	3	localParcel2	Parcel
        //   76	11	4	localObject	Object
        //   55	11	6	localm	com.google.android.gms.maps.model.internal.m
        // Exception table:
        //   from	to	target	type
        //   8	14	76	finally
        //   18	29	76	finally
        //   29	57	76	finally
        //   68	73	76	finally
      }
      
      /* Error */
      public IPolylineDelegate addPolyline(PolylineOptions paramPolylineOptions)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +53 -> 68
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 111	com/google/android/gms/maps/model/PolylineOptions:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   33: bipush 9
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 47 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 50	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 54	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   52: invokestatic 117	com/google/android/gms/maps/model/internal/IPolylineDelegate$a:bC	(Landroid/os/IBinder;)Lcom/google/android/gms/maps/model/internal/IPolylineDelegate;
        //   55: astore 6
        //   57: aload_3
        //   58: invokevirtual 63	android/os/Parcel:recycle	()V
        //   61: aload_2
        //   62: invokevirtual 63	android/os/Parcel:recycle	()V
        //   65: aload 6
        //   67: areturn
        //   68: aload_2
        //   69: iconst_0
        //   70: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   73: goto -44 -> 29
        //   76: astore 4
        //   78: aload_3
        //   79: invokevirtual 63	android/os/Parcel:recycle	()V
        //   82: aload_2
        //   83: invokevirtual 63	android/os/Parcel:recycle	()V
        //   86: aload 4
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	a
        //   0	89	1	paramPolylineOptions	PolylineOptions
        //   3	80	2	localParcel1	Parcel
        //   7	72	3	localParcel2	Parcel
        //   76	11	4	localObject	Object
        //   55	11	6	localIPolylineDelegate	IPolylineDelegate
        // Exception table:
        //   from	to	target	type
        //   8	14	76	finally
        //   18	29	76	finally
        //   29	57	76	finally
        //   68	73	76	finally
      }
      
      /* Error */
      public com.google.android.gms.maps.model.internal.n addTileOverlay(TileOverlayOptions paramTileOverlayOptions)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +53 -> 68
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 122	com/google/android/gms/maps/model/TileOverlayOptions:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   33: bipush 13
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 47 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 50	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 54	android/os/Parcel:readStrongBinder	()Landroid/os/IBinder;
        //   52: invokestatic 128	com/google/android/gms/maps/model/internal/n$a:bD	(Landroid/os/IBinder;)Lcom/google/android/gms/maps/model/internal/n;
        //   55: astore 6
        //   57: aload_3
        //   58: invokevirtual 63	android/os/Parcel:recycle	()V
        //   61: aload_2
        //   62: invokevirtual 63	android/os/Parcel:recycle	()V
        //   65: aload 6
        //   67: areturn
        //   68: aload_2
        //   69: iconst_0
        //   70: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   73: goto -44 -> 29
        //   76: astore 4
        //   78: aload_3
        //   79: invokevirtual 63	android/os/Parcel:recycle	()V
        //   82: aload_2
        //   83: invokevirtual 63	android/os/Parcel:recycle	()V
        //   86: aload 4
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	a
        //   0	89	1	paramTileOverlayOptions	TileOverlayOptions
        //   3	80	2	localParcel1	Parcel
        //   7	72	3	localParcel2	Parcel
        //   76	11	4	localObject	Object
        //   55	11	6	localn	com.google.android.gms.maps.model.internal.n
        // Exception table:
        //   from	to	target	type
        //   8	14	76	finally
        //   18	29	76	finally
        //   29	57	76	finally
        //   68	73	76	finally
      }
      
      /* Error */
      public void animateCamera(com.google.android.gms.dynamic.d paramd)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +44 -> 59
        //   18: aload_1
        //   19: invokeinterface 135 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 138	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   36: iconst_5
        //   37: aload_2
        //   38: aload_3
        //   39: iconst_0
        //   40: invokeinterface 47 5 0
        //   45: pop
        //   46: aload_3
        //   47: invokevirtual 50	android/os/Parcel:readException	()V
        //   50: aload_3
        //   51: invokevirtual 63	android/os/Parcel:recycle	()V
        //   54: aload_2
        //   55: invokevirtual 63	android/os/Parcel:recycle	()V
        //   58: return
        //   59: aconst_null
        //   60: astore 5
        //   62: goto -36 -> 26
        //   65: astore 4
        //   67: aload_3
        //   68: invokevirtual 63	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 63	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramd	com.google.android.gms.dynamic.d
        //   3	69	2	localParcel1	Parcel
        //   7	61	3	localParcel2	Parcel
        //   65	11	4	localObject	Object
        //   24	37	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	65	finally
        //   18	26	65	finally
        //   26	50	65	finally
      }
      
      /* Error */
      public void animateCamera2(com.google.android.gms.maps.model.internal.c paramc)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 143	com/google/android/gms/maps/model/internal/c:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   33: bipush 65
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 47 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 50	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 63	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 63	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aload_2
        //   58: iconst_0
        //   59: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   62: goto -33 -> 29
        //   65: astore 4
        //   67: aload_3
        //   68: invokevirtual 63	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 63	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramc	com.google.android.gms.maps.model.internal.c
        //   3	69	2	localParcel1	Parcel
        //   7	61	3	localParcel2	Parcel
        //   65	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	14	65	finally
        //   18	29	65	finally
        //   29	48	65	finally
        //   57	62	65	finally
      }
      
      /* Error */
      public void animateCameraWithCallback(com.google.android.gms.dynamic.d paramd, b paramb)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 27
        //   12: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +69 -> 85
        //   19: aload_1
        //   20: invokeinterface 135 1 0
        //   25: astore 6
        //   27: aload_3
        //   28: aload 6
        //   30: invokevirtual 138	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aconst_null
        //   34: astore 7
        //   36: aload_2
        //   37: ifnull +11 -> 48
        //   40: aload_2
        //   41: invokeinterface 148 1 0
        //   46: astore 7
        //   48: aload_3
        //   49: aload 7
        //   51: invokevirtual 138	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   54: aload_0
        //   55: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   58: bipush 6
        //   60: aload_3
        //   61: aload 4
        //   63: iconst_0
        //   64: invokeinterface 47 5 0
        //   69: pop
        //   70: aload 4
        //   72: invokevirtual 50	android/os/Parcel:readException	()V
        //   75: aload 4
        //   77: invokevirtual 63	android/os/Parcel:recycle	()V
        //   80: aload_3
        //   81: invokevirtual 63	android/os/Parcel:recycle	()V
        //   84: return
        //   85: aconst_null
        //   86: astore 6
        //   88: goto -61 -> 27
        //   91: astore 5
        //   93: aload 4
        //   95: invokevirtual 63	android/os/Parcel:recycle	()V
        //   98: aload_3
        //   99: invokevirtual 63	android/os/Parcel:recycle	()V
        //   102: aload 5
        //   104: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	105	0	this	a
        //   0	105	1	paramd	com.google.android.gms.dynamic.d
        //   0	105	2	paramb	b
        //   3	96	3	localParcel1	Parcel
        //   7	87	4	localParcel2	Parcel
        //   91	12	5	localObject	Object
        //   25	62	6	localIBinder1	IBinder
        //   34	16	7	localIBinder2	IBinder
        // Exception table:
        //   from	to	target	type
        //   9	15	91	finally
        //   19	27	91	finally
        //   27	33	91	finally
        //   40	48	91	finally
        //   48	75	91	finally
      }
      
      public void animateCameraWithCallback2(com.google.android.gms.maps.model.internal.c paramc, b paramb)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if (paramc != null)
            {
              localParcel1.writeInt(1);
              paramc.writeToParcel(localParcel1, 0);
              if (paramb != null)
              {
                localIBinder = paramb.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(66, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      /* Error */
      public void animateCameraWithDurationAndCallback(com.google.android.gms.dynamic.d paramd, int paramInt, b paramb)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore 4
        //   5: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   8: astore 5
        //   10: aload 4
        //   12: ldc 27
        //   14: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: aload_1
        //   18: ifnull +79 -> 97
        //   21: aload_1
        //   22: invokeinterface 135 1 0
        //   27: astore 7
        //   29: aload 4
        //   31: aload 7
        //   33: invokevirtual 138	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   36: aload 4
        //   38: iload_2
        //   39: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   42: aconst_null
        //   43: astore 8
        //   45: aload_3
        //   46: ifnull +11 -> 57
        //   49: aload_3
        //   50: invokeinterface 148 1 0
        //   55: astore 8
        //   57: aload 4
        //   59: aload 8
        //   61: invokevirtual 138	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   64: aload_0
        //   65: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   68: bipush 7
        //   70: aload 4
        //   72: aload 5
        //   74: iconst_0
        //   75: invokeinterface 47 5 0
        //   80: pop
        //   81: aload 5
        //   83: invokevirtual 50	android/os/Parcel:readException	()V
        //   86: aload 5
        //   88: invokevirtual 63	android/os/Parcel:recycle	()V
        //   91: aload 4
        //   93: invokevirtual 63	android/os/Parcel:recycle	()V
        //   96: return
        //   97: aconst_null
        //   98: astore 7
        //   100: goto -71 -> 29
        //   103: astore 6
        //   105: aload 5
        //   107: invokevirtual 63	android/os/Parcel:recycle	()V
        //   110: aload 4
        //   112: invokevirtual 63	android/os/Parcel:recycle	()V
        //   115: aload 6
        //   117: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	118	0	this	a
        //   0	118	1	paramd	com.google.android.gms.dynamic.d
        //   0	118	2	paramInt	int
        //   0	118	3	paramb	b
        //   3	108	4	localParcel1	Parcel
        //   8	98	5	localParcel2	Parcel
        //   103	13	6	localObject	Object
        //   27	72	7	localIBinder1	IBinder
        //   43	17	8	localIBinder2	IBinder
        // Exception table:
        //   from	to	target	type
        //   10	17	103	finally
        //   21	29	103	finally
        //   29	42	103	finally
        //   49	57	103	finally
        //   57	86	103	finally
      }
      
      public void animateCameraWithDurationAndCallback2(com.google.android.gms.maps.model.internal.c paramc, int paramInt, b paramb)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
            if (paramc != null)
            {
              localParcel1.writeInt(1);
              paramc.writeToParcel(localParcel1, 0);
              localParcel1.writeInt(paramInt);
              if (paramb != null)
              {
                localIBinder = paramb.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(67, localParcel1, localParcel2, 0);
                localParcel2.readException();
              }
            }
            else
            {
              localParcel1.writeInt(0);
              continue;
            }
            IBinder localIBinder = null;
          }
          finally
          {
            localParcel2.recycle();
            localParcel1.recycle();
          }
        }
      }
      
      public IBinder asBinder()
      {
        return this.le;
      }
      
      public void clear()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.le.transact(14, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public CameraPosition getCameraPosition()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_1
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_1
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   18: iconst_1
        //   19: aload_1
        //   20: aload_2
        //   21: iconst_0
        //   22: invokeinterface 47 5 0
        //   27: pop
        //   28: aload_2
        //   29: invokevirtual 50	android/os/Parcel:readException	()V
        //   32: aload_2
        //   33: invokevirtual 161	android/os/Parcel:readInt	()I
        //   36: ifeq +27 -> 63
        //   39: getstatic 167	com/google/android/gms/maps/model/CameraPosition:CREATOR	Lcom/google/android/gms/maps/model/a;
        //   42: aload_2
        //   43: invokevirtual 173	com/google/android/gms/maps/model/a:da	(Landroid/os/Parcel;)Lcom/google/android/gms/maps/model/CameraPosition;
        //   46: astore 6
        //   48: aload 6
        //   50: astore 5
        //   52: aload_2
        //   53: invokevirtual 63	android/os/Parcel:recycle	()V
        //   56: aload_1
        //   57: invokevirtual 63	android/os/Parcel:recycle	()V
        //   60: aload 5
        //   62: areturn
        //   63: aconst_null
        //   64: astore 5
        //   66: goto -14 -> 52
        //   69: astore_3
        //   70: aload_2
        //   71: invokevirtual 63	android/os/Parcel:recycle	()V
        //   74: aload_1
        //   75: invokevirtual 63	android/os/Parcel:recycle	()V
        //   78: aload_3
        //   79: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	80	0	this	a
        //   3	72	1	localParcel1	Parcel
        //   7	64	2	localParcel2	Parcel
        //   69	10	3	localObject	Object
        //   50	15	5	localCameraPosition1	CameraPosition
        //   46	3	6	localCameraPosition2	CameraPosition
        // Exception table:
        //   from	to	target	type
        //   8	48	69	finally
      }
      
      public com.google.android.gms.maps.model.internal.j getFocusedBuilding()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.le.transact(44, localParcel1, localParcel2, 0);
          localParcel2.readException();
          com.google.android.gms.maps.model.internal.j localj = com.google.android.gms.maps.model.internal.j.a.by(localParcel2.readStrongBinder());
          return localj;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void getMapAsync(m paramm)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 186 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 138	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   36: bipush 53
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 47 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 50	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 63	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 63	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 5
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 63	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 63	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramm	m
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        //   24	38	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	66	finally
        //   18	26	66	finally
        //   26	51	66	finally
      }
      
      public int getMapType()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.le.transact(15, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          return i;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public float getMaxZoomLevel()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.le.transact(2, localParcel1, localParcel2, 0);
          localParcel2.readException();
          float f = localParcel2.readFloat();
          return f;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public float getMinZoomLevel()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.le.transact(3, localParcel1, localParcel2, 0);
          localParcel2.readException();
          float f = localParcel2.readFloat();
          return f;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public Location getMyLocation()
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_1
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_2
        //   8: aload_1
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_0
        //   15: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   18: bipush 23
        //   20: aload_1
        //   21: aload_2
        //   22: iconst_0
        //   23: invokeinterface 47 5 0
        //   28: pop
        //   29: aload_2
        //   30: invokevirtual 50	android/os/Parcel:readException	()V
        //   33: aload_2
        //   34: invokevirtual 161	android/os/Parcel:readInt	()I
        //   37: ifeq +28 -> 65
        //   40: getstatic 200	android/location/Location:CREATOR	Landroid/os/Parcelable$Creator;
        //   43: aload_2
        //   44: invokeinterface 206 2 0
        //   49: checkcast 197	android/location/Location
        //   52: astore 5
        //   54: aload_2
        //   55: invokevirtual 63	android/os/Parcel:recycle	()V
        //   58: aload_1
        //   59: invokevirtual 63	android/os/Parcel:recycle	()V
        //   62: aload 5
        //   64: areturn
        //   65: aconst_null
        //   66: astore 5
        //   68: goto -14 -> 54
        //   71: astore_3
        //   72: aload_2
        //   73: invokevirtual 63	android/os/Parcel:recycle	()V
        //   76: aload_1
        //   77: invokevirtual 63	android/os/Parcel:recycle	()V
        //   80: aload_3
        //   81: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	82	0	this	a
        //   3	74	1	localParcel1	Parcel
        //   7	66	2	localParcel2	Parcel
        //   71	10	3	localObject	Object
        //   52	15	5	localLocation	Location
        // Exception table:
        //   from	to	target	type
        //   8	54	71	finally
      }
      
      public IProjectionDelegate getProjection()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.le.transact(26, localParcel1, localParcel2, 0);
          localParcel2.readException();
          IProjectionDelegate localIProjectionDelegate = IProjectionDelegate.a.bp(localParcel2.readStrongBinder());
          return localIProjectionDelegate;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public IUiSettingsDelegate getUiSettings()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.le.transact(25, localParcel1, localParcel2, 0);
          localParcel2.readException();
          IUiSettingsDelegate localIUiSettingsDelegate = IUiSettingsDelegate.a.bu(localParcel2.readStrongBinder());
          return localIUiSettingsDelegate;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isBuildingsEnabled()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.le.transact(40, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isIndoorEnabled()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.le.transact(19, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isMyLocationEnabled()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.le.transact(21, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean isTrafficEnabled()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.le.transact(17, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void moveCamera(com.google.android.gms.dynamic.d paramd)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +44 -> 59
        //   18: aload_1
        //   19: invokeinterface 135 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 138	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   36: iconst_4
        //   37: aload_2
        //   38: aload_3
        //   39: iconst_0
        //   40: invokeinterface 47 5 0
        //   45: pop
        //   46: aload_3
        //   47: invokevirtual 50	android/os/Parcel:readException	()V
        //   50: aload_3
        //   51: invokevirtual 63	android/os/Parcel:recycle	()V
        //   54: aload_2
        //   55: invokevirtual 63	android/os/Parcel:recycle	()V
        //   58: return
        //   59: aconst_null
        //   60: astore 5
        //   62: goto -36 -> 26
        //   65: astore 4
        //   67: aload_3
        //   68: invokevirtual 63	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 63	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramd	com.google.android.gms.dynamic.d
        //   3	69	2	localParcel1	Parcel
        //   7	61	3	localParcel2	Parcel
        //   65	11	4	localObject	Object
        //   24	37	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	65	finally
        //   18	26	65	finally
        //   26	50	65	finally
      }
      
      /* Error */
      public void moveCamera2(com.google.android.gms.maps.model.internal.c paramc)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 143	com/google/android/gms/maps/model/internal/c:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   33: bipush 64
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 47 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 50	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 63	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 63	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aload_2
        //   58: iconst_0
        //   59: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   62: goto -33 -> 29
        //   65: astore 4
        //   67: aload_3
        //   68: invokevirtual 63	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 63	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramc	com.google.android.gms.maps.model.internal.c
        //   3	69	2	localParcel1	Parcel
        //   7	61	3	localParcel2	Parcel
        //   65	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	14	65	finally
        //   18	29	65	finally
        //   29	48	65	finally
        //   57	62	65	finally
      }
      
      /* Error */
      public void onCreate(Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +42 -> 57
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 234	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   33: bipush 54
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 47 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 50	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 63	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 63	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aload_2
        //   58: iconst_0
        //   59: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   62: goto -33 -> 29
        //   65: astore 4
        //   67: aload_3
        //   68: invokevirtual 63	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 63	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramBundle	Bundle
        //   3	69	2	localParcel1	Parcel
        //   7	61	3	localParcel2	Parcel
        //   65	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	14	65	finally
        //   18	29	65	finally
        //   29	48	65	finally
        //   57	62	65	finally
      }
      
      public void onDestroy()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.le.transact(57, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onLowMemory()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.le.transact(58, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onPause()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.le.transact(56, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void onResume()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.le.transact(55, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void onSaveInstanceState(Bundle paramBundle)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +54 -> 69
        //   18: aload_2
        //   19: iconst_1
        //   20: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   23: aload_1
        //   24: aload_2
        //   25: iconst_0
        //   26: invokevirtual 234	android/os/Bundle:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   33: bipush 60
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 47 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 50	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 161	android/os/Parcel:readInt	()I
        //   52: ifeq +8 -> 60
        //   55: aload_1
        //   56: aload_3
        //   57: invokevirtual 243	android/os/Bundle:readFromParcel	(Landroid/os/Parcel;)V
        //   60: aload_3
        //   61: invokevirtual 63	android/os/Parcel:recycle	()V
        //   64: aload_2
        //   65: invokevirtual 63	android/os/Parcel:recycle	()V
        //   68: return
        //   69: aload_2
        //   70: iconst_0
        //   71: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   74: goto -45 -> 29
        //   77: astore 4
        //   79: aload_3
        //   80: invokevirtual 63	android/os/Parcel:recycle	()V
        //   83: aload_2
        //   84: invokevirtual 63	android/os/Parcel:recycle	()V
        //   87: aload 4
        //   89: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	90	0	this	a
        //   0	90	1	paramBundle	Bundle
        //   3	81	2	localParcel1	Parcel
        //   7	73	3	localParcel2	Parcel
        //   77	11	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   8	14	77	finally
        //   18	29	77	finally
        //   29	60	77	finally
        //   69	74	77	finally
      }
      
      public void setBuildingsEnabled(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          int i = 0;
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.le.transact(41, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setContentDescription(String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          localParcel1.writeString(paramString);
          this.le.transact(61, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public boolean setIndoorEnabled(boolean paramBoolean)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore_2
        //   2: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   5: astore_3
        //   6: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   9: astore 4
        //   11: aload_3
        //   12: ldc 27
        //   14: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   17: iload_1
        //   18: ifeq +56 -> 74
        //   21: iload_2
        //   22: istore 6
        //   24: aload_3
        //   25: iload 6
        //   27: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   30: aload_0
        //   31: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   34: bipush 20
        //   36: aload_3
        //   37: aload 4
        //   39: iconst_0
        //   40: invokeinterface 47 5 0
        //   45: pop
        //   46: aload 4
        //   48: invokevirtual 50	android/os/Parcel:readException	()V
        //   51: aload 4
        //   53: invokevirtual 161	android/os/Parcel:readInt	()I
        //   56: istore 8
        //   58: iload 8
        //   60: ifeq +20 -> 80
        //   63: aload 4
        //   65: invokevirtual 63	android/os/Parcel:recycle	()V
        //   68: aload_3
        //   69: invokevirtual 63	android/os/Parcel:recycle	()V
        //   72: iload_2
        //   73: ireturn
        //   74: iconst_0
        //   75: istore 6
        //   77: goto -53 -> 24
        //   80: iconst_0
        //   81: istore_2
        //   82: goto -19 -> 63
        //   85: astore 5
        //   87: aload 4
        //   89: invokevirtual 63	android/os/Parcel:recycle	()V
        //   92: aload_3
        //   93: invokevirtual 63	android/os/Parcel:recycle	()V
        //   96: aload 5
        //   98: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	99	0	this	a
        //   0	99	1	paramBoolean	boolean
        //   1	81	2	i	int
        //   5	88	3	localParcel1	Parcel
        //   9	79	4	localParcel2	Parcel
        //   85	12	5	localObject	Object
        //   22	4	6	j	int
        //   75	1	6	k	int
        //   56	3	8	m	int
        // Exception table:
        //   from	to	target	type
        //   11	17	85	finally
        //   24	58	85	finally
      }
      
      /* Error */
      public void setInfoWindowAdapter(d paramd)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 256 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 138	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   36: bipush 33
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 47 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 50	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 63	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 63	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 5
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 63	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 63	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramd	d
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        //   24	38	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	66	finally
        //   18	26	66	finally
        //   26	51	66	finally
      }
      
      /* Error */
      public void setInfoWindowRenderer(e parame)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 261 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 138	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   36: bipush 69
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 47 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 50	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 63	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 63	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 5
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 63	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 63	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	parame	e
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        //   24	38	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	66	finally
        //   18	26	66	finally
        //   26	51	66	finally
      }
      
      /* Error */
      public void setLocationSource(ILocationSourceDelegate paramILocationSourceDelegate)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 266 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 138	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   36: bipush 24
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 47 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 50	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 63	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 63	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 5
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 63	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 63	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramILocationSourceDelegate	ILocationSourceDelegate
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        //   24	38	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	66	finally
        //   18	26	66	finally
        //   26	51	66	finally
      }
      
      public void setMapType(int paramInt)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          localParcel1.writeInt(paramInt);
          this.le.transact(16, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setMyLocationEnabled(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          int i = 0;
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.le.transact(22, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void setOnCameraChangeListener(f paramf)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 273 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 138	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   36: bipush 27
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 47 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 50	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 63	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 63	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 5
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 63	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 63	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramf	f
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        //   24	38	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	66	finally
        //   18	26	66	finally
        //   26	51	66	finally
      }
      
      /* Error */
      public void setOnIndoorStateChangeListener(g paramg)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 278 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 138	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   36: bipush 45
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 47 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 50	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 63	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 63	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 5
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 63	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 63	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramg	g
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        //   24	38	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	66	finally
        //   18	26	66	finally
        //   26	51	66	finally
      }
      
      /* Error */
      public void setOnInfoWindowClickListener(h paramh)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 283 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 138	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   36: bipush 32
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 47 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 50	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 63	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 63	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 5
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 63	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 63	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramh	h
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        //   24	38	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	66	finally
        //   18	26	66	finally
        //   26	51	66	finally
      }
      
      /* Error */
      public void setOnMapClickListener(j paramj)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 288 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 138	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   36: bipush 28
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 47 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 50	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 63	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 63	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 5
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 63	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 63	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramj	j
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        //   24	38	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	66	finally
        //   18	26	66	finally
        //   26	51	66	finally
      }
      
      /* Error */
      public void setOnMapLoadedCallback(k paramk)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 293 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 138	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   36: bipush 42
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 47 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 50	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 63	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 63	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 5
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 63	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 63	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramk	k
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        //   24	38	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	66	finally
        //   18	26	66	finally
        //   26	51	66	finally
      }
      
      /* Error */
      public void setOnMapLongClickListener(l paraml)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 298 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 138	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   36: bipush 29
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 47 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 50	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 63	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 63	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 5
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 63	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 63	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paraml	l
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        //   24	38	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	66	finally
        //   18	26	66	finally
        //   26	51	66	finally
      }
      
      /* Error */
      public void setOnMarkerClickListener(n paramn)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 303 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 138	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   36: bipush 30
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 47 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 50	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 63	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 63	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 5
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 63	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 63	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramn	n
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        //   24	38	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	66	finally
        //   18	26	66	finally
        //   26	51	66	finally
      }
      
      /* Error */
      public void setOnMarkerDragListener(o paramo)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 308 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 138	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   36: bipush 31
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 47 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 50	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 63	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 63	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 5
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 63	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 63	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramo	o
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        //   24	38	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	66	finally
        //   18	26	66	finally
        //   26	51	66	finally
      }
      
      /* Error */
      public void setOnMyLocationButtonClickListener(p paramp)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 313 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 138	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   36: bipush 37
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 47 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 50	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 63	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 63	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 5
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 63	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 63	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramp	p
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        //   24	38	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	66	finally
        //   18	26	66	finally
        //   26	51	66	finally
      }
      
      /* Error */
      public void setOnMyLocationChangeListener(q paramq)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_2
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore_3
        //   8: aload_2
        //   9: ldc 27
        //   11: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   14: aload_1
        //   15: ifnull +45 -> 60
        //   18: aload_1
        //   19: invokeinterface 318 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 138	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   36: bipush 36
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 47 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 50	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 63	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 63	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 5
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 63	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 63	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramq	q
        //   3	70	2	localParcel1	Parcel
        //   7	62	3	localParcel2	Parcel
        //   66	11	4	localObject	Object
        //   24	38	5	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   8	14	66	finally
        //   18	26	66	finally
        //   26	51	66	finally
      }
      
      public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          localParcel1.writeInt(paramInt1);
          localParcel1.writeInt(paramInt2);
          localParcel1.writeInt(paramInt3);
          localParcel1.writeInt(paramInt4);
          this.le.transact(39, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public void setTrafficEnabled(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          int i = 0;
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.le.transact(18, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      /* Error */
      public void snapshot(v paramv, com.google.android.gms.dynamic.d paramd)
        throws RemoteException
      {
        // Byte code:
        //   0: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   3: astore_3
        //   4: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   7: astore 4
        //   9: aload_3
        //   10: ldc 27
        //   12: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   15: aload_1
        //   16: ifnull +69 -> 85
        //   19: aload_1
        //   20: invokeinterface 326 1 0
        //   25: astore 6
        //   27: aload_3
        //   28: aload 6
        //   30: invokevirtual 138	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aconst_null
        //   34: astore 7
        //   36: aload_2
        //   37: ifnull +11 -> 48
        //   40: aload_2
        //   41: invokeinterface 135 1 0
        //   46: astore 7
        //   48: aload_3
        //   49: aload 7
        //   51: invokevirtual 138	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   54: aload_0
        //   55: getfield 15	com/google/android/gms/maps/internal/IGoogleMapDelegate$a$a:le	Landroid/os/IBinder;
        //   58: bipush 38
        //   60: aload_3
        //   61: aload 4
        //   63: iconst_0
        //   64: invokeinterface 47 5 0
        //   69: pop
        //   70: aload 4
        //   72: invokevirtual 50	android/os/Parcel:readException	()V
        //   75: aload 4
        //   77: invokevirtual 63	android/os/Parcel:recycle	()V
        //   80: aload_3
        //   81: invokevirtual 63	android/os/Parcel:recycle	()V
        //   84: return
        //   85: aconst_null
        //   86: astore 6
        //   88: goto -61 -> 27
        //   91: astore 5
        //   93: aload 4
        //   95: invokevirtual 63	android/os/Parcel:recycle	()V
        //   98: aload_3
        //   99: invokevirtual 63	android/os/Parcel:recycle	()V
        //   102: aload 5
        //   104: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	105	0	this	a
        //   0	105	1	paramv	v
        //   0	105	2	paramd	com.google.android.gms.dynamic.d
        //   3	96	3	localParcel1	Parcel
        //   7	87	4	localParcel2	Parcel
        //   91	12	5	localObject	Object
        //   25	62	6	localIBinder1	IBinder
        //   34	16	7	localIBinder2	IBinder
        // Exception table:
        //   from	to	target	type
        //   9	15	91	finally
        //   19	27	91	finally
        //   27	33	91	finally
        //   40	48	91	finally
        //   48	75	91	finally
      }
      
      public void stopAnimation()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.le.transact(8, localParcel1, localParcel2, 0);
          localParcel2.readException();
          return;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public boolean useViewLifecycleWhenInFragment()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.maps.internal.IGoogleMapDelegate");
          this.le.transact(59, localParcel1, localParcel2, 0);
          localParcel2.readException();
          int i = localParcel2.readInt();
          boolean bool = false;
          if (i != 0) {
            bool = true;
          }
          return bool;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.internal.IGoogleMapDelegate
 * JD-Core Version:    0.7.0.1
 */