package com.appg.golfmon.util;

import android.content.Intent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JSONUtil
{
  public static JSONArray createArray(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {}
    while (!paramIntent.hasExtra(paramString)) {
      return null;
    }
    return createArray(paramIntent.getStringExtra(paramString));
  }
  
  public static JSONArray createArray(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return null;
    }
    try
    {
      JSONArray localJSONArray1 = new JSONArray(paramString);
      localJSONArray2 = localJSONArray1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        JSONArray localJSONArray2 = null;
      }
    }
    return localJSONArray2;
  }
  
  public static JSONObject createObject(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {}
    while (!paramIntent.hasExtra(paramString)) {
      return null;
    }
    return createObject(paramIntent.getStringExtra(paramString));
  }
  
  public static JSONObject createObject(String paramString)
  {
    if ((paramString == null) || ("".equals(paramString))) {
      return null;
    }
    try
    {
      JSONObject localJSONObject1 = new JSONObject(paramString);
      localJSONObject2 = localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        JSONObject localJSONObject2 = null;
      }
    }
    return localJSONObject2;
  }
  
  public static Object get(JSONObject paramJSONObject, String paramString)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has(paramString))) {
      try
      {
        Object localObject = paramJSONObject.get(paramString);
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return null;
  }
  
  public static boolean getBoolean(JSONObject paramJSONObject, String paramString)
  {
    return getBoolean(paramJSONObject, paramString, false);
  }
  
  public static boolean getBoolean(JSONObject paramJSONObject, String paramString, boolean paramBoolean)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has(paramString))) {}
    try
    {
      boolean bool = paramJSONObject.getBoolean(paramString);
      paramBoolean = bool;
      return paramBoolean;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return paramBoolean;
  }
  
  public static double getDouble(JSONObject paramJSONObject, String paramString)
  {
    return getDouble(paramJSONObject, paramString, 4.9E-324D);
  }
  
  public static double getDouble(JSONObject paramJSONObject, String paramString, double paramDouble)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has(paramString))) {}
    try
    {
      double d = paramJSONObject.getDouble(paramString);
      paramDouble = d;
      return paramDouble;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return paramDouble;
  }
  
  public static int getInteger(JSONObject paramJSONObject, String paramString)
  {
    return getInteger(paramJSONObject, paramString, -2147483648);
  }
  
  public static int getInteger(JSONObject paramJSONObject, String paramString, int paramInt)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has(paramString))) {}
    try
    {
      int i = paramJSONObject.getInt(paramString);
      paramInt = i;
      return paramInt;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return paramInt;
  }
  
  public static JSONArray getJSONArray(String paramString1, String paramString2)
  {
    return getJSONArray(createObject(paramString1), paramString2);
  }
  
  public static JSONArray getJSONArray(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return null;
      try
      {
        if (paramJSONObject.has(paramString))
        {
          JSONArray localJSONArray2 = paramJSONObject.getJSONArray(paramString);
          localJSONArray1 = localJSONArray2;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
          JSONArray localJSONArray1 = null;
        }
      }
    }
    return localJSONArray1;
  }
  
  public static JSONObject getJSONObject(String paramString1, String paramString2)
  {
    return getJSONObject(createObject(paramString1), paramString2);
  }
  
  public static JSONObject getJSONObject(JSONArray paramJSONArray, int paramInt)
  {
    if (paramJSONArray == null) {}
    while (paramJSONArray.length() == 0) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = paramJSONArray.getJSONObject(paramInt);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return null;
  }
  
  public static JSONObject getJSONObject(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = paramJSONObject.getJSONObject(paramString);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  public static long getLong(JSONObject paramJSONObject, String paramString)
  {
    return getLong(paramJSONObject, paramString, -9223372036854775808L);
  }
  
  public static long getLong(JSONObject paramJSONObject, String paramString, long paramLong)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has(paramString))) {}
    try
    {
      long l = paramJSONObject.getLong(paramString);
      paramLong = l;
      return paramLong;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return paramLong;
  }
  
  public static String getString(JSONArray paramJSONArray, int paramInt)
  {
    Object localObject = "";
    if (paramJSONArray != null) {}
    try
    {
      String str = paramJSONArray.getString(paramInt);
      localObject = str;
      return localObject;
    }
    catch (Exception localException) {}
    return localObject;
  }
  
  public static String getString(JSONArray paramJSONArray, String paramString1, String paramString2, String paramString3)
  {
    String str = "";
    if (paramJSONArray != null) {}
    for (int i = 0;; i++)
    {
      if (i >= paramJSONArray.length()) {
        return str;
      }
      JSONObject localJSONObject = getJSONObject(paramJSONArray, i);
      if (getString(localJSONObject, paramString1, "").equals(paramString2)) {
        str = getString(localJSONObject, paramString3);
      }
    }
  }
  
  public static String getString(JSONObject paramJSONObject, String paramString)
  {
    return getString(paramJSONObject, paramString, "");
  }
  
  public static String getString(JSONObject paramJSONObject, String paramString1, String paramString2)
  {
    if ((paramJSONObject != null) && (paramJSONObject.has(paramString1))) {}
    try
    {
      String str = paramJSONObject.getString(paramString1).replaceAll("^null$", "");
      paramString2 = str;
      return paramString2;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return paramString2;
  }
  
  public static boolean has(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null) {
      return paramJSONObject.has(paramString);
    }
    return false;
  }
  
  public static JSONObject put(JSONObject paramJSONObject, String paramString, Object paramObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    try
    {
      paramJSONObject.put(paramString, paramObject);
      return paramJSONObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return paramJSONObject;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.util.JSONUtil
 * JD-Core Version:    0.7.0.1
 */