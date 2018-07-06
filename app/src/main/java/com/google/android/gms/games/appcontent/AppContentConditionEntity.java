package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;

public final class AppContentConditionEntity
  implements SafeParcelable, AppContentCondition
{
  public static final AppContentConditionEntityCreator CREATOR = new AppContentConditionEntityCreator();
  private final int CK;
  private final String XT;
  private final String XU;
  private final String XV;
  private final Bundle XW;
  
  AppContentConditionEntity(int paramInt, String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    this.CK = paramInt;
    this.XT = paramString1;
    this.XU = paramString2;
    this.XV = paramString3;
    this.XW = paramBundle;
  }
  
  public AppContentConditionEntity(AppContentCondition paramAppContentCondition)
  {
    this.CK = 1;
    this.XT = paramAppContentCondition.kT();
    this.XU = paramAppContentCondition.kT();
    this.XV = paramAppContentCondition.kV();
    this.XW = paramAppContentCondition.kW();
  }
  
  static int a(AppContentCondition paramAppContentCondition)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = paramAppContentCondition.kT();
    arrayOfObject[1] = paramAppContentCondition.kU();
    arrayOfObject[2] = paramAppContentCondition.kV();
    arrayOfObject[3] = paramAppContentCondition.kW();
    return jv.hashCode(arrayOfObject);
  }
  
  static boolean a(AppContentCondition paramAppContentCondition, Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof AppContentCondition)) {
      bool = false;
    }
    AppContentCondition localAppContentCondition;
    do
    {
      do
      {
        return bool;
      } while (paramAppContentCondition == paramObject);
      localAppContentCondition = (AppContentCondition)paramObject;
    } while ((jv.equal(localAppContentCondition.kT(), paramAppContentCondition.kT())) && (jv.equal(localAppContentCondition.kU(), paramAppContentCondition.kU())) && (jv.equal(localAppContentCondition.kV(), paramAppContentCondition.kV())) && (jv.equal(localAppContentCondition.kW(), paramAppContentCondition.kW())));
    return false;
  }
  
  static String b(AppContentCondition paramAppContentCondition)
  {
    return jv.h(paramAppContentCondition).a("DefaultValue", paramAppContentCondition.kT()).a("ExpectedValue", paramAppContentCondition.kU()).a("Predicate", paramAppContentCondition.kV()).a("PredicateParameters", paramAppContentCondition.kW()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
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
  
  public String kT()
  {
    return this.XT;
  }
  
  public String kU()
  {
    return this.XU;
  }
  
  public String kV()
  {
    return this.XV;
  }
  
  public Bundle kW()
  {
    return this.XW;
  }
  
  public AppContentCondition kX()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppContentConditionEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.appcontent.AppContentConditionEntity
 * JD-Core Version:    0.7.0.1
 */