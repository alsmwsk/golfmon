package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;

public class y
  implements SafeParcelable
{
  public static final Parcelable.Creator<y> CREATOR = new z();
  private final int CK;
  private final String UN;
  private final String mName;
  
  y(int paramInt, String paramString1, String paramString2)
  {
    this.CK = paramInt;
    this.mName = paramString1;
    this.UN = paramString2;
  }
  
  private y(a parama)
  {
    this.CK = 1;
    this.mName = a.a(parama);
    this.UN = a.b(parama);
  }
  
  private boolean a(y paramy)
  {
    return (jv.equal(this.mName, paramy.mName)) && (jv.equal(this.UN, paramy.UN));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof y)) && (a((y)paramObject)));
  }
  
  public String getIdentifier()
  {
    return this.UN;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.mName;
    arrayOfObject[1] = this.UN;
    return jv.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return jv.h(this).a("name", this.mName).a("identifier", this.UN).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    z.a(this, paramParcel, paramInt);
  }
  
  public static class a
  {
    private String UN;
    private String mName;
    
    public a bx(String paramString)
    {
      this.mName = paramString;
      return this;
    }
    
    public a by(String paramString)
    {
      this.UN = paramString;
      return this;
    }
    
    public y kl()
    {
      return new y(this, null);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.y
 * JD-Core Version:    0.7.0.1
 */