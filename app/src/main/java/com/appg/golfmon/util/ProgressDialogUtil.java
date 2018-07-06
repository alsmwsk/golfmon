package com.appg.golfmon.util;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

public class ProgressDialogUtil
{
  public static void dismiss(Dialog paramDialog)
  {
    if (paramDialog != null) {}
    try
    {
      if (paramDialog.isShowing()) {
        paramDialog.dismiss();
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public static Dialog show(Context paramContext, Dialog paramDialog)
  {
    return show(paramContext, paramDialog, null, null);
  }
  
  public static Dialog show(Context paramContext, Dialog paramDialog, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return show(paramContext, paramDialog, null, paramOnCancelListener);
  }
  
  public static Dialog show(Context paramContext, Dialog paramDialog, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    return show(paramContext, paramDialog, paramOnDismissListener, null);
  }
  
  public static Dialog show(Context paramContext, Dialog paramDialog, DialogInterface.OnDismissListener paramOnDismissListener, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (paramDialog != null) {}
    try
    {
      if (paramDialog.isShowing()) {
        return paramDialog;
      }
      paramDialog.show();
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          LinearLayout localLinearLayout = new LinearLayout(paramContext);
          ProgressBar localProgressBar = new ProgressBar(paramContext);
          localLinearLayout.setOrientation(1);
          localLinearLayout.setGravity(17);
          localLinearLayout.setBackgroundColor(0);
          localLinearLayout.addView(localProgressBar, new ViewGroup.LayoutParams(-2, -2));
          localDialog.addContentView(localLinearLayout, new ViewGroup.LayoutParams(-1, -1));
          localDialog.setCancelable(true);
          if (paramOnCancelListener != null) {
            localDialog.setOnCancelListener(paramOnCancelListener);
          }
          if (paramOnDismissListener != null) {
            localDialog.setOnDismissListener(paramOnDismissListener);
          }
          localDialog.show();
          paramDialog = localDialog;
          return paramDialog;
        }
        catch (Exception localException2)
        {
          Dialog localDialog;
          paramDialog = localDialog;
          continue;
        }
        localException1 = localException1;
        localException1.printStackTrace();
      }
    }
    localDialog = new Dialog(paramContext, 16973840);
    return paramDialog;
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.util.ProgressDialogUtil
 * JD-Core Version:    0.7.0.1
 */