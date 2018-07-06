package com.google.android.gms.internal;

import com.google.android.gms.drive.metadata.SearchableOrderedMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.d;
import java.util.Date;

public class lp
{
  public static final a RQ = new a("created", 4100000);
  public static final b RR = new b("lastOpenedTime", 4300000);
  public static final d RS = new d("modified", 4100000);
  public static final c RT = new c("modifiedByMe", 4100000);
  public static final e RU = new e("sharedWithMe", 4100000);
  
  public static class a
    extends d
    implements SortableMetadataField<Date>
  {
    public a(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class b
    extends d
    implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date>
  {
    public b(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class c
    extends d
    implements SortableMetadataField<Date>
  {
    public c(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class d
    extends d
    implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date>
  {
    public d(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class e
    extends d
    implements SearchableOrderedMetadataField<Date>, SortableMetadataField<Date>
  {
    public e(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.lp
 * JD-Core Version:    0.7.0.1
 */