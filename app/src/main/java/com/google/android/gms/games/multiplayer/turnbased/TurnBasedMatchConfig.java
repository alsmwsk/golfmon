package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.internal.jx;
import java.util.ArrayList;

public abstract class TurnBasedMatchConfig
{
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public static Bundle createAutoMatchCriteria(int paramInt1, int paramInt2, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("min_automatch_players", paramInt1);
    localBundle.putInt("max_automatch_players", paramInt2);
    localBundle.putLong("exclusive_bit_mask", paramLong);
    return localBundle;
  }
  
  public abstract Bundle getAutoMatchCriteria();
  
  public abstract String[] getInvitedPlayerIds();
  
  public abstract int getVariant();
  
  public abstract int mO();
  
  public static final class Builder
  {
    int adW = -1;
    ArrayList<String> ael = new ArrayList();
    Bundle aem = null;
    int aew = 2;
    
    public Builder addInvitedPlayer(String paramString)
    {
      jx.i(paramString);
      this.ael.add(paramString);
      return this;
    }
    
    public Builder addInvitedPlayers(ArrayList<String> paramArrayList)
    {
      jx.i(paramArrayList);
      this.ael.addAll(paramArrayList);
      return this;
    }
    
    public TurnBasedMatchConfig build()
    {
      return new TurnBasedMatchConfigImpl(this);
    }
    
    public Builder setAutoMatchCriteria(Bundle paramBundle)
    {
      this.aem = paramBundle;
      return this;
    }
    
    public Builder setVariant(int paramInt)
    {
      if ((paramInt == -1) || (paramInt > 0)) {}
      for (boolean bool = true;; bool = false)
      {
        jx.b(bool, "Variant must be a positive integer or TurnBasedMatch.MATCH_VARIANT_ANY");
        this.adW = paramInt;
        return this;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig
 * JD-Core Version:    0.7.0.1
 */