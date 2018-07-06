package com.nhn.android.naverlogin.connection;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;
import com.nhn.android.naverlogin.data.OAuthLoginString;

public class NetworkState
{
  static boolean shown = false;
  
  public static boolean checkConnectivity(Context paramContext, boolean paramBoolean, RetryListener paramRetryListener)
  {
    if (isDataConnected(paramContext)) {
      return true;
    }
    if (paramBoolean)
    {
      if (paramRetryListener == null)
      {
        Toast.makeText(paramContext, OAuthLoginString.naveroauthlogin_string_network_state_not_available.getString(paramContext), 1).show();
        return false;
      }
      showRetry(paramContext, paramRetryListener);
    }
    return false;
  }
  
  public static String getNetworkState(Context paramContext)
  {
    String str = "other";
    if (is3GConnected(paramContext)) {
      str = "cell";
    }
    while (!isWifiConnected(paramContext)) {
      return str;
    }
    return "wifi";
  }
  
  public static boolean is3GConnected(Context paramContext)
  {
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      boolean bool1 = false;
      if (localConnectivityManager != null)
      {
        NetworkInfo localNetworkInfo = localConnectivityManager.getNetworkInfo(0);
        bool1 = false;
        if (localNetworkInfo != null)
        {
          boolean bool2 = localNetworkInfo.isConnected();
          bool1 = false;
          if (bool2) {
            bool1 = true;
          }
        }
      }
      return bool1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public static boolean isDataConnected(Context paramContext)
  {
    boolean bool1 = true;
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager.getActiveNetworkInfo() != null)
      {
        boolean bool2 = localConnectivityManager.getActiveNetworkInfo().isConnected();
        bool1 = bool2;
      }
      return bool1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return bool1;
  }
  
  public static boolean isWifiConnected(Context paramContext)
  {
    try
    {
      ConnectivityManager localConnectivityManager = (ConnectivityManager)paramContext.getSystemService("connectivity");
      if (localConnectivityManager != null)
      {
        boolean bool = localConnectivityManager.getNetworkInfo(1).isConnected();
        if (bool) {
          return true;
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public static void showRetry(Context paramContext, final RetryListener paramRetryListener)
  {
    if ((shown) || (paramContext == null)) {}
    while (((paramContext instanceof Activity)) && (((Activity)paramContext).isFinishing())) {
      return;
    }
    shown = true;
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramContext);
    localBuilder.setIcon(17301543);
    localBuilder.setMessage(OAuthLoginString.naveroauthlogin_string_network_state_not_available.getString(paramContext));
    localBuilder.setPositiveButton(OAuthLoginString.naveroauthlogin_string_msg_retry.getString(paramContext), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        NetworkState.shown = false;
        if (((NetworkState.this instanceof Activity)) && (((Activity)NetworkState.this).isFinishing())) {
          return;
        }
        paramRetryListener.onResult(true);
      }
    });
    localBuilder.setNegativeButton(OAuthLoginString.naveroauthlogin_string_msg_cancel.getString(paramContext), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        NetworkState.shown = false;
        if (((NetworkState.this instanceof Activity)) && (((Activity)NetworkState.this).isFinishing())) {
          return;
        }
        paramRetryListener.onResult(false);
      }
    });
    localBuilder.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        NetworkState.shown = false;
        if (((NetworkState.this instanceof Activity)) && (((Activity)NetworkState.this).isFinishing())) {
          return;
        }
        paramRetryListener.onResult(false);
      }
    });
    try
    {
      localBuilder.show();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static abstract interface RetryListener
  {
    public abstract void onResult(boolean paramBoolean);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nhn.android.naverlogin.connection.NetworkState
 * JD-Core Version:    0.7.0.1
 */