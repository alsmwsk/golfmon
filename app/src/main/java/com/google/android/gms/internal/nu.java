package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class nu
  implements SafeParcelable
{
  public static final nv CREATOR = new nv();
  final int CK;
  final List<oa> ahn;
  private final Set<oa> aho;
  private final String ahr;
  private final boolean ahs;
  final List<oe> aht;
  final List<String> ahu;
  private final Set<oe> ahv;
  private final Set<String> ahw;
  
  nu(int paramInt, List<oa> paramList, String paramString, boolean paramBoolean, List<oe> paramList1, List<String> paramList2)
  {
    this.CK = paramInt;
    List localList1;
    List localList2;
    if (paramList == null)
    {
      localList1 = Collections.emptyList();
      this.ahn = localList1;
      if (paramString == null) {
        paramString = "";
      }
      this.ahr = paramString;
      this.ahs = paramBoolean;
      if (paramList1 != null) {
        break label117;
      }
      localList2 = Collections.emptyList();
      label52:
      this.aht = localList2;
      if (paramList2 != null) {
        break label127;
      }
    }
    label117:
    label127:
    for (List localList3 = Collections.emptyList();; localList3 = Collections.unmodifiableList(paramList2))
    {
      this.ahu = localList3;
      this.aho = g(this.ahn);
      this.ahv = g(this.aht);
      this.ahw = g(this.ahu);
      return;
      localList1 = Collections.unmodifiableList(paramList);
      break;
      localList2 = Collections.unmodifiableList(paramList1);
      break label52;
    }
  }
  
  private static <E> Set<E> g(List<E> paramList)
  {
    if (paramList.isEmpty()) {
      return Collections.emptySet();
    }
    return Collections.unmodifiableSet(new HashSet(paramList));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    nu localnu;
    do
    {
      return true;
      if (!(paramObject instanceof nu)) {
        return false;
      }
      localnu = (nu)paramObject;
    } while ((this.aho.equals(localnu.aho)) && (this.ahs == localnu.ahs) && (this.ahv.equals(localnu.ahv)) && (this.ahw.equals(localnu.ahw)));
    return false;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = this.aho;
    arrayOfObject[1] = Boolean.valueOf(this.ahs);
    arrayOfObject[2] = this.ahv;
    arrayOfObject[3] = this.ahw;
    return jv.hashCode(arrayOfObject);
  }
  
  @Deprecated
  public String nu()
  {
    return this.ahr;
  }
  
  public boolean nv()
  {
    return this.ahs;
  }
  
  public String toString()
  {
    return jv.h(this).a("types", this.aho).a("placeIds", this.ahw).a("requireOpenNow", Boolean.valueOf(this.ahs)).a("requestedUserDataTypes", this.ahv).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    nv.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.nu
 * JD-Core Version:    0.7.0.1
 */