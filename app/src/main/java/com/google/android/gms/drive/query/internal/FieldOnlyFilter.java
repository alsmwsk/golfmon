package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public class FieldOnlyFilter
  extends AbstractFilter
{
  public static final Parcelable.Creator<FieldOnlyFilter> CREATOR = new b();
  final int CK;
  final MetadataBundle Si;
  private final MetadataField<?> Sj;
  
  FieldOnlyFilter(int paramInt, MetadataBundle paramMetadataBundle)
  {
    this.CK = paramInt;
    this.Si = paramMetadataBundle;
    this.Sj = e.b(paramMetadataBundle);
  }
  
  public FieldOnlyFilter(SearchableMetadataField<?> paramSearchableMetadataField)
  {
    this(1, MetadataBundle.a(paramSearchableMetadataField, null));
  }
  
  public <T> T a(f<T> paramf)
  {
    return paramf.d(this.Sj);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.FieldOnlyFilter
 * JD-Core Version:    0.7.0.1
 */