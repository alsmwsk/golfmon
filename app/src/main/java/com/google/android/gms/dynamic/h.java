package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public final class h
  extends c.a
{
  private Fragment Mx;
  
  private h(Fragment paramFragment)
  {
    this.Mx = paramFragment;
  }
  
  public static h a(Fragment paramFragment)
  {
    if (paramFragment != null) {
      return new h(paramFragment);
    }
    return null;
  }
  
  public void d(d paramd)
  {
    View localView = (View)e.f(paramd);
    this.Mx.registerForContextMenu(localView);
  }
  
  public void e(d paramd)
  {
    View localView = (View)e.f(paramd);
    this.Mx.unregisterForContextMenu(localView);
  }
  
  public Bundle getArguments()
  {
    return this.Mx.getArguments();
  }
  
  public int getId()
  {
    return this.Mx.getId();
  }
  
  public boolean getRetainInstance()
  {
    return this.Mx.getRetainInstance();
  }
  
  public String getTag()
  {
    return this.Mx.getTag();
  }
  
  public int getTargetRequestCode()
  {
    return this.Mx.getTargetRequestCode();
  }
  
  public boolean getUserVisibleHint()
  {
    return this.Mx.getUserVisibleHint();
  }
  
  public d getView()
  {
    return e.k(this.Mx.getView());
  }
  
  public boolean isAdded()
  {
    return this.Mx.isAdded();
  }
  
  public boolean isDetached()
  {
    return this.Mx.isDetached();
  }
  
  public boolean isHidden()
  {
    return this.Mx.isHidden();
  }
  
  public boolean isInLayout()
  {
    return this.Mx.isInLayout();
  }
  
  public boolean isRemoving()
  {
    return this.Mx.isRemoving();
  }
  
  public boolean isResumed()
  {
    return this.Mx.isResumed();
  }
  
  public boolean isVisible()
  {
    return this.Mx.isVisible();
  }
  
  public d jf()
  {
    return e.k(this.Mx.getActivity());
  }
  
  public c jg()
  {
    return a(this.Mx.getParentFragment());
  }
  
  public d jh()
  {
    return e.k(this.Mx.getResources());
  }
  
  public c ji()
  {
    return a(this.Mx.getTargetFragment());
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    this.Mx.setHasOptionsMenu(paramBoolean);
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    this.Mx.setMenuVisibility(paramBoolean);
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    this.Mx.setRetainInstance(paramBoolean);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    this.Mx.setUserVisibleHint(paramBoolean);
  }
  
  public void startActivity(Intent paramIntent)
  {
    this.Mx.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.Mx.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.dynamic.h
 * JD-Core Version:    0.7.0.1
 */