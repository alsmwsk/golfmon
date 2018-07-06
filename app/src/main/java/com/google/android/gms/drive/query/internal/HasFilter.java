package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class HasFilter<T>
  extends AbstractFilter
{
  public static final g CREATOR = new g();
  final int CK;
  final MetadataBundle Si;
  final MetadataField<T> Sj;
  
  HasFilter(int paramInt, MetadataBundle paramMetadataBundle)
  {
    this.CK = paramInt;
    this.Si = paramMetadataBundle;
    this.Sj = e.b(paramMetadataBundle);
  }
  
  public HasFilter(SearchableMetadataField<T> paramSearchableMetadataField, T paramT)
  {
    this(1, MetadataBundle.a(paramSearchableMetadataField, paramT));
  }
  
  public <F> F a(f<F> paramf)
  {
    return paramf.d(this.Sj, getValue());
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public T getValue()
  {
    return this.Si.a(this.Sj);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    g.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.HasFilter
 * JD-Core Version:    0.7.0.1
 */