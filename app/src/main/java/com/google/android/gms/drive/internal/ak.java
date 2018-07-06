package com.google.android.gms.drive.internal;

import com.google.android.gms.internal.qo;
import com.google.android.gms.internal.qp;
import com.google.android.gms.internal.qq;
import com.google.android.gms.internal.qv;
import com.google.android.gms.internal.qw;
import java.io.IOException;

public final class ak
  extends qq<ak>
{
  public String QG;
  public long QH;
  public long QI;
  public int versionCode;
  
  public ak()
  {
    iK();
  }
  
  public static ak g(byte[] paramArrayOfByte)
    throws qv
  {
    return (ak)qw.a(new ak(), paramArrayOfByte);
  }
  
  public void a(qp paramqp)
    throws IOException
  {
    paramqp.t(1, this.versionCode);
    paramqp.b(2, this.QG);
    paramqp.c(3, this.QH);
    paramqp.c(4, this.QI);
    super.a(paramqp);
  }
  
  protected int c()
  {
    return super.c() + qp.v(1, this.versionCode) + qp.j(2, this.QG) + qp.e(3, this.QH) + qp.e(4, this.QI);
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2;
    if (paramObject == this) {
      bool2 = true;
    }
    ak localak;
    do
    {
      int i;
      int j;
      do
      {
        boolean bool1;
        do
        {
          return bool2;
          bool1 = paramObject instanceof ak;
          bool2 = false;
        } while (!bool1);
        localak = (ak)paramObject;
        i = this.versionCode;
        j = localak.versionCode;
        bool2 = false;
      } while (i != j);
      if (this.QG != null) {
        break;
      }
      str = localak.QG;
      bool2 = false;
    } while (str != null);
    while (this.QG.equals(localak.QG))
    {
      String str;
      boolean bool3 = this.QH < localak.QH;
      bool2 = false;
      if (bool3) {
        break;
      }
      boolean bool4 = this.QI < localak.QI;
      bool2 = false;
      if (bool4) {
        break;
      }
      return a(localak);
    }
    return false;
  }
  
  public int hashCode()
  {
    int i = 31 * (527 + this.versionCode);
    if (this.QG == null) {}
    for (int j = 0;; j = this.QG.hashCode()) {
      return 31 * (31 * (31 * (j + i) + (int)(this.QH ^ this.QH >>> 32)) + (int)(this.QI ^ this.QI >>> 32)) + rQ();
    }
  }
  
  public ak iK()
  {
    this.versionCode = 1;
    this.QG = "";
    this.QH = -1L;
    this.QI = -1L;
    this.ayW = null;
    this.azh = -1;
    return this;
  }
  
  public ak m(qo paramqo)
    throws IOException
  {
    for (;;)
    {
      int i = paramqo.rz();
      switch (i)
      {
      default: 
        if (a(paramqo, i)) {
          continue;
        }
      case 0: 
        return this;
      case 8: 
        this.versionCode = paramqo.rC();
        break;
      case 18: 
        this.QG = paramqo.readString();
        break;
      case 24: 
        this.QH = paramqo.rF();
        break;
      }
      this.QI = paramqo.rF();
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.ak
 * JD-Core Version:    0.7.0.1
 */