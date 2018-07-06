package com.google.android.gms.internal;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.appindexing.Action;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class hy
{
  private static hh a(String paramString, mv.c paramc)
  {
    hp localhp = new hp.a(paramString).G(true).au(paramString).at("blob").fG();
    return new hh(qw.f(paramc), localhp);
  }
  
  public static hr a(Action paramAction, String paramString1, long paramLong, String paramString2, int paramInt)
  {
    Bundle localBundle1 = new Bundle();
    localBundle1.putAll(paramAction.fI());
    Bundle localBundle2 = localBundle1.getBundle("object");
    if (localBundle2.containsKey("id")) {}
    for (Uri localUri = Uri.parse(localBundle2.getString("id"));; localUri = null)
    {
      String str1 = localBundle2.getString("name");
      String str2 = localBundle2.getString("type");
      Intent localIntent = hz.a(paramString2, Uri.parse(localBundle2.getString("url")));
      hd.a locala = hr.a(localIntent, str1, localUri, str2, null);
      locala.a(a(".private:action", d(paramAction.fI())));
      locala.a(aw(paramString1));
      return new hr(hr.a(paramString2, localIntent), paramLong, paramInt, null, locala.fD());
    }
  }
  
  private static hh aw(String paramString)
  {
    return new hh(paramString, new hp.a(".private:actionId").G(true).au(".private:actionId").at("blob").fG());
  }
  
  static mv.c d(Bundle paramBundle)
  {
    mv.c localc = new mv.c();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramBundle.keySet().iterator();
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramBundle.get(str);
      mv.b localb = new mv.b();
      localb.name = str;
      localb.afz = new mv.d();
      if ((localObject instanceof String)) {
        localb.afz.NJ = ((String)localObject);
      }
      for (;;)
      {
        localArrayList.add(localb);
        break;
        if ((localObject instanceof Bundle)) {
          localb.afz.afE = d((Bundle)localObject);
        } else {
          Log.e("AppDataSearchClient", "Unsupported value: " + localObject);
        }
      }
    }
    if (paramBundle.containsKey("type")) {
      localc.type = paramBundle.getString("type");
    }
    localc.afA = ((mv.b[])localArrayList.toArray(new mv.b[localArrayList.size()]));
    return localc;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.hy
 * JD-Core Version:    0.7.0.1
 */