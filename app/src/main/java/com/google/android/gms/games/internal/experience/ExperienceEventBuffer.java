package com.google.android.gms.games.internal.experience;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class ExperienceEventBuffer
  extends DataBuffer<ExperienceEvent>
{
  public ExperienceEventBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  public ExperienceEvent ea(int paramInt)
  {
    return new ExperienceEventRef(this.JG, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.experience.ExperienceEventBuffer
 * JD-Core Version:    0.7.0.1
 */