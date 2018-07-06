package com.google.android.gms.drive;

import android.content.IntentSender;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.i;
import com.google.android.gms.drive.internal.s;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.lh;

public class CreateFileActivityBuilder
{
  public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
  private final i Ol = new i(0);
  private DriveContents Om;
  private boolean On;
  
  public IntentSender build(GoogleApiClient paramGoogleApiClient)
  {
    jx.b(Boolean.valueOf(this.On), "Must call setInitialDriveContents to CreateFileActivityBuilder.");
    if ((paramGoogleApiClient.a(Drive.SCOPE_FILE)) || (paramGoogleApiClient.a(Drive.Oo))) {}
    for (boolean bool = true;; bool = false)
    {
      jx.b(bool, "The apiClient must have suitable scope to create files");
      if (this.Om != null)
      {
        lh.a(this.Om.getParcelFileDescriptor());
        this.Om.is();
      }
      return this.Ol.build(paramGoogleApiClient);
    }
  }
  
  public CreateFileActivityBuilder setActivityStartFolder(DriveId paramDriveId)
  {
    this.Ol.a(paramDriveId);
    return this;
  }
  
  public CreateFileActivityBuilder setActivityTitle(String paramString)
  {
    this.Ol.bl(paramString);
    return this;
  }
  
  public CreateFileActivityBuilder setInitialDriveContents(DriveContents paramDriveContents)
  {
    if (paramDriveContents != null)
    {
      if (!(paramDriveContents instanceof s)) {
        throw new IllegalArgumentException("Only DriveContents obtained from the Drive API are accepted.");
      }
      if (paramDriveContents.getDriveId() != null) {
        throw new IllegalArgumentException("Only DriveContents obtained through DriveApi.newDriveContents are accepted for file creation.");
      }
      if (paramDriveContents.it()) {
        throw new IllegalArgumentException("DriveContents are already closed.");
      }
      this.Ol.bq(paramDriveContents.ir().getRequestId());
      this.Om = paramDriveContents;
    }
    for (;;)
    {
      this.On = true;
      return this;
      this.Ol.bq(1);
    }
  }
  
  public CreateFileActivityBuilder setInitialMetadata(MetadataChangeSet paramMetadataChangeSet)
  {
    this.Ol.a(paramMetadataChangeSet);
    return this;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.CreateFileActivityBuilder
 * JD-Core Version:    0.7.0.1
 */