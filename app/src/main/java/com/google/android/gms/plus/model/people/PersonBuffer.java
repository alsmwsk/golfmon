package com.google.android.gms.plus.model.people;

import android.os.Bundle;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.e;
import com.google.android.gms.internal.pi;
import com.google.android.gms.internal.pt;

public final class PersonBuffer
  extends DataBuffer<Person>
{
  private final e<pi> apT;
  
  public PersonBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
    if ((paramDataHolder.gV() != null) && (paramDataHolder.gV().getBoolean("com.google.android.gms.plus.IsSafeParcelable", false)))
    {
      this.apT = new e(paramDataHolder, pi.CREATOR);
      return;
    }
    this.apT = null;
  }
  
  public Person get(int paramInt)
  {
    if (this.apT != null) {
      return (Person)this.apT.at(paramInt);
    }
    return new pt(this.JG, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.model.people.PersonBuffer
 * JD-Core Version:    0.7.0.1
 */