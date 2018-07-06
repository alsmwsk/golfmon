package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.la;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DataSourcesRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataSourcesRequest> CREATOR = new h();
  private final int CK;
  private final List<DataType> TY;
  private final List<Integer> VS;
  private final boolean VT;
  
  DataSourcesRequest(int paramInt, List<DataType> paramList, List<Integer> paramList1, boolean paramBoolean)
  {
    this.CK = paramInt;
    this.TY = paramList;
    this.VS = paramList1;
    this.VT = paramBoolean;
  }
  
  private DataSourcesRequest(Builder paramBuilder)
  {
    this.CK = 2;
    this.TY = la.b(Builder.a(paramBuilder));
    this.VS = Arrays.asList(la.a(Builder.b(paramBuilder)));
    this.VT = Builder.c(paramBuilder);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<DataType> getDataTypes()
  {
    return Collections.unmodifiableList(this.TY);
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public boolean jY()
  {
    return this.VT;
  }
  
  List<Integer> jZ()
  {
    return this.VS;
  }
  
  public String toString()
  {
    jv.a locala = jv.h(this).a("dataTypes", this.TY).a("sourceTypes", this.VS);
    if (this.VT) {
      locala.a("includeDbOnlySources", "true");
    }
    return locala.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private boolean VT = false;
    private DataType[] VU = new DataType[0];
    private int[] VV = { 0, 1 };
    
    public DataSourcesRequest build()
    {
      boolean bool1 = true;
      boolean bool2;
      if (this.VU.length > 0)
      {
        bool2 = bool1;
        jx.a(bool2, "Must add at least one data type");
        if (this.VV.length <= 0) {
          break label47;
        }
      }
      for (;;)
      {
        jx.a(bool1, "Must add at least one data source type");
        return new DataSourcesRequest(this, null);
        bool2 = false;
        break;
        label47:
        bool1 = false;
      }
    }
    
    public Builder setDataSourceTypes(int... paramVarArgs)
    {
      this.VV = paramVarArgs;
      return this;
    }
    
    public Builder setDataTypes(DataType... paramVarArgs)
    {
      this.VU = paramVarArgs;
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.DataSourcesRequest
 * JD-Core Version:    0.7.0.1
 */