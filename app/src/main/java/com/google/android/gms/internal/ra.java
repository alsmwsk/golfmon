package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public abstract interface ra
{
  public static final class a
    extends qq<a>
  {
    public String[] azr;
    public String[] azs;
    public int[] azt;
    
    public a()
    {
      sa();
    }
    
    public void a(qp paramqp)
      throws IOException
    {
      if ((this.azr != null) && (this.azr.length > 0)) {
        for (int m = 0; m < this.azr.length; m++)
        {
          String str2 = this.azr[m];
          if (str2 != null) {
            paramqp.b(1, str2);
          }
        }
      }
      if ((this.azs != null) && (this.azs.length > 0)) {
        for (int k = 0; k < this.azs.length; k++)
        {
          String str1 = this.azs[k];
          if (str1 != null) {
            paramqp.b(2, str1);
          }
        }
      }
      if (this.azt != null)
      {
        int i = this.azt.length;
        int j = 0;
        if (i > 0) {
          while (j < this.azt.length)
          {
            paramqp.t(3, this.azt[j]);
            j++;
          }
        }
      }
      super.a(paramqp);
    }
    
    protected int c()
    {
      int i = 0;
      int j = super.c();
      int i4;
      int i5;
      if ((this.azr != null) && (this.azr.length > 0))
      {
        int i3 = 0;
        i4 = 0;
        i5 = 0;
        while (i3 < this.azr.length)
        {
          String str2 = this.azr[i3];
          if (str2 != null)
          {
            i5++;
            i4 += qp.dk(str2);
          }
          i3++;
        }
      }
      for (int k = j + i4 + i5 * 1;; k = j)
      {
        if ((this.azs != null) && (this.azs.length > 0))
        {
          int n = 0;
          int i1 = 0;
          int i2 = 0;
          while (n < this.azs.length)
          {
            String str1 = this.azs[n];
            if (str1 != null)
            {
              i2++;
              i1 += qp.dk(str1);
            }
            n++;
          }
          k = k + i1 + i2 * 1;
        }
        if ((this.azt != null) && (this.azt.length > 0))
        {
          int m = 0;
          while (i < this.azt.length)
          {
            m += qp.gZ(this.azt[i]);
            i++;
          }
          k = k + m + 1 * this.azt.length;
        }
        return k;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2;
      if (paramObject == this) {
        bool2 = true;
      }
      a locala;
      boolean bool5;
      do
      {
        boolean bool4;
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
            bool3 = qu.equals(this.azr, locala.azr);
            bool2 = false;
          } while (!bool3);
          bool4 = qu.equals(this.azs, locala.azs);
          bool2 = false;
        } while (!bool4);
        bool5 = qu.equals(this.azt, locala.azt);
        bool2 = false;
      } while (!bool5);
      return a(locala);
    }
    
    public int hashCode()
    {
      return 31 * (31 * (31 * (527 + qu.hashCode(this.azr)) + qu.hashCode(this.azs)) + qu.hashCode(this.azt)) + rQ();
    }
    
    public a sa()
    {
      this.azr = qz.azo;
      this.azs = qz.azo;
      this.azt = qz.azj;
      this.ayW = null;
      this.azh = -1;
      return this;
    }
    
    public a y(qo paramqo)
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
        case 10: 
          int i5 = qz.b(paramqo, 10);
          if (this.azr == null) {}
          String[] arrayOfString2;
          for (int i6 = 0;; i6 = this.azr.length)
          {
            arrayOfString2 = new String[i5 + i6];
            if (i6 != 0) {
              System.arraycopy(this.azr, 0, arrayOfString2, 0, i6);
            }
            while (i6 < -1 + arrayOfString2.length)
            {
              arrayOfString2[i6] = paramqo.readString();
              paramqo.rz();
              i6++;
            }
          }
          arrayOfString2[i6] = paramqo.readString();
          this.azr = arrayOfString2;
          break;
        case 18: 
          int i3 = qz.b(paramqo, 18);
          if (this.azs == null) {}
          String[] arrayOfString1;
          for (int i4 = 0;; i4 = this.azs.length)
          {
            arrayOfString1 = new String[i3 + i4];
            if (i4 != 0) {
              System.arraycopy(this.azs, 0, arrayOfString1, 0, i4);
            }
            while (i4 < -1 + arrayOfString1.length)
            {
              arrayOfString1[i4] = paramqo.readString();
              paramqo.rz();
              i4++;
            }
          }
          arrayOfString1[i4] = paramqo.readString();
          this.azs = arrayOfString1;
          break;
        case 24: 
          int i1 = qz.b(paramqo, 24);
          if (this.azt == null) {}
          int[] arrayOfInt2;
          for (int i2 = 0;; i2 = this.azt.length)
          {
            arrayOfInt2 = new int[i1 + i2];
            if (i2 != 0) {
              System.arraycopy(this.azt, 0, arrayOfInt2, 0, i2);
            }
            while (i2 < -1 + arrayOfInt2.length)
            {
              arrayOfInt2[i2] = paramqo.rC();
              paramqo.rz();
              i2++;
            }
          }
          arrayOfInt2[i2] = paramqo.rC();
          this.azt = arrayOfInt2;
          break;
        }
        int j = paramqo.gS(paramqo.rG());
        int k = paramqo.getPosition();
        for (int m = 0; paramqo.rL() > 0; m++) {
          paramqo.rC();
        }
        paramqo.gU(k);
        if (this.azt == null) {}
        int[] arrayOfInt1;
        for (int n = 0;; n = this.azt.length)
        {
          arrayOfInt1 = new int[m + n];
          if (n != 0) {
            System.arraycopy(this.azt, 0, arrayOfInt1, 0, n);
          }
          while (n < arrayOfInt1.length)
          {
            arrayOfInt1[n] = paramqo.rC();
            n++;
          }
        }
        this.azt = arrayOfInt1;
        paramqo.gT(j);
      }
    }
  }
  
  public static final class b
    extends qq<b>
  {
    public int azu;
    public String azv;
    public String version;
    
    public b()
    {
      sb();
    }
    
    public void a(qp paramqp)
      throws IOException
    {
      if (this.azu != 0) {
        paramqp.t(1, this.azu);
      }
      if (!this.azv.equals("")) {
        paramqp.b(2, this.azv);
      }
      if (!this.version.equals("")) {
        paramqp.b(3, this.version);
      }
      super.a(paramqp);
    }
    
    protected int c()
    {
      int i = super.c();
      if (this.azu != 0) {
        i += qp.v(1, this.azu);
      }
      if (!this.azv.equals("")) {
        i += qp.j(2, this.azv);
      }
      if (!this.version.equals("")) {
        i += qp.j(3, this.version);
      }
      return i;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2;
      if (paramObject == this) {
        bool2 = true;
      }
      b localb;
      do
      {
        String str2;
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
              bool1 = paramObject instanceof b;
              bool2 = false;
            } while (!bool1);
            localb = (b)paramObject;
            i = this.azu;
            j = localb.azu;
            bool2 = false;
          } while (i != j);
          if (this.azv != null) {
            break;
          }
          str2 = localb.azv;
          bool2 = false;
        } while (str2 != null);
        if (this.version != null) {
          break label114;
        }
        str1 = localb.version;
        bool2 = false;
      } while (str1 != null);
      label114:
      while (this.version.equals(localb.version))
      {
        String str1;
        return a(localb);
        if (this.azv.equals(localb.azv)) {
          break;
        }
        return false;
      }
      return false;
    }
    
    public int hashCode()
    {
      int i = 31 * (527 + this.azu);
      int j;
      int k;
      int m;
      if (this.azv == null)
      {
        j = 0;
        k = 31 * (j + i);
        String str = this.version;
        m = 0;
        if (str != null) {
          break label66;
        }
      }
      for (;;)
      {
        return 31 * (k + m) + rQ();
        j = this.azv.hashCode();
        break;
        label66:
        m = this.version.hashCode();
      }
    }
    
    public b sb()
    {
      this.azu = 0;
      this.azv = "";
      this.version = "";
      this.ayW = null;
      this.azh = -1;
      return this;
    }
    
    public b z(qo paramqo)
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
          int j = paramqo.rC();
          switch (j)
          {
          default: 
            break;
          }
          this.azu = j;
          break;
        case 18: 
          this.azv = paramqo.readString();
          break;
        }
        this.version = paramqo.readString();
      }
    }
  }
  
  public static final class c
    extends qq<c>
  {
    public ra.d[] azA;
    public ra.b azB;
    public byte[] azC;
    public byte[] azD;
    public byte[] azE;
    public ra.a azF;
    public String azG;
    public long azH;
    public long azw;
    public int azx;
    public int azy;
    public boolean azz;
    public String tag;
    
    public c()
    {
      sc();
    }
    
    public c A(qo paramqo)
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
          this.azw = paramqo.rB();
          break;
        case 18: 
          this.tag = paramqo.readString();
          break;
        case 26: 
          int j = qz.b(paramqo, 26);
          if (this.azA == null) {}
          ra.d[] arrayOfd;
          for (int k = 0;; k = this.azA.length)
          {
            arrayOfd = new ra.d[j + k];
            if (k != 0) {
              System.arraycopy(this.azA, 0, arrayOfd, 0, k);
            }
            while (k < -1 + arrayOfd.length)
            {
              arrayOfd[k] = new ra.d();
              paramqo.a(arrayOfd[k]);
              paramqo.rz();
              k++;
            }
          }
          arrayOfd[k] = new ra.d();
          paramqo.a(arrayOfd[k]);
          this.azA = arrayOfd;
          break;
        case 50: 
          this.azC = paramqo.readBytes();
          break;
        case 58: 
          if (this.azF == null) {
            this.azF = new ra.a();
          }
          paramqo.a(this.azF);
          break;
        case 66: 
          this.azD = paramqo.readBytes();
          break;
        case 74: 
          if (this.azB == null) {
            this.azB = new ra.b();
          }
          paramqo.a(this.azB);
          break;
        case 80: 
          this.azz = paramqo.rD();
          break;
        case 88: 
          this.azx = paramqo.rC();
          break;
        case 96: 
          this.azy = paramqo.rC();
          break;
        case 106: 
          this.azE = paramqo.readBytes();
          break;
        case 114: 
          this.azG = paramqo.readString();
          break;
        }
        this.azH = paramqo.rF();
      }
    }
    
    public void a(qp paramqp)
      throws IOException
    {
      if (this.azw != 0L) {
        paramqp.b(1, this.azw);
      }
      if (!this.tag.equals("")) {
        paramqp.b(2, this.tag);
      }
      if ((this.azA != null) && (this.azA.length > 0)) {
        for (int i = 0; i < this.azA.length; i++)
        {
          ra.d locald = this.azA[i];
          if (locald != null) {
            paramqp.a(3, locald);
          }
        }
      }
      if (!Arrays.equals(this.azC, qz.azq)) {
        paramqp.a(6, this.azC);
      }
      if (this.azF != null) {
        paramqp.a(7, this.azF);
      }
      if (!Arrays.equals(this.azD, qz.azq)) {
        paramqp.a(8, this.azD);
      }
      if (this.azB != null) {
        paramqp.a(9, this.azB);
      }
      if (this.azz) {
        paramqp.b(10, this.azz);
      }
      if (this.azx != 0) {
        paramqp.t(11, this.azx);
      }
      if (this.azy != 0) {
        paramqp.t(12, this.azy);
      }
      if (!Arrays.equals(this.azE, qz.azq)) {
        paramqp.a(13, this.azE);
      }
      if (!this.azG.equals("")) {
        paramqp.b(14, this.azG);
      }
      if (this.azH != 0L) {
        paramqp.c(15, this.azH);
      }
      super.a(paramqp);
    }
    
    protected int c()
    {
      int i = super.c();
      if (this.azw != 0L) {
        i += qp.d(1, this.azw);
      }
      if (!this.tag.equals("")) {
        i += qp.j(2, this.tag);
      }
      if ((this.azA != null) && (this.azA.length > 0))
      {
        int j = i;
        for (int k = 0; k < this.azA.length; k++)
        {
          ra.d locald = this.azA[k];
          if (locald != null) {
            j += qp.c(3, locald);
          }
        }
        i = j;
      }
      if (!Arrays.equals(this.azC, qz.azq)) {
        i += qp.b(6, this.azC);
      }
      if (this.azF != null) {
        i += qp.c(7, this.azF);
      }
      if (!Arrays.equals(this.azD, qz.azq)) {
        i += qp.b(8, this.azD);
      }
      if (this.azB != null) {
        i += qp.c(9, this.azB);
      }
      if (this.azz) {
        i += qp.c(10, this.azz);
      }
      if (this.azx != 0) {
        i += qp.v(11, this.azx);
      }
      if (this.azy != 0) {
        i += qp.v(12, this.azy);
      }
      if (!Arrays.equals(this.azE, qz.azq)) {
        i += qp.b(13, this.azE);
      }
      if (!this.azG.equals("")) {
        i += qp.j(14, this.azG);
      }
      if (this.azH != 0L) {
        i += qp.e(15, this.azH);
      }
      return i;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2;
      if (paramObject == this) {
        bool2 = true;
      }
      c localc;
      label66:
      do
      {
        ra.a locala;
        do
        {
          boolean bool9;
          do
          {
            boolean bool8;
            do
            {
              boolean bool7;
              do
              {
                ra.b localb;
                do
                {
                  boolean bool6;
                  do
                  {
                    boolean bool4;
                    boolean bool5;
                    do
                    {
                      int k;
                      int m;
                      do
                      {
                        int i;
                        int j;
                        do
                        {
                          String str2;
                          do
                          {
                            boolean bool3;
                            do
                            {
                              boolean bool1;
                              do
                              {
                                return bool2;
                                bool1 = paramObject instanceof c;
                                bool2 = false;
                              } while (!bool1);
                              localc = (c)paramObject;
                              bool3 = this.azw < localc.azw;
                              bool2 = false;
                            } while (bool3);
                            if (this.tag != null) {
                              break;
                            }
                            str2 = localc.tag;
                            bool2 = false;
                          } while (str2 != null);
                          i = this.azx;
                          j = localc.azx;
                          bool2 = false;
                        } while (i != j);
                        k = this.azy;
                        m = localc.azy;
                        bool2 = false;
                      } while (k != m);
                      bool4 = this.azz;
                      bool5 = localc.azz;
                      bool2 = false;
                    } while (bool4 != bool5);
                    bool6 = qu.equals(this.azA, localc.azA);
                    bool2 = false;
                  } while (!bool6);
                  if (this.azB != null) {
                    break label322;
                  }
                  localb = localc.azB;
                  bool2 = false;
                } while (localb != null);
                bool7 = Arrays.equals(this.azC, localc.azC);
                bool2 = false;
              } while (!bool7);
              bool8 = Arrays.equals(this.azD, localc.azD);
              bool2 = false;
            } while (!bool8);
            bool9 = Arrays.equals(this.azE, localc.azE);
            bool2 = false;
          } while (!bool9);
          if (this.azF != null) {
            break label339;
          }
          locala = localc.azF;
          bool2 = false;
        } while (locala != null);
        if (this.azG != null) {
          break label356;
        }
        str1 = localc.azG;
        bool2 = false;
      } while (str1 != null);
      label174:
      label322:
      label339:
      label356:
      while (this.azG.equals(localc.azG))
      {
        String str1;
        boolean bool10 = this.azH < localc.azH;
        bool2 = false;
        if (bool10) {
          break;
        }
        return a(localc);
        if (this.tag.equals(localc.tag)) {
          break label66;
        }
        return false;
        if (this.azB.equals(localc.azB)) {
          break label174;
        }
        return false;
        if (this.azF.equals(localc.azF)) {
          break label258;
        }
        return false;
      }
      label258:
      return false;
    }
    
    public int hashCode()
    {
      int i = 31 * (527 + (int)(this.azw ^ this.azw >>> 32));
      int j;
      int m;
      label65:
      int i1;
      label95:
      int i3;
      label148:
      int i4;
      int i5;
      if (this.tag == null)
      {
        j = 0;
        int k = 31 * (31 * (31 * (j + i) + this.azx) + this.azy);
        if (!this.azz) {
          break label214;
        }
        m = 1231;
        int n = 31 * (31 * (m + k) + qu.hashCode(this.azA));
        if (this.azB != null) {
          break label222;
        }
        i1 = 0;
        int i2 = 31 * (31 * (31 * (31 * (i1 + n) + Arrays.hashCode(this.azC)) + Arrays.hashCode(this.azD)) + Arrays.hashCode(this.azE));
        if (this.azF != null) {
          break label234;
        }
        i3 = 0;
        i4 = 31 * (i3 + i2);
        String str = this.azG;
        i5 = 0;
        if (str != null) {
          break label246;
        }
      }
      for (;;)
      {
        return 31 * (31 * (i4 + i5) + (int)(this.azH ^ this.azH >>> 32)) + rQ();
        j = this.tag.hashCode();
        break;
        label214:
        m = 1237;
        break label65;
        label222:
        i1 = this.azB.hashCode();
        break label95;
        label234:
        i3 = this.azF.hashCode();
        break label148;
        label246:
        i5 = this.azG.hashCode();
      }
    }
    
    public c sc()
    {
      this.azw = 0L;
      this.tag = "";
      this.azx = 0;
      this.azy = 0;
      this.azz = false;
      this.azA = ra.d.sd();
      this.azB = null;
      this.azC = qz.azq;
      this.azD = qz.azq;
      this.azE = qz.azq;
      this.azF = null;
      this.azG = "";
      this.azH = 0L;
      this.ayW = null;
      this.azh = -1;
      return this;
    }
  }
  
  public static final class d
    extends qq<d>
  {
    private static volatile d[] azI;
    public String fv;
    public String value;
    
    public d()
    {
      se();
    }
    
    public static d[] sd()
    {
      if (azI == null) {}
      synchronized (qu.azg)
      {
        if (azI == null) {
          azI = new d[0];
        }
        return azI;
      }
    }
    
    public d B(qo paramqo)
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
        case 10: 
          this.fv = paramqo.readString();
          break;
        }
        this.value = paramqo.readString();
      }
    }
    
    public void a(qp paramqp)
      throws IOException
    {
      if (!this.fv.equals("")) {
        paramqp.b(1, this.fv);
      }
      if (!this.value.equals("")) {
        paramqp.b(2, this.value);
      }
      super.a(paramqp);
    }
    
    protected int c()
    {
      int i = super.c();
      if (!this.fv.equals("")) {
        i += qp.j(1, this.fv);
      }
      if (!this.value.equals("")) {
        i += qp.j(2, this.value);
      }
      return i;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2;
      if (paramObject == this) {
        bool2 = true;
      }
      d locald;
      do
      {
        String str2;
        do
        {
          boolean bool1;
          do
          {
            return bool2;
            bool1 = paramObject instanceof d;
            bool2 = false;
          } while (!bool1);
          locald = (d)paramObject;
          if (this.fv != null) {
            break;
          }
          str2 = locald.fv;
          bool2 = false;
        } while (str2 != null);
        if (this.value != null) {
          break label92;
        }
        str1 = locald.value;
        bool2 = false;
      } while (str1 != null);
      label92:
      while (this.value.equals(locald.value))
      {
        String str1;
        return a(locald);
        if (this.fv.equals(locald.fv)) {
          break;
        }
        return false;
      }
      return false;
    }
    
    public int hashCode()
    {
      int i;
      int j;
      int k;
      if (this.fv == null)
      {
        i = 0;
        j = 31 * (i + 527);
        String str = this.value;
        k = 0;
        if (str != null) {
          break label54;
        }
      }
      for (;;)
      {
        return 31 * (j + k) + rQ();
        i = this.fv.hashCode();
        break;
        label54:
        k = this.value.hashCode();
      }
    }
    
    public d se()
    {
      this.fv = "";
      this.value = "";
      this.ayW = null;
      this.azh = -1;
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ra
 * JD-Core Version:    0.7.0.1
 */