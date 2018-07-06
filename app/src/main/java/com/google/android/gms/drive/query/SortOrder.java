package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.query.internal.FieldWithSortOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SortOrder
  implements SafeParcelable
{
  public static final Parcelable.Creator<SortOrder> CREATOR = new b();
  final int CK;
  final List<FieldWithSortOrder> Sf;
  final boolean Sg;
  
  SortOrder(int paramInt, List<FieldWithSortOrder> paramList, boolean paramBoolean)
  {
    this.CK = paramInt;
    this.Sf = paramList;
    this.Sg = paramBoolean;
  }
  
  private SortOrder(List<FieldWithSortOrder> paramList, boolean paramBoolean)
  {
    this(1, paramList, paramBoolean);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = TextUtils.join(",", this.Sf);
    arrayOfObject[1] = Boolean.valueOf(this.Sg);
    return String.format(localLocale, "SortOrder[%s, %s]", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    b.a(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private final List<FieldWithSortOrder> Sf = new ArrayList();
    private boolean Sg = false;
    
    public Builder addSortAscending(SortableMetadataField paramSortableMetadataField)
    {
      this.Sf.add(new FieldWithSortOrder(paramSortableMetadataField.getName(), true));
      return this;
    }
    
    public Builder addSortDescending(SortableMetadataField paramSortableMetadataField)
    {
      this.Sf.add(new FieldWithSortOrder(paramSortableMetadataField.getName(), false));
      return this;
    }
    
    public SortOrder build()
    {
      return new SortOrder(this.Sf, this.Sg, null);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.SortOrder
 * JD-Core Version:    0.7.0.1
 */