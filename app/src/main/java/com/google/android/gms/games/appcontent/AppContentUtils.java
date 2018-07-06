package com.google.android.gms.games.appcontent;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.internal.la;
import java.util.ArrayList;

public final class AppContentUtils
{
  public static ArrayList<AppContentAction> a(DataHolder paramDataHolder, ArrayList<DataHolder> paramArrayList, String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    a(paramDataHolder, 1, paramString, "action_id", paramInt, new AppContentRunner()
    {
      public void b(ArrayList<DataHolder> paramAnonymousArrayList, int paramAnonymousInt)
      {
        this.Yb.add(new AppContentActionRef(paramAnonymousArrayList, paramAnonymousInt));
      }
    }, paramArrayList);
    return localArrayList;
  }
  
  private static void a(DataHolder paramDataHolder, int paramInt1, String paramString1, String paramString2, int paramInt2, AppContentRunner paramAppContentRunner, ArrayList<DataHolder> paramArrayList)
  {
    DataHolder localDataHolder = (DataHolder)paramArrayList.get(paramInt1);
    String str1 = paramDataHolder.c(paramString1, paramInt2, paramDataHolder.au(paramInt2));
    if (!TextUtils.isEmpty(str1))
    {
      int i = localDataHolder.getCount();
      String[] arrayOfString = str1.split(",");
      for (int j = 0; j < i; j++)
      {
        String str2 = localDataHolder.c(paramString2, j, localDataHolder.au(j));
        if ((!TextUtils.isEmpty(str2)) && (la.b(arrayOfString, str2))) {
          paramAppContentRunner.b(paramArrayList, j);
        }
      }
    }
  }
  
  public static ArrayList<AppContentAnnotation> b(DataHolder paramDataHolder, ArrayList<DataHolder> paramArrayList, String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    a(paramDataHolder, 2, paramString, "annotation_id", paramInt, new AppContentRunner()
    {
      public void b(ArrayList<DataHolder> paramAnonymousArrayList, int paramAnonymousInt)
      {
        this.Yb.add(new AppContentAnnotationRef(paramAnonymousArrayList, paramAnonymousInt));
      }
    }, paramArrayList);
    return localArrayList;
  }
  
  public static ArrayList<AppContentCondition> c(DataHolder paramDataHolder, ArrayList<DataHolder> paramArrayList, String paramString, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    a(paramDataHolder, 4, paramString, "condition_id", paramInt, new AppContentRunner()
    {
      public void b(ArrayList<DataHolder> paramAnonymousArrayList, int paramAnonymousInt)
      {
        this.Yb.add(new AppContentConditionRef(paramAnonymousArrayList, paramAnonymousInt));
      }
    }, paramArrayList);
    return localArrayList;
  }
  
  public static Bundle d(DataHolder paramDataHolder, ArrayList<DataHolder> paramArrayList, String paramString, int paramInt)
  {
    final Bundle localBundle = new Bundle();
    a(paramDataHolder, 3, paramString, "tuple_id", paramInt, new AppContentRunner()
    {
      public void b(ArrayList<DataHolder> paramAnonymousArrayList, int paramAnonymousInt)
      {
        AppContentTupleRef localAppContentTupleRef = new AppContentTupleRef(this.Yc, paramAnonymousInt);
        localBundle.putString(localAppContentTupleRef.getName(), localAppContentTupleRef.getValue());
      }
    }, paramArrayList);
    return localBundle;
  }
  
  private static abstract interface AppContentRunner
  {
    public abstract void b(ArrayList<DataHolder> paramArrayList, int paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.appcontent.AppContentUtils
 * JD-Core Version:    0.7.0.1
 */