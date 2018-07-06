package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.lt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SessionInsertRequest
  implements SafeParcelable
{
  public static final Parcelable.Creator<SessionInsertRequest> CREATOR = new s();
  private final int CK;
  private final Session TQ;
  private final List<DataSet> Ua;
  private final List<DataPoint> Wh;
  
  SessionInsertRequest(int paramInt, Session paramSession, List<DataSet> paramList, List<DataPoint> paramList1)
  {
    this.CK = paramInt;
    this.TQ = paramSession;
    this.Ua = Collections.unmodifiableList(paramList);
    this.Wh = Collections.unmodifiableList(paramList1);
  }
  
  private SessionInsertRequest(Builder paramBuilder)
  {
    this.CK = 1;
    this.TQ = Builder.a(paramBuilder);
    this.Ua = Collections.unmodifiableList(Builder.b(paramBuilder));
    this.Wh = Collections.unmodifiableList(Builder.c(paramBuilder));
  }
  
  private boolean a(SessionInsertRequest paramSessionInsertRequest)
  {
    return (jv.equal(this.TQ, paramSessionInsertRequest.TQ)) && (jv.equal(this.Ua, paramSessionInsertRequest.Ua)) && (jv.equal(this.Wh, paramSessionInsertRequest.Wh));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof SessionInsertRequest)) && (a((SessionInsertRequest)paramObject)));
  }
  
  public List<DataPoint> getAggregateDataPoints()
  {
    return this.Wh;
  }
  
  public List<DataSet> getDataSets()
  {
    return this.Ua;
  }
  
  public Session getSession()
  {
    return this.TQ;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.TQ;
    arrayOfObject[1] = this.Ua;
    arrayOfObject[2] = this.Wh;
    return jv.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return jv.h(this).a("session", this.TQ).a("dataSets", this.Ua).a("aggregateDataPoints", this.Wh).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    s.a(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private Session TQ;
    private List<DataSet> Ua = new ArrayList();
    private List<DataPoint> Wh = new ArrayList();
    private List<DataSource> Wi = new ArrayList();
    
    private void d(DataPoint paramDataPoint)
    {
      f(paramDataPoint);
      e(paramDataPoint);
    }
    
    private void e(DataPoint paramDataPoint)
    {
      long l1 = this.TQ.getStartTime(TimeUnit.NANOSECONDS);
      long l2 = this.TQ.getEndTime(TimeUnit.NANOSECONDS);
      long l3 = paramDataPoint.getStartTime(TimeUnit.NANOSECONDS);
      long l4 = paramDataPoint.getEndTime(TimeUnit.NANOSECONDS);
      TimeUnit localTimeUnit;
      if ((l3 != 0L) && (l4 != 0L))
      {
        localTimeUnit = TimeUnit.MILLISECONDS;
        if (l4 > l2) {
          l4 = lt.a(l4, TimeUnit.NANOSECONDS, localTimeUnit);
        }
        if ((l3 < l1) || (l4 > l2)) {
          break label209;
        }
      }
      label209:
      for (boolean bool = true;; bool = false)
      {
        Object[] arrayOfObject1 = new Object[3];
        arrayOfObject1[0] = paramDataPoint;
        arrayOfObject1[1] = Long.valueOf(l1);
        arrayOfObject1[2] = Long.valueOf(l2);
        jx.a(bool, "Data point %s has start and end times outside session interval [%d, %d]", arrayOfObject1);
        if (l4 != paramDataPoint.getEndTime(TimeUnit.NANOSECONDS))
        {
          Object[] arrayOfObject2 = new Object[3];
          arrayOfObject2[0] = Long.valueOf(paramDataPoint.getEndTime(TimeUnit.NANOSECONDS));
          arrayOfObject2[1] = Long.valueOf(l4);
          arrayOfObject2[2] = localTimeUnit;
          Log.w("Fitness", String.format("Data point end time [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", arrayOfObject2));
          paramDataPoint.setTimeInterval(l3, l4, TimeUnit.NANOSECONDS);
        }
        return;
      }
    }
    
    private void f(DataPoint paramDataPoint)
    {
      long l1 = this.TQ.getStartTime(TimeUnit.NANOSECONDS);
      long l2 = this.TQ.getEndTime(TimeUnit.NANOSECONDS);
      long l3 = paramDataPoint.getTimestamp(TimeUnit.NANOSECONDS);
      TimeUnit localTimeUnit;
      if (l3 != 0L)
      {
        localTimeUnit = TimeUnit.MILLISECONDS;
        if ((l3 < l1) || (l3 > l2)) {
          l3 = lt.a(l3, TimeUnit.NANOSECONDS, localTimeUnit);
        }
        if ((l3 < l1) || (l3 > l2)) {
          break label198;
        }
      }
      label198:
      for (boolean bool = true;; bool = false)
      {
        Object[] arrayOfObject1 = new Object[3];
        arrayOfObject1[0] = paramDataPoint;
        arrayOfObject1[1] = Long.valueOf(l1);
        arrayOfObject1[2] = Long.valueOf(l2);
        jx.a(bool, "Data point %s has time stamp outside session interval [%d, %d]", arrayOfObject1);
        if (paramDataPoint.getTimestamp(TimeUnit.NANOSECONDS) != l3)
        {
          Object[] arrayOfObject2 = new Object[3];
          arrayOfObject2[0] = Long.valueOf(paramDataPoint.getTimestamp(TimeUnit.NANOSECONDS));
          arrayOfObject2[1] = Long.valueOf(l3);
          arrayOfObject2[2] = localTimeUnit;
          Log.w("Fitness", String.format("Data point timestamp [%d] is truncated to [%d] to match the precision [%s] of the session start and end time", arrayOfObject2));
          paramDataPoint.setTimestamp(l3, TimeUnit.NANOSECONDS);
        }
        return;
      }
    }
    
    private void ki()
    {
      Iterator localIterator1 = this.Ua.iterator();
      while (localIterator1.hasNext())
      {
        Iterator localIterator3 = ((DataSet)localIterator1.next()).getDataPoints().iterator();
        while (localIterator3.hasNext()) {
          d((DataPoint)localIterator3.next());
        }
      }
      Iterator localIterator2 = this.Wh.iterator();
      while (localIterator2.hasNext()) {
        d((DataPoint)localIterator2.next());
      }
    }
    
    public Builder addAggregateDataPoint(DataPoint paramDataPoint)
    {
      boolean bool1;
      boolean bool2;
      label45:
      DataSource localDataSource;
      if (paramDataPoint != null)
      {
        bool1 = true;
        jx.b(bool1, "Must specify a valid aggregate data point.");
        long l1 = paramDataPoint.getStartTime(TimeUnit.NANOSECONDS);
        long l2 = paramDataPoint.getEndTime(TimeUnit.NANOSECONDS);
        if ((l1 <= 0L) || (l2 <= l1)) {
          break label129;
        }
        bool2 = true;
        jx.b(bool2, "Aggregate data point should have valid start and end times: %s", new Object[] { paramDataPoint });
        localDataSource = paramDataPoint.getDataSource();
        if (this.Wi.contains(localDataSource)) {
          break label135;
        }
      }
      label129:
      label135:
      for (boolean bool3 = true;; bool3 = false)
      {
        jx.a(bool3, "Data set/Aggregate data point for this data source %s is already added.", new Object[] { localDataSource });
        this.Wi.add(localDataSource);
        this.Wh.add(paramDataPoint);
        return this;
        bool1 = false;
        break;
        bool2 = false;
        break label45;
      }
    }
    
    public Builder addDataSet(DataSet paramDataSet)
    {
      boolean bool1 = true;
      boolean bool2;
      DataSource localDataSource;
      boolean bool3;
      if (paramDataSet != null)
      {
        bool2 = bool1;
        jx.b(bool2, "Must specify a valid data set.");
        localDataSource = paramDataSet.getDataSource();
        if (this.Wi.contains(localDataSource)) {
          break label106;
        }
        bool3 = bool1;
        label37:
        Object[] arrayOfObject = new Object[bool1];
        arrayOfObject[0] = localDataSource;
        jx.a(bool3, "Data set for this data source %s is already added.", arrayOfObject);
        if (paramDataSet.getDataPoints().isEmpty()) {
          break label112;
        }
      }
      for (;;)
      {
        jx.b(bool1, "No data points specified in the input data set.");
        this.Wi.add(localDataSource);
        this.Ua.add(paramDataSet);
        return this;
        bool2 = false;
        break;
        label106:
        bool3 = false;
        break label37;
        label112:
        bool1 = false;
      }
    }
    
    public SessionInsertRequest build()
    {
      boolean bool1 = true;
      boolean bool2;
      if (this.TQ != null)
      {
        bool2 = bool1;
        jx.a(bool2, "Must specify a valid session.");
        if (this.TQ.getEndTime(TimeUnit.MILLISECONDS) == 0L) {
          break label57;
        }
      }
      for (;;)
      {
        jx.a(bool1, "Must specify a valid end time, cannot insert a continuing session.");
        ki();
        return new SessionInsertRequest(this, null);
        bool2 = false;
        break;
        label57:
        bool1 = false;
      }
    }
    
    public Builder setSession(Session paramSession)
    {
      this.TQ = paramSession;
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.SessionInsertRequest
 * JD-Core Version:    0.7.0.1
 */