package com.google.android.gms.drive.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;

public class ab
  implements Parcelable.Creator<FileUploadPreferencesImpl>
{
  static void a(FileUploadPreferencesImpl paramFileUploadPreferencesImpl, Parcel paramParcel, int paramInt)
  {
    int i = b.H(paramParcel);
    b.c(paramParcel, 1, paramFileUploadPreferencesImpl.CK);
    b.c(paramParcel, 2, paramFileUploadPreferencesImpl.Qz);
    b.c(paramParcel, 3, paramFileUploadPreferencesImpl.QA);
    b.a(paramParcel, 4, paramFileUploadPreferencesImpl.QB);
    b.H(paramParcel, i);
  }
  
  public FileUploadPreferencesImpl al(Parcel paramParcel)
  {
    boolean bool = false;
    int i = a.G(paramParcel);
    int j = 0;
    int k = 0;
    int m = 0;
    while (paramParcel.dataPosition() < i)
    {
      int n = a.F(paramParcel);
      switch (a.aH(n))
      {
      default: 
        a.b(paramParcel, n);
        break;
      case 1: 
        m = a.g(paramParcel, n);
        break;
      case 2: 
        k = a.g(paramParcel, n);
        break;
      case 3: 
        j = a.g(paramParcel, n);
        break;
      case 4: 
        bool = a.c(paramParcel, n);
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    return new FileUploadPreferencesImpl(m, k, j, bool);
  }
  
  public FileUploadPreferencesImpl[] bA(int paramInt)
  {
    return new FileUploadPreferencesImpl[paramInt];
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ab
 * JD-Core Version:    0.7.0.1
 */