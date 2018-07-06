package com.appg.golfmon.util;

import android.content.Context;
import java.io.File;

public class FileUtil
{
  public static boolean checkFileFromLocalCache(Context paramContext, String paramString)
  {
    try
    {
      if (!FormatUtil.isNullorEmpty(paramString))
      {
        String str = wrapLocalUrl(paramContext, paramString);
        File localFile = new File(str);
        boolean bool1 = localFile.isFile();
        if (localFile.length() > 0L) {}
        for (boolean bool2 = true;; bool2 = false)
        {
          boolean bool3 = bool1 & bool2;
          LogUtil.i("체크 : " + str + " = " + bool3 + " //size=" + localFile.length());
          return bool3;
        }
      }
      return false;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static void deleteDir(String paramString)
  {
    LogUtil.d("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
    for (;;)
    {
      int j;
      try
      {
        LogUtil.e("folder path : " + paramString);
        File localFile1 = new File(paramString);
        arrayOfFile = localFile1.listFiles();
        int i = arrayOfFile.length;
        j = 0;
        if (j < i) {
          continue;
        }
        localFile1.delete();
      }
      catch (Exception localException)
      {
        File[] arrayOfFile;
        File localFile2;
        continue;
      }
      LogUtil.d("↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑");
      return;
      localFile2 = arrayOfFile[j];
      if (localFile2.isDirectory())
      {
        deleteDir(localFile2.getAbsolutePath());
      }
      else
      {
        LogUtil.e("delete file : " + localFile2.getAbsolutePath());
        localFile2.delete();
      }
      j++;
    }
  }
  
  public static String getFileName(String paramString)
  {
    return getFileName(paramString, true);
  }
  
  public static String getFileName(String paramString, boolean paramBoolean)
  {
    String str1 = "";
    String str2;
    if (!FormatUtil.isNullorEmpty(paramString)) {
      str2 = ".png";
    }
    try
    {
      str2 = paramString.substring(paramString.lastIndexOf("."));
      if (str2.length() > 4) {
        str2 = ".png";
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LogUtil.e(localException.getMessage());
      }
    }
    str1 = paramString.replaceAll("[./:]", "") + str2;
    LogUtil.e("fieName=" + str1);
    return str1;
  }
  
  public static String wrapLocalUrl(Context paramContext, String paramString)
  {
    try
    {
      if (!FormatUtil.isNullorEmpty(paramString))
      {
        String str = paramContext.getCacheDir().getAbsolutePath() + "/" + paramString;
        LogUtil.i("wrapLocalUrl : " + str);
        return str;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.util.FileUtil
 * JD-Core Version:    0.7.0.1
 */