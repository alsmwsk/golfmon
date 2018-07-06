package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.internal.iz;
import com.google.android.gms.internal.ja;
import com.google.android.gms.internal.jb;
import com.google.android.gms.internal.jc;
import com.google.android.gms.internal.jc.a;
import com.google.android.gms.internal.je;
import com.google.android.gms.internal.jv;
import java.lang.ref.WeakReference;

public abstract class a
{
  final a LJ;
  protected int LK = 0;
  protected int LL = 0;
  protected boolean LM = false;
  protected ImageManager.OnImageLoadedListener LN;
  private boolean LO = true;
  private boolean LP = false;
  private boolean LQ = true;
  protected int LR;
  
  public a(Uri paramUri, int paramInt)
  {
    this.LJ = new a(paramUri);
    this.LL = paramInt;
  }
  
  private Drawable a(Context paramContext, jc paramjc, int paramInt)
  {
    Resources localResources = paramContext.getResources();
    if (this.LR > 0)
    {
      jc.a locala = new jc.a(paramInt, this.LR);
      Drawable localDrawable = (Drawable)paramjc.get(locala);
      if (localDrawable == null)
      {
        localDrawable = localResources.getDrawable(paramInt);
        if ((0x1 & this.LR) != 0) {
          localDrawable = a(localResources, localDrawable);
        }
        paramjc.put(locala, localDrawable);
      }
      return localDrawable;
    }
    return localResources.getDrawable(paramInt);
  }
  
  protected Drawable a(Resources paramResources, Drawable paramDrawable)
  {
    return ja.a(paramResources, paramDrawable);
  }
  
  protected iz a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if (paramDrawable1 != null) {
      if (!(paramDrawable1 instanceof iz)) {}
    }
    for (paramDrawable1 = ((iz)paramDrawable1).hh();; paramDrawable1 = null) {
      return new iz(paramDrawable1, paramDrawable2);
    }
  }
  
  void a(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    je.f(paramBitmap);
    if ((0x1 & this.LR) != 0) {
      paramBitmap = ja.a(paramBitmap);
    }
    BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramContext.getResources(), paramBitmap);
    if (this.LN != null) {
      this.LN.onImageLoaded(this.LJ.uri, localBitmapDrawable, true);
    }
    a(localBitmapDrawable, paramBoolean, false, true);
  }
  
  void a(Context paramContext, jc paramjc)
  {
    if (this.LQ)
    {
      int i = this.LK;
      Drawable localDrawable = null;
      if (i != 0) {
        localDrawable = a(paramContext, paramjc, this.LK);
      }
      a(localDrawable, false, true, false);
    }
  }
  
  void a(Context paramContext, jc paramjc, boolean paramBoolean)
  {
    int i = this.LL;
    Drawable localDrawable = null;
    if (i != 0) {
      localDrawable = a(paramContext, paramjc, this.LL);
    }
    if (this.LN != null) {
      this.LN.onImageLoaded(this.LJ.uri, localDrawable, false);
    }
    a(localDrawable, paramBoolean, false, false);
  }
  
  protected abstract void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
  
  public void az(int paramInt)
  {
    this.LL = paramInt;
  }
  
  protected boolean b(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (this.LO) && (!paramBoolean2) && ((!paramBoolean1) || (this.LP));
  }
  
  static final class a
  {
    public final Uri uri;
    
    public a(Uri paramUri)
    {
      this.uri = paramUri;
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof a)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      return jv.equal(((a)paramObject).uri, this.uri);
    }
    
    public int hashCode()
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.uri;
      return jv.hashCode(arrayOfObject);
    }
  }
  
  public static final class b
    extends a
  {
    private WeakReference<ImageView> LS;
    
    public b(ImageView paramImageView, int paramInt)
    {
      super(paramInt);
      je.f(paramImageView);
      this.LS = new WeakReference(paramImageView);
    }
    
    public b(ImageView paramImageView, Uri paramUri)
    {
      super(0);
      je.f(paramImageView);
      this.LS = new WeakReference(paramImageView);
    }
    
    private void a(ImageView paramImageView, Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      if ((!paramBoolean2) && (!paramBoolean3)) {}
      for (int i = 1; (i != 0) && ((paramImageView instanceof jb)); i = 0)
      {
        int k = ((jb)paramImageView).hj();
        if ((this.LL == 0) || (k != this.LL)) {
          break;
        }
        return;
      }
      boolean bool = b(paramBoolean1, paramBoolean2);
      if ((this.LM) && (paramDrawable != null)) {}
      for (Object localObject = paramDrawable.getConstantState().newDrawable();; localObject = paramDrawable)
      {
        if (bool) {
          localObject = a(paramImageView.getDrawable(), (Drawable)localObject);
        }
        paramImageView.setImageDrawable((Drawable)localObject);
        jb localjb;
        Uri localUri;
        if ((paramImageView instanceof jb))
        {
          localjb = (jb)paramImageView;
          if (!paramBoolean3) {
            break label178;
          }
          localUri = this.LJ.uri;
          label136:
          localjb.g(localUri);
          if (i == 0) {
            break label184;
          }
        }
        label178:
        label184:
        for (int j = this.LL;; j = 0)
        {
          localjb.aB(j);
          if (!bool) {
            break;
          }
          ((iz)localObject).startTransition(250);
          return;
          localUri = null;
          break label136;
        }
      }
    }
    
    protected void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      ImageView localImageView = (ImageView)this.LS.get();
      if (localImageView != null) {
        a(localImageView, paramDrawable, paramBoolean1, paramBoolean2, paramBoolean3);
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof b)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      b localb = (b)paramObject;
      ImageView localImageView1 = (ImageView)this.LS.get();
      ImageView localImageView2 = (ImageView)localb.LS.get();
      if ((localImageView2 != null) && (localImageView1 != null) && (jv.equal(localImageView2, localImageView1))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public int hashCode()
    {
      return 0;
    }
  }
  
  public static final class c
    extends a
  {
    private WeakReference<ImageManager.OnImageLoadedListener> LT;
    
    public c(ImageManager.OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
    {
      super(0);
      je.f(paramOnImageLoadedListener);
      this.LT = new WeakReference(paramOnImageLoadedListener);
    }
    
    protected void a(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
    {
      if (!paramBoolean2)
      {
        ImageManager.OnImageLoadedListener localOnImageLoadedListener = (ImageManager.OnImageLoadedListener)this.LT.get();
        if (localOnImageLoadedListener != null) {
          localOnImageLoadedListener.onImageLoaded(this.LJ.uri, paramDrawable, paramBoolean3);
        }
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (!(paramObject instanceof c)) {
        return false;
      }
      if (this == paramObject) {
        return true;
      }
      c localc = (c)paramObject;
      ImageManager.OnImageLoadedListener localOnImageLoadedListener1 = (ImageManager.OnImageLoadedListener)this.LT.get();
      ImageManager.OnImageLoadedListener localOnImageLoadedListener2 = (ImageManager.OnImageLoadedListener)localc.LT.get();
      if ((localOnImageLoadedListener2 != null) && (localOnImageLoadedListener1 != null) && (jv.equal(localOnImageLoadedListener2, localOnImageLoadedListener1)) && (jv.equal(localc.LJ, this.LJ))) {}
      for (boolean bool = true;; bool = false) {
        return bool;
      }
    }
    
    public int hashCode()
    {
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.LJ;
      return jv.hashCode(arrayOfObject);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.a
 * JD-Core Version:    0.7.0.1
 */