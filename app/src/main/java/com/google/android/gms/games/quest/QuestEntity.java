package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.le;
import java.util.ArrayList;
import java.util.List;

public final class QuestEntity
  implements SafeParcelable, Quest
{
  public static final QuestEntityCreator CREATOR = new QuestEntityCreator();
  private final int CK;
  private final int Gt;
  private final String UO;
  private final long XH;
  private final GameEntity acs;
  private final String aeK;
  private final long aeL;
  private final Uri aeM;
  private final String aeN;
  private final long aeO;
  private final Uri aeP;
  private final String aeQ;
  private final long aeR;
  private final long aeS;
  private final ArrayList<MilestoneEntity> aeT;
  private final String mName;
  private final int mState;
  
  QuestEntity(int paramInt1, GameEntity paramGameEntity, String paramString1, long paramLong1, Uri paramUri1, String paramString2, String paramString3, long paramLong2, long paramLong3, Uri paramUri2, String paramString4, String paramString5, long paramLong4, long paramLong5, int paramInt2, int paramInt3, ArrayList<MilestoneEntity> paramArrayList)
  {
    this.CK = paramInt1;
    this.acs = paramGameEntity;
    this.aeK = paramString1;
    this.aeL = paramLong1;
    this.aeM = paramUri1;
    this.aeN = paramString2;
    this.UO = paramString3;
    this.aeO = paramLong2;
    this.XH = paramLong3;
    this.aeP = paramUri2;
    this.aeQ = paramString4;
    this.mName = paramString5;
    this.aeR = paramLong4;
    this.aeS = paramLong5;
    this.mState = paramInt2;
    this.Gt = paramInt3;
    this.aeT = paramArrayList;
  }
  
  public QuestEntity(Quest paramQuest)
  {
    this.CK = 2;
    this.acs = new GameEntity(paramQuest.getGame());
    this.aeK = paramQuest.getQuestId();
    this.aeL = paramQuest.getAcceptedTimestamp();
    this.UO = paramQuest.getDescription();
    this.aeM = paramQuest.getBannerImageUri();
    this.aeN = paramQuest.getBannerImageUrl();
    this.aeO = paramQuest.getEndTimestamp();
    this.aeP = paramQuest.getIconImageUri();
    this.aeQ = paramQuest.getIconImageUrl();
    this.XH = paramQuest.getLastUpdatedTimestamp();
    this.mName = paramQuest.getName();
    this.aeR = paramQuest.mR();
    this.aeS = paramQuest.getStartTimestamp();
    this.mState = paramQuest.getState();
    this.Gt = paramQuest.getType();
    List localList = paramQuest.mQ();
    int i = localList.size();
    this.aeT = new ArrayList(i);
    for (int j = 0; j < i; j++) {
      this.aeT.add((MilestoneEntity)((Milestone)localList.get(j)).freeze());
    }
  }
  
  static int a(Quest paramQuest)
  {
    Object[] arrayOfObject = new Object[13];
    arrayOfObject[0] = paramQuest.getGame();
    arrayOfObject[1] = paramQuest.getQuestId();
    arrayOfObject[2] = Long.valueOf(paramQuest.getAcceptedTimestamp());
    arrayOfObject[3] = paramQuest.getBannerImageUri();
    arrayOfObject[4] = paramQuest.getDescription();
    arrayOfObject[5] = Long.valueOf(paramQuest.getEndTimestamp());
    arrayOfObject[6] = paramQuest.getIconImageUri();
    arrayOfObject[7] = Long.valueOf(paramQuest.getLastUpdatedTimestamp());
    arrayOfObject[8] = paramQuest.mQ();
    arrayOfObject[9] = paramQuest.getName();
    arrayOfObject[10] = Long.valueOf(paramQuest.mR());
    arrayOfObject[11] = Long.valueOf(paramQuest.getStartTimestamp());
    arrayOfObject[12] = Integer.valueOf(paramQuest.getState());
    return jv.hashCode(arrayOfObject);
  }
  
  static boolean a(Quest paramQuest, Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof Quest)) {
      bool = false;
    }
    Quest localQuest;
    do
    {
      do
      {
        return bool;
      } while (paramQuest == paramObject);
      localQuest = (Quest)paramObject;
    } while ((jv.equal(localQuest.getGame(), paramQuest.getGame())) && (jv.equal(localQuest.getQuestId(), paramQuest.getQuestId())) && (jv.equal(Long.valueOf(localQuest.getAcceptedTimestamp()), Long.valueOf(paramQuest.getAcceptedTimestamp()))) && (jv.equal(localQuest.getBannerImageUri(), paramQuest.getBannerImageUri())) && (jv.equal(localQuest.getDescription(), paramQuest.getDescription())) && (jv.equal(Long.valueOf(localQuest.getEndTimestamp()), Long.valueOf(paramQuest.getEndTimestamp()))) && (jv.equal(localQuest.getIconImageUri(), paramQuest.getIconImageUri())) && (jv.equal(Long.valueOf(localQuest.getLastUpdatedTimestamp()), Long.valueOf(paramQuest.getLastUpdatedTimestamp()))) && (jv.equal(localQuest.mQ(), paramQuest.mQ())) && (jv.equal(localQuest.getName(), paramQuest.getName())) && (jv.equal(Long.valueOf(localQuest.mR()), Long.valueOf(paramQuest.mR()))) && (jv.equal(Long.valueOf(localQuest.getStartTimestamp()), Long.valueOf(paramQuest.getStartTimestamp()))) && (jv.equal(Integer.valueOf(localQuest.getState()), Integer.valueOf(paramQuest.getState()))));
    return false;
  }
  
  static String b(Quest paramQuest)
  {
    return jv.h(paramQuest).a("Game", paramQuest.getGame()).a("QuestId", paramQuest.getQuestId()).a("AcceptedTimestamp", Long.valueOf(paramQuest.getAcceptedTimestamp())).a("BannerImageUri", paramQuest.getBannerImageUri()).a("BannerImageUrl", paramQuest.getBannerImageUrl()).a("Description", paramQuest.getDescription()).a("EndTimestamp", Long.valueOf(paramQuest.getEndTimestamp())).a("IconImageUri", paramQuest.getIconImageUri()).a("IconImageUrl", paramQuest.getIconImageUrl()).a("LastUpdatedTimestamp", Long.valueOf(paramQuest.getLastUpdatedTimestamp())).a("Milestones", paramQuest.mQ()).a("Name", paramQuest.getName()).a("NotifyTimestamp", Long.valueOf(paramQuest.mR())).a("StartTimestamp", Long.valueOf(paramQuest.getStartTimestamp())).a("State", Integer.valueOf(paramQuest.getState())).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Quest freeze()
  {
    return this;
  }
  
  public long getAcceptedTimestamp()
  {
    return this.aeL;
  }
  
  public Uri getBannerImageUri()
  {
    return this.aeM;
  }
  
  public String getBannerImageUrl()
  {
    return this.aeN;
  }
  
  public Milestone getCurrentMilestone()
  {
    return (Milestone)mQ().get(0);
  }
  
  public String getDescription()
  {
    return this.UO;
  }
  
  public void getDescription(CharArrayBuffer paramCharArrayBuffer)
  {
    le.b(this.UO, paramCharArrayBuffer);
  }
  
  public long getEndTimestamp()
  {
    return this.aeO;
  }
  
  public Game getGame()
  {
    return this.acs;
  }
  
  public Uri getIconImageUri()
  {
    return this.aeP;
  }
  
  public String getIconImageUrl()
  {
    return this.aeQ;
  }
  
  public long getLastUpdatedTimestamp()
  {
    return this.XH;
  }
  
  public String getName()
  {
    return this.mName;
  }
  
  public void getName(CharArrayBuffer paramCharArrayBuffer)
  {
    le.b(this.mName, paramCharArrayBuffer);
  }
  
  public String getQuestId()
  {
    return this.aeK;
  }
  
  public long getStartTimestamp()
  {
    return this.aeS;
  }
  
  public int getState()
  {
    return this.mState;
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
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public boolean isEndingSoon()
  {
    return this.aeR <= 1800000L + System.currentTimeMillis();
  }
  
  public List<Milestone> mQ()
  {
    return new ArrayList(this.aeT);
  }
  
  public long mR()
  {
    return this.aeR;
  }
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    QuestEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.quest.QuestEntity
 * JD-Core Version:    0.7.0.1
 */