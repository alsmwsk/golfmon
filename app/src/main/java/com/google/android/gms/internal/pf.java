package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.plus.model.moments.ItemScope;
import com.google.android.gms.plus.model.moments.Moment;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class pf
  extends ks
  implements Moment
{
  public static final pg CREATOR = new pg();
  private static final HashMap<String, kr.a<?, ?>> aom = new HashMap();
  String CE;
  final int CK;
  final Set<Integer> aon;
  String apa;
  pd api;
  pd apj;
  String vc;
  
  static
  {
    aom.put("id", kr.a.l("id", 2));
    aom.put("result", kr.a.a("result", 4, pd.class));
    aom.put("startDate", kr.a.l("startDate", 5));
    aom.put("target", kr.a.a("target", 6, pd.class));
    aom.put("type", kr.a.l("type", 7));
  }
  
  public pf()
  {
    this.CK = 1;
    this.aon = new HashSet();
  }
  
  pf(Set<Integer> paramSet, int paramInt, String paramString1, pd parampd1, String paramString2, pd parampd2, String paramString3)
  {
    this.aon = paramSet;
    this.CK = paramInt;
    this.CE = paramString1;
    this.api = parampd1;
    this.apa = paramString2;
    this.apj = parampd2;
    this.vc = paramString3;
  }
  
  public pf(Set<Integer> paramSet, String paramString1, pd parampd1, String paramString2, pd parampd2, String paramString3)
  {
    this.aon = paramSet;
    this.CK = 1;
    this.CE = paramString1;
    this.api = parampd1;
    this.apa = paramString2;
    this.apj = parampd2;
    this.vc = paramString3;
  }
  
  protected boolean a(kr.a parama)
  {
    return this.aon.contains(Integer.valueOf(parama.hR()));
  }
  
  protected Object b(kr.a parama)
  {
    switch (parama.hR())
    {
    case 3: 
    default: 
      throw new IllegalStateException("Unknown safe parcelable id=" + parama.hR());
    case 2: 
      return this.CE;
    case 4: 
      return this.api;
    case 5: 
      return this.apa;
    case 6: 
      return this.apj;
    }
    return this.vc;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof pf)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    pf localpf = (pf)paramObject;
    Iterator localIterator = aom.values().iterator();
    while (localIterator.hasNext())
    {
      kr.a locala = (kr.a)localIterator.next();
      if (a(locala))
      {
        if (localpf.a(locala))
        {
          if (!b(locala).equals(localpf.b(locala))) {
            return false;
          }
        }
        else {
          return false;
        }
      }
      else if (localpf.a(locala)) {
        return false;
      }
    }
    return true;
  }
  
  public String getId()
  {
    return this.CE;
  }
  
  public ItemScope getResult()
  {
    return this.api;
  }
  
  public String getStartDate()
  {
    return this.apa;
  }
  
  public ItemScope getTarget()
  {
    return this.apj;
  }
  
  public String getType()
  {
    return this.vc;
  }
  
  public HashMap<String, kr.a<?, ?>> hK()
  {
    return aom;
  }
  
  public boolean hasId()
  {
    return this.aon.contains(Integer.valueOf(2));
  }
  
  public boolean hasResult()
  {
    return this.aon.contains(Integer.valueOf(4));
  }
  
  public boolean hasStartDate()
  {
    return this.aon.contains(Integer.valueOf(5));
  }
  
  public boolean hasTarget()
  {
    return this.aon.contains(Integer.valueOf(6));
  }
  
  public boolean hasType()
  {
    return this.aon.contains(Integer.valueOf(7));
  }
  
  public int hashCode()
  {
    Iterator localIterator = aom.values().iterator();
    int i = 0;
    kr.a locala;
    if (localIterator.hasNext())
    {
      locala = (kr.a)localIterator.next();
      if (!a(locala)) {
        break label66;
      }
    }
    label66:
    for (int j = i + locala.hR() + b(locala).hashCode();; j = i)
    {
      i = j;
      break;
      return i;
    }
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public pf oJ()
  {
    return this;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    pg.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.pf
 * JD-Core Version:    0.7.0.1
 */