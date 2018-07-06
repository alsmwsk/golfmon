package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.la;
import java.util.Collections;
import java.util.List;

public class StartBleScanRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<StartBleScanRequest> CREATOR = new ac();
  private final int CK;
  private final List<DataType> TY;
  private final l Wm;
  private final int Wn;
  
  StartBleScanRequest(int paramInt1, List<DataType> paramList, IBinder paramIBinder, int paramInt2)
  {
    this.CK = paramInt1;
    this.TY = paramList;
    this.Wm = l.a.aB(paramIBinder);
    this.Wn = paramInt2;
  }
  
  private StartBleScanRequest(Builder paramBuilder)
  {
    this.CK = 2;
    this.TY = la.b(Builder.a(paramBuilder));
    this.Wm = Builder.b(paramBuilder);
    this.Wn = Builder.c(paramBuilder);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public List<DataType> getDataTypes()
  {
    return Collections.unmodifiableList(this.TY);
  }
  
  public int getTimeoutSecs()
  {
    return this.Wn;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public IBinder km()
  {
    return this.Wm.asBinder();
  }
  
  public String toString()
  {
    return jv.h(this).a("dataTypes", this.TY).a("timeoutSecs", Integer.valueOf(this.Wn)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ac.a(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private DataType[] VU = new DataType[0];
    private l Wm;
    private int Wn = 10;
    
    public Builder a(l paraml)
    {
      this.Wm = paraml;
      return this;
    }
    
    public StartBleScanRequest build()
    {
      if (this.Wm != null) {}
      for (boolean bool = true;; bool = false)
      {
        jx.a(bool, "Must set BleScanCallback");
        return new StartBleScanRequest(this, null);
      }
    }
    
    public Builder setBleScanCallback(BleScanCallback paramBleScanCallback)
    {
      a(a.a.jP().a(paramBleScanCallback));
      return this;
    }
    
    public Builder setDataTypes(DataType... paramVarArgs)
    {
      this.VU = paramVarArgs;
      return this;
    }
    
    public Builder setTimeoutSecs(int paramInt)
    {
      boolean bool1 = true;
      boolean bool2;
      if (paramInt > 0)
      {
        bool2 = bool1;
        jx.b(bool2, "Stop time must be greater than zero");
        if (paramInt > 60) {
          break label38;
        }
      }
      for (;;)
      {
        jx.b(bool1, "Stop time must be less than 1 minute");
        this.Wn = paramInt;
        return this;
        bool2 = false;
        break;
        label38:
        bool1 = false;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.StartBleScanRequest
 * JD-Core Version:    0.7.0.1
 */