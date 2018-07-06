package com.google.android.gms.drive.events;

import android.os.IBinder;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.internal.ah;
import com.google.android.gms.drive.internal.ah.a;
import com.google.android.gms.drive.internal.w;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.lh;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class CompletionEvent
  implements SafeParcelable, ResourceEvent
{
  public static final Parcelable.Creator<CompletionEvent> CREATOR = new b();
  public static final int STATUS_CANCELED = 3;
  public static final int STATUS_CONFLICT = 2;
  public static final int STATUS_FAILURE = 1;
  public static final int STATUS_SUCCESS;
  final int CK;
  final String DZ;
  final int FP;
  final ParcelFileDescriptor OY;
  final ParcelFileDescriptor OZ;
  final DriveId Oj;
  final MetadataBundle Pa;
  final List<String> Pb;
  final IBinder Pc;
  private boolean Pd = false;
  private boolean Pe = false;
  private boolean Pf = false;
  
  CompletionEvent(int paramInt1, DriveId paramDriveId, String paramString, ParcelFileDescriptor paramParcelFileDescriptor1, ParcelFileDescriptor paramParcelFileDescriptor2, MetadataBundle paramMetadataBundle, List<String> paramList, int paramInt2, IBinder paramIBinder)
  {
    this.CK = paramInt1;
    this.Oj = paramDriveId;
    this.DZ = paramString;
    this.OY = paramParcelFileDescriptor1;
    this.OZ = paramParcelFileDescriptor2;
    this.Pa = paramMetadataBundle;
    this.Pb = paramList;
    this.FP = paramInt2;
    this.Pc = paramIBinder;
  }
  
  private void M(boolean paramBoolean)
  {
    iC();
    this.Pf = true;
    lh.a(this.OY);
    lh.a(this.OZ);
    if (this.Pc == null)
    {
      StringBuilder localStringBuilder2 = new StringBuilder().append("No callback on ");
      if (paramBoolean) {}
      for (String str2 = "snooze";; str2 = "dismiss")
      {
        w.p("CompletionEvent", str2);
        return;
      }
    }
    StringBuilder localStringBuilder1;
    try
    {
      ah.a.aa(this.Pc).M(paramBoolean);
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localStringBuilder1 = new StringBuilder().append("RemoteException on ");
      if (!paramBoolean) {}
    }
    for (String str1 = "snooze";; str1 = "dismiss")
    {
      w.p("CompletionEvent", str1 + ": " + localRemoteException);
      return;
    }
  }
  
  private void iC()
  {
    if (this.Pf) {
      throw new IllegalStateException("Event has already been dismissed or snoozed.");
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void dismiss()
  {
    M(false);
  }
  
  public String getAccountName()
  {
    iC();
    return this.DZ;
  }
  
  public InputStream getBaseContentsInputStream()
  {
    iC();
    if (this.OY == null) {
      return null;
    }
    if (this.Pd) {
      throw new IllegalStateException("getBaseInputStream() can only be called once per CompletionEvent instance.");
    }
    this.Pd = true;
    return new FileInputStream(this.OY.getFileDescriptor());
  }
  
  public DriveId getDriveId()
  {
    iC();
    return this.Oj;
  }
  
  public InputStream getModifiedContentsInputStream()
  {
    iC();
    if (this.OZ == null) {
      return null;
    }
    if (this.Pe) {
      throw new IllegalStateException("getModifiedInputStream() can only be called once per CompletionEvent instance.");
    }
    this.Pe = true;
    return new FileInputStream(this.OZ.getFileDescriptor());
  }
  
  public MetadataChangeSet getModifiedMetadataChangeSet()
  {
    iC();
    if (this.Pa != null) {
      return new MetadataChangeSet(this.Pa);
    }
    return null;
  }
  
  public int getStatus()
  {
    iC();
    return this.FP;
  }
  
  public List<String> getTrackingTags()
  {
    iC();
    return new ArrayList(this.Pb);
  }
  
  public int getType()
  {
    return 2;
  }
  
  public void snooze()
  {
    M(true);
  }
  
  public String toString()
  {
    if (this.Pb == null) {}
    for (String str = "<null>";; str = "'" + TextUtils.join("','", this.Pb) + "'")
    {
      Locale localLocale = Locale.US;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = this.Oj;
      arrayOfObject[1] = Integer.valueOf(this.FP);
      arrayOfObject[2] = str;
      return String.format(localLocale, "CompletionEvent [id=%s, status=%s, trackingTag=%s]", arrayOfObject);
    }
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.events.CompletionEvent
 * JD-Core Version:    0.7.0.1
 */