package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.jx;

public class i
{
  private String OH;
  private DriveId OJ;
  protected MetadataChangeSet Pu;
  private Integer Pv;
  private final int Pw;
  
  public i(int paramInt)
  {
    this.Pw = paramInt;
  }
  
  public void a(DriveId paramDriveId)
  {
    this.OJ = ((DriveId)jx.i(paramDriveId));
  }
  
  public void a(MetadataChangeSet paramMetadataChangeSet)
  {
    this.Pu = ((MetadataChangeSet)jx.i(paramMetadataChangeSet));
  }
  
  public void bl(String paramString)
  {
    this.OH = ((String)jx.i(paramString));
  }
  
  public void bq(int paramInt)
  {
    this.Pv = Integer.valueOf(paramInt);
  }
  
  public IntentSender build(GoogleApiClient paramGoogleApiClient)
  {
    jx.b(this.Pu, "Must provide initial metadata to CreateFileActivityBuilder.");
    jx.a(paramGoogleApiClient.isConnected(), "Client must be connected");
    r localr = (r)paramGoogleApiClient.a(Drive.DQ);
    this.Pu.iz().setContext(localr.getContext());
    if (this.Pv == null) {}
    for (int i = -1;; i = this.Pv.intValue()) {
      try
      {
        IntentSender localIntentSender = localr.iG().a(new CreateFileIntentSenderRequest(this.Pu.iz(), i, this.OH, this.OJ, this.Pw));
        return localIntentSender;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException("Unable to connect Drive Play Service", localRemoteException);
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.i
 * JD-Core Version:    0.7.0.1
 */