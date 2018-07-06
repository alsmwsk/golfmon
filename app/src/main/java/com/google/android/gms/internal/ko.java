package com.google.android.gms.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public final class ko
  implements SafeParcelable, kr.b<String, Integer>
{
  public static final kp CREATOR = new kp();
  private final int CK;
  private final HashMap<String, Integer> NG;
  private final HashMap<Integer, String> NH;
  private final ArrayList<a> NI;
  
  public ko()
  {
    this.CK = 1;
    this.NG = new HashMap();
    this.NH = new HashMap();
    this.NI = null;
  }
  
  ko(int paramInt, ArrayList<a> paramArrayList)
  {
    this.CK = paramInt;
    this.NG = new HashMap();
    this.NH = new HashMap();
    this.NI = null;
    b(paramArrayList);
  }
  
  private void b(ArrayList<a> paramArrayList)
  {
    Iterator localIterator = paramArrayList.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      h(locala.NJ, locala.NK);
    }
  }
  
  public String a(Integer paramInteger)
  {
    String str = (String)this.NH.get(paramInteger);
    if ((str == null) && (this.NG.containsKey("gms_unknown"))) {
      str = "gms_unknown";
    }
    return str;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  int getVersionCode()
  {
    return this.CK;
  }
  
  public ko h(String paramString, int paramInt)
  {
    this.NG.put(paramString, Integer.valueOf(paramInt));
    this.NH.put(Integer.valueOf(paramInt), paramString);
    return this;
  }
  
  ArrayList<a> hH()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.NG.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new a(str, ((Integer)this.NG.get(str)).intValue()));
    }
    return localArrayList;
  }
  
  public int hI()
  {
    return 7;
  }
  
  public int hJ()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    kp.a(this, paramParcel, paramInt);
  }
  
  public static final class a
    implements SafeParcelable
  {
    public static final kq CREATOR = new kq();
    final String NJ;
    final int NK;
    final int versionCode;
    
    a(int paramInt1, String paramString, int paramInt2)
    {
      this.versionCode = paramInt1;
      this.NJ = paramString;
      this.NK = paramInt2;
    }
    
    a(String paramString, int paramInt)
    {
      this.versionCode = 1;
      this.NJ = paramString;
      this.NK = paramInt;
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      kq.a(this, paramParcel, paramInt);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ko
 * JD-Core Version:    0.7.0.1
 */