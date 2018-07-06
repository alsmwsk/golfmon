package com.appg.golfmon.util;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class ListenerUtil
{
  public static View.OnClickListener getCheckButtonListener()
  {
    new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (paramAnonymousView.isSelected()) {}
        for (boolean bool = false;; bool = true)
        {
          paramAnonymousView.setSelected(bool);
          return;
        }
      }
    };
  }
  
  public static View.OnClickListener getFinishButtonListener(Activity paramActivity)
  {
    new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        ListenerUtil.this.finish();
      }
    };
  }
  
  public static View.OnClickListener getMoveButtonListener(final Activity paramActivity, final Class<?> paramClass, int paramInt, final boolean paramBoolean)
  {
    new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if (this.val$requestCode > 0) {
          paramActivity.startActivityForResult(new Intent(paramAnonymousView.getContext(), paramClass), this.val$requestCode);
        }
        do
        {
          return;
          paramActivity.startActivity(new Intent(paramAnonymousView.getContext(), paramClass));
        } while (!paramBoolean);
        paramActivity.finish();
      }
    };
  }
  
  public static View.OnClickListener getMoveButtonListener(Activity paramActivity, Class<?> paramClass, boolean paramBoolean)
  {
    return getMoveButtonListener(paramActivity, paramClass, -1, paramBoolean);
  }
  
  public static View.OnClickListener getRadioButtonListener(View... paramVarArgs)
  {
    new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        for (int i = 0;; i++)
        {
          if (i >= ListenerUtil.this.length) {
            return;
          }
          ListenerUtil.this[i].setSelected(ListenerUtil.this[i].equals(paramAnonymousView));
        }
      }
    };
  }
  
  public static View.OnClickListener getTypeMoveButtonListener(final Activity paramActivity, Class<?> paramClass, final int paramInt1, final int paramInt2, final boolean paramBoolean)
  {
    new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Intent localIntent = new Intent(paramAnonymousView.getContext(), ListenerUtil.this);
        localIntent.putExtra("EXTRAS_TYPE", paramInt1);
        if (paramInt2 > 0) {
          paramActivity.startActivityForResult(localIntent, paramInt2);
        }
        do
        {
          return;
          paramActivity.startActivity(localIntent);
        } while (!paramBoolean);
        paramActivity.finish();
      }
    };
  }
  
  public static View.OnClickListener getTypeMoveButtonListener(Activity paramActivity, Class<?> paramClass, int paramInt, boolean paramBoolean)
  {
    return getTypeMoveButtonListener(paramActivity, paramClass, paramInt, -1, paramBoolean);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.util.ListenerUtil
 * JD-Core Version:    0.7.0.1
 */