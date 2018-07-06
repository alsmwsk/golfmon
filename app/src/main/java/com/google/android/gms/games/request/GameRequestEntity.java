package com.google.android.gms.games.request;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class GameRequestEntity
  implements SafeParcelable, GameRequest
{
  public static final GameRequestEntityCreator CREATOR = new GameRequestEntityCreator();
  private final int CK;
  private final int FP;
  private final int Gt;
  private final String Zt;
  private final GameEntity acs;
  private final long adS;
  private final byte[] aeA;
  private final PlayerEntity aeU;
  private final ArrayList<PlayerEntity> aeV;
  private final long aeW;
  private final Bundle aeX;
  
  GameRequestEntity(int paramInt1, GameEntity paramGameEntity, PlayerEntity paramPlayerEntity, byte[] paramArrayOfByte, String paramString, ArrayList<PlayerEntity> paramArrayList, int paramInt2, long paramLong1, long paramLong2, Bundle paramBundle, int paramInt3)
  {
    this.CK = paramInt1;
    this.acs = paramGameEntity;
    this.aeU = paramPlayerEntity;
    this.aeA = paramArrayOfByte;
    this.Zt = paramString;
    this.aeV = paramArrayList;
    this.Gt = paramInt2;
    this.adS = paramLong1;
    this.aeW = paramLong2;
    this.aeX = paramBundle;
    this.FP = paramInt3;
  }
  
  public GameRequestEntity(GameRequest paramGameRequest)
  {
    this.CK = 2;
    this.acs = new GameEntity(paramGameRequest.getGame());
    this.aeU = new PlayerEntity(paramGameRequest.getSender());
    this.Zt = paramGameRequest.getRequestId();
    this.Gt = paramGameRequest.getType();
    this.adS = paramGameRequest.getCreationTimestamp();
    this.aeW = paramGameRequest.getExpirationTimestamp();
    this.FP = paramGameRequest.getStatus();
    byte[] arrayOfByte = paramGameRequest.getData();
    if (arrayOfByte == null) {
      this.aeA = null;
    }
    for (;;)
    {
      List localList = paramGameRequest.getRecipients();
      int i = localList.size();
      this.aeV = new ArrayList(i);
      this.aeX = new Bundle();
      for (int j = 0; j < i; j++)
      {
        Player localPlayer = (Player)((Player)localList.get(j)).freeze();
        String str = localPlayer.getPlayerId();
        this.aeV.add((PlayerEntity)localPlayer);
        this.aeX.putInt(str, paramGameRequest.getRecipientStatus(str));
      }
      this.aeA = new byte[arrayOfByte.length];
      System.arraycopy(arrayOfByte, 0, this.aeA, 0, arrayOfByte.length);
    }
  }
  
  static int a(GameRequest paramGameRequest)
  {
    Object[] arrayOfObject = new Object[8];
    arrayOfObject[0] = paramGameRequest.getGame();
    arrayOfObject[1] = paramGameRequest.getRecipients();
    arrayOfObject[2] = paramGameRequest.getRequestId();
    arrayOfObject[3] = paramGameRequest.getSender();
    arrayOfObject[4] = b(paramGameRequest);
    arrayOfObject[5] = Integer.valueOf(paramGameRequest.getType());
    arrayOfObject[6] = Long.valueOf(paramGameRequest.getCreationTimestamp());
    arrayOfObject[7] = Long.valueOf(paramGameRequest.getExpirationTimestamp());
    return jv.hashCode(arrayOfObject);
  }
  
  static boolean a(GameRequest paramGameRequest, Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof GameRequest)) {
      bool = false;
    }
    GameRequest localGameRequest;
    do
    {
      do
      {
        return bool;
      } while (paramGameRequest == paramObject);
      localGameRequest = (GameRequest)paramObject;
    } while ((jv.equal(localGameRequest.getGame(), paramGameRequest.getGame())) && (jv.equal(localGameRequest.getRecipients(), paramGameRequest.getRecipients())) && (jv.equal(localGameRequest.getRequestId(), paramGameRequest.getRequestId())) && (jv.equal(localGameRequest.getSender(), paramGameRequest.getSender())) && (Arrays.equals(b(localGameRequest), b(paramGameRequest))) && (jv.equal(Integer.valueOf(localGameRequest.getType()), Integer.valueOf(paramGameRequest.getType()))) && (jv.equal(Long.valueOf(localGameRequest.getCreationTimestamp()), Long.valueOf(paramGameRequest.getCreationTimestamp()))) && (jv.equal(Long.valueOf(localGameRequest.getExpirationTimestamp()), Long.valueOf(paramGameRequest.getExpirationTimestamp()))));
    return false;
  }
  
  private static int[] b(GameRequest paramGameRequest)
  {
    List localList = paramGameRequest.getRecipients();
    int i = localList.size();
    int[] arrayOfInt = new int[i];
    for (int j = 0; j < i; j++) {
      arrayOfInt[j] = paramGameRequest.getRecipientStatus(((Player)localList.get(j)).getPlayerId());
    }
    return arrayOfInt;
  }
  
  static String c(GameRequest paramGameRequest)
  {
    return jv.h(paramGameRequest).a("Game", paramGameRequest.getGame()).a("Sender", paramGameRequest.getSender()).a("Recipients", paramGameRequest.getRecipients()).a("Data", paramGameRequest.getData()).a("RequestId", paramGameRequest.getRequestId()).a("Type", Integer.valueOf(paramGameRequest.getType())).a("CreationTimestamp", Long.valueOf(paramGameRequest.getCreationTimestamp())).a("ExpirationTimestamp", Long.valueOf(paramGameRequest.getExpirationTimestamp())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public GameRequest freeze()
  {
    return this;
  }
  
  public long getCreationTimestamp()
  {
    return this.adS;
  }
  
  public byte[] getData()
  {
    return this.aeA;
  }
  
  public long getExpirationTimestamp()
  {
    return this.aeW;
  }
  
  public Game getGame()
  {
    return this.acs;
  }
  
  public int getRecipientStatus(String paramString)
  {
    return this.aeX.getInt(paramString, 0);
  }
  
  public List<Player> getRecipients()
  {
    return new ArrayList(this.aeV);
  }
  
  public String getRequestId()
  {
    return this.Zt;
  }
  
  public Player getSender()
  {
    return this.aeU;
  }
  
  public int getStatus()
  {
    return this.FP;
  }
  
  public int getType()
  {
    return this.Gt;
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    return a(this);
  }
  
  public boolean isConsumed(String paramString)
  {
    return getRecipientStatus(paramString) == 1;
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public Bundle mS()
  {
    return this.aeX;
  }
  
  public String toString()
  {
    return c(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GameRequestEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.request.GameRequestEntity
 * JD-Core Version:    0.7.0.1
 */