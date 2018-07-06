package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@ey
public final class db
  implements MediationAdRequest
{
  private final Date d;
  private final Set<String> f;
  private final boolean g;
  private final Location h;
  private final int ow;
  private final int qU;
  
  public db(Date paramDate, int paramInt1, Set<String> paramSet, Location paramLocation, boolean paramBoolean, int paramInt2)
  {
    this.d = paramDate;
    this.ow = paramInt1;
    this.f = paramSet;
    this.h = paramLocation;
    this.g = paramBoolean;
    this.qU = paramInt2;
  }
  
  public Date getBirthday()
  {
    return this.d;
  }
  
  public int getGender()
  {
    return this.ow;
  }
  
  public Set<String> getKeywords()
  {
    return this.f;
  }
  
  public Location getLocation()
  {
    return this.h;
  }
  
  public boolean isTesting()
  {
    return this.g;
  }
  
  public int taggedForChildDirectedTreatment()
  {
    return this.qU;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.db
 * JD-Core Version:    0.7.0.1
 */