package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.R.string;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.dynamic.LifecycleDelegate;
import com.google.android.gms.dynamic.a;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.internal.qa;
import com.google.android.gms.internal.qb.a;
import com.google.android.gms.internal.qi;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class WalletFragment
  extends Fragment
{
  private final Fragment TG = this;
  private WalletFragmentOptions awe;
  private WalletFragmentInitParams awf;
  private MaskedWalletRequest awg;
  private MaskedWallet awh;
  private Boolean awi;
  private b awn;
  private final b awo = b.a(this);
  private final c awp = new c(null);
  private a awq = new a(this);
  private boolean mCreated = false;
  
  public static WalletFragment newInstance(WalletFragmentOptions paramWalletFragmentOptions)
  {
    WalletFragment localWalletFragment = new WalletFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extraWalletFragmentOptions", paramWalletFragmentOptions);
    localWalletFragment.TG.setArguments(localBundle);
    return localWalletFragment;
  }
  
  public int getState()
  {
    if (this.awn != null) {
      return b.a(this.awn);
    }
    return 0;
  }
  
  public void initialize(WalletFragmentInitParams paramWalletFragmentInitParams)
  {
    if (this.awn != null)
    {
      b.a(this.awn, paramWalletFragmentInitParams);
      this.awf = null;
    }
    do
    {
      return;
      if (this.awf != null) {
        break;
      }
      this.awf = paramWalletFragmentInitParams;
      if (this.awg != null) {
        Log.w("WalletFragment", "updateMaskedWalletRequest() was called before initialize()");
      }
    } while (this.awh == null);
    Log.w("WalletFragment", "updateMaskedWallet() was called before initialize()");
    return;
    Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.awn != null) {
      b.a(this.awn, paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      paramBundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
      WalletFragmentInitParams localWalletFragmentInitParams = (WalletFragmentInitParams)paramBundle.getParcelable("walletFragmentInitParams");
      if (localWalletFragmentInitParams != null)
      {
        if (this.awf != null) {
          Log.w("WalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
        }
        this.awf = localWalletFragmentInitParams;
      }
      if (this.awg == null) {
        this.awg = ((MaskedWalletRequest)paramBundle.getParcelable("maskedWalletRequest"));
      }
      if (this.awh == null) {
        this.awh = ((MaskedWallet)paramBundle.getParcelable("maskedWallet"));
      }
      if (paramBundle.containsKey("walletFragmentOptions")) {
        this.awe = ((WalletFragmentOptions)paramBundle.getParcelable("walletFragmentOptions"));
      }
      if (paramBundle.containsKey("enabled")) {
        this.awi = Boolean.valueOf(paramBundle.getBoolean("enabled"));
      }
    }
    for (;;)
    {
      this.mCreated = true;
      this.awp.onCreate(paramBundle);
      return;
      if (this.TG.getArguments() != null)
      {
        WalletFragmentOptions localWalletFragmentOptions = (WalletFragmentOptions)this.TG.getArguments().getParcelable("extraWalletFragmentOptions");
        if (localWalletFragmentOptions != null)
        {
          localWalletFragmentOptions.ab(this.TG.getActivity());
          this.awe = localWalletFragmentOptions;
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.awp.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mCreated = false;
  }
  
  public void onInflate(Activity paramActivity, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    super.onInflate(paramActivity, paramAttributeSet, paramBundle);
    if (this.awe == null) {
      this.awe = WalletFragmentOptions.a(paramActivity, paramAttributeSet);
    }
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("attrKeyWalletFragmentOptions", this.awe);
    this.awp.onInflate(paramActivity, localBundle, paramBundle);
  }
  
  public void onPause()
  {
    super.onPause();
    this.awp.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.awp.onResume();
    FragmentManager localFragmentManager = this.TG.getActivity().getFragmentManager();
    Fragment localFragment = localFragmentManager.findFragmentByTag("GooglePlayServicesErrorDialog");
    if (localFragment != null)
    {
      localFragmentManager.beginTransaction().remove(localFragment).commit();
      GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.TG.getActivity()), this.TG.getActivity(), -1);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
    this.awp.onSaveInstanceState(paramBundle);
    if (this.awf != null)
    {
      paramBundle.putParcelable("walletFragmentInitParams", this.awf);
      this.awf = null;
    }
    if (this.awg != null)
    {
      paramBundle.putParcelable("maskedWalletRequest", this.awg);
      this.awg = null;
    }
    if (this.awh != null)
    {
      paramBundle.putParcelable("maskedWallet", this.awh);
      this.awh = null;
    }
    if (this.awe != null)
    {
      paramBundle.putParcelable("walletFragmentOptions", this.awe);
      this.awe = null;
    }
    if (this.awi != null)
    {
      paramBundle.putBoolean("enabled", this.awi.booleanValue());
      this.awi = null;
    }
  }
  
  public void onStart()
  {
    super.onStart();
    this.awp.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    this.awp.onStop();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.awn != null)
    {
      b.a(this.awn, paramBoolean);
      this.awi = null;
      return;
    }
    this.awi = Boolean.valueOf(paramBoolean);
  }
  
  public void setOnStateChangedListener(OnStateChangedListener paramOnStateChangedListener)
  {
    this.awq.a(paramOnStateChangedListener);
  }
  
  public void updateMaskedWallet(MaskedWallet paramMaskedWallet)
  {
    if (this.awn != null)
    {
      b.a(this.awn, paramMaskedWallet);
      this.awh = null;
      return;
    }
    this.awh = paramMaskedWallet;
  }
  
  public void updateMaskedWalletRequest(MaskedWalletRequest paramMaskedWalletRequest)
  {
    if (this.awn != null)
    {
      b.a(this.awn, paramMaskedWalletRequest);
      this.awg = null;
      return;
    }
    this.awg = paramMaskedWalletRequest;
  }
  
  public static abstract interface OnStateChangedListener
  {
    public abstract void onStateChanged(WalletFragment paramWalletFragment, int paramInt1, int paramInt2, Bundle paramBundle);
  }
  
  static class a
    extends qb.a
  {
    private WalletFragment.OnStateChangedListener awr;
    private final WalletFragment aws;
    
    a(WalletFragment paramWalletFragment)
    {
      this.aws = paramWalletFragment;
    }
    
    public void a(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      if (this.awr != null) {
        this.awr.onStateChanged(this.aws, paramInt1, paramInt2, paramBundle);
      }
    }
    
    public void a(WalletFragment.OnStateChangedListener paramOnStateChangedListener)
    {
      this.awr = paramOnStateChangedListener;
    }
  }
  
  private static class b
    implements LifecycleDelegate
  {
    private final qa awl;
    
    private b(qa paramqa)
    {
      this.awl = paramqa;
    }
    
    private int getState()
    {
      try
      {
        int i = this.awl.getState();
        return i;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    private void initialize(WalletFragmentInitParams paramWalletFragmentInitParams)
    {
      try
      {
        this.awl.initialize(paramWalletFragmentInitParams);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    private void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
    {
      try
      {
        this.awl.onActivityResult(paramInt1, paramInt2, paramIntent);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    private void setEnabled(boolean paramBoolean)
    {
      try
      {
        this.awl.setEnabled(paramBoolean);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    private void updateMaskedWallet(MaskedWallet paramMaskedWallet)
    {
      try
      {
        this.awl.updateMaskedWallet(paramMaskedWallet);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    private void updateMaskedWalletRequest(MaskedWalletRequest paramMaskedWalletRequest)
    {
      try
      {
        this.awl.updateMaskedWalletRequest(paramMaskedWalletRequest);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public void onCreate(Bundle paramBundle)
    {
      try
      {
        this.awl.onCreate(paramBundle);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
    {
      try
      {
        View localView = (View)e.f(this.awl.onCreateView(e.k(paramLayoutInflater), e.k(paramViewGroup), paramBundle));
        return localView;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public void onDestroy() {}
    
    public void onDestroyView() {}
    
    public void onInflate(Activity paramActivity, Bundle paramBundle1, Bundle paramBundle2)
    {
      WalletFragmentOptions localWalletFragmentOptions = (WalletFragmentOptions)paramBundle1.getParcelable("extraWalletFragmentOptions");
      try
      {
        this.awl.a(e.k(paramActivity), localWalletFragmentOptions, paramBundle2);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public void onLowMemory() {}
    
    public void onPause()
    {
      try
      {
        this.awl.onPause();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public void onResume()
    {
      try
      {
        this.awl.onResume();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public void onSaveInstanceState(Bundle paramBundle)
    {
      try
      {
        this.awl.onSaveInstanceState(paramBundle);
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public void onStart()
    {
      try
      {
        this.awl.onStart();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
    
    public void onStop()
    {
      try
      {
        this.awl.onStop();
        return;
      }
      catch (RemoteException localRemoteException)
      {
        throw new RuntimeException(localRemoteException);
      }
    }
  }
  
  private class c
    extends a<WalletFragment.b>
    implements View.OnClickListener
  {
    private c() {}
    
    protected void a(FrameLayout paramFrameLayout)
    {
      Button localButton = new Button(WalletFragment.a(WalletFragment.this).getActivity());
      localButton.setText(R.string.wallet_buy_button_place_holder);
      int i = -1;
      int j = -2;
      if (WalletFragment.e(WalletFragment.this) != null)
      {
        WalletFragmentStyle localWalletFragmentStyle = WalletFragment.e(WalletFragment.this).getFragmentStyle();
        if (localWalletFragmentStyle != null)
        {
          DisplayMetrics localDisplayMetrics = WalletFragment.a(WalletFragment.this).getResources().getDisplayMetrics();
          i = localWalletFragmentStyle.a("buyButtonWidth", localDisplayMetrics, i);
          j = localWalletFragmentStyle.a("buyButtonHeight", localDisplayMetrics, j);
        }
      }
      localButton.setLayoutParams(new ViewGroup.LayoutParams(i, j));
      localButton.setOnClickListener(this);
      paramFrameLayout.addView(localButton);
    }
    
    protected void a(f<WalletFragment.b> paramf)
    {
      Activity localActivity = WalletFragment.a(WalletFragment.this).getActivity();
      if ((WalletFragment.b(WalletFragment.this) == null) && (WalletFragment.c(WalletFragment.this)) && (localActivity != null)) {}
      try
      {
        qa localqa = qi.a(localActivity, WalletFragment.d(WalletFragment.this), WalletFragment.e(WalletFragment.this), WalletFragment.f(WalletFragment.this));
        WalletFragment.a(WalletFragment.this, new WalletFragment.b(localqa, null));
        WalletFragment.a(WalletFragment.this, null);
        paramf.a(WalletFragment.b(WalletFragment.this));
        if (WalletFragment.g(WalletFragment.this) != null)
        {
          WalletFragment.b.a(WalletFragment.b(WalletFragment.this), WalletFragment.g(WalletFragment.this));
          WalletFragment.a(WalletFragment.this, null);
        }
        if (WalletFragment.h(WalletFragment.this) != null)
        {
          WalletFragment.b.a(WalletFragment.b(WalletFragment.this), WalletFragment.h(WalletFragment.this));
          WalletFragment.a(WalletFragment.this, null);
        }
        if (WalletFragment.i(WalletFragment.this) != null)
        {
          WalletFragment.b.a(WalletFragment.b(WalletFragment.this), WalletFragment.i(WalletFragment.this));
          WalletFragment.a(WalletFragment.this, null);
        }
        if (WalletFragment.j(WalletFragment.this) != null)
        {
          WalletFragment.b.a(WalletFragment.b(WalletFragment.this), WalletFragment.j(WalletFragment.this).booleanValue());
          WalletFragment.a(WalletFragment.this, null);
        }
        return;
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException) {}
    }
    
    public void onClick(View paramView)
    {
      Activity localActivity = WalletFragment.a(WalletFragment.this).getActivity();
      GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(localActivity), localActivity, -1);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.fragment.WalletFragment
 * JD-Core Version:    0.7.0.1
 */