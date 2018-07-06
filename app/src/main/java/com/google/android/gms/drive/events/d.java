package com.google.android.gms.drive.events;

import com.google.android.gms.drive.DriveId;

public class d
{
  public static boolean a(int paramInt, DriveId paramDriveId)
  {
    return (paramDriveId != null) || (bi(paramInt));
  }
  
  public static boolean bi(int paramInt)
  {
    return (0x2 & 1 << paramInt) != 0L;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.d
 * JD-Core Version:    0.7.0.1
 */