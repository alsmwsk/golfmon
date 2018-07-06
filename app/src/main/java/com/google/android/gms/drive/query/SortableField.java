package com.google.android.gms.drive.query;

import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.internal.ln;
import com.google.android.gms.internal.lp;
import java.util.Date;

public class SortableField
{
  public static final SortableMetadataField<Date> CREATED_DATE;
  public static final SortableMetadataField<Date> LAST_VIEWED_BY_ME;
  public static final SortableMetadataField<Date> MODIFIED_BY_ME_DATE;
  public static final SortableMetadataField<Date> MODIFIED_DATE;
  public static final SortableMetadataField<Long> QUOTA_USED = ln.RG;
  public static final SortableMetadataField<Date> SHARED_WITH_ME_DATE;
  public static final SortableMetadataField<String> TITLE = ln.RJ;
  
  static
  {
    CREATED_DATE = lp.RQ;
    MODIFIED_DATE = lp.RS;
    MODIFIED_BY_ME_DATE = lp.RT;
    LAST_VIEWED_BY_ME = lp.RR;
    SHARED_WITH_ME_DATE = lp.RU;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.query.SortableField
 * JD-Core Version:    0.7.0.1
 */