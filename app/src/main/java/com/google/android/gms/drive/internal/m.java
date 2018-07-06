package com.google.android.gms.drive.internal;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

public final class m
  extends Metadata
{
  private final MetadataBundle PD;
  
  public m(MetadataBundle paramMetadataBundle)
  {
    this.PD = paramMetadataBundle;
  }
  
  protected <T> T a(MetadataField<T> paramMetadataField)
  {
    return this.PD.a(paramMetadataField);
  }
  
  public boolean isDataValid()
  {
    return this.PD != null;
  }
  
  public Metadata iy()
  {
    return new m(MetadataBundle.a(this.PD));
  }
  
  public String toString()
  {
    return "Metadata [mImpl=" + this.PD + "]";
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.drive.internal.m
 * JD-Core Version:    0.7.0.1
 */