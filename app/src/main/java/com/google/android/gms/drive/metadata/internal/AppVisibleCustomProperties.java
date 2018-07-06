package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class AppVisibleCustomProperties
  implements SafeParcelable, Iterable<CustomProperty>
{
  public static final Parcelable.Creator<AppVisibleCustomProperties> CREATOR = new a();
  public static final AppVisibleCustomProperties Rd = new a().iW();
  final int CK;
  final List<CustomProperty> Re;
  
  AppVisibleCustomProperties(int paramInt, Collection<CustomProperty> paramCollection)
  {
    this.CK = paramInt;
    jx.i(paramCollection);
    this.Re = new ArrayList(paramCollection);
  }
  
  private AppVisibleCustomProperties(Collection<CustomProperty> paramCollection)
  {
    this(1, paramCollection);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Map<CustomPropertyKey, String> iV()
  {
    HashMap localHashMap = new HashMap(this.Re.size());
    Iterator localIterator = this.Re.iterator();
    while (localIterator.hasNext())
    {
      CustomProperty localCustomProperty = (CustomProperty)localIterator.next();
      localHashMap.put(localCustomProperty.iX(), localCustomProperty.getValue());
    }
    return Collections.unmodifiableMap(localHashMap);
  }
  
  public Iterator<CustomProperty> iterator()
  {
    return this.Re.iterator();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
  
  public static class a
  {
    private final Map<CustomPropertyKey, CustomProperty> Rf = new HashMap();
    
    public a a(CustomPropertyKey paramCustomPropertyKey, String paramString)
    {
      jx.b(paramCustomPropertyKey, "key");
      this.Rf.put(paramCustomPropertyKey, new CustomProperty(paramCustomPropertyKey, paramString));
      return this;
    }
    
    public AppVisibleCustomProperties iW()
    {
      return new AppVisibleCustomProperties(this.Rf.values(), null);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties
 * JD-Core Version:    0.7.0.1
 */