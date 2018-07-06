package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;

public final class QuestBuffer
  extends g<Quest>
{
  public QuestBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  protected String ha()
  {
    return "external_quest_id";
  }
  
  protected Quest n(int paramInt1, int paramInt2)
  {
    return new QuestRef(this.JG, paramInt1, paramInt2);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.quest.QuestBuffer
 * JD-Core Version:    0.7.0.1
 */