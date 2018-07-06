package com.appg.golfmon.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class SPUtilBase
{
  private JSONArray createJSONArray(String paramString)
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
  
  private JSONObject createJSONObject(String paramString)
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
  
  private SharedPreferences getSharedPreferences(Context paramContext, String paramString)
  {
    return paramContext.getSharedPreferences(paramString, 0);
  }
  
  public void clearData(Context paramContext, String paramString)
  {
    SharedPreferences.Editor localEditor = getSharedPreferences(paramContext, paramString).edit();
    localEditor.clear();
    localEditor.commit();
  }
  
  public void deleteData(Context paramContext, String paramString1, String paramString2)
  {
    deleteData(paramContext, paramString1, new String[] { paramString2 });
  }
  
  public void deleteData(Context paramContext, String paramString, String[] paramArrayOfString)
  {
    SharedPreferences.Editor localEditor = getSharedPreferences(paramContext, paramString).edit();
    for (int i = 0;; i++)
    {
      if (i >= paramArrayOfString.length)
      {
        localEditor.commit();
        return;
      }
      localEditor.remove(paramArrayOfString[i]);
    }
  }
  
  public HashMap<String, ?> readAll(Context paramContext, String paramString)
  {
    return (HashMap)getSharedPreferences(paramContext, paramString).getAll();
  }
  
  public boolean readBoolean(Context paramContext, String paramString1, String paramString2)
  {
    return readBoolean(paramContext, paramString1, paramString2, false);
  }
  
  public boolean readBoolean(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    return getSharedPreferences(paramContext, paramString1).getBoolean(paramString2, paramBoolean);
  }
  
  public float readFloat(Context paramContext, String paramString1, String paramString2)
  {
    return readFloat(paramContext, paramString1, paramString2, 0.0F);
  }
  
  public float readFloat(Context paramContext, String paramString1, String paramString2, float paramFloat)
  {
    return getSharedPreferences(paramContext, paramString1).getFloat(paramString2, paramFloat);
  }
  
  public int readInt(Context paramContext, String paramString1, String paramString2)
  {
    return readInt(paramContext, paramString1, paramString2, 0);
  }
  
  public int readInt(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    return getSharedPreferences(paramContext, paramString1).getInt(paramString2, paramInt);
  }
  
  public JSONArray readJSONArray(Context paramContext, String paramString1, String paramString2)
  {
    return createJSONArray(readString(paramContext, paramString1, paramString2));
  }
  
  public JSONObject readJSONObject(Context paramContext, String paramString1, String paramString2)
  {
    return createJSONObject(readString(paramContext, paramString1, paramString2));
  }
  
  public long readLong(Context paramContext, String paramString1, String paramString2)
  {
    return readLong(paramContext, paramString1, paramString2, 0L);
  }
  
  public long readLong(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    return getSharedPreferences(paramContext, paramString1).getLong(paramString2, paramLong);
  }
  
  public String readString(Context paramContext, String paramString1, String paramString2)
  {
    return readString(paramContext, paramString1, paramString2, null);
  }
  
  public String readString(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    return getSharedPreferences(paramContext, paramString1).getString(paramString2, paramString3);
  }
  
  public void removeMap(Context paramContext, String paramString, HashMap<String, ?> paramHashMap)
  {
    SharedPreferences.Editor localEditor = getSharedPreferences(paramContext, paramString).edit();
    Iterator localIterator = paramHashMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        localEditor.commit();
        return;
      }
      localEditor.remove((String)localIterator.next());
    }
  }
  
  public void writeBoolean(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = getSharedPreferences(paramContext, paramString1).edit();
    localEditor.putBoolean(paramString2, paramBoolean);
    localEditor.commit();
  }
  
  public void writeFloat(Context paramContext, String paramString1, String paramString2, float paramFloat)
  {
    SharedPreferences.Editor localEditor = getSharedPreferences(paramContext, paramString1).edit();
    localEditor.putFloat(paramString2, paramFloat);
    localEditor.commit();
  }
  
  public void writeInt(Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    SharedPreferences.Editor localEditor = getSharedPreferences(paramContext, paramString1).edit();
    localEditor.putInt(paramString2, paramInt);
    localEditor.commit();
  }
  
  public void writeJSONArray(Context paramContext, String paramString1, String paramString2, JSONArray paramJSONArray)
  {
    if (paramJSONArray != null) {
      writeString(paramContext, paramString1, paramString2, paramJSONArray.toString());
    }
  }
  
  public void writeJSONObject(Context paramContext, String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      writeString(paramContext, paramString1, paramString2, paramJSONObject.toString());
    }
  }
  
  public void writeLong(Context paramContext, String paramString1, String paramString2, long paramLong)
  {
    SharedPreferences.Editor localEditor = getSharedPreferences(paramContext, paramString1).edit();
    localEditor.putLong(paramString2, paramLong);
    localEditor.commit();
  }
  
  public void writeMap(Context paramContext, String paramString, HashMap<String, ?> paramHashMap)
  {
    SharedPreferences.Editor localEditor = getSharedPreferences(paramContext, paramString).edit();
    Iterator localIterator = paramHashMap.keySet().iterator();
    for (;;)
    {
      if (!localIterator.hasNext())
      {
        localEditor.commit();
        return;
      }
      String str = (String)localIterator.next();
      Object localObject = paramHashMap.get(str);
      if ((localObject instanceof Integer)) {
        localEditor.putInt(str, ((Integer)localObject).intValue());
      } else if ((localObject instanceof String)) {
        localEditor.putString(str, (String)localObject);
      } else if ((localObject instanceof Boolean)) {
        localEditor.putBoolean(str, ((Boolean)localObject).booleanValue());
      } else if ((localObject instanceof Long)) {
        localEditor.putLong(str, ((Long)localObject).longValue());
      } else if ((localObject instanceof Float)) {
        localEditor.putFloat(str, ((Float)localObject).floatValue());
      }
    }
  }
  
  public void writeString(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    SharedPreferences.Editor localEditor = getSharedPreferences(paramContext, paramString1).edit();
    localEditor.putString(paramString2, paramString3);
    localEditor.commit();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.util.SPUtilBase
 * JD-Core Version:    0.7.0.1
 */