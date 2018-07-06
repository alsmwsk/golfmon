package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;
import java.util.ArrayList;

public final class AppContentSectionBuffer
  extends g<AppContentSection>
{
  private final ArrayList<DataHolder> XX;
  
  protected AppContentSection h(int paramInt1, int paramInt2)
  {
    return new AppContentSectionRef(this.XX, paramInt1, paramInt2);
  }
  
  protected String ha()
  {
    return "section_id";
  }
  
  protected String hc()
  {
    return "card_id";
  }
  
  public void release()
  {
    super.release();
    int i = this.XX.size();
    for (int j = 1; j < i; j++)
    {
      DataHolder localDataHolder = (DataHolder)this.XX.get(j);
      if (localDataHolder != null) {
        localDataHolder.close();
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.appcontent.AppContentSectionBuffer
 * JD-Core Version:    0.7.0.1
 */