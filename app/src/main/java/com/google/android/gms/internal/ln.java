package com.google.android.gms.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.a;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.SortableMetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.g;
import com.google.android.gms.drive.metadata.internal.i;
import com.google.android.gms.drive.metadata.internal.j;
import com.google.android.gms.drive.metadata.internal.k;
import com.google.android.gms.drive.metadata.internal.l;
import com.google.android.gms.drive.metadata.internal.m;
import java.util.Collection;
import java.util.Collections;

public class ln
{
  public static final c RA = new c("mimeType", 4100000);
  public static final MetadataField<String> RB = new l("originalFilename", 4300000);
  public static final com.google.android.gms.drive.metadata.b<String> RC = new k("ownerNames", 4300000);
  public static final m RD = new m("lastModifyingUser", 6000000);
  public static final m RE = new m("sharingUser", 6000000);
  public static final d RF = new d("parents", 4100000);
  public static final e RG = new e("quotaBytesUsed", 4300000);
  public static final f RH = new f("starred", 4100000);
  public static final MetadataField<a> RI = new j("thumbnail", Collections.emptySet(), Collections.emptySet(), 4400000)
  {
    protected a k(DataHolder paramAnonymousDataHolder, int paramAnonymousInt1, int paramAnonymousInt2)
    {
      throw new IllegalStateException("Thumbnail field is write only");
    }
  };
  public static final g RJ = new g("title", 4100000);
  public static final h RK = new h("trashed", 4100000);
  public static final MetadataField<String> RL = new l("webContentLink", 4300000);
  public static final MetadataField<String> RM = new l("webViewLink", 4300000);
  public static final MetadataField<String> RN = new l("uniqueIdentifier", 5000000);
  public static final com.google.android.gms.drive.metadata.internal.b RO = new com.google.android.gms.drive.metadata.internal.b("writersCanShare", 6000000);
  public static final MetadataField<String> RP = new l("role", 6000000);
  public static final MetadataField<DriveId> Rj = lq.RV;
  public static final MetadataField<String> Rk = new l("alternateLink", 4300000);
  public static final a Rl = new a(5000000);
  public static final MetadataField<String> Rm = new l("description", 4300000);
  public static final MetadataField<String> Rn = new l("embedLink", 4300000);
  public static final MetadataField<String> Ro = new l("fileExtension", 4300000);
  public static final MetadataField<Long> Rp = new g("fileSize", 4300000);
  public static final MetadataField<Boolean> Rq = new com.google.android.gms.drive.metadata.internal.b("hasThumbnail", 4300000);
  public static final MetadataField<String> Rr = new l("indexableText", 4300000);
  public static final MetadataField<Boolean> Rs = new com.google.android.gms.drive.metadata.internal.b("isAppData", 4300000);
  public static final MetadataField<Boolean> Rt = new com.google.android.gms.drive.metadata.internal.b("isCopyable", 4300000);
  public static final MetadataField<Boolean> Ru = new com.google.android.gms.drive.metadata.internal.b("isEditable", 4100000);
  public static final b Rv = new b("isPinned", 4100000);
  public static final MetadataField<Boolean> Rw = new com.google.android.gms.drive.metadata.internal.b("isRestricted", 4300000);
  public static final MetadataField<Boolean> Rx = new com.google.android.gms.drive.metadata.internal.b("isShared", 4300000);
  public static final MetadataField<Boolean> Ry = new com.google.android.gms.drive.metadata.internal.b("isTrashable", 4400000);
  public static final MetadataField<Boolean> Rz = new com.google.android.gms.drive.metadata.internal.b("isViewed", 4300000);
  
  public static class a
    extends lo
    implements SearchableMetadataField<AppVisibleCustomProperties>
  {
    public a(int paramInt)
    {
      super();
    }
  }
  
  public static class b
    extends com.google.android.gms.drive.metadata.internal.b
    implements SearchableMetadataField<Boolean>
  {
    public b(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class c
    extends l
    implements SearchableMetadataField<String>
  {
    public c(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class d
    extends i<DriveId>
    implements SearchableCollectionMetadataField<DriveId>
  {
    public d(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class e
    extends g
    implements SortableMetadataField<Long>
  {
    public e(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class f
    extends com.google.android.gms.drive.metadata.internal.b
    implements SearchableMetadataField<Boolean>
  {
    public f(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class g
    extends l
    implements SearchableMetadataField<String>, SortableMetadataField<String>
  {
    public g(String paramString, int paramInt)
    {
      super(paramInt);
    }
  }
  
  public static class h
    extends com.google.android.gms.drive.metadata.internal.b
    implements SearchableMetadataField<Boolean>
  {
    public h(String paramString, int paramInt)
    {
      super(paramInt);
    }
    
    protected Boolean e(DataHolder paramDataHolder, int paramInt1, int paramInt2)
    {
      if (paramDataHolder.b(getName(), paramInt1, paramInt2) != 0) {}
      for (boolean bool = true;; bool = false) {
        return Boolean.valueOf(bool);
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ln
 * JD-Core Version:    0.7.0.1
 */