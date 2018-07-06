package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.DownloadManager;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.R.string;
import java.util.Map;
import org.json.JSONObject;

@ey
public class dj
{
  private final Context mContext;
  private final gu mo;
  private final Map<String, String> rd;
  
  public dj(gu paramgu, Map<String, String> paramMap)
  {
    this.mo = paramgu;
    this.rd = paramMap;
    this.mContext = paramgu.dI();
  }
  
  String B(String paramString)
  {
    return Uri.parse(paramString).getLastPathSegment();
  }
  
  DownloadManager.Request b(String paramString1, String paramString2)
  {
    DownloadManager.Request localRequest = new DownloadManager.Request(Uri.parse(paramString1));
    localRequest.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, paramString2);
    if (ll.ig())
    {
      localRequest.allowScanningByMediaScanner();
      localRequest.setNotificationVisibility(1);
      return localRequest;
    }
    localRequest.setShowRunningNotification(true);
    return localRequest;
  }
  
  public void execute()
  {
    if (!new bl(this.mContext).bq())
    {
      gr.W("Store picture feature is not supported on this device.");
      return;
    }
    if (TextUtils.isEmpty((CharSequence)this.rd.get("iurl")))
    {
      gr.W("Image url cannot be empty.");
      return;
    }
    final String str1 = (String)this.rd.get("iurl");
    if (!URLUtil.isValidUrl(str1))
    {
      gr.W("Invalid image url:" + str1);
      return;
    }
    final String str2 = B(str1);
    if (!gi.N(str2))
    {
      gr.W("Image type not recognized:");
      return;
    }
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mContext);
    localBuilder.setTitle(ga.c(R.string.store_picture_title, "Save image"));
    localBuilder.setMessage(ga.c(R.string.store_picture_message, "Allow Ad to store image in Picture gallery?"));
    localBuilder.setPositiveButton(ga.c(R.string.accept, "Accept"), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        DownloadManager localDownloadManager = (DownloadManager)dj.a(dj.this).getSystemService("download");
        try
        {
          localDownloadManager.enqueue(dj.this.b(str1, str2));
          return;
        }
        catch (IllegalStateException localIllegalStateException)
        {
          gr.U("Could not store picture.");
        }
      }
    });
    localBuilder.setNegativeButton(ga.c(R.string.decline, "Decline"), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        dj.b(dj.this).b("onStorePictureCanceled", new JSONObject());
      }
    });
    localBuilder.create().show();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dj
 * JD-Core Version:    0.7.0.1
 */