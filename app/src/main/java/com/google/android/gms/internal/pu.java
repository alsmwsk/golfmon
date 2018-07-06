package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface pu
{
  public static final class a
    extends qq<a>
  {
    public long auB;
    public c.j auC;
    public c.f gs;
    
    public a()
    {
      rc();
    }
    
    public static a l(byte[] paramArrayOfByte)
      throws qv
    {
      return (a)qw.a(new a(), paramArrayOfByte);
    }
    
    public void a(qp paramqp)
      throws IOException
    {
      paramqp.b(1, this.auB);
      if (this.gs != null) {
        paramqp.a(2, this.gs);
      }
      if (this.auC != null) {
        paramqp.a(3, this.auC);
      }
      super.a(paramqp);
    }
    
    protected int c()
    {
      int i = super.c() + qp.d(1, this.auB);
      if (this.gs != null) {
        i += qp.c(2, this.gs);
      }
      if (this.auC != null) {
        i += qp.c(3, this.auC);
      }
      return i;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2;
      if (paramObject == this) {
        bool2 = true;
      }
      a locala;
      do
      {
        c.f localf;
        do
        {
          boolean bool3;
          do
          {
            boolean bool1;
            do
            {
              return bool2;
              bool1 = paramObject instanceof a;
              bool2 = false;
            } while (!bool1);
            locala = (a)paramObject;
            bool3 = this.auB < locala.auB;
            bool2 = false;
          } while (bool3);
          if (this.gs != null) {
            break;
          }
          localf = locala.gs;
          bool2 = false;
        } while (localf != null);
        if (this.auC != null) {
          break label111;
        }
        localj = locala.auC;
        bool2 = false;
      } while (localj != null);
      label111:
      while (this.auC.equals(locala.auC))
      {
        c.j localj;
        return a(locala);
        if (this.gs.equals(locala.gs)) {
          break;
        }
        return false;
      }
      return false;
    }
    
    public int hashCode()
    {
      int i = 31 * (527 + (int)(this.auB ^ this.auB >>> 32));
      int j;
      int k;
      int m;
      if (this.gs == null)
      {
        j = 0;
        k = 31 * (j + i);
        c.j localj = this.auC;
        m = 0;
        if (localj != null) {
          break label75;
        }
      }
      for (;;)
      {
        return 31 * (k + m) + rQ();
        j = this.gs.hashCode();
        break;
        label75:
        m = this.auC.hashCode();
      }
    }
    
    public a rc()
    {
      this.auB = 0L;
      this.gs = null;
      this.auC = null;
      this.ayW = null;
      this.azh = -1;
      return this;
    }
    
    public a s(qo paramqo)
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
          this.auB = paramqo.rB();
          break;
        case 18: 
          if (this.gs == null) {
            this.gs = new c.f();
          }
          paramqo.a(this.gs);
          break;
        }
        if (this.auC == null) {
          this.auC = new c.j();
        }
        paramqo.a(this.auC);
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.pu
 * JD-Core Version:    0.7.0.1
 */