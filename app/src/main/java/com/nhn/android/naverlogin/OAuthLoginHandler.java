package com.nhn.android.naverlogin;

import android.os.Handler;
import android.os.Message;

public abstract class OAuthLoginHandler
  extends Handler
{
  public void handleMessage(Message paramMessage)
  {
    int i = 1;
    super.handleMessage(paramMessage);
    if (paramMessage.what == i) {}
    for (;;)
    {
      run(i);
      return;
      int j = 0;
    }
  }
  
  public abstract void run(boolean paramBoolean);
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nhn.android.naverlogin.OAuthLoginHandler
 * JD-Core Version:    0.7.0.1
 */