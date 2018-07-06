package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;

public class StreetViewPanoramaLocation
  implements SafeParcelable
{
  public static final s CREATOR = new s();
  private final int CK;
  public final StreetViewPanoramaLink[] links;
  public final String panoId;
  public final LatLng position;
  
  StreetViewPanoramaLocation(int paramInt, StreetViewPanoramaLink[] paramArrayOfStreetViewPanoramaLink, LatLng paramLatLng, String paramString)
  {
    this.CK = paramInt;
    this.links = paramArrayOfStreetViewPanoramaLink;
    this.position = paramLatLng;
    this.panoId = paramString;
  }
  
  public StreetViewPanoramaLocation(StreetViewPanoramaLink[] paramArrayOfStreetViewPanoramaLink, LatLng paramLatLng, String paramString)
  {
    this(1, paramArrayOfStreetViewPanoramaLink, paramLatLng, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    StreetViewPanoramaLocation localStreetViewPanoramaLocation;
    do
    {
      return true;
      if (!(paramObject instanceof StreetViewPanoramaLocation)) {
        return false;
      }
      localStreetViewPanoramaLocation = (StreetViewPanoramaLocation)paramObject;
    } while ((this.panoId.equals(localStreetViewPanoramaLocation.panoId)) && (this.position.equals(localStreetViewPanoramaLocation.position)));
    return false;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.position;
    arrayOfObject[1] = this.panoId;
    return jv.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return jv.h(this).a("panoId", this.panoId).a("position", this.position.toString()).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    s.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.StreetViewPanoramaLocation
 * JD-Core Version:    0.7.0.1
 */