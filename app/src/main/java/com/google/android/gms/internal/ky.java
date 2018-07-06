package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.internal.safeparcel.a.a;
import com.google.android.gms.common.internal.safeparcel.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ky
  extends kr
  implements SafeParcelable
{
  public static final kz CREATOR = new kz();
  private final int CK;
  private final kv NT;
  private final Parcel Oa;
  private final int Ob;
  private int Oc;
  private int Od;
  private final String mClassName;
  
  ky(int paramInt, Parcel paramParcel, kv paramkv)
  {
    this.CK = paramInt;
    this.Oa = ((Parcel)jx.i(paramParcel));
    this.Ob = 2;
    this.NT = paramkv;
    if (this.NT == null) {}
    for (this.mClassName = null;; this.mClassName = this.NT.ia())
    {
      this.Oc = 2;
      return;
    }
  }
  
  private ky(SafeParcelable paramSafeParcelable, kv paramkv, String paramString)
  {
    this.CK = 1;
    this.Oa = Parcel.obtain();
    paramSafeParcelable.writeToParcel(this.Oa, 0);
    this.Ob = 1;
    this.NT = ((kv)jx.i(paramkv));
    this.mClassName = ((String)jx.i(paramString));
    this.Oc = 2;
  }
  
  public static <T extends kr,  extends SafeParcelable> ky a(T paramT)
  {
    String str = paramT.getClass().getCanonicalName();
    kv localkv = b(paramT);
    return new ky((SafeParcelable)paramT, localkv, str);
  }
  
  private static void a(kv paramkv, kr paramkr)
  {
    Class localClass1 = paramkr.getClass();
    if (!paramkv.b(localClass1))
    {
      HashMap localHashMap = paramkr.hK();
      paramkv.a(localClass1, paramkr.hK());
      Iterator localIterator = localHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        kr.a locala = (kr.a)localHashMap.get((String)localIterator.next());
        Class localClass2 = locala.hS();
        if (localClass2 != null) {
          try
          {
            a(paramkv, (kr)localClass2.newInstance());
          }
          catch (InstantiationException localInstantiationException)
          {
            throw new IllegalStateException("Could not instantiate an object of type " + locala.hS().getCanonicalName(), localInstantiationException);
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            throw new IllegalStateException("Could not access object of type " + locala.hS().getCanonicalName(), localIllegalAccessException);
          }
        }
      }
    }
  }
  
  private void a(StringBuilder paramStringBuilder, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      throw new IllegalArgumentException("Unknown type = " + paramInt);
    case 0: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 5: 
    case 6: 
      paramStringBuilder.append(paramObject);
      return;
    case 7: 
      paramStringBuilder.append("\"").append(li.bh(paramObject.toString())).append("\"");
      return;
    case 8: 
      paramStringBuilder.append("\"").append(lb.d((byte[])paramObject)).append("\"");
      return;
    case 9: 
      paramStringBuilder.append("\"").append(lb.e((byte[])paramObject));
      paramStringBuilder.append("\"");
      return;
    case 10: 
      lj.a(paramStringBuilder, (HashMap)paramObject);
      return;
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }
  
  private void a(StringBuilder paramStringBuilder, kr.a<?, ?> parama, Parcel paramParcel, int paramInt)
  {
    switch (parama.hJ())
    {
    default: 
      throw new IllegalArgumentException("Unknown field out type = " + parama.hJ());
    case 0: 
      b(paramStringBuilder, parama, a(parama, Integer.valueOf(a.g(paramParcel, paramInt))));
      return;
    case 1: 
      b(paramStringBuilder, parama, a(parama, a.k(paramParcel, paramInt)));
      return;
    case 2: 
      b(paramStringBuilder, parama, a(parama, Long.valueOf(a.i(paramParcel, paramInt))));
      return;
    case 3: 
      b(paramStringBuilder, parama, a(parama, Float.valueOf(a.l(paramParcel, paramInt))));
      return;
    case 4: 
      b(paramStringBuilder, parama, a(parama, Double.valueOf(a.m(paramParcel, paramInt))));
      return;
    case 5: 
      b(paramStringBuilder, parama, a(parama, a.n(paramParcel, paramInt)));
      return;
    case 6: 
      b(paramStringBuilder, parama, a(parama, Boolean.valueOf(a.c(paramParcel, paramInt))));
      return;
    case 7: 
      b(paramStringBuilder, parama, a(parama, a.o(paramParcel, paramInt)));
      return;
    case 8: 
    case 9: 
      b(paramStringBuilder, parama, a(parama, a.r(paramParcel, paramInt)));
      return;
    case 10: 
      b(paramStringBuilder, parama, a(parama, g(a.q(paramParcel, paramInt))));
      return;
    }
    throw new IllegalArgumentException("Method does not accept concrete type.");
  }
  
  private void a(StringBuilder paramStringBuilder, String paramString, kr.a<?, ?> parama, Parcel paramParcel, int paramInt)
  {
    paramStringBuilder.append("\"").append(paramString).append("\":");
    if (parama.hU())
    {
      a(paramStringBuilder, parama, paramParcel, paramInt);
      return;
    }
    b(paramStringBuilder, parama, paramParcel, paramInt);
  }
  
  private void a(StringBuilder paramStringBuilder, HashMap<String, kr.a<?, ?>> paramHashMap, Parcel paramParcel)
  {
    HashMap localHashMap = b(paramHashMap);
    paramStringBuilder.append('{');
    int i = a.G(paramParcel);
    int j = 0;
    while (paramParcel.dataPosition() < i)
    {
      int k = a.F(paramParcel);
      Map.Entry localEntry = (Map.Entry)localHashMap.get(Integer.valueOf(a.aH(k)));
      if (localEntry != null)
      {
        if (j != 0) {
          paramStringBuilder.append(",");
        }
        a(paramStringBuilder, (String)localEntry.getKey(), (kr.a)localEntry.getValue(), paramParcel, k);
        j = 1;
      }
    }
    if (paramParcel.dataPosition() != i) {
      throw new a.a("Overread allowed size end=" + i, paramParcel);
    }
    paramStringBuilder.append('}');
  }
  
  private static kv b(kr paramkr)
  {
    kv localkv = new kv(paramkr.getClass());
    a(localkv, paramkr);
    localkv.hY();
    localkv.hX();
    return localkv;
  }
  
  private static HashMap<Integer, Map.Entry<String, kr.a<?, ?>>> b(HashMap<String, kr.a<?, ?>> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localHashMap.put(Integer.valueOf(((kr.a)localEntry.getValue()).hR()), localEntry);
    }
    return localHashMap;
  }
  
  private void b(StringBuilder paramStringBuilder, kr.a<?, ?> parama, Parcel paramParcel, int paramInt)
  {
    if (parama.hP())
    {
      paramStringBuilder.append("[");
      switch (parama.hJ())
      {
      default: 
        throw new IllegalStateException("Unknown field type out.");
      case 0: 
        la.a(paramStringBuilder, a.u(paramParcel, paramInt));
      }
      for (;;)
      {
        paramStringBuilder.append("]");
        return;
        la.a(paramStringBuilder, a.w(paramParcel, paramInt));
        continue;
        la.a(paramStringBuilder, a.v(paramParcel, paramInt));
        continue;
        la.a(paramStringBuilder, a.x(paramParcel, paramInt));
        continue;
        la.a(paramStringBuilder, a.y(paramParcel, paramInt));
        continue;
        la.a(paramStringBuilder, a.z(paramParcel, paramInt));
        continue;
        la.a(paramStringBuilder, a.t(paramParcel, paramInt));
        continue;
        la.a(paramStringBuilder, a.A(paramParcel, paramInt));
        continue;
        throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
        Parcel[] arrayOfParcel = a.E(paramParcel, paramInt);
        int j = arrayOfParcel.length;
        for (int k = 0; k < j; k++)
        {
          if (k > 0) {
            paramStringBuilder.append(",");
          }
          arrayOfParcel[k].setDataPosition(0);
          a(paramStringBuilder, parama.hW(), arrayOfParcel[k]);
        }
      }
    }
    switch (parama.hJ())
    {
    default: 
      throw new IllegalStateException("Unknown field type out");
    case 0: 
      paramStringBuilder.append(a.g(paramParcel, paramInt));
      return;
    case 1: 
      paramStringBuilder.append(a.k(paramParcel, paramInt));
      return;
    case 2: 
      paramStringBuilder.append(a.i(paramParcel, paramInt));
      return;
    case 3: 
      paramStringBuilder.append(a.l(paramParcel, paramInt));
      return;
    case 4: 
      paramStringBuilder.append(a.m(paramParcel, paramInt));
      return;
    case 5: 
      paramStringBuilder.append(a.n(paramParcel, paramInt));
      return;
    case 6: 
      paramStringBuilder.append(a.c(paramParcel, paramInt));
      return;
    case 7: 
      String str2 = a.o(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(li.bh(str2)).append("\"");
      return;
    case 8: 
      byte[] arrayOfByte2 = a.r(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(lb.d(arrayOfByte2)).append("\"");
      return;
    case 9: 
      byte[] arrayOfByte1 = a.r(paramParcel, paramInt);
      paramStringBuilder.append("\"").append(lb.e(arrayOfByte1));
      paramStringBuilder.append("\"");
      return;
    case 10: 
      Bundle localBundle = a.q(paramParcel, paramInt);
      Set localSet = localBundle.keySet();
      localSet.size();
      paramStringBuilder.append("{");
      Iterator localIterator = localSet.iterator();
      for (int i = 1; localIterator.hasNext(); i = 0)
      {
        String str1 = (String)localIterator.next();
        if (i == 0) {
          paramStringBuilder.append(",");
        }
        paramStringBuilder.append("\"").append(str1).append("\"");
        paramStringBuilder.append(":");
        paramStringBuilder.append("\"").append(li.bh(localBundle.getString(str1))).append("\"");
      }
      paramStringBuilder.append("}");
      return;
    }
    Parcel localParcel = a.D(paramParcel, paramInt);
    localParcel.setDataPosition(0);
    a(paramStringBuilder, parama.hW(), localParcel);
  }
  
  private void b(StringBuilder paramStringBuilder, kr.a<?, ?> parama, Object paramObject)
  {
    if (parama.hO())
    {
      b(paramStringBuilder, parama, (ArrayList)paramObject);
      return;
    }
    a(paramStringBuilder, parama.hI(), paramObject);
  }
  
  private void b(StringBuilder paramStringBuilder, kr.a<?, ?> parama, ArrayList<?> paramArrayList)
  {
    paramStringBuilder.append("[");
    int i = paramArrayList.size();
    for (int j = 0; j < i; j++)
    {
      if (j != 0) {
        paramStringBuilder.append(",");
      }
      a(paramStringBuilder, parama.hI(), paramArrayList.get(j));
    }
    paramStringBuilder.append("]");
  }
  
  public static HashMap<String, String> g(Bundle paramBundle)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramBundle.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localHashMap.put(str, paramBundle.getString(str));
    }
    return localHashMap;
  }
  
  protected Object bc(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  protected boolean bd(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public HashMap<String, kr.a<?, ?>> hK()
  {
    if (this.NT == null) {
      return null;
    }
    return this.NT.bg(this.mClassName);
  }
  
  public Parcel ic()
  {
    switch (this.Oc)
    {
    }
    for (;;)
    {
      return this.Oa;
      this.Od = b.H(this.Oa);
      b.H(this.Oa, this.Od);
      this.Oc = 2;
      continue;
      b.H(this.Oa, this.Od);
      this.Oc = 2;
    }
  }
  
  kv id()
  {
    switch (this.Ob)
    {
    default: 
      throw new IllegalStateException("Invalid creation type: " + this.Ob);
    case 0: 
      return null;
    case 1: 
      return this.NT;
    }
    return this.NT;
  }
  
  public String toString()
  {
    jx.b(this.NT, "Cannot convert to JSON on client side.");
    Parcel localParcel = ic();
    localParcel.setDataPosition(0);
    StringBuilder localStringBuilder = new StringBuilder(100);
    a(localStringBuilder, this.NT.bg(this.mClassName), localParcel);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    kz.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ky
 * JD-Core Version:    0.7.0.1
 */