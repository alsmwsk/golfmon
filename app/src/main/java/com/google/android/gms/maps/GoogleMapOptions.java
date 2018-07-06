package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.R.styleable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.maps.internal.aa;
import com.google.android.gms.maps.model.CameraPosition;

public final class GoogleMapOptions
  implements SafeParcelable
{
  public static final a CREATOR = new a();
  private final int CK;
  private Boolean akF;
  private Boolean akG;
  private int akH = -1;
  private CameraPosition akI;
  private Boolean akJ;
  private Boolean akK;
  private Boolean akL;
  private Boolean akM;
  private Boolean akN;
  private Boolean akO;
  private Boolean akP;
  private Boolean akQ;
  
  public GoogleMapOptions()
  {
    this.CK = 1;
  }
  
  GoogleMapOptions(int paramInt1, byte paramByte1, byte paramByte2, int paramInt2, CameraPosition paramCameraPosition, byte paramByte3, byte paramByte4, byte paramByte5, byte paramByte6, byte paramByte7, byte paramByte8, byte paramByte9, byte paramByte10)
  {
    this.CK = paramInt1;
    this.akF = com.google.android.gms.maps.internal.a.a(paramByte1);
    this.akG = com.google.android.gms.maps.internal.a.a(paramByte2);
    this.akH = paramInt2;
    this.akI = paramCameraPosition;
    this.akJ = com.google.android.gms.maps.internal.a.a(paramByte3);
    this.akK = com.google.android.gms.maps.internal.a.a(paramByte4);
    this.akL = com.google.android.gms.maps.internal.a.a(paramByte5);
    this.akM = com.google.android.gms.maps.internal.a.a(paramByte6);
    this.akN = com.google.android.gms.maps.internal.a.a(paramByte7);
    this.akO = com.google.android.gms.maps.internal.a.a(paramByte8);
    this.akP = com.google.android.gms.maps.internal.a.a(paramByte9);
    this.akQ = com.google.android.gms.maps.internal.a.a(paramByte10);
  }
  
  public static GoogleMapOptions createFromAttributes(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null) {
      return null;
    }
    TypedArray localTypedArray = paramContext.getResources().obtainAttributes(paramAttributeSet, R.styleable.MapAttrs);
    GoogleMapOptions localGoogleMapOptions = new GoogleMapOptions();
    if (localTypedArray.hasValue(R.styleable.MapAttrs_mapType)) {
      localGoogleMapOptions.mapType(localTypedArray.getInt(R.styleable.MapAttrs_mapType, -1));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_zOrderOnTop)) {
      localGoogleMapOptions.zOrderOnTop(localTypedArray.getBoolean(R.styleable.MapAttrs_zOrderOnTop, false));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_useViewLifecycle)) {
      localGoogleMapOptions.useViewLifecycleInFragment(localTypedArray.getBoolean(R.styleable.MapAttrs_useViewLifecycle, false));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiCompass)) {
      localGoogleMapOptions.compassEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiCompass, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiRotateGestures)) {
      localGoogleMapOptions.rotateGesturesEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiRotateGestures, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiScrollGestures)) {
      localGoogleMapOptions.scrollGesturesEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiScrollGestures, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiTiltGestures)) {
      localGoogleMapOptions.tiltGesturesEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiTiltGestures, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiZoomGestures)) {
      localGoogleMapOptions.zoomGesturesEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiZoomGestures, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiZoomControls)) {
      localGoogleMapOptions.zoomControlsEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiZoomControls, true));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_liteMode)) {
      localGoogleMapOptions.liteMode(localTypedArray.getBoolean(R.styleable.MapAttrs_liteMode, false));
    }
    if (localTypedArray.hasValue(R.styleable.MapAttrs_uiMapToolbar)) {
      localGoogleMapOptions.mapToolbarEnabled(localTypedArray.getBoolean(R.styleable.MapAttrs_uiMapToolbar, true));
    }
    localGoogleMapOptions.camera(CameraPosition.createFromAttributes(paramContext, paramAttributeSet));
    localTypedArray.recycle();
    return localGoogleMapOptions;
  }
  
  public GoogleMapOptions camera(CameraPosition paramCameraPosition)
  {
    this.akI = paramCameraPosition;
    return this;
  }
  
  public GoogleMapOptions compassEnabled(boolean paramBoolean)
  {
    this.akK = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public CameraPosition getCamera()
  {
    return this.akI;
  }
  
  public Boolean getCompassEnabled()
  {
    return this.akK;
  }
  
  public Boolean getLiteMode()
  {
    return this.akP;
  }
  
  public Boolean getMapToolbarEnabled()
  {
    return this.akQ;
  }
  
  public int getMapType()
  {
    return this.akH;
  }
  
  public Boolean getRotateGesturesEnabled()
  {
    return this.akO;
  }
  
  public Boolean getScrollGesturesEnabled()
  {
    return this.akL;
  }
  
  public Boolean getTiltGesturesEnabled()
  {
    return this.akN;
  }
  
  public Boolean getUseViewLifecycleInFragment()
  {
    return this.akG;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public Boolean getZOrderOnTop()
  {
    return this.akF;
  }
  
  public Boolean getZoomControlsEnabled()
  {
    return this.akJ;
  }
  
  public Boolean getZoomGesturesEnabled()
  {
    return this.akM;
  }
  
  public GoogleMapOptions liteMode(boolean paramBoolean)
  {
    this.akP = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions mapToolbarEnabled(boolean paramBoolean)
  {
    this.akQ = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions mapType(int paramInt)
  {
    this.akH = paramInt;
    return this;
  }
  
  byte nD()
  {
    return com.google.android.gms.maps.internal.a.c(this.akF);
  }
  
  byte nE()
  {
    return com.google.android.gms.maps.internal.a.c(this.akG);
  }
  
  byte nF()
  {
    return com.google.android.gms.maps.internal.a.c(this.akJ);
  }
  
  byte nG()
  {
    return com.google.android.gms.maps.internal.a.c(this.akK);
  }
  
  byte nH()
  {
    return com.google.android.gms.maps.internal.a.c(this.akL);
  }
  
  byte nI()
  {
    return com.google.android.gms.maps.internal.a.c(this.akM);
  }
  
  byte nJ()
  {
    return com.google.android.gms.maps.internal.a.c(this.akN);
  }
  
  byte nK()
  {
    return com.google.android.gms.maps.internal.a.c(this.akO);
  }
  
  byte nL()
  {
    return com.google.android.gms.maps.internal.a.c(this.akP);
  }
  
  byte nM()
  {
    return com.google.android.gms.maps.internal.a.c(this.akQ);
  }
  
  public GoogleMapOptions rotateGesturesEnabled(boolean paramBoolean)
  {
    this.akO = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions scrollGesturesEnabled(boolean paramBoolean)
  {
    this.akL = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions tiltGesturesEnabled(boolean paramBoolean)
  {
    this.akN = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions useViewLifecycleInFragment(boolean paramBoolean)
  {
    this.akG = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    if (aa.ob())
    {
      b.a(this, paramParcel, paramInt);
      return;
    }
    a.a(this, paramParcel, paramInt);
  }
  
  public GoogleMapOptions zOrderOnTop(boolean paramBoolean)
  {
    this.akF = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions zoomControlsEnabled(boolean paramBoolean)
  {
    this.akJ = Boolean.valueOf(paramBoolean);
    return this;
  }
  
  public GoogleMapOptions zoomGesturesEnabled(boolean paramBoolean)
  {
    this.akM = Boolean.valueOf(paramBoolean);
    return this;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.GoogleMapOptions
 * JD-Core Version:    0.7.0.1
 */