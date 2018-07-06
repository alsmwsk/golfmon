package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Session;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.jx;
import java.util.concurrent.TimeUnit;

public class w
  implements SafeParcelable
{
  public static final Parcelable.Creator<w> CREATOR = new x();
  private final int CK;
  private final Session TQ;
  
  w(int paramInt, Session paramSession)
  {
    this.CK = paramInt;
    this.TQ = paramSession;
  }
  
  private w(a parama)
  {
    this.CK = 1;
    this.TQ = a.a(parama);
  }
  
  private boolean a(w paramw)
  {
    return jv.equal(this.TQ, paramw.TQ);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof w)) && (a((w)paramObject)));
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
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.TQ;
    return jv.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return jv.h(this).a("session", this.TQ).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    x.a(this, paramParcel, paramInt);
  }
  
  public static class a
  {
    private Session TQ;
    
    public a b(Session paramSession)
    {
      if (paramSession.getEndTime(TimeUnit.MILLISECONDS) == 0L) {}
      for (boolean bool = true;; bool = false)
      {
        jx.b(bool, "Cannot start a session which has already ended");
        this.TQ = paramSession;
        return this;
      }
    }
    
    public w kk()
    {
      return new w(this, null);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.w
 * JD-Core Version:    0.7.0.1
 */