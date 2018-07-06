package com.google.android.gms.drive;

import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties.a;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.jx;
import com.google.android.gms.internal.ln;
import com.google.android.gms.internal.lp;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public final class MetadataChangeSet
{
  public static final int CUSTOM_PROPERTY_SIZE_LIMIT_BYTES = 124;
  public static final int INDEXABLE_TEXT_SIZE_LIMIT_BYTES = 131072;
  public static final int MAX_PRIVATE_PROPERTIES_PER_RESOURCE_PER_APP = 30;
  public static final int MAX_PUBLIC_PROPERTIES_PER_RESOURCE = 30;
  public static final int MAX_TOTAL_PROPERTIES_PER_RESOURCE = 100;
  public static final MetadataChangeSet OE = new MetadataChangeSet(MetadataBundle.iZ());
  private final MetadataBundle OF;
  
  public MetadataChangeSet(MetadataBundle paramMetadataBundle)
  {
    this.OF = MetadataBundle.a(paramMetadataBundle);
  }
  
  public Map<CustomPropertyKey, String> getCustomPropertyChangeMap()
  {
    AppVisibleCustomProperties localAppVisibleCustomProperties = (AppVisibleCustomProperties)this.OF.a(ln.Rl);
    if (localAppVisibleCustomProperties == null) {
      return Collections.emptyMap();
    }
    return localAppVisibleCustomProperties.iV();
  }
  
  public String getDescription()
  {
    return (String)this.OF.a(ln.Rm);
  }
  
  public String getIndexableText()
  {
    return (String)this.OF.a(ln.Rr);
  }
  
  public Date getLastViewedByMeDate()
  {
    return (Date)this.OF.a(lp.RR);
  }
  
  public String getMimeType()
  {
    return (String)this.OF.a(ln.RA);
  }
  
  public String getTitle()
  {
    return (String)this.OF.a(ln.RJ);
  }
  
  public Boolean isPinned()
  {
    return (Boolean)this.OF.a(ln.Rv);
  }
  
  public Boolean isStarred()
  {
    return (Boolean)this.OF.a(ln.RH);
  }
  
  public Boolean isViewed()
  {
    return (Boolean)this.OF.a(ln.Rz);
  }
  
  public MetadataBundle iz()
  {
    return this.OF;
  }
  
  public static class Builder
  {
    private final MetadataBundle OF = MetadataBundle.iZ();
    private AppVisibleCustomProperties.a OG;
    
    private int bk(String paramString)
    {
      if (paramString == null) {
        return 0;
      }
      return paramString.getBytes().length;
    }
    
    private String i(String paramString, int paramInt1, int paramInt2)
    {
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = paramString;
      arrayOfObject[1] = Integer.valueOf(paramInt1);
      arrayOfObject[2] = Integer.valueOf(paramInt2);
      return String.format("%s must be no more than %d bytes, but is %d bytes.", arrayOfObject);
    }
    
    private AppVisibleCustomProperties.a iA()
    {
      if (this.OG == null) {
        this.OG = new AppVisibleCustomProperties.a();
      }
      return this.OG;
    }
    
    private void j(String paramString, int paramInt1, int paramInt2)
    {
      if (paramInt2 <= paramInt1) {}
      for (boolean bool = true;; bool = false)
      {
        jx.b(bool, i(paramString, paramInt1, paramInt2));
        return;
      }
    }
    
    public MetadataChangeSet build()
    {
      if (this.OG != null) {
        this.OF.b(ln.Rl, this.OG.iW());
      }
      return new MetadataChangeSet(this.OF);
    }
    
    public Builder deleteCustomProperty(CustomPropertyKey paramCustomPropertyKey)
    {
      jx.b(paramCustomPropertyKey, "key");
      iA().a(paramCustomPropertyKey, null);
      return this;
    }
    
    public Builder setCustomProperty(CustomPropertyKey paramCustomPropertyKey, String paramString)
    {
      jx.b(paramCustomPropertyKey, "key");
      jx.b(paramString, "value");
      j("The total size of key string and value string of a custom property", 124, bk(paramCustomPropertyKey.getKey()) + bk(paramString));
      iA().a(paramCustomPropertyKey, paramString);
      return this;
    }
    
    public Builder setDescription(String paramString)
    {
      this.OF.b(ln.Rm, paramString);
      return this;
    }
    
    public Builder setIndexableText(String paramString)
    {
      j("Indexable text size", 131072, bk(paramString));
      this.OF.b(ln.Rr, paramString);
      return this;
    }
    
    public Builder setLastViewedByMeDate(Date paramDate)
    {
      this.OF.b(lp.RR, paramDate);
      return this;
    }
    
    public Builder setMimeType(String paramString)
    {
      this.OF.b(ln.RA, paramString);
      return this;
    }
    
    public Builder setPinned(boolean paramBoolean)
    {
      this.OF.b(ln.Rv, Boolean.valueOf(paramBoolean));
      return this;
    }
    
    public Builder setStarred(boolean paramBoolean)
    {
      this.OF.b(ln.RH, Boolean.valueOf(paramBoolean));
      return this;
    }
    
    public Builder setTitle(String paramString)
    {
      this.OF.b(ln.RJ, paramString);
      return this;
    }
    
    public Builder setViewed(boolean paramBoolean)
    {
      this.OF.b(ln.Rz, Boolean.valueOf(paramBoolean));
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.MetadataChangeSet
 * JD-Core Version:    0.7.0.1
 */