package com.nhn.android.naverlogin.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;

public class OAuthLoginDialogMng
{
  public Object mAlertDialogSync = new Object();
  private ProgressDialog mNLoginGlobalDefaultProgressDialog = null;
  public Object mProgressDialogSync = new Object();
  
  /* Error */
  public boolean hideProgressDlg()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 15	com/nhn/android/naverlogin/ui/OAuthLoginDialogMng:mProgressDialogSync	Ljava/lang/Object;
    //   8: astore_3
    //   9: aload_3
    //   10: monitorenter
    //   11: aload_0
    //   12: getfield 19	com/nhn/android/naverlogin/ui/OAuthLoginDialogMng:mNLoginGlobalDefaultProgressDialog	Landroid/app/ProgressDialog;
    //   15: ifnonnull +9 -> 24
    //   18: aload_3
    //   19: monitorexit
    //   20: aload_0
    //   21: monitorexit
    //   22: iload_1
    //   23: ireturn
    //   24: aload_0
    //   25: getfield 19	com/nhn/android/naverlogin/ui/OAuthLoginDialogMng:mNLoginGlobalDefaultProgressDialog	Landroid/app/ProgressDialog;
    //   28: invokevirtual 30	android/app/ProgressDialog:hide	()V
    //   31: aload_0
    //   32: getfield 19	com/nhn/android/naverlogin/ui/OAuthLoginDialogMng:mNLoginGlobalDefaultProgressDialog	Landroid/app/ProgressDialog;
    //   35: invokevirtual 33	android/app/ProgressDialog:dismiss	()V
    //   38: aload_0
    //   39: aconst_null
    //   40: putfield 19	com/nhn/android/naverlogin/ui/OAuthLoginDialogMng:mNLoginGlobalDefaultProgressDialog	Landroid/app/ProgressDialog;
    //   43: aload_3
    //   44: monitorexit
    //   45: iconst_1
    //   46: istore_1
    //   47: goto -27 -> 20
    //   50: astore 5
    //   52: aload 5
    //   54: invokevirtual 36	java/lang/Exception:printStackTrace	()V
    //   57: aload_3
    //   58: monitorexit
    //   59: iconst_0
    //   60: istore_1
    //   61: goto -41 -> 20
    //   64: astore 4
    //   66: aload_3
    //   67: monitorexit
    //   68: aload 4
    //   70: athrow
    //   71: astore_2
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	OAuthLoginDialogMng
    //   1	60	1	bool	boolean
    //   71	4	2	localObject1	Object
    //   64	5	4	localObject3	Object
    //   50	3	5	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   24	43	50	java/lang/Exception
    //   11	20	64	finally
    //   24	43	64	finally
    //   43	45	64	finally
    //   52	59	64	finally
    //   66	68	64	finally
    //   4	11	71	finally
    //   68	71	71	finally
  }
  
  public boolean showProgressDlg(Context paramContext, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    synchronized (this.mProgressDialogSync)
    {
      try
      {
        if (this.mNLoginGlobalDefaultProgressDialog != null)
        {
          this.mNLoginGlobalDefaultProgressDialog.hide();
          this.mNLoginGlobalDefaultProgressDialog.dismiss();
        }
        this.mNLoginGlobalDefaultProgressDialog = new ProgressDialog(paramContext);
        this.mNLoginGlobalDefaultProgressDialog.setIndeterminate(true);
        this.mNLoginGlobalDefaultProgressDialog.setMessage(paramString);
        this.mNLoginGlobalDefaultProgressDialog.setProgressStyle(0);
        if (paramOnCancelListener != null) {
          this.mNLoginGlobalDefaultProgressDialog.setOnCancelListener(paramOnCancelListener);
        }
        this.mNLoginGlobalDefaultProgressDialog.setCanceledOnTouchOutside(false);
        this.mNLoginGlobalDefaultProgressDialog.setOnDismissListener(new DialogInterface.OnDismissListener()
        {
          public void onDismiss(DialogInterface paramAnonymousDialogInterface)
          {
            OAuthLoginDialogMng.this.mNLoginGlobalDefaultProgressDialog = null;
          }
        });
        this.mNLoginGlobalDefaultProgressDialog.show();
        return true;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return false;
      }
    }
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.nhn.android.naverlogin.ui.OAuthLoginDialogMng
 * JD-Core Version:    0.7.0.1
 */