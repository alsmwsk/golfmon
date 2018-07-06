package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.location.GeofencingRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.b;
import com.google.android.gms.location.b.a;
import com.google.android.gms.location.d;
import com.google.android.gms.location.e;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.g;
import com.google.android.gms.maps.model.i;
import java.util.ArrayList;
import java.util.List;

public abstract interface ni
  extends IInterface
{
  public abstract void S(boolean paramBoolean)
    throws RemoteException;
  
  public abstract void a(long paramLong, boolean paramBoolean, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(PendingIntent paramPendingIntent, nh paramnh, String paramString)
    throws RemoteException;
  
  public abstract void a(Location paramLocation, int paramInt)
    throws RemoteException;
  
  public abstract void a(nh paramnh, String paramString)
    throws RemoteException;
  
  public abstract void a(nl paramnl, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(nl paramnl, b paramb)
    throws RemoteException;
  
  public abstract void a(ns paramns, oh paramoh, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(nu paramnu, oh paramoh, og paramog)
    throws RemoteException;
  
  public abstract void a(nw paramnw, oh paramoh)
    throws RemoteException;
  
  public abstract void a(ny paramny, oh paramoh, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(oc paramoc, oh paramoh, og paramog)
    throws RemoteException;
  
  public abstract void a(oe paramoe, LatLngBounds paramLatLngBounds, List<String> paramList, oh paramoh, og paramog)
    throws RemoteException;
  
  public abstract void a(oh paramoh, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent, nh paramnh)
    throws RemoteException;
  
  public abstract void a(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void a(LocationRequest paramLocationRequest, b paramb)
    throws RemoteException;
  
  public abstract void a(LocationRequest paramLocationRequest, b paramb, String paramString)
    throws RemoteException;
  
  public abstract void a(b paramb)
    throws RemoteException;
  
  public abstract void a(LatLng paramLatLng, nu paramnu, oh paramoh, og paramog)
    throws RemoteException;
  
  public abstract void a(LatLngBounds paramLatLngBounds, int paramInt, nu paramnu, oh paramoh, og paramog)
    throws RemoteException;
  
  public abstract void a(LatLngBounds paramLatLngBounds, int paramInt, String paramString, nu paramnu, oh paramoh, og paramog)
    throws RemoteException;
  
  public abstract void a(String paramString, oh paramoh, og paramog)
    throws RemoteException;
  
  public abstract void a(String paramString, LatLngBounds paramLatLngBounds, nq paramnq, oh paramoh, og paramog)
    throws RemoteException;
  
  public abstract void a(List<nn> paramList, PendingIntent paramPendingIntent, nh paramnh, String paramString)
    throws RemoteException;
  
  public abstract void a(List<String> paramList, oh paramoh, og paramog)
    throws RemoteException;
  
  public abstract void a(String[] paramArrayOfString, nh paramnh, String paramString)
    throws RemoteException;
  
  public abstract void b(PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void b(Location paramLocation)
    throws RemoteException;
  
  public abstract void b(oh paramoh, PendingIntent paramPendingIntent)
    throws RemoteException;
  
  public abstract void b(String paramString, oh paramoh, og paramog)
    throws RemoteException;
  
  public abstract Location bZ(String paramString)
    throws RemoteException;
  
  public abstract e ca(String paramString)
    throws RemoteException;
  
  public abstract Location ni()
    throws RemoteException;
  
  public abstract IBinder nj()
    throws RemoteException;
  
  public abstract IBinder nk()
    throws RemoteException;
  
  public static abstract class a
    extends Binder
    implements ni
  {
    public static ni aO(IBinder paramIBinder)
    {
      if (paramIBinder == null) {
        return null;
      }
      IInterface localIInterface = paramIBinder.queryLocalInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      if ((localIInterface != null) && ((localIInterface instanceof ni))) {
        return (ni)localIInterface;
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
        paramParcel2.writeString("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        return true;
      case 1: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        ArrayList localArrayList3 = paramParcel1.createTypedArrayList(nn.CREATOR);
        if (paramParcel1.readInt() != 0) {}
        for (PendingIntent localPendingIntent12 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent12 = null)
        {
          a(localArrayList3, localPendingIntent12, nh.a.aN(paramParcel1.readStrongBinder()), paramParcel1.readString());
          paramParcel2.writeNoException();
          return true;
        }
      case 57: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        GeofencingRequest localGeofencingRequest;
        if (paramParcel1.readInt() != 0)
        {
          localGeofencingRequest = (GeofencingRequest)GeofencingRequest.CREATOR.createFromParcel(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label476;
          }
        }
        for (PendingIntent localPendingIntent11 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent11 = null)
        {
          a(localGeofencingRequest, localPendingIntent11, nh.a.aN(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
          localGeofencingRequest = null;
          break;
        }
      case 2: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {}
        for (PendingIntent localPendingIntent10 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent10 = null)
        {
          a(localPendingIntent10, nh.a.aN(paramParcel1.readStrongBinder()), paramParcel1.readString());
          paramParcel2.writeNoException();
          return true;
        }
      case 3: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        a(paramParcel1.createStringArray(), nh.a.aN(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 4: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        a(nh.a.aN(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 5: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        long l = paramParcel1.readLong();
        boolean bool2;
        if (paramParcel1.readInt() != 0)
        {
          bool2 = true;
          if (paramParcel1.readInt() == 0) {
            break label661;
          }
        }
        for (PendingIntent localPendingIntent9 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent9 = null)
        {
          a(l, bool2, localPendingIntent9);
          paramParcel2.writeNoException();
          return true;
          bool2 = false;
          break;
        }
      case 6: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {}
        for (PendingIntent localPendingIntent8 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent8 = null)
        {
          a(localPendingIntent8);
          paramParcel2.writeNoException();
          return true;
        }
      case 7: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        Location localLocation4 = ni();
        paramParcel2.writeNoException();
        if (localLocation4 != null)
        {
          paramParcel2.writeInt(1);
          localLocation4.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 8: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        int i9 = paramParcel1.readInt();
        LocationRequest localLocationRequest3 = null;
        if (i9 != 0) {
          localLocationRequest3 = LocationRequest.CREATOR.cJ(paramParcel1);
        }
        a(localLocationRequest3, b.a.aL(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 20: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        int i8 = paramParcel1.readInt();
        LocationRequest localLocationRequest2 = null;
        if (i8 != 0) {
          localLocationRequest2 = LocationRequest.CREATOR.cJ(paramParcel1);
        }
        a(localLocationRequest2, b.a.aL(paramParcel1.readStrongBinder()), paramParcel1.readString());
        paramParcel2.writeNoException();
        return true;
      case 9: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        LocationRequest localLocationRequest1;
        if (paramParcel1.readInt() != 0)
        {
          localLocationRequest1 = LocationRequest.CREATOR.cJ(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label917;
          }
        }
        for (PendingIntent localPendingIntent7 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent7 = null)
        {
          a(localLocationRequest1, localPendingIntent7);
          paramParcel2.writeNoException();
          return true;
          localLocationRequest1 = null;
          break;
        }
      case 52: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        int i7 = paramParcel1.readInt();
        nl localnl2 = null;
        if (i7 != 0) {
          localnl2 = nl.CREATOR.cM(paramParcel1);
        }
        a(localnl2, b.a.aL(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 53: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        nl localnl1;
        if (paramParcel1.readInt() != 0)
        {
          localnl1 = nl.CREATOR.cM(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label1034;
          }
        }
        for (PendingIntent localPendingIntent6 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent6 = null)
        {
          a(localnl1, localPendingIntent6);
          paramParcel2.writeNoException();
          return true;
          localnl1 = null;
          break;
        }
      case 10: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        a(b.a.aL(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 11: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {}
        for (PendingIntent localPendingIntent5 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent5 = null)
        {
          b(localPendingIntent5);
          paramParcel2.writeNoException();
          return true;
        }
      case 12: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        int i6 = paramParcel1.readInt();
        boolean bool1 = false;
        if (i6 != 0) {
          bool1 = true;
        }
        S(bool1);
        paramParcel2.writeNoException();
        return true;
      case 13: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {}
        for (Location localLocation3 = (Location)Location.CREATOR.createFromParcel(paramParcel1);; localLocation3 = null)
        {
          b(localLocation3);
          paramParcel2.writeNoException();
          return true;
        }
      case 14: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        LatLngBounds localLatLngBounds4;
        int i5;
        nu localnu4;
        if (paramParcel1.readInt() != 0)
        {
          localLatLngBounds4 = LatLngBounds.CREATOR.dd(paramParcel1);
          i5 = paramParcel1.readInt();
          if (paramParcel1.readInt() == 0) {
            break label1279;
          }
          localnu4 = nu.CREATOR.cQ(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label1285;
          }
        }
        for (oh localoh15 = oh.CREATOR.cW(paramParcel1);; localoh15 = null)
        {
          a(localLatLngBounds4, i5, localnu4, localoh15, og.a.aP(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
          localLatLngBounds4 = null;
          break;
          localnu4 = null;
          break label1232;
        }
      case 47: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        LatLngBounds localLatLngBounds3;
        int i3;
        String str4;
        if (paramParcel1.readInt() != 0)
        {
          localLatLngBounds3 = LatLngBounds.CREATOR.dd(paramParcel1);
          i3 = paramParcel1.readInt();
          str4 = paramParcel1.readString();
          if (paramParcel1.readInt() == 0) {
            break label1397;
          }
        }
        for (nu localnu3 = nu.CREATOR.cQ(paramParcel1);; localnu3 = null)
        {
          int i4 = paramParcel1.readInt();
          oh localoh14 = null;
          if (i4 != 0) {
            localoh14 = oh.CREATOR.cW(paramParcel1);
          }
          a(localLatLngBounds3, i3, str4, localnu3, localoh14, og.a.aP(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
          localLatLngBounds3 = null;
          break;
        }
      case 15: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        String str3 = paramParcel1.readString();
        int i2 = paramParcel1.readInt();
        oh localoh13 = null;
        if (i2 != 0) {
          localoh13 = oh.CREATOR.cW(paramParcel1);
        }
        a(str3, localoh13, og.a.aP(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 16: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        LatLng localLatLng;
        if (paramParcel1.readInt() != 0)
        {
          localLatLng = LatLng.CREATOR.de(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label1549;
          }
        }
        for (nu localnu2 = nu.CREATOR.cQ(paramParcel1);; localnu2 = null)
        {
          int i1 = paramParcel1.readInt();
          oh localoh12 = null;
          if (i1 != 0) {
            localoh12 = oh.CREATOR.cW(paramParcel1);
          }
          a(localLatLng, localnu2, localoh12, og.a.aP(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
          localLatLng = null;
          break;
        }
      case 17: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {}
        for (nu localnu1 = nu.CREATOR.cQ(paramParcel1);; localnu1 = null)
        {
          int n = paramParcel1.readInt();
          oh localoh11 = null;
          if (n != 0) {
            localoh11 = oh.CREATOR.cW(paramParcel1);
          }
          a(localnu1, localoh11, og.a.aP(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
        }
      case 42: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        String str2 = paramParcel1.readString();
        int m = paramParcel1.readInt();
        oh localoh10 = null;
        if (m != 0) {
          localoh10 = oh.CREATOR.cW(paramParcel1);
        }
        b(str2, localoh10, og.a.aP(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 58: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        ArrayList localArrayList2 = paramParcel1.createStringArrayList();
        int k = paramParcel1.readInt();
        oh localoh9 = null;
        if (k != 0) {
          localoh9 = oh.CREATOR.cW(paramParcel1);
        }
        a(localArrayList2, localoh9, og.a.aP(paramParcel1.readStrongBinder()));
        paramParcel2.writeNoException();
        return true;
      case 50: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        oe localoe;
        LatLngBounds localLatLngBounds2;
        ArrayList localArrayList1;
        if (paramParcel1.readInt() != 0)
        {
          localoe = oe.CREATOR.cV(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label1830;
          }
          localLatLngBounds2 = LatLngBounds.CREATOR.dd(paramParcel1);
          localArrayList1 = paramParcel1.createStringArrayList();
          if (paramParcel1.readInt() == 0) {
            break label1836;
          }
        }
        for (oh localoh8 = oh.CREATOR.cW(paramParcel1);; localoh8 = null)
        {
          a(localoe, localLatLngBounds2, localArrayList1, localoh8, og.a.aP(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
          localoe = null;
          break;
          localLatLngBounds2 = null;
          break label1777;
        }
      case 18: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        ny localny;
        oh localoh7;
        if (paramParcel1.readInt() != 0)
        {
          localny = ny.CREATOR.cS(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label1923;
          }
          localoh7 = oh.CREATOR.cW(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label1929;
          }
        }
        for (PendingIntent localPendingIntent4 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent4 = null)
        {
          a(localny, localoh7, localPendingIntent4);
          paramParcel2.writeNoException();
          return true;
          localny = null;
          break;
          localoh7 = null;
          break label1880;
        }
      case 19: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        oh localoh6;
        if (paramParcel1.readInt() != 0)
        {
          localoh6 = oh.CREATOR.cW(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label1998;
          }
        }
        for (PendingIntent localPendingIntent3 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent3 = null)
        {
          a(localoh6, localPendingIntent3);
          paramParcel2.writeNoException();
          return true;
          localoh6 = null;
          break;
        }
      case 48: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        ns localns;
        oh localoh5;
        if (paramParcel1.readInt() != 0)
        {
          localns = ns.CREATOR.cP(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label2085;
          }
          localoh5 = oh.CREATOR.cW(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label2091;
          }
        }
        for (PendingIntent localPendingIntent2 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent2 = null)
        {
          a(localns, localoh5, localPendingIntent2);
          paramParcel2.writeNoException();
          return true;
          localns = null;
          break;
          localoh5 = null;
          break label2042;
        }
      case 49: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        oh localoh4;
        if (paramParcel1.readInt() != 0)
        {
          localoh4 = oh.CREATOR.cW(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label2160;
          }
        }
        for (PendingIntent localPendingIntent1 = (PendingIntent)PendingIntent.CREATOR.createFromParcel(paramParcel1);; localPendingIntent1 = null)
        {
          b(localoh4, localPendingIntent1);
          paramParcel2.writeNoException();
          return true;
          localoh4 = null;
          break;
        }
      case 55: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        String str1 = paramParcel1.readString();
        LatLngBounds localLatLngBounds1;
        nq localnq;
        if (paramParcel1.readInt() != 0)
        {
          localLatLngBounds1 = LatLngBounds.CREATOR.dd(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label2257;
          }
          localnq = nq.CREATOR.cO(paramParcel1);
          if (paramParcel1.readInt() == 0) {
            break label2263;
          }
        }
        for (oh localoh3 = oh.CREATOR.cW(paramParcel1);; localoh3 = null)
        {
          a(str1, localLatLngBounds1, localnq, localoh3, og.a.aP(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
          localLatLngBounds1 = null;
          break;
          localnq = null;
          break label2210;
        }
      case 46: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {}
        for (oc localoc = (oc)oc.CREATOR.createFromParcel(paramParcel1);; localoc = null)
        {
          int j = paramParcel1.readInt();
          oh localoh2 = null;
          if (j != 0) {
            localoh2 = oh.CREATOR.cW(paramParcel1);
          }
          a(localoc, localoh2, og.a.aP(paramParcel1.readStrongBinder()));
          paramParcel2.writeNoException();
          return true;
        }
      case 21: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        Location localLocation2 = bZ(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (localLocation2 != null)
        {
          paramParcel2.writeInt(1);
          localLocation2.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 25: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {}
        for (nw localnw = nw.CREATOR.cR(paramParcel1);; localnw = null)
        {
          int i = paramParcel1.readInt();
          oh localoh1 = null;
          if (i != 0) {
            localoh1 = oh.CREATOR.cW(paramParcel1);
          }
          a(localnw, localoh1);
          return true;
        }
      case 26: 
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        if (paramParcel1.readInt() != 0) {}
        for (Location localLocation1 = (Location)Location.CREATOR.createFromParcel(paramParcel1);; localLocation1 = null)
        {
          a(localLocation1, paramParcel1.readInt());
          paramParcel2.writeNoException();
          return true;
        }
      case 34: 
        label1923:
        label2085:
        label2091:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        label2210:
        e locale = ca(paramParcel1.readString());
        paramParcel2.writeNoException();
        if (locale != null)
        {
          paramParcel2.writeInt(1);
          locale.writeToParcel(paramParcel2, 1);
          return true;
        }
        paramParcel2.writeInt(0);
        return true;
      case 51: 
        label476:
        label1279:
        paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
        label661:
        label1232:
        label1397:
        label2042:
        IBinder localIBinder2 = nj();
        label917:
        label1777:
        paramParcel2.writeNoException();
        label1034:
        label1549:
        label1830:
        label1836:
        label1880:
        label2160:
        paramParcel2.writeStrongBinder(localIBinder2);
        label1285:
        label1929:
        label1998:
        label2257:
        label2263:
        return true;
      }
      paramParcel1.enforceInterface("com.google.android.gms.location.internal.IGoogleLocationManagerService");
      IBinder localIBinder1 = nk();
      paramParcel2.writeNoException();
      paramParcel2.writeStrongBinder(localIBinder1);
      return true;
    }
    
    private static class a
      implements ni
    {
      private IBinder le;
      
      a(IBinder paramIBinder)
      {
        this.le = paramIBinder;
      }
      
      public void S(boolean paramBoolean)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          int i = 0;
          if (paramBoolean) {
            i = 1;
          }
          localParcel1.writeInt(i);
          this.le.transact(12, localParcel1, localParcel2, 0);
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
      public void a(long paramLong, boolean paramBoolean, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        // Byte code:
        //   0: iconst_1
        //   1: istore 5
        //   3: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   6: astore 6
        //   8: invokestatic 25	android/os/Parcel:obtain	()Landroid/os/Parcel;
        //   11: astore 7
        //   13: aload 6
        //   15: ldc 27
        //   17: invokevirtual 31	android/os/Parcel:writeInterfaceToken	(Ljava/lang/String;)V
        //   20: aload 6
        //   22: lload_1
        //   23: invokevirtual 53	android/os/Parcel:writeLong	(J)V
        //   26: iload_3
        //   27: ifeq +61 -> 88
        //   30: aload 6
        //   32: iload 5
        //   34: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   37: aload 4
        //   39: ifnull +55 -> 94
        //   42: aload 6
        //   44: iconst_1
        //   45: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   48: aload 4
        //   50: aload 6
        //   52: iconst_0
        //   53: invokevirtual 59	android/app/PendingIntent:writeToParcel	(Landroid/os/Parcel;I)V
        //   56: aload_0
        //   57: getfield 15	com/google/android/gms/internal/ni$a$a:le	Landroid/os/IBinder;
        //   60: iconst_5
        //   61: aload 6
        //   63: aload 7
        //   65: iconst_0
        //   66: invokeinterface 41 5 0
        //   71: pop
        //   72: aload 7
        //   74: invokevirtual 44	android/os/Parcel:readException	()V
        //   77: aload 7
        //   79: invokevirtual 47	android/os/Parcel:recycle	()V
        //   82: aload 6
        //   84: invokevirtual 47	android/os/Parcel:recycle	()V
        //   87: return
        //   88: iconst_0
        //   89: istore 5
        //   91: goto -61 -> 30
        //   94: aload 6
        //   96: iconst_0
        //   97: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   100: goto -44 -> 56
        //   103: astore 8
        //   105: aload 7
        //   107: invokevirtual 47	android/os/Parcel:recycle	()V
        //   110: aload 6
        //   112: invokevirtual 47	android/os/Parcel:recycle	()V
        //   115: aload 8
        //   117: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	118	0	this	a
        //   0	118	1	paramLong	long
        //   0	118	3	paramBoolean	boolean
        //   0	118	4	paramPendingIntent	PendingIntent
        //   1	89	5	i	int
        //   6	105	6	localParcel1	Parcel
        //   11	95	7	localParcel2	Parcel
        //   103	13	8	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   13	26	103	finally
        //   30	37	103	finally
        //   42	56	103	finally
        //   56	77	103	finally
        //   94	100	103	finally
      }
      
      /* Error */
      public void a(PendingIntent paramPendingIntent)
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
        //   26: invokevirtual 59	android/app/PendingIntent:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 15	com/google/android/gms/internal/ni$a$a:le	Landroid/os/IBinder;
        //   33: bipush 6
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 41 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 44	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 47	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 47	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aload_2
        //   58: iconst_0
        //   59: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   62: goto -33 -> 29
        //   65: astore 4
        //   67: aload_3
        //   68: invokevirtual 47	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 47	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramPendingIntent	PendingIntent
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
      
      public void a(PendingIntent paramPendingIntent, nh paramnh, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramPendingIntent != null)
            {
              localParcel1.writeInt(1);
              paramPendingIntent.writeToParcel(localParcel1, 0);
              if (paramnh != null)
              {
                localIBinder = paramnh.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                localParcel1.writeString(paramString);
                this.le.transact(2, localParcel1, localParcel2, 0);
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
      public void a(Location paramLocation, int paramInt)
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
        //   16: ifnull +50 -> 66
        //   19: aload_3
        //   20: iconst_1
        //   21: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   24: aload_1
        //   25: aload_3
        //   26: iconst_0
        //   27: invokevirtual 77	android/location/Location:writeToParcel	(Landroid/os/Parcel;I)V
        //   30: aload_3
        //   31: iload_2
        //   32: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   35: aload_0
        //   36: getfield 15	com/google/android/gms/internal/ni$a$a:le	Landroid/os/IBinder;
        //   39: bipush 26
        //   41: aload_3
        //   42: aload 4
        //   44: iconst_0
        //   45: invokeinterface 41 5 0
        //   50: pop
        //   51: aload 4
        //   53: invokevirtual 44	android/os/Parcel:readException	()V
        //   56: aload 4
        //   58: invokevirtual 47	android/os/Parcel:recycle	()V
        //   61: aload_3
        //   62: invokevirtual 47	android/os/Parcel:recycle	()V
        //   65: return
        //   66: aload_3
        //   67: iconst_0
        //   68: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   71: goto -41 -> 30
        //   74: astore 5
        //   76: aload 4
        //   78: invokevirtual 47	android/os/Parcel:recycle	()V
        //   81: aload_3
        //   82: invokevirtual 47	android/os/Parcel:recycle	()V
        //   85: aload 5
        //   87: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	88	0	this	a
        //   0	88	1	paramLocation	Location
        //   0	88	2	paramInt	int
        //   3	79	3	localParcel1	Parcel
        //   7	70	4	localParcel2	Parcel
        //   74	12	5	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   9	15	74	finally
        //   19	30	74	finally
        //   30	56	74	finally
        //   66	71	74	finally
      }
      
      /* Error */
      public void a(nh paramnh, String paramString)
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
        //   16: ifnull +52 -> 68
        //   19: aload_1
        //   20: invokeinterface 67 1 0
        //   25: astore 6
        //   27: aload_3
        //   28: aload 6
        //   30: invokevirtual 70	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   33: aload_3
        //   34: aload_2
        //   35: invokevirtual 73	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   38: aload_0
        //   39: getfield 15	com/google/android/gms/internal/ni$a$a:le	Landroid/os/IBinder;
        //   42: iconst_4
        //   43: aload_3
        //   44: aload 4
        //   46: iconst_0
        //   47: invokeinterface 41 5 0
        //   52: pop
        //   53: aload 4
        //   55: invokevirtual 44	android/os/Parcel:readException	()V
        //   58: aload 4
        //   60: invokevirtual 47	android/os/Parcel:recycle	()V
        //   63: aload_3
        //   64: invokevirtual 47	android/os/Parcel:recycle	()V
        //   67: return
        //   68: aconst_null
        //   69: astore 6
        //   71: goto -44 -> 27
        //   74: astore 5
        //   76: aload 4
        //   78: invokevirtual 47	android/os/Parcel:recycle	()V
        //   81: aload_3
        //   82: invokevirtual 47	android/os/Parcel:recycle	()V
        //   85: aload 5
        //   87: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	88	0	this	a
        //   0	88	1	paramnh	nh
        //   0	88	2	paramString	String
        //   3	79	3	localParcel1	Parcel
        //   7	70	4	localParcel2	Parcel
        //   74	12	5	localObject	Object
        //   25	45	6	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   9	15	74	finally
        //   19	27	74	finally
        //   27	58	74	finally
      }
      
      public void a(nl paramnl, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramnl != null)
            {
              localParcel1.writeInt(1);
              paramnl.writeToParcel(localParcel1, 0);
              if (paramPendingIntent != null)
              {
                localParcel1.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel1, 0);
                this.le.transact(53, localParcel1, localParcel2, 0);
                localParcel2.readException();
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
      
      public void a(nl paramnl, b paramb)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramnl != null)
            {
              localParcel1.writeInt(1);
              paramnl.writeToParcel(localParcel1, 0);
              if (paramb != null)
              {
                localIBinder = paramb.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(52, localParcel1, localParcel2, 0);
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
      
      public void a(ns paramns, oh paramoh, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramns != null)
            {
              localParcel1.writeInt(1);
              paramns.writeToParcel(localParcel1, 0);
              if (paramoh != null)
              {
                localParcel1.writeInt(1);
                paramoh.writeToParcel(localParcel1, 0);
                if (paramPendingIntent == null) {
                  break label134;
                }
                localParcel1.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel1, 0);
                this.le.transact(48, localParcel1, localParcel2, 0);
                localParcel2.readException();
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
          continue;
          label134:
          localParcel1.writeInt(0);
        }
      }
      
      public void a(nu paramnu, oh paramoh, og paramog)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramnu != null)
            {
              localParcel1.writeInt(1);
              paramnu.writeToParcel(localParcel1, 0);
              if (paramoh != null)
              {
                localParcel1.writeInt(1);
                paramoh.writeToParcel(localParcel1, 0);
                if (paramog == null) {
                  break label136;
                }
                localIBinder = paramog.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(17, localParcel1, localParcel2, 0);
                localParcel2.readException();
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
          continue;
          label136:
          IBinder localIBinder = null;
        }
      }
      
      public void a(nw paramnw, oh paramoh)
        throws RemoteException
      {
        Parcel localParcel = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramnw != null)
            {
              localParcel.writeInt(1);
              paramnw.writeToParcel(localParcel, 0);
              if (paramoh != null)
              {
                localParcel.writeInt(1);
                paramoh.writeToParcel(localParcel, 0);
                this.le.transact(25, localParcel, null, 1);
              }
            }
            else
            {
              localParcel.writeInt(0);
              continue;
            }
            localParcel.writeInt(0);
          }
          finally
          {
            localParcel.recycle();
          }
        }
      }
      
      public void a(ny paramny, oh paramoh, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramny != null)
            {
              localParcel1.writeInt(1);
              paramny.writeToParcel(localParcel1, 0);
              if (paramoh != null)
              {
                localParcel1.writeInt(1);
                paramoh.writeToParcel(localParcel1, 0);
                if (paramPendingIntent == null) {
                  break label134;
                }
                localParcel1.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel1, 0);
                this.le.transact(18, localParcel1, localParcel2, 0);
                localParcel2.readException();
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
          continue;
          label134:
          localParcel1.writeInt(0);
        }
      }
      
      public void a(oc paramoc, oh paramoh, og paramog)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramoc != null)
            {
              localParcel1.writeInt(1);
              paramoc.writeToParcel(localParcel1, 0);
              if (paramoh != null)
              {
                localParcel1.writeInt(1);
                paramoh.writeToParcel(localParcel1, 0);
                if (paramog == null) {
                  break label136;
                }
                localIBinder = paramog.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(46, localParcel1, localParcel2, 0);
                localParcel2.readException();
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
          continue;
          label136:
          IBinder localIBinder = null;
        }
      }
      
      public void a(oe paramoe, LatLngBounds paramLatLngBounds, List<String> paramList, oh paramoh, og paramog)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramoe != null)
            {
              localParcel1.writeInt(1);
              paramoe.writeToParcel(localParcel1, 0);
              if (paramLatLngBounds != null)
              {
                localParcel1.writeInt(1);
                paramLatLngBounds.writeToParcel(localParcel1, 0);
                localParcel1.writeStringList(paramList);
                if (paramoh == null) {
                  break label163;
                }
                localParcel1.writeInt(1);
                paramoh.writeToParcel(localParcel1, 0);
                if (paramog == null) {
                  break label172;
                }
                localIBinder = paramog.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(50, localParcel1, localParcel2, 0);
                localParcel2.readException();
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
          continue;
          label163:
          localParcel1.writeInt(0);
          continue;
          label172:
          IBinder localIBinder = null;
        }
      }
      
      public void a(oh paramoh, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramoh != null)
            {
              localParcel1.writeInt(1);
              paramoh.writeToParcel(localParcel1, 0);
              if (paramPendingIntent != null)
              {
                localParcel1.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel1, 0);
                this.le.transact(19, localParcel1, localParcel2, 0);
                localParcel2.readException();
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
      
      public void a(GeofencingRequest paramGeofencingRequest, PendingIntent paramPendingIntent, nh paramnh)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramGeofencingRequest != null)
            {
              localParcel1.writeInt(1);
              paramGeofencingRequest.writeToParcel(localParcel1, 0);
              if (paramPendingIntent != null)
              {
                localParcel1.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel1, 0);
                if (paramnh == null) {
                  break label136;
                }
                localIBinder = paramnh.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(57, localParcel1, localParcel2, 0);
                localParcel2.readException();
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
          continue;
          label136:
          IBinder localIBinder = null;
        }
      }
      
      public void a(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramLocationRequest != null)
            {
              localParcel1.writeInt(1);
              paramLocationRequest.writeToParcel(localParcel1, 0);
              if (paramPendingIntent != null)
              {
                localParcel1.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel1, 0);
                this.le.transact(9, localParcel1, localParcel2, 0);
                localParcel2.readException();
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
      
      public void a(LocationRequest paramLocationRequest, b paramb)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramLocationRequest != null)
            {
              localParcel1.writeInt(1);
              paramLocationRequest.writeToParcel(localParcel1, 0);
              if (paramb != null)
              {
                localIBinder = paramb.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(8, localParcel1, localParcel2, 0);
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
      
      public void a(LocationRequest paramLocationRequest, b paramb, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramLocationRequest != null)
            {
              localParcel1.writeInt(1);
              paramLocationRequest.writeToParcel(localParcel1, 0);
              if (paramb != null)
              {
                localIBinder = paramb.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                localParcel1.writeString(paramString);
                this.le.transact(20, localParcel1, localParcel2, 0);
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
      public void a(b paramb)
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
        //   19: invokeinterface 86 1 0
        //   24: astore 5
        //   26: aload_2
        //   27: aload 5
        //   29: invokevirtual 70	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   32: aload_0
        //   33: getfield 15	com/google/android/gms/internal/ni$a$a:le	Landroid/os/IBinder;
        //   36: bipush 10
        //   38: aload_2
        //   39: aload_3
        //   40: iconst_0
        //   41: invokeinterface 41 5 0
        //   46: pop
        //   47: aload_3
        //   48: invokevirtual 44	android/os/Parcel:readException	()V
        //   51: aload_3
        //   52: invokevirtual 47	android/os/Parcel:recycle	()V
        //   55: aload_2
        //   56: invokevirtual 47	android/os/Parcel:recycle	()V
        //   59: return
        //   60: aconst_null
        //   61: astore 5
        //   63: goto -37 -> 26
        //   66: astore 4
        //   68: aload_3
        //   69: invokevirtual 47	android/os/Parcel:recycle	()V
        //   72: aload_2
        //   73: invokevirtual 47	android/os/Parcel:recycle	()V
        //   76: aload 4
        //   78: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	79	0	this	a
        //   0	79	1	paramb	b
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
      
      public void a(LatLng paramLatLng, nu paramnu, oh paramoh, og paramog)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramLatLng != null)
            {
              localParcel1.writeInt(1);
              paramLatLng.writeToParcel(localParcel1, 0);
              if (paramnu != null)
              {
                localParcel1.writeInt(1);
                paramnu.writeToParcel(localParcel1, 0);
                if (paramoh == null) {
                  break label155;
                }
                localParcel1.writeInt(1);
                paramoh.writeToParcel(localParcel1, 0);
                if (paramog == null) {
                  break label164;
                }
                localIBinder = paramog.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(16, localParcel1, localParcel2, 0);
                localParcel2.readException();
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
          continue;
          label155:
          localParcel1.writeInt(0);
          continue;
          label164:
          IBinder localIBinder = null;
        }
      }
      
      public void a(LatLngBounds paramLatLngBounds, int paramInt, nu paramnu, oh paramoh, og paramog)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramLatLngBounds != null)
            {
              localParcel1.writeInt(1);
              paramLatLngBounds.writeToParcel(localParcel1, 0);
              localParcel1.writeInt(paramInt);
              if (paramnu != null)
              {
                localParcel1.writeInt(1);
                paramnu.writeToParcel(localParcel1, 0);
                if (paramoh == null) {
                  break label163;
                }
                localParcel1.writeInt(1);
                paramoh.writeToParcel(localParcel1, 0);
                if (paramog == null) {
                  break label172;
                }
                localIBinder = paramog.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(14, localParcel1, localParcel2, 0);
                localParcel2.readException();
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
          continue;
          label163:
          localParcel1.writeInt(0);
          continue;
          label172:
          IBinder localIBinder = null;
        }
      }
      
      public void a(LatLngBounds paramLatLngBounds, int paramInt, String paramString, nu paramnu, oh paramoh, og paramog)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramLatLngBounds != null)
            {
              localParcel1.writeInt(1);
              paramLatLngBounds.writeToParcel(localParcel1, 0);
              localParcel1.writeInt(paramInt);
              localParcel1.writeString(paramString);
              if (paramnu != null)
              {
                localParcel1.writeInt(1);
                paramnu.writeToParcel(localParcel1, 0);
                if (paramoh == null) {
                  break label171;
                }
                localParcel1.writeInt(1);
                paramoh.writeToParcel(localParcel1, 0);
                if (paramog == null) {
                  break label180;
                }
                localIBinder = paramog.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(47, localParcel1, localParcel2, 0);
                localParcel2.readException();
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
          continue;
          label171:
          localParcel1.writeInt(0);
          continue;
          label180:
          IBinder localIBinder = null;
        }
      }
      
      public void a(String paramString, oh paramoh, og paramog)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            localParcel1.writeString(paramString);
            if (paramoh != null)
            {
              localParcel1.writeInt(1);
              paramoh.writeToParcel(localParcel1, 0);
              if (paramog != null)
              {
                localIBinder = paramog.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(15, localParcel1, localParcel2, 0);
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
      
      public void a(String paramString, LatLngBounds paramLatLngBounds, nq paramnq, oh paramoh, og paramog)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            localParcel1.writeString(paramString);
            if (paramLatLngBounds != null)
            {
              localParcel1.writeInt(1);
              paramLatLngBounds.writeToParcel(localParcel1, 0);
              if (paramnq != null)
              {
                localParcel1.writeInt(1);
                paramnq.writeToParcel(localParcel1, 0);
                if (paramoh == null) {
                  break label163;
                }
                localParcel1.writeInt(1);
                paramoh.writeToParcel(localParcel1, 0);
                if (paramog == null) {
                  break label172;
                }
                localIBinder = paramog.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(55, localParcel1, localParcel2, 0);
                localParcel2.readException();
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
          continue;
          label163:
          localParcel1.writeInt(0);
          continue;
          label172:
          IBinder localIBinder = null;
        }
      }
      
      public void a(List<nn> paramList, PendingIntent paramPendingIntent, nh paramnh, String paramString)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            localParcel1.writeTypedList(paramList);
            if (paramPendingIntent != null)
            {
              localParcel1.writeInt(1);
              paramPendingIntent.writeToParcel(localParcel1, 0);
              if (paramnh != null)
              {
                localIBinder = paramnh.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                localParcel1.writeString(paramString);
                this.le.transact(1, localParcel1, localParcel2, 0);
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
      
      public void a(List<String> paramList, oh paramoh, og paramog)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            localParcel1.writeStringList(paramList);
            if (paramoh != null)
            {
              localParcel1.writeInt(1);
              paramoh.writeToParcel(localParcel1, 0);
              if (paramog != null)
              {
                localIBinder = paramog.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(58, localParcel1, localParcel2, 0);
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
      public void a(String[] paramArrayOfString, nh paramnh, String paramString)
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
        //   17: aload 4
        //   19: aload_1
        //   20: invokevirtual 156	android/os/Parcel:writeStringArray	([Ljava/lang/String;)V
        //   23: aload_2
        //   24: ifnull +56 -> 80
        //   27: aload_2
        //   28: invokeinterface 67 1 0
        //   33: astore 7
        //   35: aload 4
        //   37: aload 7
        //   39: invokevirtual 70	android/os/Parcel:writeStrongBinder	(Landroid/os/IBinder;)V
        //   42: aload 4
        //   44: aload_3
        //   45: invokevirtual 73	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   48: aload_0
        //   49: getfield 15	com/google/android/gms/internal/ni$a$a:le	Landroid/os/IBinder;
        //   52: iconst_3
        //   53: aload 4
        //   55: aload 5
        //   57: iconst_0
        //   58: invokeinterface 41 5 0
        //   63: pop
        //   64: aload 5
        //   66: invokevirtual 44	android/os/Parcel:readException	()V
        //   69: aload 5
        //   71: invokevirtual 47	android/os/Parcel:recycle	()V
        //   74: aload 4
        //   76: invokevirtual 47	android/os/Parcel:recycle	()V
        //   79: return
        //   80: aconst_null
        //   81: astore 7
        //   83: goto -48 -> 35
        //   86: astore 6
        //   88: aload 5
        //   90: invokevirtual 47	android/os/Parcel:recycle	()V
        //   93: aload 4
        //   95: invokevirtual 47	android/os/Parcel:recycle	()V
        //   98: aload 6
        //   100: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	101	0	this	a
        //   0	101	1	paramArrayOfString	String[]
        //   0	101	2	paramnh	nh
        //   0	101	3	paramString	String
        //   3	91	4	localParcel1	Parcel
        //   8	81	5	localParcel2	Parcel
        //   86	13	6	localObject	Object
        //   33	49	7	localIBinder	IBinder
        // Exception table:
        //   from	to	target	type
        //   10	23	86	finally
        //   27	35	86	finally
        //   35	69	86	finally
      }
      
      public IBinder asBinder()
      {
        return this.le;
      }
      
      /* Error */
      public void b(PendingIntent paramPendingIntent)
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
        //   26: invokevirtual 59	android/app/PendingIntent:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 15	com/google/android/gms/internal/ni$a$a:le	Landroid/os/IBinder;
        //   33: bipush 11
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 41 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 44	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 47	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 47	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aload_2
        //   58: iconst_0
        //   59: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   62: goto -33 -> 29
        //   65: astore 4
        //   67: aload_3
        //   68: invokevirtual 47	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 47	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramPendingIntent	PendingIntent
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
      public void b(Location paramLocation)
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
        //   26: invokevirtual 77	android/location/Location:writeToParcel	(Landroid/os/Parcel;I)V
        //   29: aload_0
        //   30: getfield 15	com/google/android/gms/internal/ni$a$a:le	Landroid/os/IBinder;
        //   33: bipush 13
        //   35: aload_2
        //   36: aload_3
        //   37: iconst_0
        //   38: invokeinterface 41 5 0
        //   43: pop
        //   44: aload_3
        //   45: invokevirtual 44	android/os/Parcel:readException	()V
        //   48: aload_3
        //   49: invokevirtual 47	android/os/Parcel:recycle	()V
        //   52: aload_2
        //   53: invokevirtual 47	android/os/Parcel:recycle	()V
        //   56: return
        //   57: aload_2
        //   58: iconst_0
        //   59: invokevirtual 35	android/os/Parcel:writeInt	(I)V
        //   62: goto -33 -> 29
        //   65: astore 4
        //   67: aload_3
        //   68: invokevirtual 47	android/os/Parcel:recycle	()V
        //   71: aload_2
        //   72: invokevirtual 47	android/os/Parcel:recycle	()V
        //   75: aload 4
        //   77: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	78	0	this	a
        //   0	78	1	paramLocation	Location
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
      
      public void b(oh paramoh, PendingIntent paramPendingIntent)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            if (paramoh != null)
            {
              localParcel1.writeInt(1);
              paramoh.writeToParcel(localParcel1, 0);
              if (paramPendingIntent != null)
              {
                localParcel1.writeInt(1);
                paramPendingIntent.writeToParcel(localParcel1, 0);
                this.le.transact(49, localParcel1, localParcel2, 0);
                localParcel2.readException();
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
      
      public void b(String paramString, oh paramoh, og paramog)
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        for (;;)
        {
          try
          {
            localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
            localParcel1.writeString(paramString);
            if (paramoh != null)
            {
              localParcel1.writeInt(1);
              paramoh.writeToParcel(localParcel1, 0);
              if (paramog != null)
              {
                localIBinder = paramog.asBinder();
                localParcel1.writeStrongBinder(localIBinder);
                this.le.transact(42, localParcel1, localParcel2, 0);
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
      public Location bZ(String paramString)
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
        //   14: aload_2
        //   15: aload_1
        //   16: invokevirtual 73	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   19: aload_0
        //   20: getfield 15	com/google/android/gms/internal/ni$a$a:le	Landroid/os/IBinder;
        //   23: bipush 21
        //   25: aload_2
        //   26: aload_3
        //   27: iconst_0
        //   28: invokeinterface 41 5 0
        //   33: pop
        //   34: aload_3
        //   35: invokevirtual 44	android/os/Parcel:readException	()V
        //   38: aload_3
        //   39: invokevirtual 164	android/os/Parcel:readInt	()I
        //   42: ifeq +28 -> 70
        //   45: getstatic 168	android/location/Location:CREATOR	Landroid/os/Parcelable$Creator;
        //   48: aload_3
        //   49: invokeinterface 174 2 0
        //   54: checkcast 76	android/location/Location
        //   57: astore 6
        //   59: aload_3
        //   60: invokevirtual 47	android/os/Parcel:recycle	()V
        //   63: aload_2
        //   64: invokevirtual 47	android/os/Parcel:recycle	()V
        //   67: aload 6
        //   69: areturn
        //   70: aconst_null
        //   71: astore 6
        //   73: goto -14 -> 59
        //   76: astore 4
        //   78: aload_3
        //   79: invokevirtual 47	android/os/Parcel:recycle	()V
        //   82: aload_2
        //   83: invokevirtual 47	android/os/Parcel:recycle	()V
        //   86: aload 4
        //   88: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	89	0	this	a
        //   0	89	1	paramString	String
        //   3	80	2	localParcel1	Parcel
        //   7	72	3	localParcel2	Parcel
        //   76	11	4	localObject	Object
        //   57	15	6	localLocation	Location
        // Exception table:
        //   from	to	target	type
        //   8	59	76	finally
      }
      
      /* Error */
      public e ca(String paramString)
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
        //   14: aload_2
        //   15: aload_1
        //   16: invokevirtual 73	android/os/Parcel:writeString	(Ljava/lang/String;)V
        //   19: aload_0
        //   20: getfield 15	com/google/android/gms/internal/ni$a$a:le	Landroid/os/IBinder;
        //   23: bipush 34
        //   25: aload_2
        //   26: aload_3
        //   27: iconst_0
        //   28: invokeinterface 41 5 0
        //   33: pop
        //   34: aload_3
        //   35: invokevirtual 44	android/os/Parcel:readException	()V
        //   38: aload_3
        //   39: invokevirtual 164	android/os/Parcel:readInt	()I
        //   42: ifeq +27 -> 69
        //   45: getstatic 181	com/google/android/gms/location/e:CREATOR	Lcom/google/android/gms/location/f;
        //   48: aload_3
        //   49: invokevirtual 187	com/google/android/gms/location/f:cK	(Landroid/os/Parcel;)Lcom/google/android/gms/location/e;
        //   52: astore 7
        //   54: aload 7
        //   56: astore 6
        //   58: aload_3
        //   59: invokevirtual 47	android/os/Parcel:recycle	()V
        //   62: aload_2
        //   63: invokevirtual 47	android/os/Parcel:recycle	()V
        //   66: aload 6
        //   68: areturn
        //   69: aconst_null
        //   70: astore 6
        //   72: goto -14 -> 58
        //   75: astore 4
        //   77: aload_3
        //   78: invokevirtual 47	android/os/Parcel:recycle	()V
        //   81: aload_2
        //   82: invokevirtual 47	android/os/Parcel:recycle	()V
        //   85: aload 4
        //   87: athrow
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	88	0	this	a
        //   0	88	1	paramString	String
        //   3	79	2	localParcel1	Parcel
        //   7	71	3	localParcel2	Parcel
        //   75	11	4	localObject	Object
        //   56	15	6	locale1	e
        //   52	3	7	locale2	e
        // Exception table:
        //   from	to	target	type
        //   8	54	75	finally
      }
      
      /* Error */
      public Location ni()
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
        //   15: getfield 15	com/google/android/gms/internal/ni$a$a:le	Landroid/os/IBinder;
        //   18: bipush 7
        //   20: aload_1
        //   21: aload_2
        //   22: iconst_0
        //   23: invokeinterface 41 5 0
        //   28: pop
        //   29: aload_2
        //   30: invokevirtual 44	android/os/Parcel:readException	()V
        //   33: aload_2
        //   34: invokevirtual 164	android/os/Parcel:readInt	()I
        //   37: ifeq +28 -> 65
        //   40: getstatic 168	android/location/Location:CREATOR	Landroid/os/Parcelable$Creator;
        //   43: aload_2
        //   44: invokeinterface 174 2 0
        //   49: checkcast 76	android/location/Location
        //   52: astore 5
        //   54: aload_2
        //   55: invokevirtual 47	android/os/Parcel:recycle	()V
        //   58: aload_1
        //   59: invokevirtual 47	android/os/Parcel:recycle	()V
        //   62: aload 5
        //   64: areturn
        //   65: aconst_null
        //   66: astore 5
        //   68: goto -14 -> 54
        //   71: astore_3
        //   72: aload_2
        //   73: invokevirtual 47	android/os/Parcel:recycle	()V
        //   76: aload_1
        //   77: invokevirtual 47	android/os/Parcel:recycle	()V
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
      
      public IBinder nj()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          this.le.transact(51, localParcel1, localParcel2, 0);
          localParcel2.readException();
          IBinder localIBinder = localParcel2.readStrongBinder();
          return localIBinder;
        }
        finally
        {
          localParcel2.recycle();
          localParcel1.recycle();
        }
      }
      
      public IBinder nk()
        throws RemoteException
      {
        Parcel localParcel1 = Parcel.obtain();
        Parcel localParcel2 = Parcel.obtain();
        try
        {
          localParcel1.writeInterfaceToken("com.google.android.gms.location.internal.IGoogleLocationManagerService");
          this.le.transact(54, localParcel1, localParcel2, 0);
          localParcel2.readException();
          IBinder localIBinder = localParcel2.readStrongBinder();
          return localIBinder;
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
 * Qualified Name:     com.google.android.gms.internal.ni
 * JD-Core Version:    0.7.0.1
 */