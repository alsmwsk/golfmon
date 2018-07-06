package com.google.android.gms.maps.model;

public abstract interface TileProvider
{
  public static final Tile NO_TILE = new Tile(-1, -1, null);
  
  public abstract Tile getTile(int paramInt1, int paramInt2, int paramInt3);
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.TileProvider
 * JD-Core Version:    0.7.0.1
 */