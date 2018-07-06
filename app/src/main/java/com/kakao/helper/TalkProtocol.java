package com.kakao.helper;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class TalkProtocol
  extends KakaoServiceProtocol
{
  private static final String INTENT_ACTION_LOGGED_IN_ACTIVITY = "com.kakao.talk.intent.action.CAPRI_LOGGED_IN_ACTIVITY";
  private static final String INTENT_ACTION_LOGGED_OUT_ACTIVITY = "com.kakao.talk.intent.action.CAPRI_LOGGED_OUT_ACTIVITY";
  private static final int TALK_MIN_VERSION_SUPPORT_CAPRI = 139;
  private static final int TALK_MIN_VERSION_SUPPORT_PROJEC_LOGIN = 178;
  
  public static Intent createKakakoTalkLinkIntent(Context paramContext, String paramString)
  {
    return checkSupportedService(paramContext, new Intent("android.intent.action.SEND", Uri.parse(paramString)), 139);
  }
  
  public static Intent createLoggedInActivityIntent(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    Intent localIntent = createIntent("com.kakao.talk.intent.action.CAPRI_LOGGED_IN_ACTIVITY", paramString1, paramString2, paramBundle);
    if (paramBoolean) {}
    for (int i = 178;; i = 139) {
      return checkSupportedService(paramContext, localIntent, i);
    }
  }
  
  public static Intent createLoggedOutActivityIntent(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    Intent localIntent = createIntent("com.kakao.talk.intent.action.CAPRI_LOGGED_OUT_ACTIVITY", paramString1, paramString2, paramBundle);
    if (paramBoolean) {}
    for (int i = 178;; i = 139) {
      return checkSupportedService(paramContext, localIntent, i);
    }
  }
  
  public static boolean existCapriLoginActivityInTalk(Context paramContext, boolean paramBoolean)
  {
    Intent localIntent = new Intent().setAction("com.kakao.talk.intent.action.CAPRI_LOGGED_IN_ACTIVITY").addCategory("android.intent.category.DEFAULT");
    if (paramBoolean) {}
    for (int i = 178; checkSupportedService(paramContext, localIntent, i) != null; i = 139) {
      return true;
    }
    return false;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.kakao.helper.TalkProtocol
 * JD-Core Version:    0.7.0.1
 */