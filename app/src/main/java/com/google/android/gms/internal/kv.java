package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class kv
  implements SafeParcelable
{
  public static final kw CREATOR = new kw();
  private final int CK;
  private final HashMap<String, HashMap<String, kr.a<?, ?>>> NV;
  private final ArrayList<a> NW;
  private final String NX;
  
  kv(int paramInt, ArrayList<a> paramArrayList, String paramString)
  {
    this.CK = paramInt;
    this.NW = null;
    this.NV = c(paramArrayList);
    this.NX = ((String)jx.i(paramString));
    hX();
  }
  
  public kv(Class<? extends kr> paramClass)
  {
    this.CK = 1;
    this.NW = null;
    this.NV = new HashMap();
    this.NX = paramClass.getCanonicalName();
  }
  
  private static HashMap<String, HashMap<String, kr.a<?, ?>>> c(ArrayList<a> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    int i = paramArrayList.size();
    for (int j = 0; j < i; j++)
    {
      a locala = (a)paramArrayList.get(j);
      localHashMap.put(locala.className, locala.ib());
    }
    return localHashMap;
  }
  
  public void a(Class<? extends kr> paramClass, HashMap<String, kr.a<?, ?>> paramHashMap)
  {
    this.NV.put(paramClass.getCanonicalName(), paramHashMap);
  }
  
  public boolean b(Class<? extends kr> paramClass)
  {
    return this.NV.containsKey(paramClass.getCanonicalName());
  }
  
  public HashMap<String, kr.a<?, ?>> bg(String paramString)
  {
    return (HashMap)this.NV.get(paramString);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public void hX()
  {
    Iterator localIterator1 = this.NV.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      HashMap localHashMap = (HashMap)this.NV.get(str);
      Iterator localIterator2 = localHashMap.keySet().iterator();
      while (localIterator2.hasNext()) {
        ((kr.a)localHashMap.get((String)localIterator2.next())).a(this);
      }
    }
  }
  
  public void hY()
  {
    Iterator localIterator1 = this.NV.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      HashMap localHashMap1 = (HashMap)this.NV.get(str1);
      HashMap localHashMap2 = new HashMap();
      Iterator localIterator2 = localHashMap1.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        localHashMap2.put(str2, ((kr.a)localHashMap1.get(str2)).hN());
      }
      this.NV.put(str1, localHashMap2);
    }
  }
  
  ArrayList<a> hZ()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.NV.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new a(str, (HashMap)this.NV.get(str)));
    }
    return localArrayList;
  }
  
  public String ia()
  {
    return this.NX;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = this.NV.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      localStringBuilder.append(str1).append(":\n");
      HashMap localHashMap = (HashMap)this.NV.get(str1);
      Iterator localIterator2 = localHashMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        localStringBuilder.append("  ").append(str2).append(": ");
        localStringBuilder.append(localHashMap.get(str2));
      }
    }
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    kw.a(this, paramParcel, paramInt);
  }
  
  public static class a
    implements SafeParcelable
  {
    public static final kx CREATOR = new kx();
    final ArrayList<kv.b> NY;
    final String className;
    final int versionCode;
    
    a(int paramInt, String paramString, ArrayList<kv.b> paramArrayList)
    {
      this.versionCode = paramInt;
      this.className = paramString;
      this.NY = paramArrayList;
    }
    
    a(String paramString, HashMap<String, kr.a<?, ?>> paramHashMap)
    {
      this.versionCode = 1;
      this.className = paramString;
      this.NY = a(paramHashMap);
    }
    
    private static ArrayList<kv.b> a(HashMap<String, kr.a<?, ?>> paramHashMap)
    {
      if (paramHashMap == null) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList.add(new kv.b(str, (kr.a)paramHashMap.get(str)));
      }
      return localArrayList;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    HashMap<String, kr.a<?, ?>> ib()
    {
      HashMap localHashMap = new HashMap();
      int i = this.NY.size();
      for (int j = 0; j < i; j++)
      {
        kv.b localb = (kv.b)this.NY.get(j);
        localHashMap.put(localb.fv, localb.NZ);
      }
      return localHashMap;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      kx.a(this, paramParcel, paramInt);
    }
  }
  
  public static class b
    implements SafeParcelable
  {
    public static final ku CREATOR = new ku();
    final kr.a<?, ?> NZ;
    final String fv;
    final int versionCode;
    
    b(int paramInt, String paramString, kr.a<?, ?> parama)
    {
      this.versionCode = paramInt;
      this.fv = paramString;
      this.NZ = parama;
    }
    
    b(String paramString, kr.a<?, ?> parama)
    {
      this.versionCode = 1;
      this.fv = paramString;
      this.NZ = parama;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      ku.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.kv
 * JD-Core Version:    0.7.0.1
 */