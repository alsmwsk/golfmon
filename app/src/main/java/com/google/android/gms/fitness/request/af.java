package com.google.android.gms.fitness.request;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Subscription;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.jx;

public class af
  implements SafeParcelable
{
  public static final Parcelable.Creator<af> CREATOR = new ag();
  private final int CK;
  private final Subscription Wo;
  private final boolean Wp;
  
  af(int paramInt, Subscription paramSubscription, boolean paramBoolean)
  {
    this.CK = paramInt;
    this.Wo = paramSubscription;
    this.Wp = paramBoolean;
  }
  
  private af(a parama)
  {
    this.CK = 1;
    this.Wo = a.a(parama);
    this.Wp = a.b(parama);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public Subscription kn()
  {
    return this.Wo;
  }
  
  public boolean ko()
  {
    return this.Wp;
  }
  
  public String toString()
  {
    return jv.h(this).a("subscription", this.Wo).toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ag.a(this, paramParcel, paramInt);
  }
  
  public static class a
  {
    private Subscription Wo;
    private boolean Wp = false;
    
    public a b(Subscription paramSubscription)
    {
      this.Wo = paramSubscription;
      return this;
    }
    
    public af kp()
    {
      if (this.Wo != null) {}
      for (boolean bool = true;; bool = false)
      {
        jx.a(bool, "Must call setSubscription()");
        return new af(this, null);
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.request.af
 * JD-Core Version:    0.7.0.1
 */