package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jx;

public final class Field
  implements SafeParcelable
{
  public static final Parcelable.Creator<Field> CREATOR = new j();
  public static final Field FIELD_ACCURACY;
  public static final Field FIELD_ACTIVITY = bu("activity");
  public static final Field FIELD_ALTITUDE;
  public static final Field FIELD_AVERAGE;
  public static final Field FIELD_BPM;
  public static final Field FIELD_CALORIES;
  public static final Field FIELD_CONFIDENCE = bv("confidence");
  public static final Field FIELD_DISTANCE;
  public static final Field FIELD_DURATION;
  public static final Field FIELD_HEIGHT;
  public static final Field FIELD_HIGH_LATITUDE;
  public static final Field FIELD_HIGH_LONGITUDE;
  public static final Field FIELD_LATITUDE;
  public static final Field FIELD_LONGITUDE;
  public static final Field FIELD_LOW_LATITUDE;
  public static final Field FIELD_LOW_LONGITUDE;
  public static final Field FIELD_MAX;
  public static final Field FIELD_MIN;
  public static final Field FIELD_NUM_SEGMENTS;
  public static final Field FIELD_REVOLUTIONS;
  public static final Field FIELD_RPM;
  public static final Field FIELD_SPEED;
  public static final Field FIELD_STEPS = bu("steps");
  public static final Field FIELD_WATTS;
  public static final Field FIELD_WEIGHT;
  public static final int FORMAT_FLOAT = 2;
  public static final int FORMAT_INT32 = 1;
  public static final Field UA;
  public static final Field UB;
  public static final Field UC;
  public static final Field UD;
  private final int CK;
  private final int UE;
  private final String mName;
  
  static
  {
    FIELD_DURATION = bu("duration");
    FIELD_BPM = bv("bpm");
    FIELD_LATITUDE = bv("latitude");
    FIELD_LONGITUDE = bv("longitude");
    FIELD_ACCURACY = bv("accuracy");
    FIELD_ALTITUDE = bv("altitude");
    FIELD_DISTANCE = bv("distance");
    FIELD_HEIGHT = bv("height");
    FIELD_WEIGHT = bv("weight");
    FIELD_SPEED = bv("speed");
    FIELD_RPM = bv("rpm");
    FIELD_REVOLUTIONS = bu("revolutions");
    FIELD_CALORIES = bv("calories");
    FIELD_WATTS = bv("watts");
    FIELD_NUM_SEGMENTS = bu("num_segments");
    FIELD_AVERAGE = bv("average");
    FIELD_MAX = bv("max");
    FIELD_MIN = bv("min");
    FIELD_LOW_LATITUDE = bv("low_latitude");
    FIELD_LOW_LONGITUDE = bv("low_longitude");
    FIELD_HIGH_LATITUDE = bv("high_latitude");
    FIELD_HIGH_LONGITUDE = bv("high_longitude");
    UA = bu("edge_type");
    UB = bv("x");
    UC = bv("y");
    UD = bv("z");
  }
  
  Field(int paramInt1, String paramString, int paramInt2)
  {
    this.CK = paramInt1;
    this.mName = ((String)jx.i(paramString));
    this.UE = paramInt2;
  }
  
  public Field(String paramString, int paramInt)
  {
    this(1, paramString, paramInt);
  }
  
  private boolean a(Field paramField)
  {
    return (this.mName.equals(paramField.mName)) && (this.UE == paramField.UE);
  }
  
  private static Field bu(String paramString)
  {
    return new Field(paramString, 1);
  }
  
  private static Field bv(String paramString)
  {
    return new Field(paramString, 2);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof Field)) && (a((Field)paramObject)));
  }
  
  public int getFormat()
  {
    return this.UE;
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
    return this.mName.hashCode();
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.mName;
    if (this.UE == 1) {}
    for (String str = "i";; str = "f")
    {
      arrayOfObject[1] = str;
      return String.format("%s(%s)", arrayOfObject);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    j.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.data.Field
 * JD-Core Version:    0.7.0.1
 */