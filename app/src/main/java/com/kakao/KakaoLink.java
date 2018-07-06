package com.kakao;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.kakao.helper.Logger;
import com.kakao.helper.SystemInfo;
import com.kakao.helper.TalkProtocol;
import com.kakao.helper.Utility;
import com.kakao.sdk.R.string;
import org.json.JSONException;
import org.json.JSONObject;

public class KakaoLink
{
  static final String APP_KEY_PROPERTY = "com.kakao.sdk.AppKey";
  private static String appKey;
  private static String appKeyHash = "";
  private static String appPackageName;
  private static String appVer = "";
  private static KakaoLink singltonKakaoLink;
  
  static
  {
    appPackageName = "";
  }
  
  public static KakaoLink getKakaoLink(Context paramContext)
    throws KakaoParameterException
  {
    if (singltonKakaoLink != null) {
      return singltonKakaoLink;
    }
    if (appKey == null) {
      appKey = Utility.getMetadata(paramContext, "com.kakao.sdk.AppKey");
    }
    if (TextUtils.isEmpty(appKey)) {
      throw new KakaoParameterException(paramContext.getString(R.string.com_kakao_alert_appKey));
    }
    appVer = String.valueOf(Utility.getAppVersion(paramContext));
    appPackageName = Utility.getAppPackageName(paramContext);
    appKeyHash = Utility.getKeyHash(paramContext);
    singltonKakaoLink = new KakaoLink();
    return singltonKakaoLink;
  }
  
  private String makeExtra()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("KA", SystemInfo.getKAHeader());
      localJSONObject.put("appPkg", appPackageName);
      localJSONObject.put("keyHash", appKeyHash);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      Logger.getInstance().w(localJSONException.getMessage());
    }
    return "";
  }
  
  private String makeReferrer()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("KA", SystemInfo.getKAHeader());
      localJSONObject.put("appkey", appKey);
      localJSONObject.put("appver", appVer);
      localJSONObject.put("appPkg", appPackageName);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      Logger.getInstance().w(localJSONException.getMessage());
    }
    return "";
  }
  
  public KakaoTalkLinkMessageBuilder createKakaoTalkLinkMessageBuilder()
  {
    return new KakaoTalkLinkMessageBuilder(appKey, appVer, makeExtra());
  }
  
  public void sendMessage(String paramString, final Context paramContext)
    throws KakaoParameterException
  {
    Intent localIntent = TalkProtocol.createKakakoTalkLinkIntent(paramContext, paramString);
    if (localIntent == null)
    {
      new AlertDialog.Builder(paramContext).setIcon(17301543).setMessage(paramContext.getString(R.string.com_kakao_alert_install_kakaotalk)).setPositiveButton(17039370, new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.kakao.talk&referrer=" + KakaoLink.this.makeReferrer())));
        }
      }).create().show();
      return;
    }
    paramContext.startActivity(localIntent);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.kakao.KakaoLink
 * JD-Core Version:    0.7.0.1
 */