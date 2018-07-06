package com.google.android.gms.drive.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.ChangeListener;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.CompletionListener;
import com.google.android.gms.drive.events.DriveEvent;
import com.google.android.gms.drive.events.c;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.List;

public class aa
  extends ag.a
{
  private final int Pm;
  private final c Qw;
  private final a Qx;
  private final List<Integer> Qy = new ArrayList();
  
  public aa(Looper paramLooper, Context paramContext, int paramInt, c paramc)
  {
    this.Pm = paramInt;
    this.Qw = paramc;
    this.Qx = new a(paramLooper, paramContext, null);
  }
  
  public void bw(int paramInt)
  {
    this.Qy.add(Integer.valueOf(paramInt));
  }
  
  public boolean bx(int paramInt)
  {
    return this.Qy.contains(Integer.valueOf(paramInt));
  }
  
  public void c(OnEventResponse paramOnEventResponse)
    throws RemoteException
  {
    DriveEvent localDriveEvent = paramOnEventResponse.iQ();
    if (this.Pm == localDriveEvent.getType()) {}
    for (boolean bool = true;; bool = false)
    {
      jx.K(bool);
      jx.K(this.Qy.contains(Integer.valueOf(localDriveEvent.getType())));
      this.Qx.a(this.Qw, localDriveEvent);
      return;
    }
  }
  
  private static class a
    extends Handler
  {
    private final Context mContext;
    
    private a(Looper paramLooper, Context paramContext)
    {
      super();
      this.mContext = paramContext;
    }
    
    public void a(c paramc, DriveEvent paramDriveEvent)
    {
      sendMessage(obtainMessage(1, new Pair(paramc, paramDriveEvent)));
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      default: 
        w.e(this.mContext, "EventCallback", "Don't know how to handle this event");
        return;
      }
      Pair localPair = (Pair)paramMessage.obj;
      c localc = (c)localPair.first;
      DriveEvent localDriveEvent = (DriveEvent)localPair.second;
      switch (localDriveEvent.getType())
      {
      default: 
        w.o("EventCallback", "Unexpected event: " + localDriveEvent);
        return;
      case 1: 
        ((ChangeListener)localc).onChange((ChangeEvent)localDriveEvent);
        return;
      }
      ((CompletionListener)localc).onCompletion((CompletionEvent)localDriveEvent);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.aa
 * JD-Core Version:    0.7.0.1
 */