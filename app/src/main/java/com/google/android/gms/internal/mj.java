package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.HistoryApi;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.e.a;
import com.google.android.gms.fitness.result.DataReadResult;

public class mj
  implements HistoryApi
{
  public PendingResult<Status> deleteData(GoogleApiClient paramGoogleApiClient, final DataDeleteRequest paramDataDeleteRequest)
  {
    paramGoogleApiClient.a(new lu.c(paramGoogleApiClient)
    {
      protected void a(lu paramAnonymouslu)
        throws RemoteException
      {
        lu.b localb = new lu.b(this);
        String str = paramAnonymouslu.getContext().getPackageName();
        paramAnonymouslu.jM().a(paramDataDeleteRequest, localb, str);
      }
    });
  }
  
  public PendingResult<Status> insertData(GoogleApiClient paramGoogleApiClient, final DataSet paramDataSet)
  {
    paramGoogleApiClient.a(new lu.c(paramGoogleApiClient)
    {
      protected void a(lu paramAnonymouslu)
        throws RemoteException
      {
        lu.b localb = new lu.b(this);
        String str = paramAnonymouslu.getContext().getPackageName();
        paramAnonymouslu.jM().a(new e.a().b(paramDataSet).jU(), localb, str);
      }
    });
  }
  
  public PendingResult<DataReadResult> readData(GoogleApiClient paramGoogleApiClient, final DataReadRequest paramDataReadRequest)
  {
    paramGoogleApiClient.a(new lu.a(paramGoogleApiClient)
    {
      protected void a(lu paramAnonymouslu)
        throws RemoteException
      {
        mj.a locala = new mj.a(this, null);
        String str = paramAnonymouslu.getContext().getPackageName();
        paramAnonymouslu.jM().a(paramDataReadRequest, locala, str);
      }
      
      protected DataReadResult x(Status paramAnonymousStatus)
      {
        return DataReadResult.a(paramAnonymousStatus, paramDataReadRequest);
      }
    });
  }
  
  private static class a
    extends lw.a
  {
    private final BaseImplementation.b<DataReadResult> Ea;
    private int Vi = 0;
    private DataReadResult Vj = null;
    
    private a(BaseImplementation.b<DataReadResult> paramb)
    {
      this.Ea = paramb;
    }
    
    /* Error */
    public void a(DataReadResult paramDataReadResult)
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: ldc 29
      //   4: ldc 31
      //   6: invokestatic 37	android/util/Log:v	(Ljava/lang/String;Ljava/lang/String;)I
      //   9: pop
      //   10: aload_0
      //   11: getfield 20	com/google/android/gms/internal/mj$a:Vj	Lcom/google/android/gms/fitness/result/DataReadResult;
      //   14: ifnonnull +48 -> 62
      //   17: aload_0
      //   18: aload_1
      //   19: putfield 20	com/google/android/gms/internal/mj$a:Vj	Lcom/google/android/gms/fitness/result/DataReadResult;
      //   22: aload_0
      //   23: iconst_1
      //   24: aload_0
      //   25: getfield 18	com/google/android/gms/internal/mj$a:Vi	I
      //   28: iadd
      //   29: putfield 18	com/google/android/gms/internal/mj$a:Vi	I
      //   32: aload_0
      //   33: getfield 18	com/google/android/gms/internal/mj$a:Vi	I
      //   36: aload_0
      //   37: getfield 20	com/google/android/gms/internal/mj$a:Vj	Lcom/google/android/gms/fitness/result/DataReadResult;
      //   40: invokevirtual 43	com/google/android/gms/fitness/result/DataReadResult:kr	()I
      //   43: if_icmpne +16 -> 59
      //   46: aload_0
      //   47: getfield 22	com/google/android/gms/internal/mj$a:Ea	Lcom/google/android/gms/common/api/BaseImplementation$b;
      //   50: aload_0
      //   51: getfield 20	com/google/android/gms/internal/mj$a:Vj	Lcom/google/android/gms/fitness/result/DataReadResult;
      //   54: invokeinterface 49 2 0
      //   59: aload_0
      //   60: monitorexit
      //   61: return
      //   62: aload_0
      //   63: getfield 20	com/google/android/gms/internal/mj$a:Vj	Lcom/google/android/gms/fitness/result/DataReadResult;
      //   66: aload_1
      //   67: invokevirtual 51	com/google/android/gms/fitness/result/DataReadResult:b	(Lcom/google/android/gms/fitness/result/DataReadResult;)V
      //   70: goto -48 -> 22
      //   73: astore_2
      //   74: aload_0
      //   75: monitorexit
      //   76: aload_2
      //   77: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	78	0	this	a
      //   0	78	1	paramDataReadResult	DataReadResult
      //   73	4	2	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	22	73	finally
      //   22	59	73	finally
      //   59	61	73	finally
      //   62	70	73	finally
      //   74	76	73	finally
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.mj
 * JD-Core Version:    0.7.0.1
 */