package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.d;
import com.google.android.gms.common.api.d.b;
import com.google.android.gms.drive.DriveApi.DriveContentsResult;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFile.DownloadProgressListener;
import com.google.android.gms.drive.DriveId;

public class t
  extends y
  implements DriveFile
{
  public t(DriveId paramDriveId)
  {
    super(paramDriveId);
  }
  
  private static DriveFile.DownloadProgressListener a(GoogleApiClient paramGoogleApiClient, DriveFile.DownloadProgressListener paramDownloadProgressListener)
  {
    if (paramDownloadProgressListener == null) {
      return null;
    }
    return new a(paramGoogleApiClient.d(paramDownloadProgressListener));
  }
  
  public PendingResult<DriveApi.DriveContentsResult> open(GoogleApiClient paramGoogleApiClient, final int paramInt, DriveFile.DownloadProgressListener paramDownloadProgressListener)
  {
    if ((paramInt != 268435456) && (paramInt != 536870912) && (paramInt != 805306368)) {
      throw new IllegalArgumentException("Invalid mode provided.");
    }
    paramGoogleApiClient.a(new p.b(paramGoogleApiClient)
    {
      protected void a(r paramAnonymousr)
        throws RemoteException
      {
        paramAnonymousr.iG().a(new OpenContentsRequest(t.this.getDriveId(), paramInt, 0), new az(this, this.Qc));
      }
    });
  }
  
  private static class a
    implements DriveFile.DownloadProgressListener
  {
    private final d<DriveFile.DownloadProgressListener> Qe;
    
    public a(d<DriveFile.DownloadProgressListener> paramd)
    {
      this.Qe = paramd;
    }
    
    public void onProgress(final long paramLong1, long paramLong2)
    {
      this.Qe.a(new d.b()
      {
        public void a(DriveFile.DownloadProgressListener paramAnonymousDownloadProgressListener)
        {
          paramAnonymousDownloadProgressListener.onProgress(paramLong1, this.Qg);
        }
        
        public void gG() {}
      });
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.t
 * JD-Core Version:    0.7.0.1
 */