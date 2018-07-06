package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import java.util.Locale;

public final class ChangeEvent
  implements SafeParcelable, ResourceEvent
{
  public static final Parcelable.Creator<ChangeEvent> CREATOR = new a();
  final int CK;
  final int OX;
  final DriveId Oj;
  
  ChangeEvent(int paramInt1, DriveId paramDriveId, int paramInt2)
  {
    this.CK = paramInt1;
    this.Oj = paramDriveId;
    this.OX = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DriveId getDriveId()
  {
    return this.Oj;
  }
  
  public int getType()
  {
    return 1;
  }
  
  public boolean hasContentChanged()
  {
    return (0x2 & this.OX) != 0;
  }
  
  public boolean hasMetadataChanged()
  {
    return (0x1 & this.OX) != 0;
  }
  
  public String toString()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = this.Oj;
    arrayOfObject[1] = Integer.valueOf(this.OX);
    return String.format(localLocale, "ChangeEvent [id=%s,changeFlags=%x]", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.ChangeEvent
 * JD-Core Version:    0.7.0.1
 */