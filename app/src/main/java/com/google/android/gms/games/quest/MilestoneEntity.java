package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;

public final class MilestoneEntity
  implements SafeParcelable, Milestone
{
  public static final MilestoneEntityCreator CREATOR = new MilestoneEntityCreator();
  private final int CK;
  private final String Ye;
  private final String Zn;
  private final long aeH;
  private final long aeI;
  private final byte[] aeJ;
  private final int mState;
  
  MilestoneEntity(int paramInt1, String paramString1, long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt2, String paramString2)
  {
    this.CK = paramInt1;
    this.Zn = paramString1;
    this.aeH = paramLong1;
    this.aeI = paramLong2;
    this.aeJ = paramArrayOfByte;
    this.mState = paramInt2;
    this.Ye = paramString2;
  }
  
  public MilestoneEntity(Milestone paramMilestone)
  {
    this.CK = 4;
    this.Zn = paramMilestone.getMilestoneId();
    this.aeH = paramMilestone.getCurrentProgress();
    this.aeI = paramMilestone.getTargetProgress();
    this.mState = paramMilestone.getState();
    this.Ye = paramMilestone.getEventId();
    byte[] arrayOfByte = paramMilestone.getCompletionRewardData();
    if (arrayOfByte == null)
    {
      this.aeJ = null;
      return;
    }
    this.aeJ = new byte[arrayOfByte.length];
    System.arraycopy(arrayOfByte, 0, this.aeJ, 0, arrayOfByte.length);
  }
  
  static int a(Milestone paramMilestone)
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = paramMilestone.getMilestoneId();
    arrayOfObject[1] = Long.valueOf(paramMilestone.getCurrentProgress());
    arrayOfObject[2] = Long.valueOf(paramMilestone.getTargetProgress());
    arrayOfObject[3] = Integer.valueOf(paramMilestone.getState());
    arrayOfObject[4] = paramMilestone.getEventId();
    return jv.hashCode(arrayOfObject);
  }
  
  static boolean a(Milestone paramMilestone, Object paramObject)
  {
    boolean bool = true;
    if (!(paramObject instanceof Milestone)) {
      bool = false;
    }
    Milestone localMilestone;
    do
    {
      do
      {
        return bool;
      } while (paramMilestone == paramObject);
      localMilestone = (Milestone)paramObject;
    } while ((jv.equal(localMilestone.getMilestoneId(), paramMilestone.getMilestoneId())) && (jv.equal(Long.valueOf(localMilestone.getCurrentProgress()), Long.valueOf(paramMilestone.getCurrentProgress()))) && (jv.equal(Long.valueOf(localMilestone.getTargetProgress()), Long.valueOf(paramMilestone.getTargetProgress()))) && (jv.equal(Integer.valueOf(localMilestone.getState()), Integer.valueOf(paramMilestone.getState()))) && (jv.equal(localMilestone.getEventId(), paramMilestone.getEventId())));
    return false;
  }
  
  static String b(Milestone paramMilestone)
  {
    return jv.h(paramMilestone).a("MilestoneId", paramMilestone.getMilestoneId()).a("CurrentProgress", Long.valueOf(paramMilestone.getCurrentProgress())).a("TargetProgress", Long.valueOf(paramMilestone.getTargetProgress())).a("State", Integer.valueOf(paramMilestone.getState())).a("CompletionRewardData", paramMilestone.getCompletionRewardData()).a("EventId", paramMilestone.getEventId()).toString();
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return a(this, paramObject);
  }
  
  public Milestone freeze()
  {
    return this;
  }
  
  public byte[] getCompletionRewardData()
  {
    return this.aeJ;
  }
  
  public long getCurrentProgress()
  {
    return this.aeH;
  }
  
  public String getEventId()
  {
    return this.Ye;
  }
  
  public String getMilestoneId()
  {
    return this.Zn;
  }
  
  public int getState()
  {
    return this.mState;
  }
  
  public long getTargetProgress()
  {
    return this.aeI;
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
  
  public String toString()
  {
    return b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    MilestoneEntityCreator.a(this, paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.quest.MilestoneEntity
 * JD-Core Version:    0.7.0.1
 */