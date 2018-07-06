package com.appg.golfmon.util;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONObject;

public class LogUtil
{
  private static boolean ENABLE = true;
  private static String TAG = "APPG_LOG";
  
  public static void d(int paramInt)
  {
    d(paramInt);
  }
  
  public static void d(String paramString)
  {
    d(TAG, paramString);
  }
  
  public static void d(String paramString, int paramInt)
  {
    if (ENABLE) {
      Log.d(paramString, paramInt);
    }
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (ENABLE) {
      Log.d(paramString1, paramString2);
    }
  }
  
  public static void d(String paramString, boolean paramBoolean)
  {
    if (ENABLE) {
      Log.d(paramString, paramBoolean);
    }
  }
  
  public static void d(boolean paramBoolean)
  {
    d(paramBoolean);
  }
  
  public static void e(int paramInt)
  {
    e(paramInt);
  }
  
  public static void e(String paramString)
  {
    e(TAG, paramString);
  }
  
  public static void e(String paramString, int paramInt)
  {
    if (ENABLE) {
      Log.e(paramString, paramInt);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (ENABLE) {
      Log.e(paramString1, paramString2);
    }
  }
  
  public static void e(String paramString, boolean paramBoolean)
  {
    if (ENABLE) {
      Log.e(paramString, paramBoolean);
    }
  }
  
  public static void e(boolean paramBoolean)
  {
    e(paramBoolean);
  }
  
  public static void errorTrace(String paramString, int paramInt, Exception paramException)
  {
    paramException.printStackTrace();
  }
  
  public static void i(int paramInt)
  {
    i(paramInt);
  }
  
  public static void i(String paramString)
  {
    i(TAG, paramString);
  }
  
  public static void i(String paramString1, String paramString2)
  {
    if (ENABLE) {
      Log.i(paramString1, paramString2);
    }
  }
  
  public static void i(boolean paramBoolean)
  {
    i(paramBoolean);
  }
  
  public static void intent(Intent paramIntent)
  {
    intent(TAG, paramIntent);
  }
  
  public static void intent(String paramString, Intent paramIntent)
  {
    if (!ENABLE) {
      return;
    }
    i(paramString, "=============================================================================================================================");
    if (paramIntent == null)
    {
      d(paramString, "intent is null");
      i(paramString, "=============================================================================================================================");
      return;
    }
    if (paramIntent.getData() != null) {
      d(paramString, "intent data : " + paramIntent.getData().toString());
    }
    for (;;)
    {
      String str1;
      Object localObject;
      try
      {
        d(paramString, "intent action : " + paramIntent.getAction());
        Bundle localBundle = paramIntent.getExtras();
        Iterator localIterator;
        if (localBundle != null)
        {
          localIterator = localBundle.keySet().iterator();
          boolean bool = localIterator.hasNext();
          if (bool) {}
        }
        else
        {
          i(paramString, "=============================================================================================================================");
          return;
        }
        str1 = (String)localIterator.next();
        localObject = localBundle.get(str1);
        if ((localObject instanceof String))
        {
          String str2 = (String)localObject;
          d(paramString, str1 + " : " + str2);
          continue;
        }
        if (!(localObject instanceof Integer)) {
          break label249;
        }
      }
      catch (Exception localException)
      {
        i(paramString, "=============================================================================================================================");
        return;
      }
      Integer localInteger = (Integer)localObject;
      d(paramString, str1 + " : " + localInteger);
      continue;
      label249:
      if ((localObject instanceof Boolean))
      {
        Boolean localBoolean = (Boolean)localObject;
        d(paramString, str1 + " : " + localBoolean);
      }
      else
      {
        d(paramString, str1 + " : Unknown Type..");
      }
    }
  }
  
  public static void json(String paramString, JSONObject paramJSONObject)
  {
    if (!ENABLE) {
      return;
    }
    d("=============================================================================================================================");
    if (paramJSONObject == null) {
      d(paramString, "json is null");
    }
    for (;;)
    {
      d("=============================================================================================================================");
      return;
      d(paramString, paramJSONObject.toString());
    }
  }
  
  public static void json(JSONObject paramJSONObject)
  {
    json(TAG, paramJSONObject);
  }
  
  public static void w(Exception paramException)
  {
    if (ENABLE) {
      paramException.printStackTrace();
    }
  }
  
  public static void write(String paramString)
  {
    if (!ENABLE) {
      return;
    }
    try
    {
      Calendar localCalendar = Calendar.getInstance();
      String str = FormatUtil.getDateCalendarToString(localCalendar, "yyyy-MM-dd HH:mm:ss.SSS") + "\t" + paramString + "\n";
      File localFile1 = Environment.getExternalStorageDirectory();
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = FormatUtil.getDateCalendarToString(localCalendar, "yyyyMMdd");
      File localFile2 = new File(localFile1, String.format("log_%s.txt", arrayOfObject));
      if (!localFile2.exists()) {
        localFile2.createNewFile();
      }
      BufferedWriter localBufferedWriter = new BufferedWriter(new FileWriter(localFile2, true));
      localBufferedWriter.write(str);
      localBufferedWriter.flush();
      localBufferedWriter.close();
      e("파일쓰기 : " + paramString);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.util.LogUtil
 * JD-Core Version:    0.7.0.1
 */