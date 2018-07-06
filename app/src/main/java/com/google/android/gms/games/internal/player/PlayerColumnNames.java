package com.google.android.gms.games.internal.player;

import android.text.TextUtils;

public final class PlayerColumnNames
{
  public final String acL;
  public final String acM;
  public final String acN;
  public final String acO;
  public final String acP;
  public final String acQ;
  public final String acR;
  public final String acS;
  public final String acT;
  public final String acU;
  public final String acV;
  public final String acW;
  public final String acX;
  public final String acY;
  public final String acZ;
  public final String ada;
  public final String adb;
  public final String adc;
  public final String add;
  public final String ade;
  public final String adf;
  public final String adg;
  public final String adh;
  public final String adi;
  public final String adj;
  
  public PlayerColumnNames(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.acL = "external_player_id";
      this.acM = "profile_name";
      this.acN = "profile_icon_image_uri";
      this.acO = "profile_icon_image_url";
      this.acP = "profile_hi_res_image_uri";
      this.acQ = "profile_hi_res_image_url";
      this.acR = "last_updated";
      this.acS = "is_in_circles";
      this.acT = "played_with_timestamp";
      this.acU = "current_xp_total";
      this.acV = "current_level";
      this.acW = "current_level_min_xp";
      this.acX = "current_level_max_xp";
      this.acY = "next_level";
      this.acZ = "next_level_max_xp";
      this.ada = "last_level_up_timestamp";
      this.adb = "player_title";
      this.adc = "has_all_public_acls";
      this.add = "is_profile_visible";
      this.ade = "most_recent_external_game_id";
      this.adf = "most_recent_game_name";
      this.adg = "most_recent_activity_timestamp";
      this.adh = "most_recent_game_icon_uri";
      this.adi = "most_recent_game_hi_res_uri";
      this.adj = "most_recent_game_featured_uri";
      return;
    }
    this.acL = (paramString + "external_player_id");
    this.acM = (paramString + "profile_name");
    this.acN = (paramString + "profile_icon_image_uri");
    this.acO = (paramString + "profile_icon_image_url");
    this.acP = (paramString + "profile_hi_res_image_uri");
    this.acQ = (paramString + "profile_hi_res_image_url");
    this.acR = (paramString + "last_updated");
    this.acS = (paramString + "is_in_circles");
    this.acT = (paramString + "played_with_timestamp");
    this.acU = (paramString + "current_xp_total");
    this.acV = (paramString + "current_level");
    this.acW = (paramString + "current_level_min_xp");
    this.acX = (paramString + "current_level_max_xp");
    this.acY = (paramString + "next_level");
    this.acZ = (paramString + "next_level_max_xp");
    this.ada = (paramString + "last_level_up_timestamp");
    this.adb = (paramString + "player_title");
    this.adc = (paramString + "has_all_public_acls");
    this.add = (paramString + "is_profile_visible");
    this.ade = (paramString + "most_recent_external_game_id");
    this.adf = (paramString + "most_recent_game_name");
    this.adg = (paramString + "most_recent_activity_timestamp");
    this.adh = (paramString + "most_recent_game_icon_uri");
    this.adi = (paramString + "most_recent_game_hi_res_uri");
    this.adj = (paramString + "most_recent_game_featured_uri");
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.player.PlayerColumnNames
 * JD-Core Version:    0.7.0.1
 */