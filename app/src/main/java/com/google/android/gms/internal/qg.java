package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.wallet.FullWalletRequest;
import com.google.android.gms.wallet.MaskedWalletRequest;
import com.google.android.gms.wallet.NotifyTransactionStatusRequest;
import com.google.android.gms.wallet.Payments;
import com.google.android.gms.wallet.Wallet.b;

public class qg
  implements Payments
{
  public void changeMaskedWallet(GoogleApiClient paramGoogleApiClient, final String paramString1, final String paramString2, final int paramInt)
  {
    paramGoogleApiClient.a(new Wallet.b(paramGoogleApiClient)
    {
      protected void a(qh paramAnonymousqh)
      {
        paramAnonymousqh.d(paramString1, paramString2, paramInt);
        b(Status.Kw);
      }
    });
  }
  
  public void checkForPreAuthorization(GoogleApiClient paramGoogleApiClient, final int paramInt)
  {
    paramGoogleApiClient.a(new Wallet.b(paramGoogleApiClient)
    {
      protected void a(qh paramAnonymousqh)
      {
        paramAnonymousqh.gk(paramInt);
        b(Status.Kw);
      }
    });
  }
  
  public void loadFullWallet(GoogleApiClient paramGoogleApiClient, final FullWalletRequest paramFullWalletRequest, final int paramInt)
  {
    paramGoogleApiClient.a(new Wallet.b(paramGoogleApiClient)
    {
      protected void a(qh paramAnonymousqh)
      {
        paramAnonymousqh.a(paramFullWalletRequest, paramInt);
        b(Status.Kw);
      }
    });
  }
  
  public void loadMaskedWallet(GoogleApiClient paramGoogleApiClient, final MaskedWalletRequest paramMaskedWalletRequest, final int paramInt)
  {
    paramGoogleApiClient.a(new Wallet.b(paramGoogleApiClient)
    {
      protected void a(qh paramAnonymousqh)
      {
        paramAnonymousqh.a(paramMaskedWalletRequest, paramInt);
        b(Status.Kw);
      }
    });
  }
  
  public void notifyTransactionStatus(GoogleApiClient paramGoogleApiClient, final NotifyTransactionStatusRequest paramNotifyTransactionStatusRequest)
  {
    paramGoogleApiClient.a(new Wallet.b(paramGoogleApiClient)
    {
      protected void a(qh paramAnonymousqh)
      {
        paramAnonymousqh.a(paramNotifyTransactionStatusRequest);
        b(Status.Kw);
      }
    });
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.qg
 * JD-Core Version:    0.7.0.1
 */