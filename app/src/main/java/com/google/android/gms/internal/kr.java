package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class kr
{
  private void a(StringBuilder paramStringBuilder, a parama, Object paramObject)
  {
    if (parama.hI() == 11)
    {
      paramStringBuilder.append(((kr)parama.hS().cast(paramObject)).toString());
      return;
    }
    if (parama.hI() == 7)
    {
      paramStringBuilder.append("\"");
      paramStringBuilder.append(li.bh((String)paramObject));
      paramStringBuilder.append("\"");
      return;
    }
    paramStringBuilder.append(paramObject);
  }
  
  private void a(StringBuilder paramStringBuilder, a parama, ArrayList<Object> paramArrayList)
  {
    paramStringBuilder.append("[");
    int i = 0;
    int j = paramArrayList.size();
    while (i < j)
    {
      if (i > 0) {
        paramStringBuilder.append(",");
      }
      Object localObject = paramArrayList.get(i);
      if (localObject != null) {
        a(paramStringBuilder, parama, localObject);
      }
      i++;
    }
    paramStringBuilder.append("]");
  }
  
  protected <O, I> I a(a<I, O> parama, Object paramObject)
  {
    if (a.c(parama) != null) {
      paramObject = parama.convertBack(paramObject);
    }
    return paramObject;
  }
  
  protected boolean a(a parama)
  {
    if (parama.hJ() == 11)
    {
      if (parama.hP()) {
        return bf(parama.hQ());
      }
      return be(parama.hQ());
    }
    return bd(parama.hQ());
  }
  
  protected Object b(a parama)
  {
    String str1 = parama.hQ();
    if (parama.hS() != null)
    {
      boolean bool;
      if (bc(parama.hQ()) == null)
      {
        bool = true;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = parama.hQ();
        jx.a(bool, "Concrete field shouldn't be value object: %s", arrayOfObject);
        if (!parama.hP()) {
          break label79;
        }
      }
      label79:
      for (HashMap localHashMap = hM();; localHashMap = hL())
      {
        if (localHashMap == null) {
          break label88;
        }
        return localHashMap.get(str1);
        bool = false;
        break;
      }
      try
      {
        label88:
        String str2 = "get" + Character.toUpperCase(str1.charAt(0)) + str1.substring(1);
        Object localObject = getClass().getMethod(str2, new Class[0]).invoke(this, new Object[0]);
        return localObject;
      }
      catch (Exception localException)
      {
        throw new RuntimeException(localException);
      }
    }
    return bc(parama.hQ());
  }
  
  protected abstract Object bc(String paramString);
  
  protected abstract boolean bd(String paramString);
  
  protected boolean be(String paramString)
  {
    throw new UnsupportedOperationException("Concrete types not supported");
  }
  
  protected boolean bf(String paramString)
  {
    throw new UnsupportedOperationException("Concrete type arrays not supported");
  }
  
  public abstract HashMap<String, a<?, ?>> hK();
  
  public HashMap<String, Object> hL()
  {
    return null;
  }
  
  public HashMap<String, Object> hM()
  {
    return null;
  }
  
  public String toString()
  {
    HashMap localHashMap = hK();
    StringBuilder localStringBuilder = new StringBuilder(100);
    Iterator localIterator = localHashMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      a locala = (a)localHashMap.get(str);
      if (a(locala))
      {
        Object localObject = a(locala, b(locala));
        if (localStringBuilder.length() == 0) {
          localStringBuilder.append("{");
        }
        for (;;)
        {
          localStringBuilder.append("\"").append(str).append("\":");
          if (localObject != null) {
            break label135;
          }
          localStringBuilder.append("null");
          break;
          localStringBuilder.append(",");
        }
        label135:
        switch (locala.hJ())
        {
        default: 
          if (locala.hO()) {
            a(localStringBuilder, locala, (ArrayList)localObject);
          }
          break;
        case 8: 
          localStringBuilder.append("\"").append(lb.d((byte[])localObject)).append("\"");
          break;
        case 9: 
          localStringBuilder.append("\"").append(lb.e((byte[])localObject)).append("\"");
          break;
        case 10: 
          lj.a(localStringBuilder, (HashMap)localObject);
          continue;
          a(localStringBuilder, locala, localObject);
        }
      }
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.append("}");
    }
    for (;;)
    {
      return localStringBuilder.toString();
      localStringBuilder.append("{}");
    }
  }
  
  public static class a<I, O>
    implements SafeParcelable
  {
    public static final kt CREATOR = new kt();
    private final int CK;
    protected final int NL;
    protected final boolean NM;
    protected final int NN;
    protected final boolean NO;
    protected final String NP;
    protected final int NQ;
    protected final Class<? extends kr> NR;
    protected final String NS;
    private kv NT;
    private kr.b<I, O> NU;
    
    a(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, int paramInt4, String paramString2, km paramkm)
    {
      this.CK = paramInt1;
      this.NL = paramInt2;
      this.NM = paramBoolean1;
      this.NN = paramInt3;
      this.NO = paramBoolean2;
      this.NP = paramString1;
      this.NQ = paramInt4;
      if (paramString2 == null) {
        this.NR = null;
      }
      for (this.NS = null; paramkm == null; this.NS = paramString2)
      {
        this.NU = null;
        return;
        this.NR = ky.class;
      }
      this.NU = paramkm.hG();
    }
    
    protected a(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString, int paramInt3, Class<? extends kr> paramClass, kr.b<I, O> paramb)
    {
      this.CK = 1;
      this.NL = paramInt1;
      this.NM = paramBoolean1;
      this.NN = paramInt2;
      this.NO = paramBoolean2;
      this.NP = paramString;
      this.NQ = paramInt3;
      this.NR = paramClass;
      if (paramClass == null) {}
      for (this.NS = null;; this.NS = paramClass.getCanonicalName())
      {
        this.NU = paramb;
        return;
      }
    }
    
    public static a a(String paramString, int paramInt, kr.b<?, ?> paramb, boolean paramBoolean)
    {
      return new a(paramb.hI(), paramBoolean, paramb.hJ(), false, paramString, paramInt, null, paramb);
    }
    
    public static <T extends kr> a<T, T> a(String paramString, int paramInt, Class<T> paramClass)
    {
      return new a(11, false, 11, false, paramString, paramInt, paramClass, null);
    }
    
    public static <T extends kr> a<ArrayList<T>, ArrayList<T>> b(String paramString, int paramInt, Class<T> paramClass)
    {
      return new a(11, true, 11, true, paramString, paramInt, paramClass, null);
    }
    
    public static a<Integer, Integer> i(String paramString, int paramInt)
    {
      return new a(0, false, 0, false, paramString, paramInt, null, null);
    }
    
    public static a<Double, Double> j(String paramString, int paramInt)
    {
      return new a(4, false, 4, false, paramString, paramInt, null, null);
    }
    
    public static a<Boolean, Boolean> k(String paramString, int paramInt)
    {
      return new a(6, false, 6, false, paramString, paramInt, null, null);
    }
    
    public static a<String, String> l(String paramString, int paramInt)
    {
      return new a(7, false, 7, false, paramString, paramInt, null, null);
    }
    
    public static a<ArrayList<String>, ArrayList<String>> m(String paramString, int paramInt)
    {
      return new a(7, true, 7, true, paramString, paramInt, null, null);
    }
    
    public void a(kv paramkv)
    {
      this.NT = paramkv;
    }
    
    public I convertBack(O paramO)
    {
      return this.NU.convertBack(paramO);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public int getVersionCode()
    {
      return this.CK;
    }
    
    public int hI()
    {
      return this.NL;
    }
    
    public int hJ()
    {
      return this.NN;
    }
    
    public a<I, O> hN()
    {
      return new a(this.CK, this.NL, this.NM, this.NN, this.NO, this.NP, this.NQ, this.NS, hV());
    }
    
    public boolean hO()
    {
      return this.NM;
    }
    
    public boolean hP()
    {
      return this.NO;
    }
    
    public String hQ()
    {
      return this.NP;
    }
    
    public int hR()
    {
      return this.NQ;
    }
    
    public Class<? extends kr> hS()
    {
      return this.NR;
    }
    
    String hT()
    {
      if (this.NS == null) {
        return null;
      }
      return this.NS;
    }
    
    public boolean hU()
    {
      return this.NU != null;
    }
    
    km hV()
    {
      if (this.NU == null) {
        return null;
      }
      return km.a(this.NU);
    }
    
    public HashMap<String, a<?, ?>> hW()
    {
      jx.i(this.NS);
      jx.i(this.NT);
      return this.NT.bg(this.NS);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("Field\n");
      localStringBuilder1.append("            versionCode=").append(this.CK).append('\n');
      localStringBuilder1.append("                 typeIn=").append(this.NL).append('\n');
      localStringBuilder1.append("            typeInArray=").append(this.NM).append('\n');
      localStringBuilder1.append("                typeOut=").append(this.NN).append('\n');
      localStringBuilder1.append("           typeOutArray=").append(this.NO).append('\n');
      localStringBuilder1.append("        outputFieldName=").append(this.NP).append('\n');
      localStringBuilder1.append("      safeParcelFieldId=").append(this.NQ).append('\n');
      localStringBuilder1.append("       concreteTypeName=").append(hT()).append('\n');
      if (hS() != null) {
        localStringBuilder1.append("     concreteType.class=").append(hS().getCanonicalName()).append('\n');
      }
      StringBuilder localStringBuilder2 = localStringBuilder1.append("          converterName=");
      if (this.NU == null) {}
      for (String str = "null";; str = this.NU.getClass().getCanonicalName())
      {
        localStringBuilder2.append(str).append('\n');
        return localStringBuilder1.toString();
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      kt.a(this, paramParcel, paramInt);
    }
  }
  
  public static abstract interface b<I, O>
  {
    public abstract I convertBack(O paramO);
    
    public abstract int hI();
    
    public abstract int hJ();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kr
 * JD-Core Version:    0.7.0.1
 */