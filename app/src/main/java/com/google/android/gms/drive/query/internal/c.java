package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class c
  implements Parcelable.Creator<FieldWithSortOrder>
{
  static void a(FieldWithSortOrder paramFieldWithSortOrder, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1000, paramFieldWithSortOrder.CK);
    b.a(paramParcel, 1, paramFieldWithSortOrder.QY, false);
    b.a(paramParcel, 2, paramFieldWithSortOrder.Sk);
    b.H(paramParcel, i);
  }
  
  public FieldWithSortOrder aU(Parcel paramParcel)
  {
    boolean bool = false;
    int i = a.G(paramParcel);
    String str = null;
    int j = 0;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
        break;
      case 1: 
        str = a.o(paramParcel, k);
        break;
      case 2: 
        bool = a.c(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new FieldWithSortOrder(j, str, bool);
  }
  
  public FieldWithSortOrder[] cj(int paramInt)
  {
    return new FieldWithSortOrder[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.c
 * JD-Core Version:    0.7.0.1
 */