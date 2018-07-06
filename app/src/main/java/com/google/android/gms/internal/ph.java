package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;

public final class ph
  extends d
  implements Moment
{
  private pf apk;
  
  public ph(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  private pf oK()
  {
    try
    {
      if (this.apk == null)
      {
        byte[] arrayOfByte = getByteArray("momentImpl");
        Parcel localParcel = Parcel.obtain();
        localParcel.unmarshall(arrayOfByte, 0, arrayOfByte.length);
        localParcel.setDataPosition(0);
        this.apk = pf.CREATOR.dy(localParcel);
        localParcel.recycle();
      }
      return this.apk;
    }
    finally {}
  }
  
  public String getId()
  {
    return oK().getId();
  }
  
  public ItemScope getResult()
  {
    return oK().getResult();
  }
  
  public String getStartDate()
  {
    return oK().getStartDate();
  }
  
  public ItemScope getTarget()
  {
    return oK().getTarget();
  }
  
  public String getType()
  {
    return oK().getType();
  }
  
  public boolean hasId()
  {
    return oK().hasId();
  }
  
  public boolean hasResult()
  {
    return oK().hasResult();
  }
  
  public boolean hasStartDate()
  {
    return oK().hasStartDate();
  }
  
  public boolean hasTarget()
  {
    return oK().hasTarget();
  }
  
  public boolean hasType()
  {
    return oK().hasType();
  }
  
  public pf oJ()
  {
    return oK();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ph
 * JD-Core Version:    0.7.0.1
 */