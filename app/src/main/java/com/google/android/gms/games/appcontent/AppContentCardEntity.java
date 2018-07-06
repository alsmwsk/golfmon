package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardEntity
  implements SafeParcelable, AppContentCard
{
  public static final AppContentCardEntityCreator CREATOR = new AppContentCardEntityCreator();
  private final int CK;
  private final String OH;
  private final String UO;
  private final Uri WD;
  private final ArrayList<AppContentConditionEntity> XJ;
  private final String XK;
  private final Uri XN;
  private final ArrayList<AppContentAnnotationEntity> XO;
  private final int XP;
  private final Bundle XQ;
  private final String XR;
  private final int XS;
  private final ArrayList<AppContentActionEntity> mActions;
  private final String vc;
  
  AppContentCardEntity(int paramInt1, ArrayList<AppContentActionEntity> paramArrayList, ArrayList<AppContentAnnotationEntity> paramArrayList1, ArrayList<AppContentConditionEntity> paramArrayList2, String paramString1, int paramInt2, String paramString2, Bundle paramBundle, Uri paramUri1, Uri paramUri2, String paramString3, String paramString4, int paramInt3, String paramString5)
  {
    this.CK = paramInt1;
    this.mActions = paramArrayList;
    this.XO = paramArrayList1;
    this.XJ = paramArrayList2;
    this.XK = paramString1;
    this.XP = paramInt2;
    this.UO = paramString2;
    this.XQ = paramBundle;
    this.WD = paramUri1;
    this.XN = paramUri2;
    this.XR = paramString3;
    this.OH = paramString4;
    this.XS = paramInt3;
    this.vc = paramString5;
  }
  
  public AppContentCardEntity(AppContentCard paramAppContentCard)
  {
    this.CK = 1;
    this.XK = paramAppContentCard.kI();
    this.XP = paramAppContentCard.kO();
    this.UO = paramAppContentCard.getDescription();
    this.XQ = paramAppContentCard.kP();
    this.WD = paramAppContentCard.getIconImageUri();
    this.XN = paramAppContentCard.kL();
    this.OH = paramAppContentCard.getTitle();
    this.XR = paramAppContentCard.kQ();
    this.XS = paramAppContentCard.kR();
    this.vc = paramAppContentCard.getType();
    List localList1 = paramAppContentCard.getActions();
    int j = localList1.size();
    this.mActions = new ArrayList(j);
    for (int k = 0; k < j; k++) {
      this.mActions.add((AppContentActionEntity)((AppContentAction)localList1.get(k)).freeze());
    }
    List localList2 = paramAppContentCard.kN();
    int m = localList2.size();
    this.XO = new ArrayList(m);
    for (int n = 0; n < m; n++) {
      this.XO.add((AppContentAnnotationEntity)((AppContentAnnotation)localList2.get(n)).freeze());
    }
    List localList3 = paramAppContentCard.kH();
    int i1 = localList3.size();
    this.XJ = new ArrayList(i1);
    while (i < i1)
    {
      this.XJ.add((AppContentConditionEntity)((AppContentCondition)localList3.get(i)).freeze());
      i++;
    }
  }
  
  static int a(AppContentCard paramAppContentCard)
  {
    Object[] arrayOfObject = new Object[13];
    arrayOfObject[0] = paramAppContentCard.getActions();
    arrayOfObject[1] = paramAppContentCard.kN();
    arrayOfObject[2] = paramAppContentCard.kH();
    arrayOfObject[3] = paramAppContentCard.kI();
    arrayOfObject[4] = Integer.valueOf(paramAppContentCard.kO());
    arrayOfObject[5] = paramAppContentCard.getDescription();
    arrayOfObject[6] = paramAppContentCard.kP();
    arrayOfObject[7] = paramAppContentCard.getIconImageUri();
    arrayOfObject[8] = paramAppContentCard.kL();
    arrayOfObject[9] = paramAppContentCard.kQ();
    arrayOfObject[10] = paramAppContentCard.getTitle();
    arrayOfObject[11] = Integer.valueOf(paramAppContentCard.kR());
    arrayOfObject[12] = paramAppContentCard.getType();
    return jv.hashCode(arrayOfObject);
  }
  
  static boolean a(AppContentCard paramAppContentCard, Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof AppContentCard)) {
      bool = false;
    }
    AppContentCard localAppContentCard;
    do
    {
      do
      {
        return bool;
      } while (paramAppContentCard == paramObject);
      localAppContentCard = (AppContentCard)paramObject;
    } while ((jv.equal(localAppContentCard.getActions(), paramAppContentCard.getActions())) && (jv.equal(localAppContentCard.kN(), paramAppContentCard.kN())) && (jv.equal(localAppContentCard.kH(), paramAppContentCard.kH())) && (jv.equal(localAppContentCard.kI(), paramAppContentCard.kI())) && (jv.equal(Integer.valueOf(localAppContentCard.kO()), Integer.valueOf(paramAppContentCard.kO()))) && (jv.equal(localAppContentCard.getDescription(), paramAppContentCard.getDescription())) && (jv.equal(localAppContentCard.kP(), paramAppContentCard.kP())) && (jv.equal(localAppContentCard.getIconImageUri(), paramAppContentCard.getIconImageUri())) && (jv.equal(localAppContentCard.kL(), paramAppContentCard.kL())) && (jv.equal(localAppContentCard.kQ(), paramAppContentCard.kQ())) && (jv.equal(localAppContentCard.getTitle(), paramAppContentCard.getTitle())) && (jv.equal(Integer.valueOf(localAppContentCard.kR()), Integer.valueOf(paramAppContentCard.kR()))) && (jv.equal(localAppContentCard.getType(), paramAppContentCard.getType())));
    return false;
  }
  
  static String b(AppContentCard paramAppContentCard)
  {
    return jv.h(paramAppContentCard).a("Actions", paramAppContentCard.getActions()).a("Annotations", paramAppContentCard.kN()).a("Conditions", paramAppContentCard.kH()).a("ContentDescription", paramAppContentCard.kI()).a("CurrentSteps", Integer.valueOf(paramAppContentCard.kO())).a("Description", paramAppContentCard.getDescription()).a("ExtraData", paramAppContentCard.kP()).a("IconImageUri", paramAppContentCard.getIconImageUri()).a("ImageUri", paramAppContentCard.kL()).a("Subtitle", paramAppContentCard.kQ()).a("Title", paramAppContentCard.getTitle()).a("TotalSteps", Integer.valueOf(paramAppContentCard.kR())).a("Type", paramAppContentCard.getType()).toString();
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
  
  public String getDescription()
  {
    return this.UO;
  }
  
  public Uri getIconImageUri()
  {
    return this.WD;
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
  
  public List<AppContentCondition> kH()
  {
    return new ArrayList(this.XJ);
  }
  
  public String kI()
  {
    return this.XK;
  }
  
  public Uri kL()
  {
    return this.XN;
  }
  
  public List<AppContentAnnotation> kN()
  {
    return new ArrayList(this.XO);
  }
  
  public int kO()
  {
    return this.XP;
  }
  
  public Bundle kP()
  {
    return this.XQ;
  }
  
  public String kQ()
  {
    return this.XR;
  }
  
  public int kR()
  {
    return this.XS;
  }
  
  public AppContentCard kS()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppContentCardEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.appcontent.AppContentCardEntity
 * JD-Core Version:    0.7.0.1
 */