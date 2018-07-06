package com.google.android.gms.common.data;

import java.util.ArrayList;

public abstract class g<T>
  extends DataBuffer<T>
{
  private boolean Lr = false;
  private ArrayList<Integer> Ls;
  
  protected g(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  private void hb()
  {
    for (;;)
    {
      int k;
      Object localObject3;
      try
      {
        if (this.Lr) {
          break label198;
        }
        int i = this.JG.getCount();
        this.Ls = new ArrayList();
        if (i <= 0) {
          break label193;
        }
        this.Ls.add(Integer.valueOf(0));
        String str = ha();
        int j = this.JG.au(0);
        localObject2 = this.JG.c(str, 0, j);
        k = 1;
        if (k >= i) {
          break label193;
        }
        int m = this.JG.au(k);
        localObject3 = this.JG.c(str, k, m);
        if (localObject3 == null) {
          throw new NullPointerException("Missing value for markerColumn: " + str + ", at row: " + k + ", for window: " + m);
        }
      }
      finally {}
      if (!((String)localObject3).equals(localObject2))
      {
        this.Ls.add(Integer.valueOf(k));
        break label205;
        label193:
        this.Lr = true;
      }
      else
      {
        label198:
        localObject3 = localObject2;
      }
      label205:
      k++;
      Object localObject2 = localObject3;
    }
  }
  
  int ax(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.Ls.size())) {
      throw new IllegalArgumentException("Position " + paramInt + " is out of bounds for this buffer");
    }
    return ((Integer)this.Ls.get(paramInt)).intValue();
  }
  
  protected int ay(int paramInt)
  {
    int i;
    if ((paramInt < 0) || (paramInt == this.Ls.size())) {
      i = 0;
    }
    label137:
    for (;;)
    {
      return i;
      if (paramInt == -1 + this.Ls.size()) {}
      for (i = this.JG.getCount() - ((Integer)this.Ls.get(paramInt)).intValue();; i = ((Integer)this.Ls.get(paramInt + 1)).intValue() - ((Integer)this.Ls.get(paramInt)).intValue())
      {
        if (i != 1) {
          break label137;
        }
        int j = ax(paramInt);
        int k = this.JG.au(j);
        String str = hc();
        if ((str == null) || (this.JG.c(str, j, k) != null)) {
          break;
        }
        return 0;
      }
    }
  }
  
  protected abstract T f(int paramInt1, int paramInt2);
  
  public final T get(int paramInt)
  {
    hb();
    return f(ax(paramInt), ay(paramInt));
  }
  
  public int getCount()
  {
    hb();
    return this.Ls.size();
  }
  
  protected abstract String ha();
  
  protected String hc()
  {
    return null;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.g
 * JD-Core Version:    0.7.0.1
 */