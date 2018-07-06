package com.google.android.gms.drive;

import android.os.ParcelFileDescriptor;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import java.io.InputStream;
import java.io.OutputStream;

public abstract interface DriveContents
{
  public abstract PendingResult<Status> commit(GoogleApiClient paramGoogleApiClient, MetadataChangeSet paramMetadataChangeSet);
  
  public abstract PendingResult<Status> commit(GoogleApiClient paramGoogleApiClient, MetadataChangeSet paramMetadataChangeSet, ExecutionOptions paramExecutionOptions);
  
  public abstract void discard(GoogleApiClient paramGoogleApiClient);
  
  public abstract DriveId getDriveId();
  
  public abstract InputStream getInputStream();
  
  public abstract int getMode();
  
  public abstract OutputStream getOutputStream();
  
  public abstract ParcelFileDescriptor getParcelFileDescriptor();
  
  public abstract Contents ir();
  
  public abstract void is();
  
  public abstract boolean it();
  
  public abstract PendingResult<DriveApi.DriveContentsResult> reopenForWrite(GoogleApiClient paramGoogleApiClient);
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.DriveContents
 * JD-Core Version:    0.7.0.1
 */