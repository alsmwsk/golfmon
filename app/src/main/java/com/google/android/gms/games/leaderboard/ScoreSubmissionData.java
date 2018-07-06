package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.internal.constants.TimeSpan;
import com.google.android.gms.internal.jv;
import com.google.android.gms.internal.jv.a;
import com.google.android.gms.internal.jx;
import java.util.HashMap;

public final class ScoreSubmissionData
{
  private static final String[] adl = { "leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag" };
  private int Iv;
  private String Xh;
  private HashMap<Integer, Result> adR;
  private String adn;
  
  public ScoreSubmissionData(DataHolder paramDataHolder)
  {
    this.Iv = paramDataHolder.getStatusCode();
    this.adR = new HashMap();
    int i = paramDataHolder.getCount();
    if (i == 3) {}
    for (boolean bool = true;; bool = false)
    {
      jx.L(bool);
      for (int j = 0; j < i; j++)
      {
        int k = paramDataHolder.au(j);
        if (j == 0)
        {
          this.adn = paramDataHolder.c("leaderboardId", j, k);
          this.Xh = paramDataHolder.c("playerId", j, k);
        }
        if (paramDataHolder.d("hasResult", j, k)) {
          a(new Result(paramDataHolder.a("rawScore", j, k), paramDataHolder.c("formattedScore", j, k), paramDataHolder.c("scoreTag", j, k), paramDataHolder.d("newBest", j, k)), paramDataHolder.b("timeSpan", j, k));
        }
      }
    }
  }
  
  private void a(Result paramResult, int paramInt)
  {
    this.adR.put(Integer.valueOf(paramInt), paramResult);
  }
  
  public String getLeaderboardId()
  {
    return this.adn;
  }
  
  public String getPlayerId()
  {
    return this.Xh;
  }
  
  public Result getScoreResult(int paramInt)
  {
    return (Result)this.adR.get(Integer.valueOf(paramInt));
  }
  
  public String toString()
  {
    jv.a locala = jv.h(this).a("PlayerId", this.Xh).a("StatusCode", Integer.valueOf(this.Iv));
    int i = 0;
    if (i < 3)
    {
      Result localResult = (Result)this.adR.get(Integer.valueOf(i));
      locala.a("TimesSpan", TimeSpan.dZ(i));
      if (localResult == null) {}
      for (String str = "null";; str = localResult.toString())
      {
        locala.a("Result", str);
        i++;
        break;
      }
    }
    return locala.toString();
  }
  
  public static final class Result
  {
    public final String formattedScore;
    public final boolean newBest;
    public final long rawScore;
    public final String scoreTag;
    
    public Result(long paramLong, String paramString1, String paramString2, boolean paramBoolean)
    {
      this.rawScore = paramLong;
      this.formattedScore = paramString1;
      this.scoreTag = paramString2;
      this.newBest = paramBoolean;
    }
    
    public String toString()
    {
      return jv.h(this).a("RawScore", Long.valueOf(this.rawScore)).a("FormattedScore", this.formattedScore).a("ScoreTag", this.scoreTag).a("NewBest", Boolean.valueOf(this.newBest)).toString();
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.leaderboard.ScoreSubmissionData
 * JD-Core Version:    0.7.0.1
 */