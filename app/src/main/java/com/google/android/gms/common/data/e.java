package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class e<T extends SafeParcelable>
  extends DataBuffer<T>
{
  private static final String[] Lb = { "data" };
  private final Parcelable.Creator<T> Lc;
  
  public e(DataHolder paramDataHolder, Parcelable.Creator<T> paramCreator)
  {
    super(paramDataHolder);
    this.Lc = paramCreator;
  }
  
  public T at(int paramInt)
  {
    byte[] arrayOfByte = this.JG.f("data", paramInt, this.JG.au(paramInt));
    Parcel localParcel = Parcel.obtain();
    localParcel.unmarshall(arrayOfByte, 0, arrayOfByte.length);
    localParcel.setDataPosition(0);
    SafeParcelable localSafeParcelable = (SafeParcelable)this.Lc.createFromParcel(localParcel);
    localParcel.recycle();
    return localSafeParcelable;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.e
 * JD-Core Version:    0.7.0.1
 */