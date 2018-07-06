package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.provider.CalendarContract.Events;
import android.text.TextUtils;
import com.google.android.gms.R.string;
import java.util.Map;
import org.json.JSONObject;

@ey
public class dh
{
  private final Context mContext;
  private final gu mo;
  private final Map<String, String> rd;
  private String re;
  private long rf;
  private long rg;
  private String rh;
  private String ri;
  
  public dh(gu paramgu, Map<String, String> paramMap)
  {
    this.mo = paramgu;
    this.rd = paramMap;
    this.mContext = paramgu.dI();
    bQ();
  }
  
  private String A(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)this.rd.get(paramString))) {
      return "";
    }
    return (String)this.rd.get(paramString);
  }
  
  private void bQ()
  {
    this.re = A("description");
    this.rh = A("summary");
    this.rf = gi.O((String)this.rd.get("start"));
    this.rg = gi.O((String)this.rd.get("end"));
    this.ri = A("location");
  }
  
  Intent createIntent()
  {
    Intent localIntent = new Intent("android.intent.action.EDIT").setData(CalendarContract.Events.CONTENT_URI);
    localIntent.putExtra("title", this.rh);
    localIntent.putExtra("eventLocation", this.ri);
    localIntent.putExtra("description", this.re);
    localIntent.putExtra("beginTime", this.rf);
    localIntent.putExtra("endTime", this.rg);
    localIntent.setFlags(268435456);
    return localIntent;
  }
  
  public void execute()
  {
    if (!new bl(this.mContext).bt())
    {
      gr.W("This feature is not available on this version of the device.");
      return;
    }
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this.mContext);
    localBuilder.setTitle(ga.c(R.string.create_calendar_title, "Create calendar event"));
    localBuilder.setMessage(ga.c(R.string.create_calendar_message, "Allow Ad to create a calendar event?"));
    localBuilder.setPositiveButton(ga.c(R.string.accept, "Accept"), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        Intent localIntent = dh.this.createIntent();
        dh.a(dh.this).startActivity(localIntent);
      }
    });
    localBuilder.setNegativeButton(ga.c(R.string.decline, "Decline"), new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        dh.b(dh.this).b("onCalendarEventCanceled", new JSONObject());
      }
    });
    localBuilder.create().show();
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.dh
 * JD-Core Version:    0.7.0.1
 */