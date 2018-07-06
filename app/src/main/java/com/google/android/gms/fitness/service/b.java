package com.google.android.gms.fitness.service;

import android.os.RemoteException;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.k;
import com.google.android.gms.internal.jx;
import java.util.Iterator;
import java.util.List;

class b
  implements SensorEventDispatcher
{
  private final k VW;
  
  b(k paramk)
  {
    this.VW = ((k)jx.i(paramk));
  }
  
  public void publish(DataPoint paramDataPoint)
    throws RemoteException
  {
    this.VW.c(paramDataPoint);
  }
  
  public void publish(List<DataPoint> paramList)
    throws RemoteException
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      publish((DataPoint)localIterator.next());
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.service.b
 * JD-Core Version:    0.7.0.1
 */