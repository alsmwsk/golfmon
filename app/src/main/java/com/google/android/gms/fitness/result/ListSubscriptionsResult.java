package com.google.android.gms.fitness.result;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ListSubscriptionsResult
  implements Result, SafeParcelable
{
  public static final Parcelable.Creator<ListSubscriptionsResult> CREATOR = new e();
  private final int CK;
  private final Status Eb;
  private final List<Subscription> Wu;
  
  ListSubscriptionsResult(int paramInt, List<Subscription> paramList, Status paramStatus)
  {
    this.CK = paramInt;
    this.Wu = paramList;
    this.Eb = paramStatus;
  }
  
  public ListSubscriptionsResult(List<Subscription> paramList, Status paramStatus)
  {
    this.CK = 3;
    this.Wu = Collections.unmodifiableList(paramList);
    this.Eb = ((Status)jx.b(paramStatus, "status"));
  }
  
  public static ListSubscriptionsResult F(Status paramStatus)
  {
    return new ListSubscriptionsResult(Collections.emptyList(), paramStatus);
  }
  
  private boolean b(ListSubscriptionsResult paramListSubscriptionsResult)
  {
    return (this.Eb.equals(paramListSubscriptionsResult.Eb)) && (jv.equal(this.Wu, paramListSubscriptionsResult.Wu));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof ListSubscriptionsResult)) && (b((ListSubscriptionsResult)paramObject)));
  }
  
  public Status getStatus()
  {
    return this.Eb;
  }
  
  public List<Subscription> getSubscriptions()
  {
    return this.Wu;
  }
  
  public List<Subscription> getSubscriptions(DataType paramDataType)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.Wu.iterator();
    while (localIterator.hasNext())
    {
      Subscription localSubscription = (Subscription)localIterator.next();
      if (paramDataType.equals(localSubscription.jJ())) {
        localArrayList.add(localSubscription);
      }
    }
    return Collections.unmodifiableList(localArrayList);
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.Eb;
    arrayOfObject[1] = this.Wu;
    return jv.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    return jv.h(this).a("status", this.Eb).a("subscriptions", this.Wu).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    e.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.result.ListSubscriptionsResult
 * JD-Core Version:    0.7.0.1
 */