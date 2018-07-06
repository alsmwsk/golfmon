package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.c;
import com.google.android.gms.fitness.FitnessActivities;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.jx;
import java.util.concurrent.TimeUnit;

public class Session
  implements SafeParcelable
{
  public static final Parcelable.Creator<Session> CREATOR = new p();
  public static final String EXTRA_SESSION = "vnd.google.fitness.session";
  public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.session/";
  private final int CK;
  private final long LW;
  private final long TO;
  private final int TZ;
  private final String UN;
  private final String UO;
  private final a Um;
  private final String mName;
  
  Session(int paramInt1, long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, int paramInt2, a parama)
  {
    this.CK = paramInt1;
    this.LW = paramLong1;
    this.TO = paramLong2;
    this.mName = paramString1;
    this.UN = paramString2;
    this.UO = paramString3;
    this.TZ = paramInt2;
    this.Um = parama;
  }
  
  private Session(Builder paramBuilder)
  {
    this.CK = 2;
    this.LW = Builder.a(paramBuilder);
    this.TO = Builder.b(paramBuilder);
    this.mName = Builder.c(paramBuilder);
    this.UN = Builder.d(paramBuilder);
    this.UO = Builder.e(paramBuilder);
    this.TZ = Builder.f(paramBuilder);
    this.Um = Builder.g(paramBuilder);
  }
  
  private boolean a(Session paramSession)
  {
    return (this.LW == paramSession.LW) && (this.TO == paramSession.TO) && (jv.equal(this.mName, paramSession.mName)) && (jv.equal(this.UN, paramSession.UN)) && (jv.equal(this.UO, paramSession.UO)) && (jv.equal(this.Um, paramSession.Um)) && (this.TZ == paramSession.TZ);
  }
  
  public static Session extract(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return (Session)c.a(paramIntent, "vnd.google.fitness.session", CREATOR);
  }
  
  public static String getMimeType(String paramString)
  {
    return "vnd.google.fitness.session/" + paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof Session)) && (a((Session)paramObject)));
  }
  
  public String getActivity()
  {
    return FitnessActivities.getName(this.TZ);
  }
  
  public String getAppPackageName()
  {
    if (this.Um == null) {
      return null;
    }
    return this.Um.getPackageName();
  }
  
  public String getDescription()
  {
    return this.UO;
  }
  
  public long getEndTime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.TO, TimeUnit.MILLISECONDS);
  }
  
  public String getIdentifier()
  {
    return this.UN;
  }
  
  public String getName()
  {
    return this.mName;
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
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Long.valueOf(this.LW);
    arrayOfObject[1] = Long.valueOf(this.TO);
    arrayOfObject[2] = this.UN;
    return jv.hashCode(arrayOfObject);
  }
  
  public boolean isOngoing()
  {
    return this.TO == 0L;
  }
  
  public int jm()
  {
    return this.TZ;
  }
  
  public long jo()
  {
    return this.LW;
  }
  
  public long jp()
  {
    return this.TO;
  }
  
  public a jx()
  {
    return this.Um;
  }
  
  public String toString()
  {
    return jv.h(this).a("startTime", Long.valueOf(this.LW)).a("endTime", Long.valueOf(this.TO)).a("name", this.mName).a("identifier", this.UN).a("description", this.UO).a("activity", Integer.valueOf(this.TZ)).a("application", this.Um).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    p.a(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private long LW = 0L;
    private long TO = 0L;
    private int TZ = 4;
    private String UN;
    private String UO;
    private a Um;
    private String mName = null;
    
    public Session build()
    {
      boolean bool1;
      StringBuilder localStringBuilder;
      if (this.LW > 0L)
      {
        bool1 = true;
        jx.a(bool1, "Start time should be specified.");
        boolean bool2;
        if (this.TO != 0L)
        {
          boolean bool3 = this.TO < this.LW;
          bool2 = false;
          if (!bool3) {}
        }
        else
        {
          bool2 = true;
        }
        jx.a(bool2, "End time should be later than start time.");
        if (this.UN == null)
        {
          localStringBuilder = new StringBuilder();
          if (this.mName != null) {
            break label113;
          }
        }
      }
      label113:
      for (String str = "";; str = this.mName)
      {
        this.UN = (str + this.LW);
        return new Session(this, null);
        bool1 = false;
        break;
      }
    }
    
    public Builder cV(int paramInt)
    {
      this.TZ = paramInt;
      return this;
    }
    
    public Builder setActivity(String paramString)
    {
      return cV(FitnessActivities.bs(paramString));
    }
    
    public Builder setDescription(String paramString)
    {
      if (paramString.length() <= 1000) {}
      for (boolean bool = true;; bool = false)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(1000);
        jx.b(bool, "Session description cannot exceed %d characters", arrayOfObject);
        this.UO = paramString;
        return this;
      }
    }
    
    public Builder setEndTime(long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramLong >= 0L) {}
      for (boolean bool = true;; bool = false)
      {
        jx.a(bool, "End time should be positive.");
        this.TO = paramTimeUnit.toMillis(paramLong);
        return this;
      }
    }
    
    public Builder setIdentifier(String paramString)
    {
      if ((paramString != null) && (TextUtils.getTrimmedLength(paramString) > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        jx.L(bool);
        this.UN = paramString;
        return this;
      }
    }
    
    public Builder setName(String paramString)
    {
      if (paramString.length() <= 100) {}
      for (boolean bool = true;; bool = false)
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(100);
        jx.b(bool, "Session name cannot exceed %d characters", arrayOfObject);
        this.mName = paramString;
        return this;
      }
    }
    
    public Builder setStartTime(long paramLong, TimeUnit paramTimeUnit)
    {
      if (paramLong > 0L) {}
      for (boolean bool = true;; bool = false)
      {
        jx.a(bool, "Start time should be positive.");
        this.LW = paramTimeUnit.toMillis(paramLong);
        return this;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.data.Session
 * JD-Core Version:    0.7.0.1
 */