package com.google.android.gms.games.appcontent;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import java.util.ArrayList;

public final class AppContentAnnotationRef
  extends MultiDataBufferRef
  implements AppContentAnnotation
{
  AppContentAnnotationRef(ArrayList<DataHolder> paramArrayList, int paramInt)
  {
    super(paramArrayList, 2, paramInt);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return AppContentAnnotationEntity.a(this, paramObject);
  }
  
  public String getDescription()
  {
    return getString("annotation_description");
  }
  
  public String getTitle()
  {
    return getString("annotation_title");
  }
  
  public String getType()
  {
    return getString("annotation_type");
  }
  
  public int hashCode()
  {
    return AppContentAnnotationEntity.a(this);
  }
  
  public Uri kL()
  {
    return aR("annotation_image_uri");
  }
  
  public AppContentAnnotation kM()
  {
    return new AppContentAnnotationEntity(this);
  }
  
  public String toString()
  {
    return AppContentAnnotationEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((AppContentAnnotationEntity)kM()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.appcontent.AppContentAnnotationRef
 * JD-Core Version:    0.7.0.1
 */