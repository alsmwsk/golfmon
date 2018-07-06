package com.google.android.gms.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

public abstract interface DrivePreferencesApi
{
  public abstract PendingResult<FileUploadPreferencesResult> getFileUploadPreferences(GoogleApiClient paramGoogleApiClient);
  
  public abstract PendingResult<Status> setFileUploadPreferences(GoogleApiClient paramGoogleApiClient, FileUploadPreferences paramFileUploadPreferences);
  
  public static abstract interface FileUploadPreferencesResult
    extends Result
  {
    public abstract FileUploadPreferences getFileUploadPreferences();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.DrivePreferencesApi
 * JD-Core Version:    0.7.0.1
 */