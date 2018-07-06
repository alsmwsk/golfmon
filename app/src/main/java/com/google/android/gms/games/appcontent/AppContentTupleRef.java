package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class AppContentTupleRef
  extends d
  implements AppContentTuple
{
  AppContentTupleRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return AppContentTupleEntity.a(this, paramObject);
  }
  
  public String getName()
  {
    return getString("tuple_name");
  }
  
  public String getValue()
  {
    return getString("tuple_value");
  }
  
  public int hashCode()
  {
    return AppContentTupleEntity.a(this);
  }
  
  public AppContentTuple ld()
  {
    return new AppContentTupleEntity(this);
  }
  
  public String toString()
  {
    return AppContentTupleEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((AppContentTupleEntity)ld()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.appcontent.AppContentTupleRef
 * JD-Core Version:    0.7.0.1
 */