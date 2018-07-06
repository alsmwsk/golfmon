package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.jx;

public class StreetViewPanoramaCamera
  implements SafeParcelable
{
  public static final q CREATOR = new q();
  private final int CK;
  private StreetViewPanoramaOrientation amB;
  public final float bearing;
  public final float tilt;
  public final float zoom;
  
  public StreetViewPanoramaCamera(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this(1, paramFloat1, paramFloat2, paramFloat3);
  }
  
  StreetViewPanoramaCamera(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    boolean bool;
    if ((-90.0F <= paramFloat2) && (paramFloat2 <= 90.0F))
    {
      bool = true;
      jx.b(bool, "Tilt needs to be between -90 and 90 inclusive");
      this.CK = paramInt;
      if (paramFloat1 <= 0.0D) {
        paramFloat1 = 0.0F;
      }
      this.zoom = paramFloat1;
      this.tilt = (paramFloat2 + 0.0F);
      if (paramFloat3 > 0.0D) {
        break label111;
      }
    }
    label111:
    for (float f = 360.0F + paramFloat3 % 360.0F;; f = paramFloat3)
    {
      this.bearing = (f % 360.0F);
      this.amB = new StreetViewPanoramaOrientation.Builder().tilt(paramFloat2).bearing(paramFloat3).build();
      return;
      bool = false;
      break;
    }
  }
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  public static Builder builder(StreetViewPanoramaCamera paramStreetViewPanoramaCamera)
  {
    return new Builder(paramStreetViewPanoramaCamera);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    StreetViewPanoramaCamera localStreetViewPanoramaCamera;
    do
    {
      return true;
      if (!(paramObject instanceof StreetViewPanoramaCamera)) {
        return false;
      }
      localStreetViewPanoramaCamera = (StreetViewPanoramaCamera)paramObject;
    } while ((Float.floatToIntBits(this.zoom) == Float.floatToIntBits(localStreetViewPanoramaCamera.zoom)) && (Float.floatToIntBits(this.tilt) == Float.floatToIntBits(localStreetViewPanoramaCamera.tilt)) && (Float.floatToIntBits(this.bearing) == Float.floatToIntBits(localStreetViewPanoramaCamera.bearing)));
    return false;
  }
  
  public StreetViewPanoramaOrientation getOrientation()
  {
    return this.amB;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Float.valueOf(this.zoom);
    arrayOfObject[1] = Float.valueOf(this.tilt);
    arrayOfObject[2] = Float.valueOf(this.bearing);
    return jv.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return jv.h(this).a("zoom", Float.valueOf(this.zoom)).a("tilt", Float.valueOf(this.tilt)).a("bearing", Float.valueOf(this.bearing)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    q.a(this, paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    public float bearing;
    public float tilt;
    public float zoom;
    
    public Builder() {}
    
    public Builder(StreetViewPanoramaCamera paramStreetViewPanoramaCamera)
    {
      this.zoom = paramStreetViewPanoramaCamera.zoom;
      this.bearing = paramStreetViewPanoramaCamera.bearing;
      this.tilt = paramStreetViewPanoramaCamera.tilt;
    }
    
    public Builder bearing(float paramFloat)
    {
      this.bearing = paramFloat;
      return this;
    }
    
    public StreetViewPanoramaCamera build()
    {
      return new StreetViewPanoramaCamera(this.zoom, this.tilt, this.bearing);
    }
    
    public Builder orientation(StreetViewPanoramaOrientation paramStreetViewPanoramaOrientation)
    {
      this.tilt = paramStreetViewPanoramaOrientation.tilt;
      this.bearing = paramStreetViewPanoramaOrientation.bearing;
      return this;
    }
    
    public Builder tilt(float paramFloat)
    {
      this.tilt = paramFloat;
      return this;
    }
    
    public Builder zoom(float paramFloat)
    {
      this.zoom = paramFloat;
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.StreetViewPanoramaCamera
 * JD-Core Version:    0.7.0.1
 */