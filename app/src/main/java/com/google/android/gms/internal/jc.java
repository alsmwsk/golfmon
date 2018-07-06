package com.google.android.gms.internal;

import android.graphics.drawable.Drawable;

public final class jc
  extends kj<a, Drawable>
{
  public jc()
  {
    super(10);
  }
  
  public static final class a
  {
    public final int Mt;
    public final int Mu;
    
    public a(int paramInt1, int paramInt2)
    {
      this.Mt = paramInt1;
      this.Mu = paramInt2;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (!(paramObject instanceof a)) {
        bool = false;
      }
      a locala;
      do
      {
        do
        {
          return bool;
        } while (this == paramObject);
        locala = (a)paramObject;
      } while ((locala.Mt == this.Mt) && (locala.Mu == this.Mu));
      return false;
    }
    
    public int hashCode()
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(this.Mt);
      arrayOfObject[1] = Integer.valueOf(this.Mu);
      return jv.hashCode(arrayOfObject);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jc
 * JD-Core Version:    0.7.0.1
 */