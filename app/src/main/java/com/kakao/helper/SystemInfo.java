package com.kakao.helper;

import android.os.Build;
import android.os.Build.VERSION;
import java.util.Locale;

public class SystemInfo
{
  public static final String COUNTRY_CODE = Locale.getDefault().getCountry().toUpperCase();
  public static final String DEVICE_MODEL;
  private static String KA_HEADER;
  public static final String LANGUAGE;
  public static final int OS_VERSION = Build.VERSION.SDK_INT;
  
  static
  {
    DEVICE_MODEL = Build.MODEL.replaceAll("\\s", "-").toUpperCase();
    LANGUAGE = Locale.getDefault().getLanguage().toLowerCase();
  }
  
  public static String getKAHeader()
  {
    if (KA_HEADER == null) {
      KA_HEADER = "sdk/" + "1.0.50" + " " + "os/" + "android" + "-" + OS_VERSION + " " + "lang/" + LANGUAGE + "-" + COUNTRY_CODE + " " + "device/" + DEVICE_MODEL;
    }
    return KA_HEADER;
  }
  
  public static void initialize()
  {
    if (KA_HEADER == null) {
      KA_HEADER = getKAHeader();
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.kakao.helper.SystemInfo
 * JD-Core Version:    0.7.0.1
 */