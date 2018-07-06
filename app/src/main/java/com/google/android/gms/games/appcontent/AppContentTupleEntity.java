package com.google.android.gms.games.appcontent;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;

public final class AppContentTupleEntity
  implements SafeParcelable, AppContentTuple
{
  public static final AppContentTupleEntityCreator CREATOR = new AppContentTupleEntityCreator();
  private final int CK;
  private final String mName;
  private final String mValue;
  
  AppContentTupleEntity(int paramInt, String paramString1, String paramString2)
  {
    this.CK = paramInt;
    this.mName = paramString1;
    this.mValue = paramString2;
  }
  
  public AppContentTupleEntity(AppContentTuple paramAppContentTuple)
  {
    this.CK = 1;
    this.mName = paramAppContentTuple.getName();
    this.mValue = paramAppContentTuple.getValue();
  }
  
  static int a(AppContentTuple paramAppContentTuple)
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramAppContentTuple.getName();
    arrayOfObject[1] = paramAppContentTuple.getValue();
    return jv.hashCode(arrayOfObject);
  }
  
  static boolean a(AppContentTuple paramAppContentTuple, Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof AppContentTuple)) {
      bool = false;
    }
    AppContentTuple localAppContentTuple;
    do
    {
      do
      {
        return bool;
      } while (paramAppContentTuple == paramObject);
      localAppContentTuple = (AppContentTuple)paramObject;
    } while ((jv.equal(localAppContentTuple.getName(), paramAppContentTuple.getName())) && (jv.equal(localAppContentTuple.getValue(), paramAppContentTuple.getValue())));
    return false;
  }
  
  static String b(AppContentTuple paramAppContentTuple)
  {
    return jv.h(paramAppContentTuple).a("Name", paramAppContentTuple.getName()).a("Value", paramAppContentTuple.getValue()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public String getValue()
  {
    return this.mValue;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public AppContentTuple ld()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppContentTupleEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.appcontent.AppContentTupleEntity
 * JD-Core Version:    0.7.0.1
 */