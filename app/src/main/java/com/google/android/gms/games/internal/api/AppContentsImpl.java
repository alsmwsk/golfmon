package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.Games.BaseGamesApiMethodImpl;
import com.google.android.gms.games.appcontent.AppContents;
import com.google.android.gms.games.appcontent.AppContents.LoadAppContentResult;
import com.google.android.gms.games.internal.GamesClientImpl;

public final class AppContentsImpl
  implements AppContents
{
  private static abstract class LoadsImpl
    extends Games.BaseGamesApiMethodImpl<AppContents.LoadAppContentResult>
  {
    public AppContents.LoadAppContentResult N(final Status paramStatus)
    {
      new AppContents.LoadAppContentResult()
      {
        public Status getStatus()
        {
          return paramStatus;
        }
        
        public void release() {}
      };
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.api.AppContentsImpl
 * JD-Core Version:    0.7.0.1
 */