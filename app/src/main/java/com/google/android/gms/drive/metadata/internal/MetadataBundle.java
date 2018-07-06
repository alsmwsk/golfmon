package com.google.android.gms.drive.metadata.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.data.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.w;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.ln;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class MetadataBundle
  implements SafeParcelable
{
  public static final Parcelable.Creator<MetadataBundle> CREATOR = new h();
  final int CK;
  final Bundle Ri;
  
  MetadataBundle(int paramInt, Bundle paramBundle)
  {
    this.CK = paramInt;
    this.Ri = ((Bundle)jx.i(paramBundle));
    this.Ri.setClassLoader(getClass().getClassLoader());
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator1 = this.Ri.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str2 = (String)localIterator1.next();
      if (e.bm(str2) == null)
      {
        localArrayList.add(str2);
        w.o("MetadataBundle", "Ignored unknown metadata field in bundle: " + str2);
      }
    }
    Iterator localIterator2 = localArrayList.iterator();
    while (localIterator2.hasNext())
    {
      String str1 = (String)localIterator2.next();
      this.Ri.remove(str1);
    }
  }
  
  private MetadataBundle(Bundle paramBundle)
  {
    this(1, paramBundle);
  }
  
  public static <T> MetadataBundle a(MetadataField<T> paramMetadataField, T paramT)
  {
    MetadataBundle localMetadataBundle = iZ();
    localMetadataBundle.b(paramMetadataField, paramT);
    return localMetadataBundle;
  }
  
  public static MetadataBundle a(MetadataBundle paramMetadataBundle)
  {
    return new MetadataBundle(new Bundle(paramMetadataBundle.Ri));
  }
  
  public static MetadataBundle iZ()
  {
    return new MetadataBundle(new Bundle());
  }
  
  public <T> T a(MetadataField<T> paramMetadataField)
  {
    return paramMetadataField.h(this.Ri);
  }
  
  public <T> void b(MetadataField<T> paramMetadataField, T paramT)
  {
    if (e.bm(paramMetadataField.getName()) == null) {
      throw new IllegalArgumentException("Unregistered field: " + paramMetadataField.getName());
    }
    paramMetadataField.a(paramT, this.Ri);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof MetadataBundle)) {
      return false;
    }
    MetadataBundle localMetadataBundle = (MetadataBundle)paramObject;
    Set localSet = this.Ri.keySet();
    if (!localSet.equals(localMetadataBundle.Ri.keySet())) {
      return false;
    }
    Iterator localIterator = localSet.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!jv.equal(this.Ri.get(str), localMetadataBundle.Ri.get(str))) {
        return false;
      }
    }
    return true;
  }
  
  public int hashCode()
  {
    Iterator localIterator = this.Ri.keySet().iterator();
    String str;
    for (int i = 1; localIterator.hasNext(); i = i * 31 + this.Ri.get(str).hashCode()) {
      str = (String)localIterator.next();
    }
    return i;
  }
  
  public Set<MetadataField<?>> ja()
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.Ri.keySet().iterator();
    while (localIterator.hasNext()) {
      localHashSet.add(e.bm((String)localIterator.next()));
    }
    return localHashSet;
  }
  
  public void setContext(Context paramContext)
  {
    a locala = (a)a(ln.RI);
    if (locala != null) {
      locala.a(paramContext.getCacheDir());
    }
  }
  
  public String toString()
  {
    return "MetadataBundle [values=" + this.Ri + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    h.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.MetadataBundle
 * JD-Core Version:    0.7.0.1
 */