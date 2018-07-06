package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionReadRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SessionReadRequest> CREATOR = new t();
  private final int CK;
  private final long LW;
  private final long TO;
  private final List<DataType> TY;
  private final List<DataSource> VH;
  private final boolean VR;
  private final String Wj;
  private boolean Wk;
  private final List<String> Wl;
  private final String vZ;
  
  SessionReadRequest(int paramInt, String paramString1, String paramString2, long paramLong1, long paramLong2, List<DataType> paramList, List<DataSource> paramList1, boolean paramBoolean1, boolean paramBoolean2, List<String> paramList2)
  {
    this.CK = paramInt;
    this.Wj = paramString1;
    this.vZ = paramString2;
    this.LW = paramLong1;
    this.TO = paramLong2;
    this.TY = Collections.unmodifiableList(paramList);
    this.VH = Collections.unmodifiableList(paramList1);
    this.Wk = paramBoolean1;
    this.VR = paramBoolean2;
    this.Wl = paramList2;
  }
  
  private SessionReadRequest(Builder paramBuilder)
  {
    this.CK = 3;
    this.Wj = Builder.a(paramBuilder);
    this.vZ = Builder.b(paramBuilder);
    this.LW = Builder.c(paramBuilder);
    this.TO = Builder.d(paramBuilder);
    this.TY = Collections.unmodifiableList(Builder.e(paramBuilder));
    this.VH = Collections.unmodifiableList(Builder.f(paramBuilder));
    this.Wk = Builder.g(paramBuilder);
    this.VR = Builder.h(paramBuilder);
    this.Wl = Collections.unmodifiableList(Builder.i(paramBuilder));
  }
  
  private boolean a(SessionReadRequest paramSessionReadRequest)
  {
    return (jv.equal(this.Wj, paramSessionReadRequest.Wj)) && (this.vZ.equals(paramSessionReadRequest.vZ)) && (this.LW == paramSessionReadRequest.LW) && (this.TO == paramSessionReadRequest.TO) && (jv.equal(this.TY, paramSessionReadRequest.TY)) && (jv.equal(this.VH, paramSessionReadRequest.VH)) && (this.Wk == paramSessionReadRequest.Wk) && (this.Wl.equals(paramSessionReadRequest.Wl)) && (this.VR == paramSessionReadRequest.VR);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof SessionReadRequest)) && (a((SessionReadRequest)paramObject)));
  }
  
  public List<DataSource> getDataSources()
  {
    return this.VH;
  }
  
  public List<DataType> getDataTypes()
  {
    return this.TY;
  }
  
  public long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.TO, TimeUnit.MILLISECONDS);
  }
  
  public List<String> getExcludedPackages()
  {
    return this.Wl;
  }
  
  public String getSessionId()
  {
    return this.vZ;
  }
  
  public String getSessionName()
  {
    return this.Wj;
  }
  
  public long getStartTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.LW, TimeUnit.MILLISECONDS);
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = this.Wj;
    arrayOfObject[1] = this.vZ;
    arrayOfObject[2] = Long.valueOf(this.LW);
    arrayOfObject[3] = Long.valueOf(this.TO);
    return jv.hashCode(arrayOfObject);
  }
  
  public boolean includeSessionsFromAllApps()
  {
    return this.Wk;
  }
  
  public boolean jV()
  {
    return this.VR;
  }
  
  public long jo()
  {
    return this.LW;
  }
  
  public long jp()
  {
    return this.TO;
  }
  
  public boolean kj()
  {
    return this.Wk;
  }
  
  public String toString()
  {
    return jv.h(this).a("sessionName", this.Wj).a("sessionId", this.vZ).a("startTimeMillis", Long.valueOf(this.LW)).a("endTimeMillis", Long.valueOf(this.TO)).a("dataTypes", this.TY).a("dataSources", this.VH).a("sessionsFromAllApps", Boolean.valueOf(this.Wk)).a("excludedPackages", this.Wl).a("useServer", Boolean.valueOf(this.VR)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    t.a(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private long LW = 0L;
    private long TO = 0L;
    private List<DataType> TY = new ArrayList();
    private List<DataSource> VH = new ArrayList();
    private boolean VR = false;
    private String Wj;
    private boolean Wk = false;
    private List<String> Wl = new ArrayList();
    private String vZ;
    
    public SessionReadRequest build()
    {
      boolean bool1;
      if (this.LW > 0L)
      {
        bool1 = true;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Long.valueOf(this.LW);
        jx.b(bool1, "Invalid start time: %s", arrayOfObject1);
        if ((this.TO <= 0L) || (this.TO <= this.LW)) {
          break label96;
        }
      }
      label96:
      for (boolean bool2 = true;; bool2 = false)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Long.valueOf(this.TO);
        jx.b(bool2, "Invalid end time: %s", arrayOfObject2);
        return new SessionReadRequest(this, null);
        bool1 = false;
        break;
      }
    }
    
    public Builder enableServerQueries()
    {
      this.VR = true;
      return this;
    }
    
    public Builder excludePackage(String paramString)
    {
      jx.b(paramString, "Attempting to use a null package name");
      if (!this.Wl.contains(paramString)) {
        this.Wl.add(paramString);
      }
      return this;
    }
    
    public Builder read(DataSource paramDataSource)
    {
      jx.b(paramDataSource, "Attempting to add a null data source");
      if (!this.VH.contains(paramDataSource)) {
        this.VH.add(paramDataSource);
      }
      return this;
    }
    
    public Builder read(DataType paramDataType)
    {
      jx.b(paramDataType, "Attempting to use a null data type");
      if (!this.TY.contains(paramDataType)) {
        this.TY.add(paramDataType);
      }
      return this;
    }
    
    public Builder readSessionsFromAllApps()
    {
      this.Wk = true;
      return this;
    }
    
    public Builder setSessionId(String paramString)
    {
      this.vZ = paramString;
      return this;
    }
    
    public Builder setSessionName(String paramString)
    {
      this.Wj = paramString;
      return this;
    }
    
    public Builder setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      this.LW = paramTimeUnit.toMillis(paramLong1);
      this.TO = paramTimeUnit.toMillis(paramLong2);
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.SessionReadRequest
 * JD-Core Version:    0.7.0.1
 */