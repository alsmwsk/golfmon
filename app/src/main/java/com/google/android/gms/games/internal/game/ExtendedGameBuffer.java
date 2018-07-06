package com.google.android.gms.games.internal.game;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.g;

public final class ExtendedGameBuffer
  extends g<ExtendedGame>
{
  public ExtendedGameBuffer(DataHolder paramDataHolder)
  {
    super(paramDataHolder);
  }
  
  protected String ha()
  {
    return "external_game_id";
  }
  
  protected ExtendedGame i(int paramInt1, int paramInt2)
  {
    return new ExtendedGameRef(this.JG, paramInt1, paramInt2);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.game.ExtendedGameBuffer
 * JD-Core Version:    0.7.0.1
 */