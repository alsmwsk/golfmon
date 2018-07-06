package com.google.android.gms.analytics;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.google.android.gms.internal.ha;
import com.google.android.gms.internal.ld;
import com.google.android.gms.internal.lf;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.impl.client.DefaultHttpClient;

class ag
  implements d
{
  private static final String BS = String.format("CREATE TABLE IF NOT EXISTS %s ( '%s' INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, '%s' INTEGER NOT NULL, '%s' TEXT NOT NULL, '%s' TEXT NOT NULL, '%s' INTEGER);", new Object[] { "hits2", "hit_id", "hit_time", "hit_url", "hit_string", "hit_app_id" });
  private final a BT;
  private volatile r BU;
  private final String BV;
  private af BW;
  private long BX;
  private final int BY;
  private final Context mContext;
  private ld wb;
  private o ys;
  private volatile boolean yt = true;
  private final e zc;
  
  ag(e parame, Context paramContext, o paramo)
  {
    this(parame, paramContext, "google_analytics_v4.db", 2000, paramo);
  }
  
  ag(e parame, Context paramContext, String paramString, int paramInt, o paramo)
  {
    this.mContext = paramContext.getApplicationContext();
    this.ys = paramo;
    this.BV = paramString;
    this.zc = parame;
    this.wb = lf.jdMethod_if();
    this.BT = new a(this.mContext, this.BV);
    this.BU = new h(new DefaultHttpClient(), this.mContext, this.ys);
    this.BX = 0L;
    this.BY = paramInt;
  }
  
  static String A(Map<String, String> paramMap)
  {
    ArrayList localArrayList = new ArrayList(paramMap.size());
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localArrayList.add(ac.encode((String)localEntry.getKey()) + "=" + ac.encode((String)localEntry.getValue()));
    }
    return TextUtils.join("&", localArrayList);
  }
  
  private void a(Map<String, String> paramMap, long paramLong, String paramString)
  {
    SQLiteDatabase localSQLiteDatabase = al("Error opening database for putHit");
    if (localSQLiteDatabase == null) {
      return;
    }
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("hit_string", A(paramMap));
    localContentValues.put("hit_time", Long.valueOf(paramLong));
    if (paramMap.containsKey("AppUID")) {}
    for (;;)
    {
      try
      {
        long l2 = Long.parseLong((String)paramMap.get("AppUID"));
        l1 = l2;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        l1 = 0L;
        continue;
        localContentValues.put("hit_url", paramString);
        try
        {
          localSQLiteDatabase.insert("hits2", null, localContentValues);
          this.zc.B(false);
          return;
        }
        catch (SQLiteException localSQLiteException)
        {
          ae.W("Error storing hit");
          return;
        }
      }
      localContentValues.put("hit_app_id", Long.valueOf(l1));
      if (paramString == null) {
        paramString = "http://www.google-analytics.com/collect";
      }
      if (paramString.length() == 0)
      {
        ae.W("Empty path: not sending hit");
        return;
      }
      long l1 = 0L;
    }
  }
  
  private void a(Map<String, String> paramMap, Collection<ha> paramCollection)
  {
    String str = "&_v".substring(1);
    if (paramCollection != null)
    {
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext())
      {
        ha localha = (ha)localIterator.next();
        if ("appendVersion".equals(localha.getId())) {
          paramMap.put(str, localha.getValue());
        }
      }
    }
  }
  
  private SQLiteDatabase al(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = this.BT.getWritableDatabase();
      return localSQLiteDatabase;
    }
    catch (SQLiteException localSQLiteException)
    {
      ae.W(paramString);
    }
    return null;
  }
  
  private void fh()
  {
    int i = 1 + (fj() - this.BY);
    if (i > 0)
    {
      List localList = G(i);
      ae.V("Store full, deleting " + localList.size() + " hits to make room.");
      b((String[])localList.toArray(new String[0]));
    }
  }
  
  /* Error */
  List<String> G(int paramInt)
  {
    // Byte code:
    //   0: new 111	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 315	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: iload_1
    //   9: ifgt +11 -> 20
    //   12: ldc_w 317
    //   15: invokestatic 238	com/google/android/gms/analytics/ae:W	(Ljava/lang/String;)V
    //   18: aload_2
    //   19: areturn
    //   20: aload_0
    //   21: ldc_w 319
    //   24: invokespecial 194	com/google/android/gms/analytics/ag:al	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   27: astore_3
    //   28: aload_3
    //   29: ifnonnull +5 -> 34
    //   32: aload_2
    //   33: areturn
    //   34: aload_3
    //   35: ldc 35
    //   37: iconst_1
    //   38: anewarray 47	java/lang/String
    //   41: dup
    //   42: iconst_0
    //   43: ldc 37
    //   45: aastore
    //   46: aconst_null
    //   47: aconst_null
    //   48: aconst_null
    //   49: aconst_null
    //   50: ldc_w 321
    //   53: iconst_1
    //   54: anewarray 4	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: ldc 37
    //   61: aastore
    //   62: invokestatic 51	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   65: iload_1
    //   66: invokestatic 325	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   69: invokevirtual 329	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   72: astore 7
    //   74: aload 7
    //   76: astore 5
    //   78: aload 5
    //   80: invokeinterface 334 1 0
    //   85: ifeq +35 -> 120
    //   88: aload_2
    //   89: aload 5
    //   91: iconst_0
    //   92: invokeinterface 338 2 0
    //   97: invokestatic 341	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   100: invokeinterface 173 2 0
    //   105: pop
    //   106: aload 5
    //   108: invokeinterface 344 1 0
    //   113: istore 9
    //   115: iload 9
    //   117: ifne -29 -> 88
    //   120: aload 5
    //   122: ifnull +10 -> 132
    //   125: aload 5
    //   127: invokeinterface 347 1 0
    //   132: aload_2
    //   133: areturn
    //   134: astore 6
    //   136: aconst_null
    //   137: astore 5
    //   139: new 144	java/lang/StringBuilder
    //   142: dup
    //   143: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   146: ldc_w 349
    //   149: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: aload 6
    //   154: invokevirtual 352	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   157: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 238	com/google/android/gms/analytics/ae:W	(Ljava/lang/String;)V
    //   166: aload 5
    //   168: ifnull -36 -> 132
    //   171: aload 5
    //   173: invokeinterface 347 1 0
    //   178: goto -46 -> 132
    //   181: astore 4
    //   183: aconst_null
    //   184: astore 5
    //   186: aload 5
    //   188: ifnull +10 -> 198
    //   191: aload 5
    //   193: invokeinterface 347 1 0
    //   198: aload 4
    //   200: athrow
    //   201: astore 4
    //   203: goto -17 -> 186
    //   206: astore 6
    //   208: goto -69 -> 139
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	211	0	this	ag
    //   0	211	1	paramInt	int
    //   7	126	2	localArrayList	ArrayList
    //   27	8	3	localSQLiteDatabase	SQLiteDatabase
    //   181	18	4	localObject1	Object
    //   201	1	4	localObject2	Object
    //   76	116	5	localCursor1	Cursor
    //   134	19	6	localSQLiteException1	SQLiteException
    //   206	1	6	localSQLiteException2	SQLiteException
    //   72	3	7	localCursor2	Cursor
    //   113	3	9	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   34	74	134	android/database/sqlite/SQLiteException
    //   34	74	181	finally
    //   78	88	201	finally
    //   88	115	201	finally
    //   139	166	201	finally
    //   78	88	206	android/database/sqlite/SQLiteException
    //   88	115	206	android/database/sqlite/SQLiteException
  }
  
  /* Error */
  public List<ab> H(int paramInt)
  {
    // Byte code:
    //   0: new 111	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 315	java/util/ArrayList:<init>	()V
    //   7: astore_2
    //   8: aload_0
    //   9: ldc_w 355
    //   12: invokespecial 194	com/google/android/gms/analytics/ag:al	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteDatabase;
    //   15: astore_3
    //   16: aload_3
    //   17: ifnonnull +9 -> 26
    //   20: aload_2
    //   21: astore 9
    //   23: aload 9
    //   25: areturn
    //   26: aconst_null
    //   27: astore 4
    //   29: aload_3
    //   30: ldc 35
    //   32: iconst_2
    //   33: anewarray 47	java/lang/String
    //   36: dup
    //   37: iconst_0
    //   38: ldc 37
    //   40: aastore
    //   41: dup
    //   42: iconst_1
    //   43: ldc 39
    //   45: aastore
    //   46: aconst_null
    //   47: aconst_null
    //   48: aconst_null
    //   49: aconst_null
    //   50: ldc_w 321
    //   53: iconst_1
    //   54: anewarray 4	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: ldc 37
    //   61: aastore
    //   62: invokestatic 51	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   65: iload_1
    //   66: invokestatic 325	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   69: invokevirtual 329	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   72: astore 10
    //   74: aload 10
    //   76: astore 11
    //   78: new 111	java/util/ArrayList
    //   81: dup
    //   82: invokespecial 315	java/util/ArrayList:<init>	()V
    //   85: astore 12
    //   87: aload 11
    //   89: invokeinterface 334 1 0
    //   94: ifeq +52 -> 146
    //   97: aload 12
    //   99: new 357	com/google/android/gms/analytics/ab
    //   102: dup
    //   103: aconst_null
    //   104: aload 11
    //   106: iconst_0
    //   107: invokeinterface 338 2 0
    //   112: aload 11
    //   114: iconst_1
    //   115: invokeinterface 338 2 0
    //   120: ldc_w 359
    //   123: invokespecial 362	com/google/android/gms/analytics/ab:<init>	(Ljava/lang/String;JJLjava/lang/String;)V
    //   126: invokeinterface 173 2 0
    //   131: pop
    //   132: aload 11
    //   134: invokeinterface 344 1 0
    //   139: istore 15
    //   141: iload 15
    //   143: ifne -46 -> 97
    //   146: aload 11
    //   148: ifnull +10 -> 158
    //   151: aload 11
    //   153: invokeinterface 347 1 0
    //   158: aload_3
    //   159: ldc 35
    //   161: iconst_3
    //   162: anewarray 47	java/lang/String
    //   165: dup
    //   166: iconst_0
    //   167: ldc 37
    //   169: aastore
    //   170: dup
    //   171: iconst_1
    //   172: ldc 43
    //   174: aastore
    //   175: dup
    //   176: iconst_2
    //   177: ldc 41
    //   179: aastore
    //   180: aconst_null
    //   181: aconst_null
    //   182: aconst_null
    //   183: aconst_null
    //   184: ldc_w 321
    //   187: iconst_1
    //   188: anewarray 4	java/lang/Object
    //   191: dup
    //   192: iconst_0
    //   193: ldc 37
    //   195: aastore
    //   196: invokestatic 51	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   199: iload_1
    //   200: invokestatic 325	java/lang/Integer:toString	(I)Ljava/lang/String;
    //   203: invokevirtual 329	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   206: astore 24
    //   208: aload 24
    //   210: invokeinterface 334 1 0
    //   215: ifeq +86 -> 301
    //   218: iconst_0
    //   219: istore 25
    //   221: aload 24
    //   223: checkcast 364	android/database/sqlite/SQLiteCursor
    //   226: invokevirtual 368	android/database/sqlite/SQLiteCursor:getWindow	()Landroid/database/CursorWindow;
    //   229: invokevirtual 373	android/database/CursorWindow:getNumRows	()I
    //   232: ifle +155 -> 387
    //   235: aload 12
    //   237: iload 25
    //   239: invokeinterface 376 2 0
    //   244: checkcast 357	com/google/android/gms/analytics/ab
    //   247: aload 24
    //   249: iconst_1
    //   250: invokeinterface 379 2 0
    //   255: invokevirtual 382	com/google/android/gms/analytics/ab:aj	(Ljava/lang/String;)V
    //   258: aload 12
    //   260: iload 25
    //   262: invokeinterface 376 2 0
    //   267: checkcast 357	com/google/android/gms/analytics/ab
    //   270: aload 24
    //   272: iconst_2
    //   273: invokeinterface 379 2 0
    //   278: invokevirtual 385	com/google/android/gms/analytics/ab:ak	(Ljava/lang/String;)V
    //   281: iload 25
    //   283: iconst_1
    //   284: iadd
    //   285: istore 27
    //   287: aload 24
    //   289: invokeinterface 344 1 0
    //   294: istore 28
    //   296: iload 28
    //   298: ifne +340 -> 638
    //   301: aload 24
    //   303: ifnull +10 -> 313
    //   306: aload 24
    //   308: invokeinterface 347 1 0
    //   313: aload 12
    //   315: areturn
    //   316: astore 6
    //   318: aload 6
    //   320: astore 7
    //   322: aconst_null
    //   323: astore 8
    //   325: aload_2
    //   326: astore 9
    //   328: new 144	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   335: ldc_w 349
    //   338: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload 7
    //   343: invokevirtual 352	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   346: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   349: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   352: invokestatic 238	com/google/android/gms/analytics/ae:W	(Ljava/lang/String;)V
    //   355: aload 8
    //   357: ifnull -334 -> 23
    //   360: aload 8
    //   362: invokeinterface 347 1 0
    //   367: aload 9
    //   369: areturn
    //   370: astore 5
    //   372: aload 4
    //   374: ifnull +10 -> 384
    //   377: aload 4
    //   379: invokeinterface 347 1 0
    //   384: aload 5
    //   386: athrow
    //   387: iconst_1
    //   388: anewarray 4	java/lang/Object
    //   391: astore 26
    //   393: aload 26
    //   395: iconst_0
    //   396: aload 12
    //   398: iload 25
    //   400: invokeinterface 376 2 0
    //   405: checkcast 357	com/google/android/gms/analytics/ab
    //   408: invokevirtual 389	com/google/android/gms/analytics/ab:fb	()J
    //   411: invokestatic 209	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   414: aastore
    //   415: ldc_w 391
    //   418: aload 26
    //   420: invokestatic 51	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   423: invokestatic 238	com/google/android/gms/analytics/ae:W	(Ljava/lang/String;)V
    //   426: goto -145 -> 281
    //   429: astore 16
    //   431: aload 24
    //   433: astore 11
    //   435: new 144	java/lang/StringBuilder
    //   438: dup
    //   439: invokespecial 145	java/lang/StringBuilder:<init>	()V
    //   442: ldc_w 393
    //   445: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: aload 16
    //   450: invokevirtual 352	android/database/sqlite/SQLiteException:getMessage	()Ljava/lang/String;
    //   453: invokevirtual 158	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 238	com/google/android/gms/analytics/ae:W	(Ljava/lang/String;)V
    //   462: new 111	java/util/ArrayList
    //   465: dup
    //   466: invokespecial 315	java/util/ArrayList:<init>	()V
    //   469: astore 18
    //   471: iconst_0
    //   472: istore 19
    //   474: aload 12
    //   476: invokeinterface 394 1 0
    //   481: astore 20
    //   483: aload 20
    //   485: invokeinterface 136 1 0
    //   490: ifeq +35 -> 525
    //   493: aload 20
    //   495: invokeinterface 140 1 0
    //   500: checkcast 357	com/google/android/gms/analytics/ab
    //   503: astore 21
    //   505: aload 21
    //   507: invokevirtual 397	com/google/android/gms/analytics/ab:fa	()Ljava/lang/String;
    //   510: invokestatic 401	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   513: istore 22
    //   515: iload 22
    //   517: ifeq +26 -> 543
    //   520: iload 19
    //   522: ifeq +18 -> 540
    //   525: aload 11
    //   527: ifnull +10 -> 537
    //   530: aload 11
    //   532: invokeinterface 347 1 0
    //   537: aload 18
    //   539: areturn
    //   540: iconst_1
    //   541: istore 19
    //   543: aload 18
    //   545: aload 21
    //   547: invokeinterface 173 2 0
    //   552: pop
    //   553: goto -70 -> 483
    //   556: astore 17
    //   558: aload 11
    //   560: ifnull +10 -> 570
    //   563: aload 11
    //   565: invokeinterface 347 1 0
    //   570: aload 17
    //   572: athrow
    //   573: astore 17
    //   575: aload 24
    //   577: astore 11
    //   579: goto -21 -> 558
    //   582: astore 16
    //   584: goto -149 -> 435
    //   587: astore 5
    //   589: aload 11
    //   591: astore 4
    //   593: goto -221 -> 372
    //   596: astore 5
    //   598: aload 8
    //   600: astore 4
    //   602: goto -230 -> 372
    //   605: astore 29
    //   607: aload 29
    //   609: astore 7
    //   611: aload 11
    //   613: astore 8
    //   615: aload_2
    //   616: astore 9
    //   618: goto -290 -> 328
    //   621: astore 13
    //   623: aload 13
    //   625: astore 7
    //   627: aload 11
    //   629: astore 8
    //   631: aload 12
    //   633: astore 9
    //   635: goto -307 -> 328
    //   638: iload 27
    //   640: istore 25
    //   642: goto -421 -> 221
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	645	0	this	ag
    //   0	645	1	paramInt	int
    //   7	609	2	localArrayList1	ArrayList
    //   15	144	3	localSQLiteDatabase	SQLiteDatabase
    //   27	574	4	localObject1	Object
    //   370	15	5	localObject2	Object
    //   587	1	5	localObject3	Object
    //   596	1	5	localObject4	Object
    //   316	3	6	localSQLiteException1	SQLiteException
    //   320	306	7	localObject5	Object
    //   323	307	8	localObject6	Object
    //   21	613	9	localObject7	Object
    //   72	3	10	localCursor1	Cursor
    //   76	552	11	localObject8	Object
    //   85	547	12	localArrayList2	ArrayList
    //   621	3	13	localSQLiteException2	SQLiteException
    //   139	3	15	bool1	boolean
    //   429	20	16	localSQLiteException3	SQLiteException
    //   582	1	16	localSQLiteException4	SQLiteException
    //   556	15	17	localObject9	Object
    //   573	1	17	localObject10	Object
    //   469	75	18	localArrayList3	ArrayList
    //   472	70	19	i	int
    //   481	13	20	localIterator	Iterator
    //   503	43	21	localab	ab
    //   513	3	22	bool2	boolean
    //   206	370	24	localCursor2	Cursor
    //   219	422	25	j	int
    //   391	28	26	arrayOfObject	Object[]
    //   285	354	27	k	int
    //   294	3	28	bool3	boolean
    //   605	3	29	localSQLiteException5	SQLiteException
    // Exception table:
    //   from	to	target	type
    //   29	74	316	android/database/sqlite/SQLiteException
    //   29	74	370	finally
    //   208	218	429	android/database/sqlite/SQLiteException
    //   221	281	429	android/database/sqlite/SQLiteException
    //   287	296	429	android/database/sqlite/SQLiteException
    //   387	426	429	android/database/sqlite/SQLiteException
    //   158	208	556	finally
    //   435	471	556	finally
    //   474	483	556	finally
    //   483	515	556	finally
    //   543	553	556	finally
    //   208	218	573	finally
    //   221	281	573	finally
    //   287	296	573	finally
    //   387	426	573	finally
    //   158	208	582	android/database/sqlite/SQLiteException
    //   78	87	587	finally
    //   87	97	587	finally
    //   97	141	587	finally
    //   328	355	596	finally
    //   78	87	605	android/database/sqlite/SQLiteException
    //   87	97	621	android/database/sqlite/SQLiteException
    //   97	141	621	android/database/sqlite/SQLiteException
  }
  
  public void a(Map<String, String> paramMap, long paramLong, String paramString, Collection<ha> paramCollection)
  {
    fi();
    fh();
    a(paramMap, paramCollection);
    a(paramMap, paramLong, paramString);
  }
  
  @Deprecated
  void b(Collection<ab> paramCollection)
  {
    if ((paramCollection == null) || (paramCollection.isEmpty()))
    {
      ae.W("Empty/Null collection passed to deleteHits.");
      return;
    }
    String[] arrayOfString = new String[paramCollection.size()];
    Iterator localIterator = paramCollection.iterator();
    int j;
    for (int i = 0; localIterator.hasNext(); i = j)
    {
      ab localab = (ab)localIterator.next();
      j = i + 1;
      arrayOfString[i] = String.valueOf(localab.fb());
    }
    b(arrayOfString);
  }
  
  void b(String[] paramArrayOfString)
  {
    boolean bool = true;
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {
      ae.W("Empty hitIds passed to deleteHits.");
    }
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return;
      localSQLiteDatabase = al("Error opening database for deleteHits.");
    } while (localSQLiteDatabase == null);
    Object[] arrayOfObject = new Object[bool];
    arrayOfObject[0] = TextUtils.join(",", Collections.nCopies(paramArrayOfString.length, "?"));
    String str = String.format("HIT_ID in (%s)", arrayOfObject);
    for (;;)
    {
      try
      {
        localSQLiteDatabase.delete("hits2", str, paramArrayOfString);
        e locale = this.zc;
        if (fj() == 0)
        {
          locale.B(bool);
          return;
        }
      }
      catch (SQLiteException localSQLiteException)
      {
        ae.W("Error deleting hits " + TextUtils.join(",", paramArrayOfString));
        return;
      }
      bool = false;
    }
  }
  
  public r dV()
  {
    return this.BU;
  }
  
  public void dispatch()
  {
    boolean bool = true;
    ae.V("Dispatch running...");
    if (!this.BU.ea()) {
      return;
    }
    List localList = H(20);
    if (localList.isEmpty())
    {
      ae.V("...nothing to dispatch");
      this.zc.B(bool);
      return;
    }
    if (this.BW == null) {
      this.BW = new af("_t=dispatch&_v=ma4.0.4", false);
    }
    if (fj() <= localList.size()) {}
    for (;;)
    {
      int i = this.BU.a(localList, this.BW, bool);
      ae.V("sent " + i + " of " + localList.size() + " hits");
      b(localList.subList(0, Math.min(i, localList.size())));
      if ((i != localList.size()) || (fj() <= 0)) {
        break;
      }
      GoogleAnalytics.getInstance(this.mContext).dispatchLocalHits();
      return;
      bool = false;
    }
    this.BW = null;
  }
  
  int fi()
  {
    boolean bool = true;
    long l1 = this.wb.currentTimeMillis();
    if (l1 <= 86400000L + this.BX) {}
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      return 0;
      this.BX = l1;
      localSQLiteDatabase = al("Error opening database for deleteStaleHits.");
    } while (localSQLiteDatabase == null);
    long l2 = this.wb.currentTimeMillis() - 2592000000L;
    String[] arrayOfString = new String[bool];
    arrayOfString[0] = Long.toString(l2);
    int i = localSQLiteDatabase.delete("hits2", "HIT_TIME < ?", arrayOfString);
    e locale = this.zc;
    if (fj() == 0) {}
    for (;;)
    {
      locale.B(bool);
      return i;
      bool = false;
    }
  }
  
  int fj()
  {
    Cursor localCursor = null;
    SQLiteDatabase localSQLiteDatabase = al("Error opening database for getNumStoredHits.");
    int i = 0;
    if (localSQLiteDatabase == null) {}
    for (;;)
    {
      return i;
      try
      {
        localCursor = localSQLiteDatabase.rawQuery("SELECT COUNT(*) from hits2", null);
        boolean bool = localCursor.moveToFirst();
        i = 0;
        if (bool)
        {
          long l = localCursor.getLong(0);
          i = (int)l;
        }
        return i;
      }
      catch (SQLiteException localSQLiteException)
      {
        ae.W("Error getting numStoredHits");
        i = 0;
        return 0;
      }
      finally
      {
        if (localCursor != null) {
          localCursor.close();
        }
      }
    }
  }
  
  public void l(long paramLong)
  {
    boolean bool = true;
    SQLiteDatabase localSQLiteDatabase = al("Error opening database for clearHits");
    e locale;
    if (localSQLiteDatabase != null)
    {
      if (paramLong != 0L) {
        break label54;
      }
      localSQLiteDatabase.delete("hits2", null, null);
      locale = this.zc;
      if (fj() != 0) {
        break label87;
      }
    }
    for (;;)
    {
      locale.B(bool);
      return;
      label54:
      String[] arrayOfString = new String[bool];
      arrayOfString[0] = Long.valueOf(paramLong).toString();
      localSQLiteDatabase.delete("hits2", "hit_app_id = ?", arrayOfString);
      break;
      label87:
      bool = false;
    }
  }
  
  public void setDryRun(boolean paramBoolean)
  {
    this.yt = paramBoolean;
    if (this.BU != null) {
      this.BU.setDryRun(paramBoolean);
    }
  }
  
  class a
    extends SQLiteOpenHelper
  {
    private boolean BZ;
    private long Ca = 0L;
    
    a(Context paramContext, String paramString)
    {
      super(paramString, null, 1);
    }
    
    private void a(SQLiteDatabase paramSQLiteDatabase)
    {
      Cursor localCursor = paramSQLiteDatabase.rawQuery("SELECT * FROM hits2 WHERE 0", null);
      HashSet localHashSet = new HashSet();
      try
      {
        String[] arrayOfString = localCursor.getColumnNames();
        for (int i = 0; i < arrayOfString.length; i++) {
          localHashSet.add(arrayOfString[i]);
        }
        localCursor.close();
        if ((!localHashSet.remove("hit_id")) || (!localHashSet.remove("hit_url")) || (!localHashSet.remove("hit_string")) || (!localHashSet.remove("hit_time"))) {
          throw new SQLiteException("Database column missing");
        }
      }
      finally
      {
        localCursor.close();
      }
      boolean bool = localHashSet.remove("hit_app_id");
      int j = 0;
      if (!bool) {
        j = 1;
      }
      if (!localHashSet.isEmpty()) {
        throw new SQLiteException("Database has extra columns");
      }
      if (j != 0) {
        paramSQLiteDatabase.execSQL("ALTER TABLE hits2 ADD COLUMN hit_app_id");
      }
    }
    
    /* Error */
    private boolean a(String paramString, SQLiteDatabase paramSQLiteDatabase)
    {
      // Byte code:
      //   0: aconst_null
      //   1: astore_3
      //   2: aload_2
      //   3: ldc 83
      //   5: iconst_1
      //   6: anewarray 85	java/lang/String
      //   9: dup
      //   10: iconst_0
      //   11: ldc 87
      //   13: aastore
      //   14: ldc 89
      //   16: iconst_1
      //   17: anewarray 85	java/lang/String
      //   20: dup
      //   21: iconst_0
      //   22: aload_1
      //   23: aastore
      //   24: aconst_null
      //   25: aconst_null
      //   26: aconst_null
      //   27: invokevirtual 93	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
      //   30: astore 8
      //   32: aload 8
      //   34: invokeinterface 96 1 0
      //   39: istore 10
      //   41: aload 8
      //   43: ifnull +10 -> 53
      //   46: aload 8
      //   48: invokeinterface 49 1 0
      //   53: iload 10
      //   55: ireturn
      //   56: astore 5
      //   58: aconst_null
      //   59: astore 6
      //   61: new 98	java/lang/StringBuilder
      //   64: dup
      //   65: invokespecial 99	java/lang/StringBuilder:<init>	()V
      //   68: ldc 101
      //   70: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   73: aload_1
      //   74: invokevirtual 105	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   77: invokevirtual 109	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   80: invokestatic 114	com/google/android/gms/analytics/ae:W	(Ljava/lang/String;)V
      //   83: aload 6
      //   85: ifnull +10 -> 95
      //   88: aload 6
      //   90: invokeinterface 49 1 0
      //   95: iconst_0
      //   96: ireturn
      //   97: astore 4
      //   99: aload_3
      //   100: ifnull +9 -> 109
      //   103: aload_3
      //   104: invokeinterface 49 1 0
      //   109: aload 4
      //   111: athrow
      //   112: astore 4
      //   114: aload 8
      //   116: astore_3
      //   117: goto -18 -> 99
      //   120: astore 7
      //   122: aload 6
      //   124: astore_3
      //   125: aload 7
      //   127: astore 4
      //   129: goto -30 -> 99
      //   132: astore 9
      //   134: aload 8
      //   136: astore 6
      //   138: goto -77 -> 61
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	141	0	this	a
      //   0	141	1	paramString	String
      //   0	141	2	paramSQLiteDatabase	SQLiteDatabase
      //   1	124	3	localObject1	Object
      //   97	13	4	localObject2	Object
      //   112	1	4	localObject3	Object
      //   127	1	4	localObject4	Object
      //   56	1	5	localSQLiteException1	SQLiteException
      //   59	78	6	localCursor1	Cursor
      //   120	6	7	localObject5	Object
      //   30	105	8	localCursor2	Cursor
      //   132	1	9	localSQLiteException2	SQLiteException
      //   39	15	10	bool	boolean
      // Exception table:
      //   from	to	target	type
      //   2	32	56	android/database/sqlite/SQLiteException
      //   2	32	97	finally
      //   32	41	112	finally
      //   61	83	120	finally
      //   32	41	132	android/database/sqlite/SQLiteException
    }
    
    public SQLiteDatabase getWritableDatabase()
    {
      if ((this.BZ) && (3600000L + this.Ca > ag.a(ag.this).currentTimeMillis())) {
        throw new SQLiteException("Database creation failed");
      }
      this.BZ = true;
      this.Ca = ag.a(ag.this).currentTimeMillis();
      try
      {
        SQLiteDatabase localSQLiteDatabase2 = super.getWritableDatabase();
        localSQLiteDatabase1 = localSQLiteDatabase2;
      }
      catch (SQLiteException localSQLiteException)
      {
        for (;;)
        {
          ag.c(ag.this).getDatabasePath(ag.b(ag.this)).delete();
          SQLiteDatabase localSQLiteDatabase1 = null;
        }
      }
      if (localSQLiteDatabase1 == null) {
        localSQLiteDatabase1 = super.getWritableDatabase();
      }
      this.BZ = false;
      return localSQLiteDatabase1;
    }
    
    public void onCreate(SQLiteDatabase paramSQLiteDatabase)
    {
      t.ag(paramSQLiteDatabase.getPath());
    }
    
    public void onOpen(SQLiteDatabase paramSQLiteDatabase)
    {
      Cursor localCursor;
      if (Build.VERSION.SDK_INT < 15) {
        localCursor = paramSQLiteDatabase.rawQuery("PRAGMA journal_mode=memory", null);
      }
      try
      {
        localCursor.moveToFirst();
        localCursor.close();
        if (!a("hits2", paramSQLiteDatabase))
        {
          paramSQLiteDatabase.execSQL(ag.fk());
          return;
        }
      }
      finally
      {
        localCursor.close();
      }
      a(paramSQLiteDatabase);
    }
    
    public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.analytics.ag
 * JD-Core Version:    0.7.0.1
 */