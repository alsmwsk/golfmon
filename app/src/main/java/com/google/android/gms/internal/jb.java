package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.Path;
import android.net.Uri;
import android.widget.ImageView;

public final class jb
  extends ImageView
{
  private Uri Mn;
  private int Mo;
  private int Mp;
  private a Mq;
  private int Mr;
  private float Ms;
  
  public void aB(int paramInt)
  {
    this.Mo = paramInt;
  }
  
  public void g(Uri paramUri)
  {
    this.Mn = paramUri;
  }
  
  public int hj()
  {
    return this.Mo;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.Mq != null) {
      paramCanvas.clipPath(this.Mq.g(getWidth(), getHeight()));
    }
    super.onDraw(paramCanvas);
    if (this.Mp != 0) {
      paramCanvas.drawColor(this.Mp);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int j;
    int i;
    switch (this.Mr)
    {
    default: 
      return;
    case 1: 
      j = getMeasuredHeight();
      i = (int)(j * this.Ms);
    }
    for (;;)
    {
      setMeasuredDimension(i, j);
      return;
      i = getMeasuredWidth();
      j = (int)(i / this.Ms);
    }
  }
  
  public static abstract interface a
  {
    public abstract Path g(int paramInt1, int paramInt2);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.jb
 * JD-Core Version:    0.7.0.1
 */