package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class nq
  implements SafeParcelable
{
  public static final nr CREATOR = new nr();
  final int CK;
  final boolean ahm;
  final List<oa> ahn;
  private final Set<oa> aho;
  
  nq(int paramInt, boolean paramBoolean, List<oa> paramList)
  {
    this.CK = paramInt;
    this.ahm = paramBoolean;
    if (paramList == null) {}
    for (List localList = Collections.emptyList();; localList = Collections.unmodifiableList(paramList))
    {
      this.ahn = localList;
      if (!this.ahn.isEmpty()) {
        break;
      }
      this.aho = Collections.emptySet();
      return;
    }
    this.aho = Collections.unmodifiableSet(new HashSet(this.ahn));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    nq localnq;
    do
    {
      return true;
      if (!(paramObject instanceof nq)) {
        return false;
      }
      localnq = (nq)paramObject;
    } while ((this.aho.equals(localnq.aho)) && (this.ahm == localnq.ahm));
    return false;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.aho;
    arrayOfObject[1] = Boolean.valueOf(this.ahm);
    return jv.hashCode(arrayOfObject);
  }
  
  public boolean nr()
  {
    return this.ahm;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    nr.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nq
 * JD-Core Version:    0.7.0.1
 */