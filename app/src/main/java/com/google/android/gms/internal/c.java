package com.google.android.gms.internal;

import java.io.IOException;

public abstract interface c
{
  public static final class a
    extends qq<a>
  {
    public int fn;
    public int fo;
    public int level;
    
    public a()
    {
      b();
    }
    
    public a a(qo paramqo)
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
          this.level = j;
          break;
        case 16: 
          this.fn = paramqo.rC();
          break;
        }
        this.fo = paramqo.rC();
      }
    }
    
    public void a(qp paramqp)
      throws IOException
    {
      if (this.level != 1) {
        paramqp.t(1, this.level);
      }
      if (this.fn != 0) {
        paramqp.t(2, this.fn);
      }
      if (this.fo != 0) {
        paramqp.t(3, this.fo);
      }
      super.a(paramqp);
    }
    
    public a b()
    {
      this.level = 1;
      this.fn = 0;
      this.fo = 0;
      this.ayW = null;
      this.azh = -1;
      return this;
    }
    
    protected int c()
    {
      int i = super.c();
      if (this.level != 1) {
        i += qp.v(1, this.level);
      }
      if (this.fn != 0) {
        i += qp.v(2, this.fn);
      }
      if (this.fo != 0) {
        i += qp.v(3, this.fo);
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
      int n;
      int i1;
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
            boolean bool1;
            do
            {
              return bool2;
              bool1 = paramObject instanceof a;
              bool2 = false;
            } while (!bool1);
            locala = (a)paramObject;
            i = this.level;
            j = locala.level;
            bool2 = false;
          } while (i != j);
          k = this.fn;
          m = locala.fn;
          bool2 = false;
        } while (k != m);
        n = this.fo;
        i1 = locala.fo;
        bool2 = false;
      } while (n != i1);
      return a(locala);
    }
    
    public int hashCode()
    {
      return 31 * (31 * (31 * (527 + this.level) + this.fn) + this.fo) + rQ();
    }
  }
  
  public static final class b
    extends qq<b>
  {
    private static volatile b[] fp;
    public int[] fq;
    public int fr;
    public boolean fs;
    public boolean ft;
    public int name;
    
    public b()
    {
      e();
    }
    
    public static b[] d()
    {
      if (fp == null) {}
      synchronized (qu.azg)
      {
        if (fp == null) {
          fp = new b[0];
        }
        return fp;
      }
    }
    
    public void a(qp paramqp)
      throws IOException
    {
      if (this.ft) {
        paramqp.b(1, this.ft);
      }
      paramqp.t(2, this.fr);
      if ((this.fq != null) && (this.fq.length > 0)) {
        for (int i = 0; i < this.fq.length; i++) {
          paramqp.t(3, this.fq[i]);
        }
      }
      if (this.name != 0) {
        paramqp.t(4, this.name);
      }
      if (this.fs) {
        paramqp.b(6, this.fs);
      }
      super.a(paramqp);
    }
    
    protected int c()
    {
      int i = 0;
      int j = super.c();
      if (this.ft) {
        j += qp.c(1, this.ft);
      }
      int k = j + qp.v(2, this.fr);
      if ((this.fq != null) && (this.fq.length > 0)) {
        for (int n = 0; n < this.fq.length; n++) {
          i += qp.gZ(this.fq[n]);
        }
      }
      for (int m = k + i + 1 * this.fq.length;; m = k)
      {
        if (this.name != 0) {
          m += qp.v(4, this.name);
        }
        if (this.fs) {
          m += qp.c(6, this.fs);
        }
        return m;
      }
    }
    
    public b c(qo paramqo)
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
          this.ft = paramqo.rD();
          break;
        case 16: 
          this.fr = paramqo.rC();
          break;
        case 24: 
          int i1 = qz.b(paramqo, 24);
          if (this.fq == null) {}
          int[] arrayOfInt2;
          for (int i2 = 0;; i2 = this.fq.length)
          {
            arrayOfInt2 = new int[i1 + i2];
            if (i2 != 0) {
              System.arraycopy(this.fq, 0, arrayOfInt2, 0, i2);
            }
            while (i2 < -1 + arrayOfInt2.length)
            {
              arrayOfInt2[i2] = paramqo.rC();
              paramqo.rz();
              i2++;
            }
          }
          arrayOfInt2[i2] = paramqo.rC();
          this.fq = arrayOfInt2;
          break;
        case 26: 
          int j = paramqo.gS(paramqo.rG());
          int k = paramqo.getPosition();
          for (int m = 0; paramqo.rL() > 0; m++) {
            paramqo.rC();
          }
          paramqo.gU(k);
          if (this.fq == null) {}
          int[] arrayOfInt1;
          for (int n = 0;; n = this.fq.length)
          {
            arrayOfInt1 = new int[m + n];
            if (n != 0) {
              System.arraycopy(this.fq, 0, arrayOfInt1, 0, n);
            }
            while (n < arrayOfInt1.length)
            {
              arrayOfInt1[n] = paramqo.rC();
              n++;
            }
          }
          this.fq = arrayOfInt1;
          paramqo.gT(j);
          break;
        case 32: 
          this.name = paramqo.rC();
          break;
        }
        this.fs = paramqo.rD();
      }
    }
    
    public b e()
    {
      this.fq = qz.azj;
      this.fr = 0;
      this.name = 0;
      this.fs = false;
      this.ft = false;
      this.ayW = null;
      this.azh = -1;
      return this;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2;
      if (paramObject == this) {
        bool2 = true;
      }
      b localb;
      boolean bool6;
      boolean bool7;
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
              boolean bool3;
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
                bool3 = qu.equals(this.fq, localb.fq);
                bool2 = false;
              } while (!bool3);
              i = this.fr;
              j = localb.fr;
              bool2 = false;
            } while (i != j);
            k = this.name;
            m = localb.name;
            bool2 = false;
          } while (k != m);
          bool4 = this.fs;
          bool5 = localb.fs;
          bool2 = false;
        } while (bool4 != bool5);
        bool6 = this.ft;
        bool7 = localb.ft;
        bool2 = false;
      } while (bool6 != bool7);
      return a(localb);
    }
    
    public int hashCode()
    {
      int i = 1231;
      int j = 31 * (31 * (31 * (527 + qu.hashCode(this.fq)) + this.fr) + this.name);
      int k;
      int m;
      if (this.fs)
      {
        k = i;
        m = 31 * (k + j);
        if (!this.ft) {
          break label79;
        }
      }
      for (;;)
      {
        return 31 * (m + i) + rQ();
        k = 1237;
        break;
        label79:
        i = 1237;
      }
    }
  }
  
  public static final class c
    extends qq<c>
  {
    private static volatile c[] fu;
    public String fv;
    public long fw;
    public long fx;
    public boolean fy;
    public long fz;
    
    public c()
    {
      g();
    }
    
    public static c[] f()
    {
      if (fu == null) {}
      synchronized (qu.azg)
      {
        if (fu == null) {
          fu = new c[0];
        }
        return fu;
      }
    }
    
    public void a(qp paramqp)
      throws IOException
    {
      if (!this.fv.equals("")) {
        paramqp.b(1, this.fv);
      }
      if (this.fw != 0L) {
        paramqp.b(2, this.fw);
      }
      if (this.fx != 2147483647L) {
        paramqp.b(3, this.fx);
      }
      if (this.fy) {
        paramqp.b(4, this.fy);
      }
      if (this.fz != 0L) {
        paramqp.b(5, this.fz);
      }
      super.a(paramqp);
    }
    
    protected int c()
    {
      int i = super.c();
      if (!this.fv.equals("")) {
        i += qp.j(1, this.fv);
      }
      if (this.fw != 0L) {
        i += qp.d(2, this.fw);
      }
      if (this.fx != 2147483647L) {
        i += qp.d(3, this.fx);
      }
      if (this.fy) {
        i += qp.c(4, this.fy);
      }
      if (this.fz != 0L) {
        i += qp.d(5, this.fz);
      }
      return i;
    }
    
    public c d(qo paramqo)
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
        case 16: 
          this.fw = paramqo.rB();
          break;
        case 24: 
          this.fx = paramqo.rB();
          break;
        case 32: 
          this.fy = paramqo.rD();
          break;
        }
        this.fz = paramqo.rB();
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2;
      if (paramObject == this) {
        bool2 = true;
      }
      c localc;
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
        if (this.fv != null) {
          break;
        }
        str = localc.fv;
        bool2 = false;
      } while (str != null);
      while (this.fv.equals(localc.fv))
      {
        String str;
        boolean bool3 = this.fw < localc.fw;
        bool2 = false;
        if (bool3) {
          break;
        }
        boolean bool4 = this.fx < localc.fx;
        bool2 = false;
        if (bool4) {
          break;
        }
        boolean bool5 = this.fy;
        boolean bool6 = localc.fy;
        bool2 = false;
        if (bool5 != bool6) {
          break;
        }
        boolean bool7 = this.fz < localc.fz;
        bool2 = false;
        if (bool7) {
          break;
        }
        return a(localc);
      }
      return false;
    }
    
    public c g()
    {
      this.fv = "";
      this.fw = 0L;
      this.fx = 2147483647L;
      this.fy = false;
      this.fz = 0L;
      this.ayW = null;
      this.azh = -1;
      return this;
    }
    
    public int hashCode()
    {
      int i;
      int j;
      if (this.fv == null)
      {
        i = 0;
        j = 31 * (31 * (31 * (i + 527) + (int)(this.fw ^ this.fw >>> 32)) + (int)(this.fx ^ this.fx >>> 32));
        if (!this.fy) {
          break label103;
        }
      }
      label103:
      for (int k = 1231;; k = 1237)
      {
        return 31 * (31 * (k + j) + (int)(this.fz ^ this.fz >>> 32)) + rQ();
        i = this.fv.hashCode();
        break;
      }
    }
  }
  
  public static final class d
    extends qq<d>
  {
    public d.a[] fA;
    public d.a[] fB;
    public c.c[] fC;
    
    public d()
    {
      h();
    }
    
    public void a(qp paramqp)
      throws IOException
    {
      if ((this.fA != null) && (this.fA.length > 0)) {
        for (int m = 0; m < this.fA.length; m++)
        {
          d.a locala2 = this.fA[m];
          if (locala2 != null) {
            paramqp.a(1, locala2);
          }
        }
      }
      if ((this.fB != null) && (this.fB.length > 0)) {
        for (int k = 0; k < this.fB.length; k++)
        {
          d.a locala1 = this.fB[k];
          if (locala1 != null) {
            paramqp.a(2, locala1);
          }
        }
      }
      if (this.fC != null)
      {
        int i = this.fC.length;
        int j = 0;
        if (i > 0) {
          while (j < this.fC.length)
          {
            c.c localc = this.fC[j];
            if (localc != null) {
              paramqp.a(3, localc);
            }
            j++;
          }
        }
      }
      super.a(paramqp);
    }
    
    protected int c()
    {
      int i = super.c();
      if ((this.fA != null) && (this.fA.length > 0))
      {
        int i1 = i;
        for (int i2 = 0; i2 < this.fA.length; i2++)
        {
          d.a locala2 = this.fA[i2];
          if (locala2 != null) {
            i1 += qp.c(1, locala2);
          }
        }
        i = i1;
      }
      if ((this.fB != null) && (this.fB.length > 0))
      {
        int m = i;
        for (int n = 0; n < this.fB.length; n++)
        {
          d.a locala1 = this.fB[n];
          if (locala1 != null) {
            m += qp.c(2, locala1);
          }
        }
        i = m;
      }
      if (this.fC != null)
      {
        int j = this.fC.length;
        int k = 0;
        if (j > 0) {
          while (k < this.fC.length)
          {
            c.c localc = this.fC[k];
            if (localc != null) {
              i += qp.c(3, localc);
            }
            k++;
          }
        }
      }
      return i;
    }
    
    public d e(qo paramqo)
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
          int i1 = qz.b(paramqo, 10);
          if (this.fA == null) {}
          d.a[] arrayOfa2;
          for (int i2 = 0;; i2 = this.fA.length)
          {
            arrayOfa2 = new d.a[i1 + i2];
            if (i2 != 0) {
              System.arraycopy(this.fA, 0, arrayOfa2, 0, i2);
            }
            while (i2 < -1 + arrayOfa2.length)
            {
              arrayOfa2[i2] = new d.a();
              paramqo.a(arrayOfa2[i2]);
              paramqo.rz();
              i2++;
            }
          }
          arrayOfa2[i2] = new d.a();
          paramqo.a(arrayOfa2[i2]);
          this.fA = arrayOfa2;
          break;
        case 18: 
          int m = qz.b(paramqo, 18);
          if (this.fB == null) {}
          d.a[] arrayOfa1;
          for (int n = 0;; n = this.fB.length)
          {
            arrayOfa1 = new d.a[m + n];
            if (n != 0) {
              System.arraycopy(this.fB, 0, arrayOfa1, 0, n);
            }
            while (n < -1 + arrayOfa1.length)
            {
              arrayOfa1[n] = new d.a();
              paramqo.a(arrayOfa1[n]);
              paramqo.rz();
              n++;
            }
          }
          arrayOfa1[n] = new d.a();
          paramqo.a(arrayOfa1[n]);
          this.fB = arrayOfa1;
          break;
        }
        int j = qz.b(paramqo, 26);
        if (this.fC == null) {}
        c.c[] arrayOfc;
        for (int k = 0;; k = this.fC.length)
        {
          arrayOfc = new c.c[j + k];
          if (k != 0) {
            System.arraycopy(this.fC, 0, arrayOfc, 0, k);
          }
          while (k < -1 + arrayOfc.length)
          {
            arrayOfc[k] = new c.c();
            paramqo.a(arrayOfc[k]);
            paramqo.rz();
            k++;
          }
        }
        arrayOfc[k] = new c.c();
        paramqo.a(arrayOfc[k]);
        this.fC = arrayOfc;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2;
      if (paramObject == this) {
        bool2 = true;
      }
      d locald;
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
              bool1 = paramObject instanceof d;
              bool2 = false;
            } while (!bool1);
            locald = (d)paramObject;
            bool3 = qu.equals(this.fA, locald.fA);
            bool2 = false;
          } while (!bool3);
          bool4 = qu.equals(this.fB, locald.fB);
          bool2 = false;
        } while (!bool4);
        bool5 = qu.equals(this.fC, locald.fC);
        bool2 = false;
      } while (!bool5);
      return a(locald);
    }
    
    public d h()
    {
      this.fA = d.a.r();
      this.fB = d.a.r();
      this.fC = c.c.f();
      this.ayW = null;
      this.azh = -1;
      return this;
    }
    
    public int hashCode()
    {
      return 31 * (31 * (31 * (527 + qu.hashCode(this.fA)) + qu.hashCode(this.fB)) + qu.hashCode(this.fC)) + rQ();
    }
  }
  
  public static final class e
    extends qq<e>
  {
    private static volatile e[] fD;
    public int key;
    public int value;
    
    public e()
    {
      j();
    }
    
    public static e[] i()
    {
      if (fD == null) {}
      synchronized (qu.azg)
      {
        if (fD == null) {
          fD = new e[0];
        }
        return fD;
      }
    }
    
    public void a(qp paramqp)
      throws IOException
    {
      paramqp.t(1, this.key);
      paramqp.t(2, this.value);
      super.a(paramqp);
    }
    
    protected int c()
    {
      return super.c() + qp.v(1, this.key) + qp.v(2, this.value);
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2;
      if (paramObject == this) {
        bool2 = true;
      }
      e locale;
      int k;
      int m;
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
            bool1 = paramObject instanceof e;
            bool2 = false;
          } while (!bool1);
          locale = (e)paramObject;
          i = this.key;
          j = locale.key;
          bool2 = false;
        } while (i != j);
        k = this.value;
        m = locale.value;
        bool2 = false;
      } while (k != m);
      return a(locale);
    }
    
    public e f(qo paramqo)
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
          this.key = paramqo.rC();
          break;
        }
        this.value = paramqo.rC();
      }
    }
    
    public int hashCode()
    {
      return 31 * (31 * (527 + this.key) + this.value) + rQ();
    }
    
    public e j()
    {
      this.key = 0;
      this.value = 0;
      this.ayW = null;
      this.azh = -1;
      return this;
    }
  }
  
  public static final class f
    extends qq<f>
  {
    public String[] fE;
    public String[] fF;
    public d.a[] fG;
    public c.e[] fH;
    public c.b[] fI;
    public c.b[] fJ;
    public c.b[] fK;
    public c.g[] fL;
    public String fM;
    public String fN;
    public String fO;
    public c.a fP;
    public float fQ;
    public boolean fR;
    public String[] fS;
    public int fT;
    public String version;
    
    public f()
    {
      k();
    }
    
    public static f a(byte[] paramArrayOfByte)
      throws qv
    {
      return (f)qw.a(new f(), paramArrayOfByte);
    }
    
    public void a(qp paramqp)
      throws IOException
    {
      if ((this.fF != null) && (this.fF.length > 0)) {
        for (int i5 = 0; i5 < this.fF.length; i5++)
        {
          String str3 = this.fF[i5];
          if (str3 != null) {
            paramqp.b(1, str3);
          }
        }
      }
      if ((this.fG != null) && (this.fG.length > 0)) {
        for (int i4 = 0; i4 < this.fG.length; i4++)
        {
          d.a locala = this.fG[i4];
          if (locala != null) {
            paramqp.a(2, locala);
          }
        }
      }
      if ((this.fH != null) && (this.fH.length > 0)) {
        for (int i3 = 0; i3 < this.fH.length; i3++)
        {
          c.e locale = this.fH[i3];
          if (locale != null) {
            paramqp.a(3, locale);
          }
        }
      }
      if ((this.fI != null) && (this.fI.length > 0)) {
        for (int i2 = 0; i2 < this.fI.length; i2++)
        {
          c.b localb3 = this.fI[i2];
          if (localb3 != null) {
            paramqp.a(4, localb3);
          }
        }
      }
      if ((this.fJ != null) && (this.fJ.length > 0)) {
        for (int i1 = 0; i1 < this.fJ.length; i1++)
        {
          c.b localb2 = this.fJ[i1];
          if (localb2 != null) {
            paramqp.a(5, localb2);
          }
        }
      }
      if ((this.fK != null) && (this.fK.length > 0)) {
        for (int n = 0; n < this.fK.length; n++)
        {
          c.b localb1 = this.fK[n];
          if (localb1 != null) {
            paramqp.a(6, localb1);
          }
        }
      }
      if ((this.fL != null) && (this.fL.length > 0)) {
        for (int m = 0; m < this.fL.length; m++)
        {
          c.g localg = this.fL[m];
          if (localg != null) {
            paramqp.a(7, localg);
          }
        }
      }
      if (!this.fM.equals("")) {
        paramqp.b(9, this.fM);
      }
      if (!this.fN.equals("")) {
        paramqp.b(10, this.fN);
      }
      if (!this.fO.equals("0")) {
        paramqp.b(12, this.fO);
      }
      if (!this.version.equals("")) {
        paramqp.b(13, this.version);
      }
      if (this.fP != null) {
        paramqp.a(14, this.fP);
      }
      if (Float.floatToIntBits(this.fQ) != Float.floatToIntBits(0.0F)) {
        paramqp.b(15, this.fQ);
      }
      if ((this.fS != null) && (this.fS.length > 0)) {
        for (int k = 0; k < this.fS.length; k++)
        {
          String str2 = this.fS[k];
          if (str2 != null) {
            paramqp.b(16, str2);
          }
        }
      }
      if (this.fT != 0) {
        paramqp.t(17, this.fT);
      }
      if (this.fR) {
        paramqp.b(18, this.fR);
      }
      if (this.fE != null)
      {
        int i = this.fE.length;
        int j = 0;
        if (i > 0) {
          while (j < this.fE.length)
          {
            String str1 = this.fE[j];
            if (str1 != null) {
              paramqp.b(19, str1);
            }
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
      int i17;
      int i18;
      if ((this.fF != null) && (this.fF.length > 0))
      {
        int i16 = 0;
        i17 = 0;
        i18 = 0;
        while (i16 < this.fF.length)
        {
          String str3 = this.fF[i16];
          if (str3 != null)
          {
            i18++;
            i17 += qp.dk(str3);
          }
          i16++;
        }
      }
      for (int k = j + i17 + i18 * 1;; k = j)
      {
        if ((this.fG != null) && (this.fG.length > 0))
        {
          int i14 = k;
          for (int i15 = 0; i15 < this.fG.length; i15++)
          {
            d.a locala = this.fG[i15];
            if (locala != null) {
              i14 += qp.c(2, locala);
            }
          }
          k = i14;
        }
        if ((this.fH != null) && (this.fH.length > 0))
        {
          int i12 = k;
          for (int i13 = 0; i13 < this.fH.length; i13++)
          {
            c.e locale = this.fH[i13];
            if (locale != null) {
              i12 += qp.c(3, locale);
            }
          }
          k = i12;
        }
        if ((this.fI != null) && (this.fI.length > 0))
        {
          int i10 = k;
          for (int i11 = 0; i11 < this.fI.length; i11++)
          {
            c.b localb3 = this.fI[i11];
            if (localb3 != null) {
              i10 += qp.c(4, localb3);
            }
          }
          k = i10;
        }
        if ((this.fJ != null) && (this.fJ.length > 0))
        {
          int i8 = k;
          for (int i9 = 0; i9 < this.fJ.length; i9++)
          {
            c.b localb2 = this.fJ[i9];
            if (localb2 != null) {
              i8 += qp.c(5, localb2);
            }
          }
          k = i8;
        }
        if ((this.fK != null) && (this.fK.length > 0))
        {
          int i6 = k;
          for (int i7 = 0; i7 < this.fK.length; i7++)
          {
            c.b localb1 = this.fK[i7];
            if (localb1 != null) {
              i6 += qp.c(6, localb1);
            }
          }
          k = i6;
        }
        if ((this.fL != null) && (this.fL.length > 0))
        {
          int i4 = k;
          for (int i5 = 0; i5 < this.fL.length; i5++)
          {
            c.g localg = this.fL[i5];
            if (localg != null) {
              i4 += qp.c(7, localg);
            }
          }
          k = i4;
        }
        if (!this.fM.equals("")) {
          k += qp.j(9, this.fM);
        }
        if (!this.fN.equals("")) {
          k += qp.j(10, this.fN);
        }
        if (!this.fO.equals("0")) {
          k += qp.j(12, this.fO);
        }
        if (!this.version.equals("")) {
          k += qp.j(13, this.version);
        }
        if (this.fP != null) {
          k += qp.c(14, this.fP);
        }
        if (Float.floatToIntBits(this.fQ) != Float.floatToIntBits(0.0F)) {
          k += qp.c(15, this.fQ);
        }
        if ((this.fS != null) && (this.fS.length > 0))
        {
          int i1 = 0;
          int i2 = 0;
          int i3 = 0;
          while (i1 < this.fS.length)
          {
            String str2 = this.fS[i1];
            if (str2 != null)
            {
              i3++;
              i2 += qp.dk(str2);
            }
            i1++;
          }
          k = k + i2 + i3 * 2;
        }
        if (this.fT != 0) {
          k += qp.v(17, this.fT);
        }
        if (this.fR) {
          k += qp.c(18, this.fR);
        }
        if ((this.fE != null) && (this.fE.length > 0))
        {
          int m = 0;
          int n = 0;
          while (i < this.fE.length)
          {
            String str1 = this.fE[i];
            if (str1 != null)
            {
              n++;
              m += qp.dk(str1);
            }
            i++;
          }
          k = k + m + n * 2;
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
      f localf;
      label215:
      label236:
      do
      {
        String str1;
        do
        {
          String str2;
          do
          {
            String str3;
            do
            {
              String str4;
              do
              {
                boolean bool10;
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
                        boolean bool6;
                        do
                        {
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
                                  bool1 = paramObject instanceof f;
                                  bool2 = false;
                                } while (!bool1);
                                localf = (f)paramObject;
                                bool3 = qu.equals(this.fE, localf.fE);
                                bool2 = false;
                              } while (!bool3);
                              bool4 = qu.equals(this.fF, localf.fF);
                              bool2 = false;
                            } while (!bool4);
                            bool5 = qu.equals(this.fG, localf.fG);
                            bool2 = false;
                          } while (!bool5);
                          bool6 = qu.equals(this.fH, localf.fH);
                          bool2 = false;
                        } while (!bool6);
                        bool7 = qu.equals(this.fI, localf.fI);
                        bool2 = false;
                      } while (!bool7);
                      bool8 = qu.equals(this.fJ, localf.fJ);
                      bool2 = false;
                    } while (!bool8);
                    bool9 = qu.equals(this.fK, localf.fK);
                    bool2 = false;
                  } while (!bool9);
                  bool10 = qu.equals(this.fL, localf.fL);
                  bool2 = false;
                } while (!bool10);
                if (this.fM != null) {
                  break;
                }
                str4 = localf.fM;
                bool2 = false;
              } while (str4 != null);
              if (this.fN != null) {
                break label416;
              }
              str3 = localf.fN;
              bool2 = false;
            } while (str3 != null);
            if (this.fO != null) {
              break label433;
            }
            str2 = localf.fO;
            bool2 = false;
          } while (str2 != null);
          if (this.version != null) {
            break label450;
          }
          str1 = localf.version;
          bool2 = false;
        } while (str1 != null);
        if (this.fP != null) {
          break label467;
        }
        locala = localf.fP;
        bool2 = false;
      } while (locala != null);
      label257:
      label278:
      label416:
      label433:
      label450:
      label467:
      while (this.fP.equals(localf.fP))
      {
        c.a locala;
        int i = Float.floatToIntBits(this.fQ);
        int j = Float.floatToIntBits(localf.fQ);
        bool2 = false;
        if (i != j) {
          break;
        }
        boolean bool11 = this.fR;
        boolean bool12 = localf.fR;
        bool2 = false;
        if (bool11 != bool12) {
          break;
        }
        boolean bool13 = qu.equals(this.fS, localf.fS);
        bool2 = false;
        if (!bool13) {
          break;
        }
        int k = this.fT;
        int m = localf.fT;
        bool2 = false;
        if (k != m) {
          break;
        }
        return a(localf);
        if (this.fM.equals(localf.fM)) {
          break label215;
        }
        return false;
        if (this.fN.equals(localf.fN)) {
          break label236;
        }
        return false;
        if (this.fO.equals(localf.fO)) {
          break label257;
        }
        return false;
        if (this.version.equals(localf.version)) {
          break label278;
        }
        return false;
      }
      return false;
    }
    
    public f g(qo paramqo)
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
          int i13 = qz.b(paramqo, 10);
          if (this.fF == null) {}
          String[] arrayOfString3;
          for (int i14 = 0;; i14 = this.fF.length)
          {
            arrayOfString3 = new String[i13 + i14];
            if (i14 != 0) {
              System.arraycopy(this.fF, 0, arrayOfString3, 0, i14);
            }
            while (i14 < -1 + arrayOfString3.length)
            {
              arrayOfString3[i14] = paramqo.readString();
              paramqo.rz();
              i14++;
            }
          }
          arrayOfString3[i14] = paramqo.readString();
          this.fF = arrayOfString3;
          break;
        case 18: 
          int i11 = qz.b(paramqo, 18);
          if (this.fG == null) {}
          d.a[] arrayOfa;
          for (int i12 = 0;; i12 = this.fG.length)
          {
            arrayOfa = new d.a[i11 + i12];
            if (i12 != 0) {
              System.arraycopy(this.fG, 0, arrayOfa, 0, i12);
            }
            while (i12 < -1 + arrayOfa.length)
            {
              arrayOfa[i12] = new d.a();
              paramqo.a(arrayOfa[i12]);
              paramqo.rz();
              i12++;
            }
          }
          arrayOfa[i12] = new d.a();
          paramqo.a(arrayOfa[i12]);
          this.fG = arrayOfa;
          break;
        case 26: 
          int i9 = qz.b(paramqo, 26);
          if (this.fH == null) {}
          c.e[] arrayOfe;
          for (int i10 = 0;; i10 = this.fH.length)
          {
            arrayOfe = new c.e[i9 + i10];
            if (i10 != 0) {
              System.arraycopy(this.fH, 0, arrayOfe, 0, i10);
            }
            while (i10 < -1 + arrayOfe.length)
            {
              arrayOfe[i10] = new c.e();
              paramqo.a(arrayOfe[i10]);
              paramqo.rz();
              i10++;
            }
          }
          arrayOfe[i10] = new c.e();
          paramqo.a(arrayOfe[i10]);
          this.fH = arrayOfe;
          break;
        case 34: 
          int i7 = qz.b(paramqo, 34);
          if (this.fI == null) {}
          c.b[] arrayOfb3;
          for (int i8 = 0;; i8 = this.fI.length)
          {
            arrayOfb3 = new c.b[i7 + i8];
            if (i8 != 0) {
              System.arraycopy(this.fI, 0, arrayOfb3, 0, i8);
            }
            while (i8 < -1 + arrayOfb3.length)
            {
              arrayOfb3[i8] = new c.b();
              paramqo.a(arrayOfb3[i8]);
              paramqo.rz();
              i8++;
            }
          }
          arrayOfb3[i8] = new c.b();
          paramqo.a(arrayOfb3[i8]);
          this.fI = arrayOfb3;
          break;
        case 42: 
          int i5 = qz.b(paramqo, 42);
          if (this.fJ == null) {}
          c.b[] arrayOfb2;
          for (int i6 = 0;; i6 = this.fJ.length)
          {
            arrayOfb2 = new c.b[i5 + i6];
            if (i6 != 0) {
              System.arraycopy(this.fJ, 0, arrayOfb2, 0, i6);
            }
            while (i6 < -1 + arrayOfb2.length)
            {
              arrayOfb2[i6] = new c.b();
              paramqo.a(arrayOfb2[i6]);
              paramqo.rz();
              i6++;
            }
          }
          arrayOfb2[i6] = new c.b();
          paramqo.a(arrayOfb2[i6]);
          this.fJ = arrayOfb2;
          break;
        case 50: 
          int i3 = qz.b(paramqo, 50);
          if (this.fK == null) {}
          c.b[] arrayOfb1;
          for (int i4 = 0;; i4 = this.fK.length)
          {
            arrayOfb1 = new c.b[i3 + i4];
            if (i4 != 0) {
              System.arraycopy(this.fK, 0, arrayOfb1, 0, i4);
            }
            while (i4 < -1 + arrayOfb1.length)
            {
              arrayOfb1[i4] = new c.b();
              paramqo.a(arrayOfb1[i4]);
              paramqo.rz();
              i4++;
            }
          }
          arrayOfb1[i4] = new c.b();
          paramqo.a(arrayOfb1[i4]);
          this.fK = arrayOfb1;
          break;
        case 58: 
          int i1 = qz.b(paramqo, 58);
          if (this.fL == null) {}
          c.g[] arrayOfg;
          for (int i2 = 0;; i2 = this.fL.length)
          {
            arrayOfg = new c.g[i1 + i2];
            if (i2 != 0) {
              System.arraycopy(this.fL, 0, arrayOfg, 0, i2);
            }
            while (i2 < -1 + arrayOfg.length)
            {
              arrayOfg[i2] = new c.g();
              paramqo.a(arrayOfg[i2]);
              paramqo.rz();
              i2++;
            }
          }
          arrayOfg[i2] = new c.g();
          paramqo.a(arrayOfg[i2]);
          this.fL = arrayOfg;
          break;
        case 74: 
          this.fM = paramqo.readString();
          break;
        case 82: 
          this.fN = paramqo.readString();
          break;
        case 98: 
          this.fO = paramqo.readString();
          break;
        case 106: 
          this.version = paramqo.readString();
          break;
        case 114: 
          if (this.fP == null) {
            this.fP = new c.a();
          }
          paramqo.a(this.fP);
          break;
        case 125: 
          this.fQ = paramqo.readFloat();
          break;
        case 130: 
          int m = qz.b(paramqo, 130);
          if (this.fS == null) {}
          String[] arrayOfString2;
          for (int n = 0;; n = this.fS.length)
          {
            arrayOfString2 = new String[m + n];
            if (n != 0) {
              System.arraycopy(this.fS, 0, arrayOfString2, 0, n);
            }
            while (n < -1 + arrayOfString2.length)
            {
              arrayOfString2[n] = paramqo.readString();
              paramqo.rz();
              n++;
            }
          }
          arrayOfString2[n] = paramqo.readString();
          this.fS = arrayOfString2;
          break;
        case 136: 
          this.fT = paramqo.rC();
          break;
        case 144: 
          this.fR = paramqo.rD();
          break;
        }
        int j = qz.b(paramqo, 154);
        if (this.fE == null) {}
        String[] arrayOfString1;
        for (int k = 0;; k = this.fE.length)
        {
          arrayOfString1 = new String[j + k];
          if (k != 0) {
            System.arraycopy(this.fE, 0, arrayOfString1, 0, k);
          }
          while (k < -1 + arrayOfString1.length)
          {
            arrayOfString1[k] = paramqo.readString();
            paramqo.rz();
            k++;
          }
        }
        arrayOfString1[k] = paramqo.readString();
        this.fE = arrayOfString1;
      }
    }
    
    public int hashCode()
    {
      int i = 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + qu.hashCode(this.fE)) + qu.hashCode(this.fF)) + qu.hashCode(this.fG)) + qu.hashCode(this.fH)) + qu.hashCode(this.fI)) + qu.hashCode(this.fJ)) + qu.hashCode(this.fK)) + qu.hashCode(this.fL));
      int j;
      int m;
      label118:
      int i1;
      label137:
      int i3;
      label157:
      int i5;
      label181:
      int i6;
      if (this.fM == null)
      {
        j = 0;
        int k = 31 * (j + i);
        if (this.fN != null) {
          break label258;
        }
        m = 0;
        int n = 31 * (m + k);
        if (this.fO != null) {
          break label270;
        }
        i1 = 0;
        int i2 = 31 * (i1 + n);
        if (this.version != null) {
          break label282;
        }
        i3 = 0;
        int i4 = 31 * (i3 + i2);
        c.a locala = this.fP;
        i5 = 0;
        if (locala != null) {
          break label294;
        }
        i6 = 31 * (31 * (i4 + i5) + Float.floatToIntBits(this.fQ));
        if (!this.fR) {
          break label306;
        }
      }
      label258:
      label270:
      label282:
      label294:
      label306:
      for (int i7 = 1231;; i7 = 1237)
      {
        return 31 * (31 * (31 * (i7 + i6) + qu.hashCode(this.fS)) + this.fT) + rQ();
        j = this.fM.hashCode();
        break;
        m = this.fN.hashCode();
        break label118;
        i1 = this.fO.hashCode();
        break label137;
        i3 = this.version.hashCode();
        break label157;
        i5 = this.fP.hashCode();
        break label181;
      }
    }
    
    public f k()
    {
      this.fE = qz.azo;
      this.fF = qz.azo;
      this.fG = d.a.r();
      this.fH = c.e.i();
      this.fI = c.b.d();
      this.fJ = c.b.d();
      this.fK = c.b.d();
      this.fL = c.g.l();
      this.fM = "";
      this.fN = "";
      this.fO = "0";
      this.version = "";
      this.fP = null;
      this.fQ = 0.0F;
      this.fR = false;
      this.fS = qz.azo;
      this.fT = 0;
      this.ayW = null;
      this.azh = -1;
      return this;
    }
  }
  
  public static final class g
    extends qq<g>
  {
    private static volatile g[] fU;
    public int[] fV;
    public int[] fW;
    public int[] fX;
    public int[] fY;
    public int[] fZ;
    public int[] ga;
    public int[] gb;
    public int[] gc;
    public int[] gd;
    public int[] ge;
    
    public g()
    {
      m();
    }
    
    public static g[] l()
    {
      if (fU == null) {}
      synchronized (qu.azg)
      {
        if (fU == null) {
          fU = new g[0];
        }
        return fU;
      }
    }
    
    public void a(qp paramqp)
      throws IOException
    {
      if ((this.fV != null) && (this.fV.length > 0)) {
        for (int i6 = 0; i6 < this.fV.length; i6++) {
          paramqp.t(1, this.fV[i6]);
        }
      }
      if ((this.fW != null) && (this.fW.length > 0)) {
        for (int i5 = 0; i5 < this.fW.length; i5++) {
          paramqp.t(2, this.fW[i5]);
        }
      }
      if ((this.fX != null) && (this.fX.length > 0)) {
        for (int i4 = 0; i4 < this.fX.length; i4++) {
          paramqp.t(3, this.fX[i4]);
        }
      }
      if ((this.fY != null) && (this.fY.length > 0)) {
        for (int i3 = 0; i3 < this.fY.length; i3++) {
          paramqp.t(4, this.fY[i3]);
        }
      }
      if ((this.fZ != null) && (this.fZ.length > 0)) {
        for (int i2 = 0; i2 < this.fZ.length; i2++) {
          paramqp.t(5, this.fZ[i2]);
        }
      }
      if ((this.ga != null) && (this.ga.length > 0)) {
        for (int i1 = 0; i1 < this.ga.length; i1++) {
          paramqp.t(6, this.ga[i1]);
        }
      }
      if ((this.gb != null) && (this.gb.length > 0)) {
        for (int n = 0; n < this.gb.length; n++) {
          paramqp.t(7, this.gb[n]);
        }
      }
      if ((this.gc != null) && (this.gc.length > 0)) {
        for (int m = 0; m < this.gc.length; m++) {
          paramqp.t(8, this.gc[m]);
        }
      }
      if ((this.gd != null) && (this.gd.length > 0)) {
        for (int k = 0; k < this.gd.length; k++) {
          paramqp.t(9, this.gd[k]);
        }
      }
      if (this.ge != null)
      {
        int i = this.ge.length;
        int j = 0;
        if (i > 0) {
          while (j < this.ge.length)
          {
            paramqp.t(10, this.ge[j]);
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
      int i17;
      if ((this.fV != null) && (this.fV.length > 0))
      {
        int i16 = 0;
        i17 = 0;
        while (i16 < this.fV.length)
        {
          i17 += qp.gZ(this.fV[i16]);
          i16++;
        }
      }
      for (int k = j + i17 + 1 * this.fV.length;; k = j)
      {
        if ((this.fW != null) && (this.fW.length > 0))
        {
          int i14 = 0;
          int i15 = 0;
          while (i14 < this.fW.length)
          {
            i15 += qp.gZ(this.fW[i14]);
            i14++;
          }
          k = k + i15 + 1 * this.fW.length;
        }
        if ((this.fX != null) && (this.fX.length > 0))
        {
          int i12 = 0;
          int i13 = 0;
          while (i12 < this.fX.length)
          {
            i13 += qp.gZ(this.fX[i12]);
            i12++;
          }
          k = k + i13 + 1 * this.fX.length;
        }
        if ((this.fY != null) && (this.fY.length > 0))
        {
          int i10 = 0;
          int i11 = 0;
          while (i10 < this.fY.length)
          {
            i11 += qp.gZ(this.fY[i10]);
            i10++;
          }
          k = k + i11 + 1 * this.fY.length;
        }
        if ((this.fZ != null) && (this.fZ.length > 0))
        {
          int i8 = 0;
          int i9 = 0;
          while (i8 < this.fZ.length)
          {
            i9 += qp.gZ(this.fZ[i8]);
            i8++;
          }
          k = k + i9 + 1 * this.fZ.length;
        }
        if ((this.ga != null) && (this.ga.length > 0))
        {
          int i6 = 0;
          int i7 = 0;
          while (i6 < this.ga.length)
          {
            i7 += qp.gZ(this.ga[i6]);
            i6++;
          }
          k = k + i7 + 1 * this.ga.length;
        }
        if ((this.gb != null) && (this.gb.length > 0))
        {
          int i4 = 0;
          int i5 = 0;
          while (i4 < this.gb.length)
          {
            i5 += qp.gZ(this.gb[i4]);
            i4++;
          }
          k = k + i5 + 1 * this.gb.length;
        }
        if ((this.gc != null) && (this.gc.length > 0))
        {
          int i2 = 0;
          int i3 = 0;
          while (i2 < this.gc.length)
          {
            i3 += qp.gZ(this.gc[i2]);
            i2++;
          }
          k = k + i3 + 1 * this.gc.length;
        }
        if ((this.gd != null) && (this.gd.length > 0))
        {
          int n = 0;
          int i1 = 0;
          while (n < this.gd.length)
          {
            i1 += qp.gZ(this.gd[n]);
            n++;
          }
          k = k + i1 + 1 * this.gd.length;
        }
        if ((this.ge != null) && (this.ge.length > 0))
        {
          int m = 0;
          while (i < this.ge.length)
          {
            m += qp.gZ(this.ge[i]);
            i++;
          }
          k = k + m + 1 * this.ge.length;
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
      g localg;
      boolean bool12;
      do
      {
        boolean bool11;
        do
        {
          boolean bool10;
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
                  boolean bool6;
                  do
                  {
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
                            bool1 = paramObject instanceof g;
                            bool2 = false;
                          } while (!bool1);
                          localg = (g)paramObject;
                          bool3 = qu.equals(this.fV, localg.fV);
                          bool2 = false;
                        } while (!bool3);
                        bool4 = qu.equals(this.fW, localg.fW);
                        bool2 = false;
                      } while (!bool4);
                      bool5 = qu.equals(this.fX, localg.fX);
                      bool2 = false;
                    } while (!bool5);
                    bool6 = qu.equals(this.fY, localg.fY);
                    bool2 = false;
                  } while (!bool6);
                  bool7 = qu.equals(this.fZ, localg.fZ);
                  bool2 = false;
                } while (!bool7);
                bool8 = qu.equals(this.ga, localg.ga);
                bool2 = false;
              } while (!bool8);
              bool9 = qu.equals(this.gb, localg.gb);
              bool2 = false;
            } while (!bool9);
            bool10 = qu.equals(this.gc, localg.gc);
            bool2 = false;
          } while (!bool10);
          bool11 = qu.equals(this.gd, localg.gd);
          bool2 = false;
        } while (!bool11);
        bool12 = qu.equals(this.ge, localg.ge);
        bool2 = false;
      } while (!bool12);
      return a(localg);
    }
    
    public g h(qo paramqo)
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
          int i55 = qz.b(paramqo, 8);
          if (this.fV == null) {}
          int[] arrayOfInt20;
          for (int i56 = 0;; i56 = this.fV.length)
          {
            arrayOfInt20 = new int[i55 + i56];
            if (i56 != 0) {
              System.arraycopy(this.fV, 0, arrayOfInt20, 0, i56);
            }
            while (i56 < -1 + arrayOfInt20.length)
            {
              arrayOfInt20[i56] = paramqo.rC();
              paramqo.rz();
              i56++;
            }
          }
          arrayOfInt20[i56] = paramqo.rC();
          this.fV = arrayOfInt20;
          break;
        case 10: 
          int i51 = paramqo.gS(paramqo.rG());
          int i52 = paramqo.getPosition();
          for (int i53 = 0; paramqo.rL() > 0; i53++) {
            paramqo.rC();
          }
          paramqo.gU(i52);
          if (this.fV == null) {}
          int[] arrayOfInt19;
          for (int i54 = 0;; i54 = this.fV.length)
          {
            arrayOfInt19 = new int[i53 + i54];
            if (i54 != 0) {
              System.arraycopy(this.fV, 0, arrayOfInt19, 0, i54);
            }
            while (i54 < arrayOfInt19.length)
            {
              arrayOfInt19[i54] = paramqo.rC();
              i54++;
            }
          }
          this.fV = arrayOfInt19;
          paramqo.gT(i51);
          break;
        case 16: 
          int i49 = qz.b(paramqo, 16);
          if (this.fW == null) {}
          int[] arrayOfInt18;
          for (int i50 = 0;; i50 = this.fW.length)
          {
            arrayOfInt18 = new int[i49 + i50];
            if (i50 != 0) {
              System.arraycopy(this.fW, 0, arrayOfInt18, 0, i50);
            }
            while (i50 < -1 + arrayOfInt18.length)
            {
              arrayOfInt18[i50] = paramqo.rC();
              paramqo.rz();
              i50++;
            }
          }
          arrayOfInt18[i50] = paramqo.rC();
          this.fW = arrayOfInt18;
          break;
        case 18: 
          int i45 = paramqo.gS(paramqo.rG());
          int i46 = paramqo.getPosition();
          for (int i47 = 0; paramqo.rL() > 0; i47++) {
            paramqo.rC();
          }
          paramqo.gU(i46);
          if (this.fW == null) {}
          int[] arrayOfInt17;
          for (int i48 = 0;; i48 = this.fW.length)
          {
            arrayOfInt17 = new int[i47 + i48];
            if (i48 != 0) {
              System.arraycopy(this.fW, 0, arrayOfInt17, 0, i48);
            }
            while (i48 < arrayOfInt17.length)
            {
              arrayOfInt17[i48] = paramqo.rC();
              i48++;
            }
          }
          this.fW = arrayOfInt17;
          paramqo.gT(i45);
          break;
        case 24: 
          int i43 = qz.b(paramqo, 24);
          if (this.fX == null) {}
          int[] arrayOfInt16;
          for (int i44 = 0;; i44 = this.fX.length)
          {
            arrayOfInt16 = new int[i43 + i44];
            if (i44 != 0) {
              System.arraycopy(this.fX, 0, arrayOfInt16, 0, i44);
            }
            while (i44 < -1 + arrayOfInt16.length)
            {
              arrayOfInt16[i44] = paramqo.rC();
              paramqo.rz();
              i44++;
            }
          }
          arrayOfInt16[i44] = paramqo.rC();
          this.fX = arrayOfInt16;
          break;
        case 26: 
          int i39 = paramqo.gS(paramqo.rG());
          int i40 = paramqo.getPosition();
          for (int i41 = 0; paramqo.rL() > 0; i41++) {
            paramqo.rC();
          }
          paramqo.gU(i40);
          if (this.fX == null) {}
          int[] arrayOfInt15;
          for (int i42 = 0;; i42 = this.fX.length)
          {
            arrayOfInt15 = new int[i41 + i42];
            if (i42 != 0) {
              System.arraycopy(this.fX, 0, arrayOfInt15, 0, i42);
            }
            while (i42 < arrayOfInt15.length)
            {
              arrayOfInt15[i42] = paramqo.rC();
              i42++;
            }
          }
          this.fX = arrayOfInt15;
          paramqo.gT(i39);
          break;
        case 32: 
          int i37 = qz.b(paramqo, 32);
          if (this.fY == null) {}
          int[] arrayOfInt14;
          for (int i38 = 0;; i38 = this.fY.length)
          {
            arrayOfInt14 = new int[i37 + i38];
            if (i38 != 0) {
              System.arraycopy(this.fY, 0, arrayOfInt14, 0, i38);
            }
            while (i38 < -1 + arrayOfInt14.length)
            {
              arrayOfInt14[i38] = paramqo.rC();
              paramqo.rz();
              i38++;
            }
          }
          arrayOfInt14[i38] = paramqo.rC();
          this.fY = arrayOfInt14;
          break;
        case 34: 
          int i33 = paramqo.gS(paramqo.rG());
          int i34 = paramqo.getPosition();
          for (int i35 = 0; paramqo.rL() > 0; i35++) {
            paramqo.rC();
          }
          paramqo.gU(i34);
          if (this.fY == null) {}
          int[] arrayOfInt13;
          for (int i36 = 0;; i36 = this.fY.length)
          {
            arrayOfInt13 = new int[i35 + i36];
            if (i36 != 0) {
              System.arraycopy(this.fY, 0, arrayOfInt13, 0, i36);
            }
            while (i36 < arrayOfInt13.length)
            {
              arrayOfInt13[i36] = paramqo.rC();
              i36++;
            }
          }
          this.fY = arrayOfInt13;
          paramqo.gT(i33);
          break;
        case 40: 
          int i31 = qz.b(paramqo, 40);
          if (this.fZ == null) {}
          int[] arrayOfInt12;
          for (int i32 = 0;; i32 = this.fZ.length)
          {
            arrayOfInt12 = new int[i31 + i32];
            if (i32 != 0) {
              System.arraycopy(this.fZ, 0, arrayOfInt12, 0, i32);
            }
            while (i32 < -1 + arrayOfInt12.length)
            {
              arrayOfInt12[i32] = paramqo.rC();
              paramqo.rz();
              i32++;
            }
          }
          arrayOfInt12[i32] = paramqo.rC();
          this.fZ = arrayOfInt12;
          break;
        case 42: 
          int i27 = paramqo.gS(paramqo.rG());
          int i28 = paramqo.getPosition();
          for (int i29 = 0; paramqo.rL() > 0; i29++) {
            paramqo.rC();
          }
          paramqo.gU(i28);
          if (this.fZ == null) {}
          int[] arrayOfInt11;
          for (int i30 = 0;; i30 = this.fZ.length)
          {
            arrayOfInt11 = new int[i29 + i30];
            if (i30 != 0) {
              System.arraycopy(this.fZ, 0, arrayOfInt11, 0, i30);
            }
            while (i30 < arrayOfInt11.length)
            {
              arrayOfInt11[i30] = paramqo.rC();
              i30++;
            }
          }
          this.fZ = arrayOfInt11;
          paramqo.gT(i27);
          break;
        case 48: 
          int i25 = qz.b(paramqo, 48);
          if (this.ga == null) {}
          int[] arrayOfInt10;
          for (int i26 = 0;; i26 = this.ga.length)
          {
            arrayOfInt10 = new int[i25 + i26];
            if (i26 != 0) {
              System.arraycopy(this.ga, 0, arrayOfInt10, 0, i26);
            }
            while (i26 < -1 + arrayOfInt10.length)
            {
              arrayOfInt10[i26] = paramqo.rC();
              paramqo.rz();
              i26++;
            }
          }
          arrayOfInt10[i26] = paramqo.rC();
          this.ga = arrayOfInt10;
          break;
        case 50: 
          int i21 = paramqo.gS(paramqo.rG());
          int i22 = paramqo.getPosition();
          for (int i23 = 0; paramqo.rL() > 0; i23++) {
            paramqo.rC();
          }
          paramqo.gU(i22);
          if (this.ga == null) {}
          int[] arrayOfInt9;
          for (int i24 = 0;; i24 = this.ga.length)
          {
            arrayOfInt9 = new int[i23 + i24];
            if (i24 != 0) {
              System.arraycopy(this.ga, 0, arrayOfInt9, 0, i24);
            }
            while (i24 < arrayOfInt9.length)
            {
              arrayOfInt9[i24] = paramqo.rC();
              i24++;
            }
          }
          this.ga = arrayOfInt9;
          paramqo.gT(i21);
          break;
        case 56: 
          int i19 = qz.b(paramqo, 56);
          if (this.gb == null) {}
          int[] arrayOfInt8;
          for (int i20 = 0;; i20 = this.gb.length)
          {
            arrayOfInt8 = new int[i19 + i20];
            if (i20 != 0) {
              System.arraycopy(this.gb, 0, arrayOfInt8, 0, i20);
            }
            while (i20 < -1 + arrayOfInt8.length)
            {
              arrayOfInt8[i20] = paramqo.rC();
              paramqo.rz();
              i20++;
            }
          }
          arrayOfInt8[i20] = paramqo.rC();
          this.gb = arrayOfInt8;
          break;
        case 58: 
          int i15 = paramqo.gS(paramqo.rG());
          int i16 = paramqo.getPosition();
          for (int i17 = 0; paramqo.rL() > 0; i17++) {
            paramqo.rC();
          }
          paramqo.gU(i16);
          if (this.gb == null) {}
          int[] arrayOfInt7;
          for (int i18 = 0;; i18 = this.gb.length)
          {
            arrayOfInt7 = new int[i17 + i18];
            if (i18 != 0) {
              System.arraycopy(this.gb, 0, arrayOfInt7, 0, i18);
            }
            while (i18 < arrayOfInt7.length)
            {
              arrayOfInt7[i18] = paramqo.rC();
              i18++;
            }
          }
          this.gb = arrayOfInt7;
          paramqo.gT(i15);
          break;
        case 64: 
          int i13 = qz.b(paramqo, 64);
          if (this.gc == null) {}
          int[] arrayOfInt6;
          for (int i14 = 0;; i14 = this.gc.length)
          {
            arrayOfInt6 = new int[i13 + i14];
            if (i14 != 0) {
              System.arraycopy(this.gc, 0, arrayOfInt6, 0, i14);
            }
            while (i14 < -1 + arrayOfInt6.length)
            {
              arrayOfInt6[i14] = paramqo.rC();
              paramqo.rz();
              i14++;
            }
          }
          arrayOfInt6[i14] = paramqo.rC();
          this.gc = arrayOfInt6;
          break;
        case 66: 
          int i9 = paramqo.gS(paramqo.rG());
          int i10 = paramqo.getPosition();
          for (int i11 = 0; paramqo.rL() > 0; i11++) {
            paramqo.rC();
          }
          paramqo.gU(i10);
          if (this.gc == null) {}
          int[] arrayOfInt5;
          for (int i12 = 0;; i12 = this.gc.length)
          {
            arrayOfInt5 = new int[i11 + i12];
            if (i12 != 0) {
              System.arraycopy(this.gc, 0, arrayOfInt5, 0, i12);
            }
            while (i12 < arrayOfInt5.length)
            {
              arrayOfInt5[i12] = paramqo.rC();
              i12++;
            }
          }
          this.gc = arrayOfInt5;
          paramqo.gT(i9);
          break;
        case 72: 
          int i7 = qz.b(paramqo, 72);
          if (this.gd == null) {}
          int[] arrayOfInt4;
          for (int i8 = 0;; i8 = this.gd.length)
          {
            arrayOfInt4 = new int[i7 + i8];
            if (i8 != 0) {
              System.arraycopy(this.gd, 0, arrayOfInt4, 0, i8);
            }
            while (i8 < -1 + arrayOfInt4.length)
            {
              arrayOfInt4[i8] = paramqo.rC();
              paramqo.rz();
              i8++;
            }
          }
          arrayOfInt4[i8] = paramqo.rC();
          this.gd = arrayOfInt4;
          break;
        case 74: 
          int i3 = paramqo.gS(paramqo.rG());
          int i4 = paramqo.getPosition();
          for (int i5 = 0; paramqo.rL() > 0; i5++) {
            paramqo.rC();
          }
          paramqo.gU(i4);
          if (this.gd == null) {}
          int[] arrayOfInt3;
          for (int i6 = 0;; i6 = this.gd.length)
          {
            arrayOfInt3 = new int[i5 + i6];
            if (i6 != 0) {
              System.arraycopy(this.gd, 0, arrayOfInt3, 0, i6);
            }
            while (i6 < arrayOfInt3.length)
            {
              arrayOfInt3[i6] = paramqo.rC();
              i6++;
            }
          }
          this.gd = arrayOfInt3;
          paramqo.gT(i3);
          break;
        case 80: 
          int i1 = qz.b(paramqo, 80);
          if (this.ge == null) {}
          int[] arrayOfInt2;
          for (int i2 = 0;; i2 = this.ge.length)
          {
            arrayOfInt2 = new int[i1 + i2];
            if (i2 != 0) {
              System.arraycopy(this.ge, 0, arrayOfInt2, 0, i2);
            }
            while (i2 < -1 + arrayOfInt2.length)
            {
              arrayOfInt2[i2] = paramqo.rC();
              paramqo.rz();
              i2++;
            }
          }
          arrayOfInt2[i2] = paramqo.rC();
          this.ge = arrayOfInt2;
          break;
        }
        int j = paramqo.gS(paramqo.rG());
        int k = paramqo.getPosition();
        for (int m = 0; paramqo.rL() > 0; m++) {
          paramqo.rC();
        }
        paramqo.gU(k);
        if (this.ge == null) {}
        int[] arrayOfInt1;
        for (int n = 0;; n = this.ge.length)
        {
          arrayOfInt1 = new int[m + n];
          if (n != 0) {
            System.arraycopy(this.ge, 0, arrayOfInt1, 0, n);
          }
          while (n < arrayOfInt1.length)
          {
            arrayOfInt1[n] = paramqo.rC();
            n++;
          }
        }
        this.ge = arrayOfInt1;
        paramqo.gT(j);
      }
    }
    
    public int hashCode()
    {
      return 31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + qu.hashCode(this.fV)) + qu.hashCode(this.fW)) + qu.hashCode(this.fX)) + qu.hashCode(this.fY)) + qu.hashCode(this.fZ)) + qu.hashCode(this.ga)) + qu.hashCode(this.gb)) + qu.hashCode(this.gc)) + qu.hashCode(this.gd)) + qu.hashCode(this.ge)) + rQ();
    }
    
    public g m()
    {
      this.fV = qz.azj;
      this.fW = qz.azj;
      this.fX = qz.azj;
      this.fY = qz.azj;
      this.fZ = qz.azj;
      this.ga = qz.azj;
      this.gb = qz.azj;
      this.gc = qz.azj;
      this.gd = qz.azj;
      this.ge = qz.azj;
      this.ayW = null;
      this.azh = -1;
      return this;
    }
  }
  
  public static final class h
    extends qq<h>
  {
    public static final qr<d.a, h> gf = qr.a(11, h.class, 810);
    private static final h[] gg = new h[0];
    public int[] gh;
    public int[] gi;
    public int[] gj;
    public int gk;
    public int[] gl;
    public int gm;
    public int gn;
    
    public h()
    {
      n();
    }
    
    public void a(qp paramqp)
      throws IOException
    {
      if ((this.gh != null) && (this.gh.length > 0)) {
        for (int n = 0; n < this.gh.length; n++) {
          paramqp.t(1, this.gh[n]);
        }
      }
      if ((this.gi != null) && (this.gi.length > 0)) {
        for (int m = 0; m < this.gi.length; m++) {
          paramqp.t(2, this.gi[m]);
        }
      }
      if ((this.gj != null) && (this.gj.length > 0)) {
        for (int k = 0; k < this.gj.length; k++) {
          paramqp.t(3, this.gj[k]);
        }
      }
      if (this.gk != 0) {
        paramqp.t(4, this.gk);
      }
      if (this.gl != null)
      {
        int i = this.gl.length;
        int j = 0;
        if (i > 0) {
          while (j < this.gl.length)
          {
            paramqp.t(5, this.gl[j]);
            j++;
          }
        }
      }
      if (this.gm != 0) {
        paramqp.t(6, this.gm);
      }
      if (this.gn != 0) {
        paramqp.t(7, this.gn);
      }
      super.a(paramqp);
    }
    
    protected int c()
    {
      int i = 0;
      int j = super.c();
      int i5;
      if ((this.gh != null) && (this.gh.length > 0))
      {
        int i4 = 0;
        i5 = 0;
        while (i4 < this.gh.length)
        {
          i5 += qp.gZ(this.gh[i4]);
          i4++;
        }
      }
      for (int k = j + i5 + 1 * this.gh.length;; k = j)
      {
        if ((this.gi != null) && (this.gi.length > 0))
        {
          int i2 = 0;
          int i3 = 0;
          while (i2 < this.gi.length)
          {
            i3 += qp.gZ(this.gi[i2]);
            i2++;
          }
          k = k + i3 + 1 * this.gi.length;
        }
        if ((this.gj != null) && (this.gj.length > 0))
        {
          int n = 0;
          int i1 = 0;
          while (n < this.gj.length)
          {
            i1 += qp.gZ(this.gj[n]);
            n++;
          }
          k = k + i1 + 1 * this.gj.length;
        }
        if (this.gk != 0) {
          k += qp.v(4, this.gk);
        }
        if ((this.gl != null) && (this.gl.length > 0))
        {
          int m = 0;
          while (i < this.gl.length)
          {
            m += qp.gZ(this.gl[i]);
            i++;
          }
          k = k + m + 1 * this.gl.length;
        }
        if (this.gm != 0) {
          k += qp.v(6, this.gm);
        }
        if (this.gn != 0) {
          k += qp.v(7, this.gn);
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
      h localh;
      int n;
      int i1;
      do
      {
        int k;
        int m;
        do
        {
          boolean bool6;
          do
          {
            int i;
            int j;
            do
            {
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
                      bool1 = paramObject instanceof h;
                      bool2 = false;
                    } while (!bool1);
                    localh = (h)paramObject;
                    bool3 = qu.equals(this.gh, localh.gh);
                    bool2 = false;
                  } while (!bool3);
                  bool4 = qu.equals(this.gi, localh.gi);
                  bool2 = false;
                } while (!bool4);
                bool5 = qu.equals(this.gj, localh.gj);
                bool2 = false;
              } while (!bool5);
              i = this.gk;
              j = localh.gk;
              bool2 = false;
            } while (i != j);
            bool6 = qu.equals(this.gl, localh.gl);
            bool2 = false;
          } while (!bool6);
          k = this.gm;
          m = localh.gm;
          bool2 = false;
        } while (k != m);
        n = this.gn;
        i1 = localh.gn;
        bool2 = false;
      } while (n != i1);
      return a(localh);
    }
    
    public int hashCode()
    {
      return 31 * (31 * (31 * (31 * (31 * (31 * (31 * (527 + qu.hashCode(this.gh)) + qu.hashCode(this.gi)) + qu.hashCode(this.gj)) + this.gk) + qu.hashCode(this.gl)) + this.gm) + this.gn) + rQ();
    }
    
    public h i(qo paramqo)
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
          int i19 = qz.b(paramqo, 8);
          if (this.gh == null) {}
          int[] arrayOfInt8;
          for (int i20 = 0;; i20 = this.gh.length)
          {
            arrayOfInt8 = new int[i19 + i20];
            if (i20 != 0) {
              System.arraycopy(this.gh, 0, arrayOfInt8, 0, i20);
            }
            while (i20 < -1 + arrayOfInt8.length)
            {
              arrayOfInt8[i20] = paramqo.rC();
              paramqo.rz();
              i20++;
            }
          }
          arrayOfInt8[i20] = paramqo.rC();
          this.gh = arrayOfInt8;
          break;
        case 10: 
          int i15 = paramqo.gS(paramqo.rG());
          int i16 = paramqo.getPosition();
          for (int i17 = 0; paramqo.rL() > 0; i17++) {
            paramqo.rC();
          }
          paramqo.gU(i16);
          if (this.gh == null) {}
          int[] arrayOfInt7;
          for (int i18 = 0;; i18 = this.gh.length)
          {
            arrayOfInt7 = new int[i17 + i18];
            if (i18 != 0) {
              System.arraycopy(this.gh, 0, arrayOfInt7, 0, i18);
            }
            while (i18 < arrayOfInt7.length)
            {
              arrayOfInt7[i18] = paramqo.rC();
              i18++;
            }
          }
          this.gh = arrayOfInt7;
          paramqo.gT(i15);
          break;
        case 16: 
          int i13 = qz.b(paramqo, 16);
          if (this.gi == null) {}
          int[] arrayOfInt6;
          for (int i14 = 0;; i14 = this.gi.length)
          {
            arrayOfInt6 = new int[i13 + i14];
            if (i14 != 0) {
              System.arraycopy(this.gi, 0, arrayOfInt6, 0, i14);
            }
            while (i14 < -1 + arrayOfInt6.length)
            {
              arrayOfInt6[i14] = paramqo.rC();
              paramqo.rz();
              i14++;
            }
          }
          arrayOfInt6[i14] = paramqo.rC();
          this.gi = arrayOfInt6;
          break;
        case 18: 
          int i9 = paramqo.gS(paramqo.rG());
          int i10 = paramqo.getPosition();
          for (int i11 = 0; paramqo.rL() > 0; i11++) {
            paramqo.rC();
          }
          paramqo.gU(i10);
          if (this.gi == null) {}
          int[] arrayOfInt5;
          for (int i12 = 0;; i12 = this.gi.length)
          {
            arrayOfInt5 = new int[i11 + i12];
            if (i12 != 0) {
              System.arraycopy(this.gi, 0, arrayOfInt5, 0, i12);
            }
            while (i12 < arrayOfInt5.length)
            {
              arrayOfInt5[i12] = paramqo.rC();
              i12++;
            }
          }
          this.gi = arrayOfInt5;
          paramqo.gT(i9);
          break;
        case 24: 
          int i7 = qz.b(paramqo, 24);
          if (this.gj == null) {}
          int[] arrayOfInt4;
          for (int i8 = 0;; i8 = this.gj.length)
          {
            arrayOfInt4 = new int[i7 + i8];
            if (i8 != 0) {
              System.arraycopy(this.gj, 0, arrayOfInt4, 0, i8);
            }
            while (i8 < -1 + arrayOfInt4.length)
            {
              arrayOfInt4[i8] = paramqo.rC();
              paramqo.rz();
              i8++;
            }
          }
          arrayOfInt4[i8] = paramqo.rC();
          this.gj = arrayOfInt4;
          break;
        case 26: 
          int i3 = paramqo.gS(paramqo.rG());
          int i4 = paramqo.getPosition();
          for (int i5 = 0; paramqo.rL() > 0; i5++) {
            paramqo.rC();
          }
          paramqo.gU(i4);
          if (this.gj == null) {}
          int[] arrayOfInt3;
          for (int i6 = 0;; i6 = this.gj.length)
          {
            arrayOfInt3 = new int[i5 + i6];
            if (i6 != 0) {
              System.arraycopy(this.gj, 0, arrayOfInt3, 0, i6);
            }
            while (i6 < arrayOfInt3.length)
            {
              arrayOfInt3[i6] = paramqo.rC();
              i6++;
            }
          }
          this.gj = arrayOfInt3;
          paramqo.gT(i3);
          break;
        case 32: 
          this.gk = paramqo.rC();
          break;
        case 40: 
          int i1 = qz.b(paramqo, 40);
          if (this.gl == null) {}
          int[] arrayOfInt2;
          for (int i2 = 0;; i2 = this.gl.length)
          {
            arrayOfInt2 = new int[i1 + i2];
            if (i2 != 0) {
              System.arraycopy(this.gl, 0, arrayOfInt2, 0, i2);
            }
            while (i2 < -1 + arrayOfInt2.length)
            {
              arrayOfInt2[i2] = paramqo.rC();
              paramqo.rz();
              i2++;
            }
          }
          arrayOfInt2[i2] = paramqo.rC();
          this.gl = arrayOfInt2;
          break;
        case 42: 
          int j = paramqo.gS(paramqo.rG());
          int k = paramqo.getPosition();
          for (int m = 0; paramqo.rL() > 0; m++) {
            paramqo.rC();
          }
          paramqo.gU(k);
          if (this.gl == null) {}
          int[] arrayOfInt1;
          for (int n = 0;; n = this.gl.length)
          {
            arrayOfInt1 = new int[m + n];
            if (n != 0) {
              System.arraycopy(this.gl, 0, arrayOfInt1, 0, n);
            }
            while (n < arrayOfInt1.length)
            {
              arrayOfInt1[n] = paramqo.rC();
              n++;
            }
          }
          this.gl = arrayOfInt1;
          paramqo.gT(j);
          break;
        case 48: 
          this.gm = paramqo.rC();
          break;
        }
        this.gn = paramqo.rC();
      }
    }
    
    public h n()
    {
      this.gh = qz.azj;
      this.gi = qz.azj;
      this.gj = qz.azj;
      this.gk = 0;
      this.gl = qz.azj;
      this.gm = 0;
      this.gn = 0;
      this.ayW = null;
      this.azh = -1;
      return this;
    }
  }
  
  public static final class i
    extends qq<i>
  {
    private static volatile i[] go;
    public d.a gp;
    public c.d gq;
    public String name;
    
    public i()
    {
      p();
    }
    
    public static i[] o()
    {
      if (go == null) {}
      synchronized (qu.azg)
      {
        if (go == null) {
          go = new i[0];
        }
        return go;
      }
    }
    
    public void a(qp paramqp)
      throws IOException
    {
      if (!this.name.equals("")) {
        paramqp.b(1, this.name);
      }
      if (this.gp != null) {
        paramqp.a(2, this.gp);
      }
      if (this.gq != null) {
        paramqp.a(3, this.gq);
      }
      super.a(paramqp);
    }
    
    protected int c()
    {
      int i = super.c();
      if (!this.name.equals("")) {
        i += qp.j(1, this.name);
      }
      if (this.gp != null) {
        i += qp.c(2, this.gp);
      }
      if (this.gq != null) {
        i += qp.c(3, this.gq);
      }
      return i;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2;
      if (paramObject == this) {
        bool2 = true;
      }
      i locali;
      label68:
      do
      {
        d.a locala;
        do
        {
          String str;
          do
          {
            boolean bool1;
            do
            {
              return bool2;
              bool1 = paramObject instanceof i;
              bool2 = false;
            } while (!bool1);
            locali = (i)paramObject;
            if (this.name != null) {
              break;
            }
            str = locali.name;
            bool2 = false;
          } while (str != null);
          if (this.gp != null) {
            break label113;
          }
          locala = locali.gp;
          bool2 = false;
        } while (locala != null);
        if (this.gq != null) {
          break label130;
        }
        locald = locali.gq;
        bool2 = false;
      } while (locald != null);
      label113:
      while (this.gq.equals(locali.gq))
      {
        c.d locald;
        return a(locali);
        if (this.name.equals(locali.name)) {
          break;
        }
        return false;
        if (this.gp.equals(locali.gp)) {
          break label68;
        }
        return false;
      }
      label130:
      return false;
    }
    
    public int hashCode()
    {
      int i;
      int k;
      label27:
      int m;
      int n;
      if (this.name == null)
      {
        i = 0;
        int j = 31 * (i + 527);
        if (this.gp != null) {
          break label74;
        }
        k = 0;
        m = 31 * (k + j);
        c.d locald = this.gq;
        n = 0;
        if (locald != null) {
          break label85;
        }
      }
      for (;;)
      {
        return 31 * (m + n) + rQ();
        i = this.name.hashCode();
        break;
        label74:
        k = this.gp.hashCode();
        break label27;
        label85:
        n = this.gq.hashCode();
      }
    }
    
    public i j(qo paramqo)
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
          this.name = paramqo.readString();
          break;
        case 18: 
          if (this.gp == null) {
            this.gp = new d.a();
          }
          paramqo.a(this.gp);
          break;
        }
        if (this.gq == null) {
          this.gq = new c.d();
        }
        paramqo.a(this.gq);
      }
    }
    
    public i p()
    {
      this.name = "";
      this.gp = null;
      this.gq = null;
      this.ayW = null;
      this.azh = -1;
      return this;
    }
  }
  
  public static final class j
    extends qq<j>
  {
    public c.i[] gr;
    public c.f gs;
    public String gt;
    
    public j()
    {
      q();
    }
    
    public static j b(byte[] paramArrayOfByte)
      throws qv
    {
      return (j)qw.a(new j(), paramArrayOfByte);
    }
    
    public void a(qp paramqp)
      throws IOException
    {
      if ((this.gr != null) && (this.gr.length > 0)) {
        for (int i = 0; i < this.gr.length; i++)
        {
          c.i locali = this.gr[i];
          if (locali != null) {
            paramqp.a(1, locali);
          }
        }
      }
      if (this.gs != null) {
        paramqp.a(2, this.gs);
      }
      if (!this.gt.equals("")) {
        paramqp.b(3, this.gt);
      }
      super.a(paramqp);
    }
    
    protected int c()
    {
      int i = super.c();
      if ((this.gr != null) && (this.gr.length > 0)) {
        for (int j = 0; j < this.gr.length; j++)
        {
          c.i locali = this.gr[j];
          if (locali != null) {
            i += qp.c(1, locali);
          }
        }
      }
      if (this.gs != null) {
        i += qp.c(2, this.gs);
      }
      if (!this.gt.equals("")) {
        i += qp.j(3, this.gt);
      }
      return i;
    }
    
    public boolean equals(Object paramObject)
    {
      boolean bool2;
      if (paramObject == this) {
        bool2 = true;
      }
      j localj;
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
              bool1 = paramObject instanceof j;
              bool2 = false;
            } while (!bool1);
            localj = (j)paramObject;
            bool3 = qu.equals(this.gr, localj.gr);
            bool2 = false;
          } while (!bool3);
          if (this.gs != null) {
            break;
          }
          localf = localj.gs;
          bool2 = false;
        } while (localf != null);
        if (this.gt != null) {
          break label113;
        }
        str = localj.gt;
        bool2 = false;
      } while (str != null);
      label113:
      while (this.gt.equals(localj.gt))
      {
        String str;
        return a(localj);
        if (this.gs.equals(localj.gs)) {
          break;
        }
        return false;
      }
      return false;
    }
    
    public int hashCode()
    {
      int i = 31 * (527 + qu.hashCode(this.gr));
      int j;
      int k;
      int m;
      if (this.gs == null)
      {
        j = 0;
        k = 31 * (j + i);
        String str = this.gt;
        m = 0;
        if (str != null) {
          break label69;
        }
      }
      for (;;)
      {
        return 31 * (k + m) + rQ();
        j = this.gs.hashCode();
        break;
        label69:
        m = this.gt.hashCode();
      }
    }
    
    public j k(qo paramqo)
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
          int j = qz.b(paramqo, 10);
          if (this.gr == null) {}
          c.i[] arrayOfi;
          for (int k = 0;; k = this.gr.length)
          {
            arrayOfi = new c.i[j + k];
            if (k != 0) {
              System.arraycopy(this.gr, 0, arrayOfi, 0, k);
            }
            while (k < -1 + arrayOfi.length)
            {
              arrayOfi[k] = new c.i();
              paramqo.a(arrayOfi[k]);
              paramqo.rz();
              k++;
            }
          }
          arrayOfi[k] = new c.i();
          paramqo.a(arrayOfi[k]);
          this.gr = arrayOfi;
          break;
        case 18: 
          if (this.gs == null) {
            this.gs = new c.f();
          }
          paramqo.a(this.gs);
          break;
        }
        this.gt = paramqo.readString();
      }
    }
    
    public j q()
    {
      this.gr = c.i.o();
      this.gs = null;
      this.gt = "";
      this.ayW = null;
      this.azh = -1;
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.c
 * JD-Core Version:    0.7.0.1
 */