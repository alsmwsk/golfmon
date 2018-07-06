package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;

public final class GameSearchSuggestionBuffer
  extends DataBuffer<GameSearchSuggestion>
{
  public GameSearchSuggestionBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  public GameSearchSuggestion ef(int paramInt)
  {
    return new GameSearchSuggestionRef(this.JG, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.game.GameSearchSuggestionBuffer
 * JD-Core Version:    0.7.0.1
 */