package com.google.android.gms.wallet.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import com.google.android.gms.dynamic.e;
import com.google.android.gms.dynamic.f;
import com.google.android.gms.dynamic.h;
import com.google.android.gms.internal.qa;
import com.google.android.gms.internal.qb.a;
import com.google.android.gms.internal.qi;
import com.google.android.gms.wallet.MaskedWallet;
import com.google.android.gms.wallet.MaskedWalletRequest;

public final class SupportWalletFragment
  extends Fragment
{
  private final Fragment Mx = this;
  private b awa;
  private final h awb = h.a(this);
  private final c awc = new c(null);
  private a awd = new a(this);
  private WalletFragmentOptions awe;
  private WalletFragmentInitParams awf;
  private MaskedWalletRequest awg;
  private MaskedWallet awh;
  private Boolean awi;
  private boolean mCreated = false;
  
  public static SupportWalletFragment newInstance(WalletFragmentOptions paramWalletFragmentOptions)
  {
    SupportWalletFragment localSupportWalletFragment = new SupportWalletFragment();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("extraWalletFragmentOptions", paramWalletFragmentOptions);
    localSupportWalletFragment.Mx.setArguments(localBundle);
    return localSupportWalletFragment;
  }
  
  public int getState()
  {
    if (this.awa != null) {
      return b.a(this.awa);
    }
    return 0;
  }
  
  public void initialize(WalletFragmentInitParams paramWalletFragmentInitParams)
  {
    if (this.awa != null)
    {
      b.a(this.awa, paramWalletFragmentInitParams);
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
        Log.w("SupportWalletFragment", "updateMaskedWalletRequest() was called before initialize()");
      }
    } while (this.awh == null);
    Log.w("SupportWalletFragment", "updateMaskedWallet() was called before initialize()");
    return;
    Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once. Ignoring.");
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (this.awa != null) {
      b.a(this.awa, paramInt1, paramInt2, paramIntent);
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
          Log.w("SupportWalletFragment", "initialize(WalletFragmentInitParams) was called more than once.Ignoring.");
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
      this.awc.onCreate(paramBundle);
      return;
      if (this.Mx.getArguments() != null)
      {
        WalletFragmentOptions localWalletFragmentOptions = (WalletFragmentOptions)this.Mx.getArguments().getParcelable("extraWalletFragmentOptions");
        if (localWalletFragmentOptions != null)
        {
          localWalletFragmentOptions.ab(this.Mx.getActivity());
          this.awe = localWalletFragmentOptions;
        }
      }
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    return this.awc.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
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
    this.awc.onInflate(paramActivity, localBundle, paramBundle);
  }
  
  public void onPause()
  {
    super.onPause();
    this.awc.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
    this.awc.onResume();
    FragmentManager localFragmentManager = this.Mx.getActivity().getSupportFragmentManager();
    Fragment localFragment = localFragmentManager.findFragmentByTag("GooglePlayServicesErrorDialog");
    if (localFragment != null)
    {
      localFragmentManager.beginTransaction().remove(localFragment).commit();
      GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.Mx.getActivity()), this.Mx.getActivity(), -1);
    }
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.setClassLoader(WalletFragmentOptions.class.getClassLoader());
    this.awc.onSaveInstanceState(paramBundle);
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
    this.awc.onStart();
  }
  
  public void onStop()
  {
    super.onStop();
    this.awc.onStop();
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    if (this.awa != null)
    {
      b.a(this.awa, paramBoolean);
      this.awi = null;
      return;
    }
    this.awi = Boolean.valueOf(paramBoolean);
  }
  
  public void setOnStateChangedListener(OnStateChangedListener paramOnStateChangedListener)
  {
    this.awd.a(paramOnStateChangedListener);
  }
  
  public void updateMaskedWallet(MaskedWallet paramMaskedWallet)
  {
    if (this.awa != null)
    {
      b.a(this.awa, paramMaskedWallet);
      this.awh = null;
      return;
    }
    this.awh = paramMaskedWallet;
  }
  
  public void updateMaskedWalletRequest(MaskedWalletRequest paramMaskedWalletRequest)
  {
    if (this.awa != null)
    {
      b.a(this.awa, paramMaskedWalletRequest);
      this.awg = null;
      return;
    }
    this.awg = paramMaskedWalletRequest;
  }
  
  public static abstract interface OnStateChangedListener
  {
    public abstract void onStateChanged(SupportWalletFragment paramSupportWalletFragment, int paramInt1, int paramInt2, Bundle paramBundle);
  }
  
  static class a
    extends qb.a
  {
    private SupportWalletFragment.OnStateChangedListener awj;
    private final SupportWalletFragment awk;
    
    a(SupportWalletFragment paramSupportWalletFragment)
    {
      this.awk = paramSupportWalletFragment;
    }
    
    public void a(int paramInt1, int paramInt2, Bundle paramBundle)
    {
      if (this.awj != null) {
        this.awj.onStateChanged(this.awk, paramInt1, paramInt2, paramBundle);
      }
    }
    
    public void a(SupportWalletFragment.OnStateChangedListener paramOnStateChangedListener)
    {
      this.awj = paramOnStateChangedListener;
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
    extends a<SupportWalletFragment.b>
    implements View.OnClickListener
  {
    private c() {}
    
    protected void a(FrameLayout paramFrameLayout)
    {
      Button localButton = new Button(SupportWalletFragment.a(SupportWalletFragment.this).getActivity());
      localButton.setText(R.string.wallet_buy_button_place_holder);
      int i = -1;
      int j = -2;
      if (SupportWalletFragment.e(SupportWalletFragment.this) != null)
      {
        WalletFragmentStyle localWalletFragmentStyle = SupportWalletFragment.e(SupportWalletFragment.this).getFragmentStyle();
        if (localWalletFragmentStyle != null)
        {
          DisplayMetrics localDisplayMetrics = SupportWalletFragment.a(SupportWalletFragment.this).getResources().getDisplayMetrics();
          i = localWalletFragmentStyle.a("buyButtonWidth", localDisplayMetrics, i);
          j = localWalletFragmentStyle.a("buyButtonHeight", localDisplayMetrics, j);
        }
      }
      localButton.setLayoutParams(new ViewGroup.LayoutParams(i, j));
      localButton.setOnClickListener(this);
      paramFrameLayout.addView(localButton);
    }
    
    protected void a(f<SupportWalletFragment.b> paramf)
    {
      FragmentActivity localFragmentActivity = SupportWalletFragment.a(SupportWalletFragment.this).getActivity();
      if ((SupportWalletFragment.b(SupportWalletFragment.this) == null) && (SupportWalletFragment.c(SupportWalletFragment.this)) && (localFragmentActivity != null)) {}
      try
      {
        qa localqa = qi.a(localFragmentActivity, SupportWalletFragment.d(SupportWalletFragment.this), SupportWalletFragment.e(SupportWalletFragment.this), SupportWalletFragment.f(SupportWalletFragment.this));
        SupportWalletFragment.a(SupportWalletFragment.this, new SupportWalletFragment.b(localqa, null));
        SupportWalletFragment.a(SupportWalletFragment.this, null);
        paramf.a(SupportWalletFragment.b(SupportWalletFragment.this));
        if (SupportWalletFragment.g(SupportWalletFragment.this) != null)
        {
          SupportWalletFragment.b.a(SupportWalletFragment.b(SupportWalletFragment.this), SupportWalletFragment.g(SupportWalletFragment.this));
          SupportWalletFragment.a(SupportWalletFragment.this, null);
        }
        if (SupportWalletFragment.h(SupportWalletFragment.this) != null)
        {
          SupportWalletFragment.b.a(SupportWalletFragment.b(SupportWalletFragment.this), SupportWalletFragment.h(SupportWalletFragment.this));
          SupportWalletFragment.a(SupportWalletFragment.this, null);
        }
        if (SupportWalletFragment.i(SupportWalletFragment.this) != null)
        {
          SupportWalletFragment.b.a(SupportWalletFragment.b(SupportWalletFragment.this), SupportWalletFragment.i(SupportWalletFragment.this));
          SupportWalletFragment.a(SupportWalletFragment.this, null);
        }
        if (SupportWalletFragment.j(SupportWalletFragment.this) != null)
        {
          SupportWalletFragment.b.a(SupportWalletFragment.b(SupportWalletFragment.this), SupportWalletFragment.j(SupportWalletFragment.this).booleanValue());
          SupportWalletFragment.a(SupportWalletFragment.this, null);
        }
        return;
      }
      catch (GooglePlayServicesNotAvailableException localGooglePlayServicesNotAvailableException) {}
    }
    
    public void onClick(View paramView)
    {
      FragmentActivity localFragmentActivity = SupportWalletFragment.a(SupportWalletFragment.this).getActivity();
      GooglePlayServicesUtil.showErrorDialogFragment(GooglePlayServicesUtil.isGooglePlayServicesAvailable(localFragmentActivity), localFragmentActivity, -1);
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.wallet.fragment.SupportWalletFragment
 * JD-Core Version:    0.7.0.1
 */