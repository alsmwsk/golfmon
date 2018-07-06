package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.internal.pd;
import com.google.android.gms.internal.pf;
import java.util.HashSet;
import java.util.Set;

public abstract interface Moment
  extends Freezable<Moment>
{
  public abstract String getId();
  
  public abstract ItemScope getResult();
  
  public abstract String getStartDate();
  
  public abstract ItemScope getTarget();
  
  public abstract String getType();
  
  public abstract boolean hasId();
  
  public abstract boolean hasResult();
  
  public abstract boolean hasStartDate();
  
  public abstract boolean hasTarget();
  
  public abstract boolean hasType();
  
  public static class Builder
  {
    private String CE;
    private final Set<Integer> aon = new HashSet();
    private String apa;
    private pd api;
    private pd apj;
    private String vc;
    
    public Moment build()
    {
      return new pf(this.aon, this.CE, this.api, this.apa, this.apj, this.vc);
    }
    
    public Builder setId(String paramString)
    {
      this.CE = paramString;
      this.aon.add(Integer.valueOf(2));
      return this;
    }
    
    public Builder setResult(ItemScope paramItemScope)
    {
      this.api = ((pd)paramItemScope);
      this.aon.add(Integer.valueOf(4));
      return this;
    }
    
    public Builder setStartDate(String paramString)
    {
      this.apa = paramString;
      this.aon.add(Integer.valueOf(5));
      return this;
    }
    
    public Builder setTarget(ItemScope paramItemScope)
    {
      this.apj = ((pd)paramItemScope);
      this.aon.add(Integer.valueOf(6));
      return this;
    }
    
    public Builder setType(String paramString)
    {
      this.vc = paramString;
      this.aon.add(Integer.valueOf(7));
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.plus.model.moments.Moment
 * JD-Core Version:    0.7.0.1
 */