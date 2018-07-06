package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;
import java.util.List;

public final class AppContentCardRef
  extends MultiDataBufferRef
  implements AppContentCard
{
  AppContentCardRef(ArrayList<DataHolder> paramArrayList, int paramInt)
  {
    super(paramArrayList, 0, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return AppContentCardEntity.a(this, paramObject);
  }
  
  public List<AppContentAction> getActions()
  {
    return AppContentUtils.a(this.JG, this.XX, "card_actions", this.KZ);
  }
  
  public String getDescription()
  {
    return getString("card_description");
  }
  
  public Uri getIconImageUri()
  {
    return aR("card_icon_image_uri");
  }
  
  public String getTitle()
  {
    return getString("card_title");
  }
  
  public String getType()
  {
    return getString("card_type");
  }
  
  public int hashCode()
  {
    return AppContentCardEntity.a(this);
  }
  
  public List<AppContentCondition> kH()
  {
    return AppContentUtils.c(this.JG, this.XX, "card_conditions", this.KZ);
  }
  
  public String kI()
  {
    return getString("card_content_description");
  }
  
  public Uri kL()
  {
    return aR("card_image_uri");
  }
  
  public List<AppContentAnnotation> kN()
  {
    return AppContentUtils.b(this.JG, this.XX, "card_annotations", this.KZ);
  }
  
  public int kO()
  {
    return getInteger("card_current_steps");
  }
  
  public Bundle kP()
  {
    return AppContentUtils.d(this.JG, this.XX, "card_data", this.KZ);
  }
  
  public String kQ()
  {
    return getString("card_subtitle");
  }
  
  public int kR()
  {
    return getInteger("card_total_steps");
  }
  
  public AppContentCard kS()
  {
    return new AppContentCardEntity(this);
  }
  
  public String toString()
  {
    return AppContentCardEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((AppContentCardEntity)kS()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.appcontent.AppContentCardRef
 * JD-Core Version:    0.7.0.1
 */