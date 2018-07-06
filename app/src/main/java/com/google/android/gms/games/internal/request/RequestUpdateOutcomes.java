package com.google.android.gms.games.internal.request;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.RequestUpdateResultOutcome;
import com.google.android.gms.internal.jx;
import java.util.HashMap;
import java.util.Set;

public final class RequestUpdateOutcomes
{
  private static final String[] adl = { "requestId", "outcome" };
  private final int Iv;
  private final HashMap<String, Integer> adm;
  
  private RequestUpdateOutcomes(int paramInt, HashMap<String, Integer> paramHashMap)
  {
    this.Iv = paramInt;
    this.adm = paramHashMap;
  }
  
  public static RequestUpdateOutcomes W(DataHolder paramDataHolder)
  {
    Builder localBuilder = new Builder();
    localBuilder.ek(paramDataHolder.getStatusCode());
    int i = paramDataHolder.getCount();
    for (int j = 0; j < i; j++)
    {
      int k = paramDataHolder.au(j);
      localBuilder.z(paramDataHolder.c("requestId", j, k), paramDataHolder.b("outcome", j, k));
    }
    return localBuilder.mF();
  }
  
  public Set<String> getRequestIds()
  {
    return this.adm.keySet();
  }
  
  public int getRequestOutcome(String paramString)
  {
    jx.b(this.adm.containsKey(paramString), "Request " + paramString + " was not part of the update operation!");
    return ((Integer)this.adm.get(paramString)).intValue();
  }
  
  public static final class Builder
  {
    private int Iv = 0;
    private HashMap<String, Integer> adm = new HashMap();
    
    public Builder ek(int paramInt)
    {
      this.Iv = paramInt;
      return this;
    }
    
    public RequestUpdateOutcomes mF()
    {
      return new RequestUpdateOutcomes(this.Iv, this.adm, null);
    }
    
    public Builder z(String paramString, int paramInt)
    {
      if (RequestUpdateResultOutcome.isValid(paramInt)) {
        this.adm.put(paramString, Integer.valueOf(paramInt));
      }
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.request.RequestUpdateOutcomes
 * JD-Core Version:    0.7.0.1
 */