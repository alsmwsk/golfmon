package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;

public final class AppContentAnnotationEntity
  implements SafeParcelable, AppContentAnnotation
{
  public static final AppContentAnnotationEntityCreator CREATOR = new AppContentAnnotationEntityCreator();
  private final int CK;
  private final String OH;
  private final String UO;
  private final Uri XN;
  private final String vc;
  
  AppContentAnnotationEntity(int paramInt, String paramString1, Uri paramUri, String paramString2, String paramString3)
  {
    this.CK = paramInt;
    this.UO = paramString1;
    this.XN = paramUri;
    this.OH = paramString2;
    this.vc = paramString3;
  }
  
  public AppContentAnnotationEntity(AppContentAnnotation paramAppContentAnnotation)
  {
    this.CK = 1;
    this.UO = paramAppContentAnnotation.getDescription();
    this.XN = paramAppContentAnnotation.kL();
    this.OH = paramAppContentAnnotation.getTitle();
    this.vc = paramAppContentAnnotation.getType();
  }
  
  static int a(AppContentAnnotation paramAppContentAnnotation)
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = paramAppContentAnnotation.getDescription();
    arrayOfObject[1] = paramAppContentAnnotation.kL();
    arrayOfObject[2] = paramAppContentAnnotation.getTitle();
    arrayOfObject[3] = paramAppContentAnnotation.getType();
    return jv.hashCode(arrayOfObject);
  }
  
  static boolean a(AppContentAnnotation paramAppContentAnnotation, Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof AppContentAnnotation)) {
      bool = false;
    }
    AppContentAnnotation localAppContentAnnotation;
    do
    {
      do
      {
        return bool;
      } while (paramAppContentAnnotation == paramObject);
      localAppContentAnnotation = (AppContentAnnotation)paramObject;
    } while ((jv.equal(localAppContentAnnotation.getDescription(), paramAppContentAnnotation.getDescription())) && (jv.equal(localAppContentAnnotation.kL(), paramAppContentAnnotation.kL())) && (jv.equal(localAppContentAnnotation.getTitle(), paramAppContentAnnotation.getTitle())) && (jv.equal(localAppContentAnnotation.getType(), paramAppContentAnnotation.getType())));
    return false;
  }
  
  static String b(AppContentAnnotation paramAppContentAnnotation)
  {
    return jv.h(paramAppContentAnnotation).a("Description", paramAppContentAnnotation.getDescription()).a("ImageUri", paramAppContentAnnotation.kL()).a("Title", paramAppContentAnnotation.getTitle()).a("Type", paramAppContentAnnotation.getType()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public String getDescription()
  {
    return this.UO;
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
  
  public Uri kL()
  {
    return this.XN;
  }
  
  public AppContentAnnotation kM()
  {
    return this;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppContentAnnotationEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.appcontent.AppContentAnnotationEntity
 * JD-Core Version:    0.7.0.1
 */