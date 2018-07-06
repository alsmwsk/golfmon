package com.google.android.gms.games.event;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.le;

public final class EventEntity
  implements SafeParcelable, Event
{
  public static final EventEntityCreator CREATOR = new EventEntityCreator();
  private final int CK;
  private final String UO;
  private final Uri WD;
  private final String WO;
  private final PlayerEntity XE;
  private final String Ye;
  private final long Yf;
  private final String Yg;
  private final boolean Yh;
  private final String mName;
  
  EventEntity(int paramInt, String paramString1, String paramString2, String paramString3, Uri paramUri, String paramString4, Player paramPlayer, long paramLong, String paramString5, boolean paramBoolean)
  {
    this.CK = paramInt;
    this.Ye = paramString1;
    this.mName = paramString2;
    this.UO = paramString3;
    this.WD = paramUri;
    this.WO = paramString4;
    this.XE = new PlayerEntity(paramPlayer);
    this.Yf = paramLong;
    this.Yg = paramString5;
    this.Yh = paramBoolean;
  }
  
  public EventEntity(Event paramEvent)
  {
    this.CK = 1;
    this.Ye = paramEvent.getEventId();
    this.mName = paramEvent.getName();
    this.UO = paramEvent.getDescription();
    this.WD = paramEvent.getIconImageUri();
    this.WO = paramEvent.getIconImageUrl();
    this.XE = ((PlayerEntity)paramEvent.getPlayer().freeze());
    this.Yf = paramEvent.getValue();
    this.Yg = paramEvent.getFormattedValue();
    this.Yh = paramEvent.isVisible();
  }
  
  static int a(Event paramEvent)
  {
    Object[] arrayOfObject = new Object[9];
    arrayOfObject[0] = paramEvent.getEventId();
    arrayOfObject[1] = paramEvent.getName();
    arrayOfObject[2] = paramEvent.getDescription();
    arrayOfObject[3] = paramEvent.getIconImageUri();
    arrayOfObject[4] = paramEvent.getIconImageUrl();
    arrayOfObject[5] = paramEvent.getPlayer();
    arrayOfObject[6] = Long.valueOf(paramEvent.getValue());
    arrayOfObject[7] = paramEvent.getFormattedValue();
    arrayOfObject[8] = Boolean.valueOf(paramEvent.isVisible());
    return jv.hashCode(arrayOfObject);
  }
  
  static boolean a(Event paramEvent, Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof Event)) {
      bool = false;
    }
    Event localEvent;
    do
    {
      do
      {
        return bool;
      } while (paramEvent == paramObject);
      localEvent = (Event)paramObject;
    } while ((jv.equal(localEvent.getEventId(), paramEvent.getEventId())) && (jv.equal(localEvent.getName(), paramEvent.getName())) && (jv.equal(localEvent.getDescription(), paramEvent.getDescription())) && (jv.equal(localEvent.getIconImageUri(), paramEvent.getIconImageUri())) && (jv.equal(localEvent.getIconImageUrl(), paramEvent.getIconImageUrl())) && (jv.equal(localEvent.getPlayer(), paramEvent.getPlayer())) && (jv.equal(Long.valueOf(localEvent.getValue()), Long.valueOf(paramEvent.getValue()))) && (jv.equal(localEvent.getFormattedValue(), paramEvent.getFormattedValue())) && (jv.equal(Boolean.valueOf(localEvent.isVisible()), Boolean.valueOf(paramEvent.isVisible()))));
    return false;
  }
  
  static String b(Event paramEvent)
  {
    return jv.h(paramEvent).a("Id", paramEvent.getEventId()).a("Name", paramEvent.getName()).a("Description", paramEvent.getDescription()).a("IconImageUri", paramEvent.getIconImageUri()).a("IconImageUrl", paramEvent.getIconImageUrl()).a("Player", paramEvent.getPlayer()).a("Value", Long.valueOf(paramEvent.getValue())).a("FormattedValue", paramEvent.getFormattedValue()).a("isVisible", Boolean.valueOf(paramEvent.isVisible())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Event freeze()
  {
    return this;
  }
  
  public String getDescription()
  {
    return this.UO;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    le.b(this.UO, paramCharArrayBuffer);
  }
  
  public String getEventId()
  {
    return this.Ye;
  }
  
  public String getFormattedValue()
  {
    return this.Yg;
  }
  
  public void getFormattedValue(CharArrayBuffer paramCharArrayBuffer)
  {
    le.b(this.Yg, paramCharArrayBuffer);
  }
  
  public Uri getIconImageUri()
  {
    return this.WD;
  }
  
  public String getIconImageUrl()
  {
    return this.WO;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public void getName(CharArrayBuffer paramCharArrayBuffer)
  {
    le.b(this.mName, paramCharArrayBuffer);
  }
  
  public Player getPlayer()
  {
    return this.XE;
  }
  
  public long getValue()
  {
    return this.Yf;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean isVisible()
  {
    return this.Yh;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    EventEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.event.EventEntity
 * JD-Core Version:    0.7.0.1
 */