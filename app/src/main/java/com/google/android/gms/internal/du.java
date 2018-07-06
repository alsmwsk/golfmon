package com.google.android.gms.internal;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;

@ey
public final class du
  extends FrameLayout
  implements View.OnClickListener
{
  private final Activity nB;
  private final ImageButton sx;
  
  public du(Activity paramActivity, int paramInt)
  {
    super(paramActivity);
    this.nB = paramActivity;
    setOnClickListener(this);
    this.sx = new ImageButton(paramActivity);
    this.sx.setImageResource(17301527);
    this.sx.setBackgroundColor(0);
    this.sx.setOnClickListener(this);
    this.sx.setPadding(0, 0, 0, 0);
    this.sx.setContentDescription("Interstitial close button");
    int i = gq.a(paramActivity, paramInt);
    addView(this.sx, new FrameLayout.LayoutParams(i, i, 17));
  }
  
  public void onClick(View paramView)
  {
    this.nB.finish();
  }
  
  public void q(boolean paramBoolean)
  {
    ImageButton localImageButton = this.sx;
    if (paramBoolean) {}
    for (int i = 4;; i = 0)
    {
      localImageButton.setVisibility(i);
      return;
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.du
 * JD-Core Version:    0.7.0.1
 */