package com.google.android.gms.games.snapshot;

import android.graphics.Bitmap;
import android.net.Uri;
import com.google.android.gms.common.data.a;

public abstract class SnapshotMetadataChange
{
  public static final SnapshotMetadataChange EMPTY_CHANGE = new SnapshotMetadataChangeEntity();
  
  public abstract Bitmap getCoverImage();
  
  public abstract String getDescription();
  
  public abstract Long getPlayedTimeMillis();
  
  public abstract a mT();
  
  public static final class Builder
  {
    private String UO;
    private Long afb;
    private a afc;
    private Uri afd;
    
    public SnapshotMetadataChange build()
    {
      return new SnapshotMetadataChangeEntity(this.UO, this.afb, this.afc, this.afd);
    }
    
    public Builder fromMetadata(SnapshotMetadata paramSnapshotMetadata)
    {
      this.UO = paramSnapshotMetadata.getDescription();
      this.afb = Long.valueOf(paramSnapshotMetadata.getPlayedTime());
      if (this.afb.longValue() == -1L) {
        this.afb = null;
      }
      this.afd = paramSnapshotMetadata.getCoverImageUri();
      if (this.afd != null) {
        this.afc = null;
      }
      return this;
    }
    
    public Builder setCoverImage(Bitmap paramBitmap)
    {
      this.afc = new a(paramBitmap);
      this.afd = null;
      return this;
    }
    
    public Builder setDescription(String paramString)
    {
      this.UO = paramString;
      return this;
    }
    
    public Builder setPlayedTimeMillis(long paramLong)
    {
      this.afb = Long.valueOf(paramLong);
      return this;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.snapshot.SnapshotMetadataChange
 * JD-Core Version:    0.7.0.1
 */