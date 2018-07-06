package com.google.android.gms.location;

import android.os.SystemClock;
import com.google.android.gms.internal.nn;

public abstract interface Geofence
{
  public static final int GEOFENCE_TRANSITION_DWELL = 4;
  public static final int GEOFENCE_TRANSITION_ENTER = 1;
  public static final int GEOFENCE_TRANSITION_EXIT = 2;
  public static final long NEVER_EXPIRE = -1L;
  
  public abstract String getRequestId();
  
  public static final class Builder
  {
    private String Zt = null;
    private int agd = 0;
    private long age = -9223372036854775808L;
    private short agf = -1;
    private double agg;
    private double agh;
    private float agi;
    private int agj = 0;
    private int agk = -1;
    
    public Geofence build()
    {
      if (this.Zt == null) {
        throw new IllegalArgumentException("Request ID not set.");
      }
      if (this.agd == 0) {
        throw new IllegalArgumentException("Transitions types not set.");
      }
      if (((0x4 & this.agd) != 0) && (this.agk < 0)) {
        throw new IllegalArgumentException("Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING.");
      }
      if (this.age == -9223372036854775808L) {
        throw new IllegalArgumentException("Expiration not set.");
      }
      if (this.agf == -1) {
        throw new IllegalArgumentException("Geofence region not set.");
      }
      if (this.agj < 0) {
        throw new IllegalArgumentException("Notification responsiveness should be nonnegative.");
      }
      return new nn(this.Zt, this.agd, (short)1, this.agg, this.agh, this.agi, this.age, this.agj, this.agk);
    }
    
    public Builder setCircularRegion(double paramDouble1, double paramDouble2, float paramFloat)
    {
      this.agf = 1;
      this.agg = paramDouble1;
      this.agh = paramDouble2;
      this.agi = paramFloat;
      return this;
    }
    
    public Builder setExpirationDuration(long paramLong)
    {
      if (paramLong < 0L)
      {
        this.age = -1L;
        return this;
      }
      this.age = (paramLong + SystemClock.elapsedRealtime());
      return this;
    }
    
    public Builder setLoiteringDelay(int paramInt)
    {
      this.agk = paramInt;
      return this;
    }
    
    public Builder setNotificationResponsiveness(int paramInt)
    {
      this.agj = paramInt;
      return this;
    }
    
    public Builder setRequestId(String paramString)
    {
      this.Zt = paramString;
      return this;
    }
    
    public Builder setTransitionTypes(int paramInt)
    {
      this.agd = paramInt;
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.Geofence
 * JD-Core Version:    0.7.0.1
 */