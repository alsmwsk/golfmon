package com.google.android.gms.internal;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class ao
{
  private static MessageDigest nS = null;
  protected Object mH = new Object();
  
  protected MessageDigest bf()
  {
    for (;;)
    {
      int i;
      synchronized (this.mH)
      {
        if (nS != null)
        {
          MessageDigest localMessageDigest2 = nS;
          return localMessageDigest2;
        }
        i = 0;
        if (i >= 2) {}
      }
      try
      {
        nS = MessageDigest.getInstance("MD5");
        label38:
        i++;
        continue;
        MessageDigest localMessageDigest1 = nS;
        return localMessageDigest1;
        localObject2 = finally;
        throw localObject2;
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        break label38;
      }
    }
  }
  
  abstract byte[] l(String paramString);
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ao
 * JD-Core Version:    0.7.0.1
 */