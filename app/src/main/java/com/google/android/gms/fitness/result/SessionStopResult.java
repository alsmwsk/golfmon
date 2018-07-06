package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import java.util.Collections;
import java.util.List;

public class SessionStopResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<SessionStopResult> CREATOR = new g();
  private final int CK;
  private final Status Eb;
  private final List<Session> VI;
  
  SessionStopResult(int paramInt, Status paramStatus, List<Session> paramList)
  {
    this.CK = paramInt;
    this.Eb = paramStatus;
    this.VI = Collections.unmodifiableList(paramList);
  }
  
  public SessionStopResult(Status paramStatus, List<Session> paramList)
  {
    this.CK = 3;
    this.Eb = paramStatus;
    this.VI = Collections.unmodifiableList(paramList);
  }
  
  public static SessionStopResult H(Status paramStatus)
  {
    return new SessionStopResult(paramStatus, Collections.emptyList());
  }
  
  private boolean b(SessionStopResult paramSessionStopResult)
  {
    return (this.Eb.equals(paramSessionStopResult.Eb)) && (jv.equal(this.VI, paramSessionStopResult.VI));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof SessionStopResult)) && (b((SessionStopResult)paramObject)));
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
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.Eb;
    arrayOfObject[1] = this.VI;
    return jv.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return jv.h(this).a("status", this.Eb).a("sessions", this.VI).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.result.SessionStopResult
 * JD-Core Version:    0.7.0.1
 */