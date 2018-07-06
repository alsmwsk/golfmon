package com.google.android.gms.drive.metadata;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.jx;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class a<T>
  implements MetadataField<T>
{
  private final String QY;
  private final Set<String> QZ;
  private final Set<String> Ra;
  private final int Rb;
  
  protected a(String paramString, int paramInt)
  {
    this.QY = ((String)jx.b(paramString, "fieldName"));
    this.QZ = Collections.singleton(paramString);
    this.Ra = Collections.emptySet();
    this.Rb = paramInt;
  }
  
  protected a(String paramString, Collection<String> paramCollection1, Collection<String> paramCollection2, int paramInt)
  {
    this.QY = ((String)jx.b(paramString, "fieldName"));
    this.QZ = Collections.unmodifiableSet(new HashSet(paramCollection1));
    this.Ra = Collections.unmodifiableSet(new HashSet(paramCollection2));
    this.Rb = paramInt;
  }
  
  public final T a(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    if (b(paramDataHolder, paramInt1, paramInt2)) {
      return c(paramDataHolder, paramInt1, paramInt2);
    }
    return null;
  }
  
  protected abstract void a(Bundle paramBundle, T paramT);
  
  public final void a(DataHolder paramDataHolder, MetadataBundle paramMetadataBundle, int paramInt1, int paramInt2)
  {
    jx.b(paramDataHolder, "dataHolder");
    jx.b(paramMetadataBundle, "bundle");
    paramMetadataBundle.b(this, a(paramDataHolder, paramInt1, paramInt2));
  }
  
  public final void a(T paramT, Bundle paramBundle)
  {
    jx.b(paramBundle, "bundle");
    if (paramT == null)
    {
      paramBundle.putString(getName(), null);
      return;
    }
    a(paramBundle, paramT);
  }
  
  protected boolean b(DataHolder paramDataHolder, int paramInt1, int paramInt2)
  {
    Iterator localIterator = this.QZ.iterator();
    while (localIterator.hasNext()) {
      if (paramDataHolder.h((String)localIterator.next(), paramInt1, paramInt2)) {
        return false;
      }
    }
    return true;
  }
  
  protected abstract T c(DataHolder paramDataHolder, int paramInt1, int paramInt2);
  
  public final String getName()
  {
    return this.QY;
  }
  
  public final T h(Bundle paramBundle)
  {
    jx.b(paramBundle, "bundle");
    if (paramBundle.get(getName()) != null) {
      return i(paramBundle);
    }
    return null;
  }
  
  protected abstract T i(Bundle paramBundle);
  
  public String toString()
  {
    return this.QY;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.a
 * JD-Core Version:    0.7.0.1
 */