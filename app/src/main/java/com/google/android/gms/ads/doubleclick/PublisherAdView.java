package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.internal.bh;

public final class PublisherAdView
  extends ViewGroup
{
  private final bh ll;
  
  public PublisherAdView(Context paramContext)
  {
    super(paramContext);
    this.ll = new bh(this);
  }
  
  public PublisherAdView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.ll = new bh(this, paramAttributeSet, true);
  }
  
  public PublisherAdView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.ll = new bh(this, paramAttributeSet, true);
  }
  
  public void destroy()
  {
    this.ll.destroy();
  }
  
  public AdListener getAdListener()
  {
    return this.ll.getAdListener();
  }
  
  public AdSize getAdSize()
  {
    return this.ll.getAdSize();
  }
  
  public AdSize[] getAdSizes()
  {
    return this.ll.getAdSizes();
  }
  
  public String getAdUnitId()
  {
    return this.ll.getAdUnitId();
  }
  
  public AppEventListener getAppEventListener()
  {
    return this.ll.getAppEventListener();
  }
  
  public String getMediationAdapterClassName()
  {
    return this.ll.getMediationAdapterClassName();
  }
  
  public void loadAd(PublisherAdRequest paramPublisherAdRequest)
  {
    this.ll.a(paramPublisherAdRequest.Y());
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    View localView = getChildAt(0);
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      int i = localView.getMeasuredWidth();
      int j = localView.getMeasuredHeight();
      int k = (paramInt3 - paramInt1 - i) / 2;
      int m = (paramInt4 - paramInt2 - j) / 2;
      localView.layout(k, m, i + k, j + m);
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    View localView = getChildAt(0);
    AdSize localAdSize = getAdSize();
    int j;
    int i;
    if ((localView != null) && (localView.getVisibility() != 8))
    {
      measureChild(localView, paramInt1, paramInt2);
      j = localView.getMeasuredWidth();
      i = localView.getMeasuredHeight();
    }
    for (;;)
    {
      int k = Math.max(j, getSuggestedMinimumWidth());
      int m = Math.max(i, getSuggestedMinimumHeight());
      setMeasuredDimension(View.resolveSize(k, paramInt1), View.resolveSize(m, paramInt2));
      return;
      if (localAdSize != null)
      {
        Context localContext = getContext();
        j = localAdSize.getWidthInPixels(localContext);
        i = localAdSize.getHeightInPixels(localContext);
      }
      else
      {
        i = 0;
        j = 0;
      }
    }
  }
  
  public void pause()
  {
    this.ll.pause();
  }
  
  public void recordManualImpression()
  {
    this.ll.recordManualImpression();
  }
  
  public void resume()
  {
    this.ll.resume();
  }
  
  public void setAdListener(AdListener paramAdListener)
  {
    this.ll.setAdListener(paramAdListener);
  }
  
  public void setAdSizes(AdSize... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length < 1)) {
      throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
    }
    this.ll.a(paramVarArgs);
  }
  
  public void setAdUnitId(String paramString)
  {
    this.ll.setAdUnitId(paramString);
  }
  
  public void setAppEventListener(AppEventListener paramAppEventListener)
  {
    this.ll.setAppEventListener(paramAppEventListener);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.doubleclick.PublisherAdView
 * JD-Core Version:    0.7.0.1
 */