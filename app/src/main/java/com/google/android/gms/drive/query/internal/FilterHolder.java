package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.Filter;

public class FilterHolder
  implements SafeParcelable
{
  public static final Parcelable.Creator<FilterHolder> CREATOR = new d();
  final int CK;
  final ComparisonFilter<?> Sl;
  final FieldOnlyFilter Sm;
  final LogicalFilter Sn;
  final NotFilter So;
  final InFilter<?> Sp;
  final MatchAllFilter Sq;
  final HasFilter Sr;
  private final Filter Ss;
  
  FilterHolder(int paramInt, ComparisonFilter<?> paramComparisonFilter, FieldOnlyFilter paramFieldOnlyFilter, LogicalFilter paramLogicalFilter, NotFilter paramNotFilter, InFilter<?> paramInFilter, MatchAllFilter paramMatchAllFilter, HasFilter<?> paramHasFilter)
  {
    this.CK = paramInt;
    this.Sl = paramComparisonFilter;
    this.Sm = paramFieldOnlyFilter;
    this.Sn = paramLogicalFilter;
    this.So = paramNotFilter;
    this.Sp = paramInFilter;
    this.Sq = paramMatchAllFilter;
    this.Sr = paramHasFilter;
    if (this.Sl != null)
    {
      this.Ss = this.Sl;
      return;
    }
    if (this.Sm != null)
    {
      this.Ss = this.Sm;
      return;
    }
    if (this.Sn != null)
    {
      this.Ss = this.Sn;
      return;
    }
    if (this.So != null)
    {
      this.Ss = this.So;
      return;
    }
    if (this.Sp != null)
    {
      this.Ss = this.Sp;
      return;
    }
    if (this.Sq != null)
    {
      this.Ss = this.Sq;
      return;
    }
    if (this.Sr != null)
    {
      this.Ss = this.Sr;
      return;
    }
    throw new IllegalArgumentException("At least one filter must be set.");
  }
  
  public FilterHolder(Filter paramFilter)
  {
    this.CK = 2;
    ComparisonFilter localComparisonFilter;
    FieldOnlyFilter localFieldOnlyFilter;
    label38:
    LogicalFilter localLogicalFilter;
    label56:
    NotFilter localNotFilter;
    label75:
    InFilter localInFilter;
    label94:
    MatchAllFilter localMatchAllFilter;
    if ((paramFilter instanceof ComparisonFilter))
    {
      localComparisonFilter = (ComparisonFilter)paramFilter;
      this.Sl = localComparisonFilter;
      if (!(paramFilter instanceof FieldOnlyFilter)) {
        break label202;
      }
      localFieldOnlyFilter = (FieldOnlyFilter)paramFilter;
      this.Sm = localFieldOnlyFilter;
      if (!(paramFilter instanceof LogicalFilter)) {
        break label207;
      }
      localLogicalFilter = (LogicalFilter)paramFilter;
      this.Sn = localLogicalFilter;
      if (!(paramFilter instanceof NotFilter)) {
        break label213;
      }
      localNotFilter = (NotFilter)paramFilter;
      this.So = localNotFilter;
      if (!(paramFilter instanceof InFilter)) {
        break label219;
      }
      localInFilter = (InFilter)paramFilter;
      this.Sp = localInFilter;
      if (!(paramFilter instanceof MatchAllFilter)) {
        break label225;
      }
      localMatchAllFilter = (MatchAllFilter)paramFilter;
      label113:
      this.Sq = localMatchAllFilter;
      if (!(paramFilter instanceof HasFilter)) {
        break label231;
      }
    }
    label202:
    label207:
    label213:
    label219:
    label225:
    label231:
    for (HasFilter localHasFilter = (HasFilter)paramFilter;; localHasFilter = null)
    {
      this.Sr = localHasFilter;
      if ((this.Sl != null) || (this.Sm != null) || (this.Sn != null) || (this.So != null) || (this.Sp != null) || (this.Sq != null) || (this.Sr != null)) {
        break label237;
      }
      throw new IllegalArgumentException("Invalid filter type or null filter.");
      localComparisonFilter = null;
      break;
      localFieldOnlyFilter = null;
      break label38;
      localLogicalFilter = null;
      break label56;
      localNotFilter = null;
      break label75;
      localInFilter = null;
      break label94;
      localMatchAllFilter = null;
      break label113;
    }
    label237:
    this.Ss = paramFilter;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Filter getFilter()
  {
    return this.Ss;
  }
  
  public String toString()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.Ss;
    return String.format("FilterHolder[%s]", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    d.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.internal.FilterHolder
 * JD-Core Version:    0.7.0.1
 */