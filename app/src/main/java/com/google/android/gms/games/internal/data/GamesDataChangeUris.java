package com.google.android.gms.games.internal.data;

import android.net.Uri;
import android.net.Uri.Builder;

public final class GamesDataChangeUris
{
  private static final Uri ach = Uri.parse("content://com.google.android.gms.games/").buildUpon().appendPath("data_change").build();
  public static final Uri aci = ach.buildUpon().appendPath("invitations").build();
  public static final Uri acj = ach.buildUpon().appendEncodedPath("players").build();
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.data.GamesDataChangeUris
 * JD-Core Version:    0.7.0.1
 */