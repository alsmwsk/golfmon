package com.google.android.gms.games.multiplayer;

import com.google.android.gms.common.data.DataBuffer;

public final class ParticipantBuffer
  extends DataBuffer<Participant>
{
  public Participant get(int paramInt)
  {
    return new ParticipantRef(this.JG, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.multiplayer.ParticipantBuffer
 * JD-Core Version:    0.7.0.1
 */