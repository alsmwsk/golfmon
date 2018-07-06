package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import java.util.ArrayList;
import java.util.List;

public final class AppContentSectionEntity
  implements SafeParcelable, AppContentSection
{
  public static final AppContentSectionEntityCreator CREATOR = new AppContentSectionEntityCreator();
  private final int CK;
  private final String OH;
  private final String XK;
  private final Bundle XQ;
  private final String XR;
  private final Uri XY;
  private final ArrayList<AppContentCardEntity> XZ;
  private final ArrayList<AppContentActionEntity> mActions;
  private final String vc;
  
  AppContentSectionEntity(int paramInt, ArrayList<AppContentActionEntity> paramArrayList, Uri paramUri, ArrayList<AppContentCardEntity> paramArrayList1, String paramString1, Bundle paramBundle, String paramString2, String paramString3, String paramString4)
  {
    this.CK = paramInt;
    this.mActions = paramArrayList;
    this.XY = paramUri;
    this.XZ = paramArrayList1;
    this.XK = paramString1;
    this.XQ = paramBundle;
    this.XR = paramString2;
    this.OH = paramString3;
    this.vc = paramString4;
  }
  
  public AppContentSectionEntity(AppContentSection paramAppContentSection)
  {
    this.CK = 1;
    this.XY = paramAppContentSection.kY();
    this.XK = paramAppContentSection.kI();
    this.XQ = paramAppContentSection.kP();
    this.XR = paramAppContentSection.kQ();
    this.OH = paramAppContentSection.getTitle();
    this.vc = paramAppContentSection.getType();
    List localList1 = paramAppContentSection.getActions();
    int j = localList1.size();
    this.mActions = new ArrayList(j);
    for (int k = 0; k < j; k++) {
      this.mActions.add((AppContentActionEntity)((AppContentAction)localList1.get(k)).freeze());
    }
    List localList2 = paramAppContentSection.kZ();
    int m = localList2.size();
    this.XZ = new ArrayList(m);
    while (i < m)
    {
      this.XZ.add((AppContentCardEntity)((AppContentCard)localList2.get(i)).freeze());
      i++;
    }
  }
  
  static int a(AppContentSection paramAppContentSection)
  {
    Object[] arrayOfObject = new Object[8];
    arrayOfObject[0] = paramAppContentSection.getActions();
    arrayOfObject[1] = paramAppContentSection.kY();
    arrayOfObject[2] = paramAppContentSection.kZ();
    arrayOfObject[3] = paramAppContentSection.kI();
    arrayOfObject[4] = paramAppContentSection.kP();
    arrayOfObject[5] = paramAppContentSection.kQ();
    arrayOfObject[6] = paramAppContentSection.getTitle();
    arrayOfObject[7] = paramAppContentSection.getType();
    return jv.hashCode(arrayOfObject);
  }
  
  static boolean a(AppContentSection paramAppContentSection, Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof AppContentSection)) {
      bool = false;
    }
    AppContentSection localAppContentSection;
    do
    {
      do
      {
        return bool;
      } while (paramAppContentSection == paramObject);
      localAppContentSection = (AppContentSection)paramObject;
    } while ((jv.equal(localAppContentSection.getActions(), paramAppContentSection.getActions())) && (jv.equal(localAppContentSection.kY(), paramAppContentSection.kY())) && (jv.equal(localAppContentSection.kZ(), paramAppContentSection.kZ())) && (jv.equal(localAppContentSection.kI(), paramAppContentSection.kI())) && (jv.equal(localAppContentSection.kP(), paramAppContentSection.kP())) && (jv.equal(localAppContentSection.kQ(), paramAppContentSection.kQ())) && (jv.equal(localAppContentSection.getTitle(), paramAppContentSection.getTitle())) && (jv.equal(localAppContentSection.getType(), paramAppContentSection.getType())));
    return false;
  }
  
  static String b(AppContentSection paramAppContentSection)
  {
    return jv.h(paramAppContentSection).a("Actions", paramAppContentSection.getActions()).a("BackgroundImageUri", paramAppContentSection.kY()).a("Cards", paramAppContentSection.kZ()).a("ContentDescription", paramAppContentSection.kI()).a("ExtraData", paramAppContentSection.kP()).a("Subtitle", paramAppContentSection.kQ()).a("Title", paramAppContentSection.getTitle()).a("Type", paramAppContentSection.getType()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public List<AppContentAction> getActions()
  {
    return new ArrayList(this.mActions);
  }
  
  public String getTitle()
  {
    return this.OH;
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
  
  public String kI()
  {
    return this.XK;
  }
  
  public Bundle kP()
  {
    return this.XQ;
  }
  
  public String kQ()
  {
    return this.XR;
  }
  
  public Uri kY()
  {
    return this.XY;
  }
  
  public List<AppContentCard> kZ()
  {
    return new ArrayList(this.XZ);
  }
  
  public AppContentSection la()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppContentSectionEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.appcontent.AppContentSectionEntity
 * JD-Core Version:    0.7.0.1
 */