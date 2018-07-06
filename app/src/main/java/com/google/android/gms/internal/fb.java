package com.google.android.gms.internal;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View.MeasureSpec;
import android.webkit.WebView;

@ey
public class fb
  implements Runnable
{
  private final int li;
  private final int lj;
  protected final gu mo;
  private final Handler tr;
  private final long ts;
  private long tt;
  private gv.a tu;
  protected boolean tv;
  protected boolean tw;
  
  public fb(gv.a parama, gu paramgu, int paramInt1, int paramInt2)
  {
    this(parama, paramgu, paramInt1, paramInt2, 200L, 50L);
  }
  
  public fb(gv.a parama, gu paramgu, int paramInt1, int paramInt2, long paramLong1, long paramLong2)
  {
    this.ts = paramLong1;
    this.tt = paramLong2;
    this.tr = new Handler(Looper.getMainLooper());
    this.mo = paramgu;
    this.tu = parama;
    this.tv = false;
    this.tw = false;
    this.lj = paramInt2;
    this.li = paramInt1;
  }
  
  public void a(fj paramfj, gz paramgz)
  {
    this.mo.setWebViewClient(paramgz);
    gu localgu = this.mo;
    if (TextUtils.isEmpty(paramfj.sg)) {}
    for (String str = null;; str = gi.L(paramfj.sg))
    {
      localgu.loadDataWithBaseURL(str, paramfj.tU, "text/html", "UTF-8", null);
      return;
    }
  }
  
  public void b(fj paramfj)
  {
    a(paramfj, new gz(this, this.mo, paramfj.ud));
  }
  
  public void cF()
  {
    this.tr.postDelayed(this, this.ts);
  }
  
  public void cG()
  {
    try
    {
      this.tv = true;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean cH()
  {
    try
    {
      boolean bool = this.tv;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean cI()
  {
    return this.tw;
  }
  
  public void run()
  {
    if ((this.mo == null) || (cH()))
    {
      this.tu.a(this.mo);
      return;
    }
    new a(this.mo).execute(new Void[0]);
  }
  
  protected final class a
    extends AsyncTask<Void, Void, Boolean>
  {
    private final WebView tx;
    private Bitmap ty;
    
    public a(WebView paramWebView)
    {
      this.tx = paramWebView;
    }
    
    protected void a(Boolean paramBoolean)
    {
      fb.c(fb.this);
      if ((paramBoolean.booleanValue()) || (fb.this.cH()) || (fb.d(fb.this) <= 0L))
      {
        fb.this.tw = paramBoolean.booleanValue();
        fb.e(fb.this).a(fb.this.mo);
      }
      while (fb.d(fb.this) <= 0L) {
        return;
      }
      if (gr.v(2)) {
        gr.S("Ad not detected, scheduling another run.");
      }
      fb.g(fb.this).postDelayed(fb.this, fb.f(fb.this));
    }
    
    protected Boolean b(Void... paramVarArgs)
    {
      for (;;)
      {
        int k;
        try
        {
          int i = this.ty.getWidth();
          int j = this.ty.getHeight();
          Object localObject2;
          if ((i == 0) || (j == 0))
          {
            Boolean localBoolean1 = Boolean.valueOf(false);
            localObject2 = localBoolean1;
            return localObject2;
          }
          k = 0;
          int m = 0;
          int n;
          if (k < i)
          {
            n = 0;
            if (n >= j) {
              break label139;
            }
            if (this.ty.getPixel(k, n) != 0) {
              m++;
            }
          }
          else
          {
            if (m / (i * j / 100.0D) > 0.1D)
            {
              bool = true;
              Boolean localBoolean2 = Boolean.valueOf(bool);
              localObject2 = localBoolean2;
              continue;
            }
            boolean bool = false;
            continue;
          }
          n += 10;
        }
        finally {}
        continue;
        label139:
        k += 10;
      }
    }
    
    protected void onPreExecute()
    {
      try
      {
        this.ty = Bitmap.createBitmap(fb.a(fb.this), fb.b(fb.this), Bitmap.Config.ARGB_8888);
        this.tx.setVisibility(0);
        this.tx.measure(View.MeasureSpec.makeMeasureSpec(fb.a(fb.this), 0), View.MeasureSpec.makeMeasureSpec(fb.b(fb.this), 0));
        this.tx.layout(0, 0, fb.a(fb.this), fb.b(fb.this));
        Canvas localCanvas = new Canvas(this.ty);
        this.tx.draw(localCanvas);
        this.tx.invalidate();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.fb
 * JD-Core Version:    0.7.0.1
 */