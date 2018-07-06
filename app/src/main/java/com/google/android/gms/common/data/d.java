package com.google.android.gms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;

public abstract class d
{
  protected final DataHolder JG;
  protected int KZ;
  private int La;
  
  public d(DataHolder paramDataHolder, int paramInt)
  {
    this.JG = ((DataHolder)jx.i(paramDataHolder));
    as(paramInt);
  }
  
  protected void a(String paramString, CharArrayBuffer paramCharArrayBuffer)
  {
    this.JG.a(paramString, this.KZ, this.La, paramCharArrayBuffer);
  }
  
  public boolean aQ(String paramString)
  {
    return this.JG.aQ(paramString);
  }
  
  protected Uri aR(String paramString)
  {
    return this.JG.g(paramString, this.KZ, this.La);
  }
  
  protected boolean aS(String paramString)
  {
    return this.JG.h(paramString, this.KZ, this.La);
  }
  
  protected void as(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.JG.getCount())) {}
    for (boolean bool = true;; bool = false)
    {
      jx.K(bool);
      this.KZ = paramInt;
      this.La = this.JG.au(this.KZ);
      return;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof d;
    boolean bool2 = false;
    if (bool1)
    {
      d locald = (d)paramObject;
      boolean bool3 = jv.equal(Integer.valueOf(locald.KZ), Integer.valueOf(this.KZ));
      bool2 = false;
      if (bool3)
      {
        boolean bool4 = jv.equal(Integer.valueOf(locald.La), Integer.valueOf(this.La));
        bool2 = false;
        if (bool4)
        {
          DataHolder localDataHolder1 = locald.JG;
          DataHolder localDataHolder2 = this.JG;
          bool2 = false;
          if (localDataHolder1 == localDataHolder2) {
            bool2 = true;
          }
        }
      }
    }
    return bool2;
  }
  
  protected int gW()
  {
    return this.KZ;
  }
  
  protected boolean getBoolean(String paramString)
  {
    return this.JG.d(paramString, this.KZ, this.La);
  }
  
  protected byte[] getByteArray(String paramString)
  {
    return this.JG.f(paramString, this.KZ, this.La);
  }
  
  protected float getFloat(String paramString)
  {
    return this.JG.e(paramString, this.KZ, this.La);
  }
  
  protected int getInteger(String paramString)
  {
    return this.JG.b(paramString, this.KZ, this.La);
  }
  
  protected long getLong(String paramString)
  {
    return this.JG.a(paramString, this.KZ, this.La);
  }
  
  protected String getString(String paramString)
  {
    return this.JG.c(paramString, this.KZ, this.La);
  }
  
  public int hashCode()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.KZ);
    arrayOfObject[1] = Integer.valueOf(this.La);
    arrayOfObject[2] = this.JG;
    return jv.hashCode(arrayOfObject);
  }
  
  public boolean isDataValid()
  {
    return !this.JG.isClosed();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.data.d
 * JD-Core Version:    0.7.0.1
 */