package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.jx;

public class Subscription
  implements SafeParcelable
{
  public static final Parcelable.Creator<Subscription> CREATOR = new s();
  private final int CK;
  private final DataType TM;
  private final DataSource TN;
  private final long UQ;
  private final int UR;
  
  Subscription(int paramInt1, DataSource paramDataSource, DataType paramDataType, long paramLong, int paramInt2)
  {
    this.CK = paramInt1;
    this.TN = paramDataSource;
    this.TM = paramDataType;
    this.UQ = paramLong;
    this.UR = paramInt2;
  }
  
  private Subscription(a parama)
  {
    this.CK = 1;
    this.TM = a.a(parama);
    this.TN = a.b(parama);
    this.UQ = a.c(parama);
    this.UR = a.d(parama);
  }
  
  private boolean a(Subscription paramSubscription)
  {
    return (jv.equal(this.TN, paramSubscription.TN)) && (jv.equal(this.TM, paramSubscription.TM)) && (this.UQ == paramSubscription.UQ) && (this.UR == paramSubscription.UR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof Subscription)) && (a((Subscription)paramObject)));
  }
  
  public int getAccuracyMode()
  {
    return this.UR;
  }
  
  public DataSource getDataSource()
  {
    return this.TN;
  }
  
  public DataType getDataType()
  {
    return this.TM;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = this.TN;
    arrayOfObject[1] = this.TN;
    arrayOfObject[2] = Long.valueOf(this.UQ);
    arrayOfObject[3] = Integer.valueOf(this.UR);
    return jv.hashCode(arrayOfObject);
  }
  
  public long jI()
  {
    return this.UQ;
  }
  
  public DataType jJ()
  {
    if (this.TM == null) {
      return this.TN.getDataType();
    }
    return this.TM;
  }
  
  public String toDebugString()
  {
    Object[] arrayOfObject = new Object[1];
    if (this.TN == null) {}
    for (String str = this.TM.getName();; str = this.TN.toDebugString())
    {
      arrayOfObject[0] = str;
      return String.format("Subscription{%s}", arrayOfObject);
    }
  }
  
  public String toString()
  {
    return jv.h(this).a("dataSource", this.TN).a("dataType", this.TM).a("samplingIntervalMicros", Long.valueOf(this.UQ)).a("accuracyMode", Integer.valueOf(this.UR)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    s.a(this, paramParcel, paramInt);
  }
  
  public static class a
  {
    private DataType TM;
    private DataSource TN;
    private long UQ = -1L;
    private int UR = 2;
    
    public a b(DataSource paramDataSource)
    {
      this.TN = paramDataSource;
      return this;
    }
    
    public a b(DataType paramDataType)
    {
      this.TM = paramDataType;
      return this;
    }
    
    public Subscription jK()
    {
      if ((this.TN != null) || (this.TM != null)) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        jx.a(bool1, "Must call setDataSource() or setDataType()");
        boolean bool2;
        if ((this.TM != null) && (this.TN != null))
        {
          boolean bool3 = this.TM.equals(this.TN.getDataType());
          bool2 = false;
          if (!bool3) {}
        }
        else
        {
          bool2 = true;
        }
        jx.a(bool2, "Specified data type is incompatible with specified data source");
        return new Subscription(this, null);
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.data.Subscription
 * JD-Core Version:    0.7.0.1
 */