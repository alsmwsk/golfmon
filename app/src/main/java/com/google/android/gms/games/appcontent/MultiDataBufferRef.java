package com.google.android.gms.games.appcontent;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.d;
import java.util.ArrayList;

public abstract class MultiDataBufferRef
  extends d
{
  protected final ArrayList<DataHolder> XX;
  
  protected MultiDataBufferRef(ArrayList<DataHolder> paramArrayList, int paramInt1, int paramInt2)
  {
    super((DataHolder)paramArrayList.get(paramInt1), paramInt2);
    this.XX = paramArrayList;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.appcontent.MultiDataBufferRef
 * JD-Core Version:    0.7.0.1
 */