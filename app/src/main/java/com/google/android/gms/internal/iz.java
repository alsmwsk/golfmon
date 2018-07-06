package com.google.android.gms.internal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.SystemClock;

public final class iz
  extends Drawable
  implements Drawable.Callback
{
  private boolean LO = true;
  private int LV = 0;
  private long LW;
  private int LX;
  private int LY = 255;
  private int LZ;
  private int Ma = 0;
  private boolean Mb;
  private b Mc;
  private Drawable Md;
  private Drawable Me;
  private boolean Mf;
  private boolean Mg;
  private boolean Mh;
  private int Mi;
  private int mFrom;
  
  public iz(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    this(null);
    if (paramDrawable1 == null) {
      paramDrawable1 = a.hi();
    }
    this.Md = paramDrawable1;
    paramDrawable1.setCallback(this);
    b localb1 = this.Mc;
    localb1.Mm |= paramDrawable1.getChangingConfigurations();
    if (paramDrawable2 == null) {
      paramDrawable2 = a.hi();
    }
    this.Me = paramDrawable2;
    paramDrawable2.setCallback(this);
    b localb2 = this.Mc;
    localb2.Mm |= paramDrawable2.getChangingConfigurations();
  }
  
  iz(b paramb)
  {
    this.Mc = new b(paramb);
  }
  
  public boolean canConstantState()
  {
    if (!this.Mf) {
      if ((this.Md.getConstantState() == null) || (this.Me.getConstantState() == null)) {
        break label44;
      }
    }
    label44:
    for (boolean bool = true;; bool = false)
    {
      this.Mg = bool;
      this.Mf = true;
      return this.Mg;
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    int i = 1;
    switch (this.LV)
    {
    }
    int k;
    boolean bool;
    Drawable localDrawable1;
    Drawable localDrawable2;
    do
    {
      for (int j = i;; j = 0)
      {
        k = this.Ma;
        bool = this.LO;
        localDrawable1 = this.Md;
        localDrawable2 = this.Me;
        if (j == 0) {
          break;
        }
        if ((!bool) || (k == 0)) {
          localDrawable1.draw(paramCanvas);
        }
        if (k == this.LY)
        {
          localDrawable2.setAlpha(this.LY);
          localDrawable2.draw(paramCanvas);
        }
        return;
        this.LW = SystemClock.uptimeMillis();
        this.LV = 2;
      }
    } while (this.LW < 0L);
    float f1 = (float)(SystemClock.uptimeMillis() - this.LW) / this.LZ;
    if (f1 >= 1.0F) {}
    for (;;)
    {
      if (i != 0) {
        this.LV = 0;
      }
      float f2 = Math.min(f1, 1.0F);
      this.Ma = ((int)(this.mFrom + f2 * (this.LX - this.mFrom)));
      break;
      i = 0;
    }
    if (bool) {
      localDrawable1.setAlpha(this.LY - k);
    }
    localDrawable1.draw(paramCanvas);
    if (bool) {
      localDrawable1.setAlpha(this.LY);
    }
    if (k > 0)
    {
      localDrawable2.setAlpha(k);
      localDrawable2.draw(paramCanvas);
      localDrawable2.setAlpha(this.LY);
    }
    invalidateSelf();
  }
  
  public int getChangingConfigurations()
  {
    return super.getChangingConfigurations() | this.Mc.Ml | this.Mc.Mm;
  }
  
  public Drawable.ConstantState getConstantState()
  {
    if (canConstantState())
    {
      this.Mc.Ml = getChangingConfigurations();
      return this.Mc;
    }
    return null;
  }
  
  public int getIntrinsicHeight()
  {
    return Math.max(this.Md.getIntrinsicHeight(), this.Me.getIntrinsicHeight());
  }
  
  public int getIntrinsicWidth()
  {
    return Math.max(this.Md.getIntrinsicWidth(), this.Me.getIntrinsicWidth());
  }
  
  public int getOpacity()
  {
    if (!this.Mh)
    {
      this.Mi = Drawable.resolveOpacity(this.Md.getOpacity(), this.Me.getOpacity());
      this.Mh = true;
    }
    return this.Mi;
  }
  
  public Drawable hh()
  {
    return this.Me;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if (ll.ig())
    {
      Drawable.Callback localCallback = getCallback();
      if (localCallback != null) {
        localCallback.invalidateDrawable(this);
      }
    }
  }
  
  public Drawable mutate()
  {
    if ((!this.Mb) && (super.mutate() == this))
    {
      if (!canConstantState()) {
        throw new IllegalStateException("One or more children of this LayerDrawable does not have constant state; this drawable cannot be mutated.");
      }
      this.Md.mutate();
      this.Me.mutate();
      this.Mb = true;
    }
    return this;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.Md.setBounds(paramRect);
    this.Me.setBounds(paramRect);
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong)
  {
    if (ll.ig())
    {
      Drawable.Callback localCallback = getCallback();
      if (localCallback != null) {
        localCallback.scheduleDrawable(this, paramRunnable, paramLong);
      }
    }
  }
  
  public void setAlpha(int paramInt)
  {
    if (this.Ma == this.LY) {
      this.Ma = paramInt;
    }
    this.LY = paramInt;
    invalidateSelf();
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.Md.setColorFilter(paramColorFilter);
    this.Me.setColorFilter(paramColorFilter);
  }
  
  public void startTransition(int paramInt)
  {
    this.mFrom = 0;
    this.LX = this.LY;
    this.Ma = 0;
    this.LZ = paramInt;
    this.LV = 1;
    invalidateSelf();
  }
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable)
  {
    if (ll.ig())
    {
      Drawable.Callback localCallback = getCallback();
      if (localCallback != null) {
        localCallback.unscheduleDrawable(this, paramRunnable);
      }
    }
  }
  
  private static final class a
    extends Drawable
  {
    private static final a Mj = new a();
    private static final a Mk = new a(null);
    
    public void draw(Canvas paramCanvas) {}
    
    public Drawable.ConstantState getConstantState()
    {
      return Mk;
    }
    
    public int getOpacity()
    {
      return -2;
    }
    
    public void setAlpha(int paramInt) {}
    
    public void setColorFilter(ColorFilter paramColorFilter) {}
    
    private static final class a
      extends Drawable.ConstantState
    {
      public int getChangingConfigurations()
      {
        return 0;
      }
      
      public Drawable newDrawable()
      {
        return iz.a.hi();
      }
    }
  }
  
  static final class b
    extends Drawable.ConstantState
  {
    int Ml;
    int Mm;
    
    b(b paramb)
    {
      if (paramb != null)
      {
        this.Ml = paramb.Ml;
        this.Mm = paramb.Mm;
      }
    }
    
    public int getChangingConfigurations()
    {
      return this.Ml;
    }
    
    public Drawable newDrawable()
    {
      return new iz(this);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.iz
 * JD-Core Version:    0.7.0.1
 */