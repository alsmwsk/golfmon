package com.google.android.gms.drive.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.Status;

public class bg
  extends c
{
  private final BaseImplementation.b<Status> Ea;
  
  public bg(BaseImplementation.b<Status> paramb)
  {
    this.Ea = paramb;
  }
  
  public void n(Status paramStatus)
    throws RemoteException
  {
    this.Ea.b(paramStatus);
  }
  
  public void onSuccess()
    throws RemoteException
  {
    this.Ea.b(Status.Kw);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.bg
 * JD-Core Version:    0.7.0.1
 */