package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DataDeleteRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<DataDeleteRequest> CREATOR = new d();
  private final int CK;
  private final long LW;
  private final long TO;
  private final List<DataType> TY;
  private final List<DataSource> VH;
  private final List<Session> VI;
  private final boolean VJ;
  private final boolean VK;
  
  DataDeleteRequest(int paramInt, long paramLong1, long paramLong2, List<DataSource> paramList, List<DataType> paramList1, List<Session> paramList2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.CK = paramInt;
    this.LW = paramLong1;
    this.TO = paramLong2;
    this.VH = Collections.unmodifiableList(paramList);
    this.TY = Collections.unmodifiableList(paramList1);
    this.VI = paramList2;
    this.VJ = paramBoolean1;
    this.VK = paramBoolean2;
  }
  
  private DataDeleteRequest(Builder paramBuilder)
  {
    this.CK = 1;
    this.LW = Builder.a(paramBuilder);
    this.TO = Builder.b(paramBuilder);
    this.VH = Collections.unmodifiableList(Builder.c(paramBuilder));
    this.TY = Collections.unmodifiableList(Builder.d(paramBuilder));
    this.VI = Collections.unmodifiableList(Builder.e(paramBuilder));
    this.VJ = Builder.f(paramBuilder);
    this.VK = Builder.g(paramBuilder);
  }
  
  private boolean a(DataDeleteRequest paramDataDeleteRequest)
  {
    return (this.LW == paramDataDeleteRequest.LW) && (this.TO == paramDataDeleteRequest.TO) && (jv.equal(this.VH, paramDataDeleteRequest.VH)) && (jv.equal(this.TY, paramDataDeleteRequest.TY)) && (jv.equal(this.VI, paramDataDeleteRequest.VI)) && (this.VJ == paramDataDeleteRequest.VJ) && (this.VK == paramDataDeleteRequest.VK);
  }
  
  public boolean deleteAllData()
  {
    return this.VJ;
  }
  
  public boolean deleteAllSessions()
  {
    return this.VK;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof DataDeleteRequest)) && (a((DataDeleteRequest)paramObject)));
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
  
  public List<Session> getSessions()
  {
    return this.VI;
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
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Long.valueOf(this.LW);
    arrayOfObject[1] = Long.valueOf(this.TO);
    return jv.hashCode(arrayOfObject);
  }
  
  public boolean jR()
  {
    return this.VJ;
  }
  
  public boolean jS()
  {
    return this.VK;
  }
  
  public long jo()
  {
    return this.LW;
  }
  
  public long jp()
  {
    return this.TO;
  }
  
  public String toString()
  {
    return jv.h(this).a("startTimeMillis", Long.valueOf(this.LW)).a("endTimeMillis", Long.valueOf(this.TO)).a("dataSources", this.VH).a("dateTypes", this.TY).a("sessions", this.VI).a("deleteAllData", Boolean.valueOf(this.VJ)).a("deleteAllSessions", Boolean.valueOf(this.VK)).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private long LW;
    private long TO;
    private List<DataType> TY = new ArrayList();
    private List<DataSource> VH = new ArrayList();
    private List<Session> VI = new ArrayList();
    private boolean VJ = false;
    private boolean VK = false;
    
    private void jT()
    {
      if (this.VI.isEmpty()) {
        return;
      }
      Iterator localIterator = this.VI.iterator();
      label23:
      Session localSession;
      if (localIterator.hasNext())
      {
        localSession = (Session)localIterator.next();
        if ((localSession.getStartTime(TimeUnit.MILLISECONDS) < this.LW) || (localSession.getEndTime(TimeUnit.MILLISECONDS) > this.TO)) {
          break label118;
        }
      }
      label118:
      for (boolean bool = true;; bool = false)
      {
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = localSession;
        arrayOfObject[1] = Long.valueOf(this.LW);
        arrayOfObject[2] = Long.valueOf(this.TO);
        jx.a(bool, "Session %s is outside the time interval [%d, %d]", arrayOfObject);
        break label23;
        break;
      }
    }
    
    public Builder addDataSource(DataSource paramDataSource)
    {
      boolean bool1 = true;
      boolean bool2;
      if (!this.VJ)
      {
        bool2 = bool1;
        jx.b(bool2, "All data is already marked for deletion");
        if (paramDataSource == null) {
          break label58;
        }
      }
      for (;;)
      {
        jx.b(bool1, "Must specify a valid data source");
        if (!this.VH.contains(paramDataSource)) {
          this.VH.add(paramDataSource);
        }
        return this;
        bool2 = false;
        break;
        label58:
        bool1 = false;
      }
    }
    
    public Builder addDataType(DataType paramDataType)
    {
      boolean bool1 = true;
      boolean bool2;
      if (!this.VJ)
      {
        bool2 = bool1;
        jx.b(bool2, "All data is already marked for deletion");
        if (paramDataType == null) {
          break label58;
        }
      }
      for (;;)
      {
        jx.b(bool1, "Must specify a valid data type");
        if (!this.TY.contains(paramDataType)) {
          this.TY.add(paramDataType);
        }
        return this;
        bool2 = false;
        break;
        label58:
        bool1 = false;
      }
    }
    
    public Builder addSession(Session paramSession)
    {
      boolean bool1 = true;
      boolean bool2;
      boolean bool3;
      if (!this.VK)
      {
        bool2 = bool1;
        jx.b(bool2, "All sessions already marked for deletion");
        if (paramSession == null) {
          break label67;
        }
        bool3 = bool1;
        label24:
        jx.b(bool3, "Must specify a valid session");
        if (paramSession.getEndTime(TimeUnit.MILLISECONDS) <= 0L) {
          break label73;
        }
      }
      for (;;)
      {
        jx.b(bool1, "Must specify a session that has already ended");
        this.VI.add(paramSession);
        return this;
        bool2 = false;
        break;
        label67:
        bool3 = false;
        break label24;
        label73:
        bool1 = false;
      }
    }
    
    public DataDeleteRequest build()
    {
      boolean bool1;
      int i;
      if ((this.LW > 0L) && (this.TO > this.LW))
      {
        bool1 = true;
        jx.a(bool1, "Must specify a valid time interval");
        if ((!this.VJ) && (this.VH.isEmpty()) && (this.TY.isEmpty())) {
          break label123;
        }
        i = 1;
        label62:
        if ((!this.VK) && (this.VI.isEmpty())) {
          break label128;
        }
      }
      label128:
      for (int j = 1;; j = 0)
      {
        boolean bool2;
        if (i == 0)
        {
          bool2 = false;
          if (j == 0) {}
        }
        else
        {
          bool2 = true;
        }
        jx.a(bool2, "No data or session marked for deletion");
        jT();
        return new DataDeleteRequest(this, null);
        bool1 = false;
        break;
        label123:
        i = 0;
        break label62;
      }
    }
    
    public Builder deleteAllData()
    {
      if ((this.TY.isEmpty()) && (this.VH.isEmpty())) {}
      for (boolean bool = true;; bool = false)
      {
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = this.VH;
        arrayOfObject[1] = this.TY;
        jx.b(bool, "Specific data source/type already specified for deletion. DataSources: %s DataTypes: %s", arrayOfObject);
        this.VJ = true;
        return this;
      }
    }
    
    public Builder deleteAllSessions()
    {
      boolean bool = this.VI.isEmpty();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.VI;
      jx.b(bool, "Specific sessions already added for deletion: %s", arrayOfObject);
      this.VK = true;
      return this;
    }
    
    public Builder setTimeInterval(long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
    {
      boolean bool1;
      if (paramLong1 > 0L)
      {
        bool1 = true;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = Long.valueOf(paramLong1);
        jx.b(bool1, "Invalid start time :%d", arrayOfObject1);
        if (paramLong2 <= paramLong1) {
          break label92;
        }
      }
      label92:
      for (boolean bool2 = true;; bool2 = false)
      {
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = Long.valueOf(paramLong2);
        jx.b(bool2, "Invalid end time :%d", arrayOfObject2);
        this.LW = paramTimeUnit.toMillis(paramLong1);
        this.TO = paramTimeUnit.toMillis(paramLong2);
        return this;
        bool1 = false;
        break;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.DataDeleteRequest
 * JD-Core Version:    0.7.0.1
 */