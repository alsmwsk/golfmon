package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class oe
  implements SafeParcelable
{
  public static final of CREATOR = new of();
  public static final oe akb = A("test_type", 1);
  public static final oe akc = A("labeled_place", 6);
  public static final Set<oe> akd;
  final int CK;
  final int ake;
  final String vc;
  
  static
  {
    oe[] arrayOfoe = new oe[2];
    arrayOfoe[0] = akb;
    arrayOfoe[1] = akc;
    akd = Collections.unmodifiableSet(new HashSet(Arrays.asList(arrayOfoe)));
  }
  
  oe(int paramInt1, String paramString, int paramInt2)
  {
    jx.bb(paramString);
    this.CK = paramInt1;
    this.vc = paramString;
    this.ake = paramInt2;
  }
  
  private static oe A(String paramString, int paramInt)
  {
    return new oe(0, paramString, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    oe localoe;
    do
    {
      return true;
      if (!(paramObject instanceof oe)) {
        return false;
      }
      localoe = (oe)paramObject;
    } while ((this.vc.equals(localoe.vc)) && (this.ake == localoe.ake));
    return false;
  }
  
  public int hashCode()
  {
    return this.vc.hashCode();
  }
  
  public String toString()
  {
    return this.vc;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    of.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.oe
 * JD-Core Version:    0.7.0.1
 */