package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.nn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeofencingRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<GeofencingRequest> CREATOR = new a();
  public static final int INITIAL_TRIGGER_DWELL = 4;
  public static final int INITIAL_TRIGGER_ENTER = 1;
  public static final int INITIAL_TRIGGER_EXIT = 2;
  private final int CK;
  private final List<nn> ago;
  private final int agp;
  
  GeofencingRequest(int paramInt1, List<nn> paramList, int paramInt2)
  {
    this.CK = paramInt1;
    this.ago = paramList;
    this.agp = paramInt2;
  }
  
  private GeofencingRequest(List<nn> paramList, int paramInt)
  {
    this(1, paramList, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<Geofence> getGeofences()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.ago);
    return localArrayList;
  }
  
  public int getInitialTrigger()
  {
    return this.agp;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public List<nn> ng()
  {
    return this.ago;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
  
  public static final class Builder
  {
    private final List<nn> ago = new ArrayList();
    private int agp = 5;
    
    public static int ew(int paramInt)
    {
      return paramInt & 0x7;
    }
    
    public Builder addGeofence(Geofence paramGeofence)
    {
      jx.b(paramGeofence, "geofence can't be null.");
      jx.b(paramGeofence instanceof nn, "Geofence must be created using Geofence.Builder.");
      this.ago.add((nn)paramGeofence);
      return this;
    }
    
    public Builder addGeofences(List<Geofence> paramList)
    {
      if ((paramList == null) || (paramList.isEmpty())) {}
      for (;;)
      {
        return this;
        Iterator localIterator = paramList.iterator();
        while (localIterator.hasNext())
        {
          Geofence localGeofence = (Geofence)localIterator.next();
          if (localGeofence != null) {
            addGeofence(localGeofence);
          }
        }
      }
    }
    
    public GeofencingRequest build()
    {
      if (!this.ago.isEmpty()) {}
      for (boolean bool = true;; bool = false)
      {
        jx.b(bool, "No geofence has been added to this request.");
        return new GeofencingRequest(this.ago, this.agp, null);
      }
    }
    
    public Builder setInitialTrigger(int paramInt)
    {
      this.agp = ew(paramInt);
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.GeofencingRequest
 * JD-Core Version:    0.7.0.1
 */