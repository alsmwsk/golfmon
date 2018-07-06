package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.drive.query.Query;

public abstract interface DriveFolder
  extends DriveResource
{
  public static final String MIME_TYPE = "application/vnd.google-apps.folder";
  
  public abstract PendingResult<DriveFileResult> createFile(GoogleApiClient paramGoogleApiClient, MetadataChangeSet paramMetadataChangeSet, DriveContents paramDriveContents);
  
  public abstract PendingResult<DriveFileResult> createFile(GoogleApiClient paramGoogleApiClient, MetadataChangeSet paramMetadataChangeSet, DriveContents paramDriveContents, ExecutionOptions paramExecutionOptions);
  
  public abstract PendingResult<DriveFolderResult> createFolder(GoogleApiClient paramGoogleApiClient, MetadataChangeSet paramMetadataChangeSet);
  
  public abstract PendingResult<DriveApi.MetadataBufferResult> listChildren(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<DriveApi.MetadataBufferResult> queryChildren(GoogleApiClient paramGoogleApiClient, Query paramQuery);
  
  public static abstract interface DriveFileResult
    extends Result
  {
    public abstract DriveFile getDriveFile();
  }
  
  public static abstract interface DriveFolderResult
    extends Result
  {
    public abstract DriveFolder getDriveFolder();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.DriveFolder
 * JD-Core Version:    0.7.0.1
 */