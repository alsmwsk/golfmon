package com.google.android.gms.drive;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.drive.metadata.CustomPropertyKey;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.AppVisibleCustomProperties;
import com.google.android.gms.internal.ln;
import com.google.android.gms.internal.lp;
import com.google.android.gms.internal.lr;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

public abstract class Metadata
  implements Freezable<Metadata>
{
  public static final int CONTENT_AVAILABLE_LOCALLY = 1;
  public static final int CONTENT_NOT_AVAILABLE_LOCALLY;
  
  protected abstract <T> T a(MetadataField<T> paramMetadataField);
  
  public String getAlternateLink()
  {
    return (String)a(ln.Rk);
  }
  
  public int getContentAvailability()
  {
    Integer localInteger = (Integer)a(lr.RW);
    if (localInteger == null) {
      return 0;
    }
    return localInteger.intValue();
  }
  
  public Date getCreatedDate()
  {
    return (Date)a(lp.RQ);
  }
  
  public Map<CustomPropertyKey, String> getCustomProperties()
  {
    AppVisibleCustomProperties localAppVisibleCustomProperties = (AppVisibleCustomProperties)a(ln.Rl);
    if (localAppVisibleCustomProperties == null) {
      return Collections.emptyMap();
    }
    return localAppVisibleCustomProperties.iV();
  }
  
  public String getDescription()
  {
    return (String)a(ln.Rm);
  }
  
  public DriveId getDriveId()
  {
    return (DriveId)a(ln.Rj);
  }
  
  public String getEmbedLink()
  {
    return (String)a(ln.Rn);
  }
  
  public String getFileExtension()
  {
    return (String)a(ln.Ro);
  }
  
  public long getFileSize()
  {
    return ((Long)a(ln.Rp)).longValue();
  }
  
  public Date getLastViewedByMeDate()
  {
    return (Date)a(lp.RR);
  }
  
  public String getMimeType()
  {
    return (String)a(ln.RA);
  }
  
  public Date getModifiedByMeDate()
  {
    return (Date)a(lp.RT);
  }
  
  public Date getModifiedDate()
  {
    return (Date)a(lp.RS);
  }
  
  public String getOriginalFilename()
  {
    return (String)a(ln.RB);
  }
  
  public long getQuotaBytesUsed()
  {
    return ((Long)a(ln.RG)).longValue();
  }
  
  public Date getSharedWithMeDate()
  {
    return (Date)a(lp.RU);
  }
  
  public String getTitle()
  {
    return (String)a(ln.RJ);
  }
  
  public String getWebContentLink()
  {
    return (String)a(ln.RL);
  }
  
  public String getWebViewLink()
  {
    return (String)a(ln.RM);
  }
  
  public boolean isEditable()
  {
    Boolean localBoolean = (Boolean)a(ln.Ru);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isFolder()
  {
    return "application/vnd.google-apps.folder".equals(getMimeType());
  }
  
  public boolean isInAppFolder()
  {
    Boolean localBoolean = (Boolean)a(ln.Rs);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isPinnable()
  {
    Boolean localBoolean = (Boolean)a(lr.RX);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isPinned()
  {
    Boolean localBoolean = (Boolean)a(ln.Rv);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isRestricted()
  {
    Boolean localBoolean = (Boolean)a(ln.Rw);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isShared()
  {
    Boolean localBoolean = (Boolean)a(ln.Rx);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isStarred()
  {
    Boolean localBoolean = (Boolean)a(ln.RH);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isTrashed()
  {
    Boolean localBoolean = (Boolean)a(ln.RK);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
  
  public boolean isViewed()
  {
    Boolean localBoolean = (Boolean)a(ln.Rz);
    if (localBoolean == null) {
      return false;
    }
    return localBoolean.booleanValue();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.Metadata
 * JD-Core Version:    0.7.0.1
 */