package com.google.android.gms.games.internal.request;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestEntity;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.jv;
import java.util.ArrayList;

public final class GameRequestCluster
  implements SafeParcelable, GameRequest
{
  public static final GameRequestClusterCreator CREATOR = new GameRequestClusterCreator();
  private final int CK;
  private final ArrayList<GameRequestEntity> adk;
  
  GameRequestCluster(int paramInt, ArrayList<GameRequestEntity> paramArrayList)
  {
    this.CK = paramInt;
    this.adk = paramArrayList;
    mp();
  }
  
  private void mp()
  {
    boolean bool1;
    GameRequest localGameRequest1;
    int j;
    label39:
    GameRequest localGameRequest2;
    if (!this.adk.isEmpty())
    {
      bool1 = true;
      je.K(bool1);
      localGameRequest1 = (GameRequest)this.adk.get(0);
      int i = this.adk.size();
      j = 1;
      if (j >= i) {
        return;
      }
      localGameRequest2 = (GameRequest)this.adk.get(j);
      if (localGameRequest1.getType() != localGameRequest2.getType()) {
        break label117;
      }
    }
    label117:
    for (boolean bool2 = true;; bool2 = false)
    {
      je.a(bool2, "All the requests must be of the same type");
      je.a(localGameRequest1.getSender().equals(localGameRequest2.getSender()), "All the requests must be from the same sender");
      j++;
      break label39;
      bool1 = false;
      break;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GameRequestCluster)) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    GameRequestCluster localGameRequestCluster = (GameRequestCluster)paramObject;
    if (localGameRequestCluster.adk.size() != this.adk.size()) {
      return false;
    }
    int i = this.adk.size();
    for (int j = 0; j < i; j++) {
      if (!((GameRequest)this.adk.get(j)).equals((GameRequest)localGameRequestCluster.adk.get(j))) {
        return false;
      }
    }
    return true;
  }
  
  public GameRequest freeze()
  {
    return this;
  }
  
  public long getCreationTimestamp()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public byte[] getData()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public long getExpirationTimestamp()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public Game getGame()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public int getRecipientStatus(String paramString)
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public String getRequestId()
  {
    return ((GameRequestEntity)this.adk.get(0)).getRequestId();
  }
  
  public Player getSender()
  {
    return ((GameRequestEntity)this.adk.get(0)).getSender();
  }
  
  public int getStatus()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public int getType()
  {
    return ((GameRequestEntity)this.adk.get(0)).getType();
  }
  
  public int getVersionCode()
  {
    return this.CK;
  }
  
  public int hashCode()
  {
    return jv.hashCode(this.adk.toArray());
  }
  
  public boolean isConsumed(String paramString)
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public ArrayList<GameRequest> mD()
  {
    return new ArrayList(this.adk);
  }
  
  public ArrayList<Player> mE()
  {
    throw new UnsupportedOperationException("Method not supported on a cluster");
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    GameRequestClusterCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.request.GameRequestCluster
 * JD-Core Version:    0.7.0.1
 */