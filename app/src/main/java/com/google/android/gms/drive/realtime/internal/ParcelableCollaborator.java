package com.google.android.gms.drive.realtime.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ParcelableCollaborator
  implements SafeParcelable
{
  public static final Parcelable.Creator<ParcelableCollaborator> CREATOR = new p();
  final int CK;
  final String OS;
  final boolean SH;
  final boolean SI;
  final String SJ;
  final String SK;
  final String SL;
  final String vZ;
  
  ParcelableCollaborator(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    this.CK = paramInt;
    this.SH = paramBoolean1;
    this.SI = paramBoolean2;
    this.vZ = paramString1;
    this.SJ = paramString2;
    this.OS = paramString3;
    this.SK = paramString4;
    this.SL = paramString5;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof ParcelableCollaborator)) {
      return false;
    }
    ParcelableCollaborator localParcelableCollaborator = (ParcelableCollaborator)paramObject;
    return this.vZ.equals(localParcelableCollaborator.vZ);
  }
  
  public int hashCode()
  {
    return this.vZ.hashCode();
  }
  
  public String toString()
  {
    return "Collaborator [isMe=" + this.SH + ", isAnonymous=" + this.SI + ", sessionId=" + this.vZ + ", userId=" + this.SJ + ", displayName=" + this.OS + ", color=" + this.SK + ", photoUrl=" + this.SL + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    p.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.realtime.internal.ParcelableCollaborator
 * JD-Core Version:    0.7.0.1
 */