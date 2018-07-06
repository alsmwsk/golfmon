package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.internal.GamesClientImpl;
import com.google.android.gms.games.internal.game.Acls;
import com.google.android.gms.games.internal.game.Acls.LoadAclResult;

public final class AclsImpl
  implements Acls
{
  private static Acls.LoadAclResult K(Status paramStatus)
  {
    new Acls.LoadAclResult()
    {
      public Status getStatus()
      {
        return this.DS;
      }
      
      public void release() {}
    };
  }
  
  private static abstract class LoadNotifyAclImpl
    extends Games.BaseGamesApiMethodImpl<Acls.LoadAclResult>
  {
    public Acls.LoadAclResult M(Status paramStatus)
    {
      return AclsImpl.L(paramStatus);
    }
  }
  
  private static abstract class UpdateNotifyAclImpl
    extends Games.BaseGamesApiMethodImpl<Status>
  {
    public Status b(Status paramStatus)
    {
      return paramStatus;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.api.AclsImpl
 * JD-Core Version:    0.7.0.1
 */