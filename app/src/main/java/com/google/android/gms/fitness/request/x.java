package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import com.google.android.gms.fitness.data.Session;

public class x
  implements Parcelable.Creator<w>
{
  static void a(w paramw, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.a(paramParcel, 1, paramw.getSession(), paramInt, false);
    b.c(paramParcel, 1000, paramw.getVersionCode());
    b.H(paramParcel, i);
  }
  
  public w bV(Parcel paramParcel)
  {
    int i = a.G(paramParcel);
    int j = 0;
    Session localSession = null;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      switch (a.aH(k))
      {
      default: 
        a.b(paramParcel, k);
        break;
      case 1: 
        localSession = (Session)a.a(paramParcel, k, Session.CREATOR);
        break;
      case 1000: 
        j = a.g(paramParcel, k);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new w(j, localSession);
  }
  
  public w[] dq(int paramInt)
  {
    return new w[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.x
 * JD-Core Version:    0.7.0.1
 */