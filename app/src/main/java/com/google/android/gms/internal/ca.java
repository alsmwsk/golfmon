package com.google.android.gms.internal;

import java.util.Map;

@ey
public final class ca
  implements cd
{
  private final cb pP;
  
  public ca(cb paramcb)
  {
    this.pP = paramcb;
  }
  
  public void a(gu paramgu, Map<String, String> paramMap)
  {
    String str = (String)paramMap.get("name");
    if (str == null)
    {
      gr.W("App event with no name parameter.");
      return;
    }
    this.pP.onAppEvent(str, (String)paramMap.get("info"));
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ca
 * JD-Core Version:    0.7.0.1
 */