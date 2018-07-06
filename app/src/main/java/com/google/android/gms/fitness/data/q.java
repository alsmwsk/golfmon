package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;

public class q
  implements SafeParcelable
{
  public static final Parcelable.Creator<q> CREATOR = new r();
  final int CK;
  private final Session TQ;
  private final DataSet UP;
  
  q(int paramInt, Session paramSession, DataSet paramDataSet)
  {
    this.CK = paramInt;
    this.TQ = paramSession;
    this.UP = paramDataSet;
  }
  
  private boolean a(q paramq)
  {
    return (jv.equal(this.TQ, paramq.TQ)) && (jv.equal(this.UP, paramq.UP));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (paramObject == this) || (((paramObject instanceof q)) && (a((q)paramObject)));
  }
  
  public Session getSession()
  {
    return this.TQ;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.TQ;
    arrayOfObject[1] = this.UP;
    return jv.hashCode(arrayOfObject);
  }
  
  public DataSet jH()
  {
    return this.UP;
  }
  
  public String toString()
  {
    return jv.h(this).a("session", this.TQ).a("dataSet", this.UP).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    r.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.data.q
 * JD-Core Version:    0.7.0.1
 */