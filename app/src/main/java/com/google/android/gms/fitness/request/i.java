package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.Field;
import java.util.ArrayList;

public class i
  implements Parcelable.Creator<DataTypeCreateRequest>
{
  static void a(DataTypeCreateRequest paramDataTypeCreateRequest, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramDataTypeCreateRequest.getName(), false);
    b.c(paramParcel, 1000, paramDataTypeCreateRequest.getVersionCode());
    b.c(paramParcel, 2, paramDataTypeCreateRequest.getFields(), false);
    b.H(paramParcel, i);
  }
  
  public DataTypeCreateRequest bN(Parcel paramParcel)
  {
    ArrayList localArrayList = null;
    int i = a.G(paramParcel);
    int j = 0;
    String str = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        str = a.o(paramParcel, k);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
        break;
      case 2: 
        localArrayList = a.c(paramParcel, k, Field.CREATOR);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new DataTypeCreateRequest(j, str, localArrayList);
  }
  
  public DataTypeCreateRequest[] dh(int paramInt)
  {
    return new DataTypeCreateRequest[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.i
 * JD-Core Version:    0.7.0.1
 */