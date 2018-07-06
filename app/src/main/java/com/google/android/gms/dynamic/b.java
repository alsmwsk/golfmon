package com.google.android.gms.dynamic;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public final class b
  extends c.a
{
  private Fragment TG;
  
  private b(Fragment paramFragment)
  {
    this.TG = paramFragment;
  }
  
  public static b a(Fragment paramFragment)
  {
    if (paramFragment != null) {
      return new b(paramFragment);
    }
    return null;
  }
  
  public void d(d paramd)
  {
    View localView = (View)e.f(paramd);
    this.TG.registerForContextMenu(localView);
  }
  
  public void e(d paramd)
  {
    View localView = (View)e.f(paramd);
    this.TG.unregisterForContextMenu(localView);
  }
  
  public Bundle getArguments()
  {
    return this.TG.getArguments();
  }
  
  public int getId()
  {
    return this.TG.getId();
  }
  
  public boolean getRetainInstance()
  {
    return this.TG.getRetainInstance();
  }
  
  public String getTag()
  {
    return this.TG.getTag();
  }
  
  public int getTargetRequestCode()
  {
    return this.TG.getTargetRequestCode();
  }
  
  public boolean getUserVisibleHint()
  {
    return this.TG.getUserVisibleHint();
  }
  
  public d getView()
  {
    return e.k(this.TG.getView());
  }
  
  public boolean isAdded()
  {
    return this.TG.isAdded();
  }
  
  public boolean isDetached()
  {
    return this.TG.isDetached();
  }
  
  public boolean isHidden()
  {
    return this.TG.isHidden();
  }
  
  public boolean isInLayout()
  {
    return this.TG.isInLayout();
  }
  
  public boolean isRemoving()
  {
    return this.TG.isRemoving();
  }
  
  public boolean isResumed()
  {
    return this.TG.isResumed();
  }
  
  public boolean isVisible()
  {
    return this.TG.isVisible();
  }
  
  public d jf()
  {
    return e.k(this.TG.getActivity());
  }
  
  public c jg()
  {
    return a(this.TG.getParentFragment());
  }
  
  public d jh()
  {
    return e.k(this.TG.getResources());
  }
  
  public c ji()
  {
    return a(this.TG.getTargetFragment());
  }
  
  public void setHasOptionsMenu(boolean paramBoolean)
  {
    this.TG.setHasOptionsMenu(paramBoolean);
  }
  
  public void setMenuVisibility(boolean paramBoolean)
  {
    this.TG.setMenuVisibility(paramBoolean);
  }
  
  public void setRetainInstance(boolean paramBoolean)
  {
    this.TG.setRetainInstance(paramBoolean);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    this.TG.setUserVisibleHint(paramBoolean);
  }
  
  public void startActivity(Intent paramIntent)
  {
    this.TG.startActivity(paramIntent);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt)
  {
    this.TG.startActivityForResult(paramIntent, paramInt);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.dynamic.b
 * JD-Core Version:    0.7.0.1
 */