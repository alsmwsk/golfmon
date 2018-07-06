package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveFolder.DriveFileResult;
import com.google.android.gms.drive.DriveFolder.DriveFolderResult;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.ExecutionOptions.Builder;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.drive.query.Filters;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.drive.query.Query.Builder;
import com.google.android.gms.drive.query.SearchableField;

public class v
  extends y
  implements DriveFolder
{
  public v(DriveId paramDriveId)
  {
    super(paramDriveId);
  }
  
  private PendingResult<DriveFolder.DriveFileResult> a(GoogleApiClient paramGoogleApiClient, final MetadataChangeSet paramMetadataChangeSet, final int paramInt1, final int paramInt2, final ExecutionOptions paramExecutionOptions)
  {
    ExecutionOptions.a(paramGoogleApiClient, paramExecutionOptions);
    paramGoogleApiClient.b(new d(paramGoogleApiClient)
    {
      protected void a(r paramAnonymousr)
        throws RemoteException
      {
        paramMetadataChangeSet.iz().setContext(paramAnonymousr.getContext());
        CreateFileRequest localCreateFileRequest = new CreateFileRequest(v.this.getDriveId(), paramMetadataChangeSet.iz(), paramInt1, paramInt2, paramExecutionOptions);
        paramAnonymousr.iG().a(localCreateFileRequest, new v.a(this));
      }
    });
  }
  
  private PendingResult<DriveFolder.DriveFileResult> a(GoogleApiClient paramGoogleApiClient, MetadataChangeSet paramMetadataChangeSet, DriveContents paramDriveContents, ExecutionOptions paramExecutionOptions)
  {
    int i;
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
      i = paramDriveContents.ir().getRequestId();
      paramDriveContents.is();
    }
    while (paramMetadataChangeSet == null)
    {
      throw new IllegalArgumentException("MetadataChangeSet must be provided.");
      i = 1;
    }
    if ("application/vnd.google-apps.folder".equals(paramMetadataChangeSet.getMimeType())) {
      throw new IllegalArgumentException("May not create folders (mimetype: application/vnd.google-apps.folder) using this method. Use DriveFolder.createFolder() instead.");
    }
    return a(paramGoogleApiClient, paramMetadataChangeSet, i, 0, paramExecutionOptions);
  }
  
  public PendingResult<DriveFolder.DriveFileResult> createFile(GoogleApiClient paramGoogleApiClient, MetadataChangeSet paramMetadataChangeSet, DriveContents paramDriveContents)
  {
    return createFile(paramGoogleApiClient, paramMetadataChangeSet, paramDriveContents, null);
  }
  
  public PendingResult<DriveFolder.DriveFileResult> createFile(GoogleApiClient paramGoogleApiClient, MetadataChangeSet paramMetadataChangeSet, DriveContents paramDriveContents, ExecutionOptions paramExecutionOptions)
  {
    if (paramExecutionOptions == null) {
      paramExecutionOptions = new ExecutionOptions.Builder().build();
    }
    if (paramExecutionOptions.ix() != 0) {
      throw new IllegalStateException("May not set a conflict strategy for calls to createFile.");
    }
    return a(paramGoogleApiClient, paramMetadataChangeSet, paramDriveContents, paramExecutionOptions);
  }
  
  public PendingResult<DriveFolder.DriveFolderResult> createFolder(GoogleApiClient paramGoogleApiClient, final MetadataChangeSet paramMetadataChangeSet)
  {
    if (paramMetadataChangeSet == null) {
      throw new IllegalArgumentException("MetadataChangeSet must be provided.");
    }
    if ((paramMetadataChangeSet.getMimeType() != null) && (!paramMetadataChangeSet.getMimeType().equals("application/vnd.google-apps.folder"))) {
      throw new IllegalArgumentException("The mimetype must be of type application/vnd.google-apps.folder");
    }
    paramGoogleApiClient.b(new f(paramGoogleApiClient)
    {
      protected void a(r paramAnonymousr)
        throws RemoteException
      {
        paramMetadataChangeSet.iz().setContext(paramAnonymousr.getContext());
        paramAnonymousr.iG().a(new CreateFolderRequest(v.this.getDriveId(), paramMetadataChangeSet.iz()), new v.b(this));
      }
    });
  }
  
  public PendingResult<DriveApi.MetadataBufferResult> listChildren(GoogleApiClient paramGoogleApiClient)
  {
    return queryChildren(paramGoogleApiClient, null);
  }
  
  public PendingResult<DriveApi.MetadataBufferResult> queryChildren(GoogleApiClient paramGoogleApiClient, Query paramQuery)
  {
    Query.Builder localBuilder = new Query.Builder().addFilter(Filters.in(SearchableField.PARENTS, getDriveId()));
    if (paramQuery != null)
    {
      if (paramQuery.getFilter() != null) {
        localBuilder.addFilter(paramQuery.getFilter());
      }
      localBuilder.setPageToken(paramQuery.getPageToken());
      localBuilder.setSortOrder(paramQuery.getSortOrder());
    }
    return new p().query(paramGoogleApiClient, localBuilder.build());
  }
  
  private static class a
    extends c
  {
    private final BaseImplementation.b<DriveFolder.DriveFileResult> Ea;
    
    public a(BaseImplementation.b<DriveFolder.DriveFileResult> paramb)
    {
      this.Ea = paramb;
    }
    
    public void a(OnDriveIdResponse paramOnDriveIdResponse)
      throws RemoteException
    {
      this.Ea.b(new v.c(Status.Kw, new t(paramOnDriveIdResponse.getDriveId())));
    }
    
    public void n(Status paramStatus)
      throws RemoteException
    {
      this.Ea.b(new v.c(paramStatus, null));
    }
  }
  
  private static class b
    extends c
  {
    private final BaseImplementation.b<DriveFolder.DriveFolderResult> Ea;
    
    public b(BaseImplementation.b<DriveFolder.DriveFolderResult> paramb)
    {
      this.Ea = paramb;
    }
    
    public void a(OnDriveIdResponse paramOnDriveIdResponse)
      throws RemoteException
    {
      this.Ea.b(new v.e(Status.Kw, new v(paramOnDriveIdResponse.getDriveId())));
    }
    
    public void n(Status paramStatus)
      throws RemoteException
    {
      this.Ea.b(new v.e(paramStatus, null));
    }
  }
  
  private static class c
    implements DriveFolder.DriveFileResult
  {
    private final Status Eb;
    private final DriveFile Qn;
    
    public c(Status paramStatus, DriveFile paramDriveFile)
    {
      this.Eb = paramStatus;
      this.Qn = paramDriveFile;
    }
    
    public DriveFile getDriveFile()
    {
      return this.Qn;
    }
    
    public Status getStatus()
    {
      return this.Eb;
    }
  }
  
  static abstract class d
    extends q<DriveFolder.DriveFileResult>
  {
    d(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public DriveFolder.DriveFileResult r(Status paramStatus)
    {
      return new v.c(paramStatus, null);
    }
  }
  
  private static class e
    implements DriveFolder.DriveFolderResult
  {
    private final Status Eb;
    private final DriveFolder Qo;
    
    public e(Status paramStatus, DriveFolder paramDriveFolder)
    {
      this.Eb = paramStatus;
      this.Qo = paramDriveFolder;
    }
    
    public DriveFolder getDriveFolder()
    {
      return this.Qo;
    }
    
    public Status getStatus()
    {
      return this.Eb;
    }
  }
  
  static abstract class f
    extends q<DriveFolder.DriveFolderResult>
  {
    f(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public DriveFolder.DriveFolderResult s(Status paramStatus)
    {
      return new v.e(paramStatus, null);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.v
 * JD-Core Version:    0.7.0.1
 */