package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ov
  implements SafeParcelable
{
  public static final ow CREATOR = new ow();
  public final int ang;
  public final int anh;
  public final String ani;
  public final String anj;
  public final boolean ank;
  public final String anl;
  public final String packageName;
  public final int versionCode;
  
  public ov(int paramInt1, String paramString1, int paramInt2, int paramInt3, String paramString2, String paramString3, boolean paramBoolean, String paramString4)
  {
    this.versionCode = paramInt1;
    this.packageName = paramString1;
    this.ang = paramInt2;
    this.anh = paramInt3;
    this.ani = paramString2;
    this.anj = paramString3;
    this.ank = paramBoolean;
    this.anl = paramString4;
  }
  
  @Deprecated
  public ov(String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.versionCode = 1;
    this.packageName = ((String)jx.i(paramString1));
    this.ang = paramInt1;
    this.anh = paramInt2;
    this.anl = null;
    this.ani = paramString2;
    this.anj = paramString3;
    this.ank = paramBoolean;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    ov localov;
    do
    {
      return true;
      if (!(paramObject instanceof ov)) {
        break;
      }
      localov = (ov)paramObject;
    } while ((this.packageName.equals(localov.packageName)) && (this.ang == localov.ang) && (this.anh == localov.anh) && (jv.equal(this.anl, localov.anl)) && (jv.equal(this.ani, localov.ani)) && (jv.equal(this.anj, localov.anj)) && (this.ank == localov.ank));
    return false;
    return false;
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = this.packageName;
    arrayOfObject[1] = Integer.valueOf(this.ang);
    arrayOfObject[2] = Integer.valueOf(this.anh);
    arrayOfObject[3] = this.ani;
    arrayOfObject[4] = this.anj;
    arrayOfObject[5] = Boolean.valueOf(this.ank);
    return jv.hashCode(arrayOfObject);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlayLoggerContext[");
    localStringBuilder.append("package=").append(this.packageName).append(',');
    localStringBuilder.append("versionCode=").append(this.versionCode).append(',');
    localStringBuilder.append("logSource=").append(this.anh).append(',');
    localStringBuilder.append("logSourceName=").append(this.anl).append(',');
    localStringBuilder.append("uploadAccount=").append(this.ani).append(',');
    localStringBuilder.append("loggingId=").append(this.anj).append(',');
    localStringBuilder.append("logAndroidId=").append(this.ank);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ow.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ov
 * JD-Core Version:    0.7.0.1
 */