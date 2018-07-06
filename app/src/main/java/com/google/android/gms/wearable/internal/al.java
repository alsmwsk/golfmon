package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.Node;

public class al
  implements SafeParcelable, Node
{
  public static final Parcelable.Creator<al> CREATOR = new am();
  private final String CE;
  final int CK;
  private final String OS;
  
  al(int paramInt, String paramString1, String paramString2)
  {
    this.CK = paramInt;
    this.CE = paramString1;
    this.OS = paramString2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof al)) {}
    al localal;
    do
    {
      return false;
      localal = (al)paramObject;
    } while ((!localal.CE.equals(this.CE)) || (!localal.OS.equals(this.OS)));
    return true;
  }
  
  public String getDisplayName()
  {
    return this.OS;
  }
  
  public String getId()
  {
    return this.CE;
  }
  
  public int hashCode()
  {
    return 37 * (629 + this.CE.hashCode()) + this.OS.hashCode();
  }
  
  public String toString()
  {
    return "NodeParcelable{" + this.CE + "," + this.OS + "}";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    am.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.al
 * JD-Core Version:    0.7.0.1
 */