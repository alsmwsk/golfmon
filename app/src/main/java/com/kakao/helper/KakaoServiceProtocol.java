package com.kakao.helper;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Bundle;

public class KakaoServiceProtocol
{
  private static final String DEBUG_SIGNATURE = "308201e53082014ea00302010202044f4ae542300d06092a864886f70d01010505003037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f6964204465627567301e170d3132303232373032303635385a170d3432303231393032303635385a3037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f696420446562756730819f300d06092a864886f70d010101050003818d0030818902818100c0b41c25ef21a39a13ce89c82dc3a14bf9ef0c3094aa2ac1bf755c9699535e79119e8b980c0ecdcc51f259eb0d8b2077d41de8fcfdeaac3f386c05e2a684ecb5504b660ad7d5a01cce35899f96bcbd099c9dcb274c6eb41fef861616a12fb45bc57a19683a8a97ab1a33d9c70128878b67dd1b3a388ad5121d1d66ff04c065ff0203010001300d06092a864886f70d0101050500038181000418a7dacb6d13eb61c8270fe1fdd006eb66d0ff9f58f475defd8dc1fb11c41e34ce924531d1fd8ad26d9479d64f54851bf57b8dfe3a5d6f0a01dcad5b8c36ac4ac48caeff37888c36483c26b09aaa9689dbb896938d5afe40135bf7d9f12643046301867165d28be0baa3513a5084e182f7f9c044d5baa58bdce55fa1845241";
  public static final String ERROR_APPLICATION_ERROR = "ApplicationError";
  public static final String ERROR_NETWORK_ERROR = "NetworkError";
  public static final String ERROR_PROTOCOL_ERROR = "ProtocolError";
  public static final String ERROR_UNKNOWN_ERROR = "UnknownError";
  protected static final String EXTRA_APPLICATION_KEY = "com.kakao.sdk.talk.appKey";
  public static final String EXTRA_ERROR_DESCRIPTION = "com.kakao.sdk.talk.error.description";
  public static final String EXTRA_ERROR_TYPE = "com.kakao.sdk.talk.error.type";
  protected static final String EXTRA_EXTRAPARAMS = "com.kakao.sdk.talk.extraparams";
  protected static final String EXTRA_KA_HEADER = "com.kakao.sdk.talk.kaHeader";
  protected static final String EXTRA_PROTOCOL_VERSION = "com.kakao.sdk.talk.protocol.version";
  protected static final String EXTRA_REDIRECT_URI = "com.kakao.sdk.talk.redirectUri";
  public static final String EXTRA_REDIRECT_URL = "com.kakao.sdk.talk.redirectUrl";
  public static final int MESSAGE_GET_AUTH_CODE_REPLY = 65537;
  public static final int MESSAGE_GET_AUTH_CODE_REQUEST = 65536;
  public static final String NOT_SUPPORT_ERROR = "NotSupportError";
  protected static final int PROTOCOL_VERSION = 1;
  private static final String RELEASE_SIGNATURE = "308201db30820144a00302010202044c707197300d06092a864886f70d01010505003031310b3009060355040613026b6f310e300c060355040a13056b616b616f31123010060355040b13096b616b616f7465616d3020170d3130303832323030333834375a180f32313130303732393030333834375a3031310b3009060355040613026b6f310e300c060355040a13056b616b616f31123010060355040b13096b616b616f7465616d30819f300d06092a864886f70d010101050003818d0030818902818100aef387bc86e022a87e66b8c42153284f18e0c468cf9c87a241b989729dfdad3dd9e1847546d01a2819ba77f3974a47b473c926acae173fd90c7e635000721feeef6705da7ae949a35b82900a0f67d9464d73ed8a98c37f4ac70729494a17469bc40d4ee06d043b09147ebadc55fa1020968d7036c5fb9b8c148cba1d8e9d9fc10203010001300d06092a864886f70d0101050500038181005569be704c68cff6221c1e04dd8a131110f9f5cd2138042286337fd6014a1b1d2d3eeb266ae1630afe56bf63c07dd0b5c8fad46dcb9f802f9a7802fb89eb3b4777b9665bb1ed9feaf1dc7cac4f91abedfc81187ff6d2f471dbd12335d2c0ef0e2ee719df6e763f814b9ac91f8be37fd11d40686700d66be6de22a1836f060f01";
  
  protected static Intent checkSupportedService(Context paramContext, Intent paramIntent, int paramInt)
  {
    if (paramIntent == null) {
      paramIntent = null;
    }
    ResolveInfo localResolveInfo;
    do
    {
      return paramIntent;
      localResolveInfo = Utility.resolveIntent(paramContext, paramIntent);
      if (localResolveInfo == null) {
        return null;
      }
    } while (validateTalkSignatureAndMinVersion(paramContext, localResolveInfo.activityInfo.packageName, paramInt));
    return null;
  }
  
  protected static Intent createIntent(String paramString1, String paramString2, String paramString3, Bundle paramBundle)
  {
    Intent localIntent = new Intent().setAction(paramString1).addCategory("android.intent.category.DEFAULT").putExtra("com.kakao.sdk.talk.protocol.version", 1).putExtra("com.kakao.sdk.talk.appKey", paramString2).putExtra("com.kakao.sdk.talk.redirectUri", paramString3).putExtra("com.kakao.sdk.talk.kaHeader", SystemInfo.getKAHeader());
    if ((paramBundle != null) && (!paramBundle.isEmpty())) {
      localIntent.putExtra("com.kakao.sdk.talk.extraparams", paramBundle);
    }
    return localIntent;
  }
  
  public static boolean isCapriProtocolMatched(Intent paramIntent)
  {
    return 1 == paramIntent.getIntExtra("com.kakao.sdk.talk.protocol.version", 0);
  }
  
  private static boolean validateTalkSignatureAndMinVersion(Context paramContext, String paramString, int paramInt)
  {
    PackageInfo localPackageInfo;
    try
    {
      localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramString, 64);
      if ((paramInt > 0) && (localPackageInfo.versionCode < paramInt)) {
        return false;
      }
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      return false;
    }
    Signature[] arrayOfSignature = localPackageInfo.signatures;
    int i = arrayOfSignature.length;
    for (int j = 0; j < i; j++)
    {
      String str = arrayOfSignature[j].toCharsString();
      if ((str.equals("308201db30820144a00302010202044c707197300d06092a864886f70d01010505003031310b3009060355040613026b6f310e300c060355040a13056b616b616f31123010060355040b13096b616b616f7465616d3020170d3130303832323030333834375a180f32313130303732393030333834375a3031310b3009060355040613026b6f310e300c060355040a13056b616b616f31123010060355040b13096b616b616f7465616d30819f300d06092a864886f70d010101050003818d0030818902818100aef387bc86e022a87e66b8c42153284f18e0c468cf9c87a241b989729dfdad3dd9e1847546d01a2819ba77f3974a47b473c926acae173fd90c7e635000721feeef6705da7ae949a35b82900a0f67d9464d73ed8a98c37f4ac70729494a17469bc40d4ee06d043b09147ebadc55fa1020968d7036c5fb9b8c148cba1d8e9d9fc10203010001300d06092a864886f70d0101050500038181005569be704c68cff6221c1e04dd8a131110f9f5cd2138042286337fd6014a1b1d2d3eeb266ae1630afe56bf63c07dd0b5c8fad46dcb9f802f9a7802fb89eb3b4777b9665bb1ed9feaf1dc7cac4f91abedfc81187ff6d2f471dbd12335d2c0ef0e2ee719df6e763f814b9ac91f8be37fd11d40686700d66be6de22a1836f060f01")) || (str.equals("308201e53082014ea00302010202044f4ae542300d06092a864886f70d01010505003037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f6964204465627567301e170d3132303232373032303635385a170d3432303231393032303635385a3037310b30090603550406130255533110300e060355040a1307416e64726f6964311630140603550403130d416e64726f696420446562756730819f300d06092a864886f70d010101050003818d0030818902818100c0b41c25ef21a39a13ce89c82dc3a14bf9ef0c3094aa2ac1bf755c9699535e79119e8b980c0ecdcc51f259eb0d8b2077d41de8fcfdeaac3f386c05e2a684ecb5504b660ad7d5a01cce35899f96bcbd099c9dcb274c6eb41fef861616a12fb45bc57a19683a8a97ab1a33d9c70128878b67dd1b3a388ad5121d1d66ff04c065ff0203010001300d06092a864886f70d0101050500038181000418a7dacb6d13eb61c8270fe1fdd006eb66d0ff9f58f475defd8dc1fb11c41e34ce924531d1fd8ad26d9479d64f54851bf57b8dfe3a5d6f0a01dcad5b8c36ac4ac48caeff37888c36483c26b09aaa9689dbb896938d5afe40135bf7d9f12643046301867165d28be0baa3513a5084e182f7f9c044d5baa58bdce55fa1845241"))) {
        return true;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.kakao.helper.KakaoServiceProtocol
 * JD-Core Version:    0.7.0.1
 */