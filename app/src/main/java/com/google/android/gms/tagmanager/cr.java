package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import com.google.android.gms.internal.c.b;
import com.google.android.gms.internal.c.e;
import com.google.android.gms.internal.c.f;
import com.google.android.gms.internal.c.g;
import com.google.android.gms.internal.c.h;
import com.google.android.gms.internal.d.a;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class cr
{
  private static d.a a(int paramInt, c.f paramf, d.a[] paramArrayOfa, Set<Integer> paramSet)
    throws cr.g
  {
    int i = 0;
    if (paramSet.contains(Integer.valueOf(paramInt))) {
      cN("Value cycle detected.  Current value reference: " + paramInt + "." + "  Previous value references: " + paramSet + ".");
    }
    d.a locala1 = (d.a)a(paramf.fG, paramInt, "values");
    if (paramArrayOfa[paramInt] != null) {
      return paramArrayOfa[paramInt];
    }
    paramSet.add(Integer.valueOf(paramInt));
    int j = locala1.type;
    d.a locala2 = null;
    switch (j)
    {
    }
    for (;;)
    {
      if (locala2 == null) {
        cN("Invalid value: " + locala1);
      }
      paramArrayOfa[paramInt] = locala2;
      paramSet.remove(Integer.valueOf(paramInt));
      return locala2;
      c.h localh3 = h(locala1);
      locala2 = g(locala1);
      locala2.gw = new d.a[localh3.gh.length];
      int[] arrayOfInt4 = localh3.gh;
      int i11 = arrayOfInt4.length;
      int i14;
      for (int i12 = 0; i < i11; i12 = i14)
      {
        int i13 = arrayOfInt4[i];
        d.a[] arrayOfa4 = locala2.gw;
        i14 = i12 + 1;
        arrayOfa4[i12] = a(i13, paramf, paramArrayOfa, paramSet);
        i++;
      }
      locala2 = g(locala1);
      c.h localh2 = h(locala1);
      if (localh2.gi.length != localh2.gj.length) {
        cN("Uneven map keys (" + localh2.gi.length + ") and map values (" + localh2.gj.length + ")");
      }
      locala2.gx = new d.a[localh2.gi.length];
      locala2.gy = new d.a[localh2.gi.length];
      int[] arrayOfInt2 = localh2.gi;
      int i2 = arrayOfInt2.length;
      int i3 = 0;
      int i10;
      for (int i4 = 0; i3 < i2; i4 = i10)
      {
        int i9 = arrayOfInt2[i3];
        d.a[] arrayOfa3 = locala2.gx;
        i10 = i4 + 1;
        arrayOfa3[i4] = a(i9, paramf, paramArrayOfa, paramSet);
        i3++;
      }
      int[] arrayOfInt3 = localh2.gj;
      int i5 = arrayOfInt3.length;
      int i8;
      for (int i6 = 0; i < i5; i6 = i8)
      {
        int i7 = arrayOfInt3[i];
        d.a[] arrayOfa2 = locala2.gy;
        i8 = i6 + 1;
        arrayOfa2[i6] = a(i7, paramf, paramArrayOfa, paramSet);
        i++;
      }
      locala2 = g(locala1);
      locala2.gz = di.j(a(h(locala1).gm, paramf, paramArrayOfa, paramSet));
      continue;
      locala2 = g(locala1);
      c.h localh1 = h(locala1);
      locala2.gD = new d.a[localh1.gl.length];
      int[] arrayOfInt1 = localh1.gl;
      int k = arrayOfInt1.length;
      int i1;
      for (int m = 0; i < k; m = i1)
      {
        int n = arrayOfInt1[i];
        d.a[] arrayOfa1 = locala2.gD;
        i1 = m + 1;
        arrayOfa1[m] = a(n, paramf, paramArrayOfa, paramSet);
        i++;
      }
      locala2 = locala1;
    }
  }
  
  private static a a(c.b paramb, c.f paramf, d.a[] paramArrayOfa, int paramInt)
    throws cr.g
  {
    b localb = a.qk();
    int[] arrayOfInt = paramb.fq;
    int i = arrayOfInt.length;
    int j = 0;
    if (j < i)
    {
      Integer localInteger = Integer.valueOf(arrayOfInt[j]);
      c.e locale = (c.e)a(paramf.fH, localInteger.intValue(), "properties");
      String str = (String)a(paramf.fF, locale.key, "keys");
      d.a locala = (d.a)a(paramArrayOfa, locale.value, "values");
      if (b.ec.toString().equals(str)) {
        localb.i(locala);
      }
      for (;;)
      {
        j++;
        break;
        localb.b(str, locala);
      }
    }
    return localb.qn();
  }
  
  private static e a(c.g paramg, List<a> paramList1, List<a> paramList2, List<a> paramList3, c.f paramf)
  {
    f localf = e.qs();
    int[] arrayOfInt1 = paramg.fV;
    int i = arrayOfInt1.length;
    for (int j = 0; j < i; j++) {
      localf.b((a)paramList3.get(Integer.valueOf(arrayOfInt1[j]).intValue()));
    }
    int[] arrayOfInt2 = paramg.fW;
    int k = arrayOfInt2.length;
    for (int m = 0; m < k; m++) {
      localf.c((a)paramList3.get(Integer.valueOf(arrayOfInt2[m]).intValue()));
    }
    int[] arrayOfInt3 = paramg.fX;
    int n = arrayOfInt3.length;
    for (int i1 = 0; i1 < n; i1++) {
      localf.d((a)paramList1.get(Integer.valueOf(arrayOfInt3[i1]).intValue()));
    }
    int[] arrayOfInt4 = paramg.fZ;
    int i2 = arrayOfInt4.length;
    for (int i3 = 0; i3 < i2; i3++)
    {
      Integer localInteger4 = Integer.valueOf(arrayOfInt4[i3]);
      localf.cP(paramf.fG[localInteger4.intValue()].gv);
    }
    int[] arrayOfInt5 = paramg.fY;
    int i4 = arrayOfInt5.length;
    for (int i5 = 0; i5 < i4; i5++) {
      localf.e((a)paramList1.get(Integer.valueOf(arrayOfInt5[i5]).intValue()));
    }
    int[] arrayOfInt6 = paramg.ga;
    int i6 = arrayOfInt6.length;
    for (int i7 = 0; i7 < i6; i7++)
    {
      Integer localInteger3 = Integer.valueOf(arrayOfInt6[i7]);
      localf.cQ(paramf.fG[localInteger3.intValue()].gv);
    }
    int[] arrayOfInt7 = paramg.gb;
    int i8 = arrayOfInt7.length;
    for (int i9 = 0; i9 < i8; i9++) {
      localf.f((a)paramList2.get(Integer.valueOf(arrayOfInt7[i9]).intValue()));
    }
    int[] arrayOfInt8 = paramg.gd;
    int i10 = arrayOfInt8.length;
    for (int i11 = 0; i11 < i10; i11++)
    {
      Integer localInteger2 = Integer.valueOf(arrayOfInt8[i11]);
      localf.cR(paramf.fG[localInteger2.intValue()].gv);
    }
    int[] arrayOfInt9 = paramg.gc;
    int i12 = arrayOfInt9.length;
    for (int i13 = 0; i13 < i12; i13++) {
      localf.g((a)paramList2.get(Integer.valueOf(arrayOfInt9[i13]).intValue()));
    }
    int[] arrayOfInt10 = paramg.ge;
    int i14 = arrayOfInt10.length;
    for (int i15 = 0; i15 < i14; i15++)
    {
      Integer localInteger1 = Integer.valueOf(arrayOfInt10[i15]);
      localf.cS(paramf.fG[localInteger1.intValue()].gv);
    }
    return localf.qD();
  }
  
  private static <T> T a(T[] paramArrayOfT, int paramInt, String paramString)
    throws cr.g
  {
    if ((paramInt < 0) || (paramInt >= paramArrayOfT.length)) {
      cN("Index out of bounds detected: " + paramInt + " in " + paramString);
    }
    return paramArrayOfT[paramInt];
  }
  
  public static c b(c.f paramf)
    throws cr.g
  {
    int i = 0;
    d.a[] arrayOfa = new d.a[paramf.fG.length];
    for (int j = 0; j < paramf.fG.length; j++) {
      a(j, paramf, arrayOfa, new HashSet(0));
    }
    d locald = c.qo();
    ArrayList localArrayList1 = new ArrayList();
    for (int k = 0; k < paramf.fJ.length; k++) {
      localArrayList1.add(a(paramf.fJ[k], paramf, arrayOfa, k));
    }
    ArrayList localArrayList2 = new ArrayList();
    for (int m = 0; m < paramf.fK.length; m++) {
      localArrayList2.add(a(paramf.fK[m], paramf, arrayOfa, m));
    }
    ArrayList localArrayList3 = new ArrayList();
    for (int n = 0; n < paramf.fI.length; n++)
    {
      a locala = a(paramf.fI[n], paramf, arrayOfa, n);
      locald.a(locala);
      localArrayList3.add(locala);
    }
    c.g[] arrayOfg = paramf.fL;
    int i1 = arrayOfg.length;
    while (i < i1)
    {
      locald.a(a(arrayOfg[i], localArrayList1, localArrayList3, localArrayList2, paramf));
      i++;
    }
    locald.cO(paramf.version);
    locald.fO(paramf.fT);
    return locald.qr();
  }
  
  public static void b(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte[1024];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        return;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  private static void cN(String paramString)
    throws cr.g
  {
    bh.T(paramString);
    throw new g(paramString);
  }
  
  public static d.a g(d.a parama)
  {
    d.a locala = new d.a();
    locala.type = parama.type;
    locala.gE = ((int[])parama.gE.clone());
    if (parama.gF) {
      locala.gF = parama.gF;
    }
    return locala;
  }
  
  private static c.h h(d.a parama)
    throws cr.g
  {
    if ((c.h)parama.a(c.h.gf) == null) {
      cN("Expected a ServingValue and didn't get one. Value is: " + parama);
    }
    return (c.h)parama.a(c.h.gf);
  }
  
  public static class a
  {
    private final Map<String, d.a> asM;
    private final d.a asN;
    
    private a(Map<String, d.a> paramMap, d.a parama)
    {
      this.asM = paramMap;
      this.asN = parama;
    }
    
    public static cr.b qk()
    {
      return new cr.b(null);
    }
    
    public void a(String paramString, d.a parama)
    {
      this.asM.put(paramString, parama);
    }
    
    public Map<String, d.a> ql()
    {
      return Collections.unmodifiableMap(this.asM);
    }
    
    public d.a qm()
    {
      return this.asN;
    }
    
    public String toString()
    {
      return "Properties: " + ql() + " pushAfterEvaluate: " + this.asN;
    }
  }
  
  public static class b
  {
    private final Map<String, d.a> asM = new HashMap();
    private d.a asN;
    
    public b b(String paramString, d.a parama)
    {
      this.asM.put(paramString, parama);
      return this;
    }
    
    public b i(d.a parama)
    {
      this.asN = parama;
      return this;
    }
    
    public cr.a qn()
    {
      return new cr.a(this.asM, this.asN, null);
    }
  }
  
  public static class c
  {
    private final String TU;
    private final List<cr.e> asO;
    private final Map<String, List<cr.a>> asP;
    private final int asQ;
    
    private c(List<cr.e> paramList, Map<String, List<cr.a>> paramMap, String paramString, int paramInt)
    {
      this.asO = Collections.unmodifiableList(paramList);
      this.asP = Collections.unmodifiableMap(paramMap);
      this.TU = paramString;
      this.asQ = paramInt;
    }
    
    public static cr.d qo()
    {
      return new cr.d(null);
    }
    
    public String getVersion()
    {
      return this.TU;
    }
    
    public List<cr.e> qp()
    {
      return this.asO;
    }
    
    public Map<String, List<cr.a>> qq()
    {
      return this.asP;
    }
    
    public String toString()
    {
      return "Rules: " + qp() + "  Macros: " + this.asP;
    }
  }
  
  public static class d
  {
    private String TU = "";
    private final List<cr.e> asO = new ArrayList();
    private final Map<String, List<cr.a>> asP = new HashMap();
    private int asQ = 0;
    
    public d a(cr.a parama)
    {
      String str = di.j((d.a)parama.ql().get(b.df.toString()));
      Object localObject = (List)this.asP.get(str);
      if (localObject == null)
      {
        localObject = new ArrayList();
        this.asP.put(str, localObject);
      }
      ((List)localObject).add(parama);
      return this;
    }
    
    public d a(cr.e parame)
    {
      this.asO.add(parame);
      return this;
    }
    
    public d cO(String paramString)
    {
      this.TU = paramString;
      return this;
    }
    
    public d fO(int paramInt)
    {
      this.asQ = paramInt;
      return this;
    }
    
    public cr.c qr()
    {
      return new cr.c(this.asO, this.asP, this.TU, this.asQ, null);
    }
  }
  
  public static class e
  {
    private final List<cr.a> asR;
    private final List<cr.a> asS;
    private final List<cr.a> asT;
    private final List<cr.a> asU;
    private final List<cr.a> asV;
    private final List<cr.a> asW;
    private final List<String> asX;
    private final List<String> asY;
    private final List<String> asZ;
    private final List<String> ata;
    
    private e(List<cr.a> paramList1, List<cr.a> paramList2, List<cr.a> paramList3, List<cr.a> paramList4, List<cr.a> paramList5, List<cr.a> paramList6, List<String> paramList7, List<String> paramList8, List<String> paramList9, List<String> paramList10)
    {
      this.asR = Collections.unmodifiableList(paramList1);
      this.asS = Collections.unmodifiableList(paramList2);
      this.asT = Collections.unmodifiableList(paramList3);
      this.asU = Collections.unmodifiableList(paramList4);
      this.asV = Collections.unmodifiableList(paramList5);
      this.asW = Collections.unmodifiableList(paramList6);
      this.asX = Collections.unmodifiableList(paramList7);
      this.asY = Collections.unmodifiableList(paramList8);
      this.asZ = Collections.unmodifiableList(paramList9);
      this.ata = Collections.unmodifiableList(paramList10);
    }
    
    public static cr.f qs()
    {
      return new cr.f(null);
    }
    
    public List<String> qA()
    {
      return this.asZ;
    }
    
    public List<String> qB()
    {
      return this.ata;
    }
    
    public List<cr.a> qC()
    {
      return this.asW;
    }
    
    public List<cr.a> qt()
    {
      return this.asR;
    }
    
    public List<cr.a> qu()
    {
      return this.asS;
    }
    
    public List<cr.a> qv()
    {
      return this.asT;
    }
    
    public List<cr.a> qw()
    {
      return this.asU;
    }
    
    public List<cr.a> qx()
    {
      return this.asV;
    }
    
    public List<String> qy()
    {
      return this.asX;
    }
    
    public List<String> qz()
    {
      return this.asY;
    }
    
    public String toString()
    {
      return "Positive predicates: " + qt() + "  Negative predicates: " + qu() + "  Add tags: " + qv() + "  Remove tags: " + qw() + "  Add macros: " + qx() + "  Remove macros: " + qC();
    }
  }
  
  public static class f
  {
    private final List<cr.a> asR = new ArrayList();
    private final List<cr.a> asS = new ArrayList();
    private final List<cr.a> asT = new ArrayList();
    private final List<cr.a> asU = new ArrayList();
    private final List<cr.a> asV = new ArrayList();
    private final List<cr.a> asW = new ArrayList();
    private final List<String> asX = new ArrayList();
    private final List<String> asY = new ArrayList();
    private final List<String> asZ = new ArrayList();
    private final List<String> ata = new ArrayList();
    
    public f b(cr.a parama)
    {
      this.asR.add(parama);
      return this;
    }
    
    public f c(cr.a parama)
    {
      this.asS.add(parama);
      return this;
    }
    
    public f cP(String paramString)
    {
      this.asZ.add(paramString);
      return this;
    }
    
    public f cQ(String paramString)
    {
      this.ata.add(paramString);
      return this;
    }
    
    public f cR(String paramString)
    {
      this.asX.add(paramString);
      return this;
    }
    
    public f cS(String paramString)
    {
      this.asY.add(paramString);
      return this;
    }
    
    public f d(cr.a parama)
    {
      this.asT.add(parama);
      return this;
    }
    
    public f e(cr.a parama)
    {
      this.asU.add(parama);
      return this;
    }
    
    public f f(cr.a parama)
    {
      this.asV.add(parama);
      return this;
    }
    
    public f g(cr.a parama)
    {
      this.asW.add(parama);
      return this;
    }
    
    public cr.e qD()
    {
      return new cr.e(this.asR, this.asS, this.asT, this.asU, this.asV, this.asW, this.asX, this.asY, this.asZ, this.ata, null);
    }
  }
  
  public static class g
    extends Exception
  {
    public g(String paramString)
    {
      super();
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.cr
 * JD-Core Version:    0.7.0.1
 */