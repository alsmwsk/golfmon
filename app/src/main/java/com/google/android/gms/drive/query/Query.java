package com.google.android.gms.drive.query;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.query.internal.LogicalFilter;
import com.google.android.gms.drive.query.internal.MatchAllFilter;
import com.google.android.gms.drive.query.internal.Operator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Query
  implements SafeParcelable
{
  public static final Parcelable.Creator<Query> CREATOR = new a();
  final int CK;
  final LogicalFilter RY;
  final String RZ;
  final SortOrder Sa;
  final List<String> Sb;
  
  Query(int paramInt, LogicalFilter paramLogicalFilter, String paramString, SortOrder paramSortOrder, List<String> paramList)
  {
    this.CK = paramInt;
    this.RY = paramLogicalFilter;
    this.RZ = paramString;
    this.Sa = paramSortOrder;
    this.Sb = paramList;
  }
  
  Query(LogicalFilter paramLogicalFilter, String paramString, SortOrder paramSortOrder, List<String> paramList)
  {
    this(1, paramLogicalFilter, paramString, paramSortOrder, paramList);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Filter getFilter()
  {
    return this.RY;
  }
  
  public String getPageToken()
  {
    return this.RZ;
  }
  
  public SortOrder getSortOrder()
  {
    return this.Sa;
  }
  
  public List<String> jb()
  {
    return this.Sb;
  }
  
  public String toString()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = this.RY;
    arrayOfObject[1] = this.Sa;
    arrayOfObject[2] = this.RZ;
    return String.format(localLocale, "Query[%s,%s,PageToken=%s]", arrayOfObject);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    a.a(this, paramParcel, paramInt);
  }
  
  public static class Builder
  {
    private String RZ;
    private SortOrder Sa;
    private List<String> Sb;
    private final List<Filter> Sc = new ArrayList();
    
    public Builder() {}
    
    public Builder(Query paramQuery)
    {
      this.Sc.add(paramQuery.getFilter());
      this.RZ = paramQuery.getPageToken();
      this.Sa = paramQuery.getSortOrder();
      this.Sb = paramQuery.jb();
    }
    
    public Builder addFilter(Filter paramFilter)
    {
      if (!(paramFilter instanceof MatchAllFilter)) {
        this.Sc.add(paramFilter);
      }
      return this;
    }
    
    public Query build()
    {
      return new Query(new LogicalFilter(Operator.SB, this.Sc), this.RZ, this.Sa, this.Sb);
    }
    
    public Builder setPageToken(String paramString)
    {
      this.RZ = paramString;
      return this;
    }
    
    public Builder setSortOrder(SortOrder paramSortOrder)
    {
      this.Sa = paramSortOrder;
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.Query
 * JD-Core Version:    0.7.0.1
 */