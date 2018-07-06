package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public final class Value
  implements SafeParcelable
{
  public static final Parcelable.Creator<Value> CREATOR = new u();
  private final int CK;
  private final int UE;
  private boolean US;
  private float UT;
  
  Value(int paramInt)
  {
    this(1, paramInt, false, 0.0F);
  }
  
  Value(int paramInt1, int paramInt2, boolean paramBoolean, float paramFloat)
  {
    this.CK = paramInt1;
    this.UE = paramInt2;
    this.US = paramBoolean;
    this.UT = paramFloat;
  }
  
  private boolean a(Value paramValue)
  {
    if ((this.UE == paramValue.UE) && (this.US == paramValue.US))
    {
      switch (this.UE)
      {
      default: 
        if (this.UT != paramValue.UT) {
          break;
        }
      case 1: 
      case 2: 
        do
        {
          do
          {
            return true;
          } while (asInt() == paramValue.asInt());
          return false;
        } while (asFloat() == paramValue.asFloat());
        return false;
      }
      return false;
    }
    return false;
  }
  
  public String asActivity()
  {
    try
    {
      String str = FitnessActivities.getName(asInt());
      return str;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
    return "unknown";
  }
  
  public float asFloat()
  {
    if (this.UE == 2) {}
    for (boolean bool = true;; bool = false)
    {
      jx.a(bool, "Value is not in float format");
      return this.UT;
    }
  }
  
  public int asInt()
  {
    int i = 1;
    if (this.UE == i) {}
    for (;;)
    {
      jx.a(i, "Value is not in int format");
      return Float.floatToRawIntBits(this.UT);
      int j = 0;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof Value)) && (a((Value)paramObject)));
  }
  
  public int getFormat()
  {
    return this.UE;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Float.valueOf(this.UT);
    arrayOfObject[1] = Integer.valueOf(this.UE);
    arrayOfObject[2] = Boolean.valueOf(this.US);
    return jv.hashCode(arrayOfObject);
  }
  
  public boolean isSet()
  {
    return this.US;
  }
  
  float jL()
  {
    return this.UT;
  }
  
  public void setActivity(String paramString)
  {
    setInt(FitnessActivities.bs(paramString));
  }
  
  public void setFloat(float paramFloat)
  {
    if (this.UE == 2) {}
    for (boolean bool = true;; bool = false)
    {
      jx.a(bool, "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
      this.US = true;
      this.UT = paramFloat;
      return;
    }
  }
  
  public void setInt(int paramInt)
  {
    if (this.UE == 1) {}
    for (boolean bool = true;; bool = false)
    {
      jx.a(bool, "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
      this.US = true;
      this.UT = Float.intBitsToFloat(paramInt);
      return;
    }
  }
  
  public String toString()
  {
    if (!this.US) {
      return "unset";
    }
    switch (this.UE)
    {
    default: 
      return "unknown";
    case 1: 
      return Integer.toString(asInt());
    }
    return Float.toString(asFloat());
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    u.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.data.Value
 * JD-Core Version:    0.7.0.1
 */