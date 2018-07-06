package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import java.util.ArrayList;

public class a
  implements Parcelable.Creator<Query>
{
  static void a(Query paramQuery, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1000, paramQuery.CK);
    b.a(paramParcel, 1, paramQuery.RY, paramInt, false);
    b.a(paramParcel, 3, paramQuery.RZ, false);
    b.a(paramParcel, 4, paramQuery.Sa, paramInt, false);
    b.b(paramParcel, 5, paramQuery.Sb, false);
    b.H(paramParcel, i);
  }
  
  public Query aQ(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int i = com.google.android.gms.common.internal.safeparcel.a.G(paramParcel);
    int j = 0;
    SortOrder localSortOrder = null;
    String str = null;
    LogicalFilter localLogicalFilter = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = com.google.android.gms.common.internal.safeparcel.a.F(paramParcel);
      switch (com.google.android.gms.common.internal.safeparcel.a.aH(k))
      {
      default: 
        com.google.android.gms.common.internal.safeparcel.a.b(paramParcel, k);
        break;
      case 1000: 
        j = com.google.android.gms.common.internal.safeparcel.a.g(paramParcel, k);
        break;
      case 1: 
        localLogicalFilter = (LogicalFilter)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, LogicalFilter.CREATOR);
        break;
      case 3: 
        str = com.google.android.gms.common.internal.safeparcel.a.o(paramParcel, k);
        break;
      case 4: 
        localSortOrder = (SortOrder)com.google.android.gms.common.internal.safeparcel.a.a(paramParcel, k, SortOrder.CREATOR);
        break;
      case 5: 
        localArrayList = com.google.android.gms.common.internal.safeparcel.a.C(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new Query(j, localLogicalFilter, str, localSortOrder, localArrayList);
  }
  
  public Query[] cf(int paramInt)
  {
    return new Query[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.a
 * JD-Core Version:    0.7.0.1
 */