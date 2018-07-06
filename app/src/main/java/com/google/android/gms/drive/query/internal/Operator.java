package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class Operator
  implements SafeParcelable
{
  public static final Parcelable.Creator<Operator> CREATOR = new l();
  public static final Operator SA = new Operator(">=");
  public static final Operator SB = new Operator("and");
  public static final Operator SC = new Operator("or");
  public static final Operator SD = new Operator("not");
  public static final Operator SE = new Operator("contains");
  public static final Operator Sw = new Operator("=");
  public static final Operator Sx = new Operator("<");
  public static final Operator Sy = new Operator("<=");
  public static final Operator Sz = new Operator(">");
  final int CK;
  final String mTag;
  
  Operator(int paramInt, String paramString)
  {
    this.CK = paramInt;
    this.mTag = paramString;
  }
  
  private Operator(String paramString)
  {
    this(1, paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    Operator localOperator;
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        localOperator = (Operator)paramObject;
        if (this.mTag != null) {
          break;
        }
      } while (localOperator.mTag == null);
      return false;
    } while (this.mTag.equals(localOperator.mTag));
    return false;
  }
  
  public String getTag()
  {
    return this.mTag;
  }
  
  public int hashCode()
  {
    if (this.mTag == null) {}
    for (int i = 0;; i = this.mTag.hashCode()) {
      return i + 31;
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    l.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.Operator
 * JD-Core Version:    0.7.0.1
 */