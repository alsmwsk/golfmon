package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.fitness.data.q;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SessionReadResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<SessionReadResult> CREATOR = new f();
  private final int CK;
  private final Status Eb;
  private final List<Session> VI;
  private final List<q> Wv;
  
  SessionReadResult(int paramInt, List<Session> paramList, List<q> paramList1, Status paramStatus)
  {
    this.CK = paramInt;
    this.VI = paramList;
    this.Wv = Collections.unmodifiableList(paramList1);
    this.Eb = paramStatus;
  }
  
  public SessionReadResult(List<Session> paramList, List<q> paramList1, Status paramStatus)
  {
    this.CK = 3;
    this.VI = paramList;
    this.Wv = Collections.unmodifiableList(paramList1);
    this.Eb = paramStatus;
  }
  
  public static SessionReadResult G(Status paramStatus)
  {
    return new SessionReadResult(new ArrayList(), new ArrayList(), paramStatus);
  }
  
  private boolean b(SessionReadResult paramSessionReadResult)
  {
    return (this.Eb.equals(paramSessionReadResult.Eb)) && (jv.equal(this.VI, paramSessionReadResult.VI)) && (jv.equal(this.Wv, paramSessionReadResult.Wv));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof SessionReadResult)) && (b((SessionReadResult)paramObject)));
  }
  
  public List<DataSet> getDataSet(Session paramSession)
  {
    jx.b(this.VI.contains(paramSession), "Attempting to read data for session %s which was not returned", new Object[] { paramSession });
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Wv.iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      if (jv.equal(paramSession, localq.getSession())) {
        localArrayList.add(localq.jH());
      }
    }
    return localArrayList;
  }
  
  public List<DataSet> getDataSet(Session paramSession, DataType paramDataType)
  {
    jx.b(this.VI.contains(paramSession), "Attempting to read data for session %s which was not returned", new Object[] { paramSession });
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Wv.iterator();
    while (localIterator.hasNext())
    {
      q localq = (q)localIterator.next();
      if ((jv.equal(paramSession, localq.getSession())) && (paramDataType.equals(localq.jH().getDataType()))) {
        localArrayList.add(localq.jH());
      }
    }
    return localArrayList;
  }
  
  public List<Session> getSessions()
  {
    return this.VI;
  }
  
  public Status getStatus()
  {
    return this.Eb;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.Eb;
    arrayOfObject[1] = this.VI;
    arrayOfObject[2] = this.Wv;
    return jv.hashCode(arrayOfObject);
  }
  
  public List<q> kv()
  {
    return this.Wv;
  }
  
  public String toString()
  {
    return jv.h(this).a("status", this.Eb).a("sessions", this.VI).a("sessionDataSets", this.Wv).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    f.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.result.SessionReadResult
 * JD-Core Version:    0.7.0.1
 */