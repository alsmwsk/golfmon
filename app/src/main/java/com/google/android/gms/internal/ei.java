package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Bundle;
import org.json.JSONException;
import org.json.JSONObject;

@ey
public final class ei
{
  public static String D(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      String str = new JSONObject(paramString).getString("developerPayload");
      return str;
    }
    catch (JSONException localJSONException)
    {
      gr.W("Fail to parse purchase data");
    }
    return null;
  }
  
  public static String E(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      String str = new JSONObject(paramString).getString("purchaseToken");
      return str;
    }
    catch (JSONException localJSONException)
    {
      gr.W("Fail to parse purchase data");
    }
    return null;
  }
  
  public static int b(Bundle paramBundle)
  {
    Object localObject = paramBundle.get("RESPONSE_CODE");
    if (localObject == null)
    {
      gr.W("Bundle with null response code, assuming OK (known issue)");
      return 0;
    }
    if ((localObject instanceof Integer)) {
      return ((Integer)localObject).intValue();
    }
    if ((localObject instanceof Long)) {
      return (int)((Long)localObject).longValue();
    }
    gr.W("Unexpected type for intent response code. " + localObject.getClass().getName());
    return 5;
  }
  
  public static int d(Intent paramIntent)
  {
    Object localObject = paramIntent.getExtras().get("RESPONSE_CODE");
    if (localObject == null)
    {
      gr.W("Intent with no response code, assuming OK (known issue)");
      return 0;
    }
    if ((localObject instanceof Integer)) {
      return ((Integer)localObject).intValue();
    }
    if ((localObject instanceof Long)) {
      return (int)((Long)localObject).longValue();
    }
    gr.W("Unexpected type for intent response code. " + localObject.getClass().getName());
    return 5;
  }
  
  public static String e(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return paramIntent.getStringExtra("INAPP_PURCHASE_DATA");
  }
  
  public static String f(Intent paramIntent)
  {
    if (paramIntent == null) {
      return null;
    }
    return paramIntent.getStringExtra("INAPP_DATA_SIGNATURE");
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ei
 * JD-Core Version:    0.7.0.1
 */