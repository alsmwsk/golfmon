package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;

public final class MilestoneRef
  extends d
  implements Milestone
{
  MilestoneRef(DataHolder paramDataHolder, int paramInt)
  {
    super(paramDataHolder, paramInt);
  }
  
  private long mP()
  {
    return getLong("initial_value");
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    return MilestoneEntity.a(this, paramObject);
  }
  
  public Milestone freeze()
  {
    return new MilestoneEntity(this);
  }
  
  public byte[] getCompletionRewardData()
  {
    return getByteArray("completion_reward_data");
  }
  
  public long getCurrentProgress()
  {
    switch (getState())
    {
    case 1: 
    default: 
      return 0L;
    case 3: 
    case 4: 
      return getTargetProgress();
    }
    return getLong("current_value") - mP();
  }
  
  public String getEventId()
  {
    return getString("external_event_id");
  }
  
  public String getMilestoneId()
  {
    return getString("external_milestone_id");
  }
  
  public int getState()
  {
    return getInteger("milestone_state");
  }
  
  public long getTargetProgress()
  {
    return getLong("target_value");
  }
  
  public int hashCode()
  {
    return MilestoneEntity.a(this);
  }
  
  public String toString()
  {
    return MilestoneEntity.b(this);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    ((MilestoneEntity)freeze()).writeToParcel(paramParcel, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.quest.MilestoneRef
 * JD-Core Version:    0.7.0.1
 */