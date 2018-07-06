package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public final class AppContentSectionRef
  extends MultiDataBufferRef
  implements AppContentSection
{
  private final int Ya;
  
  AppContentSectionRef(ArrayList<DataHolder> paramArrayList, int paramInt1, int paramInt2)
  {
    super(paramArrayList, 0, paramInt1);
    this.Ya = paramInt2;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return AppContentSectionEntity.a(this, paramObject);
  }
  
  public String getTitle()
  {
    return getString("section_title");
  }
  
  public String getType()
  {
    return getString("section_type");
  }
  
  public int hashCode()
  {
    return AppContentSectionEntity.a(this);
  }
  
  public String kI()
  {
    return getString("section_content_description");
  }
  
  public Bundle kP()
  {
    return AppContentUtils.d(this.JG, this.XX, "section_data", this.KZ);
  }
  
  public String kQ()
  {
    return getString("section_subtitle");
  }
  
  public Uri kY()
  {
    return aR("section_background_image_uri");
  }
  
  public AppContentSection la()
  {
    return new AppContentSectionEntity(this);
  }
  
  public ArrayList<AppContentAction> lb()
  {
    return AppContentUtils.a(this.JG, this.XX, "section_actions", this.KZ);
  }
  
  public ArrayList<AppContentCard> lc()
  {
    ArrayList localArrayList = new ArrayList(this.Ya);
    for (int i = 0; i < this.Ya; i++) {
      localArrayList.add(new AppContentCardRef(this.XX, i + this.KZ));
    }
    return localArrayList;
  }
  
  public String toString()
  {
    return AppContentSectionEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((AppContentSectionEntity)la()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.appcontent.AppContentSectionRef
 * JD-Core Version:    0.7.0.1
 */