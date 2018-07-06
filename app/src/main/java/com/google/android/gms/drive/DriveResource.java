package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.events.ChangeListener;
import java.util.Set;

public abstract interface DriveResource
{
  public abstract PendingResult<Status> addChangeListener(GoogleApiClient paramGoogleApiClient, ChangeListener paramChangeListener);
  
  public abstract PendingResult<Status> addChangeSubscription(GoogleApiClient paramGoogleApiClient);
  
  public abstract DriveId getDriveId();
  
  public abstract PendingResult<MetadataResult> getMetadata(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<DriveApi.MetadataBufferResult> listParents(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<Status> removeChangeListener(GoogleApiClient paramGoogleApiClient, ChangeListener paramChangeListener);
  
  public abstract PendingResult<Status> removeChangeSubscription(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<Status> setParents(GoogleApiClient paramGoogleApiClient, Set<DriveId> paramSet);
  
  public abstract PendingResult<MetadataResult> updateMetadata(GoogleApiClient paramGoogleApiClient, MetadataChangeSet paramMetadataChangeSet);
  
  public static abstract interface MetadataResult
    extends Result
  {
    public abstract Metadata getMetadata();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.DriveResource
 * JD-Core Version:    0.7.0.1
 */