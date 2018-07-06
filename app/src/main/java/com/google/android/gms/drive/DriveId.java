package com.google.android.gms.drive;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Base64;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.ak;
import com.google.android.gms.drive.internal.w;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.qv;
import com.google.android.gms.internal.qw;

public class DriveId
  implements SafeParcelable
{
  public static final Parcelable.Creator<DriveId> CREATOR = new c();
  final int CK;
  final String Ot;
  final long Ou;
  final long Ov;
  private volatile String Ow = null;
  
  DriveId(int paramInt, String paramString, long paramLong1, long paramLong2)
  {
    this.CK = paramInt;
    this.Ot = paramString;
    if (!"".equals(paramString)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      jx.L(bool1);
      boolean bool2;
      if (paramString == null)
      {
        boolean bool3 = paramLong1 < -1L;
        bool2 = false;
        if (!bool3) {}
      }
      else
      {
        bool2 = true;
      }
      jx.L(bool2);
      this.Ou = paramLong1;
      this.Ov = paramLong2;
      return;
    }
  }
  
  public DriveId(String paramString, long paramLong1, long paramLong2)
  {
    this(1, paramString, paramLong1, paramLong2);
  }
  
  public static DriveId bi(String paramString)
  {
    jx.i(paramString);
    return new DriveId(paramString, -1L, -1L);
  }
  
  public static DriveId decodeFromString(String paramString)
  {
    jx.b(paramString.startsWith("DriveId:"), "Invalid DriveId: " + paramString);
    return f(Base64.decode(paramString.substring("DriveId:".length()), 10));
  }
  
  static DriveId f(byte[] paramArrayOfByte)
  {
    for (;;)
    {
      ak localak;
      try
      {
        localak = ak.g(paramArrayOfByte);
        if ("".equals(localak.QG))
        {
          str = null;
          return new DriveId(localak.versionCode, str, localak.QH, localak.QI);
        }
      }
      catch (qv localqv)
      {
        throw new IllegalArgumentException();
      }
      String str = localak.QG;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final String encodeToString()
  {
    if (this.Ow == null)
    {
      String str = Base64.encodeToString(iu(), 10);
      this.Ow = ("DriveId:" + str);
    }
    return this.Ow;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof DriveId)) {}
    DriveId localDriveId;
    do
    {
      return false;
      localDriveId = (DriveId)paramObject;
      if (localDriveId.Ov != this.Ov)
      {
        w.o("DriveId", "Attempt to compare invalid DriveId detected. Has local storage been cleared?");
        return false;
      }
      if ((localDriveId.Ou == -1L) && (this.Ou == -1L)) {
        return localDriveId.Ot.equals(this.Ot);
      }
    } while (localDriveId.Ou != this.Ou);
    return true;
  }
  
  public String getResourceId()
  {
    return this.Ot;
  }
  
  public int hashCode()
  {
    if (this.Ou == -1L) {
      return this.Ot.hashCode();
    }
    return (String.valueOf(this.Ov) + String.valueOf(this.Ou)).hashCode();
  }
  
  final byte[] iu()
  {
    ak localak = new ak();
    localak.versionCode = this.CK;
    if (this.Ot == null) {}
    for (String str = "";; str = this.Ot)
    {
      localak.QG = str;
      localak.QH = this.Ou;
      localak.QI = this.Ov;
      return qw.f(localak);
    }
  }
  
  public String toString()
  {
    return encodeToString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    c.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.DriveId
 * JD-Core Version:    0.7.0.1
 */