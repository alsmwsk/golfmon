package com.google.android.gms.drive;

import android.content.IntentSender;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.ae;
import com.google.android.gms.drive.internal.r;
import com.google.android.gms.internal.jx;

public class OpenFileActivityBuilder
{
  public static final String EXTRA_RESPONSE_DRIVE_ID = "response_drive_id";
  private String OH;
  private String[] OI;
  private DriveId OJ;
  
  public IntentSender build(GoogleApiClient paramGoogleApiClient)
  {
    jx.a(paramGoogleApiClient.isConnected(), "Client must be connected");
    if (this.OI == null) {
      this.OI = new String[0];
    }
    try
    {
      IntentSender localIntentSender = ((r)paramGoogleApiClient.a(Drive.DQ)).iG().a(new OpenFileIntentSenderRequest(this.OH, this.OI, this.OJ));
      return localIntentSender;
    }
    catch (RemoteException localRemoteException)
    {
      throw new RuntimeException("Unable to connect Drive Play Service", localRemoteException);
    }
  }
  
  public OpenFileActivityBuilder setActivityStartFolder(DriveId paramDriveId)
  {
    this.OJ = ((DriveId)jx.i(paramDriveId));
    return this;
  }
  
  public OpenFileActivityBuilder setActivityTitle(String paramString)
  {
    this.OH = ((String)jx.i(paramString));
    return this;
  }
  
  public OpenFileActivityBuilder setMimeType(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null) {}
    for (boolean bool = true;; bool = false)
    {
      jx.b(bool, "mimeTypes may not be null");
      this.OI = paramArrayOfString;
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.OpenFileActivityBuilder
 * JD-Core Version:    0.7.0.1
 */