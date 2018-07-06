package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.games.GameRef;

public final class ExperienceEventRef
  extends d
  implements ExperienceEvent
{
  private final GameRef acr;
  
  public ExperienceEventRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
    if (aS("external_game_id"))
    {
      this.acr = null;
      return;
    }
    this.acr = new GameRef(this.JG, this.KZ);
  }
  
  public String getIconImageUrl()
  {
    return getString("icon_url");
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.experience.ExperienceEventRef
 * JD-Core Version:    0.7.0.1
 */