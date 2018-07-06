package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.drive.CreateFileActivityBuilder;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveApi.DriveIdResult;
import com.google.android.gms.drive.DriveApi.MetadataBufferResult;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.OpenFileActivityBuilder;
import com.google.android.gms.drive.query.Query;
import java.util.List;

public class p
  implements DriveApi
{
  public PendingResult<DriveApi.DriveContentsResult> a(GoogleApiClient paramGoogleApiClient, final int paramInt)
  {
    paramGoogleApiClient.a(new b(paramGoogleApiClient)
    {
      protected void a(r paramAnonymousr)
        throws RemoteException
      {
        paramAnonymousr.iG().a(new CreateContentsRequest(paramInt), new p.h(this));
      }
    });
  }
  
  public PendingResult<Status> cancelPendingActions(GoogleApiClient paramGoogleApiClient, List<String> paramList)
  {
    return ((r)paramGoogleApiClient.a(Drive.DQ)).cancelPendingActions(paramGoogleApiClient, paramList);
  }
  
  public PendingResult<DriveApi.DriveIdResult> fetchDriveId(GoogleApiClient paramGoogleApiClient, final String paramString)
  {
    paramGoogleApiClient.a(new e(paramGoogleApiClient)
    {
      protected void a(r paramAnonymousr)
        throws RemoteException
      {
        paramAnonymousr.iG().a(new GetMetadataRequest(DriveId.bi(paramString)), new p.c(this));
      }
    });
  }
  
  public DriveFolder getAppFolder(GoogleApiClient paramGoogleApiClient)
  {
    if (!paramGoogleApiClient.isConnected()) {
      throw new IllegalStateException("Client must be connected");
    }
    DriveId localDriveId = ((r)paramGoogleApiClient.a(Drive.DQ)).iI();
    if (localDriveId != null) {
      return new v(localDriveId);
    }
    return null;
  }
  
  public DriveFile getFile(GoogleApiClient paramGoogleApiClient, DriveId paramDriveId)
  {
    if (paramDriveId == null) {
      throw new IllegalArgumentException("Id must be provided.");
    }
    if (!paramGoogleApiClient.isConnected()) {
      throw new IllegalStateException("Client must be connected");
    }
    return new t(paramDriveId);
  }
  
  public DriveFolder getFolder(GoogleApiClient paramGoogleApiClient, DriveId paramDriveId)
  {
    if (paramDriveId == null) {
      throw new IllegalArgumentException("Id must be provided.");
    }
    if (!paramGoogleApiClient.isConnected()) {
      throw new IllegalStateException("Client must be connected");
    }
    return new v(paramDriveId);
  }
  
  public DriveFolder getRootFolder(GoogleApiClient paramGoogleApiClient)
  {
    if (!paramGoogleApiClient.isConnected()) {
      throw new IllegalStateException("Client must be connected");
    }
    return new v(((r)paramGoogleApiClient.a(Drive.DQ)).iH());
  }
  
  public CreateFileActivityBuilder newCreateFileActivityBuilder()
  {
    return new CreateFileActivityBuilder();
  }
  
  public PendingResult<DriveApi.DriveContentsResult> newDriveContents(GoogleApiClient paramGoogleApiClient)
  {
    return a(paramGoogleApiClient, 536870912);
  }
  
  public OpenFileActivityBuilder newOpenFileActivityBuilder()
  {
    return new OpenFileActivityBuilder();
  }
  
  public PendingResult<DriveApi.MetadataBufferResult> query(GoogleApiClient paramGoogleApiClient, final Query paramQuery)
  {
    if (paramQuery == null) {
      throw new IllegalArgumentException("Query must be provided.");
    }
    paramGoogleApiClient.a(new g(paramGoogleApiClient)
    {
      protected void a(r paramAnonymousr)
        throws RemoteException
      {
        paramAnonymousr.iG().a(new QueryRequest(paramQuery), new p.i(this));
      }
    });
  }
  
  public PendingResult<Status> requestSync(GoogleApiClient paramGoogleApiClient)
  {
    paramGoogleApiClient.b(new q.a(paramGoogleApiClient)
    {
      protected void a(r paramAnonymousr)
        throws RemoteException
      {
        paramAnonymousr.iG().a(new bg(this));
      }
    });
  }
  
  static class a
    implements DriveApi.DriveContentsResult
  {
    private final Status Eb;
    private final DriveContents Om;
    
    public a(Status paramStatus, DriveContents paramDriveContents)
    {
      this.Eb = paramStatus;
      this.Om = paramDriveContents;
    }
    
    public DriveContents getDriveContents()
    {
      return this.Om;
    }
    
    public Status getStatus()
    {
      return this.Eb;
    }
  }
  
  static abstract class b
    extends q<DriveApi.DriveContentsResult>
  {
    b(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public DriveApi.DriveContentsResult o(Status paramStatus)
    {
      return new p.a(paramStatus, null);
    }
  }
  
  static class c
    extends c
  {
    private final BaseImplementation.b<DriveApi.DriveIdResult> Ea;
    
    public c(BaseImplementation.b<DriveApi.DriveIdResult> paramb)
    {
      this.Ea = paramb;
    }
    
    public void a(OnDriveIdResponse paramOnDriveIdResponse)
      throws RemoteException
    {
      this.Ea.b(new p.d(Status.Kw, paramOnDriveIdResponse.getDriveId()));
    }
    
    public void a(OnMetadataResponse paramOnMetadataResponse)
      throws RemoteException
    {
      this.Ea.b(new p.d(Status.Kw, new m(paramOnMetadataResponse.iU()).getDriveId()));
    }
    
    public void n(Status paramStatus)
      throws RemoteException
    {
      this.Ea.b(new p.d(paramStatus, null));
    }
  }
  
  private static class d
    implements DriveApi.DriveIdResult
  {
    private final Status Eb;
    private final DriveId Oj;
    
    public d(Status paramStatus, DriveId paramDriveId)
    {
      this.Eb = paramStatus;
      this.Oj = paramDriveId;
    }
    
    public DriveId getDriveId()
    {
      return this.Oj;
    }
    
    public Status getStatus()
    {
      return this.Eb;
    }
  }
  
  static abstract class e
    extends q<DriveApi.DriveIdResult>
  {
    e(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public DriveApi.DriveIdResult p(Status paramStatus)
    {
      return new p.d(paramStatus, null);
    }
  }
  
  static class f
    implements DriveApi.MetadataBufferResult
  {
    private final Status Eb;
    private final MetadataBuffer PI;
    private final boolean PJ;
    
    public f(Status paramStatus, MetadataBuffer paramMetadataBuffer, boolean paramBoolean)
    {
      this.Eb = paramStatus;
      this.PI = paramMetadataBuffer;
      this.PJ = paramBoolean;
    }
    
    public MetadataBuffer getMetadataBuffer()
    {
      return this.PI;
    }
    
    public Status getStatus()
    {
      return this.Eb;
    }
  }
  
  static abstract class g
    extends q<DriveApi.MetadataBufferResult>
  {
    g(GoogleApiClient paramGoogleApiClient)
    {
      super();
    }
    
    public DriveApi.MetadataBufferResult q(Status paramStatus)
    {
      return new p.f(paramStatus, null, false);
    }
  }
  
  private static class h
    extends c
  {
    private final BaseImplementation.b<DriveApi.DriveContentsResult> Ea;
    
    public h(BaseImplementation.b<DriveApi.DriveContentsResult> paramb)
    {
      this.Ea = paramb;
    }
    
    public void a(OnContentsResponse paramOnContentsResponse)
      throws RemoteException
    {
      this.Ea.b(new p.a(Status.Kw, new s(paramOnContentsResponse.iL())));
    }
    
    public void n(Status paramStatus)
      throws RemoteException
    {
      this.Ea.b(new p.a(paramStatus, null));
    }
  }
  
  private static class i
    extends c
  {
    private final BaseImplementation.b<DriveApi.MetadataBufferResult> Ea;
    
    public i(BaseImplementation.b<DriveApi.MetadataBufferResult> paramb)
    {
      this.Ea = paramb;
    }
    
    public void a(OnListEntriesResponse paramOnListEntriesResponse)
      throws RemoteException
    {
      MetadataBuffer localMetadataBuffer = new MetadataBuffer(paramOnListEntriesResponse.iR(), null);
      this.Ea.b(new p.f(Status.Kw, localMetadataBuffer, paramOnListEntriesResponse.iS()));
    }
    
    public void n(Status paramStatus)
      throws RemoteException
    {
      this.Ea.b(new p.f(paramStatus, null, false));
    }
  }
  
  static class j
    extends q.a
  {
    j(GoogleApiClient paramGoogleApiClient, Status paramStatus)
    {
      super();
      b(paramStatus);
    }
    
    protected void a(r paramr) {}
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.p
 * JD-Core Version:    0.7.0.1
 */