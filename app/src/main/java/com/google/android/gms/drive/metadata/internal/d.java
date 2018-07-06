package com.google.android.gms.drive.metadata.internal;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import java.util.Date;

public class d
  extends com.google.android.gms.drive.metadata.d<Date>
{
  public d(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  protected void a(Bundle paramBundle, Date paramDate)
  {
    paramBundle.putLong(getName(), paramDate.getTime());
  }
  
  protected Date f(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    return new Date(paramDataHolder.a(getName(), paramInt1, paramInt2));
  }
  
  protected Date k(Bundle paramBundle)
  {
    return new Date(paramBundle.getLong(getName()));
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.d
 * JD-Core Version:    0.7.0.1
 */