package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class Contents
  implements SafeParcelable
{
  public static final Parcelable.Creator<Contents> CREATOR = new a();
  final int CK;
  final ParcelFileDescriptor LG;
  final int Oi;
  final DriveId Oj;
  final boolean Ok;
  final int ve;
  
  Contents(int paramInt1, ParcelFileDescriptor paramParcelFileDescriptor, int paramInt2, int paramInt3, DriveId paramDriveId, boolean paramBoolean)
  {
    this.CK = paramInt1;
    this.LG = paramParcelFileDescriptor;
    this.ve = paramInt2;
    this.Oi = paramInt3;
    this.Oj = paramDriveId;
    this.Ok = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public DriveId getDriveId()
  {
    return this.Oj;
  }
  
  public InputStream getInputStream()
  {
    return new FileInputStream(this.LG.getFileDescriptor());
  }
  
  public int getMode()
  {
    return this.Oi;
  }
  
  public OutputStream getOutputStream()
  {
    return new FileOutputStream(this.LG.getFileDescriptor());
  }
  
  public ParcelFileDescriptor getParcelFileDescriptor()
  {
    return this.LG;
  }
  
  public int getRequestId()
  {
    return this.ve;
  }
  
  public boolean ip()
  {
    return this.Ok;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.Contents
 * JD-Core Version:    0.7.0.1
 */