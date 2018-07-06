package com.google.android.gms.tagmanager;

import android.util.LruCache;

class bb<K, V>
  implements k<K, V>
{
  private LruCache<K, V> arR;
  
  bb(int paramInt, final l.a<K, V> parama)
  {
    this.arR = new LruCache(paramInt)
    {
      protected int sizeOf(K paramAnonymousK, V paramAnonymousV)
      {
        return parama.sizeOf(paramAnonymousK, paramAnonymousV);
      }
    };
  }
  
  public void e(K paramK, V paramV)
  {
    this.arR.put(paramK, paramV);
  }
  
  public V get(K paramK)
  {
    return this.arR.get(paramK);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.tagmanager.bb
 * JD-Core Version:    0.7.0.1
 */