package com.google.android.gms.internal;

import java.io.IOException;
import java.util.Arrays;

public final class qm
  extends qq<qm>
{
  public a[] ayq;
  
  public qm()
  {
    rt();
  }
  
  public static qm n(byte[] paramArrayOfByte)
    throws qv
  {
    return (qm)qw.a(new qm(), paramArrayOfByte);
  }
  
  public void a(qp paramqp)
    throws IOException
  {
    if ((this.ayq != null) && (this.ayq.length > 0)) {
      for (int i = 0; i < this.ayq.length; i++)
      {
        a locala = this.ayq[i];
        if (locala != null) {
          paramqp.a(1, locala);
        }
      }
    }
    super.a(paramqp);
  }
  
  protected int c()
  {
    int i = super.c();
    if ((this.ayq != null) && (this.ayq.length > 0)) {
      for (int j = 0; j < this.ayq.length; j++)
      {
        a locala = this.ayq[j];
        if (locala != null) {
          i += qp.c(1, locala);
        }
      }
    }
    return i;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2;
    if (paramObject == this) {
      bool2 = true;
    }
    qm localqm;
    boolean bool3;
    do
    {
      boolean bool1;
      do
      {
        return bool2;
        bool1 = paramObject instanceof qm;
        bool2 = false;
      } while (!bool1);
      localqm = (qm)paramObject;
      bool3 = qu.equals(this.ayq, localqm.ayq);
      bool2 = false;
    } while (!bool3);
    return a(localqm);
  }
  
  public int hashCode()
  {
    return 31 * (527 + qu.hashCode(this.ayq)) + rQ();
  }
  
  public qm rt()
  {
    this.ayq = a.ru();
    this.ayW = null;
    this.azh = -1;
    return this;
  }
  
  public qm t(qo paramqo)
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
      }
      int j = qz.b(paramqo, 10);
      if (this.ayq == null) {}
      a[] arrayOfa;
      for (int k = 0;; k = this.ayq.length)
      {
        arrayOfa = new a[j + k];
        if (k != 0) {
          System.arraycopy(this.ayq, 0, arrayOfa, 0, k);
        }
        while (k < -1 + arrayOfa.length)
        {
          arrayOfa[k] = new a();
          paramqo.a(arrayOfa[k]);
          paramqo.rz();
          k++;
        }
      }
      arrayOfa[k] = new a();
      paramqo.a(arrayOfa[k]);
      this.ayq = arrayOfa;
    }
  }
  
  public static final class a
    extends qq<a>
  {
    private static volatile a[] ayr;
    public a ays;
    public String name;
    
    public a()
    {
      rv();
    }
    
    public static a[] ru()
    {
      if (ayr == null) {}
      synchronized (qu.azg)
      {
        if (ayr == null) {
          ayr = new a[0];
        }
        return ayr;
      }
    }
    
    public void a(qp paramqp)
      throws IOException
    {
      paramqp.b(1, this.name);
      if (this.ays != null) {
        paramqp.a(2, this.ays);
      }
      super.a(paramqp);
    }
    
    protected int c()
    {
      int i = super.c() + qp.j(1, this.name);
      if (this.ays != null) {
        i += qp.c(2, this.ays);
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
        String str;
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
          if (this.name != null) {
            break;
          }
          str = locala.name;
          bool2 = false;
        } while (str != null);
        if (this.ays != null) {
          break label92;
        }
        locala1 = locala.ays;
        bool2 = false;
      } while (locala1 != null);
      label92:
      while (this.ays.equals(locala.ays))
      {
        a locala1;
        return a(locala);
        if (this.name.equals(locala.name)) {
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
      if (this.name == null)
      {
        i = 0;
        j = 31 * (i + 527);
        a locala = this.ays;
        k = 0;
        if (locala != null) {
          break label54;
        }
      }
      for (;;)
      {
        return 31 * (j + k) + rQ();
        i = this.name.hashCode();
        break;
        label54:
        k = this.ays.hashCode();
      }
    }
    
    public a rv()
    {
      this.name = "";
      this.ays = null;
      this.ayW = null;
      this.azh = -1;
      return this;
    }
    
    public a u(qo paramqo)
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
        }
        if (this.ays == null) {
          this.ays = new a();
        }
        paramqo.a(this.ays);
      }
    }
    
    public static final class a
      extends qq<a>
    {
      private static volatile a[] ayt;
      public a ayu;
      public int type;
      
      public a()
      {
        rx();
      }
      
      public static a[] rw()
      {
        if (ayt == null) {}
        synchronized (qu.azg)
        {
          if (ayt == null) {
            ayt = new a[0];
          }
          return ayt;
        }
      }
      
      public void a(qp paramqp)
        throws IOException
      {
        paramqp.t(1, this.type);
        if (this.ayu != null) {
          paramqp.a(2, this.ayu);
        }
        super.a(paramqp);
      }
      
      protected int c()
      {
        int i = super.c() + qp.v(1, this.type);
        if (this.ayu != null) {
          i += qp.c(2, this.ayu);
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
            i = this.type;
            j = locala.type;
            bool2 = false;
          } while (i != j);
          if (this.ayu != null) {
            break;
          }
          locala1 = locala.ayu;
          bool2 = false;
        } while (locala1 != null);
        while (this.ayu.equals(locala.ayu))
        {
          a locala1;
          return a(locala);
        }
        return false;
      }
      
      public int hashCode()
      {
        int i = 31 * (527 + this.type);
        if (this.ayu == null) {}
        for (int j = 0;; j = this.ayu.hashCode()) {
          return 31 * (j + i) + rQ();
        }
      }
      
      public a rx()
      {
        this.type = 1;
        this.ayu = null;
        this.ayW = null;
        this.azh = -1;
        return this;
      }
      
      public a v(qo paramqo)
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
            this.type = j;
            break;
          }
          if (this.ayu == null) {
            this.ayu = new a();
          }
          paramqo.a(this.ayu);
        }
      }
      
      public static final class a
        extends qq<a>
      {
        public int ayA;
        public int ayB;
        public boolean ayC;
        public qm.a[] ayD;
        public qm.a.a[] ayE;
        public String[] ayF;
        public long[] ayG;
        public float[] ayH;
        public long ayI;
        public byte[] ayv;
        public String ayw;
        public double ayx;
        public float ayy;
        public long ayz;
        
        public a()
        {
          ry();
        }
        
        public void a(qp paramqp)
          throws IOException
        {
          if (!Arrays.equals(this.ayv, qz.azq)) {
            paramqp.a(1, this.ayv);
          }
          if (!this.ayw.equals("")) {
            paramqp.b(2, this.ayw);
          }
          if (Double.doubleToLongBits(this.ayx) != Double.doubleToLongBits(0.0D)) {
            paramqp.a(3, this.ayx);
          }
          if (Float.floatToIntBits(this.ayy) != Float.floatToIntBits(0.0F)) {
            paramqp.b(4, this.ayy);
          }
          if (this.ayz != 0L) {
            paramqp.b(5, this.ayz);
          }
          if (this.ayA != 0) {
            paramqp.t(6, this.ayA);
          }
          if (this.ayB != 0) {
            paramqp.u(7, this.ayB);
          }
          if (this.ayC) {
            paramqp.b(8, this.ayC);
          }
          if ((this.ayD != null) && (this.ayD.length > 0)) {
            for (int i1 = 0; i1 < this.ayD.length; i1++)
            {
              qm.a locala1 = this.ayD[i1];
              if (locala1 != null) {
                paramqp.a(9, locala1);
              }
            }
          }
          if ((this.ayE != null) && (this.ayE.length > 0)) {
            for (int n = 0; n < this.ayE.length; n++)
            {
              qm.a.a locala = this.ayE[n];
              if (locala != null) {
                paramqp.a(10, locala);
              }
            }
          }
          if ((this.ayF != null) && (this.ayF.length > 0)) {
            for (int m = 0; m < this.ayF.length; m++)
            {
              String str = this.ayF[m];
              if (str != null) {
                paramqp.b(11, str);
              }
            }
          }
          if ((this.ayG != null) && (this.ayG.length > 0)) {
            for (int k = 0; k < this.ayG.length; k++) {
              paramqp.b(12, this.ayG[k]);
            }
          }
          if (this.ayI != 0L) {
            paramqp.b(13, this.ayI);
          }
          if (this.ayH != null)
          {
            int i = this.ayH.length;
            int j = 0;
            if (i > 0) {
              while (j < this.ayH.length)
              {
                paramqp.b(14, this.ayH[j]);
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
          if (!Arrays.equals(this.ayv, qz.azq)) {
            j += qp.b(1, this.ayv);
          }
          if (!this.ayw.equals("")) {
            j += qp.j(2, this.ayw);
          }
          if (Double.doubleToLongBits(this.ayx) != Double.doubleToLongBits(0.0D)) {
            j += qp.b(3, this.ayx);
          }
          if (Float.floatToIntBits(this.ayy) != Float.floatToIntBits(0.0F)) {
            j += qp.c(4, this.ayy);
          }
          if (this.ayz != 0L) {
            j += qp.d(5, this.ayz);
          }
          if (this.ayA != 0) {
            j += qp.v(6, this.ayA);
          }
          if (this.ayB != 0) {
            j += qp.w(7, this.ayB);
          }
          if (this.ayC) {
            j += qp.c(8, this.ayC);
          }
          if ((this.ayD != null) && (this.ayD.length > 0))
          {
            int i4 = j;
            for (int i5 = 0; i5 < this.ayD.length; i5++)
            {
              qm.a locala1 = this.ayD[i5];
              if (locala1 != null) {
                i4 += qp.c(9, locala1);
              }
            }
            j = i4;
          }
          if ((this.ayE != null) && (this.ayE.length > 0))
          {
            int i2 = j;
            for (int i3 = 0; i3 < this.ayE.length; i3++)
            {
              qm.a.a locala = this.ayE[i3];
              if (locala != null) {
                i2 += qp.c(10, locala);
              }
            }
            j = i2;
          }
          if ((this.ayF != null) && (this.ayF.length > 0))
          {
            int m = 0;
            int n = 0;
            int i1 = 0;
            while (m < this.ayF.length)
            {
              String str = this.ayF[m];
              if (str != null)
              {
                i1++;
                n += qp.dk(str);
              }
              m++;
            }
            j = j + n + i1 * 1;
          }
          if ((this.ayG != null) && (this.ayG.length > 0))
          {
            int k = 0;
            while (i < this.ayG.length)
            {
              k += qp.D(this.ayG[i]);
              i++;
            }
            j = j + k + 1 * this.ayG.length;
          }
          if (this.ayI != 0L) {
            j += qp.d(13, this.ayI);
          }
          if ((this.ayH != null) && (this.ayH.length > 0)) {
            j = j + 4 * this.ayH.length + 1 * this.ayH.length;
          }
          return j;
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
              bool3 = Arrays.equals(this.ayv, locala.ayv);
              bool2 = false;
            } while (!bool3);
            if (this.ayw != null) {
              break;
            }
            str = locala.ayw;
            bool2 = false;
          } while (str != null);
          while (this.ayw.equals(locala.ayw))
          {
            String str;
            boolean bool4 = Double.doubleToLongBits(this.ayx) < Double.doubleToLongBits(locala.ayx);
            bool2 = false;
            if (bool4) {
              break;
            }
            int i = Float.floatToIntBits(this.ayy);
            int j = Float.floatToIntBits(locala.ayy);
            bool2 = false;
            if (i != j) {
              break;
            }
            boolean bool5 = this.ayz < locala.ayz;
            bool2 = false;
            if (bool5) {
              break;
            }
            int k = this.ayA;
            int m = locala.ayA;
            bool2 = false;
            if (k != m) {
              break;
            }
            int n = this.ayB;
            int i1 = locala.ayB;
            bool2 = false;
            if (n != i1) {
              break;
            }
            boolean bool6 = this.ayC;
            boolean bool7 = locala.ayC;
            bool2 = false;
            if (bool6 != bool7) {
              break;
            }
            boolean bool8 = qu.equals(this.ayD, locala.ayD);
            bool2 = false;
            if (!bool8) {
              break;
            }
            boolean bool9 = qu.equals(this.ayE, locala.ayE);
            bool2 = false;
            if (!bool9) {
              break;
            }
            boolean bool10 = qu.equals(this.ayF, locala.ayF);
            bool2 = false;
            if (!bool10) {
              break;
            }
            boolean bool11 = qu.equals(this.ayG, locala.ayG);
            bool2 = false;
            if (!bool11) {
              break;
            }
            boolean bool12 = qu.equals(this.ayH, locala.ayH);
            bool2 = false;
            if (!bool12) {
              break;
            }
            boolean bool13 = this.ayI < locala.ayI;
            bool2 = false;
            if (bool13) {
              break;
            }
            return a(locala);
          }
          return false;
        }
        
        public int hashCode()
        {
          int i = 31 * (527 + Arrays.hashCode(this.ayv));
          int j;
          int m;
          if (this.ayw == null)
          {
            j = 0;
            int k = j + i;
            long l = Double.doubleToLongBits(this.ayx);
            m = 31 * (31 * (31 * (31 * (31 * (k * 31 + (int)(l ^ l >>> 32)) + Float.floatToIntBits(this.ayy)) + (int)(this.ayz ^ this.ayz >>> 32)) + this.ayA) + this.ayB);
            if (!this.ayC) {
              break label209;
            }
          }
          label209:
          for (int n = 1231;; n = 1237)
          {
            return 31 * (31 * (31 * (31 * (31 * (31 * (31 * (n + m) + qu.hashCode(this.ayD)) + qu.hashCode(this.ayE)) + qu.hashCode(this.ayF)) + qu.hashCode(this.ayG)) + qu.hashCode(this.ayH)) + (int)(this.ayI ^ this.ayI >>> 32)) + rQ();
            j = this.ayw.hashCode();
            break;
          }
        }
        
        public a ry()
        {
          this.ayv = qz.azq;
          this.ayw = "";
          this.ayx = 0.0D;
          this.ayy = 0.0F;
          this.ayz = 0L;
          this.ayA = 0;
          this.ayB = 0;
          this.ayC = false;
          this.ayD = qm.a.ru();
          this.ayE = qm.a.a.rw();
          this.ayF = qz.azo;
          this.ayG = qz.azk;
          this.ayH = qz.azl;
          this.ayI = 0L;
          this.ayW = null;
          this.azh = -1;
          return this;
        }
        
        public a w(qo paramqo)
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
              this.ayv = paramqo.readBytes();
              break;
            case 18: 
              this.ayw = paramqo.readString();
              break;
            case 25: 
              this.ayx = paramqo.readDouble();
              break;
            case 37: 
              this.ayy = paramqo.readFloat();
              break;
            case 40: 
              this.ayz = paramqo.rB();
              break;
            case 48: 
              this.ayA = paramqo.rC();
              break;
            case 56: 
              this.ayB = paramqo.rE();
              break;
            case 64: 
              this.ayC = paramqo.rD();
              break;
            case 74: 
              int i13 = qz.b(paramqo, 74);
              if (this.ayD == null) {}
              qm.a[] arrayOfa1;
              for (int i14 = 0;; i14 = this.ayD.length)
              {
                arrayOfa1 = new qm.a[i13 + i14];
                if (i14 != 0) {
                  System.arraycopy(this.ayD, 0, arrayOfa1, 0, i14);
                }
                while (i14 < -1 + arrayOfa1.length)
                {
                  arrayOfa1[i14] = new qm.a();
                  paramqo.a(arrayOfa1[i14]);
                  paramqo.rz();
                  i14++;
                }
              }
              arrayOfa1[i14] = new qm.a();
              paramqo.a(arrayOfa1[i14]);
              this.ayD = arrayOfa1;
              break;
            case 82: 
              int i11 = qz.b(paramqo, 82);
              if (this.ayE == null) {}
              qm.a.a[] arrayOfa;
              for (int i12 = 0;; i12 = this.ayE.length)
              {
                arrayOfa = new qm.a.a[i11 + i12];
                if (i12 != 0) {
                  System.arraycopy(this.ayE, 0, arrayOfa, 0, i12);
                }
                while (i12 < -1 + arrayOfa.length)
                {
                  arrayOfa[i12] = new qm.a.a();
                  paramqo.a(arrayOfa[i12]);
                  paramqo.rz();
                  i12++;
                }
              }
              arrayOfa[i12] = new qm.a.a();
              paramqo.a(arrayOfa[i12]);
              this.ayE = arrayOfa;
              break;
            case 90: 
              int i9 = qz.b(paramqo, 90);
              if (this.ayF == null) {}
              String[] arrayOfString;
              for (int i10 = 0;; i10 = this.ayF.length)
              {
                arrayOfString = new String[i9 + i10];
                if (i10 != 0) {
                  System.arraycopy(this.ayF, 0, arrayOfString, 0, i10);
                }
                while (i10 < -1 + arrayOfString.length)
                {
                  arrayOfString[i10] = paramqo.readString();
                  paramqo.rz();
                  i10++;
                }
              }
              arrayOfString[i10] = paramqo.readString();
              this.ayF = arrayOfString;
              break;
            case 96: 
              int i7 = qz.b(paramqo, 96);
              if (this.ayG == null) {}
              long[] arrayOfLong2;
              for (int i8 = 0;; i8 = this.ayG.length)
              {
                arrayOfLong2 = new long[i7 + i8];
                if (i8 != 0) {
                  System.arraycopy(this.ayG, 0, arrayOfLong2, 0, i8);
                }
                while (i8 < -1 + arrayOfLong2.length)
                {
                  arrayOfLong2[i8] = paramqo.rB();
                  paramqo.rz();
                  i8++;
                }
              }
              arrayOfLong2[i8] = paramqo.rB();
              this.ayG = arrayOfLong2;
              break;
            case 98: 
              int i3 = paramqo.gS(paramqo.rG());
              int i4 = paramqo.getPosition();
              for (int i5 = 0; paramqo.rL() > 0; i5++) {
                paramqo.rB();
              }
              paramqo.gU(i4);
              if (this.ayG == null) {}
              long[] arrayOfLong1;
              for (int i6 = 0;; i6 = this.ayG.length)
              {
                arrayOfLong1 = new long[i5 + i6];
                if (i6 != 0) {
                  System.arraycopy(this.ayG, 0, arrayOfLong1, 0, i6);
                }
                while (i6 < arrayOfLong1.length)
                {
                  arrayOfLong1[i6] = paramqo.rB();
                  i6++;
                }
              }
              this.ayG = arrayOfLong1;
              paramqo.gT(i3);
              break;
            case 104: 
              this.ayI = paramqo.rB();
              break;
            case 117: 
              int i1 = qz.b(paramqo, 117);
              if (this.ayH == null) {}
              float[] arrayOfFloat2;
              for (int i2 = 0;; i2 = this.ayH.length)
              {
                arrayOfFloat2 = new float[i1 + i2];
                if (i2 != 0) {
                  System.arraycopy(this.ayH, 0, arrayOfFloat2, 0, i2);
                }
                while (i2 < -1 + arrayOfFloat2.length)
                {
                  arrayOfFloat2[i2] = paramqo.readFloat();
                  paramqo.rz();
                  i2++;
                }
              }
              arrayOfFloat2[i2] = paramqo.readFloat();
              this.ayH = arrayOfFloat2;
              break;
            }
            int j = paramqo.rG();
            int k = paramqo.gS(j);
            int m = j / 4;
            if (this.ayH == null) {}
            float[] arrayOfFloat1;
            for (int n = 0;; n = this.ayH.length)
            {
              arrayOfFloat1 = new float[m + n];
              if (n != 0) {
                System.arraycopy(this.ayH, 0, arrayOfFloat1, 0, n);
              }
              while (n < arrayOfFloat1.length)
              {
                arrayOfFloat1[n] = paramqo.readFloat();
                n++;
              }
            }
            this.ayH = arrayOfFloat1;
            paramqo.gT(k);
          }
        }
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.qm
 * JD-Core Version:    0.7.0.1
 */