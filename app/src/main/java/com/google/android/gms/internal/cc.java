package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

@ey
public final class cc
{
  public static final cd pQ = new cd()
  {
    public void a(gu paramAnonymousgu, Map<String, String> paramAnonymousMap) {}
  };
  public static final cd pR = new cd()
  {
    public void a(gu paramAnonymousgu, Map<String, String> paramAnonymousMap)
    {
      String str1 = (String)paramAnonymousMap.get("urls");
      if (TextUtils.isEmpty(str1))
      {
        gr.W("URLs missing in canOpenURLs GMSG.");
        return;
      }
      String[] arrayOfString1 = str1.split(",");
      HashMap localHashMap = new HashMap();
      PackageManager localPackageManager = paramAnonymousgu.getContext().getPackageManager();
      int i = arrayOfString1.length;
      int j = 0;
      if (j < i)
      {
        String str2 = arrayOfString1[j];
        String[] arrayOfString2 = str2.split(";", 2);
        String str3 = arrayOfString2[0].trim();
        String str4;
        if (arrayOfString2.length > 1)
        {
          str4 = arrayOfString2[1].trim();
          label108:
          if (localPackageManager.resolveActivity(new Intent(str4, Uri.parse(str3)), 65536) == null) {
            break label161;
          }
        }
        label161:
        for (boolean bool = true;; bool = false)
        {
          localHashMap.put(str2, Boolean.valueOf(bool));
          j++;
          break;
          str4 = "android.intent.action.VIEW";
          break label108;
        }
      }
      paramAnonymousgu.a("openableURLs", localHashMap);
    }
  };
  public static final cd pS = new cd()
  {
    /* Error */
    public void a(gu paramAnonymousgu, Map<String, String> paramAnonymousMap)
    {
      // Byte code:
      //   0: aload_1
      //   1: invokevirtual 22	com/google/android/gms/internal/gu:getContext	()Landroid/content/Context;
      //   4: invokevirtual 28	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
      //   7: astore_3
      //   8: aload_2
      //   9: ldc 30
      //   11: invokeinterface 36 2 0
      //   16: checkcast 38	java/lang/String
      //   19: astore 4
      //   21: new 40	org/json/JSONObject
      //   24: dup
      //   25: aload 4
      //   27: invokespecial 43	org/json/JSONObject:<init>	(Ljava/lang/String;)V
      //   30: astore 5
      //   32: aload 5
      //   34: ldc 45
      //   36: invokevirtual 49	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
      //   39: astore 7
      //   41: new 40	org/json/JSONObject
      //   44: dup
      //   45: invokespecial 50	org/json/JSONObject:<init>	()V
      //   48: astore 8
      //   50: iconst_0
      //   51: istore 9
      //   53: iload 9
      //   55: aload 7
      //   57: invokevirtual 56	org/json/JSONArray:length	()I
      //   60: if_icmpge +296 -> 356
      //   63: aload 7
      //   65: iload 9
      //   67: invokevirtual 60	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
      //   70: astore 11
      //   72: aload 11
      //   74: ldc 62
      //   76: invokevirtual 66	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
      //   79: astore 12
      //   81: aload 11
      //   83: ldc 68
      //   85: invokevirtual 66	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
      //   88: astore 13
      //   90: aload 11
      //   92: ldc 70
      //   94: invokevirtual 66	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
      //   97: astore 14
      //   99: aload 11
      //   101: ldc 72
      //   103: invokevirtual 66	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
      //   106: astore 15
      //   108: aload 11
      //   110: ldc 74
      //   112: invokevirtual 66	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
      //   115: astore 16
      //   117: aload 11
      //   119: ldc 76
      //   121: invokevirtual 66	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
      //   124: astore 17
      //   126: aload 11
      //   128: ldc 78
      //   130: invokevirtual 66	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
      //   133: pop
      //   134: aload 11
      //   136: ldc 80
      //   138: invokevirtual 66	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
      //   141: pop
      //   142: new 82	android/content/Intent
      //   145: dup
      //   146: invokespecial 83	android/content/Intent:<init>	()V
      //   149: astore 20
      //   151: aload 13
      //   153: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   156: ifne +14 -> 170
      //   159: aload 20
      //   161: aload 13
      //   163: invokestatic 95	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
      //   166: invokevirtual 99	android/content/Intent:setData	(Landroid/net/Uri;)Landroid/content/Intent;
      //   169: pop
      //   170: aload 14
      //   172: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   175: ifne +11 -> 186
      //   178: aload 20
      //   180: aload 14
      //   182: invokevirtual 103	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
      //   185: pop
      //   186: aload 15
      //   188: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   191: ifne +11 -> 202
      //   194: aload 20
      //   196: aload 15
      //   198: invokevirtual 106	android/content/Intent:setType	(Ljava/lang/String;)Landroid/content/Intent;
      //   201: pop
      //   202: aload 16
      //   204: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   207: ifne +11 -> 218
      //   210: aload 20
      //   212: aload 16
      //   214: invokevirtual 109	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
      //   217: pop
      //   218: aload 17
      //   220: invokestatic 89	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
      //   223: ifne +41 -> 264
      //   226: aload 17
      //   228: ldc 111
      //   230: iconst_2
      //   231: invokevirtual 115	java/lang/String:split	(Ljava/lang/String;I)[Ljava/lang/String;
      //   234: astore 24
      //   236: aload 24
      //   238: arraylength
      //   239: iconst_2
      //   240: if_icmpne +24 -> 264
      //   243: aload 20
      //   245: new 117	android/content/ComponentName
      //   248: dup
      //   249: aload 24
      //   251: iconst_0
      //   252: aaload
      //   253: aload 24
      //   255: iconst_1
      //   256: aaload
      //   257: invokespecial 120	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
      //   260: invokevirtual 124	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
      //   263: pop
      //   264: aload_3
      //   265: aload 20
      //   267: ldc 125
      //   269: invokevirtual 131	android/content/pm/PackageManager:resolveActivity	(Landroid/content/Intent;I)Landroid/content/pm/ResolveInfo;
      //   272: ifnull +66 -> 338
      //   275: iconst_1
      //   276: istore 21
      //   278: aload 8
      //   280: aload 12
      //   282: iload 21
      //   284: invokevirtual 135	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
      //   287: pop
      //   288: iinc 9 1
      //   291: goto -238 -> 53
      //   294: astore 30
      //   296: aload_1
      //   297: ldc 137
      //   299: new 40	org/json/JSONObject
      //   302: dup
      //   303: invokespecial 50	org/json/JSONObject:<init>	()V
      //   306: invokevirtual 141	com/google/android/gms/internal/gu:b	(Ljava/lang/String;Lorg/json/JSONObject;)V
      //   309: return
      //   310: astore 6
      //   312: aload_1
      //   313: ldc 137
      //   315: new 40	org/json/JSONObject
      //   318: dup
      //   319: invokespecial 50	org/json/JSONObject:<init>	()V
      //   322: invokevirtual 141	com/google/android/gms/internal/gu:b	(Ljava/lang/String;Lorg/json/JSONObject;)V
      //   325: return
      //   326: astore 10
      //   328: ldc 143
      //   330: aload 10
      //   332: invokestatic 148	com/google/android/gms/internal/gr:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   335: goto -47 -> 288
      //   338: iconst_0
      //   339: istore 21
      //   341: goto -63 -> 278
      //   344: astore 22
      //   346: ldc 150
      //   348: aload 22
      //   350: invokestatic 148	com/google/android/gms/internal/gr:b	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   353: goto -65 -> 288
      //   356: aload_1
      //   357: ldc 137
      //   359: aload 8
      //   361: invokevirtual 141	com/google/android/gms/internal/gu:b	(Ljava/lang/String;Lorg/json/JSONObject;)V
      //   364: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	365	0	this	3
      //   0	365	1	paramAnonymousgu	gu
      //   0	365	2	paramAnonymousMap	Map<String, String>
      //   7	258	3	localPackageManager	PackageManager
      //   19	7	4	str1	String
      //   30	3	5	localJSONObject1	org.json.JSONObject
      //   310	1	6	localJSONException1	org.json.JSONException
      //   39	25	7	localJSONArray	org.json.JSONArray
      //   48	312	8	localJSONObject2	org.json.JSONObject
      //   51	238	9	i	int
      //   326	5	10	localJSONException2	org.json.JSONException
      //   70	65	11	localJSONObject3	org.json.JSONObject
      //   79	202	12	str2	String
      //   88	74	13	str3	String
      //   97	84	14	str4	String
      //   106	91	15	str5	String
      //   115	98	16	str6	String
      //   124	103	17	str7	String
      //   149	117	20	localIntent	Intent
      //   276	64	21	bool	boolean
      //   344	5	22	localJSONException3	org.json.JSONException
      //   234	20	24	arrayOfString	String[]
      //   294	1	30	localJSONException4	org.json.JSONException
      // Exception table:
      //   from	to	target	type
      //   21	32	294	org/json/JSONException
      //   32	41	310	org/json/JSONException
      //   63	72	326	org/json/JSONException
      //   278	288	344	org/json/JSONException
    }
  };
  public static final cd pT = new cd()
  {
    public void a(gu paramAnonymousgu, Map<String, String> paramAnonymousMap)
    {
      str1 = (String)paramAnonymousMap.get("u");
      if (str1 == null)
      {
        gr.W("URL missing from click GMSG.");
        return;
      }
      localUri1 = Uri.parse(str1);
      try
      {
        k localk = paramAnonymousgu.dF();
        if ((localk == null) || (!localk.b(localUri1))) {
          break label121;
        }
        Uri localUri3 = localk.a(localUri1, paramAnonymousgu.getContext());
        localUri2 = localUri3;
      }
      catch (l locall)
      {
        for (;;)
        {
          String str2;
          gr.W("Unable to append parameter to URL: " + str1);
          Uri localUri2 = localUri1;
        }
      }
      str2 = localUri2.toString();
      new gp(paramAnonymousgu.getContext(), paramAnonymousgu.dG().wS, str2).start();
    }
  };
  public static final cd pU = new cd()
  {
    public void a(gu paramAnonymousgu, Map<String, String> paramAnonymousMap)
    {
      dp localdp = paramAnonymousgu.dC();
      if (localdp == null)
      {
        gr.W("A GMSG tried to close something that wasn't an overlay.");
        return;
      }
      localdp.close();
    }
  };
  public static final cd pV = new cd()
  {
    public void a(gu paramAnonymousgu, Map<String, String> paramAnonymousMap)
    {
      paramAnonymousgu.q("1".equals(paramAnonymousMap.get("custom_close")));
    }
  };
  public static final cd pW = new cd()
  {
    public void a(gu paramAnonymousgu, Map<String, String> paramAnonymousMap)
    {
      String str = (String)paramAnonymousMap.get("u");
      if (str == null)
      {
        gr.W("URL missing from httpTrack GMSG.");
        return;
      }
      new gp(paramAnonymousgu.getContext(), paramAnonymousgu.dG().wS, str).start();
    }
  };
  public static final cd pX = new cd()
  {
    public void a(gu paramAnonymousgu, Map<String, String> paramAnonymousMap)
    {
      gr.U("Received log message: " + (String)paramAnonymousMap.get("string"));
    }
  };
  public static final cd pY = new cd()
  {
    public void a(gu paramAnonymousgu, Map<String, String> paramAnonymousMap)
    {
      String str1 = (String)paramAnonymousMap.get("tx");
      String str2 = (String)paramAnonymousMap.get("ty");
      String str3 = (String)paramAnonymousMap.get("td");
      try
      {
        int i = Integer.parseInt(str1);
        int j = Integer.parseInt(str2);
        int k = Integer.parseInt(str3);
        k localk = paramAnonymousgu.dF();
        if (localk != null) {
          localk.C().a(i, j, k);
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        gr.W("Could not parse touch parameters from gmsg.");
      }
    }
  };
  public static final cd pZ = new cj();
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.cc
 * JD-Core Version:    0.7.0.1
 */