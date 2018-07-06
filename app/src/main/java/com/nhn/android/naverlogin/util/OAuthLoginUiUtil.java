package com.nhn.android.naverlogin.util;

public class OAuthLoginUiUtil
{
  public static boolean isFixActivityPortrait(String paramString)
  {
    if (paramString != null) {}
    try
    {
      if (paramString.length() > 4)
      {
        String[] arrayOfString = paramString.split("\\.");
        if (2 < arrayOfString.length)
        {
          int i = Integer.valueOf(arrayOfString[0]).intValue();
          int j = Integer.valueOf(arrayOfString[1]).intValue();
          int k = Integer.valueOf(arrayOfString[2]).intValue();
          if (4 < i) {}
          do
          {
            do
            {
              return false;
              if (4 != i) {
                break;
              }
            } while (1 < j);
            if (1 != j) {
              break;
            }
          } while (2 < k);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return true;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nhn.android.naverlogin.util.OAuthLoginUiUtil
 * JD-Core Version:    0.7.0.1
 */