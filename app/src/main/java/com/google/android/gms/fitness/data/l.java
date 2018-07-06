package com.google.android.gms.fitness.data;

import android.os.RemoteException;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.internal.jx;
import java.util.HashMap;
import java.util.Map;

public class l
  extends k.a
{
  private final OnDataPointListener UF;
  
  private l(OnDataPointListener paramOnDataPointListener)
  {
    this.UF = ((OnDataPointListener)jx.i(paramOnDataPointListener));
  }
  
  public void c(DataPoint paramDataPoint)
    throws RemoteException
  {
    this.UF.onDataPoint(paramDataPoint);
  }
  
  public static class a
  {
    private static final a UG = new a();
    private final Map<OnDataPointListener, l> UH = new HashMap();
    
    public static a jG()
    {
      return UG;
    }
    
    public l a(OnDataPointListener paramOnDataPointListener)
    {
      synchronized (this.UH)
      {
        l locall = (l)this.UH.get(paramOnDataPointListener);
        if (locall == null)
        {
          locall = new l(paramOnDataPointListener, null);
          this.UH.put(paramOnDataPointListener, locall);
        }
        return locall;
      }
    }
    
    public l b(OnDataPointListener paramOnDataPointListener)
    {
      synchronized (this.UH)
      {
        l locall = (l)this.UH.get(paramOnDataPointListener);
        return locall;
      }
    }
    
    public l c(OnDataPointListener paramOnDataPointListener)
    {
      synchronized (this.UH)
      {
        l locall1 = (l)this.UH.remove(paramOnDataPointListener);
        if (locall1 != null) {
          return locall1;
        }
        l locall2 = new l(paramOnDataPointListener, null);
        return locall2;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.fitness.data.l
 * JD-Core Version:    0.7.0.1
 */