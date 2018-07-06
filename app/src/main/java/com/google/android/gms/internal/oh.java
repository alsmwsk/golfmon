package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Locale;

public class oh
  implements SafeParcelable
{
  public static final oi CREATOR = new oi();
  public static final oh akf = new oh("com.google.android.gms", Locale.ENGLISH, null);
  public final String akg;
  public final String akh;
  public final String aki;
  public final String akj;
  public final int versionCode;
  
  public oh(int paramInt, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    this.versionCode = paramInt;
    this.akg = paramString1;
    this.akh = paramString2;
    this.aki = paramString3;
    this.akj = paramString4;
  }
  
  public oh(String paramString1, Locale paramLocale, String paramString2)
  {
    this(1, paramString1, paramLocale.toString(), paramString2, null);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    oh localoh;
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof oh))) {
        return false;
      }
      localoh = (oh)paramObject;
    } while ((this.akh.equals(localoh.akh)) && (this.akg.equals(localoh.akg)) && (jv.equal(this.aki, localoh.aki)) && (jv.equal(this.akj, localoh.akj)));
    return false;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.akg;
    arrayOfObject[1] = this.akh;
    arrayOfObject[2] = this.aki;
    return jv.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return jv.h(this).a("clientPackageName", this.akg).a("locale", this.akh).a("accountName", this.aki).a("gCoreClientName", this.akj).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    oi.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.oh
 * JD-Core Version:    0.7.0.1
 */