package com.google.android.gms.fitness.request;

import android.os.SystemClock;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.jx;
import com.google.android.gms.location.LocationRequest;
import java.util.concurrent.TimeUnit;

public class SensorRequest
{
  public static final int ACCURACY_MODE_DEFAULT = 2;
  public static final int ACCURACY_MODE_HIGH = 3;
  public static final int ACCURACY_MODE_LOW = 1;
  private final DataType TM;
  private final DataSource TN;
  private final long UQ;
  private final int UR;
  private final long VZ;
  private final long Wa;
  private final LocationRequest We;
  private final long Wf;
  
  private SensorRequest(DataSource paramDataSource, LocationRequest paramLocationRequest)
  {
    this.We = paramLocationRequest;
    this.UQ = TimeUnit.MILLISECONDS.toMicros(paramLocationRequest.getInterval());
    this.Wa = TimeUnit.MILLISECONDS.toMicros(paramLocationRequest.getFastestInterval());
    this.VZ = this.UQ;
    this.TM = paramDataSource.getDataType();
    this.UR = a(paramLocationRequest);
    this.TN = paramDataSource;
    long l = paramLocationRequest.getExpirationTime();
    if (l == 9223372036854775807L)
    {
      this.Wf = 9223372036854775807L;
      return;
    }
    this.Wf = TimeUnit.MILLISECONDS.toMicros(l - SystemClock.elapsedRealtime());
  }
  
  private SensorRequest(Builder paramBuilder)
  {
    this.TN = Builder.a(paramBuilder);
    this.TM = Builder.b(paramBuilder);
    this.UQ = Builder.c(paramBuilder);
    this.Wa = Builder.d(paramBuilder);
    this.VZ = Builder.e(paramBuilder);
    this.UR = Builder.f(paramBuilder);
    this.We = null;
    this.Wf = Builder.g(paramBuilder);
  }
  
  private static int a(LocationRequest paramLocationRequest)
  {
    switch (paramLocationRequest.getPriority())
    {
    default: 
      return 2;
    case 100: 
      return 3;
    }
    return 1;
  }
  
  private boolean a(SensorRequest paramSensorRequest)
  {
    return (jv.equal(this.TN, paramSensorRequest.TN)) && (jv.equal(this.TM, paramSensorRequest.TM)) && (this.UQ == paramSensorRequest.UQ) && (this.Wa == paramSensorRequest.Wa) && (this.VZ == paramSensorRequest.VZ) && (this.UR == paramSensorRequest.UR) && (jv.equal(this.We, paramSensorRequest.We)) && (this.Wf == paramSensorRequest.Wf);
  }
  
  public static int dl(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      paramInt = 2;
    }
    return paramInt;
  }
  
  public static SensorRequest fromLocationRequest(DataSource paramDataSource, LocationRequest paramLocationRequest)
  {
    return new SensorRequest(paramDataSource, paramLocationRequest);
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof SensorRequest)) && (a((SensorRequest)paramObject)));
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
  
  public long getFastestRate(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.Wa, TimeUnit.MICROSECONDS);
  }
  
  public long getMaxDeliveryLatency(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.VZ, TimeUnit.MICROSECONDS);
  }
  
  public long getSamplingRate(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.UQ, TimeUnit.MICROSECONDS);
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[8];
    arrayOfObject[0] = this.TN;
    arrayOfObject[1] = this.TM;
    arrayOfObject[2] = Long.valueOf(this.UQ);
    arrayOfObject[3] = Long.valueOf(this.Wa);
    arrayOfObject[4] = Long.valueOf(this.VZ);
    arrayOfObject[5] = Integer.valueOf(this.UR);
    arrayOfObject[6] = this.We;
    arrayOfObject[7] = Long.valueOf(this.Wf);
    return jv.hashCode(arrayOfObject);
  }
  
  public long kh()
  {
    return this.Wf;
  }
  
  public String toString()
  {
    return jv.h(this).a("dataSource", this.TN).a("dataType", this.TM).a("samplingRateMicros", Long.valueOf(this.UQ)).a("deliveryLatencyMicros", Long.valueOf(this.VZ)).a("timeOutMicros", Long.valueOf(this.Wf)).toString();
  }
  
  public static class Builder
  {
    private DataType TM;
    private DataSource TN;
    private long UQ = -1L;
    private int UR = 2;
    private long VZ = 0L;
    private long Wa = 0L;
    private long Wf = 9223372036854775807L;
    private boolean Wg = false;
    
    public SensorRequest build()
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
        return new SensorRequest(this, null);
      }
    }
    
    public Builder setAccuracyMode(int paramInt)
    {
      this.UR = SensorRequest.dl(paramInt);
      return this;
    }
    
    public Builder setDataSource(DataSource paramDataSource)
    {
      this.TN = paramDataSource;
      return this;
    }
    
    public Builder setDataType(DataType paramDataType)
    {
      this.TM = paramDataType;
      return this;
    }
    
    public Builder setFastestRate(int paramInt, TimeUnit paramTimeUnit)
    {
      if (paramInt >= 0) {}
      for (boolean bool = true;; bool = false)
      {
        jx.b(bool, "Cannot use a negative interval");
        this.Wg = true;
        this.Wa = paramTimeUnit.toMicros(paramInt);
        return this;
      }
    }
    
    public Builder setMaxDeliveryLatency(int paramInt, TimeUnit paramTimeUnit)
    {
      if (paramInt >= 0) {}
      for (boolean bool = true;; bool = false)
      {
        jx.b(bool, "Cannot use a negative delivery interval");
        this.VZ = paramTimeUnit.toMicros(paramInt);
        return this;
      }
    }
    
    public Builder setSamplingRate(long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramLong >= 0L) {}
      for (boolean bool = true;; bool = false)
      {
        jx.b(bool, "Cannot use a negative sampling interval");
        this.UQ = paramTimeUnit.toMicros(paramLong);
        if (!this.Wg) {
          this.Wa = (this.UQ / 2L);
        }
        return this;
      }
    }
    
    public Builder setTimeout(long paramLong, TimeUnit paramTimeUnit)
    {
      boolean bool1 = true;
      boolean bool2;
      if (paramLong > 0L)
      {
        bool2 = bool1;
        Object[] arrayOfObject = new Object[bool1];
        arrayOfObject[0] = Long.valueOf(paramLong);
        jx.b(bool2, "Invalid time out value specified: %d", arrayOfObject);
        if (paramTimeUnit == null) {
          break label65;
        }
      }
      for (;;)
      {
        jx.b(bool1, "Invalid time unit specified");
        this.Wf = paramTimeUnit.toMicros(paramLong);
        return this;
        bool2 = false;
        break;
        label65:
        bool1 = false;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.SensorRequest
 * JD-Core Version:    0.7.0.1
 */