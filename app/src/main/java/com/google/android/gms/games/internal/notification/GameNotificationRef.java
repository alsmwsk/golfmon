package com.google.android.gms.games.internal.notification;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;

public final class GameNotificationRef
  extends d
  implements GameNotification
{
  GameNotificationRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  public long getId()
  {
    return getLong("_id");
  }
  
  public String getText()
  {
    return getString("text");
  }
  
  public String getTitle()
  {
    return getString("title");
  }
  
  public int getType()
  {
    return getInteger("type");
  }
  
  public String mr()
  {
    return getString("notification_id");
  }
  
  public String ms()
  {
    return getString("ticker");
  }
  
  public String mt()
  {
    return getString("coalesced_text");
  }
  
  public boolean mu()
  {
    return getInteger("acknowledged") > 0;
  }
  
  public boolean mv()
  {
    return getInteger("alert_level") == 0;
  }
  
  public String toString()
  {
    return jv.h(this).a("Id", Long.valueOf(getId())).a("NotificationId", mr()).a("Type", Integer.valueOf(getType())).a("Title", getTitle()).a("Ticker", ms()).a("Text", getText()).a("CoalescedText", mt()).a("isAcknowledged", Boolean.valueOf(mu())).a("isSilent", Boolean.valueOf(mv())).toString();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.notification.GameNotificationRef
 * JD-Core Version:    0.7.0.1
 */