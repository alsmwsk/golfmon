package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.api.BaseImplementation.b;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.DataApi.DataItemResult;
import com.google.android.gms.wearable.DataApi.DeleteDataItemsResult;
import com.google.android.gms.wearable.DataApi.GetFdForAssetResult;
import com.google.android.gms.wearable.DataItemBuffer;
import com.google.android.gms.wearable.MessageApi.SendMessageResult;
import com.google.android.gms.wearable.NodeApi.GetConnectedNodesResult;
import com.google.android.gms.wearable.NodeApi.GetLocalNodeResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.FutureTask;

final class az
{
  static abstract class a<T>
    extends a
  {
    private BaseImplementation.b<T> DA;
    
    public a(BaseImplementation.b<T> paramb)
    {
      this.DA = paramb;
    }
    
    public void A(T paramT)
    {
      BaseImplementation.b localb = this.DA;
      if (localb != null)
      {
        localb.b(paramT);
        this.DA = null;
      }
    }
  }
  
  static final class b
    extends az.a<DataApi.DeleteDataItemsResult>
  {
    public b(BaseImplementation.b<DataApi.DeleteDataItemsResult> paramb)
    {
      super();
    }
    
    public void a(p paramp)
    {
      A(new f.c(av.gN(paramp.statusCode), paramp.axI));
    }
  }
  
  static final class c
    extends az.a<NodeApi.GetConnectedNodesResult>
  {
    public c(BaseImplementation.b<NodeApi.GetConnectedNodesResult> paramb)
    {
      super();
    }
    
    public void a(v paramv)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(paramv.axL);
      A(new ak.b(av.gN(paramv.statusCode), localArrayList));
    }
  }
  
  static final class d
    extends az.a<DataApi.DataItemResult>
  {
    public d(BaseImplementation.b<DataApi.DataItemResult> paramb)
    {
      super();
    }
    
    public void a(x paramx)
    {
      A(new f.b(av.gN(paramx.statusCode), paramx.axM));
    }
  }
  
  static final class e
    extends az.a<DataItemBuffer>
  {
    public e(BaseImplementation.b<DataItemBuffer> paramb)
    {
      super();
    }
    
    public void ab(DataHolder paramDataHolder)
    {
      A(new DataItemBuffer(paramDataHolder));
    }
  }
  
  static final class f
    extends az.a<DataApi.GetFdForAssetResult>
  {
    public f(BaseImplementation.b<DataApi.GetFdForAssetResult> paramb)
    {
      super();
    }
    
    public void a(z paramz)
    {
      A(new f.d(av.gN(paramz.statusCode), paramz.axN));
    }
  }
  
  static final class g
    extends az.a<NodeApi.GetLocalNodeResult>
  {
    public g(BaseImplementation.b<NodeApi.GetLocalNodeResult> paramb)
    {
      super();
    }
    
    public void a(ab paramab)
    {
      A(new ak.c(av.gN(paramab.statusCode), paramab.axO));
    }
  }
  
  static final class h
    extends a
  {
    public void a(Status paramStatus) {}
  }
  
  static final class i
    extends az.a<DataApi.DataItemResult>
  {
    private final List<FutureTask<Boolean>> ayf;
    
    i(BaseImplementation.b<DataApi.DataItemResult> paramb, List<FutureTask<Boolean>> paramList)
    {
      super();
      this.ayf = paramList;
    }
    
    public void a(ap paramap)
    {
      A(new f.b(av.gN(paramap.statusCode), paramap.axM));
      if (paramap.statusCode != 0)
      {
        Iterator localIterator = this.ayf.iterator();
        while (localIterator.hasNext()) {
          ((FutureTask)localIterator.next()).cancel(true);
        }
      }
    }
  }
  
  static final class j
    extends az.a<MessageApi.SendMessageResult>
  {
    public j(BaseImplementation.b<MessageApi.SendMessageResult> paramb)
    {
      super();
    }
    
    public void a(at paramat)
    {
      A(new ah.b(av.gN(paramat.statusCode), paramat.ayd));
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wearable.internal.az
 * JD-Core Version:    0.7.0.1
 */