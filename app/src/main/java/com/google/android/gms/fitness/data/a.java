package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.mg;

public final class a
  implements SafeParcelable
{
  public static final Parcelable.Creator<a> CREATOR = new b();
  public static final a TT = new a("com.google.android.gms", String.valueOf(6587000), null);
  private final int CK;
  private final String CS;
  private final String TU;
  private final String TV;
  
  a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.CK = paramInt;
    this.CS = ((String)jx.i(paramString1));
    this.TU = "";
    this.TV = paramString3;
  }
  
  public a(String paramString1, String paramString2, String paramString3)
  {
    this(1, paramString1, "", paramString3);
  }
  
  private boolean a(a parama)
  {
    return (this.CS.equals(parama.CS)) && (jv.equal(this.TU, parama.TU)) && (jv.equal(this.TV, parama.TV));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof a)) && (a((a)paramObject)));
  }
  
  public String getPackageName()
  {
    return this.CS;
  }
  
  public String getVersion()
  {
    return this.TU;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.CS;
    arrayOfObject[1] = this.TU;
    arrayOfObject[2] = this.TV;
    return jv.hashCode(arrayOfObject);
  }
  
  public String jk()
  {
    return this.TV;
  }
  
  a jl()
  {
    return new a(mg.bw(this.CS), mg.bw(this.TU), mg.bw(this.TV));
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.CS;
    arrayOfObject[1] = this.TU;
    arrayOfObject[2] = this.TV;
    return String.format("Application{%s:%s:%s}", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.data.a
 * JD-Core Version:    0.7.0.1
 */