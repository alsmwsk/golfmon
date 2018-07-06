package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import java.util.ArrayList;
import java.util.List;

public final class AppContentActionEntity
  implements SafeParcelable, AppContentAction
{
  public static final AppContentActionEntityCreator CREATOR = new AppContentActionEntityCreator();
  private final int CK;
  private final ArrayList<AppContentConditionEntity> XJ;
  private final String XK;
  private final String XL;
  private final String XM;
  private final Bundle mExtras;
  private final String vc;
  
  AppContentActionEntity(int paramInt, ArrayList<AppContentConditionEntity> paramArrayList, String paramString1, Bundle paramBundle, String paramString2, String paramString3, String paramString4)
  {
    this.CK = paramInt;
    this.XJ = paramArrayList;
    this.XK = paramString1;
    this.mExtras = paramBundle;
    this.XL = paramString2;
    this.XM = paramString3;
    this.vc = paramString4;
  }
  
  public AppContentActionEntity(AppContentAction paramAppContentAction)
  {
    this.CK = 1;
    this.XK = paramAppContentAction.kI();
    this.mExtras = paramAppContentAction.getExtras();
    this.XL = paramAppContentAction.getLabel();
    this.XM = paramAppContentAction.kJ();
    this.vc = paramAppContentAction.getType();
    List localList = paramAppContentAction.kH();
    int i = localList.size();
    this.XJ = new ArrayList(i);
    for (int j = 0; j < i; j++) {
      this.XJ.add((AppContentConditionEntity)((AppContentCondition)localList.get(j)).freeze());
    }
  }
  
  static int a(AppContentAction paramAppContentAction)
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = paramAppContentAction.kH();
    arrayOfObject[1] = paramAppContentAction.kI();
    arrayOfObject[2] = paramAppContentAction.getExtras();
    arrayOfObject[3] = paramAppContentAction.getLabel();
    arrayOfObject[4] = paramAppContentAction.kJ();
    arrayOfObject[5] = paramAppContentAction.getType();
    return jv.hashCode(arrayOfObject);
  }
  
  static boolean a(AppContentAction paramAppContentAction, Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof AppContentAction)) {
      bool = false;
    }
    AppContentAction localAppContentAction;
    do
    {
      do
      {
        return bool;
      } while (paramAppContentAction == paramObject);
      localAppContentAction = (AppContentAction)paramObject;
    } while ((jv.equal(localAppContentAction.kH(), paramAppContentAction.kH())) && (jv.equal(localAppContentAction.kI(), paramAppContentAction.kI())) && (jv.equal(localAppContentAction.getExtras(), paramAppContentAction.getExtras())) && (jv.equal(localAppContentAction.getLabel(), paramAppContentAction.getLabel())) && (jv.equal(localAppContentAction.kJ(), paramAppContentAction.kJ())) && (jv.equal(localAppContentAction.getType(), paramAppContentAction.getType())));
    return false;
  }
  
  static String b(AppContentAction paramAppContentAction)
  {
    return jv.h(paramAppContentAction).a("Conditions", paramAppContentAction.kH()).a("ContentDescription", paramAppContentAction.kI()).a("Extras", paramAppContentAction.getExtras()).a("Label", paramAppContentAction.getLabel()).a("LabelStyle", paramAppContentAction.kJ()).a("Type", paramAppContentAction.getType()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public String getLabel()
  {
    return this.XL;
  }
  
  public String getType()
  {
    return this.vc;
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
  
  public List<AppContentCondition> kH()
  {
    return new ArrayList(this.XJ);
  }
  
  public String kI()
  {
    return this.XK;
  }
  
  public String kJ()
  {
    return this.XM;
  }
  
  public AppContentAction kK()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppContentActionEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.appcontent.AppContentActionEntity
 * JD-Core Version:    0.7.0.1
 */