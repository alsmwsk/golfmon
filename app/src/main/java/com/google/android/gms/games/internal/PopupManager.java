package com.google.android.gms.games.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.view.Display;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import com.google.android.gms.internal.ll;
import java.lang.ref.WeakReference;

public class PopupManager
{
  protected GamesClientImpl ZQ;
  protected PopupLocationInfo ZR;
  
  private PopupManager(GamesClientImpl paramGamesClientImpl, int paramInt)
  {
    this.ZQ = paramGamesClientImpl;
    dY(paramInt);
  }
  
  public static PopupManager a(GamesClientImpl paramGamesClientImpl, int paramInt)
  {
    if (ll.ih()) {
      return new PopupManagerHCMR1(paramGamesClientImpl, paramInt);
    }
    return new PopupManager(paramGamesClientImpl, paramInt);
  }
  
  protected void dY(int paramInt)
  {
    this.ZR = new PopupLocationInfo(paramInt, new Binder(), null);
  }
  
  public void l(View paramView) {}
  
  public void lT()
  {
    this.ZQ.a(this.ZR.ZS, this.ZR.lW());
  }
  
  public Bundle lU()
  {
    return this.ZR.lW();
  }
  
  public IBinder lV()
  {
    return this.ZR.ZS;
  }
  
  public void setGravity(int paramInt)
  {
    this.ZR.gravity = paramInt;
  }
  
  public static final class PopupLocationInfo
  {
    public IBinder ZS;
    public int ZT = -1;
    public int bottom = 0;
    public int gravity;
    public int left = 0;
    public int right = 0;
    public int top = 0;
    
    private PopupLocationInfo(int paramInt, IBinder paramIBinder)
    {
      this.gravity = paramInt;
      this.ZS = paramIBinder;
    }
    
    public Bundle lW()
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("popupLocationInfo.gravity", this.gravity);
      localBundle.putInt("popupLocationInfo.displayId", this.ZT);
      localBundle.putInt("popupLocationInfo.left", this.left);
      localBundle.putInt("popupLocationInfo.top", this.top);
      localBundle.putInt("popupLocationInfo.right", this.right);
      localBundle.putInt("popupLocationInfo.bottom", this.bottom);
      return localBundle;
    }
  }
  
  private static final class PopupManagerHCMR1
    extends PopupManager
    implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener
  {
    private boolean Yq = false;
    private WeakReference<View> ZU;
    
    protected PopupManagerHCMR1(GamesClientImpl paramGamesClientImpl, int paramInt)
    {
      super(paramInt, null);
    }
    
    private void m(View paramView)
    {
      int i = -1;
      if (ll.il())
      {
        Display localDisplay = paramView.getDisplay();
        if (localDisplay != null) {
          i = localDisplay.getDisplayId();
        }
      }
      IBinder localIBinder = paramView.getWindowToken();
      int[] arrayOfInt = new int[2];
      paramView.getLocationInWindow(arrayOfInt);
      int j = paramView.getWidth();
      int k = paramView.getHeight();
      this.ZR.ZT = i;
      this.ZR.ZS = localIBinder;
      this.ZR.left = arrayOfInt[0];
      this.ZR.top = arrayOfInt[1];
      this.ZR.right = (j + arrayOfInt[0]);
      this.ZR.bottom = (k + arrayOfInt[1]);
      if (this.Yq)
      {
        lT();
        this.Yq = false;
      }
    }
    
    protected void dY(int paramInt)
    {
      this.ZR = new PopupManager.PopupLocationInfo(paramInt, null, null);
    }
    
    public void l(View paramView)
    {
      this.ZQ.lE();
      ViewTreeObserver localViewTreeObserver;
      if (this.ZU != null)
      {
        View localView2 = (View)this.ZU.get();
        Context localContext2 = this.ZQ.getContext();
        if ((localView2 == null) && ((localContext2 instanceof Activity))) {
          localView2 = ((Activity)localContext2).getWindow().getDecorView();
        }
        if (localView2 != null)
        {
          localView2.removeOnAttachStateChangeListener(this);
          localViewTreeObserver = localView2.getViewTreeObserver();
          if (!ll.ik()) {
            break label184;
          }
          localViewTreeObserver.removeOnGlobalLayoutListener(this);
        }
      }
      for (;;)
      {
        this.ZU = null;
        Context localContext1 = this.ZQ.getContext();
        if ((paramView == null) && ((localContext1 instanceof Activity)))
        {
          View localView1 = ((Activity)localContext1).findViewById(16908290);
          if (localView1 == null) {
            localView1 = ((Activity)localContext1).getWindow().getDecorView();
          }
          GamesLog.o("PopupManager", "You have not specified a View to use as content view for popups. Falling back to the Activity content view which may not work properly in future versions of the API. Use setViewForPopups() to set your content view.");
          paramView = localView1;
        }
        if (paramView == null) {
          break;
        }
        m(paramView);
        this.ZU = new WeakReference(paramView);
        paramView.addOnAttachStateChangeListener(this);
        paramView.getViewTreeObserver().addOnGlobalLayoutListener(this);
        return;
        label184:
        localViewTreeObserver.removeGlobalOnLayoutListener(this);
      }
      GamesLog.p("PopupManager", "No content view usable to display popups. Popups will not be displayed in response to this client's calls. Use setViewForPopups() to set your content view.");
    }
    
    public void lT()
    {
      if (this.ZR.ZS != null)
      {
        super.lT();
        return;
      }
      if (this.ZU != null) {}
      for (boolean bool = true;; bool = false)
      {
        this.Yq = bool;
        return;
      }
    }
    
    public void onGlobalLayout()
    {
      if (this.ZU == null) {}
      View localView;
      do
      {
        return;
        localView = (View)this.ZU.get();
      } while (localView == null);
      m(localView);
    }
    
    public void onViewAttachedToWindow(View paramView)
    {
      m(paramView);
    }
    
    public void onViewDetachedFromWindow(View paramView)
    {
      this.ZQ.lE();
      paramView.removeOnAttachStateChangeListener(this);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.games.internal.PopupManager
 * JD-Core Version:    0.7.0.1
 */