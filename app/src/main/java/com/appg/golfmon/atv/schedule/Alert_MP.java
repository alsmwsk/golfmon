package com.appg.golfmon.atv.schedule;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TableRow;
import android.widget.TextView;
import com.appg.golfmon.net.http.GFailedHandler;
import com.appg.golfmon.net.http.GJSONDecoder;
import com.appg.golfmon.net.http.GPClient;
import com.appg.golfmon.net.http.GResultHandler;
import com.appg.golfmon.util.Alert;
import com.appg.golfmon.util.FormatUtil;
import com.appg.golfmon.util.JSONUtil;
import org.json.JSONObject;
import ra.genius.net.GBean;
import ra.genius.net.GExecutor;

public class Alert_MP
{
  public static final int BTN_CANCLE = -1;
  public static final int BTN_OK = 1;
  Context context;
  Dialog dialog;
  protected OnCloseListener mListener = null;
  JSONObject mMPointInfo;
  private RatingBar mRatingBar = null;
  JSONObject mUserInfo;
  
  private void callApi_insOfMPoint()
  {
    GPClient localGPClient = new GPClient(this.context);
    localGPClient.setUri("http://115.68.14.78/action_front.php");
    localGPClient.addCmd("ApiTransferJoin.insOfMPoint");
    localGPClient.addParameter("to_user_fk", JSONUtil.getString(this.mUserInfo, "no", ""));
    localGPClient.addParameter("grade", Float.valueOf(this.mRatingBar.getRating()));
    localGPClient.setDecoder(new GJSONDecoder(3));
    localGPClient.addProgress();
    localGPClient.addHandler(new GFailedHandler()
    {
      public void failedExecute(GBean paramAnonymousGBean)
      {
        Alert.toastLong(Alert_MP.this.context, (String)paramAnonymousGBean.get("errorMessage"));
      }
    });
    localGPClient.addHandler(new GResultHandler()
    {
      public GBean result(GBean paramAnonymousGBean, Object paramAnonymousObject, int paramAnonymousInt, String paramAnonymousString, JSONObject paramAnonymousJSONObject)
      {
        if (paramAnonymousInt > 0)
        {
          Alert_MP.this.dialog.dismiss();
          if (Alert_MP.this.mListener != null) {
            Alert_MP.this.mListener.onClose(Alert_MP.this.dialog, 1, null);
          }
        }
        new Alert().showAlert(Alert_MP.this.context, paramAnonymousString);
        return null;
      }
    });
    GExecutor.getInstance().execute(localGPClient);
  }
  
  private int setDataScore(View paramView, int paramInt1, int paramInt2)
  {
    SeekBar localSeekBar = (SeekBar)paramView.findViewById(2131361832);
    TextView localTextView = (TextView)paramView.findViewById(2131361833);
    localSeekBar.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        return true;
      }
    });
    localSeekBar.setMax(100);
    int i = 0;
    if (paramInt2 == 0) {
      localSeekBar.setProgress(0);
    }
    for (;;)
    {
      localTextView.setText(FormatUtil.toPriceFormat(paramInt1));
      return i;
      i = (int)(100.0F * (paramInt1 / paramInt2));
      localSeekBar.setProgress(i);
    }
  }
  
  private void setDataScore()
  {
    TextView localTextView1 = (TextView)this.dialog.findViewById(2131361829);
    TextView localTextView2 = (TextView)this.dialog.findViewById(2131361830);
    TableRow[] arrayOfTableRow = new TableRow[5];
    arrayOfTableRow[4] = ((TableRow)this.dialog.findViewById(2131361831));
    arrayOfTableRow[3] = ((TableRow)this.dialog.findViewById(2131361834));
    arrayOfTableRow[2] = ((TableRow)this.dialog.findViewById(2131361835));
    arrayOfTableRow[1] = ((TableRow)this.dialog.findViewById(2131361836));
    arrayOfTableRow[0] = ((TableRow)this.dialog.findViewById(2131361837));
    int i = JSONUtil.getInteger(this.mMPointInfo, "mp_cnt", 0);
    int j = 0;
    ((RatingBar)this.dialog.findViewById(2131361827)).setRating(JSONUtil.getInteger(this.mMPointInfo, "grade", 0));
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Double.valueOf(JSONUtil.getDouble(this.mMPointInfo, "grade", 0.0D));
    localTextView1.setText(String.format("%.1f", arrayOfObject));
    localTextView2.setText(FormatUtil.toPriceFormat(i) + "명");
    int k = 0;
    if (k >= arrayOfTableRow.length) {
      if (j <= 0) {}
    }
    for (int n = 0;; n++)
    {
      if (n >= arrayOfTableRow.length)
      {
        return;
        int m = setDataScore(arrayOfTableRow[k], JSONUtil.getInteger(this.mMPointInfo, "counts" + (k + 1), 0), i);
        if (j < m) {
          j = m;
        }
        k++;
        break;
      }
      ((SeekBar)arrayOfTableRow[n].findViewById(2131361832)).setMax(j);
    }
  }
  
  public void setOnCloseListener(OnCloseListener paramOnCloseListener)
  {
    this.mListener = paramOnCloseListener;
  }
  
  public Dialog showAlert(Context paramContext, JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    this.context = paramContext;
    this.mUserInfo = paramJSONObject1;
    this.mMPointInfo = paramJSONObject2;
    this.dialog = new Dialog(this.context, 16973840);
    this.dialog.setCancelable(true);
    this.dialog.setContentView(2130903043);
    ((TextView)this.dialog.findViewById(2131361826)).setText(JSONUtil.getString(this.mUserInfo, "nick_name", ""));
    Button localButton1 = (Button)this.dialog.findViewById(2131361828);
    localButton1.setText(FormatUtil.toPhoneNumber(JSONUtil.getString(this.mUserInfo, "phone", "")));
    localButton1.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        try
        {
          Intent localIntent = new Intent("android.intent.action.VIEW", Uri.parse("tel:" + JSONUtil.getString(Alert_MP.this.mUserInfo, "phone", "").replaceAll("\\D", "")));
          Alert_MP.this.context.startActivity(localIntent);
          return;
        }
        catch (Exception localException) {}
      }
    });
    this.mRatingBar = ((RatingBar)this.dialog.findViewById(2131361838));
    setDataScore();
    Button localButton2 = (Button)this.dialog.findViewById(2131361839);
    int i = JSONUtil.getInteger(this.mMPointInfo, "mygrade", 0);
    if (i != 0)
    {
      localButton2.setText("수정");
      this.mRatingBar.setRating(i);
    }
    localButton2.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Alert_MP.this.callApi_insOfMPoint();
      }
    });
    Button localButton3 = (Button)this.dialog.findViewById(2131361840);
    localButton3.setVisibility(0);
    localButton3.setText("닫기");
    localButton3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        Alert_MP.this.dialog.dismiss();
        if (Alert_MP.this.mListener != null) {
          Alert_MP.this.mListener.onClose(Alert_MP.this.dialog, -1, null);
        }
      }
    });
    this.dialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        paramAnonymousDialogInterface.dismiss();
      }
    });
    this.dialog.show();
    return this.dialog;
  }
  
  public static abstract interface OnCloseListener
  {
    public abstract void onClose(DialogInterface paramDialogInterface, int paramInt, Object paramObject);
  }
}


/* Location:           C:\Users\TGKIM\Downloads\작업폴더\리버싱\androidReversetools\jd-gui-0.3.6.windows\com.appg.golfmon-1-dex2jar.jar
 * Qualified Name:     com.appg.golfmon.atv.schedule.Alert_MP
 * JD-Core Version:    0.7.0.1
 */