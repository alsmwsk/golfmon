package com.google.android.gms.internal;

import java.util.ArrayList;

public class os
{
  private final ArrayList<a> amZ = new ArrayList();
  private int ana;
  
  public os()
  {
    this(100);
  }
  
  public os(int paramInt)
  {
    this.ana = paramInt;
  }
  
  private void oq()
  {
    while (getSize() > getCapacity()) {
      this.amZ.remove(0);
    }
  }
  
  public void a(ov paramov, or paramor)
  {
    this.amZ.add(new a(paramov, paramor, null));
    oq();
  }
  
  public void clear()
  {
    this.amZ.clear();
  }
  
  public int getCapacity()
  {
    return this.ana;
  }
  
  public int getSize()
  {
    return this.amZ.size();
  }
  
  public boolean isEmpty()
  {
    return this.amZ.isEmpty();
  }
  
  public ArrayList<a> op()
  {
    return this.amZ;
  }
  
  public static class a
  {
    public final ov anb;
    public final or anc;
    public final ra.c and;
    
    private a(ov paramov, or paramor)
    {
      this.anb = ((ov)jx.i(paramov));
      this.anc = ((or)jx.i(paramor));
      this.and = null;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.os
 * JD-Core Version:    0.7.0.1
 */