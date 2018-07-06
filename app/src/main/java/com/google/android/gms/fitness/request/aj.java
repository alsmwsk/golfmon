package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;

public class aj
  implements SafeParcelable
{
  public static final Parcelable.Creator<aj> CREATOR = new ak();
  private final int CK;
  private final DataType TM;
  private final DataSource TN;
  
  aj(int paramInt, DataType paramDataType, DataSource paramDataSource)
  {
    this.CK = paramInt;
    this.TM = paramDataType;
    this.TN = paramDataSource;
  }
  
  private aj(a parama)
  {
    this.CK = 1;
    this.TM = a.a(parama);
    this.TN = a.b(parama);
  }
  
  private boolean a(aj paramaj)
  {
    return (jv.equal(this.TN, paramaj.TN)) && (jv.equal(this.TM, paramaj.TM));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof aj)) && (a((aj)paramObject)));
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
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.TN;
    arrayOfObject[1] = this.TM;
    return jv.hashCode(arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ak.a(this, paramParcel, paramInt);
  }
  
  public static class a
  {
    private DataType TM;
    private DataSource TN;
    
    public a d(DataSource paramDataSource)
    {
      this.TN = paramDataSource;
      return this;
    }
    
    public a d(DataType paramDataType)
    {
      this.TM = paramDataType;
      return this;
    }
    
    public aj kq()
    {
      if ((this.TM != null) && (this.TN != null)) {
        throw new IllegalArgumentException("Cannot specify both dataType and dataSource");
      }
      return new aj(this, null);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.aj
 * JD-Core Version:    0.7.0.1
 */