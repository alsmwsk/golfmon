package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.c.i;
import com.google.android.gms.internal.d.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ct
{
  private static final bz<d.a> atb = new bz(di.rb(), true);
  private final DataLayer aqn;
  private final cr.c atc;
  private final ag atd;
  private final Map<String, aj> ate;
  private final Map<String, aj> atf;
  private final Map<String, aj> atg;
  private final k<cr.a, bz<d.a>> ath;
  private final k<String, b> ati;
  private final Set<cr.e> atj;
  private final Map<String, c> atk;
  private volatile String atl;
  private int atm;
  
  public ct(Context paramContext, cr.c paramc, DataLayer paramDataLayer, s.a parama1, s.a parama2, ag paramag)
  {
    if (paramc == null) {
      throw new NullPointerException("resource cannot be null");
    }
    this.atc = paramc;
    this.atj = new HashSet(paramc.qp());
    this.aqn = paramDataLayer;
    this.atd = paramag;
    l.a local1 = new l.a()
    {
      public int a(cr.a paramAnonymousa, bz<d.a> paramAnonymousbz)
      {
        return ((d.a)paramAnonymousbz.getObject()).rY();
      }
    };
    this.ath = new l().a(1048576, local1);
    l.a local2 = new l.a()
    {
      public int a(String paramAnonymousString, ct.b paramAnonymousb)
      {
        return paramAnonymousString.length() + paramAnonymousb.getSize();
      }
    };
    this.ati = new l().a(1048576, local2);
    this.ate = new HashMap();
    b(new i(paramContext));
    b(new s(parama2));
    b(new w(paramDataLayer));
    b(new dj(paramContext, paramDataLayer));
    this.atf = new HashMap();
    c(new q());
    c(new ad());
    c(new ae());
    c(new al());
    c(new am());
    c(new bd());
    c(new be());
    c(new ci());
    c(new dc());
    this.atg = new HashMap();
    a(new b(paramContext));
    a(new c(paramContext));
    a(new e(paramContext));
    a(new f(paramContext));
    a(new g(paramContext));
    a(new h(paramContext));
    a(new m());
    a(new p(this.atc.getVersion()));
    a(new s(parama1));
    a(new u(paramDataLayer));
    a(new z(paramContext));
    a(new aa());
    a(new ac());
    a(new ah(this));
    a(new an());
    a(new ao());
    a(new ax(paramContext));
    a(new az());
    a(new bc());
    a(new bj());
    a(new bl(paramContext));
    a(new ca());
    a(new cc());
    a(new cf());
    a(new ch());
    a(new cj(paramContext));
    a(new cu());
    a(new cv());
    a(new de());
    a(new dk());
    this.atk = new HashMap();
    Iterator localIterator1 = this.atj.iterator();
    while (localIterator1.hasNext())
    {
      cr.e locale = (cr.e)localIterator1.next();
      if (paramag.pH())
      {
        a(locale.qx(), locale.qy(), "add macro");
        a(locale.qC(), locale.qz(), "remove macro");
        a(locale.qv(), locale.qA(), "add tag");
        a(locale.qw(), locale.qB(), "remove tag");
      }
      for (int i = 0; i < locale.qx().size(); i++)
      {
        cr.a locala3 = (cr.a)locale.qx().get(i);
        String str2 = "Unknown";
        if ((paramag.pH()) && (i < locale.qy().size())) {
          str2 = (String)locale.qy().get(i);
        }
        c localc2 = e(this.atk, h(locala3));
        localc2.b(locale);
        localc2.a(locale, locala3);
        localc2.a(locale, str2);
      }
      for (int j = 0; j < locale.qC().size(); j++)
      {
        cr.a locala2 = (cr.a)locale.qC().get(j);
        String str1 = "Unknown";
        if ((paramag.pH()) && (j < locale.qz().size())) {
          str1 = (String)locale.qz().get(j);
        }
        c localc1 = e(this.atk, h(locala2));
        localc1.b(locale);
        localc1.b(locale, locala2);
        localc1.b(locale, str1);
      }
    }
    Iterator localIterator2 = this.atc.qq().entrySet().iterator();
    while (localIterator2.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator2.next();
      Iterator localIterator3 = ((List)localEntry.getValue()).iterator();
      while (localIterator3.hasNext())
      {
        cr.a locala1 = (cr.a)localIterator3.next();
        if (!di.n((d.a)locala1.ql().get(com.google.android.gms.internal.b.dG.toString())).booleanValue()) {
          e(this.atk, (String)localEntry.getKey()).i(locala1);
        }
      }
    }
  }
  
  private bz<d.a> a(d.a parama, Set<String> paramSet, dl paramdl)
  {
    if (!parama.gF) {
      return new bz(parama, true);
    }
    switch (parama.type)
    {
    case 5: 
    case 6: 
    default: 
      bh.T("Unknown type: " + parama.type);
      return atb;
    case 2: 
      d.a locala3 = cr.g(parama);
      locala3.gw = new d.a[parama.gw.length];
      for (int k = 0; k < parama.gw.length; k++)
      {
        bz localbz5 = a(parama.gw[k], paramSet, paramdl.fK(k));
        if (localbz5 == atb) {
          return atb;
        }
        locala3.gw[k] = ((d.a)localbz5.getObject());
      }
      return new bz(locala3, false);
    case 3: 
      d.a locala2 = cr.g(parama);
      if (parama.gx.length != parama.gy.length)
      {
        bh.T("Invalid serving value: " + parama.toString());
        return atb;
      }
      locala2.gx = new d.a[parama.gx.length];
      locala2.gy = new d.a[parama.gx.length];
      for (int j = 0; j < parama.gx.length; j++)
      {
        bz localbz3 = a(parama.gx[j], paramSet, paramdl.fL(j));
        bz localbz4 = a(parama.gy[j], paramSet, paramdl.fM(j));
        if ((localbz3 == atb) || (localbz4 == atb)) {
          return atb;
        }
        locala2.gx[j] = ((d.a)localbz3.getObject());
        locala2.gy[j] = ((d.a)localbz4.getObject());
      }
      return new bz(locala2, false);
    case 4: 
      if (paramSet.contains(parama.gz))
      {
        bh.T("Macro cycle detected.  Current macro reference: " + parama.gz + "." + "  Previous macro references: " + paramSet.toString() + ".");
        return atb;
      }
      paramSet.add(parama.gz);
      bz localbz2 = dm.a(a(parama.gz, paramSet, paramdl.pW()), parama.gE);
      paramSet.remove(parama.gz);
      return localbz2;
    }
    d.a locala1 = cr.g(parama);
    locala1.gD = new d.a[parama.gD.length];
    for (int i = 0; i < parama.gD.length; i++)
    {
      bz localbz1 = a(parama.gD[i], paramSet, paramdl.fN(i));
      if (localbz1 == atb) {
        return atb;
      }
      locala1.gD[i] = ((d.a)localbz1.getObject());
    }
    return new bz(locala1, false);
  }
  
  private bz<d.a> a(String paramString, Set<String> paramSet, bk parambk)
  {
    this.atm = (1 + this.atm);
    b localb = (b)this.ati.get(paramString);
    if ((localb != null) && (!this.atd.pH()))
    {
      a(localb.qm(), paramSet);
      this.atm = (-1 + this.atm);
      return localb.qG();
    }
    c localc = (c)this.atk.get(paramString);
    if (localc == null)
    {
      bh.T(qF() + "Invalid macro: " + paramString);
      this.atm = (-1 + this.atm);
      return atb;
    }
    bz localbz1 = a(paramString, localc.qH(), localc.qI(), localc.qJ(), localc.qL(), localc.qK(), paramSet, parambk.py());
    if (((Set)localbz1.getObject()).isEmpty()) {}
    for (cr.a locala = localc.qM(); locala == null; locala = (cr.a)((Set)localbz1.getObject()).iterator().next())
    {
      this.atm = (-1 + this.atm);
      return atb;
      if (((Set)localbz1.getObject()).size() > 1) {
        bh.W(qF() + "Multiple macros active for macroName " + paramString);
      }
    }
    bz localbz2 = a(this.atg, locala, paramSet, parambk.pN());
    boolean bool;
    if ((localbz1.pX()) && (localbz2.pX()))
    {
      bool = true;
      if (localbz2 != atb) {
        break label399;
      }
    }
    label399:
    for (bz localbz3 = atb;; localbz3 = new bz(localbz2.getObject(), bool))
    {
      d.a locala1 = locala.qm();
      if (localbz3.pX()) {
        this.ati.e(paramString, new b(localbz3, locala1));
      }
      a(locala1, paramSet);
      this.atm = (-1 + this.atm);
      return localbz3;
      bool = false;
      break;
    }
  }
  
  private bz<d.a> a(Map<String, aj> paramMap, cr.a parama, Set<String> paramSet, ck paramck)
  {
    boolean bool1 = true;
    d.a locala = (d.a)parama.ql().get(com.google.android.gms.internal.b.cU.toString());
    bz localbz1;
    if (locala == null)
    {
      bh.T("No function id in properties");
      localbz1 = atb;
    }
    String str;
    aj localaj;
    do
    {
      return localbz1;
      str = locala.gA;
      localaj = (aj)paramMap.get(str);
      if (localaj == null)
      {
        bh.T(str + " has no backing implementation.");
        return atb;
      }
      localbz1 = (bz)this.ath.get(parama);
    } while ((localbz1 != null) && (!this.atd.pH()));
    HashMap localHashMap = new HashMap();
    Iterator localIterator = parama.ql().entrySet().iterator();
    boolean bool2 = bool1;
    if (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      cm localcm = paramck.cJ((String)localEntry.getKey());
      bz localbz3 = a((d.a)localEntry.getValue(), paramSet, localcm.e((d.a)localEntry.getValue()));
      if (localbz3 == atb) {
        return atb;
      }
      if (localbz3.pX()) {
        parama.a((String)localEntry.getKey(), (d.a)localbz3.getObject());
      }
      for (boolean bool3 = bool2;; bool3 = false)
      {
        localHashMap.put(localEntry.getKey(), localbz3.getObject());
        bool2 = bool3;
        break;
      }
    }
    if (!localaj.a(localHashMap.keySet()))
    {
      bh.T("Incorrect keys for function " + str + " required " + localaj.pJ() + " had " + localHashMap.keySet());
      return atb;
    }
    if ((bool2) && (localaj.pe())) {}
    for (;;)
    {
      bz localbz2 = new bz(localaj.B(localHashMap), bool1);
      if (bool1) {
        this.ath.e(parama, localbz2);
      }
      paramck.d((d.a)localbz2.getObject());
      return localbz2;
      bool1 = false;
    }
  }
  
  private bz<Set<cr.a>> a(Set<cr.e> paramSet, Set<String> paramSet1, a parama, cs paramcs)
  {
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    Iterator localIterator = paramSet.iterator();
    boolean bool1 = true;
    if (localIterator.hasNext())
    {
      cr.e locale = (cr.e)localIterator.next();
      cn localcn = paramcs.pV();
      bz localbz = a(locale, paramSet1, localcn);
      if (((Boolean)localbz.getObject()).booleanValue()) {
        parama.a(locale, localHashSet1, localHashSet2, localcn);
      }
      if ((bool1) && (localbz.pX())) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        bool1 = bool2;
        break;
      }
    }
    localHashSet1.removeAll(localHashSet2);
    paramcs.b(localHashSet1);
    return new bz(localHashSet1, bool1);
  }
  
  private void a(d.a parama, Set<String> paramSet)
  {
    if (parama == null) {}
    for (;;)
    {
      return;
      bz localbz = a(parama, paramSet, new bx());
      if (localbz != atb)
      {
        Object localObject1 = di.o((d.a)localbz.getObject());
        if ((localObject1 instanceof Map))
        {
          Map localMap2 = (Map)localObject1;
          this.aqn.push(localMap2);
          return;
        }
        if (!(localObject1 instanceof List)) {
          break;
        }
        Iterator localIterator = ((List)localObject1).iterator();
        while (localIterator.hasNext())
        {
          Object localObject2 = localIterator.next();
          if ((localObject2 instanceof Map))
          {
            Map localMap1 = (Map)localObject2;
            this.aqn.push(localMap1);
          }
          else
          {
            bh.W("pushAfterEvaluate: value not a Map");
          }
        }
      }
    }
    bh.W("pushAfterEvaluate: value not a Map or List");
  }
  
  private static void a(List<cr.a> paramList, List<String> paramList1, String paramString)
  {
    if (paramList.size() != paramList1.size()) {
      bh.U("Invalid resource: imbalance of rule names of functions for " + paramString + " operation. Using default rule name instead");
    }
  }
  
  private static void a(Map<String, aj> paramMap, aj paramaj)
  {
    if (paramMap.containsKey(paramaj.pI())) {
      throw new IllegalArgumentException("Duplicate function type name: " + paramaj.pI());
    }
    paramMap.put(paramaj.pI(), paramaj);
  }
  
  private static c e(Map<String, c> paramMap, String paramString)
  {
    c localc = (c)paramMap.get(paramString);
    if (localc == null)
    {
      localc = new c();
      paramMap.put(paramString, localc);
    }
    return localc;
  }
  
  private static String h(cr.a parama)
  {
    return di.j((d.a)parama.ql().get(com.google.android.gms.internal.b.df.toString()));
  }
  
  private String qF()
  {
    if (this.atm <= 1) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Integer.toString(this.atm));
    for (int i = 2; i < this.atm; i++) {
      localStringBuilder.append(' ');
    }
    localStringBuilder.append(": ");
    return localStringBuilder.toString();
  }
  
  bz<Boolean> a(cr.a parama, Set<String> paramSet, ck paramck)
  {
    bz localbz = a(this.atf, parama, paramSet, paramck);
    Boolean localBoolean = di.n((d.a)localbz.getObject());
    paramck.d(di.u(localBoolean));
    return new bz(localBoolean, localbz.pX());
  }
  
  bz<Boolean> a(cr.e parame, Set<String> paramSet, cn paramcn)
  {
    Iterator localIterator1 = parame.qu().iterator();
    boolean bool1 = true;
    if (localIterator1.hasNext())
    {
      bz localbz2 = a((cr.a)localIterator1.next(), paramSet, paramcn.pP());
      if (((Boolean)localbz2.getObject()).booleanValue())
      {
        paramcn.f(di.u(Boolean.valueOf(false)));
        return new bz(Boolean.valueOf(false), localbz2.pX());
      }
      if ((bool1) && (localbz2.pX())) {}
      for (boolean bool2 = true;; bool2 = false)
      {
        bool1 = bool2;
        break;
      }
    }
    Iterator localIterator2 = parame.qt().iterator();
    while (localIterator2.hasNext())
    {
      bz localbz1 = a((cr.a)localIterator2.next(), paramSet, paramcn.pQ());
      if (!((Boolean)localbz1.getObject()).booleanValue())
      {
        paramcn.f(di.u(Boolean.valueOf(false)));
        return new bz(Boolean.valueOf(false), localbz1.pX());
      }
      if ((bool1) && (localbz1.pX())) {
        bool1 = true;
      } else {
        bool1 = false;
      }
    }
    paramcn.f(di.u(Boolean.valueOf(true)));
    return new bz(Boolean.valueOf(true), bool1);
  }
  
  bz<Set<cr.a>> a(String paramString, Set<cr.e> paramSet, final Map<cr.e, List<cr.a>> paramMap1, final Map<cr.e, List<String>> paramMap2, final Map<cr.e, List<cr.a>> paramMap3, final Map<cr.e, List<String>> paramMap4, Set<String> paramSet1, cs paramcs)
  {
    a(paramSet, paramSet1, new a()
    {
      public void a(cr.e paramAnonymouse, Set<cr.a> paramAnonymousSet1, Set<cr.a> paramAnonymousSet2, cn paramAnonymouscn)
      {
        List localList1 = (List)paramMap1.get(paramAnonymouse);
        List localList2 = (List)paramMap2.get(paramAnonymouse);
        if (localList1 != null)
        {
          paramAnonymousSet1.addAll(localList1);
          paramAnonymouscn.pR().c(localList1, localList2);
        }
        List localList3 = (List)paramMap3.get(paramAnonymouse);
        List localList4 = (List)paramMap4.get(paramAnonymouse);
        if (localList3 != null)
        {
          paramAnonymousSet2.addAll(localList3);
          paramAnonymouscn.pS().c(localList3, localList4);
        }
      }
    }, paramcs);
  }
  
  bz<Set<cr.a>> a(Set<cr.e> paramSet, cs paramcs)
  {
    a(paramSet, new HashSet(), new a()
    {
      public void a(cr.e paramAnonymouse, Set<cr.a> paramAnonymousSet1, Set<cr.a> paramAnonymousSet2, cn paramAnonymouscn)
      {
        paramAnonymousSet1.addAll(paramAnonymouse.qv());
        paramAnonymousSet2.addAll(paramAnonymouse.qw());
        paramAnonymouscn.pT().c(paramAnonymouse.qv(), paramAnonymouse.qA());
        paramAnonymouscn.pU().c(paramAnonymouse.qw(), paramAnonymouse.qB());
      }
    }, paramcs);
  }
  
  void a(aj paramaj)
  {
    a(this.atg, paramaj);
  }
  
  void b(aj paramaj)
  {
    a(this.ate, paramaj);
  }
  
  void c(aj paramaj)
  {
    a(this.atf, paramaj);
  }
  
  public bz<d.a> cT(String paramString)
  {
    this.atm = 0;
    af localaf = this.atd.cC(paramString);
    bz localbz = a(paramString, new HashSet(), localaf.pE());
    localaf.pG();
    return localbz;
  }
  
  void cU(String paramString)
  {
    try
    {
      this.atl = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void cr(String paramString)
  {
    try
    {
      cU(paramString);
      af localaf = this.atd.cD(paramString);
      t localt = localaf.pF();
      Iterator localIterator = ((Set)a(this.atj, localt.py()).getObject()).iterator();
      while (localIterator.hasNext())
      {
        cr.a locala = (cr.a)localIterator.next();
        a(this.ate, locala, new HashSet(), localt.px());
      }
      localaf.pG();
    }
    finally {}
    cU(null);
  }
  
  public void l(List<c.i> paramList)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = paramList.iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        c.i locali = (c.i)localIterator.next();
        if ((locali.name == null) || (!locali.name.startsWith("gaExperiment:"))) {
          bh.V("Ignored supplemental: " + locali);
        } else {
          ai.a(this.aqn, locali);
        }
      }
      finally {}
    }
  }
  
  String qE()
  {
    try
    {
      String str = this.atl;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  static abstract interface a
  {
    public abstract void a(cr.e parame, Set<cr.a> paramSet1, Set<cr.a> paramSet2, cn paramcn);
  }
  
  private static class b
  {
    private d.a asN;
    private bz<d.a> ats;
    
    public b(bz<d.a> parambz, d.a parama)
    {
      this.ats = parambz;
      this.asN = parama;
    }
    
    public int getSize()
    {
      int i = ((d.a)this.ats.getObject()).rY();
      if (this.asN == null) {}
      for (int j = 0;; j = this.asN.rY()) {
        return j + i;
      }
    }
    
    public bz<d.a> qG()
    {
      return this.ats;
    }
    
    public d.a qm()
    {
      return this.asN;
    }
  }
  
  private static class c
  {
    private final Set<cr.e> atj = new HashSet();
    private final Map<cr.e, List<cr.a>> att = new HashMap();
    private final Map<cr.e, List<cr.a>> atu = new HashMap();
    private final Map<cr.e, List<String>> atv = new HashMap();
    private final Map<cr.e, List<String>> atw = new HashMap();
    private cr.a atx;
    
    public void a(cr.e parame, cr.a parama)
    {
      Object localObject = (List)this.att.get(parame);
      if (localObject == null)
      {
        localObject = new ArrayList();
        this.att.put(parame, localObject);
      }
      ((List)localObject).add(parama);
    }
    
    public void a(cr.e parame, String paramString)
    {
      Object localObject = (List)this.atv.get(parame);
      if (localObject == null)
      {
        localObject = new ArrayList();
        this.atv.put(parame, localObject);
      }
      ((List)localObject).add(paramString);
    }
    
    public void b(cr.e parame)
    {
      this.atj.add(parame);
    }
    
    public void b(cr.e parame, cr.a parama)
    {
      Object localObject = (List)this.atu.get(parame);
      if (localObject == null)
      {
        localObject = new ArrayList();
        this.atu.put(parame, localObject);
      }
      ((List)localObject).add(parama);
    }
    
    public void b(cr.e parame, String paramString)
    {
      Object localObject = (List)this.atw.get(parame);
      if (localObject == null)
      {
        localObject = new ArrayList();
        this.atw.put(parame, localObject);
      }
      ((List)localObject).add(paramString);
    }
    
    public void i(cr.a parama)
    {
      this.atx = parama;
    }
    
    public Set<cr.e> qH()
    {
      return this.atj;
    }
    
    public Map<cr.e, List<cr.a>> qI()
    {
      return this.att;
    }
    
    public Map<cr.e, List<String>> qJ()
    {
      return this.atv;
    }
    
    public Map<cr.e, List<String>> qK()
    {
      return this.atw;
    }
    
    public Map<cr.e, List<cr.a>> qL()
    {
      return this.atu;
    }
    
    public cr.a qM()
    {
      return this.atx;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.ct
 * JD-Core Version:    0.7.0.1
 */