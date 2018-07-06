package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@ey
public final class gl
{
  private final Context mContext;
  private int mState = 0;
  private final float rz;
  private String wH;
  private float wI;
  private float wJ;
  private float wK;
  
  public gl(Context paramContext)
  {
    this.mContext = paramContext;
    this.rz = paramContext.getResources().getDisplayMetrics().density;
  }
  
  public gl(Context paramContext, String paramString)
  {
    this(paramContext);
    this.wH = paramString;
  }
  
  private void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    if (paramInt == 0)
    {
      this.mState = 0;
      this.wI = paramFloat1;
      this.wJ = paramFloat2;
      this.wK = paramFloat2;
    }
    label24:
    label224:
    do
    {
      do
      {
        break label24;
        do
        {
          return;
        } while (this.mState == -1);
        if (paramInt != 2) {
          break;
        }
        if (paramFloat2 > this.wJ) {
          this.wJ = paramFloat2;
        }
        while (this.wJ - this.wK > 30.0F * this.rz)
        {
          this.mState = -1;
          return;
          if (paramFloat2 < this.wK) {
            this.wK = paramFloat2;
          }
        }
        if ((this.mState == 0) || (this.mState == 2)) {
          if (paramFloat1 - this.wI >= 50.0F * this.rz) {
            this.wI = paramFloat1;
          }
        }
        for (this.mState = (1 + this.mState);; this.mState = (1 + this.mState))
        {
          do
          {
            if ((this.mState != 1) && (this.mState != 3)) {
              break label224;
            }
            if (paramFloat1 <= this.wI) {
              break;
            }
            this.wI = paramFloat1;
            return;
          } while (((this.mState != 1) && (this.mState != 3)) || (paramFloat1 - this.wI > -50.0F * this.rz));
          this.wI = paramFloat1;
        }
      } while ((this.mState != 2) || (paramFloat1 >= this.wI));
      this.wI = paramFloat1;
      return;
    } while ((paramInt != 1) || (this.mState != 4));
    showDialog();
  }
  
  private void showDialog()
  {
    final String str1;
    if (!TextUtils.isEmpty(this.wH))
    {
      Uri localUri = new Uri.Builder().encodedQuery(this.wH).build();
      StringBuilder localStringBuilder = new StringBuilder();
      Map localMap = gi.c(localUri);
      Iterator localIterator = localMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        localStringBuilder.append(str2).append(" = ").append((String)localMap.get(str2)).append("\n\n");
      }
      str1 = localStringBuilder.toString().trim();
      if (TextUtils.isEmpty(str1)) {}
    }
    for (;;)
    {
      AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mContext);
      localBuilder.setMessage(str1);
      localBuilder.setTitle("Ad Information");
      localBuilder.setPositiveButton("Share", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          gl.a(gl.this).startActivity(Intent.createChooser(new Intent("android.intent.action.SEND").setType("text/plain").putExtra("android.intent.extra.TEXT", str1), "Share via"));
        }
      });
      localBuilder.setNegativeButton("Close", new DialogInterface.OnClickListener()
      {
        public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
      localBuilder.create().show();
      return;
      str1 = "No debug information";
      continue;
      str1 = "No debug information";
    }
  }
  
  public void Q(String paramString)
  {
    this.wH = paramString;
  }
  
  public void c(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getHistorySize();
    for (int j = 0; j < i; j++) {
      a(paramMotionEvent.getActionMasked(), paramMotionEvent.getHistoricalX(0, j), paramMotionEvent.getHistoricalY(0, j));
    }
    a(paramMotionEvent.getActionMasked(), paramMotionEvent.getX(), paramMotionEvent.getY());
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.gl
 * JD-Core Version:    0.7.0.1
 */