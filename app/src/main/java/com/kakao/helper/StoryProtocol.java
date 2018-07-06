package com.kakao.helper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class StoryProtocol
  extends KakaoServiceProtocol
{
  private static final String INTENT_ACTION_LOGGED_IN_ACTIVITY = "com.kakao.story.intent.action.CAPRI_LOGGED_IN_ACTIVITY";
  private static final int STORY_MIN_VERSION_SUPPORT_CAPRI = 80;
  private static final int STORY_MIN_VERSION_SUPPORT_PROJEC_LOGIN = 99;
  
  public static Intent createLoggedInActivityIntent(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    Intent localIntent = createIntent("com.kakao.story.intent.action.CAPRI_LOGGED_IN_ACTIVITY", paramString1, paramString2, paramBundle);
    if (paramBoolean) {}
    for (int i = 99;; i = 80) {
      return checkSupportedService(paramContext, localIntent, i);
    }
  }
  
  public static boolean existCapriLoginActivityInStory(Context paramContext, boolean paramBoolean)
  {
    Intent localIntent = new Intent().setAction("com.kakao.story.intent.action.CAPRI_LOGGED_IN_ACTIVITY").addCategory("android.intent.category.DEFAULT");
    if (paramBoolean) {}
    for (int i = 99; checkSupportedService(paramContext, localIntent, i) != null; i = 80) {
      return true;
    }
    return false;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.kakao.helper.StoryProtocol
 * JD-Core Version:    0.7.0.1
 */