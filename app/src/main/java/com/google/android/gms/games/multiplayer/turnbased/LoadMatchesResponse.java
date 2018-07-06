package com.google.android.gms.games.multiplayer.turnbased;

import android.os.Bundle;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TurnBasedMatchTurnStatus;
import com.google.android.gms.games.multiplayer.InvitationBuffer;

public final class LoadMatchesResponse
{
  private final InvitationBuffer aes;
  private final TurnBasedMatchBuffer aet;
  private final TurnBasedMatchBuffer aeu;
  private final TurnBasedMatchBuffer aev;
  
  public LoadMatchesResponse(Bundle paramBundle)
  {
    DataHolder localDataHolder1 = a(paramBundle, 0);
    label48:
    DataHolder localDataHolder3;
    if (localDataHolder1 != null)
    {
      this.aes = new InvitationBuffer(localDataHolder1);
      DataHolder localDataHolder2 = a(paramBundle, 1);
      if (localDataHolder2 == null) {
        break label107;
      }
      this.aet = new TurnBasedMatchBuffer(localDataHolder2);
      localDataHolder3 = a(paramBundle, 2);
      if (localDataHolder3 == null) {
        break label115;
      }
    }
    label107:
    label115:
    for (this.aeu = new TurnBasedMatchBuffer(localDataHolder3);; this.aeu = null)
    {
      DataHolder localDataHolder4 = a(paramBundle, 3);
      if (localDataHolder4 == null) {
        break label123;
      }
      this.aev = new TurnBasedMatchBuffer(localDataHolder4);
      return;
      this.aes = null;
      break;
      this.aet = null;
      break label48;
    }
    label123:
    this.aev = null;
  }
  
  private static DataHolder a(Bundle paramBundle, int paramInt)
  {
    String str = TurnBasedMatchTurnStatus.dZ(paramInt);
    if (!paramBundle.containsKey(str)) {
      return null;
    }
    return (DataHolder)paramBundle.getParcelable(str);
  }
  
  @Deprecated
  public void close()
  {
    release();
  }
  
  public TurnBasedMatchBuffer getCompletedMatches()
  {
    return this.aev;
  }
  
  public InvitationBuffer getInvitations()
  {
    return this.aes;
  }
  
  public TurnBasedMatchBuffer getMyTurnMatches()
  {
    return this.aet;
  }
  
  public TurnBasedMatchBuffer getTheirTurnMatches()
  {
    return this.aeu;
  }
  
  public boolean hasData()
  {
    if ((this.aes != null) && (this.aes.getCount() > 0)) {}
    while (((this.aet != null) && (this.aet.getCount() > 0)) || ((this.aeu != null) && (this.aeu.getCount() > 0)) || ((this.aev != null) && (this.aev.getCount() > 0))) {
      return true;
    }
    return false;
  }
  
  public void release()
  {
    if (this.aes != null) {
      this.aes.release();
    }
    if (this.aet != null) {
      this.aet.release();
    }
    if (this.aeu != null) {
      this.aeu.release();
    }
    if (this.aev != null) {
      this.aev.release();
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse
 * JD-Core Version:    0.7.0.1
 */